package org.zerock.controller.project1;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.project1.BoardVO;
import org.zerock.domain.project1.PageInfoVO;
import org.zerock.service.project1.BoardService;

import lombok.Setter;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	@GetMapping("/list")
	public void list(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model) {
		System.out.println(page);
		
		Integer numberPerPage = 10; // 한 페이지의 row 수
		
		// 3. business logic
		// 게시물(Board) 목록 조회
//		List<BoardVO> list = service.getList();
		List<BoardVO> list = service.getListPage(page, numberPerPage);
		PageInfoVO pageInfo = service.getPageInfo(page, numberPerPage);
		
		// 4. add attribute
		model.addAttribute("list", list);
		model.addAttribute("pageInfo", pageInfo);

		// 5. forward/redirect
		// jsp path : /WEB-INF/views/board/list.jsp
	}

	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("id") Integer id, Model model) {
		BoardVO board = service.get(id);
		
		String[] fileNames = service.getFileNamesByBoardId(id);
		
		model.addAttribute("board", board);
		model.addAttribute("fileNames", fileNames);
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, String[] removeFile, MultipartFile[] files, RedirectAttributes rttr) {
		
		System.out.println(Arrays.toString(removeFile));
		
		try {
			if (service.modify(board, removeFile, files)) {
				rttr.addFlashAttribute("result", board.getId() + "번 게시글이 수정 되었습니다.");
			}
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			
			rttr.addFlashAttribute("result", board.getId() + "번 게시물 수정 중 오류가 발생하였습니다.");

		}

		// 게시물 조회로 redirect
		/*
		rttr.addAttribute("id", board.getId());
		return "redirect:/board/get";
		*/
		
		// 목록 조회로 redirect
		return "redirect:/board/list";
	}

	@GetMapping("/register")
	public void register() {

	}

	@PostMapping("/register")
	public String register(BoardVO board, MultipartFile[] files, RedirectAttributes rttr) {

		// 3. business logic
		try {
			service.register(board, files);

			// 4. add attribute
			rttr.addFlashAttribute("result", board.getId() + "번 게시글이 등록 되었습니다.");
			
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			rttr.addFlashAttribute("result", "게시물 등록 중 오류가 발생하였습니다.");
		}


		// 5. forward / redirect
		// 책: 목록으로 redirect
		return "redirect:/board/list";
	}

	
	@PostMapping("/remove")
	public String remove(@RequestParam("id") Integer id, RedirectAttributes rttr) {
		
		if (service.remove(id)) {
			rttr.addFlashAttribute("result", id + "번 게시글이 삭제 되었습니다.");
		}
		
		return "redirect:/board/list";
	}
}

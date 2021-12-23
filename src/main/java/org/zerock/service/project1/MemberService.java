package org.zerock.service.project1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.project1.MemberVO;
import org.zerock.domain.project1.PageInfoVO;
import org.zerock.mapper.project1.BoardMapper;
import org.zerock.mapper.project1.MemberMapper;
import org.zerock.mapper.project1.ReplyMapper;

import lombok.Setter;

@Service
public class MemberService {

	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper replyMapper;
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardMapper;
	
	@Setter(onMethod_ = @Autowired)
	private BoardService boardService;
	
	public MemberVO read(String id) {
		return mapper.select(id);
	}
	
	public boolean register(MemberVO member) {
		
		try {
			return mapper.insert(member) == 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean modify(MemberVO member) {
		return mapper.update(member) == 1;
	}
	
	@Transactional
	public boolean remove(String id) {
		
		// 1. 멤버가 작성한 댓글 지우기
		replyMapper.deleteByMemberId(id);
		
		// 2. 멤버가 작성한 게시물 지우기
		// 2.1 멤버가 작성한 게시물 목록 얻고
		Integer[] boardIds = boardMapper.selectByMemberId(id);
		
		// 2.2 게시물 삭제
		if (boardIds != null) {
			for (Integer boardId : boardIds) {
				boardService.remove(boardId);
			}
		}
		boardMapper.deleteByMemberId(id);
		
		// 3. 멤버 지우기
		return mapper.delete(id) == 1;
	}
	
	public List<MemberVO> getList() {
		return mapper.list();
	}

	public List<MemberVO> getList(Integer page, Integer numberPerPage) {
		
		Integer from = (page - 1) * 10;
		
		return mapper.listPage(from, numberPerPage);
	}
	
	public PageInfoVO getPageInfo(Integer page, Integer numberPerPage) {
		
		Integer countRows = mapper.getCountRows(); // 총 레코드 수
		Integer lastPage = (countRows - 1) / numberPerPage + 1; // 마지막 페이지 번호
		
		Integer leftPageNumber = page - 5; // 가장 왼쪽 페이지 번호
		leftPageNumber = Math.max(1, leftPageNumber);
		
		Integer rightPageNumber = leftPageNumber + 9; // 가장 오른쪽 페이지 번호
		rightPageNumber = Math.min(rightPageNumber, lastPage);

		Boolean hasPrevButton = page != 1; // 이전 버튼 활성화 유무
		Boolean hasNextButton = page != lastPage; // 다음 버튼 활성화 유무
		
		PageInfoVO pageInfo = new PageInfoVO();
		
		pageInfo.setLastPage(lastPage);
		pageInfo.setCountRows(countRows);
		pageInfo.setCurrentPage(page);
		pageInfo.setLeftPageNumber(leftPageNumber);
		pageInfo.setRightPageNumber(rightPageNumber);
		pageInfo.setHasPrevButton(hasPrevButton);
		pageInfo.setHasNextButton(hasNextButton);
		
		return pageInfo;
	}
	
	public boolean hasId(String id) {

		MemberVO member =  mapper.select(id);
		
		return member != null;
	}

	public boolean hasNickName(String nickName) {

		MemberVO member = mapper.selectByNickName(nickName);
		
		return member != null;
	}
}
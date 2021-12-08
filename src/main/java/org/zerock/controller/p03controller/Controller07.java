package org.zerock.controller.p03controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.controller.p03controller.bean.Bean02;

@Controller
@RequestMapping("/cont07")
public class Controller07 {

	@RequestMapping("/met01")
	public String method01(RedirectAttributes rttr) {
		System.out.println("cont07 met01 일함!");

		rttr.addAttribute("name", "donald");
		rttr.addAttribute("address", "ny");

//		return "redirect:/cont07/met02?name=john";
		return "redirect:/cont07/met02";
	}

	@RequestMapping("/met02")
	public void method02() {
		System.out.println("cont07 met02 일함@@");
	}

	// 첫번째 요청 주소 : /cont07/met03
	// 위의 요청의 응답 : redirect:/cont07/met04
	// 응답시 쿼리 스트링 ?id=99&city=seoul&country=korea

	// 메소드 method03 작성

	@RequestMapping("/met03")
	public String method03(RedirectAttributes rttr) {
		System.out.println("cont07 met03 일함!!");

		rttr.addAttribute("id", 99);
		rttr.addAttribute("city", "seoul");
		rttr.addAttribute("country", "korea");

		return "redirect:/cont07/met04";
	}

	@RequestMapping("/met05")
	public String method05(HttpSession session) {
		session.setAttribute("name", "trump");

		return "redirect:/cont07/met06";
	}

	@RequestMapping("/met06")
	public void method06(HttpSession session) {

		System.out.println("cont07 met06 일함!");
		System.out.println(session.getAttribute("name"));
	}
	
	@RequestMapping("/met07")
	public String method07(RedirectAttributes rttr) {
		rttr.addFlashAttribute("address", "usa");
		
		return "redirect:/cont07/met08";
	}
	
	@RequestMapping("/met08")
	public void method08(Model model) {
		
		System.out.println(model.asMap().get("address"));
	}
	
	@RequestMapping("/met09")
	public String method09(RedirectAttributes rttr, Bean02 bean) {
		
		bean.setAddress("seoul");
		bean.setCity("korea");
		
		rttr.addFlashAttribute("bean", bean);
		
		return "redirect:/cont07/met10";
	}
	
	@RequestMapping("met10")
	public void method10() {
		
	}
}
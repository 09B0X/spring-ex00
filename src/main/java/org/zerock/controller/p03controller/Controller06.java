package org.zerock.controller.p03controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.controller.p03controller.bean.Bean01;
import org.zerock.controller.p03controller.bean.Bean02;

@Controller
@RequestMapping("/cont06")
public class Controller06 {

	@RequestMapping("/met01")
	public void method01(HttpServletRequest request) {
		request.setAttribute("myatt12", "hello world");
	}

	@RequestMapping("/met02")
	public void method02(Model model) {
		// 4. add attribute
		model.addAttribute("myattr1", "myvalue1");
		
		// 5
	}
	
	@RequestMapping("/met03")
	public void method03(Model model) {
		model.addAttribute("myattr2", "myvalue2");
	}
	
	@RequestMapping("/met04")
	public void method04(Model model) {
		Bean01 bean = new Bean01();
		bean.setAge(99);
		bean.setName("trump");
		
		// 4. 
		model.addAttribute("myBean", bean);
	}
	
	@RequestMapping("/met05")
	public void method05(Model model) {
		// 3.
		Bean01 bean = new Bean01();
		bean.setAge(88);
		bean.setName("donald");
		
		// 4.
		//model.addAttribute("bean01", bean); // attribute의 이름이 클래스(type)의 이름과 같은 경우 생략 가능
		model.addAttribute(bean);
		
		// 할일 : view (jsp) 를 만들어서 "bean01" attribute가 있는 지 확인) 
	} 
	
	@RequestMapping("/met06")
	public void method06(Model model) {
		
		model.addAttribute("attr1", "val1");
		model.addAttribute("attr2", "val2");
	}

	@RequestMapping("/met07")
	public void method07(String name, String city, Model model) {
		
		model.addAttribute("name", name);
		model.addAttribute("city", city);
		
	}

	@RequestMapping("/met08")
	public String method08(@ModelAttribute("name") String name, 
			@ModelAttribute("city") String city) {
		
		return "/cont06/met07";
	}

	@RequestMapping("/met09")
	public void method09(Bean01 bean, Model model) {
		
		model.addAttribute("bean", bean);
		
	}

	@RequestMapping("/met10")
	public String method10(@ModelAttribute("bean") Bean01 bean) {
		
		return "/cont06/met09";
	}

	@RequestMapping("/met11")
	public void method11(@ModelAttribute Bean01 bean) {
		
		
	}
	
	@RequestMapping("/met12")
	public String method12(Bean01 bean) {
		
		return "/cont06/met11";
	}
	
	@RequestMapping("/met13")
	public void method13(Bean02 bean) {
		
	}
}















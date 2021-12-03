package org.zerock.controller.p01Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cont03")
public class Controller03 {
	
	@RequestMapping("/met01")
	public void method01(HttpServletRequest request) {
		System.out.println("메소드01 일함");
		
		
		// 2. request 분석/ 가공
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		// 3.
		System.out.println(name);
		System.out.println(age);
	}
	
	@RequestMapping("/met02")
	public void method02(String name, Integer age) {
		System.out.println("메소드02 일함");
		System.out.println(name);
		System.out.println(age);
	}
	
	@RequestMapping("/met03")
	public void method03(String address, Integer id) {
		System.out.println("메소드03 일함");
		System.out.println(address);
		System.out.println(id);
	}
	
	@RequestMapping("/met04")
	public void method04(@RequestParam("name") String contactName) {
		System.out.println(contactName);
	}
	
	// url:/cont03/met05?country=korea&height=200
	@RequestMapping("/met05")
	public void method05(@RequestParam("country") String c, @RequestParam("height") Integer h) {
		System.out.println(c);
		System.out.println(h);
	}
}

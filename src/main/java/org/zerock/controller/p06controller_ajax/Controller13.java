package org.zerock.controller.p06controller_ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cont13")
public class Controller13 {
	
	@RequestMapping("/met01")
	@ResponseBody // return value == 응답내용
	public String method01() {
		System.out.println("cont13 met01 일함");
		return "data only - hello" + Math.random();
	}
	
	@RequestMapping("/met02")
	public void method02() {
		System.out.println("cont13 met02 일함");
	}
	
	@RequestMapping("/met03")
	public String method03() {
		System.out.println("cont13 met03 일함");
		
		return "view01";
	}
	
	@RequestMapping("/met04")
	@ResponseBody
	public String method04() {
		System.out.println("cont13 met04 일함");
		
		return "hello This is Data only";
	}
	
	@RequestMapping("/met05")
	@ResponseBody
	public String method05() {
		System.out.println("cont13 met05 일함");
		
		return "success";
	}
	
	@RequestMapping("/met06")
	@ResponseBody
	public String method06() {
		System.out.println("cont13 met06 일함");
		
		return "random" + Math.random();
	}
	
	@RequestMapping("/met07")
	@ResponseBody
	public String method07() {
		System.out.println("cont13 met07 일함");
		
		return (int)(Math.random() * 10) + 1 +"";
	}
	
	@RequestMapping("/met08")
	@ResponseBody
	public String method08() {
		System.out.println("cont13 met08 일함");
		
		return "hello met08";
	}
	
	@RequestMapping("/met09")
	@ResponseBody
	public String method09() {
		System.out.println("cont13 met09 일함");
		
		return "hello met09";
	}
}

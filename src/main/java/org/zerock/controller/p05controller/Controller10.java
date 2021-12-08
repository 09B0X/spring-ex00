package org.zerock.controller.p05controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.controller.p05controller.bean.Bean09;
import org.zerock.mapper.p05mapper.Mapper01;

import lombok.Setter;

@Controller
@RequestMapping("/cont10")
public class Controller10 {
	
	@Setter(onMethod_ = @Autowired)
	private Mapper01 mapper;
	
	@RequestMapping("/met01")
	public void method01() {
		System.out.println(mapper.getSupplierOne());
	}
	
	@RequestMapping("/met02")
	public void method02() {
		// SELECT LastName, FirstName FROM Employees WHERE EmployeeID = 3
		// Mapper01.java에 getEmployeeNameOne 메소드 작성
		// 				위 메소드 리턴 타입 Bean09 사용
		// Mapper01.xml 에 새 <select> 요소 작성

		// 이 메소드에서 getEmployeeNameOne 메소드 실행 결과(Bean09) 출력
		System.out.println(mapper.getEmployeeNameOne());
	}
	
	@RequestMapping("/met03")
	public void method03() {
		List<Bean09> list = mapper.getEmployeeNameList();
		
//		list.forEach(n -> System.out.println(n));
		
		for (Bean09 n : list) {
			System.out.println(n);
		}
	}
	
	@RequestMapping("/met04")
	public void method04() {
		mapper.getSupplierList().forEach(n -> System.out.println(n));
	}
	
	@RequestMapping("/met05")
	public void method05() {
		System.out.println(mapper.getEmployeeLastNameOne());
	}
	
	@RequestMapping("/met06")
	public void method06() {
		System.out.println(mapper.getEmployeeFirstNameOne());
	}
	
	@RequestMapping("/met07")
	public void method07() {
		List<String> list = mapper.getEmployeeLastNameList();
		
		for (String lname : list) {
			System.out.println(lname);
		}
	}
}

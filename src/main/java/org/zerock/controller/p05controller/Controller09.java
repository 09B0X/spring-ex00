package org.zerock.controller.p05controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.controller.p05controller.bean.Bean09;
import org.zerock.controller.p05controller.bean.Bean10;
import org.zerock.controller.p05controller.bean.Bean11;
import org.zerock.controller.p05controller.bean.Bean12;
import org.zerock.controller.p05controller.bean.Bean13;
import org.zerock.controller.p05controller.bean.Bean14;
import org.zerock.controller.p05controller.bean.Bean15;
import org.zerock.mapper.p05mapper.TimeMapper;

import lombok.Setter;

@Controller
@RequestMapping("/cont09")
public class Controller09 {

	@Setter(onMethod_ = @Autowired)
	private TimeMapper mapper;
	
	@RequestMapping("/met01")
	public void method01() {
		String time = mapper.getTime();
		System.out.println(time);
	}
	
	@RequestMapping("/met02")
	public void method02() {
		String name = mapper.getCustomerName();
		System.out.println(name);
	}
	
	@RequestMapping("/met03")
	public void method03(Model model) {
		String name = mapper.getCustomerName();
		model.addAttribute("name", name);
	}
	
	// 요청 경로 : /cont09/met04
	// 실행 쿼리 : SELECT LastName FROM Employees WHERE EmployeeID = 1
	// 뷰 : /cont09/met04.jsp 에 LastName 출력
	
	// 작성할 메소드 Controller09#method04
	//              TimeMapper#getLastName();
	
	@RequestMapping("/met04")
	public void method04(Model model) {
		model.addAttribute("lastName", mapper.getLastName());
	}
	
	@RequestMapping("/met05")
	public void method05(Integer id) {
		String name = mapper.getCustomerNameById(id);
		System.out.println(name);
	}
	
	// method06 : request parameter "id"값으로 직원 테이블을 조회해서 
	//            콘솔에 lastName 출력
	@RequestMapping("/met06")
	public void method06(Integer id) {
		String name = mapper.getLastNameById(id);
		System.out.println(name);
	}
	
	@RequestMapping("/met07")
	public void method07() {
		List<String> names = mapper.getCustomerNames();
		System.out.println(names);
	}
	
	// method08 에서 직원들의 LastName 들 조회하고 콘솔에 출력
	@RequestMapping("/met08")
	public void method08() {
		List<String> names = mapper.getLastNames();
		System.out.println(names);
	}
	
	@RequestMapping("/met09")
	public void method09() {
		Bean09 name = mapper.getEmployeeName();
		System.out.println(name);
	}
	
	@RequestMapping("/met10")
	public void method10() {
		Bean10 name = mapper.getName();
		System.out.println(name); // 1번 고객의 CustomerName, ContactName이 출력되도록 코드 작성
	}
	
	@RequestMapping("/met11")
	public void method11() {
		Bean11 name = mapper.getCustomerInfo();
		System.out.println(name); 
	}
	
	@RequestMapping("/met12")
	public void method12() {
		Bean12 name = mapper.getEmployeeInfo();
		System.out.println(name);
	}
	
	@RequestMapping("/met13")
	public void method13(Integer id) {
		System.out.println(mapper.getEmployeeById(id));
	}
	
	@RequestMapping("/met14")
	public void method14(Integer id) {
		// TODO: mapper에 getCustomerById 메소드 (Bean14 리턴) 만들기
		//      Bean14빈의 property가 Customers 테이블의 컬럼과 매치되도록 작성
		System.out.println(mapper.getCustomerById(id));
	}
	
	@RequestMapping("/met15")
	public void method15() {
		List<Bean14> list = mapper.getCustomers();
		
		for (Bean14 item : list) {
			System.out.println(item);
		}
	}
	
	@RequestMapping("/met16")
	public void method16() {
		List<Bean13> list = mapper.getEmployees();
		
		for (Bean13 item : list) {
			System.out.println(item);
		}
	}
	
	@RequestMapping("/met17")
	public void method17() {
		List<Bean15> list = mapper.getProductInfo();
		
		for (Bean15 item : list) {
			System.out.println(item);
		}
	}
	
	@RequestMapping("/met18")
	public void method18() {
		List<Bean15> list = mapper.getProductInfo2();
		
		for (Bean15 item : list) {
			System.out.println(item);
		}
	}
}

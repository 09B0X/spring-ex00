package org.zerock.controller.p01Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.controller.p01Controller.bean.Bean01;
import org.zerock.controller.p01Controller.bean.Bean02;
import org.zerock.controller.p01Controller.bean.Bean03;
import org.zerock.controller.p01Controller.bean.Bean04;
import org.zerock.controller.p01Controller.bean.Bean05;
import org.zerock.controller.p01Controller.bean.Bean06;
import org.zerock.controller.p01Controller.bean.Bean07;
import org.zerock.controller.p01Controller.bean.Bean08;

@Controller
@RequestMapping("/cont04")
public class Controller04 {

	@RequestMapping("/met01")
	public void method01(String name, String city) {

		System.out.println(name);
		System.out.println(city);
	}

	@RequestMapping("/met02")
	public void method02(HttpServletRequest request) {

		// 2. request 분석/가공
		String name = request.getParameter("name");
		String city = request.getParameter("city");

		Bean01 bean = new Bean01();
		bean.setName(name);
		bean.setCity(city);

		System.out.println(bean); // 잘 들어왔는지 확인

		// 3. business logic

		// 4. add attribute

		// 5. forward / redirect
	}

	@RequestMapping("/met03")
	public void method03(Bean01 bean) {

		System.out.println(bean);
	}

	// /cont04/met04?country=usa&phone=0109999&address=seoul&email=usa@seoul.com
	@RequestMapping("/met04")
	public void method04(Bean02 bean) {

		System.out.println(bean);
		// 각 프로퍼티가 null이 아니도록 요청
	}

	// /cont04/met05?name=john&age=33
	@RequestMapping("/met05")
	public void method05(Bean03 bean) {

		System.out.println(bean);
	}

	// /cont04/met06?id=123&score=4000
	@RequestMapping("/met06")
	public void method06(Bean04 bean) {

		System.out.println(bean);
		// 각 프로터피가 0이 아니도록 요청
	}

	// /cont04/met07?tel=010&tel=011&tel=012
	@RequestMapping("/met07")
	public void method07(@RequestParam("tel") ArrayList<String> tel) {

		System.out.println(tel);
	}

	// /cont04/met08?name=jhon&tel=010&tel=011
	@RequestMapping("/met08")
	public void method08(Bean05 bean) {

		System.out.println(bean);
	}

	// /cont04/met09?name=jhon&id=123&tel=010&tel=011
	@RequestMapping("/met09")
	public void method09(Bean06 bean) {

		System.out.println(bean);
	}

	@RequestMapping("/met10")
	public void method10(@RequestParam("date")
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(iso = ISO.DATE) LocalDate date) {
		System.out.println(date);
	}

	@RequestMapping("/met11")
	public void method11(@RequestParam("dateTime") @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime dateTime) {
		System.out.println(dateTime);
	}

	// /cont04/met12?name=donald&birth=1999-01-01&inserted=1988-01-02T15:33:22
	@RequestMapping("/met12")
	public void method12(Bean07 bean) {
		System.out.println(bean);
	}

	// /cont04/met13?name=trump&age=99&moved=1988-02-02&writed=2010-03-03T17:22:11
	@RequestMapping("/met13")
	public void method13(Bean08 bean) {
		System.out.println(bean); // 모든 프로퍼티가 request param으로 부터 채워져서 출력되도록
	}
	
	@RequestMapping("/met14")
	public void method14(@RequestParam String name, @RequestParam int age, HttpServletRequest request) {
		System.out.println(name);
		System.out.println(age);
		
		System.out.println(request);
	}
}

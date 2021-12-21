package org.zerock.controller.p08restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.project1.BoardVO;
import org.zerock.mapper.project1.BoardMapper;

import lombok.Setter;

@RestController
@RequestMapping("/cont18")
public class Controller18 {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@RequestMapping("/met01")
	public String method01() {
		return "hello";
	}
	
	@RequestMapping(value = "/met02", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
	public String method02() {
		return "hello2";
	}
	
	@RequestMapping(value = "/met03", method = {RequestMethod.GET, RequestMethod.POST})
	public String method03() {
		return "hello3";
	}
	
	@RequestMapping(value = "/met04", method = RequestMethod.GET)
	public String method04() {
		return "hello4";
	}
	
	@GetMapping("/met05")
	public String method05() {
		return "";
	}
	
	@PostMapping("/met06")
	public String method06() {
		return "";
	}
	
	@PutMapping("/met07")
	public String method07() {
		return "";
	}
	
	@DeleteMapping("/met08")
	public String method08() {
		return "";
	}
	
	@GetMapping("/met09/{id}")
	public BoardVO method09(@PathVariable Integer id) {
		return mapper.read(id);
	}
}

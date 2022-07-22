package org.zerock.controller.p09controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/cont19")
public class Controller19 {

	@RequestMapping("/met01")
	public String method01(String name, String age, MultipartFile file1) {

		System.out.println(name);
		System.out.println(age);

		if (file1 != null) {
			System.out.println(file1.getOriginalFilename());

			String path = "D:\\course\\fileupload\\test\\" + file1.getOriginalFilename();
			File dest = new File(path);

			try {
				file1.transferTo(dest);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}

	@RequestMapping("/met02")
	public String method02(MultipartFile file1, MultipartFile file2) {

		if (file1 != null) {
			System.out.println(file1.getOriginalFilename());

			String path = "C:\\Users\\user\\Desktop\\course\\fileupload\\" + file1.getOriginalFilename();

			try {
				file1.transferTo(new File(path));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (file2 != null) {
			System.out.println(file2.getOriginalFilename());

			String path = "C:\\Users\\user\\Desktop\\course\\fileupload\\" + file2.getOriginalFilename();

			try {
				file2.transferTo(new File(path));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	@RequestMapping("/met03")
	public String method03(MultipartFile[] files) {
		
		for (MultipartFile file : files) {
			System.out.println(file.getOriginalFilename());
			
			String path = "C:\\Users\\user\\Desktop\\course\\fileupload\\" + file.getOriginalFilename();

			try {
				file.transferTo(new File(path));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}
}

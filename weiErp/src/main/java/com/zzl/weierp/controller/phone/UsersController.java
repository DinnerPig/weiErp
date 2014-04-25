package com.zzl.weierp.controller.phone;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
public class UsersController {
	
	@RequestMapping("/home")
	public String home() {
		return "phone/home/home";
	}
	
	@RequestMapping("/pc/main")
	public String main() {
		return "pc/main/main";
	}
}

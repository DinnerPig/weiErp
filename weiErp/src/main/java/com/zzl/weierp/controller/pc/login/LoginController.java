package com.zzl.weierp.controller.pc.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
public class LoginController {
	
	/**
	 * 进入登陆页
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pc/main", method = RequestMethod.GET)
	public String pcMain() {
		return "pc/login/login";
	}
	
	/**
	 * 登陆
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// 登陆成功
		if("yangshiyong".equals(username) && "yangshiyong2014".equals(password)) {
			return "pc/main/main";
		}
		
		// 登陆失败
		else {
			model.addAttribute("error", true);
			return "pc/login/login";
		}
	}
}

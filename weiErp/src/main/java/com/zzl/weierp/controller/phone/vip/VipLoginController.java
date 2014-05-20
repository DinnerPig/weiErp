package com.zzl.weierp.controller.phone.vip;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/phone/vip")
@Controller
public class VipLoginController {
	
	/**
	 * 进入注册页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/registerPage", method = RequestMethod.GET)
	public String registerPage() {
		return "phone/vip/vipRegister";
	}

}
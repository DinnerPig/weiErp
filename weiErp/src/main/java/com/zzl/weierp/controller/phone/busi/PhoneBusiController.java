package com.zzl.weierp.controller.phone.busi;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zzl.weierp.common.utils.SessionUtil;
import com.zzl.weierp.domain.Busi;

@RequestMapping("/phone/busi")
@Controller
public class PhoneBusiController {
	
	@RequestMapping
	public String loginPage() {
		return "phone/busi/login";
	}
	
	@RequestMapping("/login")
	public String login(Model model, HttpSession session,
			@RequestParam String username,
			@RequestParam String password) {
		
		// 1.check params
		if(StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
			model.addAttribute("error", true);
			return "phone/busi/login";
		}
		
		// 2.check username and password
		List<Busi> busis = Busi.findBusisByUsernameEquals(username).getResultList();
		
		// wrong
		if(null == busis || busis.isEmpty() || !password.equals(busis.get(0).getPassword())) {
			
			model.addAttribute("error", true);
			return "phone/busi/login";
		}
		
		// 3.set session
		SessionUtil.storeInfo(session, busis.get(0));
		
		// 4.enter menu
		return "phone/busi/busiMenu";
	}
}

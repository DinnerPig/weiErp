package com.zzl.weierp.controller.phone.busi;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzl.weierp.common.globalConst.StatusCode;
import com.zzl.weierp.common.utils.SessionUtil;
import com.zzl.weierp.common.utils.WebUtil;
import com.zzl.weierp.domain.Busi;

@RequestMapping("/phone/busi")
@Controller
public class PhoneBusiController {
	
	@RequestMapping
	public String loginPage() {
		return "phone/busi/login";
	}
	
	/**
	 * 修改个人信息
	 * @param busi
	 * @return
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	@ResponseBody
	public String modify(@ModelAttribute Busi busi) {
		Busi oriBusi = Busi.findBusi(busi.getId());
		oriBusi.setAddress(busi.getAddress());
		oriBusi.setPhone(busi.getPhone());
		oriBusi.setQq(busi.getQq());
		oriBusi.setWeixin(busi.getWeixin());
		oriBusi.persist();
		return WebUtil.toJsonString(StatusCode.STATUS_SUCCESS);
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
		return "phone/home/main";
	}
}

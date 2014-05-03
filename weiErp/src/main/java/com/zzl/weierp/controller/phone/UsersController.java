package com.zzl.weierp.controller.phone;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zzl.weierp.common.utils.SessionUtil;
import com.zzl.weierp.domain.Busi;
import com.zzl.weierp.domain.ProductType;

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

	@RequestMapping(value = "/phone/menu/{type}", method = RequestMethod.GET)
	public String menu(Model model, @PathVariable String type,
			HttpSession session) {

		// 1.check session
		Long userId = SessionUtil.getUserId(session);
		if (null == userId) {
			return "phone/timeout/timeout";
		}

		// person center
		if ("center".equals(type)) {
			model.addAttribute("busi", Busi.findBusi(userId));
			return "phone/busi/busiInfo";
		}

		// product type list
		else if ("product".equals(type)) {
			model.addAttribute("types", ProductType.findAllProductTypes());
			return "phone/product/productType";
		}

		// shopping car
		else if ("shopCar".equals(type)) {

		}

		// logout
		else if ("logout".equals(type)) {

		}

		// order
		else if ("order".equals(type)) {
			return "phone/busi/busiMenu";
		}

		return "phone/home/home";
	}
}

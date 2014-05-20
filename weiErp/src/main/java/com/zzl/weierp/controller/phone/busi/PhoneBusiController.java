package com.zzl.weierp.controller.phone.busi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzl.weierp.common.globalConst.StatusCode;
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
}

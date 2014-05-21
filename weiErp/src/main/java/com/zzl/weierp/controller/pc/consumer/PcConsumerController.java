package com.zzl.weierp.controller.pc.consumer;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzl.weierp.common.globalConst.StatusCode;
import com.zzl.weierp.common.utils.WebUtil;
import com.zzl.weierp.domain.consumer.Consumer;
import com.zzl.weierp.service.interfaces.consumer.IConsumerService;

@Controller
@RequestMapping("/pc/consumer")
public class PcConsumerController {

	@Autowired
	private IConsumerService consumerService;
	
	/**
	 * 会员信息
	 * @return
	 */
	@RequestMapping(value = "/query/{id}", method = RequestMethod.GET)
	public String query(Model model, HttpSession session, @PathVariable Long id) {
		
		model.addAttribute("consumer", Consumer.findConsumer(id));
		
		return "pc/consumer/consumerInfo";
	}
	
	/**
	 * 升级为分享会员
	 * @return
	 */
	@RequestMapping(value = "/rise/{id}", method = RequestMethod.POST)
	@ResponseBody
	public String rise(HttpSession session, @PathVariable Long id) {
		
		Consumer consumer = Consumer.findConsumer(id);
		
		consumer.setDegree(2);
		
		consumer.persist();
		
		return WebUtil.toJsonString(StatusCode.STATUS_SUCCESS);
	}
	
	/**
	 * 分页查询会员列表
	 * @param model
	 * @param session
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model, HttpSession session,
			@RequestParam(required = false) Integer page,
			@RequestParam(required = false) Integer size) {

		model.addAttribute("consumers", consumerService.queryList(model, page, size));

		return "pc/consumer/consumers";
	}
}

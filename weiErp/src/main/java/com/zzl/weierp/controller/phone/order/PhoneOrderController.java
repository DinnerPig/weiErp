package com.zzl.weierp.controller.phone.order;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzl.weierp.common.globalConst.GlobalConst;
import com.zzl.weierp.common.utils.SessionUtil;
import com.zzl.weierp.common.utils.WebUtil;
import com.zzl.weierp.domain.ProductOrder;
import com.zzl.weierp.service.pc.order.PcOrderService;
import com.zzl.weierp.service.phone.order.PhoneOrderService;

@RequestMapping("/phone/order")
@Controller
public class PhoneOrderController {
	
	@Autowired
	private PhoneOrderService phoneOrderService;
	
	@Autowired
	private PcOrderService pcOrderService;
	
	/**
	 * 新增订单
	 * @param order
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public String add(@ModelAttribute ProductOrder order, HttpSession session) {
		
		// check session
		Long userId = SessionUtil.getUserId(session);
		if(null == userId) {
			return WebUtil.toJson(GlobalConst.STATUS_SESSION_TIMEOUT);
		}
		
		return phoneOrderService.add(order, userId);
	}
	
	/**
	 * 修改订单卖出数量
	 * @param order
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	@ResponseBody
	public String update(@PathVariable Long id, HttpSession session, @RequestParam Integer outAmount) {
		
		// check session
		Long userId = SessionUtil.getUserId(session);
		if(null == userId) {
			return WebUtil.toJson(GlobalConst.STATUS_SESSION_TIMEOUT);
		}
		
		ProductOrder order = ProductOrder.findProductOrder(id);
		if(null == order) {
			return WebUtil.toJson(GlobalConst.STATUS_FAIL);
		}
		
		order.setOutAmount(outAmount);
		order.persist();
		
		return WebUtil.toJson(GlobalConst.STATUS_SUCCESS);
	}
	
	/**
	 * 查询所有未发货的订单
	 * @param order
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/queryAll", method = RequestMethod.GET)
	public String queryAll(Model model, HttpSession session, @RequestParam Integer status) {
		
		// check session
		Long userId = SessionUtil.getUserId(session);
		if(null == userId) {
			return "phone/timeout/timeout";
		}
		
		// set model
		model.addAttribute("orders", phoneOrderService.queryAll(userId, status));
		
		return "phone/order/phoneTodoOrderList";
	}
	
	/**
	 * 分页查询
	 * @param model
	 * @param session
	 * @param page
	 * @param size
	 * @param keyword
	 * @param status
	 * @return
	 */
	@RequestMapping(value = "/query/list", method = RequestMethod.GET)
	public String queryList(Model model, HttpSession session,
			@RequestParam(required = false) Integer page,
			@RequestParam(required = false) Integer size,
			@RequestParam(required = false) String keyword,
			@RequestParam Integer status) {

		// 1.check session
		Long userId = (Long) session.getAttribute("userId");
		if (null == userId) {
			return "phone/timeout/timeout";
		}

		// 2.query products
		model.addAttribute("orders", pcOrderService.queryList(model, keyword, page, size, userId, status));
		
		return "phone/order/phoneDoneOrderList";
		
	}
	
	/**
	 * 查询所有未发货的订单
	 * @param order
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public String detail(Model model, HttpSession session, @PathVariable Long id) {
		
		// check session
		Long userId = SessionUtil.getUserId(session);
		if(null == userId) {
			return "phone/timeout/timeout";
		}
		
		// set model
		model.addAttribute("order", ProductOrder.findProductOrder(id));
		
		return "phone/order/phoneOrderDetail";
	}
}

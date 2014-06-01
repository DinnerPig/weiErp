package com.zzl.weierp.controller.pc.order;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzl.weierp.common.globalConst.GlobalConst;
import com.zzl.weierp.common.globalConst.StatusCode;
import com.zzl.weierp.common.utils.WebUtil;
import com.zzl.weierp.domain.ProductOrder;
import com.zzl.weierp.domain.consumer.Consumer;
import com.zzl.weierp.service.pc.order.PcOrderService;

@RequestMapping("pc/order")
@Controller
public class PcOrderController {
	
	@Autowired
	private PcOrderService pcOrderService;
	
	/**
	 * 进入订单列表页面
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public String page(Model model, HttpSession session) {
		
		model.addAttribute("consumers", Consumer.findAllConsumers());

		return "pc/order/pcOrder";
	}
	
	/**
	 * 进入订单列表页面
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/print/{id}", method = RequestMethod.GET)
	public String print(Model model, HttpSession session, @PathVariable Long id) {
		
		model.addAttribute("order", ProductOrder.findProductOrder(id));
		
		return "pc/order/printTodoOrder";
	}
	
	@RequestMapping(value = "/query/list", method = RequestMethod.GET)
	public String queryList(Model model, HttpSession session,
			@RequestParam(required = false) Long consumerId,
			@RequestParam(required = false) Integer page,
			@RequestParam(required = false) Integer size,
			@RequestParam(required = false) String keyword,
			@RequestParam Integer status) {

		// 查询订单
		model.addAttribute("orders", pcOrderService.queryList(model, keyword, page, size, consumerId, status));
		
		// 未发货订单 
		if(status == GlobalConst.ORDER_STATUS_TODO) {
			return "pc/order/pcOrderListTodo";
		}
		
		// 已发货订单
		return "pc/order/pcOrderListDone";
		
	}
	
	
	/**
	 * 改为发货状态
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/done/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String done(@PathVariable Long id, @RequestParam String expressSerial, HttpSession session) {

		// check session
//		Long userId = (Long) SessionUtil.getUserId(session);
//		if (null == userId) {
//			return "common/timeout";
//		}

		// send
		return pcOrderService.done(id, expressSerial);
	}
	
	/**
	 * 改为发货状态
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String remove(@PathVariable Long id, HttpSession session) {

		// check session
//		Long userId = (Long) SessionUtil.getUserId(session);
//		if (null == userId) {
//			return "common/timeout";
//		}

		// remove
		ProductOrder order = ProductOrder.findProductOrder(id);
		if(null != order) {
			order.remove();
		}
		
		return WebUtil.toJsonString(StatusCode.STATUS_SUCCESS);
	}


}

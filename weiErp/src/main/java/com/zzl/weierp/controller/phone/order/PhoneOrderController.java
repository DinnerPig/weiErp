package com.zzl.weierp.controller.phone.order;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzl.weierp.common.globalConst.GlobalConst;
import com.zzl.weierp.common.utils.SessionUtil;
import com.zzl.weierp.common.utils.WebUtil;
import com.zzl.weierp.domain.Busi;
import com.zzl.weierp.domain.Product;
import com.zzl.weierp.domain.vo.ShopCarProduct;
import com.zzl.weierp.service.interfaces.order.IProductOrderService;
import com.zzl.weierp.service.pc.order.PcOrderService;
import com.zzl.weierp.service.phone.order.PhoneOrderService;

@RequestMapping("/phone/order")
@Controller
public class PhoneOrderController {
	
	@Autowired
	private PhoneOrderService phoneOrderService;
	
	@Autowired
	private PcOrderService pcOrderService;
	
	@Autowired
	private IProductOrderService productOrderService;
	
	/**
	 * 新增订单
	 * @param order
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public String create(@RequestBody String json, HttpSession session) {
		
		// check session
		Long userId = SessionUtil.getUserId(session);
		if(null == userId) {
			return WebUtil.toJsonString(GlobalConst.STATUS_SESSION_TIMEOUT);
		}
		
		// pack query params
		JSONObject params = JSONObject.fromObject(json);
		params.put("busiId", userId);
		
		return productOrderService.create(params.toString());
	}
	
	/**
	 * 添加到购物车
	 * @param order
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/shopCar", method = RequestMethod.POST)
	@ResponseBody
	public String shopCar(@RequestParam Long productId, @RequestParam Integer amount, HttpSession session) {
		
		// check session
		Long userId = SessionUtil.getUserId(session);
		if(null == userId) {
			return WebUtil.toJsonString(GlobalConst.STATUS_SESSION_TIMEOUT);
		}
		
		Object products = session.getAttribute("products");
		
		if(null == products) {
			Map<Long, Integer> map = new HashMap<Long, Integer>();
			map.put(productId, amount);
			session.setAttribute("products", map);
		}
		
		else {
			@SuppressWarnings("unchecked")
			Map<Long, Integer> map = (Map<Long, Integer>) products;
			
			// exist
			if(map.containsKey(productId)) {
				int oriAmount = map.get(productId);
				map.put(productId, oriAmount + amount);
			}
			
			// no exist
			else {
				map.put(productId, amount);
			}
		}
		
		return WebUtil.toJsonString(GlobalConst.STATUS_SUCCESS);
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
	 * 进入订单结算页面
	 * @param order
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public String order(Model model, HttpSession session) {
		
		// check session
		Long userId = SessionUtil.getUserId(session);
		if(null == userId) {
			return "phone/timeout/timeout";
		}
		
		List<ShopCarProduct> list = new ArrayList<ShopCarProduct>();
		Object products = session.getAttribute("products");
		if(null != products) {
			@SuppressWarnings("unchecked")
			Map<Long, Integer> map = (Map<Long, Integer>) products;
			Iterator<Entry<Long, Integer>> iter = map.entrySet().iterator();
			while(iter.hasNext()) {
				ShopCarProduct product = new ShopCarProduct();
				Entry<Long, Integer> entry = iter.next();
				Long id = entry.getKey();
				product.setId(id);
				product.setAmount(entry.getValue());
				Product temp = Product.findProduct(id);
				product.setName(temp.getName());
				product.setPrice(temp.getPrice());
				
				list.add(product);
			}
		}
		// set model
		model.addAttribute("products", list);
		model.addAttribute("busi", Busi.findBusi(userId));
		
		return "phone/product/order";
	}
}

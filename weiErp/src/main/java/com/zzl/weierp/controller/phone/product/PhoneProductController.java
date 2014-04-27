package com.zzl.weierp.controller.phone.product;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zzl.weierp.common.utils.SessionUtil;
import com.zzl.weierp.domain.Busi;
import com.zzl.weierp.domain.Product;
import com.zzl.weierp.domain.ProductType;
import com.zzl.weierp.service.phone.product.PhoneProductService;

@RequestMapping("/phone/product")
@Controller
public class PhoneProductController {

	@Autowired
	private PhoneProductService productService;

	/**
	 * 查询礼品分类列表
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/query/type", method = RequestMethod.GET)
	public String queryType(Model model, HttpSession session) {

		// 1.check session
		Long userId = SessionUtil.getUserId(session);
		if (null == userId) {
			return "phone/timeout/timeout";
		}
		
		// 2.set model
		model.addAttribute("types", ProductType.findAllProductTypes());
		
		return "phone/product/productType";
	}
	
	/**
	 * 进入某个分类的产品列表页面
	 * @param model
	 * @param typeId
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/show/{typeId}", method = RequestMethod.GET)
	public String page(Model model, @PathVariable Long typeId,
			HttpSession session) {

		// 1.check session
		Long userId = SessionUtil.getUserId(session);
		if (null == userId) {
			return "phone/timeout/timeout";
		}
		
		// 2.set model
		model.addAttribute("typeId", typeId);
		
		return "phone/product/product";
	}

	/**
	 * 根据类型查询列表
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/query/{typeId}", method = RequestMethod.GET)
	public String query(Model model, HttpSession session,
			@PathVariable Long typeId,
			@RequestParam(required = false) Integer page,
			@RequestParam(required = false) Integer size,
			@RequestParam(required = false) String keyword) {

		// 1.check session
		Long userId = SessionUtil.getUserId(session);
		if (null == userId) {
			return "phone/timeout/timeout";
		}

		// 2.query page
		model.addAttribute("products", productService.queryList(model, keyword, page, size, typeId));

		return "phone/product/productList";
	}
	
	/**
	 * 查询产品详情
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public String detail(Model model, HttpSession session,
			@PathVariable Long id) {

		// 1.check session
		Long userId = (Long) session.getAttribute("userId");
		if (null == userId) {
			return "phone/timeout/timeout";
		}

		// 2.execute query
		model.addAttribute("product", Product.findProduct(id));

		return "phone/product/detail";
	}

}

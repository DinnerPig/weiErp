package com.zzl.weierp.controller.pc.product;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzl.weierp.common.globalConst.GlobalConst;
import com.zzl.weierp.common.utils.WebUtil;
import com.zzl.weierp.domain.Product;
import com.zzl.weierp.domain.ProductType;
import com.zzl.weierp.service.pc.product.PcProductService;

@RequestMapping("/pc/product")
@Controller
public class PcProductController {

	@Autowired
	private PcProductService pcProductService;

	/**
	 * 进入礼品列表页面
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public String page(Model model, HttpSession session) {

		// 1.check session
//		Long busiId = (Long) session.getAttribute("busiId");
//		if (null == busiId) {
//			return "common/timeout";
//		}

		// 2.query productTypes
		model.addAttribute("types", ProductType.findAllProductTypes());

		return "pc/product/product";
	}
	
	/**
	 * 查询产品详情
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/modal", method = RequestMethod.GET)
	public String modal(Model model, HttpSession session,
			@RequestParam(required = false) Long id) {

		// 1.check session

		// 2.query product
		Product product = null;
		// add
		if(null == id) {
			product = new Product();
		}
		
		// edit
		else {
			product = Product.findProduct(id); 
		}
		model.addAttribute("product", product);
		model.addAttribute("types", ProductType.findAllProductTypes());

		return "pc/product/productModal";
	}
	
	@RequestMapping(value = "/query/list", method = RequestMethod.GET)
	public String queryList(Model model, HttpSession session,
			@RequestParam(required = false) Long typeId,
			@RequestParam(required = false) Integer page,
			@RequestParam(required = false) Integer size,
			@RequestParam(required = false) String keyword) {

		// 1.check session
//		Long busiId = (Long) session.getAttribute("busiId");
//		if (null == busiId) {
//			return "common/timeout";
//		}

		// 2.query products
		model.addAttribute("products", pcProductService.queryList(model, keyword, page, size, typeId));

		return "pc/product/productList";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public String save(Model model, HttpSession session, @RequestBody String body) {

		// 1.check session
//		Long busiId = (Long) session.getAttribute("busiId");
//		if (null == busiId) {
//			return "common/timeout";
//		}

		// 2.save product
		return pcProductService.save(body);
	}
	
	@RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String delete(Model model, HttpSession session, @PathVariable Long id) {

		// 1.check session
//		Long busiId = (Long) session.getAttribute("busiId");
//		if (null == busiId) {
//			return "common/timeout";
//		}

		// 2.delete product
		Product.findProduct(id).remove();
		
		return WebUtil.toJson(GlobalConst.STATUS_SUCCESS);
	}
	
}

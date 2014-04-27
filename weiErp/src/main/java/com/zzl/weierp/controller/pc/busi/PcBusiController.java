package com.zzl.weierp.controller.pc.busi;

import java.util.List;

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
import com.zzl.weierp.common.utils.WebUtil;
import com.zzl.weierp.domain.Busi;
import com.zzl.weierp.domain.ProductOrder;
import com.zzl.weierp.service.pc.busi.PcBusiService;

@RequestMapping("/pc/busi")
@Controller
public class PcBusiController {

	@Autowired
	private PcBusiService pcBusiService;

	@RequestMapping(value = "/query/list", method = RequestMethod.GET)
	public String queryList(Model model, HttpSession session,
			@RequestParam(required = false) Integer page,
			@RequestParam(required = false) Integer size) {

		// 1.check session
//		Long busiId = (Long) session.getAttribute("busiId");
//		if (null == busiId) {
//			return "common/timeout";
//		}

		// 2.query busis
		model.addAttribute("busis", pcBusiService.queryList(model, page, size));

		return "pc/busi/busi";
	}
	
	/**
	 * 查询经销商
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/modal", method = RequestMethod.GET)
	public String modal(Model model, HttpSession session,
			@RequestParam(required = false) Long id) {

		// 1.check session

		// 2.query busi
		Busi busi = null;
		// add
		if(null == id) {
			busi = new Busi();
		}
		
		// edit
		else {
			busi = Busi.findBusi(id); 
		}
		model.addAttribute("busi", busi);

		return "pc/busi/busiModal";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public String save(Model model, HttpSession session, @ModelAttribute Busi busi) {

		// 1.check session
//		Long busiId = (Long) session.getAttribute("busiId");
//		if (null == busiId) {
//			return "common/timeout";
//		}

		// 2.save product
		return pcBusiService.save(busi);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String delete(Model model, HttpSession session, @PathVariable Long id) {

		// 1.check session
//		Long busiId = (Long) session.getAttribute("busiId");
//		if (null == busiId) {
//			return "common/timeout";
//		}

		// check exist in order
		List<ProductOrder> orders = ProductOrder.findProductOrdersByBusi(Busi.findBusi(id)).getResultList();
		if(null != orders && !orders.isEmpty()) {
			return WebUtil.toJsonString(GlobalConst.STATUS_CANNOT_DELETE);
		}
		
		// delete product
		Busi.findBusi(id).remove();
		
		return WebUtil.toJsonString(GlobalConst.STATUS_SUCCESS);
	}
	
}

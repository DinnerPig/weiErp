package com.zzl.weierp.service.pc.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.zzl.weierp.common.globalConst.GlobalConst;
import com.zzl.weierp.common.utils.WebUtil;
import com.zzl.weierp.domain.ProductOrder;
import com.zzl.weierp.repository.order.OrderRepository;

@Service
public class PcOrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	/**
	 * 分页查询
	 * @param model
	 * @param keyword
	 * @param page
	 * @param size
	 * @param busiId 
	 * @param status 1：未发货，2：已发货
	 * @return
	 */
	public List<ProductOrder> queryList(Model model, String keyword, Integer page, Integer size, Long busiId, Integer status) {
		
		// 1.query total number
		long total = orderRepository.count(busiId, keyword, status);

		// 2.set page info
		WebUtil.setPageInfo(model, total, page, size);
		
		// 3.execute query
		return orderRepository.queryList(busiId, keyword, page, size, status);
	}

	/**
	 * 改为发货状态
	 * @param id
	 * @return
	 */
	public String done(Long id) {
		
		// check param
		if(null == id) {
			return WebUtil.toJsonString(GlobalConst.STATUS_FAIL);
		}
		
		// change status
		ProductOrder order = ProductOrder.findProductOrder(id);
		if(null == order) {
			WebUtil.toJsonString(GlobalConst.STATUS_FAIL);
		}
		order.setStatus(GlobalConst.ORDER_STATUS_DONE);
		order.persist();
		
		// return json
		return WebUtil.toJsonString(GlobalConst.STATUS_SUCCESS);
	}

}

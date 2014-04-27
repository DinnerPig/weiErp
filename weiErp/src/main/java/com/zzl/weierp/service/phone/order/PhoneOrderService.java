package com.zzl.weierp.service.phone.order;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzl.weierp.common.globalConst.GlobalConst;
import com.zzl.weierp.common.utils.WebUtil;
import com.zzl.weierp.domain.Busi;
import com.zzl.weierp.domain.Product;
import com.zzl.weierp.domain.ProductOrder;
import com.zzl.weierp.repository.order.OrderRepository;

@Service
public class PhoneOrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	/**
	 * 新增订单
	 * @param order
	 * @return
	 */
	public String add(ProductOrder order, Long userId) {
		
		// check param
//		if(null == userId || null == order || null == order.getProduct() || StringUtils.isBlank(order.getAddress()) || order.getAmount() <= 0) {
//			return WebUtil.toJsonString(GlobalConst.STATUS_FAIL);
//		}
		
		order.setCreateTime(new Date());
		order.setBusi(Busi.findBusi(userId));
//		order.setProduct(Product.findProduct(order.getProduct().getId()));
//		order.setStatus(GlobalConst.ORDER_STATUS_TODO);
//		order.setOutAmount(0);
		
		// execute add
		order.persist();
		
		return WebUtil.toJsonString(GlobalConst.STATUS_SUCCESS);
	}

	/**
	 * 根据条件查询所有订单
	 * @param userId
	 * @param status 
	 * @return
	 */
	public List<ProductOrder> queryAll(Long userId, Integer status) {
		
		// check params
		if(null == userId || null == status) {
			return null;
		}
		
		// execute query
		return orderRepository.queryAll(userId, status);
	}
}

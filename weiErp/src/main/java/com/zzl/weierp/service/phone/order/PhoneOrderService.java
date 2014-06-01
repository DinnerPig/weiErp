package com.zzl.weierp.service.phone.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzl.weierp.domain.ProductOrder;
import com.zzl.weierp.repository.order.OrderRepository;

@Service
public class PhoneOrderService {

	@Autowired
	private OrderRepository orderRepository;
	

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

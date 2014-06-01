package com.zzl.weierp.service.interfaces.order;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.zzl.weierp.common.globalConst.GlobalConst;
import com.zzl.weierp.common.globalConst.StatusCode;
import com.zzl.weierp.common.utils.JsonUtil;
import com.zzl.weierp.common.utils.WebUtil;
import com.zzl.weierp.domain.OrderProduct;
import com.zzl.weierp.domain.Product;
import com.zzl.weierp.domain.ProductOrder;
import com.zzl.weierp.domain.consumer.Consumer;

@Service
public class ProductOrderService implements IProductOrderService {

	/*
	 * 创建订单
	 * 
	 * @see
	 * com.zzl.weierp.service.interfaces.order.IProductOrderService#create(java
	 * .lang.String)
	 */
	@Override
	public String create(String params) {

		// check params
		if (!JsonUtil.valid(params)) {
			return WebUtil.toJsonString(StatusCode.STATUS_INVALID_JSON);
		}

		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("consumerId", "Long");
		paramsMap.put("serial", "String");
		paramsMap.put("address", "String");
		paramsMap.put("note", "String");
		if (!JsonUtil.checkParams(JSONObject.fromObject(params), paramsMap)) {
			return WebUtil.toJsonString(StatusCode.STATUS_INVALID_PARAMS);
		}

		// parser params
		JSONObject paramsObj = JSONObject.fromObject(params);
		Long consumerId = paramsObj.getLong("consumerId");
		String serial = paramsObj.getString("serial");
		String address = paramsObj.getString("address");
		String note = paramsObj.getString("note");
		
		JSONArray products = paramsObj.getJSONArray("products");
		if(null == products || products.size() <= 0) {
			return WebUtil.toJsonString(StatusCode.STATUS_INVALID_PARAMS);
		}
		
		// 查询会员信息
		Consumer consumer = Consumer.findConsumer(consumerId);
		if(null == consumer) {
			return WebUtil.toJsonString(StatusCode.STATUS_FAIL);
		}
		
		ProductOrder order = new ProductOrder();
		order.setSerial(serial);
		order.setAddress(address);
		order.setNote(note);
		order.setCreateTime(new Date());
		order.setStatus(GlobalConst.ORDER_STATUS_TODO);
		order.setConsumer(consumer);
		
		// 持久化订单
		order.persist();
		
		for(int i=0; i<products.size(); i++) {
			OrderProduct product = new OrderProduct();
			JSONObject obj = products.getJSONObject(i);
			
			// 检查产品参数
			Map<String, String> productParamsMap = new HashMap<String, String>();
			productParamsMap.put("id", "Long");
			productParamsMap.put("amount", "Integer");
			productParamsMap.put("price", "Double");
			
			if (!JsonUtil.checkParams(obj, productParamsMap)) {
				return WebUtil.toJsonString(StatusCode.STATUS_INVALID_PARAMS);
			}
			
			Product productObj = Product.findProduct(obj.getLong("id"));
			if(null == productObj) {
				return WebUtil.toJsonString(StatusCode.STATUS_FAIL);
			}
			
			product.setAmount(obj.getInt("amount"));
			product.setOutAmount(0);
			product.setPrice(obj.getDouble("price"));
			product.setProduct(productObj);
			product.setProductOrder(order);
			product.persist();
		}
		
		return WebUtil.toJsonString(StatusCode.STATUS_SUCCESS);
	}

}

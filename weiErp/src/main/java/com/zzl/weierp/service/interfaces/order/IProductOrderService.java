package com.zzl.weierp.service.interfaces.order;

/**
 * 礼品订单业务接口
 * 
 * @author zhaozailin
 * 
 */
public interface IProductOrderService {

	/**
	 * 创建订单
	 * @param params
	 * {
	 * 	busiId:x, --- 经销商id
	 * 	serial:x, --- 订单编号
	 * 	address:x, --- 送货地址
	 *	note:x, --- 备注（留言） 
	 *	products:
	 *  [
	 *  	{
	 *  		id:x, --- 产品id
	 *  		amount:x, --- 产品数量 	
	 *  	},
	 *  	...
	 *  ]
	 * }
	 * @return
	 * {
	 * 	status:x --- 状态码，1：成功；0：失败；1001：不是有效的json格式；1002：不是有效的参数；
	 * }
	 */
	public String create(String params);
}

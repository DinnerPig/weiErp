package com.zzl.weierp.common.utils;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.zzl.weierp.domain.consumer.Consumer;
import com.zzl.weierp.domain.manager.Manager;

public class SessionUtil {

	public static void storeInfo(HttpSession session, Object user) {
		if(null != user) {
			if(user instanceof Consumer) {
				session.setAttribute("userId", ((Consumer)user).getId());
				
				// 是否显示优惠价
				Consumer consumer = Consumer.findConsumer(((Consumer)user).getId());
				List<Manager> managers = Manager.findManagersBySerialEquals(consumer.getShareSerial()).getResultList();
				
				// 无上级（分享编号为管理员编号），则不显示优惠价
				if(null != managers && !managers.isEmpty()) {
					session.setAttribute("prefer", false);
				}
				else {
					session.setAttribute("prefer", true);
				}
				
				// 是否显示分享金
				if(consumer.getDegree() == 2) {
					session.setAttribute("share", true);
				}
				else {
					session.setAttribute("share", false);
				}
			}
		}
	}
	
	public static Long getUserId(HttpSession session) {
		if(null == session) {
			return null;
		}
		
		Object obj = session.getAttribute("userId");
		if(null == obj) {
			return null;
		}
		
		return (Long)obj; 
	}		
}

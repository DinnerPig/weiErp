package com.zzl.weierp.common.utils;

import javax.servlet.http.HttpSession;

import com.zzl.weierp.domain.consumer.Consumer;

public class SessionUtil {

	public static void storeInfo(HttpSession session, Object user) {
		if(null != user) {
			if(user instanceof Consumer) {
				session.setAttribute("userId", ((Consumer)user).getId());
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

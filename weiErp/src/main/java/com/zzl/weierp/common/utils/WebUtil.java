package com.zzl.weierp.common.utils;

import net.sf.json.JSONObject;

import org.springframework.ui.Model;

public class WebUtil {
	/**
     * 设置分页信息
     * @param model
     * @param totalPage 总记录数
     * @param page 页码
     * @param size 
     */
    public static void setPageInfo(Model model, long totalPage, Integer page, Integer size) {
        
    	model.addAttribute("totalPage", MathUtil.getPageTotal((int)totalPage, size));
        if(null == page) {
        	page = 0;
        }
        model.addAttribute("page", page + 1);
    }
    
    /**
     * 返回状态码--字符串形式
     * @param statusCode
     * @return
     */
    public static String toJson(int statusCode) {
    	JSONObject result = new JSONObject();
    	result.put("status", statusCode);
    	return result.toString();
    }
    
    /**
     * 返回状态码--JSONObject
     * @param statusCode
     * @return
     */
    public static JSONObject toJSONObject(int statusCode) {
    	JSONObject result = new JSONObject();
    	result.put("status", statusCode);
    	return result;
    }
}

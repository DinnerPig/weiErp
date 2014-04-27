package com.zzl.weierp.common.utils;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.json.JSONObject;

public class JsonUtil {

    /**
     * 验证字符串是否为json格式
     * 
     * @param json
     * @return
     */
    public static boolean valid(String json) {
        if(null == json) {
            return false;
        }
        
        try {
            JSONObject.fromObject(json);
        } catch (Exception e) {
            return false;
        }
        
        return true;
    }
    
    /**
     * 检查json中是否含有指定参数
     * @param json
     * @param paramsMap 参数集合
     * @return
     */
    public static boolean checkParams(JSONObject json, Map<String, String> paramsMap) {
        if(null == json || null == paramsMap) {
            return false;
        }
        
        Iterator<Entry<String, String>> iter = paramsMap.entrySet().iterator();
        while(iter.hasNext()) {
            Entry<String, String> entry = iter.next();
            String param = entry.getKey();
            String paramType = entry.getValue();
            
            if(!json.has(param)) {
                return false;
            }
            
            if(!checkParamValid(json.getString(param), paramType)) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * 检查参数的数据类型是否合法
     * @param param
     * @param paramType
     * @return
     */
    private static boolean checkParamValid(String param, String paramType) {
        if(null == param || null == paramType) {
            return false;
        }
        
        try {
            if("String".equals(paramType)) {
                return true;
            }
            if("Long".equals(paramType)) {
                Long.parseLong(param);
                return true;
            }
            if("Integer".equals(paramType)) {
                Integer.parseInt(param);
                return true;
            }
            if("Double".equals(paramType)) {
                Double.parseDouble(param);
                return true;
            }
            
        } catch (NumberFormatException e) {
            // TODO log
        }
        
        return false;
    }

}

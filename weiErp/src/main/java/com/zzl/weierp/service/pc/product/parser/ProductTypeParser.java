package com.zzl.weierp.service.pc.product.parser;

import net.sf.json.JSONObject;

import com.zzl.weierp.domain.ProductType;

public class ProductTypeParser {

	public static ProductType parser(JSONObject json) {
		
		if(null == json) {
			return null;
		}
		
		ProductType type = new ProductType();
		if(json.has("id")) {
			type.setId(json.getLong("id"));
		}
		
		if(json.has("name")) {
			type.setName(json.getString("name"));
		}
		
		return type;
	}
}

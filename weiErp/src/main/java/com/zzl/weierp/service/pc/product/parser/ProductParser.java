package com.zzl.weierp.service.pc.product.parser;

import net.sf.json.JSONObject;

import com.zzl.weierp.domain.Product;

public class ProductParser {

	public static Product parser(JSONObject json) {
		
		if(null == json) {
			return null;
		}
		
		Product product = new Product();
		if(json.has("id")) {
			product.setId(json.getLong("id"));
		}
		
		if(json.has("name")) {
			product.setName(json.getString("name"));
		}
		
		if(json.has("mainImage")) {
			product.setMainImage(json.getString("mainImage"));
		}
		
		if(json.has("description")) {
			product.setDescription(json.getString("description"));
		}
		
		if(json.has("serial")) {
			product.setSerial(json.getString("serial"));
		}
		
		if(json.has("price")) {
			product.setPrice(json.getDouble("price"));
		}
		
		if(json.has("preferPrice")) {
			product.setPreferPrice(json.getDouble("preferPrice"));
		}
		
		if(json.has("shareCash")) {
			product.setShareCash(json.getDouble("shareCash"));
		}
		
		if(json.has("standard")) {
			product.setStandard(json.getString("standard"));
		}
		
		if(json.has("type")) {
			product.setType(ProductTypeParser.parser(json.getJSONObject("type")));
		}
		
		if(json.has("images")) {
			product.setImages(ProductImageParser.parserArray(json.getJSONArray("images")));
		}
		
		return product;
	}
}

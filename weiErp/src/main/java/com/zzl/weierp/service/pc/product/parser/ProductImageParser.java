package com.zzl.weierp.service.pc.product.parser;

import java.util.HashSet;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.zzl.weierp.domain.ProductImage;

public class ProductImageParser {

	public static ProductImage parser(JSONObject json) {

		if (null == json) {
			return null;
		}

		ProductImage image = new ProductImage();
		if (json.has("id")) {
			image.setId(json.getLong("id"));
		}

		if (json.has("url")) {
			image.setUrl(json.getString("url"));
		}

		return image;
	}

	public static Set<ProductImage> parserArray(JSONArray array) {

		if (null == array) {
			return null;
		}

		Set<ProductImage> images = new HashSet<ProductImage>();
		for (int i = 0; i < array.size(); i++) {
			images.add(parser(array.getJSONObject(i)));
		}

		return images;
	}
}

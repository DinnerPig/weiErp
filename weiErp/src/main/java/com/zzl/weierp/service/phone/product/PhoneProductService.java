package com.zzl.weierp.service.phone.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.zzl.weierp.common.utils.WebUtil;
import com.zzl.weierp.domain.Product;
import com.zzl.weierp.repository.product.ProductRepository;

@Service
public class PhoneProductService {

	@Autowired
	private ProductRepository productRepository;
	
	/**
	 * 分页查询
	 * @param model
	 * @param keyword
	 * @param page
	 * @param size
	 * @param typeId
	 * @return
	 */
	public List<Product> queryList(Model model, String keyword, Integer page, Integer size, Long typeId) {
		
		// 1.query total number
		long total = productRepository.count(typeId, keyword);

		// 2.set page info
		WebUtil.setPageInfo(model, total, page, size);
		
		// 3.execute query
		return productRepository.queryList(typeId, keyword, page, size);
	}
}

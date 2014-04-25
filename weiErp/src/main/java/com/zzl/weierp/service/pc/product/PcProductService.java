package com.zzl.weierp.service.pc.product;

import java.util.List;
import java.util.Set;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.zzl.weierp.common.globalConst.GlobalConst;
import com.zzl.weierp.common.utils.WebUtil;
import com.zzl.weierp.domain.Product;
import com.zzl.weierp.domain.ProductImage;
import com.zzl.weierp.domain.ProductType;
import com.zzl.weierp.repository.product.ProductImageRepository;
import com.zzl.weierp.repository.product.ProductRepository;
import com.zzl.weierp.service.pc.product.parser.ProductParser;

@Service
public class PcProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductImageRepository productImageRepository;
	
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

	/**
	 * 保存
	 * @param body
	 * @return
	 */
	@Transactional
	public String save(String body) {
		
		// check param
		if(null == body) {
			return WebUtil.toJson(GlobalConst.STATUS_FAIL);
		}
		
		// parse body
		Product product = ProductParser.parser(JSONObject.fromObject(body));
		
		// add
		if(null == product.getId()) {
			product.setType(ProductType.findProductType(product.getType().getId()));
			product.persist();
			
			// persist new images
			Set<ProductImage> images = product.getImages();
			for(ProductImage image : images) {
				image.setProduct(product);
				image.persist();
			}
			
			// persist new product
			product.setImages(images);
			product.persist();
		}
		
		// update
		else {
			Product oriProduct = Product.findProduct(product.getId());
			oriProduct.setDescription(product.getDescription());
			
			// clean ori images
			productImageRepository.deleteByProduct(product.getId());
			
			// persist new images
			Set<ProductImage> images = product.getImages();
			for(ProductImage image : images) {
				image.setProduct(oriProduct);
				image.persist();
			}
			
			// persist new product
			oriProduct.setImages(images);
			oriProduct.setName(product.getName());
			oriProduct.setPrice(product.getPrice());
			oriProduct.setSerial(product.getSerial());
			oriProduct.setStandard(product.getStandard());
			oriProduct.setType(ProductType.findProductType(product.getType().getId()));
			oriProduct.persist();
		}
		
		return WebUtil.toJson(GlobalConst.STATUS_SUCCESS);
	}

}

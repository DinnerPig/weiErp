package com.zzl.weierp.repository.product;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.zzl.weierp.domain.Product;

@Repository
public class ProductImageRepository {
	
	/**
	 * 清空某产品下的图片
	 * @param productId
	 */
	public void deleteByProduct(Long productId) {
		
		Query query = Product.entityManager().createQuery("delete from ProductImage pi where pi.product.id = :productId");
		query.setParameter("productId", productId);
		query.executeUpdate();
	}
}

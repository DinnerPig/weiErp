package com.zzl.weierp.repository.product;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.zzl.weierp.common.globalConst.GlobalConst;
import com.zzl.weierp.domain.Product;

@Repository
public class ProductRepository {

	/**
	 * 根据条件查询总记录数
	 * @param typeId 礼品类型id
	 * @param keyword 关键字
	 * @return
	 */
	public long count(Long typeId, String keyword) {
		
		if(null == keyword) {
			keyword = "";
		}
		
		String sql = "select count(*) from Product p where p.name like '%" + keyword + "%'";
		if(null != typeId) {
			sql += "and p.type.id = :typeId";
		}
		
		Query query = Product.entityManager().createQuery(sql);
		
		if(null != typeId) {
			query.setParameter("typeId", typeId);
		}
		
		return (Long) query.getSingleResult();
	}
	
	/**
	 * 分页查询
	 * @param typeId 礼品类型id
	 * @param keyword 
	 * @param page 页码
	 * @param size 每页记录数
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Product> queryList(Long typeId, String keyword, Integer page, Integer size) {
		
		if(null == keyword) {
			keyword = "";
		}
		
		if(null == page) {
			page = 0;
		}
		
		if(null == size) {
			size = GlobalConst.DEFAULT_PAGE_LIMIT;
		}
		
		String sql = "select p from Product p where p.name like '%" + keyword + "%'";
		if(null != typeId) {
			sql += "and p.type.id = :typeId";
		}
		
		Query query = Product.entityManager().createQuery(sql);
		
		if(null != typeId) {
			query.setParameter("typeId", typeId);
		}
		
		query.setFirstResult(page * size);
		query.setMaxResults(size);
		return query.getResultList();
	}
}

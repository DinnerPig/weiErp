package com.zzl.weierp.repository.order;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.zzl.weierp.common.globalConst.GlobalConst;
import com.zzl.weierp.domain.ProductOrder;

@Repository
public class OrderRepository {

	/**
	 * 根据条件查询总记录数
	 * @param consumerId 会员id
	 * @param keyword 关键字
	 * @return
	 */
	public long count(Long consumerId, String keyword, Integer status) {
		
		// status cannot null
		if(null == status) {
			return 0;
		}
		
		if(null == keyword) {
			keyword = "";
		}
		
		String sql = "select count(*) from ProductOrder p where p.status = :status and p.serial like '%" + keyword + "%'";
		if(null != consumerId) {
			sql += "and p.consumer.id = :consumerId";
		}
		
		Query query = ProductOrder.entityManager().createQuery(sql);
		query.setParameter("status", status);
		
		if(null != consumerId) {
			query.setParameter("consumerId", consumerId);
		}
		
		return (Long) query.getSingleResult();
	}
	
	/**
	 * 分页查询
	 * @param consumerId 会员id
	 * @param keyword 
	 * @param page 页码
	 * @param size 每页记录数
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ProductOrder> queryList(Long consumerId, String keyword, Integer page, Integer size, Integer status) {
		
		// status cannot null
		if(null == status) {
			return null;
		}
		
		if(null == keyword) {
			keyword = "";
		}
		
		if(null == page) {
			page = 0;
		}
		
		if(null == size) {
			size = GlobalConst.DEFAULT_PAGE_LIMIT;
		}
		
		String sql = "select p from ProductOrder p where p.status = :status and p.serial like '%" + keyword + "%'";
		if(null != consumerId) {
			sql += " and p.consumer.id = :consumerId";
		}
		
		// order by date
		sql += " order by p.createTime desc";
		
		Query query = ProductOrder.entityManager().createQuery(sql);
		query.setParameter("status", status);
		
		if(null != consumerId) {
			query.setParameter("consumerId", consumerId);
		}
		
		query.setFirstResult(page * size);
		query.setMaxResults(size);
		
		return query.getResultList();
	}

	/**
	 * 根据条件查询所有订单
	 * @param consumerId
	 * @param status
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ProductOrder> queryAll(Long consumerId, Integer status) {
		
		Query query = ProductOrder.entityManager().createQuery("select p from ProductOrder p where p.status = :status and p.consumer.id = :consumerId order by p.createTime desc");
		query.setParameter("status", status);
		query.setParameter("consumerId", consumerId);
		return query.getResultList();
	}
}

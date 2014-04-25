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
	 * @param busiId 经销商id
	 * @param keyword 关键字
	 * @return
	 */
	public long count(Long busiId, String keyword, Integer status) {
		
		// status cannot null
		if(null == status) {
			return 0;
		}
		
		if(null == keyword) {
			keyword = "";
		}
		
		String sql = "select count(*) from ProductOrder p where p.status = :status and p.serial like '%" + keyword + "%'";
		if(null != busiId) {
			sql += "and p.busi.id = :busiId";
		}
		
		Query query = ProductOrder.entityManager().createQuery(sql);
		query.setParameter("status", status);
		
		if(null != busiId) {
			query.setParameter("busiId", busiId);
		}
		
		return (Long) query.getSingleResult();
	}
	
	/**
	 * 分页查询
	 * @param busiId 经销商id
	 * @param keyword 
	 * @param page 页码
	 * @param size 每页记录数
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ProductOrder> queryList(Long busiId, String keyword, Integer page, Integer size, Integer status) {
		
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
		if(null != busiId) {
			sql += "and p.busi.id = :busiId";
		}
		
		Query query = ProductOrder.entityManager().createQuery(sql);
		query.setParameter("status", status);
		
		if(null != busiId) {
			query.setParameter("busiId", busiId);
		}
		
		query.setFirstResult(page * size);
		query.setMaxResults(size);
		
		return query.getResultList();
	}

	/**
	 * 根据条件查询所有订单
	 * @param userId
	 * @param status
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ProductOrder> queryAll(Long busiId, Integer status) {
		
		Query query = ProductOrder.entityManager().createQuery("select p from ProductOrder p where p.status = :status and p.busi.id = :busiId order by p.createTime desc");
		query.setParameter("status", status);
		query.setParameter("busiId", busiId);
		return query.getResultList();
	}
}

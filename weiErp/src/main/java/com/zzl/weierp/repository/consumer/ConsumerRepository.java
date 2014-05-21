package com.zzl.weierp.repository.consumer;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.zzl.weierp.common.globalConst.GlobalConst;
import com.zzl.weierp.domain.consumer.Consumer;

@Repository
public class ConsumerRepository {

	/**
	 * 分页查询
	 * @param page 页码
	 * @param limit 每页记录数
	 * @return
	 */
	public List<Consumer> queryList(Integer page, Integer limit) {
		
		if(null == page) {
			page = 0;
		}
		
		if(null == limit) {
			limit = GlobalConst.DEFAULT_PAGE_LIMIT;
		}
		
		TypedQuery<Consumer> query = Consumer.entityManager().createQuery("select c from Consumer c ORDER BY c.id DESC", Consumer.class);
		
		query.setFirstResult(page * limit);
		query.setMaxResults(limit);
		
		return query.getResultList();
	}
}

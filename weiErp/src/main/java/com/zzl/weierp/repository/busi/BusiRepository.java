package com.zzl.weierp.repository.busi;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.zzl.weierp.common.globalConst.GlobalConst;
import com.zzl.weierp.domain.Busi;
import com.zzl.weierp.domain.Product;

@Repository
public class BusiRepository {

	/**
	 * 根据条件查询总记录数
	 * @return
	 */
	public long count() {
		return Busi.countBusis();
	}
	
	/**
	 * 分页查询
	 * @param page 页码
	 * @param size 每页记录数
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Busi> queryList(Integer page, Integer size) {
		
		if(null == page) {
			page = 0;
		}
		
		if(null == size) {
			size = GlobalConst.DEFAULT_PAGE_LIMIT;
		}
		
		Query query = Product.entityManager().createQuery("select b from Busi b");
		
		query.setFirstResult(page * size);
		query.setMaxResults(size);
		return query.getResultList();
	}
}

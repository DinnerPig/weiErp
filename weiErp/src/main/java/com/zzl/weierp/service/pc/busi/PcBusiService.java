package com.zzl.weierp.service.pc.busi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.zzl.weierp.common.globalConst.GlobalConst;
import com.zzl.weierp.common.utils.WebUtil;
import com.zzl.weierp.domain.Busi;
import com.zzl.weierp.repository.busi.BusiRepository;

@Service
public class PcBusiService {

	@Autowired
	private BusiRepository busiRepository;
	
	/**
	 * 分页查询
	 * @param model
	 * @param keyword
	 * @param page
	 * @param size
	 * @param typeId 
	 * @return
	 */
	public List<Busi> queryList(Model model, Integer page, Integer size) {
		
		// 1.query total number
		long total = busiRepository.count();

		// 2.set page info
		WebUtil.setPageInfo(model, total, page, size);
		
		// 3.execute query
		return busiRepository.queryList(page, size);
	}

	/**
	 * 保存
	 * @param body
	 * @return
	 */
	@Transactional
	public String save(Busi busi) {
		
		// check param
		if(null == busi) {
			return WebUtil.toJson(GlobalConst.STATUS_FAIL);
		}
		
		// add
		if(null == busi.getId()) {
			busi.persist();
		}
		
		// update
		else {
			Busi oriBusi = Busi.findBusi(busi.getId());
			
			// persist new busi
			oriBusi.setUsername(busi.getUsername());
			oriBusi.setPassword(busi.getPassword());
			oriBusi.setRealname(busi.getRealname());
			oriBusi.setPhone(busi.getPhone());
			oriBusi.setQq(busi.getQq());
			oriBusi.setWeixin(busi.getWeixin());
			oriBusi.setAddress(busi.getAddress());
			oriBusi.setSerial(busi.getSerial());
			oriBusi.persist();
		}
		
		return WebUtil.toJson(GlobalConst.STATUS_SUCCESS);
	}

}

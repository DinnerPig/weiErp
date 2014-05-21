package com.zzl.weierp.service.pc.busi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzl.weierp.common.globalConst.GlobalConst;
import com.zzl.weierp.common.utils.WebUtil;
import com.zzl.weierp.domain.Busi;
import com.zzl.weierp.repository.consumer.ConsumerRepository;

@Service
public class PcBusiService {

	@Autowired
	private ConsumerRepository busiRepository;
	
	/**
	 * 保存
	 * @param body
	 * @return
	 */
	@Transactional
	public String save(Busi busi) {
		
		// check param
		if(null == busi) {
			return WebUtil.toJsonString(GlobalConst.STATUS_FAIL);
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
		
		return WebUtil.toJsonString(GlobalConst.STATUS_SUCCESS);
	}

}

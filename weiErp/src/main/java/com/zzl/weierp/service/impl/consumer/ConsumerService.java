package com.zzl.weierp.service.impl.consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.zzl.weierp.common.utils.WebUtil;
import com.zzl.weierp.domain.consumer.Consumer;
import com.zzl.weierp.repository.consumer.ConsumerRepository;
import com.zzl.weierp.service.interfaces.consumer.IConsumerService;

@Service
public class ConsumerService implements IConsumerService {

	@Autowired
	private ConsumerRepository consumerRepository;
	
	@Override
	public List<Consumer> queryList(Model model, Integer page, Integer limit) {
		
		// 总条数
		Long total = Consumer.countConsumers();
		
		// 设置分页信息
		WebUtil.setPageInfo(model, total, page, limit);
		
		// 分页查询
		return consumerRepository.queryList(page, limit);
	}

}

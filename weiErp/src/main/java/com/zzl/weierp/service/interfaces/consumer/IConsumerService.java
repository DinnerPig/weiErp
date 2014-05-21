package com.zzl.weierp.service.interfaces.consumer;

import java.util.List;

import org.springframework.ui.Model;

import com.zzl.weierp.domain.consumer.Consumer;

public interface IConsumerService {

	/**
	 * 分页查询会员列表
	 * @param model
	 * @param page
	 * @param limit
	 * @return
	 */
	public List<Consumer> queryList(Model model, Integer page, Integer limit);
}

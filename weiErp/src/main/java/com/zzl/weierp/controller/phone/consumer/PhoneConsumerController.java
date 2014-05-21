package com.zzl.weierp.controller.phone.consumer;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzl.weierp.common.globalConst.StatusCode;
import com.zzl.weierp.common.utils.SessionUtil;
import com.zzl.weierp.common.utils.WebUtil;
import com.zzl.weierp.domain.consumer.Consumer;
import com.zzl.weierp.domain.consumer.ConsumerBank;
import com.zzl.weierp.domain.consumer.ConsumerDetail;
import com.zzl.weierp.domain.record.RiseRecord;

@Controller
@RequestMapping("/phone/consumer")
public class PhoneConsumerController {

	/**
	 * 进入注册页面
	 * @return
	 */
	@RequestMapping(value = "/registerPage", method = RequestMethod.GET)
	public String registerPage() {
		return "phone/consumer/register";
	}
	
	/**
	 * 注册
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public String create(@ModelAttribute Consumer consumer) {
		
		Long id = consumer.getId();
		
		// 注册
		if(null == id) {
			
			// 判断分享人编号是否存在
			String shareSerial = consumer.getShareSerial();
			List<Consumer> list = Consumer.findConsumersBySerialEquals(shareSerial).getResultList();
			
			// 分享人编号不存在
			if(null == list || list.isEmpty()) {
				return WebUtil.toJsonString(StatusCode.STATUS_NOT_EXIST);
			}
			
			// 判断用户是否重名
			List<Consumer> oriList = Consumer.findConsumersByUsernameEquals(consumer.getUsername()).getResultList();
			
			// 用户重名
			if(null != oriList && !oriList.isEmpty()) {
				return WebUtil.toJsonString(StatusCode.STATUS_REPEAT_EXIST);
			}
			
			// 用户
			consumer.setCreateDate(new Date());
			
			// 生成随即分享编号
			consumer.setSerial(UUID.randomUUID().toString());
			
			consumer.persist();
			
			// 用户详情
			ConsumerDetail detail = consumer.getDetail();
			detail.setConsumer(consumer);
			detail.persist();
		}
		
		// 修改（修改用户详情）
		else {
			ConsumerDetail detail = consumer.getDetail();
			ConsumerDetail oriDetail = Consumer.findConsumer(id).getDetail();
			oriDetail.setAddress(detail.getAddress());
			oriDetail.setEmail(detail.getEmail());
			oriDetail.setPhone(detail.getPhone());
			oriDetail.setQq(detail.getQq());
			oriDetail.setTrueName(detail.getTrueName());
			
			oriDetail.persist();
		}
		
		return WebUtil.toJsonString(StatusCode.STATUS_SUCCESS);
	}
	
	/**
	 * 登陆
	 * @param model
	 * @param session
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, HttpSession session,
			@RequestParam String username,
			@RequestParam String password) {
		
		// 检查参数
		if(StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
			model.addAttribute("error", true);
			return "phone/busi/login";
		}
		
		// 检查用户名和密码
		List<Consumer> consumer = Consumer.findConsumersByUsernameEquals(username).getResultList();
		
		// 错误
		if(null == consumer || consumer.isEmpty() || !password.equals(consumer.get(0).getPassword())) {
			
			model.addAttribute("error", true);
			return "phone/busi/login";
		}
		
		// 设置session
		SessionUtil.storeInfo(session, consumer.get(0));
		
		// 进入菜单
		return "phone/home/main";
	}
	
	/**
	 * 升级为分享会员页面
	 * @return
	 */
	@RequestMapping(value = "/riseSharePage", method = RequestMethod.GET)
	public String riseSharePage(Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		ConsumerBank bank = Consumer.findConsumer(userId).getBank();
		
		if(null == bank) {
			bank = new ConsumerBank();
		}
		
		model.addAttribute("degree", Consumer.findConsumer(userId).getDegree());
		model.addAttribute("bank", bank);
		
		return "phone/consumer/riseShare";
	}
	
	/**
	 * 升级为分享会员
	 * @return
	 */
	@RequestMapping(value = "/applyRise", method = RequestMethod.POST)
	@ResponseBody
	public String applyRise(HttpSession session, @ModelAttribute ConsumerBank bank) {
		Long userId = (Long) session.getAttribute("userId");
		Consumer consumer = Consumer.findConsumer(userId);
		ConsumerBank oriBank = consumer.getBank();
		
		// 无银行信息
		if(null == oriBank) {
			bank.setConsumer(consumer);
			
			bank.persist();
		}
		
		// 有银行信息
		else {
			oriBank.setBank(bank.getBank());
			oriBank.setBankAccount(bank.getBankAccount());
			oriBank.setBankUser(bank.getBankUser());
			oriBank.setPayAccount(bank.getPayAccount());
			
			oriBank.persist();
		}
		
		// 创建申请记录
		RiseRecord record = new RiseRecord();
		record.setConsumer(consumer);
		record.setCreateDate(new Date());
		
		record.persist();
		
		return WebUtil.toJsonString(StatusCode.STATUS_SUCCESS);
	}
	
}

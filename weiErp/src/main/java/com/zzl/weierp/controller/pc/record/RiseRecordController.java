package com.zzl.weierp.controller.pc.record;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzl.weierp.common.globalConst.StatusCode;
import com.zzl.weierp.common.utils.WebUtil;
import com.zzl.weierp.domain.record.RiseRecord;

@Controller
@RequestMapping("/record/rise")
public class RiseRecordController {

	/**
	 * 进入升级记录页面
	 * @return
	 */
	@RequestMapping(value = "/recordPage", method = RequestMethod.GET)
	public String recordPage() {
		return "pc/record/riseRecordPage";
	}
	
	/**
	 * 查询记录列表
	 * @return
	 */
	@RequestMapping(value = "/records", method = RequestMethod.GET)
	public String records(Model model) {
		model.addAttribute("records", RiseRecord.findAllRiseRecords());
		return "pc/record/riseRecords";
	}
	
	/**
	 * 查询记录列表
	 * @return
	 */
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String remove(@PathVariable Long id) {
		RiseRecord.findRiseRecord(id).remove();
		return WebUtil.toJsonString(StatusCode.STATUS_SUCCESS);
	}
}

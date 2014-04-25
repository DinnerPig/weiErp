package com.zzl.weierp.common.utils;

import java.util.Random;

import com.zzl.weierp.common.globalConst.GlobalConst;

public class MathUtil {
	public static int getPageTotal(int total, Integer size) {

		int pageTotal = 1;

		/*
		 * 默认每页10条
		 */
		if (null == size) {
			size = GlobalConst.DEFAULT_PAGE_LIMIT;
		}
		if (total != 0) {

			if (total % size == 0) {
				pageTotal = total / size;
			} else {
				pageTotal = total / size + 1;
			}
		}

		return pageTotal;
	}

	/**
	 * 生成随即数
	 * 
	 * @param length
	 *            长度
	 * @return
	 */
	public static String getRandom(int length) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			Random r = new Random();
			sb.append(r.nextInt(10));
		}
		return sb.toString();
	}
}

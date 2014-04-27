package com.zzl.weierp.common.globalConst;

/**
 * 全局状态码
 * 
 * @author zhaozailin
 * 
 */
public class StatusCode {
	
	// 成功
	public static final int STATUS_SUCCESS = 1;

	// 失败
	public static final int STATUS_FAIL = 0;

	// session过期
	public static final int STATUS_SESSION_TIMEOUT = -3;

	// 不是有效的json格式
	public static final int STATUS_INVALID_JSON = 1001;

	// 不是有效的参数
	public static final int STATUS_INVALID_PARAMS = 1002;

	// 文件删除失败
	public static final int STATUS_FILE_DELETE_FAIL = 1003;

	// 数据库记录不存在
	public static final int STATUS_NOT_EXIST = 1004;

	// 权限不足
	public static final int STATUS_LACK_AUTHORITY = 1005;

	// 文件操作失败
	public static final int STATUS_FILE_ERROR = 1006;

}

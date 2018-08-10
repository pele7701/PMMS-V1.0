package com.pele.pmms;
/**
 * 常量定义
 * @author beili
 *
 */
public interface Constant {

	/**数据库字段值常量*/
	interface TbColumn{
		/**state 有效*/
		String STATE_VALID = "Y";
		/**state 无效*/
		String STATE_INVALID = "N";
	}
	
	interface Dao{
		/** 分页时如果没有取到当前页码则使用默认页码*/
		int DEFAULT_PAGE_NUMBER = 1;
	}
}

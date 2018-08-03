package com.pele.pmms.util;
/**
 * 公共工具类，提供静态方法
 * @author beili
 *
 */
public class CommonUtil {

	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmptyString(String str){
		if(str != null && !str.equals("") && !str.trim().equals("")){
			return true;
		}else{
			return false;
		}
	}
}

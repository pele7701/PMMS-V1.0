package com.pele.pmms.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.Map;

import org.nutz.ioc.impl.PropertiesProxy;

/**
 * 公共工具类，提供静态方法
 * @author beili
 *
 */
public class CommonUtil {
	
	/**
	 * 读取app.Properties的代理对象
	 */
	private static PropertiesProxy appPropertiesProxy = null;
	
	static{
		//类加载时指定app.Properties文件路径初始化appPropertiesProxy
		appPropertiesProxy = new PropertiesProxy();
		appPropertiesProxy.setPaths("app.properties");
	}

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
	
	/**
	 * 判断集合是否为空，如果为空返回true，如果不为空返回false
	 * @param list
	 * @return
	 */
	public static boolean isNotEmptyCollection(Collection<?> collection) {
		if (null != collection && collection.size() > 0) {
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Map非空判断，如果map为空返回false，如果map不为空，返回true
	 * @param map
	 * @return boolean
	 */
	public static boolean isNotEmptyMap(Map<?, ?> map) {
		if (null != map && map.size() > 0) {
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 从app.Properties获取值
	 * @param key
	 * @return
	 */
	public static String getAppPropertiesVal(String key){
		String val = "";
		if(appPropertiesProxy != null && CommonUtil.isNotEmptyString(key)){
			val = appPropertiesProxy.get(key);
		}
		return val;
	}
	
	/**
	 * 获取默认分页记录数
	 * @return
	 */
	public static int getDefaulPageRowSize(){
		int size = 50;
		try {
			String defaulPageRowSize = getAppPropertiesVal("defaulPageRowSize");
			size = Integer.parseInt(defaulPageRowSize);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return size;
	}
	
	/**
	 * 获取异常信息字符串
	 * @param e
	 * @return
	 */
	public static String getExceptionStr(Exception e){
		String exceptionInfo = "";
		Writer strWriter = null;
		PrintWriter printWriter = null;
		try {
			if(e != null){
				strWriter = new StringWriter();
				printWriter = new PrintWriter(strWriter);
				e.printStackTrace(printWriter);
				exceptionInfo = strWriter.toString();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}finally{
			if(printWriter != null){
				try {
					printWriter.close();
					printWriter = null;
				} catch (Exception e3) {
				}
			}
			if(strWriter != null){
				try {
					strWriter.close();
					strWriter = null;
				} catch (Exception e3) {
				}
			}
		}
		return exceptionInfo;
	}
	
}

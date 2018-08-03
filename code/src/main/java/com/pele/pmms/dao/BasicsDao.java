package com.pele.pmms.dao;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;

/**
 * dao基类,其他dao继承此类，实现统一注入daoTemplate
 * @author beili
 *
 */
public class BasicsDao {

	@Inject("daoTemplate")
	protected Dao daoTemplate;
	
	
}

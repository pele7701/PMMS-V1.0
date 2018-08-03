package com.pele.pmms;

import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.ioc.provider.ComboIocProvider;
/**
 * 主模块
 * @author beili
 *
 */
@IocBy(type = ComboIocProvider.class,
args = {"*js",
		"dao.js",
		"*anno",
        "com.pele.pmms"
	})
@Modules
public class MainModule {}

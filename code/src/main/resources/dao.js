var ioc = {
	daoTemplate : {
		type : "org.nutz.dao.impl.NutDao",
		args : [ {
			refer : "dataSource"
		} ],
		fields : {
			interceptors : [ "log", // 默认的日志还需要的
			"time"// , // 加个时间又如何呢?
			// "net.demo.MyDaoInterceptor", //加入自己的,才合适
			// {refer:"superI"} // 引用另外一个bean作为拦截器
			]
		}
	},
	dataSource : {
		type : "com.alibaba.druid.pool.DruidDataSource",
		events : {
			depose : 'close'
		},
		fields : {
			url : "jdbc:sqlite:F:/BOM/DB/PMMS_DB.db",
			// username : "enzozhong",
			// password : "123",
			maxWait : 15000, // 若不配置此项,如果数据库未启动,druid会一直等可用连接,卡住启动过程
			defaultAutoCommit : false
		// 提高fastInsert的性能
		}
	}
}
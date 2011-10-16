var ioc = {
	dataSource : {
		type :"org.apache.commons.dbcp.BasicDataSource",
		events : {
			depose :"close"
		},
		fields : {
			driverClassName : 'org.h2.Driver',
			url             : 'jdbc:mysql://localhost:3306/pos?useUnicode=true&amp;characterEncoding=utf-8',
			username        : 'pos',
			password        : 'pos',
			initialSize     : 10,
			maxActive       : 100,
			testOnReturn    : true,
			//validationQueryTimeout : 5,
			validationQuery : "select 1"
		}
	},
    dao : {
        type : "org.nutz.dao.impl.NutDao",
        fields : {
        	dataSource : {refer : 'dataSource'}
        }
    }
}
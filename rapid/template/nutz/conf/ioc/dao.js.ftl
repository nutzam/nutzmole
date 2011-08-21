var ioc = {
	dataSource : {
		type :"org.apache.commons.dbcp.BasicDataSource",
		events : {
			depose :"close"
		},
		fields : {
			driverClassName : '${jdbc_driver}',
			url             : '${jdbc_url}',
			username        : '${jdbc_username}',
			password        : '${jdbc_password}',
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
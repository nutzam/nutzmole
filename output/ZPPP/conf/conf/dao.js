var ioc = {
	/*定义数据源*/
	dataSource : {
		type :"org.apache.commons.dbcp.BasicDataSource",
		events : {
			depose :"close"
		},
		fields : {
			driverClassName : 'org.h2.Driver',
			url             : 'jdbc:h2:file:test',
			username        : 'sa',
			password        : '',
			initialSize     : 10,
			maxActive       : 100,
			testOnReturn    : true,
			//validationQueryTimeout : 5,
			validationQuery : "select 1"
		}
	},
    /*定义NutDao*/
    dao : {
        type : "org.nutz.dao.impl.NutDao",
        fields : {
        	dataSource : {refer : 'dataSource'}
        }
    }
}
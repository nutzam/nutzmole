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
			minIdle         : 10,
			maxIdle         : 20,
			defaultAutoCommit: false,
			
			//validationQueryTimeout : 5,
			<#if jdbc_url?starts_with('jdbc:oracle:')>
			validationQuery : "select 1 from dual"
			<#else>
			validationQuery : "select 1"
			</#if>
		}
	},
    dao : {
        type : "org.nutz.dao.impl.NutDao",
        fields : {
        	dataSource : {refer : 'dataSource'}
        }
    }
}
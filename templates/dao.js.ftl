var ioc = {
		/*定义数据源,这里使用的是国产的优秀连接池BoneCP*/
        dataSource : {
                type : "com.jolbox.bonecp.BoneCPDataSource",
                events : {
                        depose : 'close'
                },
                fields : {
                        driverClass : '${db_driver}',
                        jdbcUrl : '${db_url}',
                        username : '${db_username}',
                        password : '${db_password}',
                        minConnectionsPerPartition : 5 ,
                        maxConnectionsPerPartition : 20
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
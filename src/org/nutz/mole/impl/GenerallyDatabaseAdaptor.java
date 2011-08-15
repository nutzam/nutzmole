package org.nutz.mole.impl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mole.DatabaseAdaptor;
import org.nutz.mole.MoleContext;
import org.nutz.mole.mapping.ZField;
import org.nutz.mole.mapping.ZTable;

public class GenerallyDatabaseAdaptor implements DatabaseAdaptor {
	
	private static final Log logger = Logs.get();
	
	public MoleContext fromDb(MoleContext context){
		Connection connection = null;
		ConfigPool config = context.getConfig();
		try {
			Class.forName(config.project.getProperty("db_driver"));
			connection = DriverManager.getConnection(config.project.getProperty("db_url"), 
					config.project.getProperty("db_username"), 
					config.project.getProperty("db_password"));
			connection.setReadOnly(true);
			DatabaseMetaData metaData = connection.getMetaData();
			String []para=new String[1];
		    para[0] = "TABLE";
		    ResultSet tableResultset = metaData.getTables(config.project.getProperty("db_catalog"), null, null, para);
		    List<ZTable> tables = new ArrayList<ZTable>(tableResultset.getRow());
		    while( tableResultset.next() ){
		    	ZTable zTable = new ZTable();
		    	tables.add(zTable);
		    	zTable.setTableName(tableResultset.getString("TABLE_NAME"));
		    	zTable.setClassName(config.tableMapping.getProperty(zTable.getTableName()));
		    	if (zTable.getClassName() == null) {
		    		zTable.setClassName(toName(zTable.getTableName()));
		    	}
		    }
		    logger.infof("Load %d tables",tables.size());
		    for (ZTable zTable : tables) {
		    	Set<String> pks = new HashSet<String>();
		    	ResultSet pkResultSet = metaData.getPrimaryKeys(null, null, zTable.getTableName());
	    		while(pkResultSet.next()) {
	    			pks.add(pkResultSet.getString("COLUMN_NAME"));
	    		}
		    	
		    	ResultSet columnResultset = metaData.getColumns(null, null, zTable.getTableName(), null);
		    	while(columnResultset.next()) {
		    		ZField zField = new ZField();
		    		zField.dbFieldName = columnResultset.getString("COLUMN_NAME");
		    		zField.notNull = "NO".equals(columnResultset.getString("IS_NULLABLE"));
		    		zField.dbFieldType = columnResultset.getString("TYPE_NAME");
		    		zField.fieldName = config.tableFieldMapping.getProperty(zTable.getTableName()+"."+zField.dbFieldName);
		    		if (zField.fieldName == null)
		    			zField.fieldName = config.tableFieldMapping.getProperty("*."+zField.dbFieldName);
		    		if (zField.fieldName == null)
		    			zField.fieldName = Strings.lowerFirst(toName(zField.dbFieldName));
		    		if (pks.contains(zField.dbFieldName))
		    			zField.primaryKey = true;
		    		
		    		//推断字段的Java类型
		    		zField.classTypeName = config.typeMapping.getProperty(zField.dbFieldType);
		    		if (zField.classTypeName == null) {
		    			logger.warnf("Unkown type_name %s.%s, skip!",zTable.getTableName(),zField.dbFieldName);
		    			continue;
		    		}

		    		zTable.getFields().add(zField);
		    	}
			}
		    //return tables;
		    return context;
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (Throwable e) {}
		}
		return null;
	}
	
	@Override
	public void toTarget(MoleContext context) {
		new PojoCreater().create(context);
		new HelpFileCreater().create(context);
	}

	public static final String toName(String srcName){
		if (Strings.isBlank(srcName))
			return "";
		srcName = srcName.toLowerCase();
		if (srcName.startsWith("t_"))
			srcName = srcName.substring(2);
		if (srcName.startsWith("tb_"))
			srcName = srcName.substring(3);
		String[] names = srcName.split("_");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < names.length; i++) {
			sb.append(Strings.capitalize(names[i]));
		}
		return sb.toString();
	}
}

package org.nutz.mole.impl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.nutz.json.Json;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mole.ConfigPool;
import org.nutz.mole.DatabaseAdaptor;
import org.nutz.mole.MoleContext;
import org.nutz.mole.meta.ZField;
import org.nutz.mole.meta.ZTable;

public class GenerallyDatabaseAdaptor implements DatabaseAdaptor {

	private static final Log log = Logs.get();

	public MoleContext fromDb(MoleContext context) {
		Connection connection = null;
		ConfigPool config = context.getConfig();
		try {
			//获取数据库连接
			Class.forName(config.getProject().get("db_driver"));
			connection = DriverManager.getConnection(	config.getProject().get("db_url"),
														config.getProject().get("db_username"),
														config.getProject().get("db_password"));
			connection.setReadOnly(true);
			//获取数据库的元数据
			DatabaseMetaData metaData = connection.getMetaData();
			ResultSet tableResultset = metaData.getTables(	null,
															null,
															null,
															new String[]{"TABLE"});
			//开始遍历全部结果(即全部表)
			List<ZTable> tables = new ArrayList<ZTable>(10);
			while (tableResultset.next()) {
				ZTable zTable = new ZTable();
				tables.add(zTable);
				zTable.setTableName(tableResultset.getString("TABLE_NAME"));
				//查询表名-->类名映射
				zTable.setClassName(config.getTableMapping().get(zTable.getTableName()));
				if (zTable.getClassName() == null) {
					zTable.setClassName(toName(zTable.getTableName()));
				}
				zTable.setComment(tableResultset.getString("REMARKS"));
			}
			//把信息打印一下,这样用户比较清晰
			if(log.isInfoEnabled())
				log.infof("Load %d tables", tables.size());
			if(log.isDebugEnabled())
				log.debug("Tables:\n"+Json.toJson(tables));
			//好了,开始找字段
			for (ZTable zTable : tables) {
				//先来找找主键
				Set<String> pks = new HashSet<String>();
				ResultSet pkResultSet = metaData.getPrimaryKeys(null, null, zTable.getTableName());
				while (pkResultSet.next()) {
					pks.add(pkResultSet.getString("COLUMN_NAME"));
				}

				ResultSet columnResultset = metaData.getColumns(null,
																null,
																zTable.getTableName(),
																null);
				while (columnResultset.next()) {
					ZField zField = new ZField();
					zField.dbFieldName = columnResultset.getString("COLUMN_NAME");
					zField.notNull = "NO".equals(columnResultset.getString("IS_NULLABLE"));
					zField.dbFieldType = columnResultset.getString("TYPE_NAME");
					zField.fieldName = config.getTableFieldMapping().get(zTable.getTableName()
																			+ "."
																			+ zField.dbFieldName);
					if (zField.fieldName == null)
						zField.fieldName = config.getTableFieldMapping().get("*."
																				+ zField.dbFieldName);
					if (zField.fieldName == null)
						zField.fieldName = Strings.lowerFirst(toName(zField.dbFieldName));
					if (pks.contains(zField.dbFieldName))
						zField.primaryKey = true;

					// 推断字段的Java类型
					zField.classTypeName = config.getTypeMapping().get(zField.dbFieldType);
					if (zField.classTypeName == null) {
						log.warnf(	"Unkown type_name %s.%s, skip!",
										zTable.getTableName(),
										zField.dbFieldName);
						continue;
					}
					zTable.getFields().add(zField);
				}
			}
			// return tables;
			context.setTables(tables);
			return context;
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		finally {
			if (connection != null)
				try {
					connection.close();
				}
				catch (Throwable e) {}
		}
		return null;
	}

	@Override
	public void toTarget(MoleContext context) {
		new PojoCreater().create(context);
		new HelpFileCreater().create(context);
	}

	public static final String toName(String srcName) {
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

package org.nutz.mole.mapping;

import java.util.ArrayList;
import java.util.List;

public class ZTable {

	public String dbTableName;
	public String className;
	public List<ZField> fields = new ArrayList<ZField>();
	
	
	public String getDbTableName() {
		return dbTableName;
	}
	public void setDbTableName(String dbTableName) {
		this.dbTableName = dbTableName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public List<ZField> getFields() {
		return fields;
	}
	public void setFields(List<ZField> fields) {
		this.fields = fields;
	}
	
	
}

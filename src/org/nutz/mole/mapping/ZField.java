package org.nutz.mole.mapping;

public class ZField {

	public String dbFieldName;
	public String fieldName;
	public String dbFieldType;
	public String classTypeName;
	public boolean primaryKey;
	public boolean unique;
	public boolean notNull;
	public boolean unsign;
	
	
	public String getDbFieldName() {
		return dbFieldName;
	}
	public void setDbFieldName(String dbFieldName) {
		this.dbFieldName = dbFieldName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getDbFieldType() {
		return dbFieldType;
	}
	public void setDbFieldType(String dbFieldType) {
		this.dbFieldType = dbFieldType;
	}
	public String getClassTypeName() {
		return classTypeName;
	}
	public void setClassTypeName(String classTypeName) {
		this.classTypeName = classTypeName;
	}
	public boolean isPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(boolean primaryKey) {
		this.primaryKey = primaryKey;
	}
	public boolean isUnique() {
		return unique;
	}
	public void setUnique(boolean unique) {
		this.unique = unique;
	}
	public boolean isNotNull() {
		return notNull;
	}
	public void setNotNull(boolean notNull) {
		this.notNull = notNull;
	}
	public boolean isUnsign() {
		return unsign;
	}
	public void setUnsign(boolean unsign) {
		this.unsign = unsign;
	}
	
	
}

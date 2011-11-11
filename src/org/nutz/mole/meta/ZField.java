package org.nutz.mole.meta;

import lombok.Data;

@Data
public class ZField {

	public String dbFieldName;
	public String fieldName;
	public String dbFieldType;
	public String classTypeName;
	public boolean isPrimaryKey;
	public boolean unique;
	public boolean notNull;
	public boolean unsign;
	//注释
	public String comment;
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
		return isPrimaryKey;
	}
	public void setPrimaryKey(boolean isPrimaryKey) {
		this.isPrimaryKey = isPrimaryKey;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}

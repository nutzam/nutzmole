package org.nutz.mole.meta;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ZTable {

	private String tableName;
	private String className;
	
	private String fkCatalog; //FKTABLE_CAT
	private String fkSchema; //FKTABLE_SCHEM
	private String fkTableName; //FKTABLE_NAME
	private String fkColumnName; //FKCOLUMN_NAME
	private String pkColumnName; //PKCOLUMN_NAME
	private String fkName; //FK_NAME
	private short keySeq; //KEY_SEQ
	
	private List<ZField> fields = new ArrayList<ZField>();
	
	//其他信息
	private String comment;
	private String catalog;
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getFkCatalog() {
		return fkCatalog;
	}
	public void setFkCatalog(String fkCatalog) {
		this.fkCatalog = fkCatalog;
	}
	public String getFkSchema() {
		return fkSchema;
	}
	public void setFkSchema(String fkSchema) {
		this.fkSchema = fkSchema;
	}
	public String getFkTableName() {
		return fkTableName;
	}
	public void setFkTableName(String fkTableName) {
		this.fkTableName = fkTableName;
	}
	public String getFkColumnName() {
		return fkColumnName;
	}
	public void setFkColumnName(String fkColumnName) {
		this.fkColumnName = fkColumnName;
	}
	public String getPkColumnName() {
		return pkColumnName;
	}
	public void setPkColumnName(String pkColumnName) {
		this.pkColumnName = pkColumnName;
	}
	public String getFkName() {
		return fkName;
	}
	public void setFkName(String fkName) {
		this.fkName = fkName;
	}
	public short getKeySeq() {
		return keySeq;
	}
	public void setKeySeq(short keySeq) {
		this.keySeq = keySeq;
	}
	public List<ZField> getFields() {
		return fields;
	}
	public void setFields(List<ZField> fields) {
		this.fields = fields;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCatalog() {
		return catalog;
	}
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
	
	
}


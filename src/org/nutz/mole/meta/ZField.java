package org.nutz.mole.meta;

import lombok.Data;

@Data
public class ZField {

	public String dbFieldName;
	public String fieldName;
	public String dbFieldType;
	public String classTypeName;
	public boolean primaryKey;
	public boolean unique;
	public boolean notNull;
	public boolean unsign;
	
}

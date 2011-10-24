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
}


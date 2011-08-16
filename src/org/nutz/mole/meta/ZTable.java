package org.nutz.mole.meta;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ZTable {

	private String tableName;
	private String className;
	private List<ZField> fields = new ArrayList<ZField>();
	
	//其他信息
	private String comment;
	private String catalog;
}

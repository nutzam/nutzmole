package org.nutz.mole.impl;

import java.util.HashMap;
import java.util.Map;

import org.nutz.mole.Creator;
import org.nutz.mole.MoleContext;
import org.nutz.mole.mapping.ZTable;

public class PojoCreater implements Creator {

	public void create (MoleContext context){
		String pathRoot = context.getConfig().project.getProperty("srcFileRoot")+"bean/";
		Map<String, Object> datas = new HashMap<String, Object>();
		datas.put("packageName", context.getConfig().project.get("packageName"));
		for (ZTable zTable : context.getTables()) {
			datas.put("zTable", zTable);
			FreemarkerHelp.make(pathRoot+zTable.getClassName()+".java", "POJO.ftl", datas);
		}
	}
}

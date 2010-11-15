package org.nutz.mole.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.mole.mapping.ZTable;

public class PojoCreater {

	public void create (ConfigPool config, List<ZTable> tables){
		String pathRoot = config.project.getProperty("srcFileRoot")+"bean/";
		Map<String, Object> datas = new HashMap<String, Object>();
		datas.put("packageName", config.project.get("packageName"));
		for (ZTable zTable : tables) {
			datas.put("zTable", zTable);
			FreemarkerHelp.make(pathRoot+zTable.className+".java", "POJO.ftl", datas);
		}
	}
}

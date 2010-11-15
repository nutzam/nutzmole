package org.nutz.mole.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.mole.mapping.ZTable;

public class ModuleCreater {

	public void create (ConfigPool config, List<ZTable> tables){
		String pathRoot = config.project.getProperty("srcFileRoot")+"module/";
		Map<String, Object> datas = new HashMap<String, Object>();
		datas.put("packageName", config.project.get("packageName"));
		for (ZTable zTable : tables) {
			datas.put("zTable", zTable);
			FreemarkerHelp.make(pathRoot+zTable.className+"Module.java", "Module.ftl", datas);
		}
		FreemarkerHelp.make(config.project.getProperty("srcFileRoot")+"MainModule.java", "MainModule.ftl", datas);
	}
}

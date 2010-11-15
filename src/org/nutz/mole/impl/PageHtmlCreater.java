package org.nutz.mole.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.mole.mapping.ZTable;

public class PageHtmlCreater {

	public void create (ConfigPool config, List<ZTable> tables){
		String pathRoot = config.project.getProperty("projectRoot")+"WebContent/page/";
		Map<String, Object> datas = new HashMap<String, Object>();
		for (ZTable zTable : tables) {
			datas.put("zTable", zTable);
			FreemarkerHelp.make(pathRoot+zTable.className+".html", "Page.html.ftl", datas);
		}
	}
}

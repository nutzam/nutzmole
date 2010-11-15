package org.nutz.mole.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.lang.Files;
import org.nutz.mole.mapping.ZTable;

public class HelpFileCreater {

	/**
	 * 创建web.xml
	 * 创建dao.js
	 * 创建index.html
	 * @param config
	 * @param tables
	 */
	public void create (ConfigPool config, List<ZTable> tables){
		Map<String, Object> datas = new HashMap<String, Object>();
		datas.put("packageName", config.project.get("packageName"));
		FreemarkerHelp.make(config.project.getProperty("projectRoot")+"WebContent/WEB-INF/web.xml", "web.xml.ftl", datas);

		datas.put("db_driver", config.project.getProperty("db_driver"));
		datas.put("db_url", config.project.getProperty("db_url"));
		datas.put("db_username", config.project.getProperty("db_username"));
		datas.put("db_password", config.project.getProperty("db_password"));
		FreemarkerHelp.make(config.project.getProperty("projectRoot")+"conf/conf/dao.js", "dao.js.ftl", datas);
		
		datas.put("projectName", config.project.getProperty("projectName"));
		datas.put("zTables", tables);
		FreemarkerHelp.make(config.project.getProperty("projectRoot")+"WebContent/index.html", "index.html.ftl", datas);
		
		
		
		
		try {
			Files.copyDir(new File("./lib"), new File(config.project.getProperty("projectRoot")+"WebContent/WEB-INF/lib/"));
			Files.copyDir(new File("./templates/js"), new File(config.project.getProperty("projectRoot")+"WebContent/js/"));
			Files.copyFile(new File("./templates/log4j.properties"), new File(config.project.getProperty("projectRoot")+"conf/log4j.properties"));
			Files.copyFile(new File("./templates/msg.properties"), new File(config.project.getProperty("projectRoot")+"conf/msg/msg.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

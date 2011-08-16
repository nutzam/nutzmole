package org.nutz.mole.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.lang.Files;
import org.nutz.mole.ConfigPool;
import org.nutz.mole.Creator;
import org.nutz.mole.MoleContext;
import org.nutz.mole.meta.ZTable;

public class HelpFileCreater implements Creator {

	/**
	 * 创建web.xml 创建dao.js 创建index.html
	 */
	public void create(MoleContext context) {
		ConfigPool config = context.getConfig();
		List<ZTable> tables = context.getTables();
		Map<String, Object> datas = new HashMap<String, Object>();
		datas.put("packageName", config.getProject().get("packageName"));
		FreemarkerHelp.make(config.getProject().get("projectRoot")
							+ "WebContent/WEB-INF/web.xml", "web.xml.ftl", datas);
		FreemarkerHelp.make(config.getProject().get("srcFileRoot")
							+ "MainModule.java", "MainModule.ftl", datas);

		datas.put("db_driver", config.getProject().get("db_driver"));
		datas.put("db_url", config.getProject().get("db_url"));
		datas.put("db_username", config.getProject().get("db_username"));
		datas.put("db_password", config.getProject().get("db_password"));
		FreemarkerHelp.make(config.getProject().get("projectRoot") + "conf/conf/dao.js",
							"dao.js.ftl",
							datas);

		datas.put("projectName", config.getProject().get("projectName"));
		datas.put("zTables", tables);
		FreemarkerHelp.make(config.getProject().get("projectRoot") + "WebContent/index.html",
							"index.html.ftl",
							datas);

		try {
			Files.copyDir(new File("./lib"), new File(config.getProject().get("projectRoot")
														+ "WebContent/WEB-INF/lib/"));
			Files.copyDir(	new File("./templates/js"),
							new File(config.getProject().get("projectRoot") + "WebContent/js/"));
			Files.copyFile(	new File("./templates/log4j.properties"),
							new File(config.getProject().get("projectRoot")
										+ "conf/log4j.properties"));
			Files.copyFile(	new File("./templates/msg.properties"),
							new File(config.getProject().get("projectRoot")
										+ "conf/msg/msg.properties"));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}

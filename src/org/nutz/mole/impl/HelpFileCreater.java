package org.nutz.mole.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.lang.Files;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mole.ConfigPool;
import org.nutz.mole.Creator;
import org.nutz.mole.MoleContext;
import org.nutz.mole.meta.ZTable;

public class HelpFileCreater implements Creator {

	private static final Log log = Logs.get();
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
		log.debugf("输出Dao配置文件:%s", config.getProject().get("projectRoot") + "conf/conf/dao.js");
		FreemarkerHelp.make(config.getProject().get("projectRoot") + "conf/conf/dao.js",
							"dao.js.ftl",
							datas);

		
		datas.put("projectName", config.getProject().get("projectName"));
		datas.put("zTables", tables);
		log.debugf("输出首页文件:%s",config.getProject().get("projectRoot") + "WebContent/index.html");
		FreemarkerHelp.make(config.getProject().get("projectRoot") + "WebContent/index.html",
							"index.html.ftl",
							datas);

		try {
			log.debug("准备复制库文件");
			Files.copyDir(new File("./lib"), new File(config.getProject().get("projectRoot")
														+ "WebContent/WEB-INF/lib/"));
			log.debug("准备复制JS文件");
			Files.copyDir(	new File("./templates/js"),
							new File(config.getProject().get("projectRoot") + "WebContent/js/"));
			log.debug("准备复制log4j配置文件");
			Files.copyFile(	new File("./templates/log4j.properties"),
							new File(config.getProject().get("projectRoot")
										+ "conf/log4j.properties"));
			log.debug("准备复制多国语言配置文件");
			Files.copyFile(	new File("./templates/msg.properties"),
							new File(config.getProject().get("projectRoot")
										+ "conf/msg/msg.properties"));
			log.debug("所有操作完成.恭喜.");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package org.nutz.mole;

import java.util.List;

import org.nutz.json.Json;
import org.nutz.mole.impl.ConfigPool;
import org.nutz.mole.impl.Convert2DTable;
import org.nutz.mole.impl.HelpFileCreater;
import org.nutz.mole.impl.Init;
import org.nutz.mole.impl.ModuleCreater;
import org.nutz.mole.impl.PageHtmlCreater;
import org.nutz.mole.impl.PojoCreater;
import org.nutz.mole.mapping.ZTable;

public class ZMole {
	
	static ConfigPool configPool = new ConfigPool();

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Throwable {
		//加载配置,检验配置
		configPool.load();
		//初始化项目结构
		new Init().init(configPool);
		//获取数据库表结构,构建DTable
		List<ZTable> tables = new Convert2DTable().convert(configPool);
	    System.out.println(Json.toJson(tables));
		//生成POJO
		new PojoCreater().create(configPool, tables);
		//生成Module
		new ModuleCreater().create(configPool, tables);
		//生成页面
		new PageHtmlCreater().create(configPool, tables);
		//生成辅助文件
		new HelpFileCreater().create(configPool, tables);
	}

}

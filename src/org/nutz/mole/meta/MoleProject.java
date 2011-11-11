package org.nutz.mole.meta;

import org.nutz.ioc.impl.PropertiesProxy;

import lombok.Data;

/**
 * 描述项目的总体配置信息
 * @author wendal
 *
 */
@Data
public class MoleProject {

	/**
	 * 项目的名字
	 */
	private String name;
	/**
	 * 顶层package名
	 */
	private String packageName;
	/**
	 * 输出路径名
	 */
	private String output;
	
	//数据库的配置
	
	private String db_driver;
	private String db_url;
	private String db_username;
	private String db_password;
	private String db_catalog;
	
	public MoleProject(PropertiesProxy pp) {
		if (pp == null)
			pp = new PropertiesProxy();
		this.name = pp.get("name", "nutz_abc");
		this.packageName = pp.get("packageName","com.nutzabc");
		this.output = pp.get("output","output");
		
		//DB信息:
		this.db_driver =   pp.get("db_driver","org.h2.Driver");
		this.db_url =      pp.get("db_url","jdbc:h2:file:test");
		this.db_username = pp.get("db_username","sa");
		this.db_password = pp.get("db_password","sa");
		this.db_catalog =  pp.get("db_catalog",null);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getDb_driver() {
		return db_driver;
	}

	public void setDb_driver(String db_driver) {
		this.db_driver = db_driver;
	}

	public String getDb_url() {
		return db_url;
	}

	public void setDb_url(String db_url) {
		this.db_url = db_url;
	}

	public String getDb_username() {
		return db_username;
	}

	public void setDb_username(String db_username) {
		this.db_username = db_username;
	}

	public String getDb_password() {
		return db_password;
	}

	public void setDb_password(String db_password) {
		this.db_password = db_password;
	}

	public String getDb_catalog() {
		return db_catalog;
	}

	public void setDb_catalog(String db_catalog) {
		this.db_catalog = db_catalog;
	}
	
	
	
}

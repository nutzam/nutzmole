package org.nutz.mole.impl;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigPool {

	public static final String configPath = "conf";
	public final Properties project = new Properties();
	public final Properties templete = new Properties();
	public final Properties typeMapping = new Properties();
	public final Properties tableMapping = new Properties();
	public final Properties tableFieldMapping = new Properties();
	public final Properties other = new Properties();
	
	public void load() throws Throwable {
		project.load(new FileInputStream("conf/project.properties"));
		templete.load(new FileInputStream("conf/templates.properties"));
		typeMapping.load(new FileInputStream("conf/type-mapping.properties"));
		tableMapping.load(new FileInputStream("conf/table-mapping.properties"));
		tableFieldMapping.load(new FileInputStream("conf/table-field-mapping.properties"));
		other.load(new FileInputStream("conf/other.properties"));
		
		String output = project.getProperty("output","output/");
		if (!output.endsWith("/"))
			output += "/";
		project.put("output", output);
		
		project.put("projectRoot", output+project.getProperty("projectName","Test")+"/");
		project.put("srcFileRoot", project.getProperty("projectRoot")+"src/"+project.getProperty("packageName","org.test.z").replace('.', '/')+"/");
	}
}

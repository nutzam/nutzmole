package org.nutz.mole.impl;

import java.io.File;

import org.nutz.lang.Files;

public class Init {

	/**
	 * 初始化目录结构
	 * @param config
	 */
	public void init(ConfigPool config) {
		String projectName = config.project.getProperty("projectName");
//		String packageName = config.project.getProperty("packageName");
		String output = config.project.getProperty("output","output/");
		if (!output.endsWith("/"))
			output += "/";
		System.out.println(output);
//		Files.makeDir(new File(output));
//		Files.makeDir(new File(output+projectName+"/"));
//
//		Files.makeDir(new File(output+projectName+"/src/"+packageName.replace('.', '/')+"/"));
//		Files.makeDir(new File(output+projectName+"/src/"+packageName.replace('.', '/')+"/module"));
//		Files.makeDir(new File(output+projectName+"/src/"+packageName.replace('.', '/')+"/bean"));
//		Files.makeDir(new File(output+projectName+"/src/"+packageName.replace('.', '/')+"/util"));
//		Files.makeDir(new File(output+projectName+"/conf/conf/"));
//		Files.makeDir(new File(output+projectName+"/conf/msg/"));
//		Files.makeDir(new File(output+projectName+"/test/"));
//
//		Files.makeDir(new File(output+projectName+"/WebContent/WEB-INF/lib/"));
		Files.makeDir(new File(output+projectName+"/WebContent/WEB-INF/pages/"));
	}
}

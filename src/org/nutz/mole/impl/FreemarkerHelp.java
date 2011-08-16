package org.nutz.mole.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import org.nutz.lang.Files;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class FreemarkerHelp {

	static Configuration cfg = new Configuration();
	
	static {
		try {
			cfg.setDirectoryForTemplateLoading(new File("./templates"));
			cfg.setObjectWrapper(new DefaultObjectWrapper());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static final void make(String path, String templateName, Map<String, Object> datas) {
		try {
			Files.createNewFile(new File(path));
			Template template = cfg.getTemplate(templateName);
			Writer out = new FileWriter(path);
			template.process(datas, out);
			out.flush();
			out.close();
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
	}
}

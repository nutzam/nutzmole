package org.nutz.mole;

import lombok.Getter;

import org.nutz.ioc.impl.PropertiesProxy;

@Getter
public class ConfigPool {

	private PropertiesProxy project = new PropertiesProxy();
	private PropertiesProxy templete = new PropertiesProxy();
	private PropertiesProxy typeMapping = new PropertiesProxy();
	private PropertiesProxy tableMapping = new PropertiesProxy();
	private PropertiesProxy tableFieldMapping = new PropertiesProxy();
	private PropertiesProxy other = new PropertiesProxy();

	public void load() throws Throwable {
		project.setPaths("moleconf/project.properties");
		templete.setPaths("moleconf/templates.properties");
		typeMapping.setPaths("moleconf/type-mapping.properties");
		tableMapping.setPaths("moleconf/table-mapping.properties");
		tableFieldMapping.setPaths("moleconf/table-field-mapping.properties");
		other.setPaths("moleconf/other.properties");

		String output = project.get("output", "output/");
		if (!output.endsWith("/"))
			output += "/";
		project.put("output", output);

		project.put("projectRoot", output + project.get("projectName", "Test") + "/");
		project.put("srcFileRoot",
					project.get("projectRoot")
							+ "src/"
							+ project.get("packageName", "org.test.z").replace('.', '/')
							+ "/");
	}

	public PropertiesProxy getProject() {
		return project;
	}

	public void setProject(PropertiesProxy project) {
		this.project = project;
	}

	public PropertiesProxy getTemplete() {
		return templete;
	}

	public void setTemplete(PropertiesProxy templete) {
		this.templete = templete;
	}

	public PropertiesProxy getTypeMapping() {
		return typeMapping;
	}

	public void setTypeMapping(PropertiesProxy typeMapping) {
		this.typeMapping = typeMapping;
	}

	public PropertiesProxy getTableMapping() {
		return tableMapping;
	}

	public void setTableMapping(PropertiesProxy tableMapping) {
		this.tableMapping = tableMapping;
	}

	public PropertiesProxy getTableFieldMapping() {
		return tableFieldMapping;
	}

	public void setTableFieldMapping(PropertiesProxy tableFieldMapping) {
		this.tableFieldMapping = tableFieldMapping;
	}

	public PropertiesProxy getOther() {
		return other;
	}

	public void setOther(PropertiesProxy other) {
		this.other = other;
	}
	
	
	
	
}

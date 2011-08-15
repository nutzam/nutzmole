package org.nutz.mole;

import java.util.List;

import org.nutz.lang.util.SimpleContext;
import org.nutz.mole.impl.ConfigPool;
import org.nutz.mole.mapping.ZTable;

@SuppressWarnings("unchecked")
public class MoleContext extends SimpleContext {

	private ConfigPool config;

	public MoleContext() {
		config = new ConfigPool();
	}

	public List<ZTable> getTables() {
		return getAs(List.class, "tables");
	}

	public void setTables(List<ZTable> tables) {
		set("tables", tables);
	}

	public ConfigPool getConfig() {
		return config;
	}
}

package org.nutz.molex;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.dao.tools.annotation.NotNull;


@Table("xxx")
public class Pojo {

	@Id
	@Name
	@Column
	@NotNull
	private int xx;
	
	public int getXx() {
		return xx;
	}
	
	public void setXx(int xx) {
		this.xx = xx;
	}
}

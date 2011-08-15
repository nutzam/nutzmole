package org.nutz.molex;

import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;


@Table("xxx")
public class Pojo {

	@Id
	private int xx;
	
	public int getXx() {
		return xx;
	}
	
	public void setXx(int xx) {
		this.xx = xx;
	}
}

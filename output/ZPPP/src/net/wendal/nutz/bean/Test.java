package net.wendal.nutz.bean;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

import lombok.Data;

/**
* 
*/
@Data
@Table("TEST")
public class Test {

	@Id
	@Column("ID")
	private int id;
	@Column("NAME")
	private String name;
}
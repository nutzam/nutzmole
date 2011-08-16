package net.wendal.nutz.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.nutz.dao.pager.Pager;
import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;
import org.nutz.service.EntityService;

import net.wendal.nutz.bean.Test;

@At("/test")
@InjectName
@IocBean(field={"dao"})
public class TestModule extends EntityService<Test>{
	
	@At
	public Object list(@Param("page") int page ,@Param("rows") int rows){
		if (rows < 1)
			rows = 10;
		Pager pager = dao().createPager(page, rows);
		List<Test> list = dao().query(Test.class, null, pager);
		Map<String, Object> map = new HashMap<String, Object>();
		if (pager != null) {
			pager.setRecordCount(dao().count(Test.class));
			map.put("pager", pager);
		}
		map.put("list", list);
		return map;
	}
	
	@At
	public boolean add(@Param("::") Test obj){
		try{
			dao().insert(obj);
			return true;
		}catch (Throwable e) {
			return false;
		}
	}
	
	@At
	public boolean delete(@Param("::") Test obj){
		try{
			dao().delete(obj);
			return true;
		}catch (Throwable e) {
			return false;
		}
	}
	
	@At
	public boolean update(@Param("::") Test obj){
		try{
			dao().update(obj);
			return true;
		}catch (Throwable e) {
			return false;
		}
	}
}
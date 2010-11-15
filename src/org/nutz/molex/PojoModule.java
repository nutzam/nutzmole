package org.nutz.molex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.dao.pager.Pager;
import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;
import org.nutz.service.EntityService;

@InjectName
@IocBean(field={"dao"})
@At("/pojo")
public class PojoModule extends EntityService<Pojo>{
	
	@At
	public Object list(@Param("page") int page ,@Param("rows") int rows){
		Pager pager = dao().createPager(page, rows);
		List<Pojo> list = dao().query(Pojo.class, null, pager);
		Map<String, Object> map = new HashMap<String, Object>();
		if (pager != null) {
			pager.setRecordCount(dao().count(Pojo.class));
			map.put("pager", pager);
		}
		map.put("list", list);
		return map;
	}
	
	@At
	public boolean add(@Param("::") Pojo pojo){
		try{
			dao().insert(pojo);
			return true;
		}catch (Throwable e) {
			return false;
		}
	}
	
	@At
	public boolean delete(@Param("::") Pojo pojo){
		try{
			dao().delete(pojo);
			return true;
		}catch (Throwable e) {
			return false;
		}
	}
	
	@At
	public boolean update(@Param("::") Pojo pojo){
		try{
			dao().update(pojo);
			return true;
		}catch (Throwable e) {
			return false;
		}
	}
}

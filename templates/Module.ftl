package ${packageName}.module;

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

import ${packageName}.bean.${zTable.className};

@At("/${zTable.className?lower_case}")
@InjectName
@IocBean(field={"dao"})
public class ${zTable.className}Module extends EntityService<${zTable.className}>{
	
	@At
	public Object list(@Param("page") int page ,@Param("rows") int rows){
		if (rows < 1)
			rows = 10;
		Pager pager = dao().createPager(page, rows);
		List<${zTable.className}> list = dao().query(${zTable.className}.class, null, pager);
		Map<String, Object> map = new HashMap<String, Object>();
		if (pager != null) {
			pager.setRecordCount(dao().count(${zTable.className}.class));
			map.put("pager", pager);
		}
		map.put("list", list);
		return map;
	}
	
	@At
	public boolean add(@Param("::") ${zTable.className} obj){
		try{
			dao().insert(obj);
			return true;
		}catch (Throwable e) {
			return false;
		}
	}
	
	@At
	public boolean delete(@Param("::") ${zTable.className} obj){
		try{
			dao().delete(obj);
			return true;
		}catch (Throwable e) {
			return false;
		}
	}
	
	@At
	public boolean update(@Param("::") ${zTable.className} obj){
		try{
			dao().update(obj);
			return true;
		}catch (Throwable e) {
			return false;
		}
	}
}
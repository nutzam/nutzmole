package org.nutz.mole;

/**
 * 根据项目配置及ZTable列表生成需要的信息
 * 
 * @author wendal
 * 
 */
public interface Creator {

	void create(MoleContext context);
}

package ${packageName}.bean;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

@Table("${zTable.dbTableName}")
public class ${zTable.className} {

	<#list zTable.fields as zField>
		<#if zField.primaryKey>
			<#if zField.classTypeName == "long" || zField.classTypeName == "int">
	@Id
			<#else>
				<#if zField.classTypeName == "String">
	@Name
				</#if>
			</#if>
		</#if>
	@Column("${zField.dbFieldName}")
	private ${zField.classTypeName} ${zField.fieldName};
	</#list>
	
	//getter setter
	<#list zTable.fields as zField>
		<#if zField.classTypeName != "boolean">
	public ${zField.classTypeName} get${zField.fieldName?cap_first}() {
		return ${zField.fieldName};
	}
		<#else>
	public ${zField.classTypeName} is${zField.fieldName?cap_first}() {
		return ${zField.fieldName};
	}
		</#if>
	public void set${zField.fieldName?cap_first}(${zField.classTypeName} ${zField.fieldName}) {
		this.${zField.fieldName} = ${zField.fieldName};
	}
	</#list>
}
package ${packageName}.bean;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

import lombok.Data;

/**
* ${zTable.comment!""}
*/
@Data
@Table("${zTable.tableName}")
public class ${zTable.className} {

	<#list zTable.fields as zField>
		<#if zField.primaryKey>
			<#if zField.classTypeName == "long" || zField.classTypeName == "int">
	<#if zField.comment !="">
	//${zField.comment}
	</#if>
	@Id
			<#else>
				<#if zField.classTypeName == "String">
	<#if zField.comment !="">
	//${zField.comment}
	</#if>
	@Name
				</#if>
			</#if>
		</#if>
	<#if zField.comment !="">
	//${zField.comment}
	</#if>
	@Column("${zField.dbFieldName}")
	private ${zField.classTypeName} ${zField.fieldName};
	</#list>
}
package ${basepackage}.bean;

import org.nutz.dao.entity.annotation.*;

import lombok.Data;

/**
* 
*/
@Data
@Table("${table.sqlName}")
public class ${table.className} {

	<#list table.columns as column>
		<#if column.pk>
			<#if column.javaType == "java.lang.Long" || column.javaType == "java.lang.Integer">
	@Id
			<#else>
				<#if column.javaType == "java.lang.String">
	@Name
				</#if>
			</#if>
		</#if>
	@Column("${column.columnName?upper_case}")
	private ${column.possibleShortJavaType} ${column.columnNameFirstLower};
	</#list>
}
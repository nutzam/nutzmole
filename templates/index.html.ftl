<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${projectName}</title>
</head>
<body>
	<div id="info">List of pages</div><p/>
	<div>
	<#list zTables as zTable>
	<a href="page/${zTable.className}.html">${zTable.className}</a><p/>
	</#list>
	</div>
</body>
</html>
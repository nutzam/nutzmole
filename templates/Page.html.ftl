<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of ${zTable.className}</title>
<script type="text/javascript" src="../js/jquery-1.4.3.min.js"></script>
<script type="text/javascript" src="../js/jquery.dataTables.min.js"></script>
<script type="text/javascript">
$(function() {
	$('#example').dataTable( {
		"bProcessing": true,
		"sAjaxSource": '../${zTable.className?lower_case}/list.nut'
	} );
} );
</script>
</head>
<body>

<div id="header"></div>
<div id="list">
<table cellpadding="0" cellspacing="0" border="0" class="display" id="example">
	<thead>
		<tr>
			<#list zTable.fields as zField>
			<th>${zField.fieldName?cap_first}</th>
			</#list>
		</tr>
	</thead>
	<tbody>
		
	</tbody>
	<tfoot>
		<tr>
			<#list zTable.fields as zField>
			<th>${zField.fieldName?cap_first}</th>
			</#list>
		</tr>
	</tfoot>
</table>

</div>
<!-- 页脚 -->
<div id="footer"></div>
</body>
</html>
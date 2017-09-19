<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/common/bashPath.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<%@ include file="/modules/bootstrap/css/boostrap_css.jsp"%>
<title>index</title>
</head>
<body>
	进程状态：
	<div class="bs-example" data-example-id="striped-table" id="content"></div>
</body>
<%@ include file="/modules/jquery/jquery_js.jsp"%>
<%@ include file="/modules/bootstrap/js/boostrap_js.jsp"%>
<%@ include file="/modules/arttemplate/template_js.jsp"%>
<script id="test" type="text/html">
{{if success}}
	<table class="table table-striped">
	<thead>
	<tr>
	<th>pid</th>
	<th>user</th>
	<th>startTime</th>
	<th>memSize</th>
	<th>memUse</th>
	<th>memhare</th>
	<th>state</th>
	<th>cpuTime</th>
	<th>name</th>
	</tr>
	</thead>
	<tbody>
	{{each result as i}}
	<tr>
	<th scope="row">{{i.pid }}</th>
	<th>{{i.user }}</th>
	<th>{{i.startTime }}</th>
	<th>{{i.memSize }}</th>
	<th>{{i.memUse }}</th>
	<th>{{i.memhare }}</th>
	<th>{{i.state }}</th>
	<th>{{i.cpuTime }}</th>
	<th>{{i.name }}</th>
	</tr>
	{{/each}}
	</tbody>
	</table>
{{/if}}
</script>
<script type="text/javascript">
	/* 0.5秒刷新一次 */
	setInterval("aj()", "1000");
	$("button").on("click", function() {

	});
	var $bashPath = $bashPath = $("bashPath").attr("value");
	var $progress = $("#pro");
	var aj = function() {
		$.ajax({
			url : $bashPath + '/system/procruninfos.json',
			data : null,
			type : 'get',
			cache : false,
			dataType : 'json',
			success : function(data) {
				alert(data.success);
				var html = template('test', data);
				document.getElementById('content').innerHTML = html;
			},
			error : function() {
				alert("异常！");
			}
		});
	}
</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	内存使用率：
	<div style="width: 50%">
		<div class="progress">
			<div id="pro" class="progress-bar progress-bar-striped active"
				role="progressbar" aria-valuemax="100" style="width: 0%">0%</div>
		</div>
	</div>
	<button>click</button>
</body>
<%@ include file="/modules/jquery/jquery_js.jsp"%>
<%@ include file="/modules/bootstrap/js/boostrap_js.jsp"%>
<script type="text/javascript">
/* 1秒刷新一次 */
	setInterval("aj()","1000");
	$("button").on("click",function(){
		var $bashPath=$("bashPath").attr("value");
		alert($bashPath);
	});
	var $bashPath=$bashPath=$("bashPath").attr("value");
	var $progress = $("#pro");
	var aj = function() {
		$.ajax({
			url : $bashPath+'/system/mem.json',
			data : null,
			type : 'get',
			cache : false,
			dataType : 'json',
			success : function(data) {
				$progress.css("width", data.result.usedPercent + "%");
				$progress.text(data.result.usedPercent + "%");
				color();
			},
			error : function() {
				alert("异常！");
			}
		});
	}
	var color=function(){
		var $progresText=parseFloat($progress.text());
		if ($progresText<50.0) {
			$progress.removeClass("progress-bar-success");
			$progress.removeClass("progress-bar-warning");
			$progress.removeClass("progress-bar-danger");
			$progress.addClass("progress-bar-success");
		}else if ($progresText>50.0&&$progresText<75.0) {
			$progress.removeClass("progress-bar-success");
			$progress.removeClass("progress-bar-warning");
			$progress.removeClass("progress-bar-danger");
			$progress.addClass("progress-bar-warning");
		}else{
			$progress.removeClass("progress-bar-success");
			$progress.removeClass("progress-bar-warning");
			$progress.removeClass("progress-bar-danger");
			$progress.addClass("progress-bar-danger");
		}
	}
</script>
</html>
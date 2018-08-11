<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	pageContext.setAttribute("ctx", request.getContextPath());
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
	var ctx = "${ctx}";
	$(document).ready(function(){
		//頁面初始化時，獲取動態密碼，同時獲取刷新頻率,
		$.ajax({
			type:"post",
			url:ctx+'/getInterval',
			cache : false,
			async: false,
			success:function(data){
				//根據刷新頻率來新建定時循環任務
				console.log(data);
				autoGetCode();
				setInterval('autoGetCode()',1000*parseInt(data));
			}
		});
		
		//若刷新頻率改變
		
		//setInterval('autoGetCode()',1000);
	})
	function autoGetCode(){
		$.ajax({
			type:"post",
			url:ctx+'/getCode',
			cache : false,
			async: false,
			success:function(data){
				$("#code").text(data);
			}
		});
	}
</script>

<body>
    helloJsp
    <hr>
   <div id="code" style="font-size:36px"></div>
</body>
</html>
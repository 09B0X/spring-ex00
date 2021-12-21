<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resource/css/icon/css/all.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<script>
	$(document).ready(function() {
		const appRoot = "${pageContext.request.contextPath}";
		
		$("#btn01").click(function() {
			$.ajax({
				url : appRoot + "/cont17/met01"
			});
		});
		
		$("#btn02").click(function() {
			$.ajax({
				url : appRoot + "/cont17/met02/" + 3231
			});
		});
		
		$("#btn03").click(function() {
			$.ajax({
				url : appRoot + "/cont17/met03/" + 4231
			});
		});
		
		$("#btn04").click(function() {
			$.ajax({
				url : appRoot + "/cont17/met04/tiger"
			});
		});
		
		$("#btn05").click(function() {
			$.ajax({
				url : appRoot + "/cont17/met05/5124/seoul" 
			});
		});
		
		$("#btn06").click(function() {
			$.ajax({
				url : appRoot + "/cont17/met06/id/2141/city/ny" 
			});
		});
		
	});
</script>

<title>Insert title here</title>
</head>
<body>

<button id="btn01">/cont17/met01 요청</button>
<button id="btn02">/cont17/met02/id 요청</button>
<button id="btn03">/cont17/met03/number 요청 : controller에서 바뀔수있는 number를 sysout으로 출력</button>
<button id="btn04">/cont17/met04/문자열 요청</button>
<button id="btn05">/cont17/met05/id/city 요청</button>
<button id="btn06">/cont17/met06/id/{id}/city/{city} 요청</button>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
</body>
</html>
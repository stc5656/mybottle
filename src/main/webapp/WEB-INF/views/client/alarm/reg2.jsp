
<%-- <%@page import="com.mybottle.webapp.service.member.AlertService"%>
<%@page import="com.mybottle.webapp.entity.Alert"%> --%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<title>알람</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link href="../../css/style.css" type="text/css" rel="stylesheet"/>
<link href="../../css/member/alert/style.css" type="text/css" rel="stylesheet" />
<link href="../../css/timedropper.min.css" type="text/css" rel="stylesheet" />
<script src="//code.jquery.com/jquery-1.12.4.js" integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous" ></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script src="../../js/timedropper.min.js"></script>
<script src="../../js/member/dateSelect.js" type="text/javascript"></script>
</head>
<body>
<div id="body" class="full-screen bg-morning">	
	<!-- header 영역11 -->
	<header id="header">
		<div class="content-container clearfix">
			<section>
				<h1>&lt; 알람설정</h1>
			</section>
		</div>
	</header>		
	<!-- main 영역 -->
	<main id="main" class="full-container bg-white">
		<form method="post">
			<aside class="set-date">
				<h1>날짜 설정</h1>
				<span class="date-txt">${alert.specificDate}</span>
				<div class="select">
					<input type="hidden" name="datepicker" id="datepicker" value="${alert.specificDate}" />
					<span id="datepicker-button">날짜선택</span>
				</div>
			</aside>
			<section class="set-time">
				<h1>시간 설정</h1>
				<input type="text" name="time" class="td-input time-dropper" value="12:00" readonly />
			</section>
			<section class="set-week">
				<h1>요일 반복</h1>
				<input type="hidden" name="week" id="week-input" />
				<ul class="menu-week" id="week-select">
					<c:forEach var="a" items="${week }">
					<li>${a}</li>
					</c:forEach>
				</ul>
			</section>
			<div>
				<ul class="menu-btn">
					<li><a href="list">취소</a></li>
					<li><input type="submit" value="저장하기" class="submit-btn" /></li>
				</ul>
			</div>
		</form>
	</main>
	<%-- <jsp:include page="../../inc/bottom_menu.jsp"></jsp:include> --%>
</div>	
</body>
</html>
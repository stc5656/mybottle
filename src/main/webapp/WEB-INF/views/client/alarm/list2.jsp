<%-- <%@page import="com.libo.web.service.member.AlertService"%>
<%@page import="com.libo.web.entity.Alert"%> --%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>알람</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
<link href="../../css/style.css" type="text/css" rel="stylesheet"/>
<link href="../../css/anypicker.css" type="text/css" rel="stylesheet" />
<script src="//code.jquery.com/jquery-1.11.3.js"></script>
<script src="../../js/anypicker.js"></script>
<script src="../../js/dataMulti.js"></script>
<script src="../../js/member/course/list.js"></script>

<link rel="stylesheet" type="text/css" href="../../css/member/course/list.css">
<style>
#alert-list h1,
.del-chk {
	display:none;
}
.delete-check {
	margin-top:15px;
}
.list {margin-top:5px;} 
</style>
</head>
<body>
<div id="body" class="full-screen bg-morning">	
	<!-- header 영역11 -->
	<header id="header">
		<div class="content-container clearfix">
			<section>
				<h1><a href="#" onclick="history.go(-1)">&lt;알람 설정</a></h1>
			</section>
			<section id="sub-box" style="display: block;">
				<div></div>
			</section>			
		</div>
		<div class="df-menu" id="sub-menu">
			<ul>
				<li id="delete-menu">삭제</li>
				<li id="cancel-menu">취소</li>
			</ul>
		</div>
	</header>		
	<!-- main 영역 -->
	<main id="main" class="full-container bg-white">
		<section id="alert-list" class="sel-list cont-scroll">
			<h1>알람 표</h1>
			<form id="delete-form" action="delete" method="post">
			<ul class="list set">
				<c:forEach var="a" items="${list }">
				<li class="list-record" data-id="${a.id}">
					<input type="checkbox" name="delete-id" value="${a.id}" class="delete-check" />
					<%-- <a href="detail?id=${a.id}"> --%>
						<div class="col-sm">
							<span>${a.time }</span>
						</div>
						<div class="col-au col-week">
							<c:if test="${!empty a.week}">${a.week}</c:if>
							<c:if test="${empty a.week}">${a.specificDate}</c:if>
						</div>
						<div class="col-xs switch-item">
						<c:choose>
						    <c:when test="${a.alarm eq 'Y'}">
						   		<label class="switch"><input value="${a.id }" class="alarm" type="checkbox" checked><span class="slider round"></span></label>
						    </c:when>
						    <c:otherwise>
						      <label class="switch"><input value="${a.id }" class="alarm" type="checkbox"><span class="slider round"></span></label>
						    </c:otherwise>
						</c:choose>
						</div>
				</li>
				</c:forEach>																									
			</ul>
 			</form>			
		</section>
		<div>
			<a href="reg" class="btn-add" id="plus"><span>+</span></a>
		</div>
	</main>
	<%-- <jsp:include page="../../inc/bottom_menu.jsp"></jsp:include> --%>
</div>	
</body>
</html>
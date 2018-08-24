<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
/* ---------------------------------------------------------------- */
body {
	margin: 0px;
}

h1 {
	margin: 0px;
	display: none;
}

h2 {
	margin: 10px;
	position: relative;
	font-size: 21px;
	color: white;
}

ol, ul {
	list-style: none;
}

/* -----------common style----------------------------------------------------- */
.hidden {
	display: none;
}

/* viewport - 모바일처럼 보이게 크기 줄여주는거 */

/* -----------component style(버튼 모아놓는 곳)----------------------------------------------------- */
.button {
	width: 35px;
	height: 35px;
	overflow: hidden;
	text-indent: -999px;
	border: 0px;
	padding: 0px;
	margin: 0px;
}

.menu-button {
	position: relative;
	left: -48px;
	top: 11px;
	background: url("/mybottle/resources/images/hamburger.png") no-repeat 0px 0px;
}

.alram-menu-button {
	background: url("/mybottle/resources/images/alarm.png") no-repeat 0px 0px;
	margin-right: 10px;
}

.date-menu-button {
	background: url("/mybottle/resources/images/date.png") no-repeat 0px 0px;
	margin-right: 10px;
}

.list-menu-button {
	background: url("/mybottle/resources/images/library.png") no-repeat 0px 0px;
}

.menu-container {
	display: flex;
	position: relative;
	left: 165px;
	top: -24px;
}

#header {
	width: 100%;
	height: 55px;
	background: #0A56BD;
	display: flex;
}

#header:after {
	position: fixed;
	background-color: black;
	top: 0px;
	left: 0px;
	width: 100%;
	height: 0%;
	display: block;
	opacity: 0;
	content: "";
	transiton: 500ms opacity ease;
}

#header #header-button {
	position: relative;
	display: flex;
}

#header-button {
	position: relative;
	display: flex;
}

#menu-text {
	position: relative;
	left: 55px;
	margin-top: 4px;
	
}

/* -----------main menu----------------------------------------------------- */
#header #main-menu {
	position: fixed;
	/* absolute / fixed(화면 기준) / relative(보이는거) / 차이점 - 영역의 위치의 차이점이 있다. */
	left: -80%;
	width: 80%;
	background: white;
	height: 100%;
	z-index: 10;
	transiton: 500ms right ease 500ms;
}

#header #main-menu ul {
	margin-top: 100%;
	width: 100%;
	list-style-type: none;
	position: absolute;
	z-index: 1;
	margin: 0;
	padding: 0;
	top: 15%;
	left: 0;
}

#header #main-menu ul a {
	display: block;
	width: 100%;
	height: 45px;
	line-height: 45px;
	padding-left: 10px;
	text-decoration: none;
}

#header #main-menu ul li {
	height: 45px;
	border-top: 1px solid #474a50;
}

#header #main-menu ul li.menu-label a {
	padding-left: 80px;
	height: 100%;
	display: block;
	font-size: 17px;
	text-transform: lowercase;
}

#header #main-menu .mo-menu-title {
	padding: 32px 0 0 40px;
	height: 100%;
	display: block;
	font-size: 17px;
	text-transform: uppercase;
}

#header.menu-show #main-menu {
	left: 0%;
}

#header.menu-show:after {
	height: 100%;
	opacity: 0.5;
}

#goal-container {
	position: absolute;
	width: inherit;
	height: 100px;
	background: #e9e9e9;
	margin-top: 55px;
}

	#goal-container.goal-text{
		margin-top: 10px;
		margin-left: 10px;
	}



</style>

<header id="header">

	<section id="menu-text">
		<h2>메뉴</h2>
	</section>

	<section id="header-buttons">
		<h1 class="hidden">헤더 버튼</h1>

		<section>
			<input class="button menu-button" type="button" value="메뉴버튼" /><a
				href=""></a>
		</section>

		<div class="menu-container">
			<input class="button alram-menu-button" type="button" value="알림" /><a
				href=""></a> <input class="button date-menu-button" type="button"
				value="날짜" /><a href=""></a> <input class="button list-menu-button"
				type="button" value="기록" /><a href=""></a>
		</div>
	</section>


	<section id="main-menu">
		<h1 class="hidden">메인메뉴</h1>

		<span class="mo-menu-title">CATEGORY</span>

		<ul>
			<li class="menu-label"><a href=""><img src ="/mybottle/resources/images/dry.png"/>물마시기</a></li>
			<li class="menu-label"><a href="">음료기록</a></li>
			<li class="menu-label"><a href="">물</a></li>
			<li class="menu-label"><a href="">알림</a></li>
			<li class="menu-label"><a href="">설정</a></li>
		</ul>
	</section>


	<section id = "goal-container">
		<ul>
			<li class = "goal-text">오늘의 목표</li>
		</ul>
	</section>

</header>

<script>
   window.addEventListener("load", function(event){
      var header = document.querySelector("#header");
      var menuButton = header.querySelector(".menu-button");
      
      header.onclick = function(e){
         if(e.target.nodeName == "HEADER")
            header.classList.remove("menu-show");
      };
      
      menuButton.onclick = function(e){
         header.classList.add("menu-show");
         
         e.stopPropagation();
      };
   });
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
	<%@ page import="java.util.regex.*" %>
		<jsp:useBean id="user_db" scope="session" class="login.LoginUserBean" />
		<!DOCTYPE html>
		<html lang="ja">

		<head>
			<meta charset="UTF-8">
			<title>Hamfile - Profile</title>
			<link rel="stylesheet" href="css/picnic.min.css">
			<link rel="stylesheet" href="css/stylesheet.css">
			<link rel="stylesheet" href="css/font-awesome-4.7.0/css/font-awesome.min.css">
			<script src="https://cdnjs.cloudflare.com/ajax/libs/clipboard.js/1.5.16/clipboard.min.js"></script>
			<script type="text/javascript" src="script/script.js"></script>
			<script type="text/javascript" src="script/jquery-3.1.1.min.js"></script>
			<link rel="shortcut icon" href="img/Logoico.ico">
		</head>

		<body>

			<!-- ■ナビゲーションバー -->
			<nav class="demo imponent">
				<a href="index.html" class="brand">
					<span class="logo"><img class="title_logo" src="img/Logo400.png" alt="logo">Hamfile</span>
				</a>
				<!-- レスポンシブメニュー -->
				<input id="bmenub" type="checkbox" class="show">
				<label for="bmenub" class="burger pseudo button"><i class="fa fa-navicon"></i></label>
				<!-- メニュー項目 -->
				<div class="menu">
					<%
				if(user_db != null && user_db.getLoginflag()==1){
				%>
						 <button class="btn" id="foo" data-clipboard-target="#foo" data-clipboard-text="http://localhost:8080/Hamfile/profile/FUJIMOTO" value="http://localhost:8080/Hamfile/profile/FUJIMOTO"><i class="fa fa-copy"></i> クリップボードにコピー</button>
						<a href="edit.jsp" class="button"><i class="fa fa-pencil-square-o"></i> プロフィール編集</a>
						<!-- <a href="setting_pass.html" class="button"><i class="fa fa-cog"></i> アカウント設定</a> -->
						<a href="index.html " class="button" action="./LogoutServlet.java"><i class="fa fa-sign-out"></i>ログアウト</a>
						<%
				}
				%>
				</div>
			</nav>

			<div class="flex two contents_profile">
				<!-- ■プロフィール画像 -->
				<span>
			<%
				if(user_db !=null && user_db.getImagepath() != null){
					out.println("<img class='profile_img' src='profileimg/" + user_db.getImagepath() + "'>");
				} else {
			%>
				<img class="profile_img" src="img/ham_profile.png">
			<% } %>
			</span>

				<!-- ■基本プロフィール -->
				<span>
		<div class="information">
			<h4>
				<i class="fa fa-user"></i> Name :
				<jsp:getProperty property="name" name="user_db"/>
			</h4>
		</div>
	</span>
				<%
    String s = user_db.getProfile();
    //s.replaceAll("\n\r", "<br>");
    //s.replaceAll(System.getProperty("file.separator"), "<br>");
    String LINE_SEPARATOR_PATTERN =  "\r\n|[\n\r\u2028\u2029\u0085]";
    Pattern pt = Pattern.compile(LINE_SEPARATOR_PATTERN);
    Matcher match = pt.matcher(s);
    String stVal = match.replaceAll("<br>");
		String result = stVal.replaceAll("(http://|https://){1}[\\w\\.\\-/:]+","<a href='$0'>$0</a>");
%>
					<!-- ■テキストエリア -->
					<span class="full">
		<article class="card self-card adoraku1">
			<header>自己紹介</header>
			<section id="self">
				<p class="spacing">
					<!-- ここに自己紹介が表示される。 -->
					<%= result %>
				<!--	<jsp:getProperty property="profile" name="user_db"/> -->
				</p>
			</section>
		</article>
	</span>
			</div>

			<script src="https://cdnjs.cloudflare.com/ajax/libs/clipboard.js/1.5.16/clipboard.min.js"></script>
			<script type="text/javascript" src="script/script.js"></script>
		</body>

		</html>
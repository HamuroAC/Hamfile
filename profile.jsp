<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<jsp:useBean id="user_db" scope="session" class="login.LoginUserBean" />
<!DOCTYPE html>
<html lang="ja">

<head>
	<meta charset="UTF-8">
	<title>Hamfile - Profile</title>
	<link rel="stylesheet" href="css/picnic.min.css">
	<link rel="stylesheet" href="css/stylesheet.css">
	<link rel="stylesheet" href="css/font-awesome-4.7.0/css/font-awesome.min.css">
	<script type="text/javascript" src="script/script.js"></script>
	<scirpt type="text/javascript" src="script/jquery-3.1.1.min.js"></scirpt>
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
		<a href="edit.jsp" class="button"><i class="fa fa-pencil-square-o"></i> プロフィール編集</a>
		<a href="setting_pass.html" class="button"><i class="fa fa-cog"></i> アカウント設定</a>
		<a href="index.html " class="button" action="./LogoutServlet.java"><i class="fa fa-sign-out"></i>ログアウト</a>
	</div>
</nav>

<div class="flex two contents_profile">
	<!-- ■プロフィール画像 -->
	<span>
		<img class="profile_img" src="img/ham_profile.png">
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
	<!-- ■テキストエリア -->
	<span class="full">
		<article class="card self-card">
			<header>自己紹介</header>
			<section id="self">
				<p class="spacing">
					<!-- ここに自己紹介が表示される。 -->
					<jsp:getProperty propety="profile" name="user_db"/> 
				</p>
			</section>
		</article>
	</span>
</div>

</body>

</html>
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
  <!--  HttpSession ses = req.setSession
    String id = String ses.GetAtteribute(string id)
    if(id==null){<!-セッション未実装のためコメントアウト--><!--
     <a href="login.jsp" class="button">ログイン</a>}else{-->
     <a href="edit.jsp" class="button"><i class="fa fa-pencil-square-o"></i> プロフィール編集</a><!--}-->
     <a href="setting.html" class="button"><i class="fa fa-cog"></i> アカウント設定</a>
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
    <h4><i class="fa fa-user"></i> Name : 
    <jsp:getProperty property="name" name="user_db"/></h4>
  </div>
</span>

</div>

</body>

</html>
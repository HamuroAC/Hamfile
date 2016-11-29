<!DOCTYPE html>
<html lang="ja">

<head>
  <meta charset="UTF-8">
  <title>Hamfile - Profile</title>
  <link rel="stylesheet" href="css/picnic.min.css">
  <link rel="stylesheet" href="css/stylesheet.css">
  <script type="text/javascript" src="script/script.js"></script>
  <scirpt type="text/javascript" src="script/jquery-3.1.1.min.js"></scirpt>
  <link rel="shortcut icon" href="img/Logoico.ico">
</head>

<body>
  <!-- ナビゲーションバー -->
  <nav class="demo imponent">
    <a href="index.html" class="brand">
      <span class="logo"><img class="title_logo" src="img/Logo200.png" alt="logo">Hamfile</span>
    </a>
    <div class="menu">
    <!--  HttpSession ses = req.setSession
      String id = String ses.GetAtteribute(string id)
      if(id==null){<!-セッション未実装のためコメントアウト--><!--
       <a href="login.jsp" class="button">ログイン</a>}else{-->
       <a href="edit.jsp" class="button">設定</a><!--}-->
    </div>
  </nav>
  <!-- コンテンツ -->
  <div class="flex two contents_profile">
    <span>
        <img class="profile_img" src="img/person.png">
    </span>
    <span>
      <div class="information">
        <h3>Name : KNGMT</h3>
        <h3>Gender : Male</h3>
        <h3>Location : Nara</h3>
      </div>
    </span>
  </div>
    <div class="flex two center demo">
    I'd like to
    </div>
  <div class="flex two center demo">
  <div><span>🍳中華料理</span></div>
  <div><span>💻プログラミング</span></div>
  <div><span></span></div>
  <div><span>4</span></div>
  <div><span>5</span></div>
</div>
  <!-- フッター -->
</body>

</html>
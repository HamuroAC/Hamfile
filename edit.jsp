<%@page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ja">

<head>
  <meta charset="UTF-8">
  <title>Hamfile - Edit</title>
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
  <!-- ロゴ -->
  <a href="index.html" class="brand">
    <span class="logo"><img class="title_logo" src="img/Logo400.png" alt="logo">Hamfile</span>
  </a>
  <!-- レスポンシブメニュー -->
  <input id="bmenub" type="checkbox" class="show">
  <label for="bmenub" class="burger pseudo button"><i class="fa fa-navicon"></i></label>
  <!-- メニュー項目 -->
  <div class="menu">
    <a href="profile.jsp" class="button"><i class="fa fa-share"></i> キャンセル</a>
  </div>
</nav>


<form method="POST" enctype="multipart/form-data" action="./UploadServlet">
<div class="flex two contents">

<!-- ■画像アップロード -->
<span>
  <article class="card upload_pic_card">
    <header><h3><i class="fa fa-camera"></i> Upload New Picture</h3></header>
    <section class="upload_pic_section">
      <label class="dropimage miniprofile">
        <input name="filea" title="Drop image or click me" type="file">
      </label>
    </section>
  </article>
</span>

<!-- ■基本プロフィール編集 -->
<span class="information_edit">
  <article class="card">
    <header><i class="fa fa-pencil-square-o"></i> 基本プロフィール</header>
    <section>
      <h4><i class="fa fa-user"></i> 名前<input name= "name" type="text" placeholder="Name"></h4>
    </section>
  </article>
</span>

<!-- なにも記入しない -->
 <span>
</span>

<!-- 決定ボタン -->
<span>
  <input class="full add_profile_btn" type="submit" value="&#xf046; 決定">
</span>

</div>
</form>

</body>

</html>
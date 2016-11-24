 <%@page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ja">

<head>
  <meta charset="UTF-8">
  <title>Hamfile - Edit</title>
  <link rel="stylesheet" href="css/picnic.min.css">
  <link rel="stylesheet" href="css/stylesheet.css">
  <script type="text/javascript" src="script/script.js"></script>
  <link rel="shortcut icon" href="img/Logoico.ico">
</head>

<body>
  <!-- ナビゲーションバー -->
  <nav class="demo imponent">
    <a href="index.html" class="brand">
      <span class="logo"><img class="title_logo" src="img/Logo200.png" alt="logo">Hamfile</span>
    </a>
    <div class="menu">
      <!-- メニューなし -->
    </div>
  </nav>
  <!-- コンテンツ -->
  <form method="POST" enctype="multipart/form-data" action="./UploadServlet">
  <div class="flex two contents_profile">
    <span>
      <label class="dropimage miniprofile">
        <input name="filea" title="Drop image or click me" type="file">
      </label>
    </span>
    <span class="information_edit">
      <h3><input type="text" placeholder="Name"></h3>
      <h3><input type="text" placeholder="Gender"></h3>
      <h3><input type="text" placeholder="Location"></h3>
    </span>
    <span>
      <!-- なし -->
    </span>
    <span>
      <input class="full" type="submit" value="決定">
    </span>
  </div>
  </form>
</body>

</html>
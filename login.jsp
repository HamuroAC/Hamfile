<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<!DOCTYPE html>
<html lang="ja">
  <head>
  <meta charset="UTF-8">
  <title>ようこそ</title>
 <link rel="stylesheet" href="login.css">
  </head>
   <body>
   <div id="main">
   <%
   request.setCharacterEncoding("UTF-8");
   String ident = request.getParameter("loginId");
   String pass = request.getParameter("loginPass");
   String name = "";
   Context ctx = null;
   DataSource ds = null;
   Connection con = null;
   PreparedStatement ps = null;
   ResultSet rs = null;
   int errCode = 0;
   if (ident == null || ident.equals("") || pass == null || pass.equals("")) {
 errCode = 100;
 } else {
    try {
   ctx  =  new  InitialContext( );
   ds  =  (DataSource)ctx.lookup("java:comp/env/jdbc/login");
   con  =  ds.getConnection( );
   String  strSql  =  "select  *  from  password  where  ident  =  ?";
   ps  =  con.prepareStatement(strSql);
   ps.setString(1, ident);
   rs  =  ps.executeQuery( );
   if (!rs.next()) {
   errCode = 200;
   } else if (!pass.equals(rs.getString("pass"))){
 errCode = 300;
 } else {
    name = rs.getString("name");
   }
  } catch(SQLException e) {
    errCode = 900;
    e.printStackTrace( );
     } catch(Exception e) {
    errCode = 910;
    e.printStackTrace( );
    } finally {
    try {
    if ( rs  !=  null )   rs.close( );
   if ( ps  !=  null )  ps.close( );
   if ( con  !=  null )  con.close( );
  } catch(SQLException e) {
    errCode = 900;
    e.printStackTrace( );
     }
    }
    }
  if (errCode == 0) {
  out.println("<h2>ようこそ！</h2>");
   out.println("<hr><br>");
   out.println("こんにちは、"+ name + "さん！<br><br>");
 out.println("<a href='login.html'>ログインページへ</a>");
  } else if (errCode == 100) {
   out.println("<h2>未入力項目があります。</h2>");
   out.println("<hr><br>");
  out.println("ユーザーID、パスワードを入力してください。<br><br>");
  out.println("<a href='login.html'>ログインページへ</a>");
  } else if (errCode == 200) {
 out.println("<h2>ユーザーIDは未登録です</h2>");
 out.println("<hr><br>");
 out.println("入力されたユーザーID(<b>" + ident + "</b>)は未登録です。<br>");
  out.println("ユーザー登録されてからご利用ください。<br><br>");
  out.println("<a href='register.html'>新規ユーザー登録へ</a>");
  } else if (errCode == 300) {
   out.println("<h2>パスワードをご確認ください。</h2>");
  out.println("<hr><br>");
  out.println("正しいパスワードを入力してください。<br><br>");
  out.println("<a href='login.html'>ログインページへ</a>");
  } else if (errCode == 900) {
  out.println("<h2>SQLエラー</h2>");
  out.println("<hr><br>");
  out.println("SQLでエラーが発生しました。<br>");
  out.println("管理者に連絡してください。<br><br>");
    out.println("<a href='login.html'>ログインページへ</a>");
    } else if (errCode == 910) {
  out.println("<h2>データベースエラー</h2>");
    out.println("<hr><br>");
  out.println("データベースでエラーが発生しました。<br>");
  out.println("管理者に連絡してください。<br><br>");
  out.println("<a href='login.html'>ログインページへ</a>");
    }
   %>
  <br><br>
    <hr>
 <p>02組34番藤本智彦</p> 
 </div>
</body>
</html>

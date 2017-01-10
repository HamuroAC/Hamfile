import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.*;
import javax.servlet.http.*;



/*ログアウト機能*/
@WebServlet(name = "LogoutServlet", urlPatterns = { "/LogoutServlet" })
public class LogoutServlet extends HttpServlet {
  public LogoutServlet() {
        super();
    }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

    response.setContentType("text/html; charset=Shift_JIS");
    PrintWriter out = response.getWriter();

    /*セッションを切断*/
    HttpSession session = request.getSession(true);
    session.invalidate();

    response.sendRedirect("./login.html");
  }
}
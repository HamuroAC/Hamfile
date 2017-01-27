package UserFound;
import login.LoginUserBean;
import UserFound.UserFoundDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.http.HttpSession;

@WebServlet(name = "UserFoundServlet", urlPatterns = {"/profile/*"})
@MultipartConfig(maxFileSize = 1048576)
public class UserFoundServlet extends HttpServlet {

    public UserFoundServlet() {
        super();
    }

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      doPost(request, response);
}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        // 文字化け防止
        request.setCharacterEncoding("UTF-8");
String UserURL;
UserURL=request.getRequestURI();

String UserID=UserURL.substring(UserURL.lastIndexOf("/")+1);
System.out.println("UserFoundServlet: UserID=" + UserID);
              /*  response.setContentType("text/html; charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<!DOCTYPE>");
                out.println("<html lang='ja'>");
                out.println("<head><meta charset='UTF-8'>");
                out.println("<title>Servlet</title></head>");
                out.println("<body>");
                out.println("UserID=" + UserID);
                out.println("</body>");
                out.println("</html>");
            */
            // 文字化け防止
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        RequestDispatcher rd;
            //URIで取得したIDをDB.javaに渡すため変数idに入れる
            String id =UserID;
            System.out.println("UserFoundServlet: id=" + id);
            
            UserFoundDB userfounddb = new UserFoundDB();

            // ユーザ情報をモデルに格納
            LoginUserBean bean = userfounddb.userFoundData(id);

             // ログイン判定
            String dispatcherURL = null;
            if (bean.getId() != null) {

                // ユーザー情報
                session.setAttribute("user_db", bean);
                // ログイン状態
                session.setAttribute("login_db", "login");
                // セッション有効時間
                session.setMaxInactiveInterval(1000);

                //rd = request.getRequestDispatcher("/profile.jsp");
                dispatcherURL = "/Hamfile/profile.jsp";

                } else {

                //rd = request.getRequestDispatcher("/login.html");
                dispatcherURL = "/Hamfile/login.html";
                bean= null;
            }

            //rd.forward(request, response);[
            response.sendRedirect(dispatcherURL);
            

    }
}
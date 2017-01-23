package login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ログイン機能
 */
@WebServlet(name = "LoginServlet", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {

    public LoginServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        // 文字化け防止
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        RequestDispatcher rd;

            // IDとPASSWORDを取得
            String id = request.getParameter("id");
            String password = request.getParameter("password");
            //imagepath profileを取得
            String imagepath =request.getParameter("imagepath");
            System.out.println("Loginservlet:Line38:" + imagepath);
            String profile = request.getParameter("profile");
            System.out.println("Loginservlet:Line41:" + profile);

            LoginDB logindb = new LoginDB();

            // ユーザ情報をモデルに格納
            //LoginUserBean bean = logindb.getUserData(id, password);
            LoginUserBean bean = logindb.getUserData(id, password,imagepath,profile);
             // ログイン判定

            if (bean != null) {

                // ユーザー情報
                session.setAttribute("user_db", bean);
                // ログイン状態
                session.setAttribute("login_db", "login");
                // セッション有効時間
                session.setMaxInactiveInterval(180);

                rd = request.getRequestDispatcher("./profile.jsp");

                } else {

                rd = request.getRequestDispatcher("./login.html");
            }

            rd.forward(request, response);
        }
    }

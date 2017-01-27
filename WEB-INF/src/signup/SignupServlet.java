package signup;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.http.HttpSession;

import login.LoginUserBean;
/**
 * 新規登録機能
 */
@WebServlet(name = "SignupServlet", urlPatterns = { "/SignupServlet" })
public class SignupServlet extends HttpServlet {

    public SignupServlet() {
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

            SignupDB db = new SignupDB();

            try {

                LoginUserBean bean = db.insertUserData(id, password);
                // ログイン判定

                if (bean != null) {
                    // ユーザー情報
                    session.setAttribute("user_db", bean);
                    session.setAttribute("login_db", "login");
                    // セッション有効時間
                    session.setMaxInactiveInterval(1000);
                    rd = request.getRequestDispatcher("./first_edit.jsp");

                } else {
                    rd = request.getRequestDispatcher("./index.html");
                }
                rd.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
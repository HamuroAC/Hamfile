package signup;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ログイン機能.
 */
@WebServlet(name = "SignupServlet", urlPatterns = { "/SignupServlet" })
@MultipartConfig(maxFileSize = 1048576)
public class SignupServlet extends HttpServlet {
    public SignupServlet() {
        super();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // ① クリックされたボタンの判定
        // ①-1 ボタン名の文字化けを防ぐために文字コードを設定してから取得
        request.setCharacterEncoding("UTF-8");

        // ② 画面移動の準備
        HttpSession session = request.getSession();	// セッション
        RequestDispatcher rd;						// 画面の情報

            // ③-1 クリックされたボタンが「ログイン」の場合はログイン処理を実施
            // ③-1-1 ログイン画面で入力されたIDとパスワードを取得
            String id = request.getParameter("id");
            String password = request.getParameter("password");
            // ③-1-2 ユーザ情報をモデルに格納するために指示
            // ③-1-3 ログイン処理クラスをインスタンス化
            SignupDB signupdb = new SignupDB();

            // ③-1-4 ID処理クラスに②-1-1で取得したIDを渡してユーザ情報をモデルに格納
            SignupUserBean bean = signupdb.getUserData(id, password);
             // ③-2 モデルの情報を判定
            if (bean == null) {

                // ③-2-2 つぎに表示させる画面（ビュー）を指定
                rd = request.getRequestDispatcher("./edit.jsp");

            } else {

                rd = request.getRequestDispatcher("./index.html");
            }

            rd.forward(request, response);
        }
    }

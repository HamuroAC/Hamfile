package upload;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.http.HttpSession;

import login.LoginUserBean;

@WebServlet(name = "UploadServlet", urlPatterns = {"/UploadServlet"})
@MultipartConfig(maxFileSize = 1048576)
public class UploadServlet extends HttpServlet {

    public UploadServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        // 文字化け防止
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        RequestDispatcher rd;

        String id = ((LoginUserBean) session.getAttribute("user_db")).getId();

        // 名前を取得
        String name = request.getParameter("name");
        // 画像を取得
        Part imagePart = request.getPart("filea");

        // 画像なし対策
        if (imagePart != null) {

            // 画像の名前を取得
            String imageName = imagePart.getSubmittedFileName();
            String path = getServletContext().getRealPath("/profile");

            // 画像書き出し
            imagePart.write(path + "/" + imageName);

        }

        UploadDB db = new UploadDB();
        try {
        LoginUserBean bean = db.uploadUserData(id, name);
                // ログイン判定
        if (bean != null) {
            // ユーザー情報
            session.setAttribute("user_db", bean);
        }
        } catch (Exception e) {
            e.printStackTrace();
        } 

        // 商品結果画面に移動
        rd = request.getRequestDispatcher("./profile.jsp");
        rd.forward(request, response);
    }
}
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
        LoginUserBean user_db = (LoginUserBean) session.getAttribute("user_db");
        String id = user_db.getId();
        System.out.println("UplordServlet:" + id);

        // 名前を取得
        String name = request.getParameter("name");
        if(name == null || name.equals("")){
            name = user_db.getName();
        }
        // 画像を取得
        Part imagePart = request.getPart("filea");
        //自己紹介文を取得
        String profile = request.getParameter("profile");
        if(profile == null || profile.equals("")){
            profile = user_db.getProfile();
        }
        // 画像なし対策
        String imageName=null;
        if (imagePart.getSize() > 0) {

            // 画像の名前を取得
            imageName = imagePart.getSubmittedFileName();
            String path = getServletContext().getRealPath("/profileimg");

            // 画像書き出し
            imagePart.write(path + "/" + imageName);
            
        } else{
            imageName = user_db.getImagepath();

        }

        UploadDB db = new UploadDB();
        try {
        db.uploadUserData(id, name,imageName,profile,user_db);
        } catch (Exception e) {
            e.printStackTrace();
        } 

        rd = request.getRequestDispatcher("./profile.jsp");
        rd.forward(request, response);
    }
}
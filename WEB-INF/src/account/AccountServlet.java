package Account;

import UserFound.UserFoundDB;

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

@WebServlet(name = "AccountServlet", urlPatterns = {"/AccountServlet"})
@MultipartConfig(maxFileSize = 1048576)
public class UploadServlet extends HttpServlet {


    public Accountservlet() {
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

request.setCharacterEncoding("UTF-8");


HttpSession session = request.getSession();
LoginUserBean user_db = (LoginUserBean) session.getAttribute("user_db");
String id = user_db.getId();



    }
}

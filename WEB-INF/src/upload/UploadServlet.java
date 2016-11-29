package upload;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "UploadServlet", urlPatterns = {"/UploadServlet"})
@MultipartConfig(maxFileSize = 1048576)
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        // get path of /profile
        String path = getServletContext().getRealPath("/profile");

        // get name
        String name = request.getParameter("name");
        UserBean bean = new UserBean();
        // set name
        if (name != null) {
            bean.setName(name);
        }

        // get filea
        Part imagePart = request.getPart("filea");

        if (imagePart != null) {

            // get name of filea
            String imageName = imagePart.getSubmittedFileName();

            // write 
            imagePart.write(path + "/" + imageName);
            bean.setImagePath(path + "/" + imageName);
        } else {
            bean.setImagePath(null);
        }
                    System.out.println(bean.getName());
            System.out.println(bean.getImagePath());
        UploadDao dao = new UploadDao();
        dao.UploadDao();
    }
}
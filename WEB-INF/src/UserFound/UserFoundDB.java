package UserFound;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import login.LoginUserBean;

public class UserFoundDB {

    public LoginUserBean userFoundData(String id) 
    //throws Exception
     {

        LoginUserBean bean = null;
        UserFoundDao dao = null;

//        try {
            
            dao = new UserFoundDao();
            // DBを更新
            bean = dao.userfoundUser(id);

         //   if(result != null) {
         //       bean = new LoginUserBean();
         //       bean.setId(id);
         //   }
//        } catch (Exception sqle) {
//            sqle.printStackTrace();
//        } finally {
//            if (dao != null) {
                // 各接続を解除
//                dao.close();
//            }
//        }
        return bean;
    }
}
package signup;

import java.sql.SQLException;

import login.LoginUserBean;

public class SignupDB {

    public LoginUserBean insertUserData(String id, String password) 
    throws Exception {

        LoginUserBean bean = null;
        InsertDao dao = null;
        int result;

        try {
            
            dao = new InsertDao();
            // DBを更新
            result = dao.insertUser(id, password);

            if(result != 0) {
                bean = new LoginUserBean();
                bean.setId(id);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            if (dao != null) {
                // 各接続を解除
                dao.close();
            }
        }
        return bean;
    }
}
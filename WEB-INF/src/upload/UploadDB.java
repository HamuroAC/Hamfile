package upload;

import java.sql.SQLException;

import login.LoginUserBean;

public class UploadDB {

    public LoginUserBean uploadUserData(String id, String name) 
    throws Exception {

        LoginUserBean bean = null;
        UploadDao dao = null;

        try {

            dao = new UploadDao();
            // DBを更新
            dao.uploadUser(id, name);

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            if (dao != null) {
            // 各接続を解除
            dao.close();
            }
        }

                bean = new LoginUserBean();
                // ID
                bean.setId(id);
                // 名前
                bean.setName(name);
        return bean;
    }
}

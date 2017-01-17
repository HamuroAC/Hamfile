package upload;

import java.sql.SQLException;

import login.LoginUserBean;

public class UploadDB {

    public void uploadUserData(String id, String name,String imagepath,String profile,LoginUserBean user_db) 
    throws Exception {

        //LoginUserBean bean = null;
       
        UploadDao dao = null;

        try {

            dao = new UploadDao();
            // DBを更新
            dao.uploadUser(id, name,imagepath,profile);

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            if (dao != null) {
            // 各接続を解除
            dao.close();
            }
        }

                // ID
                user_db.setId(id);
                // 名前
                user_db.setName(name);
                //画像名
                user_db.setImagepath(imagepath);
                //自己紹介
                user_db.setProfile(profile);
    }
}

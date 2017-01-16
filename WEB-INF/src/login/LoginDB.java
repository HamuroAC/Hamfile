package login;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ログイン処理クラス
 */
public class LoginDB extends Login {

    public LoginUserBean getUserData(String id, String password) {

        LoginUserBean bean = null;
        LoginDao dao = null;
        ResultSet rs;

        try {

            dao = new LoginDao();
            // DBを検索
            //rs = dao.selectUser(id, password);
            //上記の処理を追加項目修正
            rs = dao.selectUser(id, password);

            while (rs.next()) {

                bean = new LoginUserBean();

                // ID
                bean.setId(id);
                // 名前
                bean.setName(rs.getString("name"));
                //画像PASS
                bean.setImagepath(rs.getString("imagepath"));
                //profileの本文を追加
                bean.setProfile(rs.getString("profile"));
                
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            // 各接続を解除
            dao.close();
        }
        return bean;
    }
}
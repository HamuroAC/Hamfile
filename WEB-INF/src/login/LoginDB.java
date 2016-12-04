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
            rs = dao.selectUser(id, password);

            while (rs.next()) {

                bean = new LoginUserBean();

                // ID
                bean.setId(id);
                // 名前
                bean.setName(rs.getString("name"));
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
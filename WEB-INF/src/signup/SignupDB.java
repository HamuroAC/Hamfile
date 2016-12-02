package signup;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ログイン処理クラス. 
 * 
 * Loginクラスを親にしています
 */
public class SignupDB extends Signup {

    public SignupUserBean getUserData(String id, String password) {
        SignupUserBean bean = null;
        SelectDao daos = null;
        InsertDao daoi = null;
        ResultSet rs1;
        ResultSet rs2;

        try {
            // DAOクラスをインスタンス化
            daos = new SelectDao();
            // 画面で入力されたIDとパスワードを基にDB検索を実行
            rs1 = daos.selectUser(id, password);

            while (rs1.next()) {
                /*検索結果が存在する場合はbeanに値をセット
                 （結果が1件しか返らないことを想定）
                 */
                 bean = new SignupUserBean();
                // ID（IDは引数のものをセット）
                bean.setId(id);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            // 処理終了時に各接続を解除
            daos.close();
        }
        return bean;
            
    }
}

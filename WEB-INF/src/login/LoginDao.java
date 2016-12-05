package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ログインDAOクラス
 */
public class LoginDao {

    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;

    private final String SQL_URL = "jdbc:mysql://localhost:3306/teamA?autoReconnect=true&useSSL=false";
    private final String SQL_ID = "kunugi";
    private final String SQL_PASS = "hamuro";

    /**
     * IDとPASSWORDを使ってユーザ情報を検索
     *
     * @param id	ログインID
     * @param pass  パスワード
     * @return ユーザ情報（ResultSet）
     */
    public ResultSet selectUser(String id, String password) {
        try {

            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            // DBに接続
            con = DriverManager.getConnection(SQL_URL, SQL_ID, SQL_PASS);

            // SQLを生成
            String sql = "SELECT name FROM person WHERE id = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            // ?を設定
            ps.setString(1, id);
            ps.setString(2, password);

            // SQLを実行
            rs = ps.executeQuery();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return rs;
    }

    /**
     * コネクションをクローズ
     */
    public void close() {
        try {
            // DB接続を解除
            if (con != null) {
                con.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        }catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}

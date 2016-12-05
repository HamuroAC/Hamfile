package signup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DAOクラス.
 *
 * DaoFuctory
 */
public class SelectDao {

    private Connection con = null;
    private ResultSet rs = null;

    private final String SQL_URL = "jdbc:mysql://localhost:3306/teamA?autoReconnect=true&useSSL=false";
    private final String SQL_ID = "kunugi";
    private final String SQL_PASS = "hamuro";

    /**
     * データベースから指定されたIDとパスワードを使ってユーザ情報を検索します.
     *
     * @param id	ログインID
     * @param pass パスワード
     * @return ユーザ情報（ResultSet）
     */
    public ResultSet selectUser(String id, String password) {
        try {
            // JDBCドライバのロード
            // 「com.mysql.jdbc.Driver」クラス名
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            
            // データベースと接続（本来はユーザやパスワードも別管理にしておくのが理想）
            con = DriverManager.getConnection(SQL_URL, SQL_ID, SQL_PASS);

            // SQL文を生成
            String sql = "SELECT name FROM person WHERE id = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            // 生成したSQL文の「？」の部分にIDとパスワードをセット
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
     * コネクションをクローズします.
     */
    public void close() {
        try {
            // データベースとの接続を解除する
            if (con != null) {
                con.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException sqle) {
            // データベースとの接続解除に失敗した場合
            sqle.printStackTrace();
        }
    }
}

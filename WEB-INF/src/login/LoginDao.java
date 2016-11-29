package login;

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
public class LoginDao {

    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;

    private final String SQL_ID = "kunugi@localhost";
    private final String SQL_PASS = "hamuro";

    /**
     * データベースから指定されたIDとパスワードを使ってユーザ情報を検索します.
     *
     * @param id	ログインID
     * @param pass パスワード
     * @return ユーザ情報（ResultSet）
     */
    public ResultSet selectUser(String id, String name) {
        try {
            // JDBCドライバのロード
            // 「com.mysql.jdbc.Driver」クラス名
            Class.forName("com.mysql.jdbc.Driver");

            // データベースと接続（本来はユーザやパスワードも別管理にしておくのが理想）
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?useUnicode=true&characterEncoding=utf8", SQL_ID, SQL_PASS);

            // SQL文を生成
            ps = con.prepareStatement("select name, imgpath from user where id = ? and name = ?");

            // 生成したSQL文の「？」の部分にIDとパスワードをセット
            ps.setString(1, id);
            ps.setString(2, name);

            // SQLを実行
            rs = ps.executeQuery();
            
        } catch (ClassNotFoundException cne) {
            cne.printStackTrace();
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
            if (ps != null) {
                ps.close();
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

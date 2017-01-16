package UserFound;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import login.LoginUserBean;

/**
 * ログインDAOクラス
 */
public class UserFoundDao {

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
    public LoginUserBean userfoundUser(String id) {
        LoginUserBean bean = new LoginUserBean();
        try {
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            // DBに接続
            con = DriverManager.getConnection(SQL_URL, SQL_ID, SQL_PASS);

            // SQLを生成
            String sql = "SELECT *  FROM person WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            // ?を設定
            ps.setString(1, id);

            // SQLを実行
            rs = ps.executeQuery();
            if(rs.next()){
                bean.setId(rs.getString("id"));
                bean.setName(rs.getString("name"));
                System.out.println("id=" + rs.getString("id") + ", name=" + rs.getString("name"));
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return bean;
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

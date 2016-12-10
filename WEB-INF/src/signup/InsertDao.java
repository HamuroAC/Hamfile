package signup;

import java.sql.*;

public class InsertDao{

    private Connection con = null;
    private PreparedStatement ps = null;
    private int result;

    private final String SQL_URL = "jdbc:mysql://localhost:3306/teamA?autoReconnect=true&useSSL=false";
    private final String SQL_ID = "kunugi";
    private final String SQL_PASS = "hamuro";
    public int insertUser(String id, String password) throws Exception{
        try {

            // DBに接続
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = DriverManager.getConnection(SQL_URL, SQL_ID, SQL_PASS);

            // SQLを生成
            String sql = "INSERT INTO person(id, password) SELECT ?, ? FROM person WHERE NOT EXISTS (SELECT * FROM person WHERE id = ?) LIMIT 1;";
            ps = con.prepareStatement(sql);

            // ?を設定
            ps.setString(1, id);
            ps.setString(2, password);
            ps.setString(3, id);

            // SQLを実行
            result = ps.executeUpdate();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return result;
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
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}

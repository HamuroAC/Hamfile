package upload;

import java.sql.*;

public class UploadDao{

    private Connection con = null;
    private PreparedStatement ps = null;

    private final String SQL_URL = "jdbc:mysql://localhost:3306/teamA?autoReconnect=true&useSSL=false";
    private final String SQL_ID = "kunugi";
    private final String SQL_PASS = "hamuro";

    public void uploadUser(String id, String name) throws Exception{
        try {

            // DBに接続
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = DriverManager.getConnection(SQL_URL, SQL_ID, SQL_PASS);

            // SQLを生成
            String sql = "UPDATE person SET name = ? WHERE id = ?";
            ps = con.prepareStatement(sql);

            // ?を設定
            ps.setString(1, name);
            ps.setString(2, id);

            // SQLを実行
            ps.executeUpdate();

            }  catch (SQLException sqle) {
            sqle.printStackTrace();
            }
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

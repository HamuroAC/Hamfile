package upload;

import java.sql.*;

public class UploadDao{
    public void UploadDao() {

        Connection con = null;
        // db settings
        String dbUrl = "jdbc:mysql://localhost:3306/hamfile?autoReconnect=true&useSSL=false";
        String dbUser = "kunugi";
        String dbPassword = "hamuro";
        UserBean bean = new UserBean();
        String id = "HAMURO_IS_GOD";
        try {
            // connect db
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            // make sql
            String sql = "UPDATE person SET name = ?, imagepath = ? " +
            "WHERE id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            // set values
                        System.out.println(bean.getName());
            System.out.println(bean.getImagePath());
            statement.setString(1, bean.getName());
            statement.setString(2, bean.getImagePath());
            statement.setString(3, id);
            // do sql
            int row = statement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("a");
                 e.printStackTrace();
                } finally {
                    if (con != null) {
                        try {
                            con.close();
                            } catch (SQLException e) {
                                System.out.println("b");
                            }
                    }
                }
    }
}
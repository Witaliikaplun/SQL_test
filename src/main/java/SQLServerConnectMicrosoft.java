import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.sql.*;

public class SQLServerConnectMicrosoft {

    public static void initialConnect(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
//            Connection con = DriverManager.getConnection("jdbc:sqlserver://CLK5101N","LoginSQL", "12345");

            String connectionUrl = "jdbc:sqlserver://localhost:55319;" +
                    "databaseName=DATA_WINCC_TEST;user=LoginSQL;password=12345";
            Connection con = DriverManager.getConnection(connectionUrl);
            System.out.println(con);
            Statement statement = con.createStatement();
            String sqlQuere = "SELECT TOP 10 * FROM Table_888";
            ResultSet rs = statement.executeQuery(sqlQuere);
            

            while (rs.next()){
                System.out.println(rs.getInt("data"));
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

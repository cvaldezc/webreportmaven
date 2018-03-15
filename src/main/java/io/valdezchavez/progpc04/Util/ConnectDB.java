package io.valdezchavez.progpc04.Util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Christian
 */
public class ConnectDB {

    private static final String DATABASE = "bdComercial04";

    private ConnectDB() {
    }

    public static Connection getConnection() {
        Connection cn = null;
        try {
            String uri, user, passwd;
            uri = "jdbc:mysql://localhost:3306/" + DATABASE;
            user = "root";
            passwd = "cjavaperu";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cn = DriverManager.getConnection(uri, user, passwd);
        } catch (SQLException |
                ClassNotFoundException |
                InstantiationException |
                IllegalAccessException e) {
            LoggerUtil.getInstance().getLogger().error(e.getMessage());
        }
        return cn;
    }

}

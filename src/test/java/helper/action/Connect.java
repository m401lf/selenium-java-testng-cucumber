package helper.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connect {

    private Connection conn;

    public Connect() {
    }

    public void setConnection(String database, String user, String password, String url) throws IOException {

        java.io.InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("my.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        String format = url + database;
        Properties props = new Properties();
        props.put("user", user);
        if (password != null) {
            props.put("password", password);
        }
        try {
            this.conn = DriverManager.getConnection(format, props);
            if (properties.getProperty("uitesting.url").contains("beta.jobs.nhs.uk")) {
                String schema = database.substring(0, database.length() - 5) + "_01";
                this.conn.setSchema(schema);
            }
            this.conn.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        return this.conn;
    }

    public void closeConnection() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

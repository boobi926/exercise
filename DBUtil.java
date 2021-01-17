package blog;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

//Utilize工具
public class DBUtil {
   // 静态属性，这个代码运行过程中，只有一份（整个进程运行过程中）
    private static  DataSource dataSourse = null;

    static {
        initDtaSourse();
    }

    private static void initDtaSourse(){
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setServerName("127.0.0.1");
        mysqlDataSource.setPort(3306);
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("1234");
        mysqlDataSource.setDatabaseName("boke");
        mysqlDataSource.setUseSSL(false);
        mysqlDataSource.setCharacterEncoding("utf8");

        dataSourse = mysqlDataSource;
    }

    public static Connection getConnection() throws SQLException {
        return (Connection) dataSourse.getConnection();
    }
}

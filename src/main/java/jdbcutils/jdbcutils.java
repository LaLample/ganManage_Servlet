package jdbcutils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
//druid连接池技术
/**
 * jdbc工具类
 */
public class jdbcutils {
    private static DataSource ds;
    static{

        try {/**
         * 加载配置文件
         */
            Properties pro=new Properties();
            /**
             * 使用classload加载配置文件，获取字节输入流
             */
            InputStream is=jdbcutils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            /**
             * 初始化连接池对象
             */
            ds=DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取连接池对象
     */
    public static DataSource getDataSource(){

        return ds;
    }

    /**
     * 获取connection对象
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}

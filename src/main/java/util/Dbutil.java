package util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.*;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
public class Dbutil {
    //接受配置文件中的键值对
    private static Properties properties = new Properties();
    static {
        try {
            //加载配置文件 用输入流
//            InputStream in=Dbutil.class.getClassLoader().getResourceAsStream("JDBCutil.properties");
            BufferedReader in=new BufferedReader(new FileReader("src/main/resources/JDBCutil.properties"));
//            if(in == null)
//            System.out.println("aaa");
            // 通过load方法 把输入流加载到输入对象中
            properties.load(in);
            //获取驱动名字
            Class.forName(properties.getProperty("jdbcName"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // get-> 获取数据库连接
    public static Connection getConnection(){
        Connection connection = null;
        try {
            String Url=properties.getProperty("dbUrl");
            String Name=properties.getProperty("dbName");
            String Pwd=properties.getProperty("dbPwd");
            connection= DriverManager.getConnection(Url,Name,Pwd);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    //关闭资源
    public static void close(ResultSet resultSet, PreparedStatement statement,
                             Connection connection){
        //判断资源对象如果不为空 则关闭资源
        try {
            if(resultSet != null)
            {
                resultSet.close();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        realse(statement,connection);
    }
    public static void realse(PreparedStatement statement,Connection connection){
        try{
            if(statement!= null) statement.close();
            if(connection != null) connection.close();
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
}

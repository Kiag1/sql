package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLAdd {
    public static void Adding(String name,String ss,String sno,String date,int t) throws Exception{
        Connection connection=null;
        PreparedStatement statement=null;

        try{
            connection = Dbutil.getConnection();
            String sql = "insert into student_temp(Sname,Ss,Sno,Stime,Time) values(?,?,?,?,?)";
            statement = connection.prepareStatement(sql);

            statement.setString(1, name);
            statement.setString(2, ss);
            statement.setString(3, sno);
            statement.setString(4, date);
            statement.setInt(5, t);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Dbutil.realse(statement,connection);
        }
    }
}

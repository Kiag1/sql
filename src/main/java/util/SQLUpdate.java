package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLUpdate {
    static void Update_time(String name,String sno,int time){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection=Dbutil.getConnection();
            String sql="update student_temp set Time=? where Sname=? and Sno=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,time);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,sno);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Dbutil.realse(preparedStatement,connection);
        }
    }
}

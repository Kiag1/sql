package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLDelete {
    public static void Deleting(String name,String sno){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection=Dbutil.getConnection();
            String str="delete from student_temp where Sname=? and Sno=?";
            preparedStatement=connection.prepareStatement(str);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,sno);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Dbutil.realse(preparedStatement,connection);
        }
    }
}

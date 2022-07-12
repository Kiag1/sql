package util;
import EXCEL.DATA;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLSelecting {

    public static DATA[] SelectingAll() throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = Dbutil.getConnection();
            String sql = "select Sname,Ss,Sno,Stime,Time from student_temp";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery(sql);
            List list = new ArrayList();
            while (resultSet.next()) {
                DATA sql_data = new DATA();
                sql_data.setName(resultSet.getString(1));
                sql_data.setXueyuan(resultSet.getString(2));
                sql_data.setSno(resultSet.getString(3));
                sql_data.setNow_time(resultSet.getString(4));
                sql_data.setTime(resultSet.getInt(5));
                list.add(sql_data);
            }
            if (list != null && list.size() > 0) {
                DATA[] data = new DATA[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    data[i] = (DATA) list.get(i);
                }

                return data;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Dbutil.close(resultSet, statement, connection);
        }
        return null;
    }

    public static DATA[] Name_Selecting(String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = Dbutil.getConnection();
            String sql = "select Sname,Ss,Sno,Stime,Time from student_temp where Sname=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            List list = new ArrayList();
            String[] strings = new String[5];
            while (resultSet.next()) {
                DATA sql_data = new DATA();
                sql_data.setName(resultSet.getString(1));
                sql_data.setXueyuan(resultSet.getString(2));
                sql_data.setSno(resultSet.getString(3));
                sql_data.setNow_time(resultSet.getString(4));
                sql_data.setTime(resultSet.getInt(5));
                list.add(sql_data);
            }
            if (list != null && list.size() > 0) {
                DATA[] data = new DATA[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    data[i] = (DATA) list.get(i);
                }
                return data;
            }
        }catch(SQLException e){
                e.printStackTrace();
            }finally{
                Dbutil.realse(preparedStatement, connection);
            }
        return null;
        }
}
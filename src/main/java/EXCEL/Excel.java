package EXCEL;
import jxl.*;
import jxl.read.biff.BiffException;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Excel {
    public static void main(String[] args) {
        //Excel文件路径
        File path=new File("D:\\Excel-MySQL\\test_1.xls");
        try {
            //读数据
            ReadExcel.readExcel(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (BiffException e) {
            throw new RuntimeException(e);
        }
    }
}
class ReadExcel {
    private static String dirvername="com.mysql.cj.jdbc.Driver";//驱动名字
    //MySQL的URL
    private static String url="jdbc:mysql://localhost:3306/libtime?useUnicode=true&characterEncoding=utf8&useSSL=false";
    //用户名
    private static String user="root";
    //密码
    private static String password="Ly011219";
    //数据库连接
    private static Connection connection=null;

    private static PreparedStatement preparedStatement=null;

    public static void readExcel (File path)throws IOException, BiffException{
        //connecting —— mysql
        try{
            Class.forName(dirvername);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try{
            connection= DriverManager.getConnection(url,user,password);//获取libtime数据库的连接
        }catch (SQLException e){
            e.printStackTrace();
        }

        Workbook workbook=Workbook.getWorkbook(path);
        Sheet[] sheets= workbook.getSheets();
        if (connection != null) {
            for(Sheet sheet:sheets){
                //获取excel行数
                int rows = sheet.getRows();
                //获取excel列数
                int cols = sheet.getColumns();

                //读数据
                for(int r = 2;r < rows;r++){
                    String [] values = new String[5];
                    for(int c = 0; c < cols; c++){
                        //放入数组VALUES中
                        values[c]=sheet.getCell(c,r).getContents();
                    }
                    //写入数据库中
                    try{
                        preparedStatement = connection.prepareStatement("insert into test(Sname,xueyuan,sno,now_time,time) values (?,?,?,?,?);");
                        //姓名 学院 学号 查询时间 时长
                        preparedStatement.setNString(1,values[0]);
                        preparedStatement.setObject(2,values[1]);
                        preparedStatement.setNString(3,values[2]);
                        preparedStatement.setNString(4,values[3]);
                        preparedStatement.setNString(5,values[4]);
                        //执行insert语句
                        preparedStatement.executeUpdate();
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                }
            }
        }
        workbook.close();
        try{
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

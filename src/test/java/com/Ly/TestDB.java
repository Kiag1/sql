package com.Ly;

import EXCEL.DATA;
import org.junit.Test;
import util.Dbutil;
import util.SQLSelecting;

//单元测试
public class TestDB {
    @Test
    public void TestDB() {
        System.out.println(Dbutil.getConnection());
    }

    @Test
    public void h1() throws Exception {

        DATA[] a = SQLSelecting.SelectingAll();

        String[][] message = new String[a.length][];
        Object[][] tableBody = new String[a.length][];
        for (int i = 0; i < a.length; i++) {
            message[i] = a[i].getMessage();
            tableBody[i] = message[i];

        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < message[i].length; j++) {
                System.out.printf("%s ", message[i][j]);
            }
            System.out.println();
        }

//        String[] title = {"姓名", "学院", "学号", "日期", "时长"};
//
//        JFrame jFrame = new JFrame("展示测试");
//        jFrame.setBounds(500, 250, 900,600);
//
////        JTable jTable = new JTable(tableBody, title);
////        JScrollPane jScrollPane = new JScrollPane(jTable);
////        jScrollPane.setBounds(400, 250, 500, 500);
////        jScrollPane.setVisible(true);
//
////        jFrame.add(jScrollPane);
//        jFrame.setVisible(true);
//        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

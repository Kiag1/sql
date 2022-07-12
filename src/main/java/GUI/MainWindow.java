package GUI;

import util.GetMessageTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainWindow {
    public static final String[] title = {"姓名", "学院", "学号", "日期", "时长"};

    public static void main(String[] args) throws Exception{
//        Object[][] tableBody = new GetMessageTable().MessageTable("刘大途");
        String[][] tableBody = new GetMessageTable().TotalMessageTable();

        JFrame jFrame = new JFrame("展示测试");
        jFrame.setBounds(500, 250, 400,400);
        jFrame.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton jButton1 = new JButton();
        jButton1.setBounds(1, 1,1,1);
        JButton jButton2 = new JButton();
        JButton jButton3 = new JButton();
        JButton jButton4 = new JButton();

//        jButton1.addActionListener();

        jFrame.add(jButton1);
        jFrame.add(jButton2);
        jFrame.add(jButton3);
        jFrame.add(jButton4);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

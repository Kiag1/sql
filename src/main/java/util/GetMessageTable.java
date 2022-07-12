package util;

import EXCEL.DATA;

public class GetMessageTable {
    public String[][] TotalMessageTable()throws Exception{
        DATA[] a = SQLSelecting.SelectingAll();
        String[][] message = new String[a.length][];
        String[][] tableBody = new String[a.length][];
        for (int i = 0; i < a.length; i++) {
            message[i] = a[i].getMessage();
            tableBody[i] = message[i];
        }
        return tableBody;
    }
    public String[][] MessageTable(String name) throws Exception{
        DATA[] a= SQLSelecting.Name_Selecting(name);
        String[][] message=new String[a.length][];
        message [0] =a[0].getMessage();

        System.out.println( message[0][0] + message[0][1] );

        return message;
    }
}

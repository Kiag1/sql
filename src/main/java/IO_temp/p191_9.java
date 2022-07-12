package IO_temp;

import java.util.*;
import java.io.*;

public class p191_9 {
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        File file=new File("D:/t1.txt");
        File fileto=new File("D:/t2.txt");
        String str=scanner.next();
        BufferedOutputStream b1=new BufferedOutputStream(new FileOutputStream(file));

        b1.write(str.getBytes());
        b1.close();

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        BufferedOutputStream b2=new BufferedOutputStream(new FileOutputStream(fileto));
        String str1=null;
        while(bufferedReader.read()!=-1) {
            str1+=bufferedReader.readLine();
        }
        char []ch=str1.toCharArray();
        Arrays.sort(ch);
        str1=ch.toString();

        b2.write(str.getBytes());
        b2.close();
    }
}


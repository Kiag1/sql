package IO_temp;

import java.io.*;
import java.util.*;
import java.util.zip.ZipOutputStream;

public class IO_test {
    public static void main(String[] args) {

    }
}
/*
�ڵ��������Դӻ���һ���ض��ĵط�(�ڵ�)��д���ݣ�ֱ����������Դ������������ļ���FileReader��
�����������顢�ܵ����ַ������ؼ��ֱַ�ΪByteArray/CharArray��Piped��String
����������װ����������ֱ����������Դ���Ƕ�һ���Ѵ��ڵ��������Ӻͷ�װ����һ�ֵ��͵�װ�������ģʽ��ʹ�ô�������Ҫ��Ϊ�˸������ִ���������������
��PrintStream��������ܺ�ǿ������BufferedReader�ṩ������ƣ��Ƽ����ʱ��ʹ�ô�������װ��
* */
class Temp1{
    public void f1(){
        //File ����io�� Fileֻ�������ļ���һЩ���Ժ͹������
        File file=new File("o");//·������
    }
    //�ַ��� Reader �� Writer
    //ת���� InputStreamReader ��OutputStreamWriter --> �ֽ���ת��Ϊ�ַ���
    //Buffered ������ BufferedWriter��BufferedReader������ ��Ҫ�׽ڵ���
    //���л���Object
    //�ֽ���InputStream �� OutputStream
    public void reading(File fname) throws IOException {
        InputStream in=new FileInputStream(fname);
        while(in.read()!=-1){
            System.out.println((char)in.read());
        }
        in.close();
    }
    public void writing(File file) throws  IOException{
        OutputStream outputStream=new FileOutputStream(file);
        outputStream.close();
    }
    public void Buff_r(File name)throws IOException{
        BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream(name));
    }

}
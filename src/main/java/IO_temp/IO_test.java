package IO_temp;

import java.io.*;
import java.util.*;
import java.util.zip.ZipOutputStream;

public class IO_test {
    public static void main(String[] args) {

    }
}
/*
节点流：可以从或向一个特定的地方(节点)读写数据，直接连接数据源。如最常见的是文件的FileReader，
还可以是数组、管道、字符串，关键字分别为ByteArray/CharArray，Piped，String
处理流（包装流）：并不直接连接数据源，是对一个已存在的流的连接和封装，是一种典型的装饰器设计模式，使用处理流主要是为了更方便的执行输入输出工作，
如PrintStream，输出功能很强大，又如BufferedReader提供缓存机制，推荐输出时都使用处理流包装。
* */
class Temp1{
    public void f1(){
        //File 不是io； File只是描述文件的一些属性和管理操作
        File file=new File("o");//路径名称
    }
    //字符流 Reader 和 Writer
    //转换流 InputStreamReader 和OutputStreamWriter --> 字节流转换为字符流
    //Buffered 缓冲流 BufferedWriter、BufferedReader处理流 需要套节点流
    //序列化：Object
    //字节流InputStream 和 OutputStream
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
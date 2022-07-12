package IO_temp;
import java.io.*;
import java.lang.*;
public class P191_10 {
    public static void main(String args[]) throws IOException, ClassNotFoundException {
        Student student=new Student("zhangsan",19,"03");
        ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream("D:/Hello.txt"));
        outputStream.writeObject(student);
        outputStream.close();
        ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream("D:/Hello.txt"));
        Student s1=(Student) objectInputStream.readObject();
        System.out.println(s1.toString());
        objectInputStream.close();
    }
}
class Student implements Serializable{
    String name;
    int age;
    String Class;
    //transient 保存和读出的时候不会对其处理，常用于保护密码
    transient String password="123456";
    public Student(String name,int age,String aClass){
        this.name=name;
        this.age=age;
        this.Class=aClass;
    }
    public Student(){
        
    }
    public String toString(){
       return ("姓名："+this.name+"，年龄："+this.age+"，班级："+this.Class+"，密码："+this.password);
    }
    public void setP(String s){
        this.password=s;
    }
}
/**
  * @authod hzchenzhe1
  * @date 10/19/17.
  * @description
  *
  */

/**
  * 单例对象 Scala语言并不支持静态成员
 */
object Student {

  private var studentNo:Int = 0
  def uniqueStudentNo() = {
    studentNo += 1
    studentNo
  }

  def main(args: Array[String]): Unit = {
    println(Student.uniqueStudentNo())
  }
}

/**
  * 编译之后生成2个文件
  * Student$.class
  * Student.class
  *
  * Compiled from "Student.scala"
public final class cn.scala.xtwy.Student$ {
  public static final cn.scala.xtwy.Student$ MODULE$;  静态final，类似饥饿式
  private int studentNo;
  public static {};
  private int studentNo();
  private void studentNo_$eq(int);
  public int uniqueStudentNo();
  private cn.scala.xtwy.Student$();  私有化的构造方法
}

D:\ScalaWorkspace\ScalaChapter06_2\bin\cn\scala\xtwy>javap -private Student
警告: 二进制文件Student包含cn.scala.xtwy.Student
Compiled from "Student.scala"
public final class cn.scala.xtwy.Student {
  public static void main(java.lang.String[]);
  public static int uniqueStudentNo();
}
  */

//定义一个class, 这时候object Student就是class Student的伴生对象， class Student是object Student的伴生类
class Student(var name:String,age:Int) {
}
/**
  在编译之后
  Compiled from "Student.scala"
public class cn.scala.xtwy.Student {
  private java.lang.String name;
  private int age;
  public static void main(java.lang.String[]);
  public static int uniqueStudentNo();
  public java.lang.String name();
  public void name_$eq(java.lang.String);
  public int age();
  public void age_$eq(int);
  public cn.scala.xtwy.Student(java.lang.String, int);
}

D:\ScalaWorkspace\ScalaChapter06_2\bin\cn\scala\xtwy>javap -private Student$
警告: 二进制文件Student$包含cn.scala.xtwy.Student$
Compiled from "Student.scala"
public final class cn.scala.xtwy.Student$ {
  public static final cn.scala.xtwy.Student$ MODULE$;
  private int studentNo;
  public static {};
  private int studentNo();
  private void studentNo_$eq(int);
  public int uniqueStudentNo();
  public void main(java.lang.String[]);
  private cn.scala.xtwy.Student$();
}

  其实伴生对象与伴生类本质上是不同的两个类，只不过伴生类与伴生对象之间可以相互访问到对主的成员包括私有的成员变量或方法
  */

class Student1(var name:String,age:Int) {
  private var sex:Int=0
  //直接访问伴生对象的私有成员
  def printCompanionObject()=println(Student1.studentNo)
}

object Student1 {

  private var studentNo:Int=0;
  def uniqueStudentNo()={
    studentNo+=1
    studentNo
  }
  def main(args: Array[String]): Unit = {
    println(Student1.uniqueStudentNo())
    val s=new Student1("john",29)
    //直接访问伴生类Student中的私有成员
    println(s.sex)
  }
}

/**
  通过定义apply 方法来new 对象，避免显示new
  apply 方法都是定义在伴生对象中
  */
//定义Student类，该类称为伴生类，因为在同一个源文件里面，我们还定义了object Student
class Student2(var name:String,var age:Int){
  private var sex:Int=0
  //直接访问伴生对象的私有成员
  def printCompanionObject()=println(Student2.studentNo)

}

//伴生对象
object Student2 {
  private var studentNo:Int=0;
  def uniqueStudentNo()={
    studentNo+=1
    studentNo
  }
  //定义自己的apply方法
  def apply(name:String,age:Int)=new Student2(name,age)
  def main(args: Array[String]): Unit = {
    println(Student.uniqueStudentNo())
    val s=new Student2("john",29)
    //直接访问伴生类Student中的私有成员
    println(s.sex)

    //直接利用类名进行对象的创建，这种方式实际上是调用前面的apply方法进行实现，这种方式的好处是避免了自己手动new去创建对象
    val s1=Student2("john",29)
    println(s1.name)
    println(s1.age)
  }
}
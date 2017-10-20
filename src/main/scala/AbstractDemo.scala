/**
  * @authod hzchenzhe1
  * @date 10/20/17.
  * @description
  *
  */
/**
  * 抽象类
  */
abstract class AbstractDemo {
  def eat:Unit  //抽象方法
  //抽象字段(域）
  //前面我们提到，一般类中定义字段的话必须初始化，而抽象类中则没有这要求
  var height:Int
}

//Person继承Animal，对eat方法进行了实现
//通过主构造器对height参数进行了初始化
class Person(var height:Int) extends AbstractDemo{
  //对父类中的方法进行实现，注意这里面可以不加override关键字
  def eat()={
    println("eat by mouth")
  }

}

//通过扩展App创建程序的入口
object Person extends App{
  new Person(10).eat()
}

/**
Compiled from "Person.scala"
public abstract class cn.scala.xtwy.Animal {
  public abstract int height();
  public abstract void height_$eq(int);
  public abstract void eat();
  public cn.scala.xtwy.Animal();
}

//Person类对应的字节码文件
D:\ScalaWorkspace\ScalaChapter06_2\bin\cn\scala\xtwy>javap -private Person.class

Compiled from "Person.scala"
public class cn.scala.xtwy.Person extends cn.scala.xtwy.Animal {
  private int height;
  public static void main(java.lang.String[]);
  public static void delayedInit(scala.Function0<scala.runtime.BoxedUnit>);
  public static java.lang.String[] args();
  public static void scala$App$_setter_$executionStart_$eq(long);
  public static long executionStart();
  public int height();
  public void height_$eq(int);
  public void eat();
  public cn.scala.xtwy.Person(int);
}

//伴生对象Person对应的字节码文件内容
D:\ScalaWorkspace\ScalaChapter06_2\bin\cn\scala\xtwy>javap -private Person$.clas
s
Compiled from "Person.scala"
public final class cn.scala.xtwy.Person$ implements scala.App {
  public static final cn.scala.xtwy.Person$ MODULE$;
  private final long executionStart;
  private java.lang.String[] scala$App$$_args;
  private final scala.collection.mutable.ListBuffer<scala.Function0<scala.runtim
e.BoxedUnit>> scala$App$$initCode;
  public static {};
  public long executionStart();
  public java.lang.String[] scala$App$$_args();
  public void scala$App$$_args_$eq(java.lang.String[]);
  public scala.collection.mutable.ListBuffer<scala.Function0<scala.runtime.Boxed
Unit>> scala$App$$initCode();
  public void scala$App$_setter_$executionStart_$eq(long);
  public void scala$App$_setter_$scala$App$$initCode_$eq(scala.collection.mutabl
e.ListBuffer);
  public java.lang.String[] args();
  public void delayedInit(scala.Function0<scala.runtime.BoxedUnit>);
  public void main(java.lang.String[]);
  private cn.scala.xtwy.Person$();
}
  */
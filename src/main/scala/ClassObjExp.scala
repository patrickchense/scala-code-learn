import scala.beans.BeanProperty

/**
  * @authod hzchenzhe1
  * @date 9/29/17.
  * @description
  * Person javap 之后
  * public class cn.scala.xtwy.Person {
  private java.lang.String name;
  public java.lang.String name();
  public void name_$eq(java.lang.String);
  public cn.scala.xtwy.Person();
}
  默认添加了name() 和 name_=() 及 NoArgsConstructor
  即使定义的name 没有加 限定符 private ,生成的还是private, 提供了 setter 和getter

  */
class Person {
  //类成员必须初始化，否则会报错
  //这里定义的是一个公有成员
  var name:String=null

  //定义私有成员
  private var privateName:String=null;

  //getter方法 //自己定义getter,setter
  def firstName=privateName
  //setter方法
  def firstName_=(name:String){
    this.privateName=name
  }

  //如果类的成员域是val类型的变量，则只会生成getter方法, 对应java中的final
  val sex = 1;

  //成员域定义为private[this]，则不会生成getter、setter方法
  private[this] val age = 18

  //@BeanProperty用于生成getXxx,setXxx方法
  @BeanProperty var height = 178
}

//主构造器的定义与类的定义交织在一直，将构造器参数直接放在类名称之后
class Person1(val name1:String, val age1:Int)

/**
  * javap之后，生成了下面的class
  * public class cn.scala.xtwy.Person {
  private final java.lang.String name;
  private final int age;
  public java.lang.String name();
  public int age();
  public cn.scala.xtwy.Person(java.lang.String, int);
}

//不难看出：上面的代码与下列java语言编写的代码等同
public class Person{
  private final String name;
  private final int age;
  public Person(String name,int age){
       this.name=name;
       this.age=age;
  }
  public String getName(){ return name}
  public int getAge() {return age}
}
  */

//主构建器还可以使用默认参数
class Person2(val name:String="",val age:Int=18) {
  println("constructing Person ........")
  override def toString()= name + ":"+ age
}

//主构造器中的参数还可以加访问控制符
class Person3(val name:String="",private val age:Int=18){
  println("constructing Person ........")
  override def toString()= name + ":"+ age
}

//当主构造器的参数不用var或val修饰的时候，参数会生成类的私有val成员，并且不会产生getter和setter方法
class Person4(name:String,age:Int){
  println("constructing Person ........")
  override def toString()= name + ":"+ age
}
/**
  * Compiled from "Person.scala"
public class cn.scala.xtwy.Person {
  private final java.lang.String name;
  private final int age;
  public java.lang.String toString();
  public cn.scala.xtwy.Person(java.lang.String, int);
}

  */
//将上述Person类中的toString()方法去掉，则类中无任何地方使用了主构造器的参数，此时主构造器参数不会生成类成员
class Person5( val name:String,age:Int){
  println("constructing Person ........")
}
/**
  * Compiled from "Person.scala"
public class cn.scala.xtwy.Person {
  public cn.scala.xtwy.Person(java.lang.String, int);
}
  */

//在某些情况下，可能需要禁用主构建器
//类名后面紧跟private关键字可以将主构建器设为私有，不允许外部使用
class Person6 private(var name:String,var age:Int){
  println("constructing Person ........")
}
/**
  * Compiled from "Person.scala"
public class cn.scala.xtwy.Person {
  private java.lang.String name;
  private int age;
  public java.lang.String name();
  public void name_$eq(java.lang.String);
  public int age();
  public void age_$eq(int);
  private cn.scala.xtwy.Person(java.lang.String, int);
}
//此时不能直接这么用
  scala> val p=new Person("john",19)
<console>:9: error: constructor Person in class Person cannot be accessed in obj
ect $iw
       val p=new Person("john",19)
  */

//辅助构造函数
/**
  * 禁用掉了主构建器，则必须使用辅助构造函数来创建对象。辅助构造函数具有两个特点：
  * （1）辅助构建器的名称为this，java中的辅助构造函数与类名相同，这常常会导致修改类名时出现不少问题，scala语言避免了这样的问题；
  * （2）调用辅助构造函数时，必须先调用主构造函数或其它已经定义好的构造函数。
  */

//只有辅助构造函数的类
class Person7{
  //类成员
  private var name:String=null
  private var age:Int=18
  private var sex:Int=0

  //辅助构造器
  def this(name:String){
    this()
    this.name=name
  }
  def this(name:String,age:Int){
    this(name)
    this.age=age
  }
  def this(name:String,age:Int,sex:Int){
    this(name,age)
    this.sex=sex
  }
}
/**
Compiled from "Person.scala"
public class cn.scala.xtwy.Person {
  private java.lang.String name;
  private int age;
  private int sex;
  private java.lang.String name();
  private void name_$eq(java.lang.String);
  private int age();
  private void age_$eq(int);
  private int sex();
  private void sex_$eq(int);
  public cn.scala.xtwy.Person();
  public cn.scala.xtwy.Person(java.lang.String);
  public cn.scala.xtwy.Person(java.lang.String, int);
  public cn.scala.xtwy.Person(java.lang.String, int, int);
}

  */

//在定义辅助构造函数时，需要注意构造函数的顺序
class Person8{
  //类成员
  private var name:String=null
  private var age:Int=18
  private var sex:Int=0

  //辅助构造器
/*  def this(name:String,age:Int,sex:Int){
    this(name,age)//此处会发生编译错误，这是因为def this(name:String,age:Int)没有被定义
    this.sex=sex
  }

  def this(name:String){
    this()
    this.name=name
  }
  def this(name:String,age:Int){
    this(name)
    this.age=age
  }*/

}

//具有主构建函数和辅助构建函数的Person类
class Person9(var name:String,var age:Int){
  //类成员
  private var sex:Int=0

  //辅助构造器
  def this(name:String,age:Int,sex:Int){
    this(name,age)
    this.sex=sex
  }
}

//禁用主构造函数
class Person10 private(var name:String,var age:Int){
  //类成员
  private var sex:Int=0

  //辅助构造器
  def this(name:String,age:Int,sex:Int){
    this(name,age)
    this.sex=sex
  }

}
/**
Compiled from "Person.scala"
public class cn.scala.xtwy.Person {
  private java.lang.String name;
  private int age;
  private int sex;
  public java.lang.String name();
  public void name_$eq(java.lang.String);
  public int age();
  public void age_$eq(int);
  private int sex();
  private void sex_$eq(int);
  private cn.scala.xtwy.Person(java.lang.String, int);
  public cn.scala.xtwy.Person(java.lang.String, int, int);
}
  */


object ClassObjExp {

  def main(args: Array[String]):Unit = {
    val p = new Person()
    p.name_=("John")
    //或者直接修改
    p.name = "John"
    p.name //get

  }
}

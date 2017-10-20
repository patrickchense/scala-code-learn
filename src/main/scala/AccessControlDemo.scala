/**
  * @authod hzchenzhe1
  * @date 10/20/17.
  * @description
  *
  */
/**
  * 在scala中没有public关键字，仅有private 和 protected访问控制符，当一个类成员不加private和protected时，它的访问权限就是public
  */
class AccessControlDemo(var name:String,var age:Int){
  private var sex:Int=0
  //内部类
  class Course(val cName:String,val gpa:Float){
    //可以直接访问其外部类的私有成员
    def getStudentSex(student:AccessControlDemo)= student.sex
  }
}

//班级类
class Class{
  //下面这条语句统计通不过，因为sex是私有的
  // def getStudentSex(student:Student)=student.sex
}
object AccessControlDemo {
  private var studentNo:Int=0;
  def uniqueStudentNo()={
    studentNo+=1
    studentNo
  }
  def apply(name:String,age:Int)=new AccessControlDemo(name,age)

  def main(args: Array[String]): Unit = {
    println(AccessControlDemo.uniqueStudentNo())
    val s=new AccessControlDemo("john",29)
    //直接访问伴生类Student中的私有成员
    println(s.sex)

    val s1=AccessControlDemo("john",29)
    println(s1.name)
    println(s1.age)

    //使用内部类
    val c1=new s1.Course("Scala",3.0f)

  }
}

/**
在scala中，protected成员只能被该类及其子类访问
  */
class SuperClass {
  protected def f()=println(".....")
}

class SubClass extends SuperClass{
  f()
}

class OtherClass{
  //下面这个语句会报错
  //f()
}

/**
scala中提供了更为灵活的访问控制方法，private、protected除了可以直接修饰成员外，
还可以以private[X]、protected[X]的方式进行更为灵活的访问控制，这种访问控制的意思是可以将private、protected限定到X，X可以是包、类，还可以是单例对象v
  */
package cn{
  class UtilsTest{
    //编译通不过，因为Utils利用private[scala]修饰，只能在scala及其子包中使用
    //Utils.toString()
  }
  package scala{
    //private[scala]限定Utils只能在scala及子包中使用
    private[scala] object Utils{
      def toString(x:String){
        println(x)
      }
      import cn.scala.xtwy._
      def getTeacher():Teacher=new Teacher("john")

    }
    package xtwy{
      class Teacher(var name:String) {
        def printName()={Utils.toString(name)}
      }

    }
  }
}
object appDemo{
  import cn.scala._
  import cn.scala.xtwy._
  def main(args: Array[String]): Unit = {
    //编译通不过，同UtilsTest
    //Utils.toString(new Teacher("john").name)
    new Teacher("john").printName()
  }

}

//private[this]，限定只有该类的对象才能访问，称这种成员为对象私有成员
class Teacher1(var name: String) {
  private[this] def printName(tName:String="") :Unit= { println(tName) }
  //调用private[this] printName方法
  def print(n:String)=this.printName(n)
}

object Teacher1{
  //private[this]限定的成员，即使伴生对象Teacher也不能使用
  //def printName=new Teacher("john").printName()
}

object appDemo1 {
  def main(args: Array[String]): Unit = {
    //编译不能通过
    //new Teacher("john").printName()
  }

}

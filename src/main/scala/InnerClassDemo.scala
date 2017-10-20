/**
  * @authod hzchenzhe1
  * @date 10/20/17.
  * @description
  *
  */
class InnerClassDemo {

}

/**
  * 外部类不能访问内部类的成员域，但内部类可以直接访问外部类成员域，哪怕这个成员域是private私有的
  */
class OuterClass {
  //即使定义为 private[this] var x:Int=0，也是可行的
  private var x:Int=0

  //def getInnerY=y，外部类不能直接访问内部类的成员域
  class InnerClass{
    private var y:Int=0
    //内部的类可以直接访问外部类的成员变量和成员方法,注意外部类的成员变量是private
    def getOuterX= x
  }
}

object AppDemo{
  def main(args: Array[String]): Unit = {
    val o=new OuterClass
    //创建内部类对象，通过o.InnerClass方式，InnerClass就像是OuterClass的成员变量一样
    val i=new o.InnerClass
    println(i.getOuterX)
  }
}
//内部类除了是一个类之外，与外部类的成员没有任何区别，它可以与外部类的成员域一样被使用
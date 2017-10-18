/**
  * @authod hzchenzhe1
  * @date 9/28/17.
  * @description
  *
  */
object FuncClojureExp {

  val increase=(x:Int)=>x+1 //increase: Int => Int = <function1>

  def increaseAnother(x:Int)=x+1 //和上面一样效果

  //值函数简化
  val fun1 = 1 + (_:Double)

  val fun2:(Double)=>Double=1+_

  //高阶函数, 函数参数
  /**
    *
  scala> def convertIntToString(f:(Int)=>String)=f(4)
convertIntToString: (f: Int => String)String

    */
  def convertIntToString(f:(Int)=>String)=f(4)

  //高阶函数, 产生新函数
  /**
    * scala> def multiplyBy(factor:Double)=(x:Double)=>factor*x
multiplyBy: (factor: Double)Double => Double
    */
  def multiplyBy(factor:Double)=(x:Double)=>factor*x



  def main(args: Array[String]):Unit = {
    println(increase(10))

    //数组map中调用写法1
    println(Array(1,2,3,4).map(increase).mkString(","))

    //匿名函数写法2
    println(Array(1,2,3,4).map((x:Int)=>x+1).mkString(","))
    //{}写法3
    Array(1,2,3,4).map{(x:Int)=>x+1}.mkString(",")
    //省略. 写法4
    Array(1,2,3,4) map{(x:Int)=>x+1} mkString(",")

    //参数类型推断
    Array(1,2,3,4) map{(x)=>x+1} mkString(",")

    //一个参数可以省略() 写法6
    Array(1,2,3,4) map {x=> x+1} mkString(",")

    //右边参数只出现一次, 写法7
    Array(1,2,3,4) map {_+1} mkString(",")

    /**
      * 关于值函数的简化_ 使用
      * 必须能够进行类型推断
      * 出错
      * scala> val fun1=1+_
<console>:7: error: missing parameter type for expanded function ((x$1) => 1.+(x$1))
       val fun1=1+_
        正确
          scala> val fun1=1+(_:Double)
fun1: Double => Double = <function1>
        fun2 fun2采用了另一种方式来说明类型
      */
    fun1(1000)
    fun2(200)

    //高阶函数
    convertIntToString((x:Int)=>x+" s")

    //高阶函数, 产生新函数
    /**
      * scala> val x=multiplyBy(10)
x: Double => Double = <function1>
      */
    val x=multiplyBy(10)



    //闭包(Closure）

    //(x:Int)=>x+more,这里面的more是一个自由变量（Free Variable）,more是一个没有给定含义的不定变量
    //而x则的类型确定、值在函数调用的时候被赋值，称这种变量为绑定变量（Bound Variable）
    /**
      * scala> (x:Int)=>x+more
<console>:10: error: not found: value more
              (x:Int)=>x+more
      */
    //这里还是存在类型推断的问题
    var more = 1;
    // more: Int = 1
    val fun=(x:Int)=>1 + more
    //fun: Int => Int = <function1>
    fun(10)
    //res1: Int = 11
    more = 10
    fun(10)
    //res2: Int = 20

    //像这种运行时确定more类型及值的函数称为闭包,more是个自由变量，在运行时其值和类型得以确定
    //这是一个由开放(free)到封闭的过程，因此称为闭包

    //下列函数也是一种闭包，因为在运行时其值才得以确定
    def multiplyBy2(factor:Double)=(x:Double)=>factor*x
  }
}

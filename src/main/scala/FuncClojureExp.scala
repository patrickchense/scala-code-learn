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

  //函数参数
  def convertIntToString(f:(Int)=>String)=f(4)

  //产生新函数
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

    convertIntToString((x:Int)=>x+" s")


    val x=multiplyBy(10)
    //闭包(Closure）

    //(x:Int)=>x+more,这里面的more是一个自由变量（Free Variable）,more是一个没有给定含义的不定变量
    //而x则的类型确定、值在函数调用的时候被赋值，称这种变量为绑定变量（Bound Variable）

  }
}

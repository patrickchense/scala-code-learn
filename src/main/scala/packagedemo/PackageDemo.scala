package packagedemo

/**
  * @authod hzchenzhe1
  * @date 10/20/17.
  * @description
  *
  */

class PackageDemo {

}

/**
  * 其他一种定义方式, 可以在其他地方通过 packagedemo.demo.PackageDemo1 来引用
  */
package demo {

  package scala {
    object Utils {
      def toString(x: String) {
        println(x)
      }
    }

  }
  //外层包不能引用内层包对象
  import packagedemo.demo.scala.Utils
  class PackageDemo1(var name : String) {
    def printName()={Utils.toString(name)}
  }
}

object PackageDemo {
  //scala允许在任何地方进行包的引入，_的意思是引入该包下的所有类和对象
  import demo.scala._
  import demo.PackageDemo1

  def main(args : Array[String]) : Unit = {
    Utils.toString(new PackageDemo1("john").name)
    new PackageDemo1("john").printName()
  }
}

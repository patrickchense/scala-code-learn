/**
  * @authod hzchenzhe1
  * @date 10/20/17.
  * @description
  *
  */
/**
  * 包对象主要用于将常量、工具函数，使用时直接通过包名引用
  */
object PackageObjDemo {

}

package object Math {
  val PI=3.141529
  val THETA=2.0
  val SIGMA=1.9
}

class Coputation{
  def computeArea(r:Double)=Math.PI*r*r
}
//编译后会在 Math 包目录下生成 package$.class package.class 两个文件
/**
Compiled from "Math.scala"
public final class cn.scala.xtwy.Math.package {
  public static double SIGMA();
  public static double THETA();
  public static double PI();
}

D:\ScalaWorkspace\ScalaChapter08\bin\cn\scala\xtwy\Math>javap -private package$.
class
Compiled from "Math.scala"
public final class cn.scala.xtwy.Math.package$ {
  public static final cn.scala.xtwy.Math.package$ MODULE$;
  private final double PI;
  private final double THETA;
  private final double SIGMA;
  public static {};
  public double PI();
  public double THETA();
  public double SIGMA();
  private cn.scala.xtwy.Math.package$();
}
  不能看出，它为我们的包对象Math创建了一个文件夹，然后创建了两个类，通过单例的方式实现方法调用
  */

/**
  * 对于import 重名，采取重命名的方法
  */
//将java.util.HashMap重命名为JavaHashMap
import java.util.{ HashMap => JavaHashMap }
import scala.collection.mutable.HashMap
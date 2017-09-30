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

  //如果类的成员域是val类型的变量，则只会生成getter方法
  val sex = 1;

  //成员域定义为private[this]，则不会生成getter、setter方法
  private[this] val age = 18

  //@BeanProperty用于生成getXxx,setXxx方法
  @BeanProperty var height = 178
}


object ClassObjExp {

  def main(args: Array[String]):Unit = {
    val p = new Person()
    p.name_=("John")
    //或者直接修改
    p.name = "John"
    p.name //get

  }
}

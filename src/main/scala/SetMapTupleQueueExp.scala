import scala.collection.mutable

/**
  * @authod hzchenzhe1
  * @date 9/28/17.
  * @description
  *
  */
object SetMapTupleQueueExp {

  /**
    *
Scala collections systematically distinguish between mutable and immutable collections. A mutable collection can be updated or extended in place.
This means you can change, add, or remove elements of a collection as a side effect. Immutable collections, by contrast, never change. You have still
  operations that simulate additions, removals, or updates,
but those operations will in each case return a new collection and leave the old collection unchanged.
//大致意思是：scala中的集合分为两种，一种是可变的集合，另一种是不可变的集合
//可变的集合可以更新或修改，添加、删除、修改元素将作用于原集合
//不可变集合一量被创建，便不能被改变，添加、删除、更新操作返回的是新的集合，老集合保持不变
    */


  /**
    * 这里提一下,scala 默认引入
    * java.lang._
    * scala._
    * Predef._
    *   而在Predef obj中 定义了
    *   type Map[A, +B] = immutable.Map[A,B]
    *   type Set[A] = immutable.Set[A]
    *   val Map = immutable.Map
    *   val Set = immutable.Set
    *
    */

  def main(args: Array[String]):Unit = {
    val mutableSet=mutable.Set(1,2,3)
    val immutableSet=Set(1,2,3) // 不指定就是immutable //默认情况下，Set的实现方式是HashSet实现方式，
    //添加
    val res8 = mutableSet+6 // res8: scala.collection.mutable.Set[Int] = Set(1, 2, 6, 3)
    //loop
    for ( i <- res8 ) println(i)

    //如果对插入的顺序有着严格的要求，则采用scala.collection.mutalbe.LinkedHashSet来实现
    val linkedHashSet=scala.collection.mutable.LinkedHashSet(3.0,5) //linkedHashSet: scala.collection.mutable.LinkedHashSet[Double] = Set(3.0, 5.0)
    linkedHashSet+6 //res10: scala.collection.mutable.LinkedHashSet[Double] = Set(3.0, 5.0, 6.0)


    //Map
    val studentInfo=Map("john" -> 21, "stephen" -> 22,"lucy" -> 20) //studentInfo: scala.collection.immutable.Map[String,Int] = Map(john -> 21, stephen -> 22, lucy -> 20)
    //immutable不可变，它不具有以下操作
    //不能 clear(),
    val studentInfoMutable=scala.collection.mutable.Map("john" -> 21, "stephen" -> 22,"lucy" -> 20)
    studentInfoMutable.clear()
    //loop
    for( i <- studentInfoMutable ) println(i)
    //foreach
    studentInfoMutable.foreach(e=> {val (k,v)=e; println(k+":"+v)})
    studentInfoMutable.foreach(e=> println(e._1+":"+e._2))

    //空map
    val xMap=new scala.collection.mutable.HashMap[String,Int]()
    //add
    xMap.put("spark",1)
    xMap.contains("spark")
    //初始化
    val xMap1=scala.collection.mutable.Map(("spark",1),("hive",1))
    "spark" -> 1 //res12: (String, Int) = (spark,1)
    //获取
    val op1 = xMap.get("spark") //res13: Option[Int] = Some(1)
    //获取不存在
    val op2 = xMap.get("sdklff") //res14: Option[Int] = None

    /**
      * Option,None,Some类型

Option、None、Some是scala中定义的类型，它们在scala语言中十分常用，因此这三个类型非学重要。
None、Some是Option的子类，它主要解决值为null的问题，在java语言中，对于定义好的HashMap，如果get方法中传入的键不存在，方法会返回null，在编写代码的时候对于null的这种情况通常需要特殊处理，
    然而在实际中经常会忘记，因此它很容易引起 NullPointerException异常。在Scala语言中通过Option、None、Some这三个类来避免这样的问题，这样做有几个好处，首先是代码可读性更强，
    当看到Option时，我们自然而然就知道它的值是可选的，然后变量是Option，比如Option[String]的时候，直接使用String的话，编译直接通不过。
      */
    //关于Option的获取
    show(op1) //res15: Any = 1
    show(op2) //res16: Any = ????

    //tuple
    //元组则是不同类型值的聚集
    ("hello","china",1) //res17: (String, String, Int) = (hello,china,1)
    var tuple=("Hello","China",1)
    //访问
    tuple._1 //res18: String = Hello
    val (first, second, third)=tuple
    /**
      * 返回: first: String = Hello
second: String = China
third: Int = 1
      */

    //queue
    var queue=scala.collection.immutable.Queue(1,2,3) //这是是var
    //出队
    queue.dequeue
    //入
    queue.enqueue(4)
    var queue1=scala.collection.mutable.Queue(1,2,3,4,5)
    queue1 += 5
    queue1 ++= List(6,7,8)

    //stack
    val stack = new mutable.Stack[Int]
    val stack1=mutable.Stack(1,2,3)
    stack1.top //出栈
    stack.push(2)
    stack.top

  }

  /**
    * A collection in package scala.collection.immutable is guaranteed to be immutable for everyone. Such a collection will never change after it is created.
Therefore, you can rely on the fact that accessing the same collection value repeatedly at different points in time will always yield a collection with the
  same elements.

    */

  /**
    * A collection in package scala.collection.mutable is known to have some operations that change the collection in place.
So dealing with mutable collection means you need to understand which code changes which collection when.

    */

  /**
    * A collection in package scala.collection can be either mutable or immutable. For instance,
collection.IndexedSeq[T] is a superclass of both collection.immutable.IndexedSeq[T] and collection.mutable.IndexedSeq[T] Generally,
the root collections in package scala.collection define the same interface as the immutable collections,
and the mutable collections in package scala.collection.mutable typically add some side-effecting modification operations to this immutable interface.
    */

  /**
    * 默认都是immutable
    * import scala.collection.mutable
    */

  def show(x:Option[Int]) =x match{
    case Some(s) => s
    case None => "????"
   }
}

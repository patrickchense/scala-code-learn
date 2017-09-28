import scala.collection.mutable.ArrayBuffer

/**
  * @authod hzchenzhe1
  * @date 9/28/17.
  * @description
  *
  */
object ArrayListExp {

  /**
    * //Scala中的Array以Java中的Array方式实现
    * @param args
    */
  def main(args : Array[String]) : Unit = {

  fixLengthArray()



  }

  def fixLengthArray() : Unit = {
    // 定长数组
    val numberArray = new Array[Int](10) //numberArray: Array[Int] = Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    val stringArray = new Array[String](10) //stringArray: Array[String] = Array(null, null, null, null, null, null, null, null, null, null)

    //赋值
    stringArray(0) = "stringArray1" //
    stringArray //res6: Array[String] = Array(stringArray1, null, null, null, null, null, null, null, null, null)


    //用apply 定义定长数组
    val stringArray2 = Array("1","23") //val stringArray2 = Array("1","23")
  }

  /**
    * ArrayBuffer
    * import scala.collection.mutable.ArrayBuffer
    */
  def flexLengthArray() : Unit = {
    val strArrayVar=ArrayBuffer[String]() //strArrayVar: scala.collection.mutable.ArrayBuffer[String] = ArrayBuffer()
    //尾部添加
    strArrayVar += "Hello" // res0: strArrayVar.type = ArrayBuffer(Hello)
    //添加多个
    strArrayVar+=("World","Programmer") // res1: strArrayVar.type = ArrayBuffer(Hello, World, Programmer)

    //++=用于向数组中追加内容，++=右侧可以是任何集合
    //追加Array数组
    strArrayVar++=Array("Wllcome","To","XueTuWuYou") //res4: strArrayVar.type = ArrayBuffer(Hello, World, Programmer, Wllcome, To, XueTuWuYou)

    //追加List
    strArrayVar ++= List("Wllcome","To","XueTuWuYou") //res5: strArrayVar.type = ArrayBuffer(Hello, World, Programmer, Wllcome, To, XueTuWuYou, Wllcome, To, XueTuWuYou)

    //删除末尾n个元素
    strArrayVar.trimEnd(3) //

    var intArrayVar=ArrayBuffer(1,1,2)// intArrayVar: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 1, 2)

    //index 0 插入 6
    intArrayVar.insert(0,6)//
    intArrayVar // scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(6, 1, 1, 2)
    //index 0 插入 7,8,9
    intArrayVar.insert(0,7,8,9)
    // 从 0 开始删4个
    intArrayVar.remove(0,4)
    intArrayVar //

    //专定长
    intArrayVar.toArray //res11: Array[Int] = Array()
    //定长转ArrayBuffer
//    res11.toBuffer  //res11 之前的返回, res12: scala.collection.mutable.Buffer[Int] = ArrayBuffer()
  }

  /**
    * 编历
    */
  def loopArray(intArrayVar : ArrayBuffer[Int]): Unit = {
    //to
    for(i <- 0 to intArrayVar.length-1) println("Array Element: " +intArrayVar(i))
    //until
    scala> for(i <- 0 until intArrayVar.length) println("Array Element: " +intArrayVar(i))
    //数组(推荐)
    scala> for(i <- intArrayVar) println("Array Element: " + i)
    //长度2
    scala>  for(i <- 0 until (intArrayVar.length,2)) println("Array Element: " +intArrayVar(i))
    //reverse
    for( i<- (0 until intArrayVar.length).reverse) println("Array Element: "+ intArrayVar(i))

    //多维数组
    var multiDimArray = Array(Array(1,2,3),Array(2,3,5))
    multiDimArray(0)(2) //
    for(i <- multiDimArray) println( i.mkString(","))
  }

  /**
    * 转换
    * @param intArrayVar
    */
  def transferArray(intArrayVar : ArrayBuffer[Int]): Unit = {
    //生成新数组，老的不变
    //yeild
    var intArrayVar2 = for(i <- intArrayVar) yield i*2
    //加过滤
    var intArrayNoBuffer=Array(1,2,3)
    var intArrayNoBuffer2=for(i <- intArrayNoBuffer if i>=2) yield i*2

  }

  def commonArray() = {
    val intArr=Array(1,2,3,4,5,6,7,8,9,10)
    intArr.sum
    intArr.max

    ArrayBuffer("Hello","Hell","Hey","Happy").max
    intArr.min
    intArr.toString() //res94: String = [I@141aba8
    intArr.mkString(",") //res96: String = 1,2,3,4,5,6,7,8,9,10
    intArr.mkString("<",",",">") //res97: String = <1,2,3,4,5,6,7,8,9,10>
  }

  /**
    * 1 List一但创建，其值不能被改变
    * 2 List具有递归结构（Recursive Structure),例如链表结构
    *   List类型和其它类型集合一样，它具有协变性（Covariant)，即对于类型S和T，如果S是T的子类型，则List[S]也是List[T]的子类型
    */
  def listOp() = {
    //定义
    val fruit=List("Apple","Banana","Orange") //fruit: List[String] = List(Apple, Banana, Orange)
    val fruit2=List.apply("Apple","Banana","Orange")
    val nums=List(1,2,3,4,5)
    val diagMatrix=List(List(1,0,0),List(0,1,0),List(0,0,1))

    //协变
    var listStr:List[Object]=List("This","Is","Covariant","Example")

    //空的List，其类型为Nothing,Nothing在Scala的继承层次中的最低层
    //，即Nothing是任何Scala其它类型如String,Object等的子类
    var list = List() //list: List[Nothing] = List()

    //构造方法
    val nums1 = 1 :: (2 :: (3 :: (4 :: Nil)))
    //由于::操作符的优先级是从右往左的，因此上一条语句等同于下面这条语句
    val nums2=1::2::3::4::Nil


    //loop
    for (i <- nums) println("List Element: "+i)


    //常用
    nums.isEmpty
    nums.head
    nums.tail ////取除第一个元素外剩余的元素，返回的是列表
    nums.tail.head  // 取列表第二个元素
    //连接
    List(1,2,3):::List(4,5,6)
    nums.init // 取除最后一个元素外的元素，返回的是列表
    nums.last //最后一个元素
    nums.reverse
    nums.reverse.init == nums.tail.reverse
    nums drop 3 //丢弃前3个
    nums take 1 //取前n个 return List
    nums.take(3)
    nums.splitAt(2)  //分割 res127: (List[Int], List[Int]) = (List(1, 2),List(3, 4))
    (nums.take(2),nums.drop(2)) // res128: (List[Int], List[Int]) = (List(1, 2),List(3, 4))

    //zip
    val nums3=List(1,2,3,4)
    val chars=List('1','2','3','4')
    val res130 = nums zip chars // res130: List[(Int, Char)] = List((1,1), (2,2), (3,3), (4,4))
    //unzip
    res130 unzip //res146: (List[Int], List[Char]) = (List(1, 2, 3, 4),List(1, 2, 3, 4))


    nums.toString //res131: String = List(1, 2, 3, 4)
    nums.mkString //res132: String = 1234
    nums.toArray //res134: Array[Int] = Array(1, 2, 3, 4)

    //伴生对象方法
    List.apply(1, 2, 3)
    List.range(2, 6)
    List.range(2, 6,2) //步长2, List[Int] = List(2, 4)
    List.range(2, 6,-1) //es142: List[Int] = List()
    // List.make(5, "hey") //相同元素, res144: List[String] = List(hey, hey, hey, hey, hey) 2.12 好像没有此方法

    val xss = List(List('a', 'b'), List('c'), List('d', 'e')) //xss: List[List[Char]] = List(List(a, b), List(c), List(d, e))
    xss.flatten //res6: List[Char] = List(a, b, c, d, e)
    List.concat(List('a', 'b'), List('c')) //连接 res7: List[Char] = List(a, b, c)

  }

  //插入算法
  def isort(xs: List[Int]): List[Int] =
    if (xs.isEmpty) Nil
    else insert(xs.head, isort(xs.tail))

  def insert(x: Int, xs: List[Int]): List[Int] =
    if (xs.isEmpty || x <= xs.head) x :: xs
    else xs.head :: insert(x, xs.tail)

}

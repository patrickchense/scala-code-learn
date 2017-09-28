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
    * @param args
    */
  def main(args: Array[String]):Unit = {
    val mutableSet=mutable.Set(1,2,3)
    val immutableSet=Set(1,2,3) // 不指定就是immutable
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
}

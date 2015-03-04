package com.github.tamaki.study.tamaki

/**
 * Created by ryuta.sakamoto on 2015/03/04.
 */
object impliConversion {

  // またはimplicit class
  case class MyInt(value: Int) {
    def hoge() = (1 to value).foreach(_ => println("hoge"))
  }

  def twice(i: MyInt): Int = i.value * 2

  implicit def string2MyInt(s: String): MyInt = MyInt(s.toInt)
  implicit def int2MyInt(i:Int):MyInt = MyInt(i)

  def main(args: Array[String]) {
    println(twice(MyInt(2)))
    println(twice("2"))
    //println(twice(string2Int("2")))  をコンパイル時にやっているだけ
    2.hoge()
  }
}

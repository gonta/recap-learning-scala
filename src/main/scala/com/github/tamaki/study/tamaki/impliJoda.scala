package com.github.tamaki.study.tamaki

import java.time.Period

import org.joda.time.DateTime

/**
 * Created by ryuta.sakamoto on 2015/03/04.
 */
object impliJoda {

  //  joda-timeをライブラリの依存関係に追加してください
  //  以下が動くようにしよう
  val now = new DateTime
  val tomorrow = now + 1.day

  implicit def int2MyJoda(i: Int): MyJoda = MyJoda(i)

  implicit def spJoda(jdt: DateTime): MyJoda2 = MyJoda2(jdt)

  case class MyJoda(value: Int) {
    def day() = value
  }

  case class MyJoda2(jdt: DateTime) {
    def +(num: Int): DateTime = jdt.plusDays(num)
  }

  def main(args: Array[String]) {
    2.day()
    println(now)
    println(tomorrow)
  }
}

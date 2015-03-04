package com.github.tamaki.study.tamaki.FizzBuzz

import java.util.Date

/**
 * Created by tamaki on 2015/02/08.
 */
object FizzBuzz {
  def main(args: Array[String]): Unit = {
    (1 to 100).foreach(println) // 1 -> 100が出る

    //    (1 to 100).foreach(x => fizzBuzz(x))
    (1 to 100).withFilter(_ % 2 != 0) map fizzBuzz

    def fizzBuzz(s: Int) {
      val x: String = {
        if (s % 15 == 0) "FizzBuzz"
        else if (s % 3 == 0) "Fizz"
        else if (s % 5 == 0) "Buzz"
        else s.toString
      }
      println(x)
    }

    // 2の倍数を除外して「,」区切りで1行表示する
    // withFilterの方がFilterよりも早い　遅延評価するため
    (1 to 100).withFilter(_ % 2 != 0).map {
      //mapはリストを返す
      case n if n % 15 == 0 => "FizzBuzz"
      case n if n % 3 == 0 => "Fizz"
      case n if n % 5 == 0 => "Buzz"
      case n => n.toString
    }.mkString(",").foreach(print)

    println()
    

    //FizzBuzz その5
    // その1 バージョンのFizzBuzzの出力前のリストから、
    // Fizz/Buzz/FizzBuzz になっていない数値の足し算をして合計値を出す
    print(sumFizzBuzz)
    def sumFizzBuzz: Int = (1 to 100).map {
      case n if n % 15 == 0 => print("FizzBuzz")
      case n if n % 3 == 0 => print("Fizz")
      case n if n % 5 == 0 => print("Buzz")
      case n => n // print出来ない
    }.collect { case s: Int => s}.sum

    // 1 to 100のリストを作らない
    // かつ
    // while/forループ禁止、var禁止で
    def factList(n: Int): Int =
      n match {
        case 100 => 1
        case _ => n * factList(n + 1)
      }

    // 関数
    timeIt({ () =>
      Thread.sleep(100)
      println("Hello World")
    })

    def timeIt(f: => Unit): Unit = {
      print("")
      f
      print("")
    }

    println("------------------------")

    def area(x: Int): (Int) => Int = {
      (y: Int) => x + y
    }
    val f2 = area(3)
    println(f2(3))



    def areaV3(pi: Double, radius: Double): Double = {
      pi * radius * radius
    }
    val areaV3_314 = areaV3(3.14, _: Double)
    println(areaV3_314(10))

    functionCompose()

    def functionCompose() = {
      val f = (x: Int) => x + 1
      val g = (x: Int) => x * 3
      val h1 = f compose g
      val h2 = g compose f
    }
    def chainFunction[T](f: Function[T, T]*) = {
      f.reduce(_ andThen _)
    }
    //
    //
//    def replace(langs: Seq[String], pf: PartialFunction[String, String]): Seq[String] = {
//      langs.map{l => if (pf.isDefinedAt(l))}
//    }

//    val langs = Seq("Java", "JavaScript", "Scala")
//    val result = replace(langs, { case "Scala" => "Cool"})
//    println(result) // =>Seq(Java,JavaScript,Cool)
  }
}


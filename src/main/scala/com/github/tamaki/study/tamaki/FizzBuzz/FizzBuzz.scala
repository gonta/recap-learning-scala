package com.github.tamaki.study.tamaki.FizzBuzz

/**
 * Created by tamaki on 2015/02/08.
 */
object FizzBuzz {
  def main(args: Array[String]): Unit = {
    (1 to 100).foreach(println)// 1 -> 100が出る

    (1 to 100).foreach(x => fizzBuzz(x))

    def fizzBuzz(s:Int){
      val x:Any = {
        if( s%15 == 0 ) "FizzBuzz"
        else if( s%3 == 0 ) "Fizz"
        else if( s%5 == 0 ) "Buzz"
        else s
      }
      println(x)
    }
  }
}
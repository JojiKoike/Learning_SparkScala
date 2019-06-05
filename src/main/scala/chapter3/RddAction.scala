package chapter3

import org.apache.spark.{SparkConf, SparkContext}

object RddAction extends App {
  override def main(args: Array[String]): Unit = {
    val inputFile = args(0)
    val outputFile = args(1)
    val conf = new SparkConf().setAppName("RDD Action")
    val sc = new SparkContext(conf)
    val inputRDD = sc.textFile(inputFile)
    inputRDD.filter(line => line.contains("POST")).take(10).foreach(println)
  }
}

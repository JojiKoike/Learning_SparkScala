package chapter3

import org.apache.spark.{SparkConf, SparkContext}

object RddConversion extends App {
  override def main(args: Array[String]): Unit = {
    val inputFile = args(0)
    val outputFile = args(1)
    val conf = new SparkConf().setAppName("RddConversion")
    val sc = new SparkContext(conf)
    val inputRDD = sc.textFile(inputFile)
    val errorsRDD = inputRDD.filter(line => line.contains("POST"))
    errorsRDD.saveAsTextFile(outputFile)
  }
}

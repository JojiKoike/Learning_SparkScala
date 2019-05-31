package chapter3

import org.apache.spark.{SparkConf, SparkContext}

object RddUnion extends App {
  override def main(args: Array[String]): Unit = {
    val inputFile = args(0)
    val outputFile = args(1)
    val conf = new SparkConf().setAppName("RddUnion")
    val sc = new SparkContext(conf)
    val inputRDD = sc.textFile(inputFile)
    val postRDD = inputRDD.filter(line => line.contains("POST"))
    val getRDD = inputRDD.filter(line => line.contains("GET"))
    postRDD.union(getRDD).saveAsTextFile(outputFile)
  }
}

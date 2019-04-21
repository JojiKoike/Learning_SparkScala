package sample

import org.apache.spark.sql.SparkSession

object SparkExampleApp extends App {

  override def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("Spark Sample App").getOrCreate()
  }

}

package chapter3
import org.apache.spark.{SparkContext, SparkConf}

object Parallelize extends App {
  override def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("My App")
    val sc = new SparkContext(conf)
    val lines = sc.parallelize(List("pandas", "i like pandas"))
    val linelike = lines.filter(line => line.contains("like"))
    linelike.saveAsTextFile("./results")
  }
}

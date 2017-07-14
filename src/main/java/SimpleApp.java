/**
 * Created by suvasish on 29/7/16.
 */
import org.apache.spark.api.java.*;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.Function;

public class SimpleApp {
    public static void main(String[] args) {
        String logFile = "/usr/spark-2.1.1/README.md";
        SparkConf conf = new SparkConf().setAppName("Simple Spark Application");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> logData = sc.textFile(logFile).cache();

        long numAs = logData.filter(new Function<String, Boolean>() {
            public Boolean call(String s) { return s.contains("a"); }
        }).count();

        long numBs = logData.filter(new Function<String, Boolean>() {
            public Boolean call(String s) { return s.contains("b"); }
        }).count();

        System.out.println("==========================================");
        System.out.println("Lines with a: " + numAs + ", lines with b: " + numBs);
        System.out.println("==========================================");

        sc.stop();
    }
}
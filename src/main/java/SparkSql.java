/**
 * Created by suvasish on 4/8/16.
 */

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import static org.apache.spark.sql.functions.col;


/**
 * Explore Spark SQL, DataFrames API
 */
public class SparkSql {

    public static void main(String[] args) {
        SparkSession spark = SparkSession
                .builder()
                .appName("Spark SQL Application")
                .config("spark.some.config.option", "some-value")
                .getOrCreate();

        // DataFrame operations
        Dataset<Row> df = spark.read().csv("/app/deploy/ebay.csv");
        df.show();
        System.out.println("#### ------------ >" + df.count());
        df.select(col("_c0"), col("_c8").plus(1));
        df.show();

        // Running SQL queries
        df.createOrReplaceTempView("ebay");
        Dataset<Row> sqlDF = spark.sql("Select * from ebay where _c4 > 50");
        sqlDF.show();
    }
}

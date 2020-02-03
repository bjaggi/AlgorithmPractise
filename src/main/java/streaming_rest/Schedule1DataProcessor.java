package streaming_rest;


import org.apache.spark.SparkConf;
        import org.apache.spark.api.java.JavaRDD;
        import org.apache.spark.api.java.function.Function;
        import org.apache.spark.api.java.function.VoidFunction;
        import org.apache.spark.streaming.Durations;
        import org.apache.spark.streaming.api.java.JavaDStream;
        import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
        import org.apache.spark.streaming.api.java.JavaStreamingContext;

import org.apache.log4j.Logger;
import org.apache.log4j.Level;

/**
 * Hello world!
 *
 */
public class Schedule1DataProcessor
{

    @SuppressWarnings("deprecation")
    public static void main( final String[] args )
    {

        Logger.getLogger("org").setLevel(Level.ERROR);


        if (args.length < 1) {
            System.err.println("Usage:<rest client - reciever url> ");
            System.exit(1);
        }
        //System.out.println("Value of argumetns"+args[0]+args[1]+args[2]);

        SparkConf sparkConf = new SparkConf().setAppName("Schedule1DataProcessor").setMaster("local[1]");

        JavaStreamingContext ssc = new JavaStreamingContext(sparkConf, Durations.seconds(5));
        // JavaDStream<String> filelines = ssc.textFileStream("/tmp/Streamtest");

        JavaReceiverInputDStream<String> lines = ssc.receiverStream(new Schedule1JSONRestReceiver(args[0]));
        lines.foreachRDD(new VoidFunction<JavaRDD<String> >() {

            public void call(JavaRDD<String> rdd) throws Exception {
                //arg0.saveAsTextFile(args[1]);
                if(!rdd.partitions().isEmpty()) {
                    System.out.println("processing & posting to reciever");
                    // collect RDD for printing
                    for (String line : rdd.collect()) {
                        System.out.println(" Data in RDD :  " + line);
                    }
                } else
                    System.out.println(" Ignoring Empty Batch " );
                //TODO
                //write hashing logic

            }
        });

        lines.print();
        ssc.start();
        try {
            ssc.awaitTermination();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
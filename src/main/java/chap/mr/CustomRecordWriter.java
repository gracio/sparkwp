package chap.mr;

/**
 * Description : some words
 * Author: chris
 * Date: 2014/9/5
 */

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

public class CustomRecordWriter extends RecordWriter<LongWritable, Text> {

    private PrintWriter out;
    private String separator = ",";

    public CustomRecordWriter(FSDataOutputStream fileOut) {
        out = new PrintWriter(fileOut);
    }

    @Override
    public void write(LongWritable key, Text value) throws IOException,
            InterruptedException {
        out.println(key.get() + separator + value.toString());
    }

    @Override
    public void close(TaskAttemptContext context) throws IOException,
            InterruptedException {
        out.close();
    }

}

package com.orienit.hadoop.training;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer extends
		Reducer<Text, LongWritable, Text, LongWritable> {
	@Override
	protected void reduce(Text key, Iterable<LongWritable> values,
			Context context) throws IOException, InterruptedException {

		// Sum the List Of Values
		long sum = 0;
		for (LongWritable value : values) {
			sum = sum + value.get();
		}

		// Assign Sum to Corresponding Word
		context.write(key, new LongWritable(sum));

	}
}









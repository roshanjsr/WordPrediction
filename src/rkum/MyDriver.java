package rkum;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Job;

public class MyDriver {
	
	public static void main(String[] args) throws Exception {
		if(args.length != 3){
			System.out.printf("USAGE: StubDriver <input dir><interim-output dir><final-output dir>\n");
			System.exit(-1);
		}
		
		JobConf conf=new JobConf(MyDriver.class);
		
		//Process the text by job1
		@SuppressWarnings("deprecation")
		Job job1 = new Job(conf, "job1");
		job1.setJarByClass(MyDriver.class);
		job1.setMapperClass(MyMapper.class);
		job1.setReducerClass(MyReducer.class);
		job1.setOutputKeyClass(Text.class);
		job1.setOutputValueClass(LongWritable.class);
		job1.setMapOutputKeyClass(Text.class);
		job1.setMapOutputValueClass(LongWritable.class);
		
		//Pass the first file to first mapper-reducer
		FileInputFormat.addInputPath(job1, new Path(args[0]));
		FileOutputFormat.setOutputPath(job1, new Path(args[1]));
		
		boolean result = job1.waitForCompletion(true);

		@SuppressWarnings("deprecation")
		Job job2 = new Job(conf, "job2");
		job2.setJarByClass(MyDriver.class);
		job2.setMapperClass(MyMapper1.class);
		job2.setReducerClass(MyReducer1.class);
		job2.setOutputKeyClass(Text.class);
		job2.setOutputValueClass(Text.class);
		job2.setMapOutputKeyClass(Text.class);
		job2.setMapOutputValueClass(Text.class);
		
		//Pass the output from first mapred to the second mapred as input
		FileInputFormat.addInputPath(job2, new Path(args[1]));
		FileOutputFormat.setOutputPath(job2, new Path(args[2]));
				
		//Wait for both jobs to complete
		boolean result1 = job2.waitForCompletion(true);
		
		//Exit if both jobs were success
			
		System.exit(result && result1 ? 0 : 1);
		
		//System.exit(result ? 0 : 1);
	}
}

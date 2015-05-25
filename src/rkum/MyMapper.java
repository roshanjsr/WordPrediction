package rkum;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*;


public class MyMapper extends Mapper<Object, Text, Text, LongWritable>{

	@Override
	public void map(Object key, Text value, Context context)
	throws IOException, InterruptedException {
		
		//for testing
		//System.out.println("Mapper Started");
		
		String w1="";
		String w2="";
		String k="";

		String[] words = value.toString().split("[ \t]+");  

		for(int i=0;i<words.length-1;i++)
		{
			w1 = words[i];			
			w2 = words[i+1];
			
			w1=w1.replaceAll("[^a-zA-Z0-9]","");
			w2=w2.replaceAll("[^a-zA-Z0-9]","");
			k=w1+"-"+w2;
			
			//Emit w1-w2 as key and 1 as value
			context.write(new Text(k), new LongWritable(1));
			
			//for debugging
			//System.out.println("i="+i);
		}
		
		//for testing
		//System.out.println("Mapper ended");
	}
}


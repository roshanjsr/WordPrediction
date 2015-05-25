package rkum;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MyReducer extends Reducer<Text, LongWritable, Text, Text>{
	
	public void reduce(Text key, Iterable<LongWritable> values, Context context)
		throws IOException, InterruptedException {
		
		//for testing
		//System.out.println("Reducer Started");
		
		//count the no. of occurance for each w1-w2 occurance
		long sum = 0;
		for(LongWritable iw:values)
		{
		  sum = sum + iw.get();
		  //System.out.println("word="+iw.get());
		}
		
		//split w1-w2 into two separate words
		String[] words = key.toString().split("[-]+");
		
		if(words.length>1){
			String w1= words[0];
			String w2= Long.toString(sum)+"~"+words[1];	
		//}
		
		//for testing
		//System.out.println("word[0]="+words[0]+" word[1]="+words[1]+" sum="+sum);
		
		//Emit w1 as key and count+w2 as value
		context.write(new Text(w1), new Text(w2));
		}
		//for testing
		//System.out.println("Reducer ended");
	}
}

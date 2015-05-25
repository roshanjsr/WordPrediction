package rkum;

import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*;


public class MyMapper1 extends Mapper<Object, Text, Text, Text>{

	@Override
	public void map(Object key, Text value, Context context)
	throws IOException, InterruptedException {
	
		
		//Extract count from string
		String[] words = value.toString().split("[\n]+");
		//System.out.println("Mapper1 started");
		//System.out.println("Length of words="+words.length);
		
		//for( String s: words)
		for(int i=0;i<words.length;i++)
		{
			String s=words[i];
			//Key
			String k = s.substring(0,s.indexOf("\t"));
			k=k.replaceAll("[^a-zA-Z0-9]","");
			//System.out.println("Inside Mapper1: k="+k);
			
			//value
			String v = s.substring(s.indexOf("\t")+1);
			//System.out.println("Inside Mapper1: v="+v);
			
			context.write(new Text(k), new Text(v));
			//System.out.println("Mapper1 ended");
		}		
	}
}

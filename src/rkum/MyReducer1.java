package rkum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MyReducer1 extends Reducer<Text, Text, Text, Text>{
	
	public void reduce(Text key, Iterable<Text> values, Context context)
		throws IOException, InterruptedException {
		
		//System.out.println("Reducer1 started");
		ArrayList<String> strArrList = new ArrayList<String>();
		
		for(Text iw:values)
		{
			String s1=iw.toString();
			strArrList.add(s1);
			//System.out.println("strArrList Length:"+strArrList.size());
			//System.out.println("iw:"+s1);
			System.err.println("RKUMLOG:This is a log.");
		}
		
		//Sort the array list to get the count in the beginning of the list
		Collections.sort(strArrList);
		Collections.reverse(strArrList);
		
		String s="";
		String rslt="";
		int len=strArrList.size();
		for(int i=0;i<len && i<3;i++)
		{
			s=strArrList.get(i);
			s=s.substring(s.indexOf("~")+1);
			if(rslt.length() != 0)
				rslt= rslt+","+s;
			else
				rslt=rslt+s;			
		}
		context.write(new Text(key), new Text(rslt));
		//System.out.println("Reducer1 ended");
	}
}

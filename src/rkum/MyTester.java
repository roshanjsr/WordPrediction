package rkum;

import java.util.List;
import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.apache.hadoop.mrunit.types.Pair;
import org.junit.Test;
import org.junit.Before;



public class MyTester {

MapDriver<Object, Text, Text, Text>mapDriver;
ReduceDriver<Text, Text, Text, Text> reduceDriver;
MapReduceDriver<Object, Text, Text, Text, Text, Text> mapReduceDriver;
List<Pair<Text, LongWritable>> output;


@Before	
	public void Setup()
		{
			MyMapper1 mapper = new MyMapper1();
			mapDriver = new MapDriver<Object, Text, Text, Text>();
			mapDriver.setMapper(mapper);
			
			MyReducer1 reducer = new MyReducer1();
			reduceDriver = new ReduceDriver<Text, Text, Text, Text>();
			reduceDriver.setReducer(reducer);
			
			mapReduceDriver = new MapReduceDriver<Object, Text, Text, Text, Text, Text>();
			mapReduceDriver.setMapper(mapper);
			mapReduceDriver.setReducer(reducer);
			
		}
/*
	@Test
 	public void testMapper() throws IOException
		{
			System.out.println("Mapper test started");
 			mapDriver.withInput(new Pair<Object, Text> ("1", new Text("Please read the. legal small print, and other information? legal small print. and other.")));
 			
			output = mapDriver.run();
			
			for (Pair<Text, LongWritable> p : output) 
				{
					System.out.println("Mapper Output :   " + p.getFirst() + "->" + p.getSecond());
				}
			System.out.println("Mapper test ended");
		}
*/

/*	
@Test
 	public void testReducer() throws IOException

 	{
 		System.out.println("Reducer testing started");

 			/*List<LongWritable>	values = new ArrayList<LongWritable>();
 		    values.add(new LongWritable(1));
 		    values.add(new LongWritable(1));
 		    values.add(new LongWritable(1));
 		   	values.add(new LongWritable(9));
 		  	values.add(new LongWritable(9));
	 		values.add(new LongWritable(9));
	 		values.add(new LongWritable(1));
	 		values.add(new LongWritable(1));
	 		values.add(new LongWritable(1));*/

/*	 		
 		//reduceDriver.withInput(new Pair<Object, Text> ("1", new Text("A 5, C")));
		//reduceDriver.withInput(new Pair<Object, Text> ("2", new Text("B 1, C")));
		//reduceDriver.withInput(new Pair<Object, Text> ("3", new Text("C 11, F")));
		//reduceDriver.withInput(new Pair<Object, Text> ("4", new Text("D 3, A")));
		//reduceDriver.withInput(new Pair<Object, Text> ("5", new Text("B 1")));
		//reduceDriver.withInput(new Pair<Object, Text> ("6", new Text("C 11")));
 		
	 	//reduceDriver.withInput(new Text("the"), values);

 		    List<Pair<Text, LongWritable>> output1 = reduceDriver.run();
 		  
 		 for (Pair<Text, LongWritable> p : output1) 
			{
				System.out.println("Reducer Output :   " + p.getFirst() + "->" + p.getSecond());
			}
 		System.out.println("Reducer test ended");
 	}
*/
 	
	@Test
 	public void testmapReducer() throws IOException
		{
 		System.out.println("MapReducer test started");
 			//mapReduceDriver.withInput(new Pair<Object, Text> ("1", new Text("In the second piece of code, the variable temp is accessible since it was declared outside the if and else blocks in the same block as that of the method. Variables declared within methods are known as local variables. For example, here temp is a local variable. Such variables are accessible within that particular method only. The scope and lifetime of local variables is the method block itself. Now that we have learnt how to use set and get methods to enforce restriction on the data that can be assigned to variable, we present a complete program below. We also provide a getAverage() method which computes the average if the Student. We use this getAverage() method in the printDetails() function. And then we have a test class, where the object is initialised with values entered by the user. And then, we display the details of the student in two ways- one by using the printDetails() method and the other by using the get methods provided in the class.")));
 		mapReduceDriver.withInput(new Pair<Object, Text> ("1", new Text("user	1~the \n"
 				+ "use	3~world \n"
 				+ "use	2~core \n"
 				+ "values	9~entered")));
 					
			List<Pair<Text, Text>> output = mapReduceDriver.run();
	//		assertEquals(11, output.size());
			
			for (Pair<Text, Text> p : output) 
				{
					System.out.println(p.getFirst() + "->" + p.getSecond());
				}
		System.out.println("MapReducer test Ended");
		}
}
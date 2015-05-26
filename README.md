# WordPrediction
Java project to emit top three next word predictions for each word in a large text

What this project does: Based on the content from a very large text archive, formulates the next words recommendation.
For each word, prepare a top 5 recommendations of the word that would go next.

Example: 
happy birthday, newyear, marriage
how are, do, did

How to run it: Import the project in eclipse and create a JAR. Copy the jar file onto the local machine with Hadoop and use the hadoop streaming command similar to what's given below to execute it:

"$ hadoop jar package_name.driver_class_name input_file_location_on_HDFS interim_output_location_on_HDFS output_location_on_HDFS"

Note: The interim output file in the above example serves as the input for the second mapper reducer.

You can visit www.knowbigdata.com for more details and courses on Hadoop and Hadoop related technologies

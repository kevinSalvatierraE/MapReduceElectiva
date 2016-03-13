import java.io.File;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

//import org.apache.hadoop.hdfs.tools.GetConf;
//import org.apache.hadoop.io.IntWritable;
//import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
//import org.apache.hadoop.conf.Configuration;
//import org.apache.hadoop.util.ToolRunner;

public class StubDriver {

	public static void main(String[] args) throws Exception {

		/*
		 * Validate that two arguments were passed from the command line.
		 */
		if (args.length != 2) {
			System.out.printf("Usage: StubDriver <input dir> <output dir>\n");
			System.exit(-1);
		}

		String input;
		String output;

		input = args[0];
		output = args[1];

		/*
		 * Instantiate a Job object for your job's configuration.
		 */
		Job job = Job.getInstance();

		/*
		 * Specify the jar file that contains your driver, mapper, and reducer.
		 * Hadoop will transfer this jar file to nodes in your cluster running
		 * mapper and reducer tasks.
		 */
		job.setJarByClass(StubDriver.class);

		/*
		 * Specify an easily-decipherable name for the job. This job name will
		 * appear in reports and logs.
		 */
		job.setJobName("Stub Driver");

		/*
		 * TODO implement
		 */

//		String path = input;
//		File folder = new File(path);
//		File[] listOfFiles = folder.listFiles();
//		for (int i = 0; i < listOfFiles.length; i++) {
//			// encont[i] = new archivo();
//			if (listOfFiles[i].isFile()) {
//				// files =;
//
//				FileInputFormat.setInputPaths(job,
//						new Path(input+"/"+listOfFiles[i].getName()));
//
//			}
//		}
		FileInputFormat.setInputPaths(job, new Path(input));
		FileOutputFormat.setOutputPath(job, new Path(output));

		job.setMapperClass(StubMapper.class);
		job.setReducerClass(StubReducer.class);
		//
		// job.setMapOutputKeyClass(Text.class);
		// job.setMapOutputValueClass(IntWritable.class);
		//
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);

		/*
		 * Start the MapReduce job and wait for it to finish. If it finishes
		 * successfully, return 0. If not, return 1.
		 */
		boolean success = job.waitForCompletion(true);
		System.exit(success ? 0 : 1);
	}

}

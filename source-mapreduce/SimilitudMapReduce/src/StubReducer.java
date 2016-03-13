import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class StubReducer extends Reducer<Text, Text, Text, Text> {

	@Override
	public void reduce(Text key, Iterable<Text> values, Context context)
			throws IOException, InterruptedException {

		/*
		 * TODO implement
		 */

		// System.out.println("reduce key "+key);
		// System.out.println("reduce value "+values);
		// for (IntWritable v : values) {
		// System.out.println("reduce values v "+v);
		// }

		int sum = 0;
		Text dir = new Text();
		for (Text val : values) {
			// sum += val.get();
			System.out.println("reduce values v " + val);
			dir.set(val);
		}
		
		System.out.println("reduce key " + key);

		
		if (!key.toString().trim().equals("0.0%")) {
//			System.out.println(" no es cero");

			context.write(key, dir);
		}
	}
}
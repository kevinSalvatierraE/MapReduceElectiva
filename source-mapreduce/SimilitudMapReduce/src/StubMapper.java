import java.io.IOException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import StringSimilitud.Jaccard;

public class StubMapper extends Mapper<LongWritable, Text, Text, Text> {

//	private static Pattern inputPattern = Pattern.compile("(.*) (\\d*)");
	private final static IntWritable one = new IntWritable(1);
	private Text word = new Text();
	String compara = "kevin salvatierra";
	Jaccard j2;
	
	

	@Override
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		j2 =  new Jaccard(2);
		/*
		 * TODO implement
		 */
		
		Text dir = new Text();
		
//		System.out.println("1 "+context.getInputSplit().toString();
		dir.set(context.getInputSplit().toString());
		
		double sim;

		String line = value.toString();
		
		
		
		sim = j2.similarity(line, compara);
		word.set(sim*100+"%");

			context.write(word, dir);
//		}
	}
}

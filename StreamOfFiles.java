package lab4;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamOfFiles {
	
	public static void main(String[] args)
	{
		long uniquewords=0;
		
		try(Stream<String> lines = Files.lines(Paths.get("C:\\Users\\Dell\\Documents\\Canada.txt"), Charset.defaultCharset())){
			uniquewords = lines.flatMap(line-> Arrays.stream(line.split(" ")))
					.distinct()
					.count();
		}catch(IOException e)
		{
			
		}
		
		System.out.println(uniquewords);
	
	}
	

	
}


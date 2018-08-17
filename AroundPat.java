package lab3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.IIOException;

public class AroundPat {

	public static void main(String[] args) {
		
		try {
			String OneLine = processFile((BufferedReader br) -> Long.toString(br.lines().count()));
			System.out.println(OneLine);
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
	
	public static String processFile(BufferedReaderProcessor p) throws IOException
	{
		try (BufferedReader br = new BufferedReader
				(new FileReader("C:\\Users\\Dell\\Documents\\Canada.txt")))
		{
			return p.process(br);
		}
	}
	

	@FunctionalInterface 
	public interface BufferedReaderProcessor 
	{ 
		String process(BufferedReader b) throws IOException;
	}
}

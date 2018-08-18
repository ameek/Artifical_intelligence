package EmailFilter;

import java.io.BufferedReader;
import java.io.FileReader;


public class ReaderUtil {

	public static void readFile(String name)
	{
		try{
		BufferedReader reader = new BufferedReader(new FileReader(name));
			
		String newLine;
		while(true)
		{
			newLine = reader.readLine();
			
			if(newLine==null)
                            break;
			System.out.println(newLine);
			
		}
		
			reader.close();
		}catch(Exception e)
		{
			System.out.println("Error"+e);
			
		}
	}
	
	public static void main(String ...args)
	{
            readFile("src/EmailFilter/spam.txt");
                
	}
	
}

package scan;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
 

public class DIT {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File f1 = new File("C:\\Users\\user\\Desktop\\scrpts\\test.txt"); // Creation of File Descriptor for input file

		FileReader fr = new FileReader(f1); // Creation of File Reader object
		BufferedReader br = new BufferedReader(fr); // Creation of BufferedReader object
		
		int Ndi = 0, Nidi = 0;

		String s;

		String[] cl = { "class", "extends", "public" }; // Input word to be searched

		String[] b = { "extends" };

		String ext = "extends";
		// Intialize the word to zero

		while ((s = br.readLine()) != null) // Reading Content from the file
		{
			String[] words = s.split(" ");
			
			for(String word : words) 
			{
				int c = 0;
				if(word.matches("(.*)public class(.*)") || word.matches("(.*)class(.*)")) {
				for(int i = 0; 1<= c ; i++) {
					c++;
				}
				}
				
			}
			
		}
            
        
	}

}


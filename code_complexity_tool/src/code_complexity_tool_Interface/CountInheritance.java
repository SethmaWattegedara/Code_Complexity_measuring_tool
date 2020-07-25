package code_complexity_tool_Interface;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class CountInheritance {

	 public static void main(String[] args) {
		 
	        // invoke to count & print for supplied file
	        countAndPrintRepeatedCharacterOccurences("C:\\Users\\user\\Desktop\\scrpts\\test.txt");
	    }
	 
	 public static void countAndPrintRepeatedCharacterOccurences(
	            String fileName) {
		 	String ext = "extends";
		 	int c = 2;
		 	int s = 1;
		 	int Ndi = 1;
		 	int Nidi = 1;
		 	int Tot = 0;
	        // local variables
	        String line = "";
	 
	        // Step 1: create Map of Character-Integer
	        Map<String, Integer> mapOfRepeatedWord = 
	                new HashMap<String, Integer>();
	 
	        // Step A: Read file using try-with-resources statement
	        try(BufferedReader bufferedReader = new BufferedReader(
	                new FileReader(fileName))) {
	 
	            // Step B: Read line from file
	            while ((line = bufferedReader.readLine()) != null) {
	 
	                // Step 2: convert String into character-array
	                // using toCharArray() method 
	            	String[] words = line.split(" ");
	 
	                // Step 3: iterate through char[] array
	                for(String word : words) {
	 
	                	if (word.equals(ext)) {
	                	String[] cls = line.split(" ");
	                	for(String w: cls) {	
	                	String tempUCword = w.toLowerCase();
	                	if(w.matches("(.*)class(.*)")) {
							
							System.out.print(" ");
						}
						
						else if(w.matches("(.*)extends(.*)")) {
							
							System.out.print(" ");
						}
						

						else if(w.matches("(.*)public(.*)")) {
							
							System.out.print(" ");
						}
						else {
	                    // Step 4: leave spaces
	                	if(mapOfRepeatedWord.containsKey(tempUCword)){
	                		 
	                        // Step 6: If contains, increase count value by 1
	                        mapOfRepeatedWord.put(tempUCword,mapOfRepeatedWord.get(tempUCword) + 1);
	                        
	                        if(mapOfRepeatedWord.get(tempUCword) == 2) {
	                        	
	                        	System.out.print(tempUCword + "  Nidi  : " + Nidi  + "  Ci : " + c  + "  Ndi  :" + " 0 " );
	                        	c++;
	                        	
	                        	if(mapOfRepeatedWord.get(tempUCword) == 2) {
		                        	
		                        	 int Ti1 = 1;
		                        	System.out.println(" Ti :  " + Ti1 );
		                        	
		                        }
	                        	else if(mapOfRepeatedWord.get(tempUCword) == 3) {
		                        	
	                        		int Ti2 = 2;
		                        	System.out.println(" Ti  : " + Ti2 );
		                        	
		                        }
	                        	else  {
		                        		
	                        		int Ti3 = 3;
		                        	System.out.println("  Ti  : " + Ti3);
		                        	
		                        }
	                        	
	                        	line = bufferedReader.readLine();
	                        }
	                        
	                       // if(mapOfRepeatedWord.get(tempUCword) == 3) {
	                        //	System.out.println(tempUCword + "  inherit by 2");
	                        //}
	                        
	                 
	                    } 
	                    else {
	                    	
	                    	
	         
	                        // Step 7: otherwise, make a new entry
	                        mapOfRepeatedWord.put(tempUCword, 1);
	                        if(mapOfRepeatedWord.get(tempUCword) == 1) {
	                        	 if(s == 1 && Ndi == 1) {
	                        	System.out.println(tempUCword+ "  Ndi  :  " + Ndi  + "  Ci :  " + s +  " Nidi  :" + " 0 " + " Ti :" + "  0  " );
	                        	s = 1 - 1;
	                        	Ndi = 1 - 1;
	                        	line = bufferedReader.readLine();
	                        }
	                        	
	                        }
	                     
	                    }
	                	  
						} //else
	                }//for
	                	}// if
	                	
	             
	               }//word
	                
	                 
	                
	                System.out.println("  Nid :  "+ "0" + "  Nidi  : " + " 0 "  + "  Ti : "+ " 0 " + "  Ci : " + " 0 " );
	                
	                System.out.println();
	                
	            }
	           // System.out.println("  Nid :  "+ "0" + "  Nidi  : " + " 0 "  + "  Ti : "+ " 0 " + "  Ci : " + " 0 " );
	 
	            System.out.println("Inhritance: \n");
	            System.out.println("Words" + "\t\t" + "Count");
	            System.out.println("======" + "\t\t" + "=====");
	     
	            // Step 8: print word along with its count
	            for(Map.Entry<String, Integer> entry : 
	                mapOfRepeatedWord.entrySet()){
	                System.out.println(entry.getKey() 
	                        + "\t\t" + entry.getValue());
	            }
	     
	            // Step 9: Sorting logic by invoking sortByCountValue()
	           /* Map<String, Integer> wordLHMap = sortByCountValue(
	                    mapOfRepeatedWord);
	     
	            System.out.println("\n\nAfter sorting"
	                    + " in descending order of count : \n");
	            System.out.println("Words" + "\t\t" + "Count");
	            System.out.println("======" + "\t\t" + "=====");
	     
	            // Step 10: Again print after sorting
	            for(Map.Entry<String, Integer> entry : 
	                wordLHMap.entrySet()) {
	                System.out.println(entry.getKey() 
	                        + "\t\t" + entry.getValue());
	            }*/
	        }
	        catch (FileNotFoundException fnfex) {
	            fnfex.printStackTrace();
	        }
	        catch (IOException ioex) {
	            ioex.printStackTrace();
	        }
	    }
	 
	    /**
	     * this method sort acc. to count value
	     * @param mapOfRepeatedWord
	     * @return
	     */
	 public static Map<String, Integer> sortByCountValue(
	            Map<String, Integer> mapOfRepeatedWord) {
	 
	        // get entrySet from HashMap object
	        Set<Map.Entry<String, Integer>> setOfWordEntries = 
	                mapOfRepeatedWord.entrySet();
	 
	        // convert HashMap to List of Map entries
	        List<Map.Entry<String, Integer>> listOfwordEntry = 
	                new ArrayList<Map.Entry<String, Integer>>(
	                        setOfWordEntries);
	 
	        // sort list of entries using Collections.sort(ls, cmptr);
	        Collections.sort(listOfwordEntry, 
	                new Comparator<Map.Entry<String, Integer>>() {
	 
	            @Override
	            public int compare(Entry<String, Integer> es1, 
	                    Entry<String, Integer> es2) {
	                return es2.getValue().compareTo(es1.getValue());
	            }
	        });
	 
	        // store into LinkedHashMap for maintaining insertion
	        Map<String, Integer> wordLHMap = 
	                new LinkedHashMap<String, Integer>();
	 
	        // iterating list and storing in LinkedHahsMap
	        for(Map.Entry<String, Integer> map : listOfwordEntry){
	            wordLHMap.put(map.getKey(), map.getValue());
	        }
	 
	        return wordLHMap;
	    }
	 

	
	
}

package com.CodeComplex.Controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.CodeComplex.Controller.*;
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


@WebServlet("/InheritanceServlet")
@MultipartConfig(fileSizeThreshold = 1024*1024*10, //10MB
				maxFileSize=1024*1024*50, // 50 MB
				maxRequestSize=1024*1024*100)//100MB

public class InheritanceServlet extends HttpServlet {
	private static final long serialVersionUID = 205242440643911308L;
	
	/** * Directory where uploaded files will be saved, its relative to * the web application directory. */
	private static final String UPLOAD_DIR = "uploads";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InheritanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//if(request.getParameter("upload") != null) {
		// gets absolute path of the web application
		String applicationPath = request.getServletContext().getRealPath("");
		// constructs path of the directory to save uploaded file
		String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
		
		// creates the save directory if it does not exists
		File fileSaveDir = new File(uploadFilePath);
		if (!fileSaveDir.exists()) {
		fileSaveDir.mkdirs();
		}
		
		System.out.println("Upload File Directory="+fileSaveDir.getAbsolutePath());
		
		String fileName = null;
		//Get all the parts from request and write it to the file on server
		for (Part part : request.getParts()) {
		
			fileName = getFileName(part);
			
		if(fileName != null) {
		
			File f = new File(fileName);
		    part.write(uploadFilePath + File.separator + f.getName());
		}
		
		}
		
		if (request.getParameter("calInherit") != null)
			
		{
		int in0 = Integer.parseInt(request.getParameter("zero"));
		int in1 = Integer.parseInt(request.getParameter("one"));
		int in2 = Integer.parseInt(request.getParameter("two"));
		int in3 = Integer.parseInt(request.getParameter("three"));
		int in4 = Integer.parseInt(request.getParameter("four"));
		
		CountInheritance(request, response, in0, in1, in2, in3, in4);
		
		}
		
		else {
		
		CountInheritance(request, response, 0, 1, 2, 3, 4);
		}
		
		
}
		
	
	
	
	/** * Utility method to get file name from HTTP header content-disposition */
	private String getFileName(Part part) {
	String contentDisp = part.getHeader("content-disposition");
	System.out.println("content-disposition header= "+contentDisp);
	String[] tokens = contentDisp.split(";");
	for (String token : tokens) {
	if (token.trim().startsWith("filename")) {
	return token.substring(token.indexOf("=") + 2, token.length()-1);
	}
	}
	return null;
	}
		 
	public void CountInheritance(HttpServletRequest request, HttpServletResponse response, int zero, int one, int two, int three, int four) throws IOException
		         {
		File file = new File("D:\\JAVA\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp2\\wtpwebapps\\code_complexity_tool\\uploads\\");
		       
		File[] files = file.listFiles();
		
			 	String ext = "extends";
			 	int c = 2;
			 	int c0 = zero;
			 	int c1 = one;
			 	int c2 = two;
			 	int c3 = three;
			 	int c4 = four;
			 	
			 	
			 	
			 	int Ndi = 1;
			 	int Ndi1 = 0;
			 	int Nidi = 1;
			 	int Nidi1 = 0;
			 	
			 	int lineNo = 1;
			 	
			 	
			 	StringBuilder in = new StringBuilder();
			 	in.append("<html>");
				in.append("<head>");
				in.append("</head>");
		        String line = "";
		 
		     
		        Map<String, Integer> mapOfRepeatedWord = new HashMap<String, Integer>();
		 		
		       for (File f : files) {
		        try {   
		        	BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\JAVA\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp2\\wtpwebapps\\code_complexity_tool\\uploads\\" + f.getName()));
		 
		        	in.append("<table class = \"table\">");
        			in.append("<thead>");
        			in.append("<tr>");
        			in.append("<th scope=\"col\">Line No.</th>");
        			in.append("<th scope=\"col\">Program Statement</th>");
        			in.append("<th scope=\"col\">Ndi</th>");
        			in.append("<th scope=\"col\">Nidi</th>");
        			in.append("<th scope=\"col\">Ti</th>");
        			in.append("<th scope=\"col\">Ci</th>");
        			in.append("</tr>");
        			in.append("</thead>");
        			
		            
		            while ((line = bufferedReader.readLine()) != null) {
		 
		            	in.append("<tbody>");
						
		            	String[] words = line.split(" ");
		 
		            	 // \\s(?=\\{)|(?<=\\})\\s
		                for(String word : words) {
		                	
		                	
		 
		                	if (word.equals(ext)) {
		                	String[] cls = line.split("[{} ,.;/&\\s]+");
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
		                    //leave spaces
		                	if(mapOfRepeatedWord.containsKey(tempUCword)){
		                		 
		                        // If contains, increase count value by 1
		                        mapOfRepeatedWord.put(tempUCword,mapOfRepeatedWord.get(tempUCword) + 1);
		                        
		                        if(mapOfRepeatedWord.get(tempUCword) == 2) {
		                                              	        	
		                   
		                      
		                        	//System.out.print(tempUCword + "  Nidi  : " + Nidi  + "  Ci : " + c  + "  Ndi  :" + " 0 " );
		                        	if(c != 3 && c != 4) {
		                        	int ti = Ndi1 + Nidi;
		                        	
		                        	in.append("<tr>");
		    						in.append("<td>" + lineNo);
		    						in.append("</td>");
		    						System.out.print("\t");
		    						System.out.print(line);
		    						in.append("<td>" + line);
		    						in.append("</td>");
		                        	in.append("<td>" + Ndi1);
		        					in.append("</td>");
		        					in.append("<td>" + Nidi);
		        					in.append("</td>");
		        					in.append("<td>" + ti);
		        					in.append("</td>");
		        					in.append("<td>" + c2);
		        					in.append("</td>");
		        					in.append("</tr>");
		        					
		                       
		        				
		        				
		        					

				                	line = bufferedReader.readLine();
		                        	lineNo++;
				                						                        	
		                        	}
		                        	else if(c == 4) {
		                        		
		                        		int Nidi2 = 2;
		                        		int ti = Ndi1 + Nidi2;
			                        	in.append("<tr>");
			    						//System.out.print(lineNo);
			    						in.append("<td>" + lineNo);
			    						in.append("</td>");
			    						System.out.print("\t");
			    						System.out.print(line);
			    						in.append("<td>" + line);
			    						in.append("</td>");
			                        	in.append("<td>" + Ndi1);
			        					in.append("</td>");
			        					in.append("<td>" + Nidi2);
			        					in.append("</td>");
			        					in.append("<td>" + ti);
			        					in.append("</td>");
			        					in.append("<td>" + c3);
			        					in.append("</td>");
			        					in.append("</tr>");
			        					
			                       
			        					
			        					c++;
			        					

					                	line = bufferedReader.readLine();
			                        	lineNo++;
		                        		
		                        	}
		                        	
		                        	else if(c >= 5) {
		                        		
		                        		int Nidi3 = 4;
		                        		int ti = Ndi1 + Nidi3;
			                        	in.append("<tr>");
			    						//System.out.print(lineNo);
			    						in.append("<td>" + lineNo);
			    						in.append("</td>");
			    						System.out.print("\t");
			    						System.out.print(line);
			    						in.append("<td>" + line);
			    						in.append("</td>");
			                        	in.append("<td>" + Ndi1);
			        					in.append("</td>");
			        					in.append("<td>" + Nidi3);
			        					in.append("</td>");
			        					in.append("<td>" + ti);
			        					in.append("</td>");
			        					in.append("<td>" + c4);
			        					in.append("</td>");
			        					in.append("</tr>");
			        					
			                       
			        					
			        					c++;
			        					

					                	line = bufferedReader.readLine();
			                        	lineNo++;
		                        		
		                        		
		                        	}
		                        	
		                        	c++;	
		                          	
		                        	}
		                        	
		                        	
		                        
		                        if(mapOfRepeatedWord.get(tempUCword) == 3) {
			                        
		                        	//System.out.print(tempUCword + "  Nidi  : " + Nidi  + "  Ci : " + c  + "  Ndi  :" + " 0 " );
		                        	
		                        	int ti = Ndi1 + Nidi;
		                        	in.append("<tr>");
		    						//System.out.print(lineNo);
		    						in.append("<td>" + lineNo);
		    						in.append("</td>");
		    						System.out.print("\t");
		    						System.out.print(line);
		    						in.append("<td>" + line);
		    						in.append("</td>");
		                        	in.append("<td>" + Ndi1);
		        					in.append("</td>");
		        					in.append("<td>" + Nidi);
		        					in.append("</td>");
		        					in.append("<td>" + ti);
		        					in.append("</td>");
		        					in.append("<td>" + c2);
		        					in.append("</td>");
		        					in.append("</tr>");
		        					
		                                	
		                        	line = bufferedReader.readLine();
		                        	lineNo++;
		                        	
		                        }
		                    
		                       // if(mapOfRepeatedWord.get(tempUCword) == 3) {
		                        //	System.out.println(tempUCword + "  inherit by 2");
		                        //}
		                        
		                 
		                    } 
		                    else {
		                    	
		                    	
		         
		                       mapOfRepeatedWord.put(tempUCword, 1);
		                        if(mapOfRepeatedWord.get(tempUCword) == 1) {
		                        	int cc = 1;
		                        	 if(cc == 1 && Ndi == 1) {
		                        	System.out.println(tempUCword+ "  Ndi  :  " + Ndi  + "  Ci :  " + c1 +  " Nidi  :" + " 0 " + " Ti :" + "  0  " );
		                        	int ti = Ndi + Nidi1;
		                        	
		                        	in.append("<tr>");
		    						//System.out.print(lineNo);
		    						in.append("<td>" + lineNo);
		    						in.append("</td>");
		    						System.out.print("\t");
		    						System.out.print(line);
		    						in.append("<td>" + line);
		    						in.append("</td>");
		                        	in.append("<td>" + Ndi);
		        					in.append("</td>");
		        					in.append("<td>" + Nidi1);
		        					in.append("</td>");
		        					in.append("<td>" + ti);
		        					in.append("</td>");
		        					in.append("<td>" + c1);
		        					in.append("</td>");
		        					in.append("</tr>");
		                        	
		        					 c1 = 0;
		        		            Ndi = 0;
		                        	
		                        	line = bufferedReader.readLine();
		                        	lineNo++;
		                        	
		                        	
		                        }
		                        	 
		                        	 
		                        }       	
				                        	
		                             
		                      
		                     
		                    }
		                	  
							} //else
		                	
		                	
		                	
		                }//for
		                	}// if
		                	
		                	
		                	
		               }//word
		            
		               int ti = Ndi1 + Nidi1;
                    
		           	in.append("<tr>");
					//System.out.print(lineNo);
					in.append("<td>" + lineNo);
					in.append("</td>");
					System.out.print("\t");
					System.out.print(line);
					in.append("<td>" + line);
					in.append("</td>");
		                in.append("<td>\n" + Ndi1);
    					in.append("</td>");
    					in.append("<td>" + Nidi1);
    					in.append("</td>");
    					in.append("<td>" + ti);
    					in.append("</td>");
    					in.append("<td>" + c0);
    					in.append("</td>");
    					lineNo++;
    					 in.append("</tr>");
 		                
 		                
                 
		           
		                System.out.println("  Nid :  "+ "0" + "  Nidi  : " + " 0 "  + "  Ti : "+ " 0 " + "  Ci : " + " 0 " );
		                
		                System.out.println();
		                
		               
						in.append("</tbody>");
						
		                
		            }
		           // System.out.println("  Nid :  "+ "0" + "  Nidi  : " + " 0 "  + "  Ti : "+ " 0 " + "  Ci : " + " 0 " );
		            bufferedReader.close();
		      
		        }
		        catch (FileNotFoundException fnfex) {
		            fnfex.printStackTrace();
		        }
		        catch (IOException ioex) {
		            ioex.printStackTrace();
		        }
		        
		        in.append("</table>");
		        lineNo = 1;
		       
		    }
		        //}
		//request.setAttribute("message", fileName + " File uploaded successfully!");
		        in.append("</body>");
				in.append("</html>");

				request.setAttribute("table", in.toString());

				System.out.println(in.toString());
				try {
					getServletContext().getRequestDispatcher("/DisplayInheritance.jsp").forward(request, response);
				} catch (ServletException e) { // TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) { // TODO Auto-generated catchblock
					e.printStackTrace();
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



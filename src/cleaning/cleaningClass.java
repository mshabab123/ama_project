package cleaning;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class cleaningClass{
	  
public cleaningClass(){

		        // The name of the file to open.
		        String fileName = mainData.fileNameText;
		        String fileName1 = "C:/Users/Mshabab/workspace/TestProject/dataP/file1.txt";
		        int count = 0;   // count of rating 
 		        int counthelp = 0; // count of helpless
		        // This will reference one line at a time
		        String line = null;

		        try {
		            FileReader fileReader =  new FileReader(fileName);
		            BufferedReader bufferedReader = new BufferedReader(fileReader);


		            FileWriter fileWriter = new FileWriter(fileName1);
		            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		            
		            		            
		            while((line = bufferedReader.readLine()) != null) {
		            	    count++;
		            		line = line.replaceAll(";", "::");
			              	line = line.replaceAll("product/productId: ", "");
			              	line = line.replaceAll("review/userId: ", "");
			              	line = line.replaceAll("review/profileName: ", "");
			              	line = line.replaceAll("review/helpfulne", "");
			              	line = line.replaceAll("review/score: ", "");
			              	line = line.replaceAll("review/time: ", "");
			            	line = line.replaceAll("review/summary: ", "");
			            	line = line.replaceAll("review/text: ", "");
			     
			            	Pattern pattern1 = Pattern.compile("ss\\: \\d+\\/\\d+");
			            	Matcher matcher1 = pattern1.matcher(line);
			            	if (matcher1.find()) {
		           	  				System.out.println(matcher1.group(0)); 
		           	  				counthelp++;
		           	  				line = line.replaceAll("/", ";");
			           	  			line = line.replaceAll("ss: ", "");
			            	} 

			            	bufferedWriter.write(line);
			     			bufferedWriter.newLine();
			               		     
		            		}	

			            // Always close files.
			            bufferedReader.close();	
			            // Always close files.
			            bufferedWriter.close();
			
		        }
		        catch(FileNotFoundException ex) {
		            System.out.println(
		                "Unable to open file '" + 
		                fileName + "'");				
		        }
		        catch(IOException ex) {
		            System.out.println(
		                "Error reading file '" 
		                + fileName + "'");					
		
		        }
		        
		        System.out.println("\n\n the numbrr of instatnce is "+count/9+" the nmyber of helpless is "+counthelp+"\n\n");
		        
		        
		        
		    }

}

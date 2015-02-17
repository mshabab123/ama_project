package cleaning;

import java.io.*;
public class writingClass {
		public  writingClass(){
		        // The name of the file to open.
		        String fileName = "C:/Users/Mshabab/workspace/TestProject/dataP/file1.txt";
		        String fileName1 = "C:/Users/Mshabab/workspace/TEstProject/dataP/file3.txt";
		        String line = null;
		       
		        try {
		            FileReader fileReader =  new FileReader(fileName);
		            BufferedReader bufferedReader = new BufferedReader(fileReader);

		            FileWriter fileWriter = new FileWriter(fileName1);
		            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	  
		            while((line = bufferedReader.readLine()) != null) {   
		            	for (int i =0 ; i <8; i++)     
		            		line = line + ";" +bufferedReader.readLine() ;
			         	line = line.replaceAll("null", "");
		                line = line  + mainData.catogery ;                
			     		bufferedWriter.write(line);
			     		bufferedWriter.newLine();
			     	//	System.out.println(line);
		            }	

			            bufferedReader.close();	
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
		}

}

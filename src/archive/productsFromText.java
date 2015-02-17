package archive;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class productsFromText {
		String[] poductNameArray = new String[1000];
	public productsFromText() {
			
			
		        // The name of the file to open.
		        String fileName = "M:/workEclipse/ratingPred/productsName.txt";
		        String line = null ;
		        String[] poductNameArray= null;
		        List<String> product_list = new ArrayList<String>();
		       
		        try {
		            FileReader fileReader =  new FileReader(fileName);
		            BufferedReader bufferedReader = new BufferedReader(fileReader);

	  
		            while((line = bufferedReader.readLine()) != null) {   
		            	product_list.add(	line) ;
		            	
		            }	

			            bufferedReader.close();	
			            
			        poductNameArray = product_list.toArray(poductNameArray);
			            
			            for (int i = 0; i < product_list.size(); i++)
					    {
					        System.out.println(product_list.get(i)+"\t"+ poductNameArray[i]+"\t"+ poductNameArray.length);
					    }
					
			
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

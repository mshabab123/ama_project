import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;


public class divid_data_training {


	public static void main(String[] args) throws IOException {

	String	fileName= "result_neuralarry_all";
	String line;
	int k = 0;
			try {
				FileReader fileReader = new FileReader(fileName);
				BufferedReader bufferedReader = new BufferedReader(fileReader);

				File file = new File("testing_neural_data");
				File file1 = new File("training_neural_data");

				if (!file.exists()) {
					file.createNewFile();
				}
				
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				FileWriter fw1 = new FileWriter(file1.getAbsoluteFile());
				BufferedWriter bw1 = new BufferedWriter(fw1);
				
				while ((line = bufferedReader.readLine()) != null) {
						k++;
					if(k==6){
						k=0;
						bw.write(line);
						bw.write("\n");
					}else
					{			bw1.write(line);
							bw1.write("\n");
						
					}
					}
		
				
		
		

					
				bw.close();
				bw1.close();
				

				bufferedReader.close();
			} catch (FileNotFoundException ex) {
				System.out.println("Unable to open file '" + fileName + "'");
			} catch (IOException ex) {
				System.out.println("Error reading file '" + fileName + "'");

			}
	}}
	
	

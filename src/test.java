import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class test {

	public static void main(String[] args) throws IOException {

		String result ="hi, Mshabab.";
		
		WriteToFile(result);
		
		
	}

	static void WriteToFile(String result) throws IOException {

		File file = new File("result1");

		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(result);
		bw.close();

		System.out.println("Done");

	}
}
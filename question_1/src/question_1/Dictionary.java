package question_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Dictionary {
	public static Properties prop  = new Properties();

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\resources\\data.properties");
		prop.load(fis);
		
		System.out.println("--Positive Scenario--");
		String file = prop.getProperty("path");
		System.out.println(file);
		String path = System.getProperty("user.dir")+ "\\resources\\" +file;
		printDictionary(path);
		
		System.out.println("--Negative Scenario--");
		String fakefile = prop.getProperty("fakepath");
		String fakepath = System.getProperty("user.dir")+ "\\resources\\" +fakefile;
		printDictionary(fakepath);
		
	}
	
	public static boolean doesFileExist(String Path) {
		File f = new File(Path);
		try{
			if(f.exists()) {
				System.out.println("File exists at given path!");
				return true;
			}
		}catch(Exception F) {
			System.out.println("Exception Catched: " + F);
		}
		return false;
	} 
	
	
	public static void printDictionary(String path) {
		try {
			if(doesFileExist(path)) {
				BufferedReader reader = new BufferedReader(new FileReader(path));
				
				String current_line;
				System.out.println("Printing words with their meanings.");
				while((current_line = reader.readLine()) != null) {
					String[] line = current_line.split("-");
					String[] meanings = line[1].split(",");
					System.out.println(line[0]);
					for(String m:meanings) {
						System.out.println(m.trim());
					}
				}
				reader.close();	
			}
			else {

				System.out.println("file not found at given path.");
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

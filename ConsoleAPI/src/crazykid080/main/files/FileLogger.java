package crazykid080.main.files;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import crazykid080.main.adminControls.ConsoleControl;
import crazykid080.main.adminControls.LogLevels;

public class FileLogger {
	//File to write to
	String filename = "ConsoleOutput.txt";

	String line = null;
	public void WriteToFile(String text){
		try{
			FileWriter fileWriter = new FileWriter(filename);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(text);
			bufferedWriter.newLine();
			
			bufferedWriter.close();
		}catch(IOException ex){
			ConsoleControl.createError("Error writing to file", LogLevels.Error, "FileLogger");
			ex.printStackTrace();
		}
	}
}

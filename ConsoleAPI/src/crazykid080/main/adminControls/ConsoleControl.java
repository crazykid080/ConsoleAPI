package crazykid080.main.adminControls;

import java.util.ArrayList;

public class ConsoleControl{
	protected static ArrayList<Object> consoles = new ArrayList<>();
	protected static LogLevels fileLevel = LogLevels.Info;
	protected static int fileLevInt = 0;

	public static void registerConsole(Object hash){
		consoles.add(hash);
	}

	public static ArrayList<Object> getConsoles(){
		return consoles;
	}
	public static void write(String text){
		System.out.println(text);
		for (Object object : consoles) {
			((AdminConsole)object).write(text);
		}
	}
	public static void write(String text, LogLevels level){
		System.out.println(text);
		for (Object object : consoles) {
			((AdminConsole)object).write(text , level);
		}
		if(shouldWrite(level)){
			//DO THE THING WITH THE FILE THING HERE!
			System.out.println("DO THE THING");
		}
	}

	public static void createError(String text, LogLevels level, String className){
		String fullError = "ERROR ( "+ className + " )" + text;
		write(fullError, level);
	}

	public static void write(int i) {
		System.out.println(i);
		String a = String.valueOf(i);
		for (Object object : consoles) {
			((AdminConsole)object).write(a);
		}
	}
	
	public static void setFileLogging(LogLevels lev){
		if(lev == fileLevel){
			return;
		}else{
			fileLevel = lev;
		}
		switch (lev) {
		case Info:
			fileLevInt = 1;
			break;
		case Warning:
			fileLevInt = 2;
			break;
		case Error:
			fileLevInt = 3;
			break;
		case CRITICAL:
			fileLevInt = 4;
			break;
		default:
			break;
		}
	}
	
	private static boolean shouldWrite(LogLevels lev){
		System.out.println(lev);
		int internalLev = 0;
		switch (lev) {
		case Info:
			internalLev = 1;
			break;
		case Warning:
			internalLev = 2;
			break;
		case Error:
			internalLev = 3;
			break;
		case CRITICAL:
			internalLev = 4;
			break;
		default:
			break;
		}
		System.out.println(internalLev);
		if(fileLevInt <= internalLev){
			return true;
		}
		return false;
	}
	
}
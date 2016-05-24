package crazykid080.main.adminControls;

public class AdminCommandController{

	/**
	 * @author crazykid080
	 * @since 0.0.1
	 * @param command the text from the console.
	 * THIS SHOULD HAVE AN EXTENDED CLASS IN YOUR PROJECT!
	 */
	public static void runCommand(String command){		
		if(command.contains("exit")){
			exit();
		}
		ConsoleControl.write("ERROR: command doesn't seem to be valid!");

	}


	/** @author crazykid080
	 * @since 0.0.1
	 * Exits the program.
	 */
	public static void exit() {
		System.exit(1);
	}

}

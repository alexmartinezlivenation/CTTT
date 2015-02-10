package output.impl;

public class ConsoleDisplay implements DisplayInterface {

	public void clearScreen() {
		final String ESC = "\033[";
		try {
			final String os = System.getProperty("os.name");
			
			if (os.contains("Windows")) {
				Runtime.getRuntime().exec("cls");
			}
			else {
				Runtime.getRuntime().exec("clear");
				System.out.print(ESC + "2J");
			}
		}
		catch (final Exception e) {
			// Handle any exceptions
		}
	}

	public void writeToScreen(String text) {
		System.out.println(text);
	}

}

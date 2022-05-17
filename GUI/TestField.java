package GUI;

public class TestField {

	public TestField() {
		// Creates the windows
	}
	
	public void launchTitleScreen() {
		TitleScreen title = new TitleScreen(this);
	}
	
	public void sayText() {
		System.out.println("Hello Sir");
	}
	
	
	public static void main(String[] args) {
		TestField manager = new TestField();
		manager.launchTitleScreen();
	}
}

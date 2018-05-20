package application;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * This class is the Main class for the Flight Attendant's Application. It
 * launches the application and <br>
 * sets up the main scene.
 * 
 * @author Roger Cruz <br>
 *         Date 5/2018
 */

public class Main extends Application
{

	/**
	 * The start method of the class.
	 */
	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			this.primaryStage = primaryStage;
			showMainScene();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Displays the Main window of the application(aka: Home)
	 * 
	 * @throws IOException
	 */
	private void showMainScene() throws IOException
	{

		// Get the scene from the fxml file
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("/View/FlightAttendantView.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout, 600, 400);
		scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
		primaryStage.setTitle("Flight Attendat");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * The main method of the class
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		launch(args);
	}

	// Private Data Members
	private Stage primaryStage;
	private static Pane mainLayout;
}

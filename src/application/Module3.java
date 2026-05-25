package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Module3 extends Application  {
	/**
	 * top bar that includes a menu
	 * menu should have:
	 * first menu option: Print date and time in a text box.
	 * second menu option: write text box contents to a text file named "log.txt."
	 * third menu option: change frame background color changes to random color hue of the color green
	 * 		the menu option should display the initial random hue each time selected for a single execution of the program. 
	 * fourth menu option then the program exits.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Menu Example");
		// Create two menus to hold the four options
		Menu fileMenu = new Menu("File");
		MenuItem pullTimeStamp = new MenuItem("Pull Date and Time");
		MenuItem saveTimeStamp = new MenuItem("Save Date and Time");
		MenuItem exitOption = new MenuItem("Exit");
		fileMenu.getItems().add(pullTimeStamp);
		fileMenu.getItems().add(saveTimeStamp);
		fileMenu.getItems().add(exitOption);
		
		Menu colorMenu = new Menu("Color");
		MenuItem changeColor = new MenuItem("Change Background");
		colorMenu.getItems().add(changeColor);
		// Create MenuBar and add Menus
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().add(fileMenu);
		menuBar.getMenus().add(colorMenu);
		
		// TO DO: Create a text box object and add it to the window
		// TO DO: Create IO logic and imports to create log.txt
		// TO DO: create color generator function using random number generator to select green shade (randomize RGB: 0, random, 0)
		// TO DO: create dialogs for successful accomplishment of log.txt creation, and to display initial random hue
		// TO DO: Create Exit button logic 
		
		// Print date and time in a text box.
		
		
		// Write text box contents to a text file named "log.txt."
		String filePath = "log.txt";
		try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
			pw.println("Timestamp record:");
			pw.println();
			pw.println(timeStamp);
	        Alert alert = new Alert(AlertType.INFORMATION, 
	                "Timestamp written to " + filePath);
	        alert.showAndWait();
	        } catch (IOException e) {
	        	Alert alert = new Alert(AlertType.ERROR, 
	        			"Operation unsuccessful. log.txt not written.");
	        	alert.showAndWait();
	        }
	    }

		// Change frame background color
		
		// Exit
	    Alert alert = new Alert(AlertType.CONFIRMATION, 
	            "Are you sure you want to exit?");
	    alert.showAndWait();
	    
	    
		BorderPane root = new BorderPane();
		root.setTop(menuBar);
		Scene scene = new Scene(root, 600, 400, Color.GREEN);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
	Application.launch(args);
	}
}
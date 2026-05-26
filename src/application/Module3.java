package application;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

public class Module3 extends Application  {

	private String timeStamp = "";
    private final Random random = new Random();
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Module 3 Critical Thinking");
		
		// Menu setup
		Menu fileMenu = new Menu("File");
		MenuItem pullTimeStamp = new MenuItem("Pull Date and Time");
		MenuItem saveTimeStamp = new MenuItem("Save Date and Time");
		MenuItem exitOption = new MenuItem("Exit");
		fileMenu.getItems().addAll(pullTimeStamp, saveTimeStamp, exitOption);
		Menu colorMenu = new Menu("Color");
		MenuItem changeColor = new MenuItem("Change Background");
		colorMenu.getItems().add(changeColor);
		// Add Menus to MenuBar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, colorMenu);
		
		// Text Box to display Time Stamp
		TextArea timestampDisplay = new TextArea();
		timestampDisplay.setMaxWidth(300);
		timestampDisplay.setMaxHeight(50);
	    timestampDisplay.setEditable(false);
	    timestampDisplay.setWrapText(true);
	    timestampDisplay.setPromptText("Timestamp will appear here...");
	    // FIX ME: Text box fills entire window and background color not visible
	    
		// Event Handlers
		
		// Print date and time in a text box.
		pullTimeStamp.setOnAction(e -> {
	        final String timeStamp = "Current Date and Time:\n" + LocalDate.now() + " " + LocalTime.now();
	        
	        timestampDisplay.setText(timeStamp);   // Display in the text box
	        
	        Alert alert = new Alert(AlertType.INFORMATION, "Timestamp Updated:\n" + timeStamp);
	        alert.showAndWait();
	    });
		
		// Write text box contents to a text file named "log.txt."
		saveTimeStamp.setOnAction(e -> {
            if (timeStamp.isEmpty()) {
                Alert alert = new Alert(AlertType.WARNING, 
                		"No timestamp pulled yet!\nPlease use 'Pull Date and Time' first.");
                alert.showAndWait();
                return;
            }

            String filePath = "log.txt";
            try (PrintWriter pw = new PrintWriter(new FileWriter(filePath, true))) {
                pw.println("=== Timestamp Record ===");
                pw.println(timeStamp);
                pw.println("Saved on: " + LocalDate.now() + " " + LocalTime.now());
                pw.println("------------------------");

                Alert alert = new Alert(AlertType.INFORMATION, 
                		"Timestamp successfully saved to " + filePath);
                alert.showAndWait();
            } catch (IOException ex) {
                Alert alert = new Alert(AlertType.ERROR, 
                		"Failed to write to log.txt");
                alert.showAndWait();
            }
        });
		// FIX ME: does not detect text box fill

		// Change frame background color
		changeColor.setOnAction(e -> {
            // Random green hue (between 80 and 140 for nice green tones)
            double hue = 80 + random.nextDouble() * 60;
            Color randomGreen = Color.hsb(hue, 0.7, 0.85);
            
            Scene scene = primaryStage.getScene();
            if (scene != null) {
                scene.setFill(randomGreen);
            }

            Alert alert = new Alert(AlertType.INFORMATION, 
                "Background changed to random green hue.\nHue value: " + String.format("%.1f", hue));
            alert.showAndWait();
        });
		
		// Exit
		exitOption.setOnAction(e -> {
            Alert alert = new Alert(AlertType.CONFIRMATION, "Are you sure you want to exit?");
            alert.showAndWait().ifPresent(response -> {
                if (response == javafx.scene.control.ButtonType.OK) {
                    primaryStage.close();
                }
            });
        });
	    
	    
		BorderPane root = new BorderPane();
		root.setTop(menuBar);
		root.setCenter(timestampDisplay);
		Scene scene = new Scene(root, 500, 200, Color.GREEN);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
	Application.launch(args);
	}
}
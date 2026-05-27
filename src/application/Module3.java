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

    private final Random random = new Random();
    private TextArea timestampDisplay = new TextArea();
    private double initialHue;
    
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Module 3 Critical Thinking");
		// Menu setup
		Menu fileMenu = new Menu("File");
		MenuItem pullTimeStamp = new MenuItem("Pull Date and Time");
		MenuItem saveTimeStamp = new MenuItem("Save Date and Time");
		MenuItem changeColor = new MenuItem("Change Background");
		MenuItem exitOption = new MenuItem("Exit");
		Menu helpMenu = new Menu("Help");
		MenuItem aboutOption = new MenuItem("About Me");
		helpMenu.getItems().add(aboutOption);
		fileMenu.getItems().addAll(pullTimeStamp, saveTimeStamp, changeColor, exitOption);

		// Add Menus to MenuBar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);
		
		// Text Box to display Time Stamp
		timestampDisplay.setMaxWidth(300);
		timestampDisplay.setMaxHeight(50);
	    timestampDisplay.setEditable(false);
	    timestampDisplay.setWrapText(true);
	    timestampDisplay.setPromptText("Timestamp will appear here...");
		
		// Print date and time in a text box.
		pullTimeStamp.setOnAction(e -> {
	        final String timeStamp = "System Time:\n" + LocalDate.now() + " " + LocalTime.now();
	        timestampDisplay.setText(timeStamp);   // Display in the text box
	    });
		
		// Write text box contents to a text file named "log.txt."
		saveTimeStamp.setOnAction(e -> {
			String content = timestampDisplay.getText().trim();
            if (content.isEmpty()) {
                Alert alert = new Alert(AlertType.WARNING, 
                		"No timestamp pulled yet!\nPlease use 'Pull Date and Time' first.");
                alert.showAndWait();
                return;
            }

            String filePath = "log.txt";
            try (PrintWriter pw = new PrintWriter(new FileWriter(filePath, true))) {
                pw.println("=== Timestamp Record ===");
                pw.println(content);
                Alert alert = new Alert(AlertType.INFORMATION, 
                		"Timestamp successfully saved to " + filePath);
                alert.showAndWait();
            } catch (IOException ex) {
                Alert alert = new Alert(AlertType.ERROR, 
                		"Failed to write to log.txt");
                alert.showAndWait();
            }
        });

		// Change frame background color
		changeColor.setOnAction(e -> {
            // Random green hue (between 80 and 140 for nice green tones)
            double randomHue = 80 + random.nextDouble() * 60;
            Color randomGreen = Color.hsb(randomHue, 0.7, 0.85);
            
            Scene scene = primaryStage.getScene();
            if (scene != null) {
                scene.setFill(randomGreen);
            }
            // Display initial hue at each iteration
            Alert alert = new Alert(AlertType.INFORMATION, 
                "Background green value changed to: " + String.format("%.1f", randomHue) + "\nInitial green value was: " + String.format("%.1f", initialHue));
            alert.showAndWait();
            initialHue = randomHue;
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
		// Help Option
		aboutOption.setOnAction(e -> {
	        Alert alert = new Alert(AlertType.INFORMATION, 
	        		"Welcome the Benjamin Mossberg's Module 3 Submission v1.0!\n"
	        		+ "Pull Date and Time outputs your current system time.\n"
	        		+ "Save Date and Time saves that timestamp to current directory.\n"
	        		+ "Change Background generates a different green background.");
	        alert.showAndWait();
	    });
	    
		BorderPane root = new BorderPane();
		root.setTop(menuBar);
		root.setCenter(timestampDisplay);
		root.setStyle("-fx-background-color: transparent;");
		Scene scene = new Scene(root, 500, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
	Application.launch(args);
	}
}
package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AlertShowcase extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("The Alerts");
		
		// Define Buttons
		Button button1 = new Button("NONE");
		Button button2 = new Button("ERROR");
		Button button3 = new Button("CONFIRMATION");
		Button button4 = new Button("INFORMATION");
		Button button5 = new Button("WARNING");
		Button button6 = new Button("Button 6");
		
		// Define Display text object
		final Text actiontarget = new Text();
		
		// Create gridPane with padding
		GridPane gridPane = new GridPane();
		Insets gridPadding = new Insets(10, 10, 10, 10); // Window edge (Top, right, bottom, left)
		gridPane.setPadding(gridPadding); // Assign insets to pane
		gridPane.setHgap(10); // Padding between columns
		gridPane.setVgap(10); // Padding between rows
		
		// Add objects to pane
		gridPane.add(button1, 0, 0, 1, 1);
		gridPane.add(button2, 1, 0, 1, 1);
		gridPane.add(button3, 2, 0, 1, 1);
		gridPane.add(button4, 0, 1, 1, 1);
		gridPane.add(button5, 1, 1, 1, 1);
		gridPane.add(button6, 2, 1, 1, 1);
		gridPane.add(actiontarget,0,3,1,3);
		
		// Use Helper method to set Hgrow and Vgrow for buttons to fill cells
		makeFillCell(button1);
		makeFillCell(button2);
		makeFillCell(button3);
		makeFillCell(button4);
		makeFillCell(button5);
		makeFillCell(button6);
		button1.setOnAction(event -> {
			Alert alert = new Alert(AlertType.NONE, 
				"Type: NONE");
			alert.showAndWait();

		});
		button2.setOnAction(event -> {
			Alert alert = new Alert(AlertType.ERROR, 
				"Type: ERROR");
			alert.showAndWait();

		});
		button3.setOnAction(event -> {
			Alert alert = new Alert(AlertType.CONFIRMATION, 
					"Type: Confirmation");
			alert.showAndWait();
		});
		button4.setOnAction(event -> {
			Alert alert = new Alert(AlertType.INFORMATION, 
					"Type: INFORMATION");
			alert.showAndWait();
		});
		button5.setOnAction(event -> {
			Alert alert = new Alert(AlertType.WARNING, 
					"Type: WARNING");
			alert.showAndWait();
		});
		button6.setOnAction(event -> {
			actiontarget.setFill(Color.FORESTGREEN);
			actiontarget.setText("button six pressed");
		});
		Scene scene = new Scene(gridPane, 500, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	private void makeFillCell(Button button) {
		GridPane.setHgrow(button, Priority.ALWAYS);
	    GridPane.setVgrow(button, Priority.ALWAYS);
	    button.setMaxWidth(Double.MAX_VALUE);
	    button.setMaxHeight(Double.MAX_VALUE);
	}
   public static void main(String [] args) {
      launch(args); // Launch application
   }
}
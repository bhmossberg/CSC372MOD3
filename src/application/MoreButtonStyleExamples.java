package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MoreButtonStyleExamples extends Application  {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// Window title
		primaryStage.setTitle("Button Experiment 1");
		// Declare Buttons
		Button button1 = new Button("Button 1");
		Button button2 = new Button("Button 2");
		Button button3 = new Button("Button 3");
		Button button4 = new Button("Button 4");
		// actiontarget is a Text type object that will be used for displaying text on button press
		final Text actiontarget = new Text();
		// Attributes such as border color, border width, font size, and text fill for buttons
		button1.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
		button2.setStyle("-fx-background-color: #00ff00");
		button3.setStyle("-fx-font-size: 2em; ");
		button4.setStyle("-fx-text-fill: #0000ff");
		// New horizontal box to contain the buttons and text
		HBox hbox = new HBox(button1, button2, button3, button4,actiontarget);
		button1.setOnAction(event -> {
			actiontarget.setFill(Color.FIREBRICK);
			actiontarget.setText("button one pressed");
		});
		button2.setOnAction(event -> {
			actiontarget.setFill(Color.BLUE);
			actiontarget.setText("button two pressed");
		});
		button3.setOnAction(event -> {
			actiontarget.setFill(Color.ORANGERED);
			actiontarget.setText("button three pressed");
		});
		button4.setOnAction(event -> {
			actiontarget.setFill(Color.GREEN);
			actiontarget.setText("button four pressed");
		});
		Scene scene = new Scene(hbox, 400, 100);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
	Application.launch(args);
	}
}
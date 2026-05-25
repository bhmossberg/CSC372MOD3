package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class ButtonSample extends Application  {
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("The Alerts");
		Button button1 = new Button("Button 1");
		Button button2 = new Button("Button 2");
		Button button3 = new Button("Button 3");
		Button button4 = new Button("Button 4");
		Button button5 = new Button("Button 5");
		Button button6 = new Button("Button 6");
		final Text actiontarget = new Text();
		GridPane gridPane = new GridPane();
		gridPane.add(button1, 0, 0, 1, 1);
		gridPane.add(button2, 1, 0, 1, 1);
		gridPane.add(button3, 2, 0, 1, 1);
		gridPane.add(button4, 0, 1, 1, 1);
		gridPane.add(button5, 1, 1, 1, 1);
		gridPane.add(button6, 2, 1, 1, 1);
		gridPane.add(actiontarget,0,3,1,3);
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
		button5.setOnAction(event -> {
			actiontarget.setFill(Color.GOLDENROD);
			actiontarget.setText("button five pressed");
		});
		button6.setOnAction(event -> {
			actiontarget.setFill(Color.FORESTGREEN);
			actiontarget.setText("button six pressed");
		});
		Scene scene = new Scene(gridPane, 240, 100);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}

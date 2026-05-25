package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
public class MenuExample extends Application  {
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Menu Example");
		MenuItem menuItem1 = new MenuItem("Option 1");
		MenuItem menuItem2 = new MenuItem("Option 2");
		MenuItem menuItem3 = new MenuItem("Option 3");
		menuItem3.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
		System.out.println("Option 3 selected");
		}
		});
		menuItem2.setOnAction(event -> {
		System.out.println("Option 2 selected via Lambda");
		});
		MenuButton menuButton = new MenuButton("Options", null, menuItem1, menuItem2, menuItem3);
		HBox hbox = new HBox(menuButton);
		Scene scene = new Scene(hbox, 200, 100);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
	Application.launch(args);
	}
}
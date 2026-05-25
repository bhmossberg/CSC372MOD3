package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class IntroApplication extends Application {		// STEP 1a: Extending the Application
	@Override
	public void start(Stage primaryStage) {	// STEP 2: Overriding the start method
		try {
			
			// STEP 3: Create a pane and scene
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400, Color.BLACK);
			
			// STEP 4: Create and add graphical components
			Circle cir = new Circle(200, 200, 100);
			cir.setFill(Color.CORAL);
			root.getChildren().add(cir);
			
			// Optional: Use style sheet when creating rules which use -fx-Property
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			// STEP 5: Set and display the scene
			primaryStage.setTitle("This is the title.");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);					// STEP 1b: Launching the Application
	}
}

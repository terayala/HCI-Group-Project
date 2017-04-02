package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//construct a new model
			Model m = new Model(); 
			
			//construct a new controller
			Controller c = new Controller(m);
			
			//construct a new view 
			View v = new View(primaryStage, m, c);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

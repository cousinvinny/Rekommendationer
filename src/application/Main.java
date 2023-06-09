package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.InitialLoginModel;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		InitialLoginModel model = new InitialLoginModel();
		try {
			BorderPane root;
			if(model.chechDBForInitialLogin()==true) {//Flag column in database to signal initial login			
				root = (BorderPane) FXMLLoader.load(getClass().getResource("initialLog.fxml"));
			}
			else
				root = (BorderPane) FXMLLoader.load(getClass().getResource("returnLog.fxml"));
			Scene scene = new Scene(root, 1280, 720);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

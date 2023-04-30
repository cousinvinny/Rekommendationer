package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.ReturnLogModel;

public class ReturnLogController implements Initializable{
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void switchToSceneRecGUI(ActionEvent event) throws IOException {
		root = (BorderPane)FXMLLoader.load(getClass().getResource("mainPage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	/**
	 * LOG BACK IN
	 */
	@FXML PasswordField logBackInPF;
	@FXML Button logBackInBTN;
	@FXML Label returnLogPasswordStatus;
	User user = User.getUser();
	private String logBackInPW;
	ReturnLogModel returnLogModel = new ReturnLogModel();
	
	public void logBackIn(ActionEvent event) throws IOException {

		logBackInPW = logBackInPF.getText();
		try {
			if(returnLogModel.isLogin(logBackInPW)) {
				System.out.println("Login Success");
				switchToSceneRecGUI(event);
			}
			else {
				System.out.println("Login Failed");
				returnLogPasswordStatus.setVisible(true);
				returnLogPasswordStatus.setText("Incorrect password entered!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			returnLogPasswordStatus.setText("Incorrect password entered!");
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		returnLogPasswordStatus.setVisible(false);
	}
}
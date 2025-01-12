package com.github.grimbear42.charactercreator;


import java.io.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;

/**
 * Controller Class for application Splash Screen
 * 
 * @author Adam Barnard
 * @version 1.0 03/08/2024 
 */
public class SplashController {
	private Stage stage;
	private Scene scene;
	private Parent root;	
	
	//Loads scene for the name, race and class selection screen when the user 
	//selects the Create New Character Button
	@FXML
	protected void createNew(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("NameRaceClass.fxml"));
			root = fxmlLoader.load();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
}

package com.github.grimbear42.charactercreator;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;

/**
 * Main class of Character Creator Application
 * Compile and execute this file to run the Character Creator
 * 
 * @author Adam Barnard
 * @version 1.0 03/08/2024 
 */
public class App extends Application {
	
	//Start method
	//Loads the initial Java FX Stage and Scene 
	@Override
	public void start(Stage stage) {
		try {
			Scene scene = new Scene(loadFXML("CharacterCreator"), 640, 480);
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}

    protected static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
	
	//Main method
	//Launches the Application GUI
	public static void main(String[] args) {
		launch(args);
	}
	
}




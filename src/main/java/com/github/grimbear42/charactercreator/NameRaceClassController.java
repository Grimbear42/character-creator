package com.github.grimbear42.charactercreator;

import java.io.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.stage.*;

/**
 * Controller Class for Name, Race, and Class selection screen
 * 
 * @author Adam Barnard
 * @version 1.0 03/08/2024 
 */
public class NameRaceClassController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	//JavaFX ChoiceBox for selecting CharRace
	@FXML
	private ChoiceBox<String> raceSelect;
	//JavaFX ChoiceBox for selecting CharClass
	@FXML
	private ChoiceBox<String> classSelect;
	//JavaFX TextField for entering character's name
	@FXML
	private TextField nameField;
	//JavaFX Text to display Error message for invalid input
	@FXML
	private Text errorMessage;
	
	@FXML
	public void initialize() {
		//populate choiceboxes with class and race names
		classSelect.getItems().addAll(CharClasses.getClassNames());
		raceSelect.getItems().addAll(CharRaces.getRaceNames());
	}
	
	//Executed when the user clicks 'Choose Stats' Button
	//Loads passes data to the stat selection controller and loads the scene for stat selection
	@FXML	
	public void chooseStats(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(App.class.getResource("StatSelection.fxml"));
		try {
			root = loader.load();		
			
		} catch(IOException e) {
			e.printStackTrace();
		}	
		
		String name = nameField.getText();
		String className = classSelect.getValue();
		String raceName = raceSelect.getValue();
		//validate provided character name before continuing
		if(name != null && name.length() >0 && isAllLetters(name.toCharArray()) 
			&& className != null && raceName != null) 
		{
			Charac newChar = new Charac(name, CharRaces.getRace(raceName), 
														CharClasses.getClass(className));
			
			//load controller for next scene and pass data
			StatController statController = loader.getController();
			statController.startChar(newChar);
			
			//Loads the scene for stat selection
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} else {
			errorMessage.setVisible(true);
		}		
		
	}
	
	//Tests character array for non-letters and non-whitespace
	private static boolean isAllLetters(char[] word) {
		for(int i = 0; i < word.length; i++) {
			char c = word[i];
			if(!Character.isLetter(c) && !Character.isWhitespace(c)) {
				return false;
			}
		}
		
		return true;
	}
}

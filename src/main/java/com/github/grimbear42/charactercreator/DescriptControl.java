package com.github.grimbear42.charactercreator;

import java.io.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.stage.*;
import javafx.beans.value.*;

public class DescriptControl {
	private Charac currentChar;
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	//FXML injected UI elements
	@FXML
	private ChoiceBox<String> alignmentChoice;
	@FXML
	private ChoiceBox<String> backgroundChoice;
	@FXML
	private Spinner<Integer> heightFeet;
	@FXML
	private Spinner<Integer> heightInches;
	@FXML
	private Spinner<Integer> weight;
	@FXML
	private TextField eyeColor;
	@FXML
	private TextField hairColor;
	@FXML
	private TextField age;
	@FXML
	private Text heightRange;
	@FXML
	private Text weightRange;
	@FXML
	private Text ageRange;
	@FXML
	private Text heightError;
	@FXML
	private Text weightError;
	@FXML
	private Text ageError;
	@FXML
	private Text eyeColorError;
	@FXML
	private Text hairColorError;
	@FXML
	private Text alignmentError;
	@FXML
	private Text backgroundError;
	@FXML
	private Button applyChanges;
	
	//Receive the character and configure the interface
	public void setCharacter(Charac currentChar) {
		this.currentChar = currentChar;
		configureInterface();
		
	}
	
	
	private void configureInterface() {
		//populate choice boxes
		alignmentChoice.getItems().setAll(Charac.ALIGNMENTS);
		backgroundChoice.getItems().setAll(Backgrounds.getBackgroundNames());
		
		int minFeet = currentChar.getMyRace().getMinHeight() / 12;
		int minInches = currentChar.getMyRace().getMinHeight() % 12;
		int maxFeet = currentChar.getMyRace().getMaxHeight() / 12;
		int maxInches = currentChar.getMyRace().getMaxHeight() % 12;
		
		//create a spinner factory for height in feet
		SpinnerValueFactory<Integer> feetFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(minFeet, maxFeet);
		feetFactory.setValue(minFeet);
		heightFeet.setValueFactory(feetFactory);
		//add a listener to the height in feet spinner
		heightFeet.valueProperty().addListener(new ChangeListener<Integer>() {
			
			@Override
			public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
				//sets the error message visible if the selected height isn't valid
				heightError.setVisible(!currentChar.getMyRace().isValidHeight(newValue, heightInches.getValue()));
			}
			});
		
		//create a spinner factory for height in inches
		SpinnerValueFactory<Integer> inchFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 11);
		inchFactory.setValue(minInches);
		heightInches.setValueFactory(inchFactory);
		//add a listener to the height in inches
		heightInches.valueProperty().addListener(new ChangeListener<Integer>() {
			
			@Override
			public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
				//sets the error message visible if the selected height isn't valid
				heightError.setVisible(!currentChar.getMyRace().isValidHeight(heightFeet.getValue(), newValue));
			}
			});
		
		heightRange.setText(minFeet + "'" + minInches + "\" - " + maxFeet + "'" + maxInches + "\"");
		
		int minWeight = currentChar.getMyRace().getMinWeight();
		int maxWeight = currentChar.getMyRace().getMaxWeight();
		//create a spinner factory for the weight spinner
		SpinnerValueFactory<Integer> weightFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(minWeight, maxWeight);
		weightFactory.setValue(minWeight);
		weight.setValueFactory(weightFactory);
		//add a listener to the weight spinner
		weight.valueProperty().addListener(new ChangeListener<Integer>() {
			
			@Override
			public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
				weightError.setVisible(!currentChar.getMyRace().isValidWeight(newValue));
			}
			});
		weightRange.setText(minWeight + "lbs - " + maxWeight + "lbs");
		
		int minAge = currentChar.getMyRace().getMinAge();
		int maxAge = currentChar.getMyRace().getMaxAge();
		ageRange.setText(minAge + " - " + maxAge + " years old");		
	}
	
	@FXML
	private void applyChanges(ActionEvent e) {
		//TODO fix bug that won't allow you to correct an invalid input
		//disable error messages for choiceboxes
		alignmentError.setVisible(false);
		backgroundError.setVisible(false);
		//gather inputs from UI
		String alignmentValue = alignmentChoice.getValue();
		String backgroundValue = backgroundChoice.getValue();
		Integer heightFeetValue = heightFeet.getValue();
		Integer heightInchesValue = heightInches.getValue();
		Integer weightValue = weight.getValue();
		String eyeColorValue = eyeColor.getText();
		String hairColorValue = hairColor.getText();
		String ageValue = age.getText();
		
		//update the character if all inputs are valid then load the next scene
		if(validInputs(alignmentValue, backgroundValue, heightFeetValue, heightInchesValue, weightValue, eyeColorValue, hairColorValue, ageValue)) {
			currentChar.setAlignment(alignmentValue);
			currentChar.setBackground(Backgrounds.getBackground(backgroundValue));
			currentChar.setHeight(heightFeetValue, heightInchesValue);
			currentChar.setWeight(weightValue);
			currentChar.setEyeColor(eyeColorValue.toString());
			currentChar.setHairColor(hairColorValue.toString());
			currentChar.setAge(Integer.parseInt(ageValue));
			
			FXMLLoader loader = new FXMLLoader(App.class.getResource("Proficiencies.fxml"));
			try {
				root = loader.load();
			} catch(IOException ioe) {
				ioe.printStackTrace();
			}			
		
			ProficiencyController proficiencyController = loader.getController();
			proficiencyController.setCharacter(currentChar);
		
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
		}
	}
	
	//test for valid inputs
	private boolean validInputs(String alignment, String background, Integer heightFeet, Integer heightInches, Integer weight, String eyeColor, String hairColor, String age) {
		if(alignment == null) {
			alignmentError.setVisible(true);
		}
		if(background == null) {
			backgroundError.setVisible(true);
		}
		if(eyeColor == null || eyeColor.length() == 0) {
			eyeColorError.setVisible(true);
		}
		if(hairColor == null || hairColor.length() == 0) {
			hairColorError.setVisible(true);
		}
		if(age == null || age.length() == 0) {
			ageError.setVisible(true);
		}
		return !alignmentError.isVisible() && !backgroundError.isVisible() && !heightError.isVisible() && !weightError.isVisible() && !eyeColorError.isVisible() && !hairColorError.isVisible() && !ageError.isVisible();
		
	}
	
	//validation methods for each input
	private boolean isAllLetters(CharSequence word) {
		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(!Character.isLetter(c) && !Character.isWhitespace(c)) {
				return false;
			}
		}
		
		return true;
	}
	
	private boolean isNumeric(CharSequence number) {
		for(int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
			if(!Character.isDigit(c)) {
				return false;
			}
		}
		
		return true;
	}
	
	@FXML
	private void validEyeColor(ActionEvent e) {
		boolean isValidEyeColor = true;
		for(int i = 0; i < eyeColor.getLength(); i++) {
			String s = eyeColor.getText(i, i + 1);
			char c = s.charAt(0);
			if(!Character.isLetter(c) || !Character.isWhitespace(c)) {
				isValidEyeColor = false;
			}
		}
		eyeColor.setVisible(!isValidEyeColor);
	}
	
	@FXML
	private void validHairColor(ActionEvent e) {
		boolean isValidHairColor = true;
		for(int i = 0; i < hairColor.getLength(); i++) {
			String s = hairColor.getText(i, i + 1);
			char c = s.charAt(0);
			if(!Character.isLetter(c) || !Character.isWhitespace(c)) {
				isValidHairColor = false;
			}
		}
		hairColor.setVisible(!isValidHairColor);
	}
	
	@FXML
	private void validAge(ActionEvent e) {
		boolean isValidAge = true;
		for(int i = 0; i < age.getLength(); i++) {
			String s = age.getText(i, i + 1);
			char c = s.charAt(0);
			if(!Character.isDigit(c)) {
				isValidAge = false;
			}
		}
		ageError.setVisible(!isValidAge || !currentChar.getMyRace().isValidAge(Integer.parseInt(age.getText())));
	}
	
}

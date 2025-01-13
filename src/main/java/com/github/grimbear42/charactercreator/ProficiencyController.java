package com.github.grimbear42.charactercreator;

import java.io.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;
import javafx.collections.*;

//This class controls the scene for selection of proficiencies and language
public class ProficiencyController {
	private Charac currentChar;
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	//global variables to store the different available skills and proficiencies
	private Skills[] classSkills;
	private int numClassSkills;
	
	private Skills[] backgroundSkills;
	private int numBackgroundSkills;
	
	private Skills[] raceSkills;
	private int numRaceSkills;
	
	private int numLanguages;
	
	private String[] raceTools;
	private int numRaceTools;
	
	private String[] backgroundTools;
	private int numBackgroundTools;
	
	//Injected FXML for UI items
	@FXML
	private ListView<String> classSkillsList;
	@FXML
	private Text classSkillsText;
	@FXML
	private ListView<String> raceSkillsList;
	@FXML
	private Text raceSkillsText;
	@FXML
	private ListView<String> backgroundSkillsList;
	@FXML
	private Text backgroundSkillsText;
	@FXML
	private ListView<String> languageList;
	@FXML
	private Text languageText;
	@FXML
	private ListView<String> raceToolList;
	@FXML
	private Text raceToolText;
	@FXML
	private ListView<String> backgroundToolList;
	@FXML
	private Text backgroundToolText;
	@FXML
	private Button continueButton;

	//Load character in from previous scene
	protected void setCharacter(Charac currentChar) {
		this.currentChar = currentChar;
		populateInterface();	
	}
	
	//Populate the UI based on what is available to this character
	private void populateInterface() {
		CharClass myClass = currentChar.getMyClass();
		CharRace myRace = currentChar.getMyRace();
		Background myBackgrd = currentChar.getBackground();
		
		this.classSkills = myClass.getAvailableSkills();
		this.numClassSkills = myClass.getNumOfSkills();
		populateList(classSkillsList, classSkillsText, classSkills, numClassSkills);
		
		this.raceSkills = myRace.getSkillProficiencies();
		this.numRaceSkills = myRace.getNumOfSkills();
		populateList(raceSkillsList, raceSkillsText, raceSkills, numRaceSkills);
				
		this.backgroundSkills = myBackgrd.getSkillProficiencies();
		this.numBackgroundSkills = myBackgrd.getNumOfSkills();
		populateList(backgroundSkillsList, backgroundSkillsText, backgroundSkills, numBackgroundSkills);
		
		this.numLanguages = currentChar.getExtraLanguages();
		populateList(languageList, languageText, currentChar.getUnknownLanguages(), numLanguages);
		
		this.raceTools = myRace.getToolProficiencies();
		this.numRaceTools = myRace.getNumOfTools();
		populateList(raceToolList, raceToolText, raceTools, numRaceTools);
		
		this.backgroundTools = myBackgrd.getToolProficiencies();
		this.numBackgroundTools = myBackgrd.getNumOfTools();
		populateList(backgroundToolList, backgroundToolText, backgroundTools, numBackgroundTools);
	}
	
	//Populates a ListView and updates the associated text with the number of options that can be selected.
	private void populateList(ListView<String> list, Text text, Object[] listItems, int num) {
		list.setVisible(false);
		list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		text.setVisible(false);
		//only populate and display the listview if choices are available
		if(listItems != null && listItems.length > 0) {
			//process Skills objects
			if(listItems instanceof Skills[]) {
				Skills[] skillList = (Skills[])listItems;
				for(Skills skill : skillList) {
					list.getItems().add(Skill.SKILL_NAMES[skill.ordinal()]);
				}
			}
			
			//process Strings
			if(listItems instanceof String[]) {
				String[] stringList = (String[])listItems;
				list.getItems().addAll(stringList);
			}
			list.setVisible(true);
			text.setVisible(true);
			text.setText("Select " + num + " options below. \nCtrl-Click to select multiple options");
		}
	}
	
	//gather, validate and pass on inputs prior to loading next scene
	@FXML
	public void acceptSelections(ActionEvent e) {
		//flag for all inputs being valid
		boolean allValid = true;
		//objects to store selected items
		ObservableList<String> classSkillSelection = null;
		ObservableList<String> backgroundSkillSelection = null;
		ObservableList<String> languageSelection = null;
		ObservableList<String> raceToolSelection = null;
		ObservableList<String> backgroundToolSelection = null;
		
		//only validate list views that are visible
		if(classSkillsList.isVisible()) {
			classSkillSelection = classSkillsList.getSelectionModel().getSelectedItems();
			//if the input isn't valid set the flag to false;
			if(!validateSelections(classSkillsList, classSkillsText, numClassSkills, classSkillSelection)) {
				allValid = false;
			}			
		}
		if(backgroundSkillsList.isVisible()) {
			backgroundSkillSelection = backgroundSkillsList.getSelectionModel().getSelectedItems();
			if(!validateSelections(backgroundSkillsList, backgroundSkillsText, numBackgroundSkills, backgroundSkillSelection)) {
				allValid = false;
			}
		}
		if(languageList.isVisible()) {
			languageSelection = languageList.getSelectionModel().getSelectedItems();
			if(!validateSelections(languageList, languageText, numLanguages, languageSelection)) {
				allValid = false;
			}			
		}
		if(raceToolList.isVisible()) {
			raceToolSelection = raceToolList.getSelectionModel().getSelectedItems();
			if(!validateSelections(raceToolList, raceToolText, numRaceTools, raceToolSelection)) {
				allValid = false;
			}
		}
		if(backgroundToolList.isVisible()) {
			backgroundToolSelection = backgroundToolList.getSelectionModel().getSelectedItems();
			if(!validateSelections(backgroundToolList, backgroundToolText, numBackgroundTools, backgroundToolSelection)) {
				allValid = false;
			}
		}
		//If any inputs are invalid, leave the method.
		if(!allValid) {
			return;
		}
		
		//apply all selections to the current character
		if(classSkillSelection != null) {
			currentChar.updateProficiencies(classSkillSelection.toArray(new String[0]));
		}
		
		if(backgroundSkillSelection != null) {
			currentChar.updateProficiencies(backgroundSkillSelection.toArray(new String[0]));
		}
		
		if(languageSelection != null) {
			currentChar.updateLanguages(languageSelection.toArray(new String[0]));
		}
		
		if(raceToolSelection != null) {
			currentChar.updateToolProficiencies(raceToolSelection.toArray(new String[0]));
		}
		
		if(backgroundToolSelection != null) {
			currentChar.updateToolProficiencies(backgroundToolSelection.toArray(new String[0]));
		}
		
		//load the next scene
		FXMLLoader loader = new FXMLLoader(App.class.getResource("DisplayCharacter.fxml"));
		try {
			root = loader.load();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
			
		DisplayController displayController = loader.getController();
		displayController.setCharacter(currentChar);
	
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	//Check that the appropriate number of items have been selected from the listview
	private boolean validateSelections(ListView<String> list, Text text, int allowedNum, ObservableList<String> selectionList) {
		if(selectionList == null) {
			throw new NullPointerException("Null Selection List provided");
		}
		//if the wrong number of items is selected, display and error message and return false
		if(selectionList.size() != allowedNum) {
				text.setText(allowedNum + " selections required. " + selectionList.size() + " options selected.");
				text.setSelectionFill(Color.RED);
				return false;
		}
		
		return true;
	}
	
	
}

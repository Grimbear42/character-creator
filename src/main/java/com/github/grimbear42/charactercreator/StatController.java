package com.github.grimbear42.charactercreator;

import java.io.*;
import java.util.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;


public class StatController {
	//The current Charactre
	private Charac currentChar;
	//JavaFX controls
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	//Injected JavaFX elements for the user interface
	@FXML
	private RadioButton rollStats;
	//@FXML
	//private RadioButton pointBuy;
	@FXML
	private RadioButton preRoll;
	@FXML
	private AnchorPane rollStatsPane;
	//@FXML
	//private AnchorPane pointBuyPane;
	@FXML
	private AnchorPane preRollPane;
	@FXML
	private Text availablePreRoll;
	@FXML
	private Text availableRolledStats;
	@FXML
	private ChoiceBox<Integer> preRollStrChoice;
	@FXML
	private ChoiceBox<Integer> preRollDexChoice;
	@FXML
	private ChoiceBox<Integer> preRollConChoice;
	@FXML
	private ChoiceBox<Integer> preRollIntChoice;
	@FXML
	private ChoiceBox<Integer> preRollWisChoice;
	@FXML
	private ChoiceBox<Integer> preRollChaChoice;
	@FXML
	private ChoiceBox<Integer> rollStrChoice;
	@FXML
	private ChoiceBox<Integer> rollDexChoice;
	@FXML
	private ChoiceBox<Integer> rollConChoice;
	@FXML
	private ChoiceBox<Integer> rollIntChoice;
	@FXML
	private ChoiceBox<Integer> rollWisChoice;
	@FXML
	private ChoiceBox<Integer> rollChaChoice;
	@FXML
	private Text preRollStrModifierTxt;
	@FXML
	private Text preRollDexModifierTxt;
	@FXML
	private Text preRollConModifierTxt;
	@FXML
	private Text preRollIntModifierTxt;
	@FXML
	private Text preRollWisModifierTxt;
	@FXML
	private Text preRollChaModifierTxt;
	@FXML
	private Text preRollStrTotalTxt;
	@FXML
	private Text preRollDexTotalTxt;
	@FXML
	private Text preRollConTotalTxt;
	@FXML
	private Text preRollIntTotalTxt;
	@FXML
	private Text preRollWisTotalTxt;
	@FXML
	private Text preRollChaTotalTxt;
	@FXML
	private Text rollStrModifierTxt;
	@FXML
	private Text rollDexModifierTxt;
	@FXML
	private Text rollConModifierTxt;
	@FXML
	private Text rollIntModifierTxt;
	@FXML
	private Text rollWisModifierTxt;
	@FXML
	private Text rollChaModifierTxt;
	@FXML
	private Text rollStrTotalTxt;
	@FXML
	private Text rollDexTotalTxt;
	@FXML
	private Text rollConTotalTxt;
	@FXML
	private Text rollIntTotalTxt;
	@FXML
	private Text rollWisTotalTxt;
	@FXML
	private Text rollChaTotalTxt;
	@FXML
	private Text errorMessage;
	
	//Global variables for the pre-selected stat user interface
	private ChoiceBox<Integer>[] preRollChoices;
	private Text[] preRollModifiersTxt;
	private Text[] preRollTotalStatTxt;
	private Integer[] preRolledStats;
	
	//Global variables for rolled stat user inteface
	private ChoiceBox<Integer>[] rollChoices;
	private Text[] rollModifiersTxt;
	private Text[] rollTotalStatTxt;
	private Integer[] rolledStats;
	private String rolledStatsString;
	
	//Selected user interface
	private ChoiceBox<Integer>[] statChoices;
	private Text[] statModifiersTxt;
	private Text[] totalStatTxt;
	private Integer[] availableStats;
	
	
    //initialization method
    //configures the initial elements and creates groupings for later manipulation
	@SuppressWarnings("unchecked")
	public void initialize() {
		//Group radio buttons
		ToggleGroup radioGroup = new ToggleGroup();
		rollStats.setToggleGroup(radioGroup);
		//pointBuy.setToggleGroup(radioGroup);
		preRoll.setToggleGroup(radioGroup);
		//disable all interface options, until the user selects a radio button
		rollStatsPane.setDisable(true);
		//pointBuyPane.setDisable(true);
		preRollPane.setDisable(true);
		
		//populate options pre-selected stat interface
		preRollChoices = new ChoiceBox[]{preRollStrChoice, preRollDexChoice, preRollConChoice, preRollIntChoice, preRollWisChoice, preRollChaChoice};
		preRollModifiersTxt = new Text[]{preRollStrModifierTxt, preRollDexModifierTxt, preRollConModifierTxt, preRollIntModifierTxt, preRollWisModifierTxt, preRollChaModifierTxt};
		preRollTotalStatTxt = new Text[]{preRollStrTotalTxt, preRollDexTotalTxt, preRollConTotalTxt, preRollIntTotalTxt, preRollWisTotalTxt, preRollChaTotalTxt};
		preRolledStats = Stat.PREROLLSTATS;
		
		//Populate options for randomly generated stats
		rollChoices = new ChoiceBox[]{rollStrChoice, rollDexChoice, rollConChoice, rollIntChoice, rollWisChoice, rollChaChoice};
		rollModifiersTxt = new Text[]{rollStrModifierTxt, rollDexModifierTxt, rollConModifierTxt, rollIntModifierTxt, rollWisModifierTxt, rollChaModifierTxt};
		rollTotalStatTxt = new Text[]{rollStrTotalTxt, rollDexTotalTxt, rollConTotalTxt, rollIntTotalTxt, rollWisTotalTxt, rollChaTotalTxt};
		//Randomly Generate Ability Scores
		rolledStats = Stat.rollStats();
		rolledStatsString = rolledStats[0].toString();
		
		//Display randomly generated scores
		for(int i = 1; i < rolledStats.length; i++) {
			rolledStatsString += ", " + rolledStats[i].toString();
		}
		availableRolledStats.setText("Available Scores: " + rolledStatsString);
		
	}
	
	//Initialize global Charac variable with Charac from last scene
	//Called by "Choose Stats" in previous scene
	@FXML
	public void startChar(Charac currentChar) {
		this.currentChar = currentChar;
	}
	
	//Populates the inteface with racial ability score modifiers, populates each 
	//choicebox with the available ability scores
	private void populateStatInterface() {
		int[] statModifiers = currentChar.getStatModifiers();
		for(int i = 0; i < statModifiersTxt.length; i++) {
			statModifiersTxt[i].setText("+" + statModifiers[i]);
		}
		for(ChoiceBox<Integer> statChoice : statChoices) {
			statChoice.getItems().addAll(availableStats);
			statChoice.setOnAction(this::updateChoiceBoxes);
		}
		for(Text total : totalStatTxt) {
			total.setText("Total: ");
		}
	}
	
	//On action method for Radio Buttons
	//Enables the selected pane, disables any other panes, assigns the 
	//appropriate interface items to the variables for the current inteface.
	@FXML
	public void paneSelect(ActionEvent e) {
		String paneId = ((Node)e.getSource()).getId();
		switch(paneId) {
			case "rollStats": {
				rollStatsPane.setDisable(false);
				//pointBuyPane.setDisable(true);
				preRollPane.setDisable(true);
				statChoices = rollChoices;
				statModifiersTxt = rollModifiersTxt;
				totalStatTxt = rollTotalStatTxt;
				availableStats = rolledStats;
				populateStatInterface();
			};
			break;
			//TODO add point buy capabilities
			//case "pointBuy": {
				//rollStatsPane.setDisable(true);
				//pointBuyPane.setDisable(false);
				//preRollPane.setDisable(true);
			//};
			//break;
			case "preRoll": {
				rollStatsPane.setDisable(true);
				//pointBuyPane.setDisable(true);
				preRollPane.setDisable(false);
				availableStats = Stat.PREROLLSTATS;
				statChoices = preRollChoices;
				statModifiersTxt = preRollModifiersTxt;
				totalStatTxt = preRollTotalStatTxt;
				populateStatInterface();
			};
			break;
		}
	}
	
	//On Action method for all ChoiceBoxes
	//Updates the dsiplayed Total Ability Score based on the selected value and 
	//its modifier
	private void updateChoiceBoxes(ActionEvent e) {
		for(int i = 0; i < statChoices.length; i++) {
			Integer value = statChoices[i].getValue();
			if(value != null) {
				totalStatTxt[i].setText("Total: " + (value + Integer.parseInt(statModifiersTxt[i].getText().substring(1))));
			} else {
				totalStatTxt[i].setText("Total: ");
			}
		}			
	}
	
	//On Action method for the Apply Stats buttons
	@FXML
	private void applyStats(ActionEvent e) {
		//validate ability score selections
		if(!isUniqueStats()) {
			errorMessage.setVisible(true);
			errorMessage.setText("Error: One or more available Ability Scores have been assigned more than once!");
			errorMessage.setFill(Color.RED);
		} else {
			errorMessage.setVisible(false);
			
			//Store selected ability scores
			Integer[] selectedStats = new Integer[6];
			for(int i = 0; i < statChoices.length; i++) {
				selectedStats[i] = statChoices[i].getValue();
			}
			
			//assign selected ability scores to the character
			currentChar.setCharStats(selectedStats);
			
			//load the next scene and pass the character to its controller
			FXMLLoader loader = new FXMLLoader(App.class.getResource("Description.fxml"));
			try{
				root = loader.load();
			} catch(IOException ioe) {
				ioe.printStackTrace();
			}
			
			
			DescriptControl descriptControl = loader.getController();
			descriptControl.setCharacter(currentChar);
			
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		
		
		
		
	}
	
	//Determines if each available ability score has only been selected once
	private boolean isUniqueStats() {
		Integer[] selectedStats = new Integer[6];
		int index = 0;
		for(ChoiceBox<Integer> statChoice : statChoices) {
			Integer value = statChoice.getValue();
			if(value == null) return false;
			selectedStats[index++] = value;			
		}
		Arrays.sort(selectedStats);
		Arrays.sort(availableStats);
		for(int i = 0; i < selectedStats.length; i++) {
			if(selectedStats[i] != availableStats[i]) return false;
		}
		
		return true;
	}
	
}

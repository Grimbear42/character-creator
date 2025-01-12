package com.github.grimbear42.charactercreator;

import javafx.fxml.*;
import javafx.scene.text.*;

//This class controls the scene for displaying the completed character
public class DisplayController {
	private Charac currentChar;
	
	//FXML injected elements to display character information
	@FXML	
	private Text name;
	@FXML
	private Text className;
	@FXML
	private Text raceName;
	@FXML
	private Text level;
	@FXML
	private Text background;
	@FXML
	private Text alignment;
	@FXML
	private Text str;
	@FXML
	private Text strMod;
	@FXML
	private Text dex;
	@FXML
	private Text dexMod;
	@FXML
	private Text con;
	@FXML
	private Text conMod;
	@FXML
	private Text intell;
	@FXML
	private Text intellMod;
	@FXML
	private Text wis;
	@FXML
	private Text wisMod;
	@FXML
	private Text cha;
	@FXML
	private Text chaMod;
	@FXML
	private Text proficiencyBonus;
	@FXML
	private Text strSaving;
	@FXML
	private Text dexSaving;
	@FXML
	private Text conSaving;
	@FXML
	private Text intSaving;
	@FXML
	private Text wisSaving;
	@FXML
	private Text chaSaving;
	@FXML
	private Text skills;
	@FXML
	private Text passivePerception;
	@FXML
	private Text initiative;
	@FXML
	private Text speed;
	@FXML
	private Text armorClass;
	@FXML
	private Text hitPoints;
	@FXML
	private Text hitDice;
	@FXML
	private Text languages;
	@FXML
	private Text proficiencies;
	@FXML
	private Text features;
	@FXML
	private Text equipment;

	//accept the character from the previous scene
	public void setCharacter(Charac currentChar) {
		this.currentChar = currentChar;
		populateCharacterView();	
	}
	
	//Populate the scene with all of the character's information
	private void populateCharacterView() {
		name.setText("Character Name: " + currentChar.getCharName());
		className.setText("Class: " + currentChar.getMyClass().getClassName());
		raceName.setText("Race: " + currentChar.getMyRace().getRaceName());
		level.setText("Level: " + currentChar.getLevel());
		background.setText("Background: " + currentChar.getBackground().getBackgroundName());
		alignment.setText("Alignment: " + currentChar.getAlignment());
		setStatTexts();
		proficiencyBonus.setText("+" + currentChar.getProficiencyBonus());
		setSkillsText();
		passivePerception.setText("Passive Perception: " + currentChar.getPassivePercept());
		int initValue = currentChar.getInitiative();
		initiative.setText(initValue < 0 ? "" + initValue : "+" + initValue);
		speed.setText(currentChar.getSpeed() + " feet");
		armorClass.setText("" + currentChar.getArmorClass());
		hitPoints.setText("Hit points: " + currentChar.getHitPoints());
		hitDice.setText("Hit Dice: " + currentChar.getHitDice());
		languages.setText("Languages:\n" + buildStringList(currentChar.getKnownLanguages()));
		proficiencies.setText("Proficiencies:\n" + buildStringList(currentChar.getCombinedProficiencies()));
		features.setText("Features:\n" + buildStringList(currentChar.getCombinedFeatures()));
		equipment.setText("Equipment:\n" + buildStringList(currentChar.getEquipment()));
	}
	
	//Display all Ability Score information
	private void setStatTexts() {
		Text[] statTexts = new Text[]{str, dex, con, intell, wis, cha};
		Text[] statMods = new Text[]{strMod, dexMod, conMod, intellMod, wisMod, chaMod};
		Text[] statSaves = new Text[]{strSaving, dexSaving, conSaving, intSaving, wisSaving, chaSaving};
		int[] stats = currentChar.getStats();
		int[] statModArray = currentChar.getMods();
		int[] statSavesArray = currentChar.getSaves();
		
		for(int i = 0; i < 6; i++) {
			setStatText(Stat.STATNAMES[i], statTexts[i], statMods[i], statSaves[i], stats[i], statModArray[i], statSavesArray[i]);
		}
	}
	
	//Display information for a single Ability Score
	private void setStatText(String statName, Text statText, Text modText, Text saveText, int stat, int mod, int save) {
		String modString = "Modifier: ";
		String saveString = "Save: ";
		//Put a plus sign in front of positive numbers
		if(mod >= 0) {
			modString += "+";
		}
		if(save >= 0) {
			saveString += "+";
		}
		statText.setText(statName + ": " + stat);
		modText.setText(modString + mod);
		saveText.setText(saveString + save);
	}
	
	//Display all skill information
	private void setSkillsText() {
		StringBuilder skillString = new StringBuilder();
		int[] skillMods = currentChar.getSkillModifiers();
		
		for(int i = 0; i < Skill.SKILL_NAMES.length; i++) {
			skillString.append(Skill.SKILL_NAMES[i]);
			skillString.append(" : ");
			if(skillMods[i] >= 0) {
				skillString.append("+");
			}
			skillString.append(skillMods[i]);
			skillString.append("\n");
		}
		
		this.skills.setText(skillString.toString());
	}
	
	/** 
	* Combines the contents of a String Array in a single String object, with 
	* each element of the array seperated by a line break.
	* 
	* @param items a String array
	* @return a String containing all of the Strings within items, seperated by
	*         line breaks,
	* 
	* @since 1.0
	*/
	private String buildStringList(String[] items) {
		StringBuilder stringList = new StringBuilder();
		for(String item : items) {
			stringList.append(item);
			stringList.append("\n");
		}
		
		return stringList.toString();
	}
	
}

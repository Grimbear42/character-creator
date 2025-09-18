package com.github.grimbear42.charactercreator;

import java.util.*;
/**
 * Charac Class
 * 
 * Defines a Charac object representing a D&D character.  It consists of a 
 * character name, ability scores, hit points, class, race, background, 
 * alignment, initiative, age, height, weight, hair and eye color, armorClass, 
 * skill proficiencies, weapon, armor, and tool proficiencies, and known 
 * languages.
 * 
 * @author Adam Barnard
 * @version 1.0 03/08/2024 
 */
public class Charac {
	/** 
	 * A constant representing all available character alignments
	 */	
	public static final String[] ALIGNMENTS = new String[]{
			"Lawful Good", "Neutral Good", "Chaotic Good", "Lawful Neutral", 
			"True Neutral", "Chaotic Neutral", "Lawful Evil", "Neutral Evil", 
			"Chaotic Evil"
		};
	/** 
	 * A constant representing all available languages
	 */	
	public static final String[] LANGUAGES = new String[]{
			"Common", "Dwarvish", "Elvish", "Giant", "Gnomish", "Goblin", 
			"Halfling", "Orc", "Abyssal", "Celestial", "Draconic", 
			"Deep Speech", "Infernal", "Primordial", "Sylvan", "Undercommon"
		};
	
	/** 
	 * The name of this character
	 */
	private String charName;
	/** 
	 * This character's Race
	 */
	private CharRace myRace;
	/** 
	 * This character's Class
	 */
	private CharClass myClass;
	/** 
	 * This character's Background
	 */
	private Background background;
	/** 
	 * An array of this character's Stats
	 */
	private Stat[] charStats;	
	/** 
	 * This character's number of hit points
	 */
	private int hitPoints;	
	/** 
	 * This character's alignment
	 */
	private String alignment;
	/** 
	 * This character's initiative bonus
	 */
	private int initiative;
	/** 
	 * This character's eye color
	 */
	private String eyeColor;
	/** 
	 * This character's hair color
	 */
	private String hairColor;
	/** 
	 * This character's age
	 */
	private int age;
	/** 
	 * This character's height
	 */
	private int height;
	/** 
	 * This character's weight
	 */
	private int weight;
	/** 
	 * This character's Armor Class
	 */
	private int armorClass;
	/** 
	 * This character's skill proficiencies
	 */
	private Skill[] skillProficiencies;
	/** 
	 * This character's armor, weapon, and tool proficiencies
	 */
	private String[] combinedProficiencies;
	/** 
	 * This character's features
	 */
	private String[] combinedFeatures;
	/** 
	 * This character's known languages
	 */
	private String[] knownLanguages;
	
	//
	// Constructors
	//
	
	/** 
	* Constructor for <code>Charac</code> class
	* 
	* @param charName The name of this character
	* @param myRace The race for this character
	* @param myClass The class for this character
	* 
	* @throws IllegalArgumentException when any parameter is null or charName is
	* 								   an empty String.
	*
	* @since 1.0
	*/
	protected Charac(String charName, CharRace myRace, CharClass myClass) {			
			if(charName == null || myRace == null || myClass == null) {
				throw new IllegalArgumentException("Null Value provided");
			}
			if(charName.length() == 0) {
				throw new IllegalArgumentException("Empty Name String");
			}
			this.setCharName(charName);
			this.setMyRace(myRace);
			this.setMyClass(myClass);
			//crate empty Stat array
			this.charStats = new Stat[6];
			//initialize skill array and populate with every skill
			this.skillProficiencies = new Skill[Skills.values().length];
			for(Skills skill : Skills.values()) {
				this.skillProficiencies[skill.ordinal()] = new Skill(skill);
			}
			//consolidate class and race proficiencies
			this.setCombinedProficiencies(new String[][]{
											myClass.getArmorProficiencies(), 
											myClass.getWeaponProficiencies(), 
											myRace.getWeaponProficiencies(),
											myRace.getArmorProficiencies()
											});
			//consolidate class and race features			
			this.setCombinedFeatures(new String[][] {
											myClass.getClassFeatures(), 
											myRace.getFeatures()});
			//set non-optional languages
			this.setKnownLanguages(this.getMyRace().getLanguages());
	
	}
	
	//
	// Getters and Setters for this Class
	//
	
	/** 
	* Accessor method for <code>charName</code>.
	* 
	* @param charName the name of this character
	* 
	* @since 1.0
	*/
	private void setCharName(String charName) {
		this.charName = charName;
	}
	
	/** 
	* Accessor method for <code>charName</code>.
	* 
	* @return copy of the <code>charName</code> property.
	* 
	* @since 1.0
	*/
	protected String getCharName() {
		return String.valueOf(this.charName);
	}
	
	/** 
	* Accessor method for <code>myRace</code>.
	* 
	* @param myRace the race of this character
	* 
	* @since 1.0
	*/
	private void setMyRace(CharRace myRace) {
		this.myRace = myRace;
	}
	
	/** 
	* Accessor method for <code>myRace</code>.
	* 
	* @return copy of the <code>myRace</code> property.
	* 
	* @since 1.0
	*/
	protected CharRace getMyRace() {
		return this.myRace.copyOf();
	}
	
	/** 
	* Accessor method for <code>myClass</code>.
	* 
	* @param myClass the class of this character
	* 
	* @since 1.0
	*/
	private void setMyClass(CharClass myClass) {
		this.myClass = myClass;
	}
	
	/** 
	* Accessor method for <code>myClass</code>.
	* 
	* @return copy of the <code>myClass</code> property.
	* 
	* @since 1.0
	*/
	protected CharClass getMyClass() {
		return this.myClass.copyOf();
	}
	
	/** 
	* Accessor method for <code>background</code>.
	* 
	* @param background the background of this character
	* @throws IllegalArgumentException when background is null
	* 
	* @since 1.0
	*/
	protected void setBackground(Background background) {
		if(background == null) {
			throw new IllegalArgumentException("No Background Provided");
		}
		this.background = background;
		
		//add background features to combinedFeatures
		if(this.background.getToolProficiencies() != null) {
			this.setCombinedProficiencies(new String[][]{
											this.getCombinedFeatures(), 
											this.background.getToolProficiencies()
												});
		} 
		
	}
	
	/** 
	* Accessor method for <code>background</code>.
	* 
	* @return copy of the <code>background</code> property.
	* 
	* @since 1.0
	*/
	protected Background getBackground() {
		return this.background.copyOf();
	}
	
	/** 
	* Accessor method for <code>charStats</code>.
	* 
	* @param statArray the background of this character
	* @throws IllegalArgumentException when statArray or any value in statArray 
	* 								   is null
	* 
	* @since 1.0
	*/
	protected void setCharStats(Integer[] statArray) {
		if(statArray == null) {
			throw new IllegalArgumentException("Null Array");
		}
		//get racial stat modifiers
		int[] statModifiers = myRace.getStatModifiers();
		for(int i = 0; i < statArray.length; i++) {
			if(statArray[i] == null) {
				throw new IllegalArgumentException("Null Stat Value");
			}
			//initialize each ability score
			this.charStats[i] = new Stat(statArray[i] + statModifiers[i]);
		}
		//1st level character gets maximum hit points
		setHitPoints(myClass.getHitDie());
		//set initiative bonus based on dexterity modifier
		setInitiative(this.charStats[Stat.DEX].getModifier());
		//set armor class (requires dex and con modifiers)
		setArmorClass();
	}
	
	/** 
	* Accessor method for <code>charStats</code>.
	* 
	* @return int array containing values of each ability score
	* 
	* @since 1.0
	*/
	protected int[] getStats() {
		int[] statValues = new int[6];
		for(int i = 0; i < 6; i++) {
			statValues[i] = this.charStats[i].getValue();
		}
		
		return statValues;
	}
		
	/** 
	* Accessor method for <code>hitPoints</code>.
	* 
	* @param hitPoints this character's hit points
	* @throws IllegalArgumentException when hitpoints is negative, or greater 
	* 								   than maximum possible hit points for this
	* 								   character's level
	* 
	* @since 1.0
	*/
	private void setHitPoints(int hitPoints) {
		if(hitPoints < 0 || hitPoints > 
									(myClass.getHitDie() + 
									charStats[Stat.CON].getModifier()) * 
									myClass.getLevel()) {
			throw new IllegalArgumentException("Invalid Hit Point total");
		}
		this.hitPoints = hitPoints;
	}
	
	/** 
	* Accessor method for <code>hitPoints</code>.
	* 
	* @return value of the <code>hitPoints</code> property.
	* 
	* @since 1.0
	*/
	protected int getHitPoints() {
		return this.hitPoints;
	}
	
	/** 
	* Accessor method for <code>alignment</code>.
	* 
	* @param alignment the background of this character
	* @throws IllegalArgumentException when alignment is null or not a value in 
	* 								   the ALIGNMENT constant
	* 
	* @since 1.0
	*/
	protected void setAlignment(String alignment) {
		if(alignment == null || !Charac.contains(Charac.ALIGNMENTS, alignment)) {
			throw new IllegalArgumentException("Invalid Alignment Value");
		}
		this.alignment = alignment;
	}
	
	/** 
	* Accessor method for <code>alignment</code>.
	* 
	* @return copy of the <code>alignment</code> property.
	* 
	* @since 1.0
	*/
	protected String getAlignment() {
		return String.valueOf(this.alignment);
	}
	
	
	/** 
	* Accessor method for <code>initiative</code>.
	* 
	* @param initiative this character's initiavtive bonus
	* 
	* @since 1.0
	*/
	private void setInitiative(int initiative) {
		this.initiative = initiative;
	}
	
	/** 
	* Accessor method for <code>initiative</code>.
	* 
	* @return value of the <code>initiative</code> property.
	* 
	* @since 1.0
	*/
	protected int getInitiative() {
		return this.initiative;
	}
	
	/** 
	* Accessor method for <code>eyeColor</code>.
	* 
	* @param eyeColor this character's eye color
	* @throws IllegalArgumentException when eyeColor is null or contains 
	* 								   characters other than letters or whitespace
	* 
	* @since 1.0
	*/	
	protected void setEyeColor(String eyeColor) {
		if(eyeColor == null || !isOnlyLetters(eyeColor)) {
			throw new IllegalArgumentException("Invalid Input");
		}
		this.eyeColor = eyeColor;
	}
	
	/** 
	* Accessor method for <code>eyeColor</code>.
	* 
	* @return copy of the <code>eyeColor</code> property.
	* 
	* @since 1.0
	*/
	protected String getEyeColor() {
		return String.valueOf(this.eyeColor);
	}
	
	/** 
	* Accessor method for <code>hairColor</code>.
	* 
	* @param hairColor this character's hair color
	* @throws IllegalArgumentException when hairColor is null or contains 
	* 								   characters other than letters or whitespace
	* 
	* @since 1.0
	*/	
	protected void setHairColor(String hairColor) {
		if(hairColor == null || !isOnlyLetters(hairColor)) {
			throw new IllegalArgumentException("Invalid Input");
		}
		this.hairColor = hairColor;
	}
	
	/** 
	* Accessor method for <code>hairColor</code>.
	* 
	* @return copy of the <code>hairColor</code> property.
	* 
	* @since 1.0
	*/
	public String getHairColor() {
		return String.valueOf(this.hairColor);
	}
	
	/** 
	* Accessor method for <code>age</code>.
	* 
	* @param age this character's age
	* @throws IllegalArgumentException when age is outside racial limits
	* 
	* @since 1.0
	*/	
	protected void setAge(int age) {
		if(!this.myRace.isValidAge(age)) {
			throw new IllegalArgumentException("Age outside racial limits");
		}
		this.age = age;
	}
	
	/** 
	* Accessor method for <code>age</code>.
	* 
	* @return value of the <code>age</code> property.
	* 
	* @since 1.0
	*/
	protected int getAge() {
		return this.age;
	}
	
	/** 
	* Accessor method for <code>height</code>.
	* 
	* @param heightFeet this character's height in feet
	* @param heightInches this character's height in inches
	* @throws IllegalArgumentException when height is outside racial limits
	* 
	* @since 1.0
	*/
	protected void setHeight(int heightFeet, int heightInches) {
		if(!this.myRace.isValidHeight(heightFeet, heightInches)) {
			throw new IllegalArgumentException("Height outside racial limits");
		}
		this.setHeight(heightFeet * 12 + heightInches);
	}
	
	/** 
	* Accessor method for <code>height</code>.
	* 
	* @param height this character's height in inches
	* 
	* @since 1.0
	*/
	private void setHeight(int height) {
		
		this.height = height;
	}
	
	/** 
	* Accessor method for <code>height</code>.
	* 
	* @return value of the <code>height</code> property in inches.
	* 
	* @since 1.0
	*/
	protected int getHeight() {
		return this.height;
	}
	
	/** 
	* Accessor method for <code>weight</code>.
	* 
	* @param weight this character's weight
	* @throws IllegalArgumentException when weight is outside racial limits
	* 
	* @since 1.0
	*/
	protected void setWeight(int weight) {
		if(!this.myRace.isValidWeight(weight)) {
			throw new IllegalArgumentException("Weight outside racial limits");						
		}
		this.weight = weight;
	}
	
	/** 
	* Accessor method for <code>weight</code>.
	* 
	* @return value of the <code>weight</code> property in pounds
	* 
	* @since 1.0
	*/
	protected int getWeigth() {
		return this.weight;
	}
	
	/** 
	* Accessor method for <code>armorClass</code>.
	* Sets armor class based on equipped armor items, and 
	* dexterity and constitution modifiers
	* 
	* @since 1.0
	*/
	private void setArmorClass() {
		int armorClass = 10;
		if(myClass.getUnarmoredDefense()) {
			armorClass += this.charStats[Stat.CON].getModifier();
		}
		armorClass += this.charStats[Stat.DEX].getModifier();
		//TODO implement armor class from equipment
		this.armorClass = armorClass;
	}
	
	/** 
	* Accessor method for <code>armorClass</code>.
	* 
	* @return value of the <code>armorClass</code>
	* 
	* @since 1.0
	*/
	protected int getArmorClass() {
		return this.armorClass;
	}
	
	/** 
	* Accessor method for <code>skillProficiencies</code>.
	* 
	* @param skillProficiencies array of all skills
	* 
	* @since 1.0
	*/
	private void setSkillProficiencies(Skill[] skillProficiencies) {
		this.skillProficiencies = skillProficiencies;
	}
	
	/** 
	* Accessor method for <code>skillProficiencies</code>.
	* 
	* @return copy of the <code>skillProficiencies</code>
	* 
	* @since 1.0
	*/
	public Skill[] getSkillProficiencies() {
		return Arrays.copyOf(this.skillProficiencies, 
												this.skillProficiencies.length);
	}
	
	/** 
	* Accessor method for <code>combinedProficiencies</code>.
	* 
	* @param proficiencyArray 2D proficiency array
	* 
	* @since 1.0
	*/
	private void setCombinedProficiencies(String[][] proficiencyArray) {

		this.combinedProficiencies = combineArrays(proficiencyArray);
		
	}
	
	/** 
	* Accessor method for <code>combinedProficiencies</code>.
	* 
	* @param proficiencyArray 1D proficiency array
	* 
	* @since 1.0
	*/
	private void setCombinedProficiencies(String[] proficiencyArray) {
		this.combinedProficiencies = proficiencyArray;
	}
	
	/** 
	* Accessor method for <code>combinedProficiencies</code>.
	* 
	* @return copy of the <code>combinedProficiencies</code>
	* 
	* @since 1.0
	*/
	protected String[] getCombinedProficiencies() {
		return Arrays.copyOf(this.combinedProficiencies, 
									this.combinedProficiencies.length);
	}
	
	/** 
	* Accessor method for <code>combinedFeatures</code>.
	* 
	* @param featuresArray 2D feature array
	* 
	* @since 1.0
	*/
	private void setCombinedFeatures(String[][] featuresArray) {
		this.combinedFeatures = combineArrays(featuresArray);
	}
	
	/** 
	* Accessor method for <code>combinedFeatures</code>.
	* 
	* @return copy of the <code>combinedFeatures</code>
	* 
	* @since 1.0
	*/
	protected String[] getCombinedFeatures() {
		return Arrays.copyOf(this.combinedFeatures, 
											this.combinedFeatures.length);
	}
	
	/** 
	* Accessor method for <code>knownLanguages</code>.
	* 
	* @param knownLanguages array of languages this character knows
	* @throws IllegalArgumentException when knownLanguages is null
	* 
	* @since 1.0
	*/
	private void setKnownLanguages(String[] knownLanguages) {
		if(knownLanguages == null) {
			throw new IllegalArgumentException("Null Array");
		}
		this.knownLanguages = knownLanguages;
		getUnknownLanguages();
	}
	
	/** 
	* Accessor method for <code>knownLanguages</code>.
	* 
	* @return copy of the <code>knownLanguages</code>
	* 
	* @since 1.0
	*/
	protected String[] getKnownLanguages() {
		return Arrays.copyOf(this.knownLanguages, this.knownLanguages.length);
	}
	
	
	
	//These sections provide access to certain properties from the character's 
	//class and race.  These were implemented to simplify the the character 
	//model from the point of view of the controller.  It allows you to access 
	//all necessary information for a character without having to remember 
	//whether that data is stored in the class or race.
	//
	// Accessors for Race Properties
	//
	
	
	/** 
	* Gets this character's movement speed
	* 
	* @return this character's movement speed
	* 
	* @since 1.0
	*/	
	protected int getSpeed() {
		return this.myRace.getSpeed();
	}
	
	/** 
	* Provides modifiers to this character's ability scores
	* 
	* @return all modifiers to this character's ability scores
	* 
	* @since 1.0
	*/	
	protected int[] getStatModifiers() {
		return this.myRace.getStatModifiers();
	}
	
	//
	//Accessors for Class Properties
	//
	
	/** 
	* Provides this character's Hit Dice
	* 
	* @return a String representation of this character's hit dice
	* 
	* @since 1.0
	*/
	protected String getHitDice() {
		return this.myClass.getLevel() + "d" + this.myClass.getHitDie();
	}
	
	/** 
	* Provides this character's proficiency bonus
	* 
	* @return this character's proficiency bonus
	* 
	* @since 1.0
	*/
	protected int getProficiencyBonus() {
		return this.myClass.getProficiencyBonus();
	}
	
	/** 
	* Provides this character's level
	* 
	* @return this character's level
	* 
	* @since 1.0
	*/
	protected int getLevel() {
		return this.myClass.getLevel();
	}
	
	//
	//Utility Methods
	//
	
	/** 
	* Merges the contents of a 2D String array into a single String array
	* 
	* @param proficiencyArray a two-dimensional String array
	* @return a one-dimensional array of strings containing all of the strings 
	* 		  from proficiencyArray.
	* @throws IllegalArgumentException when any array within proficiency array 
	* 								   is null.
	* 
	* @since 1.0
	*/
	private String[] combineArrays(String[][] proficiencyArray) {
		int elements = 0;
		
		for(String[] array : proficiencyArray) {
			if(array == null) {
				throw new IllegalArgumentException("Null Array");
			}
			elements += array.length;
		}
		
		String[] finalArray = new String[elements];
		
		int index = 0;
		for(String[] array : proficiencyArray) {
			for(String element : array) {
				finalArray[index++] = element;
			}			
		}
		
		return finalArray;
	}
	
	/** 
	* Creates an array of unknown languages for this character based on the 
	* languages the character knows.
	* 
	* @return a String array representing the languages this character does not 
	* 		  know.
	* 
	* @since 1.0
	*/
	protected String[] getUnknownLanguages() {
		String[] unknownLanguages = new String[Charac.LANGUAGES.length - 
													this.knownLanguages.length];
		
		int index = 0;
		for(int i = 0; i < Charac.LANGUAGES.length; i++) {
			String current = Charac.LANGUAGES[i];
			if(!contains(this.getKnownLanguages(), current)) {
				unknownLanguages[index++] = current;
			}			
		}
		
		return unknownLanguages;
	}
	
	/** 
	* Evaluates whether the specified String contains an element equal to the 
	* provided String.
	* 
	* @param sArray the String array to be searched
	* @param str the String to look for inside of sArray
	* @return true if the str is found inside of sArray, otherwise false.
	* 
	* @since 1.0
	*/
	private static boolean contains(String[] sArray, String str) {
		for(int i = 0; i < sArray.length; i++) {
			if(str.equals(sArray[i])){
				return true;
			}
		}
		
		return false;
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
	
	/** 
	* Evaluates whether the specified String contains only letters and 
	* whitespace
	* 
	* @param str the String to be tested
	* @return true if the str contains only letters and whitespace, otherwise 
	*         false.
	* 
	* @since 1.0
	*/
	protected static boolean isOnlyLetters(String str) {
		char[] sArray = str.toCharArray();
		for(char c : sArray) {
			if(!Character.isLetter(c) && !Character.isWhitespace(c)) {
				return false;
			}
		}
		
		return true;
	}
	
	//
	//Data Formatting
	//
	/** 
	* Provides an array of Ability Score modifiers
	* 
	* @return an array containing the modifiers for each Ability Score
	* 
	* @since 1.0
	*/
	protected int[] getMods() {
		int[] statMods = new int[6];
		for(int i = 0; i < 6; i++) {
			statMods[i] = this.charStats[i].getModifier();
		}
		
		return statMods;
	}
	
	/** 
	* Provides an array of Saving Throw modifiers
	* 
	* @return an array containing the modifiers for each Saving Throw
	* 
	* @since 1.0
	*/
	protected int[] getSaves() {
		int[] statSaves = new int[6];
		for(int i = 0; i < 6; i++) {
			statSaves[i] = this.charStats[i].getSavingThrow();
		}
		
		return statSaves;
	}
	
	/** 
	* Provides the number of extra languages available to this character
	* 
	* @return the number of extra languages available to this character
	* 
	* @since 1.0
	*/
	protected int getExtraLanguages() {
		return this.myRace.getExtraLanguages() + 
							this.background.getExtraLanguages();
	}
	
	/** 
	* Provides an array of skill check modifiers
	* 
	* @return an array containing the modifiers for all skill checks for this 
	*         character
	* 
	* @since 1.0
	*/
	protected int[] getSkillModifiers() {
		int[] skillModifiers = new int[skillProficiencies.length];
		int index = 0;
		for(Skill skill : skillProficiencies) {
			skillModifiers[index] = 
				skill.isProficient() ? 
					this.getProficiencyBonus() + 
						this.charStats[skill.getAbility()].getModifier() : 
					this.charStats[skill.getAbility()].getModifier();
			index++;
		}
		
		return skillModifiers;
	}
	
	/** 
	* Provides an array of this character's default equipment loadout.
	* 
	* @return an array containing all of this character's default equipment
	* 
	* @since 1.0
	*/
	protected String[] getEquipment() {
		
		return combineArrays(new String[][]{
									this.myClass.getEquipment(),
									this.background.getEquipment()});
		
	}
	
	/** 
	* Provides this character's passive perception
	* 
	* @return the number representing this character's passive perception
	* 
	* @since 1.0
	*/
	protected String getPassivePercept() {
		return this.charStats[Stat.WIS].getModifier() + 10 + "";
	}
	

	
	//
	//Mutators
	//
	/** 
	* Updates this character's skill proficiencies
	* 
	* @param newProficiencies An array of the names of the skills that will be 
	*        flagged proficient
	* @throws IllegalArgumentException when newProficiencies is null, or when a 
	*         String within newProficiences is null or an empty String.
	* 
	* @since 1.0
	*/	
	protected void updateProficiencies(String[] newProficiencies) {
		if(newProficiencies == null) {
			throw new IllegalArgumentException("Null Array Provided");
		}
		for(String skill : newProficiencies) {
			if(skill == null || skill.length() == 0) {
				throw new IllegalArgumentException("Invalid String");
			}
			this.skillProficiencies[Skill.getSkillIndex(skill)].setProficient();
		}
	}
		
	/** 
	* Updates this character's combined proficiencies
	* 
	* @param proficiencies An array of the names of the proficiencies that will 
	*                      be added for this character
	* 
	* @since 1.0
	*/	
	protected void updateCombinedProficiencies(String[] proficiencies) {
		
		this.setCombinedProficiencies(combineArrays(new String[][]{
										this.getCombinedProficiencies(), 
										proficiencies}));
	}
		
	/** 
	* Updates this character's languages
	* 
	* @param languages An array of the langauges that will 
	*                      be added for this character
	* 
	* @since 1.0
	*/
	protected void updateLanguages(String[] languages) {
		this.setKnownLanguages(combineArrays(new String[][]{
									this.getKnownLanguages(),
									languages}));
	}
	
	/** 
	* Updates this character's tool proficiencies
	* 
	* @param tools An array of the names of the tool proficiencies that will 
	*                      be added for this character
	* 
	* @since 1.0
	*/	
	protected void updateToolProficiencies(String[] tools) {
		this.updateCombinedProficiencies(tools);
	}
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

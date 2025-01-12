package com.github.grimbear42.charactercreator;

import java.util.*;
/**
 * Background Class
 * 
 * Defines a Background Object consisting of a name, any associated skills, 
 * tools, languages, equipment and/or features
 * 
 * @author Adam Barnard
 * @version 1.0 03/08/2024 
 */
public class CharRace {
	/** 
	 * The name of the race
	 */
	private String raceName;
	/** 
	 * The minimum age for the race
	 */
	private int minAge;
	/** 
	 * The maximum age for the race
	 */
	private int maxAge;
	/** 
	 * The minimum height for the race
	 */
	private int minHeight;
	/** 
	 * The maximum height for the race
	 */
	private int maxHeight;
	/** 
	 * The minimum weight for the race
	 */
	private int minWeight;
	/** 
	 * The maxumum weight for the race
	 */
	private int maxWeight;
	/** 
	 * The movement speed for the race
	 */
	private int speed;
	/** 
	 * Languages known by the race
	 */
	private String[] languages;
	/** 
	 * Number of extra languages the user may select
	 */
	private int extraLanguages;
	/** 
	 * An array representing modifiers that will be applied to ability scores
	 */
	private int[] statModifiers;
	/** 
	 * An array of features provided by the race
	 */
	private String[] features;
	/** 
	 * An array of weapon proficiencies provided by the race
	 */
	private String[] weaponProficiencies;
	/** 
	 * An array of tool proficiencies provided by the race
	 */
	private String[] toolProficiencies;
	/** 
	 * An array of armor proficiencies provided by the race
	 */
	private String[] armorProficiencies;
	/** 
	 * The number of tool proficiencies that may be chosen
	 */
	private int numOfTools;
	/** 
	 * An array of skill proficiencies provided by the race
	 */
	private Skills[] skillProficiencies;
	/** 
	 * The number of skill proficiencies that may be chosen
	 */
	private int numOfSkills;
	
	
	/** 
	* Constructor for <code>CharRace</code> class
	* 
	* @param charRace A CharRace object
	*
	* @since 1.0
	*/
	protected CharRace(CharRace charRace) {
		this(charRace.getRaceName(), charRace.getMinAge(), charRace.getMaxAge(),
				charRace.getMinHeight(), charRace.getMaxHeight(), 
				charRace.getMinWeight(), charRace.getMaxWeight(), 
				charRace.getSpeed(), charRace.getLanguages(), 
				charRace.getExtraLanguages(), charRace.getStatModifiers(), 
				charRace.getWeaponProficiencies(), charRace.getToolProficiencies(), 
				charRace.getNumOfTools(), charRace.getFeatures(), 
				charRace.getArmorProficiencies(), charRace.getSkillProficiencies(), 
				charRace.getNumOfSkills());
	}
		
	/** 
	* Constructor for <code>Background</code> class
	* 
	* @param raceName The name of the race
	* @param minAge The minimum age for the race
	* @param maxAge The maximum age for the race
	* @param minHeight The minimum height for the race
	* @param maxHeight The maximum height for the race
	* @param minWeight The minimum weight for the race
	* @param maxWeight The maxumum weight for the race
	* @param speed The movement speed for the race
	* @param languages Languages known by the race
	* @param extraLanguages Number of extra languages the user may select
	* @param statModifiers An array representing modifiers that will be applied to ability scores
	* @param weaponProficiencies An array of weapon proficiencies provided by the race
	* @param toolProficiencies An array of tool proficiencies provided by the race
	* @param numOfTools The number of tool proficiencies that may be chosen
	* @param features An array of features provided by the race
	* @param armorProficiencies An array of armor proficiencies provided by the race
	* @param skillProficiencies An array of skill proficiencies provided by the race
	* @param numOfSkills The number of skill proficiencies that may be chosen
	* 
	* @throws IllegalArgumentException when any parameter is null or negative.
	*
	* @since 1.0
	*/
	protected CharRace(String raceName, int minAge, int maxAge, int minHeight, 
					int maxHeight, int minWeight, int maxWeight, int speed, 
					String[] languages, int extraLanguages, int[] statModifiers,
					String[] weaponProficiencies, String[] toolProficiencies,
					int numOfTools, String[] features, 
					String[] armorProficiencies, Skills[] skillProficiencies, 
					int numOfSkills) {
		if(raceName == null || minAge < 0 || maxAge < minAge || minHeight < 0 ||
				maxHeight < minHeight || minWeight < 0 || maxWeight < minWeight 
				|| speed < 0 || languages == null || extraLanguages < 0 || 
				statModifiers == null || weaponProficiencies == null || 
				toolProficiencies == null || numOfTools < 0 || features == null || 
				armorProficiencies == null || skillProficiencies == null || 
				numOfSkills < 0) {
			throw new IllegalArgumentException();
		}
		setRaceName(raceName);
		setMinAge(minAge);
		setMaxAge(maxAge);
		setMinHeight(minHeight);
		setMaxHeight(maxHeight);
		setMinWeight(minWeight);
		setMaxWeight(maxWeight);
		setSpeed(speed);
		setLanguages(languages);
		setExtraLanguages(extraLanguages);
		setStatModifiers(statModifiers);
		setFeatures(features);
		setWeaponProficiencies(weaponProficiencies);
		setToolProficiencies(toolProficiencies);
		setNumOfTools(numOfTools);
		setArmorProficiencies(armorProficiencies);
		setSkillProficiencies(skillProficiencies);
		setNumOfSkills(numOfSkills);
	}
	
	/** 
	* Accessor method for <code>raceName</code>.
	* 
	* @param raceName the name of the race
	* 
	* @since 1.0
	*/
	private void setRaceName(String raceName) {
		this.raceName = raceName;
	}
	
	/** 
	* Accessor method for <code>raceName</code>.
	* 
	* @return copy of the <code>raceName</code> property.
	* 
	* @since 1.0
	*/
	protected String getRaceName() {
		return String.valueOf(this.raceName);
	}
	
	/** 
	* Accessor method for <code>minAge</code>.
	* 
	* @param minAge minimum age of the race
	* 
	* @since 1.0
	*/
	private void setMinAge(int minAge) {
		this.minAge = minAge;
	}
	
	/** 
	* Accessor method for <code>minAge</code>.
	* 
	* @return value of the <code>minAge</code> property.
	* 
	* @since 1.0
	*/
	public int getMinAge() {
		return this.minAge;
	}
	
	/** 
	* Accessor method for <code>maxAge</code>.
	* 
	* @param maxAge maximum age of the race
	* 
	* @since 1.0
	*/
	private void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}
	
	/** 
	* Accessor method for <code>maxAge</code>.
	* 
	* @return value of the <code>maxAge</code> property.
	* 
	* @since 1.0
	*/
	public int getMaxAge() {
		return this.maxAge;
	}
	
	/** 
	* Validation method for an age
	* 
	* @param age the intended age of the character
	* @return whether age is within the age limit of this race.
	* 
	* @since 1.0
	*/
	protected boolean isValidAge(int age) {
		//int ageNumber = Integer.parseInt(age.toString());
		return age >= this.minAge && age <= this.maxAge;
	}
	
	/** 
	* Accessor method for <code>minHeight</code>.
	* 
	* @param minHeight minimum height of the race
	* 
	* @since 1.0
	*/
	private void setMinHeight(int minHeight) {
		this.minHeight = minHeight;
		
	}
	
	/** 
	* Accessor method for <code>minHeight</code>.
	* 
	* @return value of the <code>minHeight</code> property.
	* 
	* @since 1.0
	*/
	protected int getMinHeight() {
		return this.minHeight;
	}
	
	/** 
	* Accessor method for <code>maxHeight</code>.
	* 
	* @param maxHeight maximum height of the race
	* 
	* @since 1.0
	*/
	private void setMaxHeight(int maxHeight) {
		this.maxHeight = maxHeight;
	}
	
	/** 
	* Accessor method for <code>maxHeight</code>.
	* 
	* @return value of the <code>maxHeight</code> property.
	* 
	* @since 1.0
	*/
	protected int getMaxHeight() {
		return this.maxHeight;
	}
	
	/** 
	* Validation method for a height in feet and inches
	* 
	* @param feet the intended height (in feet) of the character
	* @param inches the intended height (in inches) of the character
	* @return whether height is within the height limit of this race.
	* 
	* @since 1.0
	*/
	protected boolean isValidHeight(int feet, int inches) {
		int totalHeight = feet * 12 + inches;
		return totalHeight >= this.minHeight && totalHeight <= this.maxHeight;
	}
	
	/** 
	* Accessor method for <code>minWeight</code>.
	* 
	* @param minWeight minimum weight of the race
	* 
	* @since 1.0
	*/
	private void setMinWeight(int minWeight) {
		this.minWeight = minWeight;
	}
	
	/** 
	* Accessor method for <code>minWeight</code>.
	* 
	* @return value of the <code>minWeight</code> property.
	* 
	* @since 1.0
	*/
	protected int getMinWeight() {
		return this.minWeight;
	}
	
	/** 
	* Accessor method for <code>maxWeight</code>.
	* 
	* @param maxWeight maximum weight of the race
	* 
	* @since 1.0
	*/
	private void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}
	
	/** 
	* Accessor method for <code>maxWeight</code>.
	* 
	* @return value of the <code>maxWeight</code> property.
	* 
	* @since 1.0
	*/
	protected int getMaxWeight() {
		return this.maxWeight;
	}
	
	/** 
	* Validation method for a weight
	* 
	* @param weight the intended weight of the character
	* @return whether weight is within the weight limit of this race.
	* 
	* @since 1.0
	*/
	protected boolean isValidWeight(int weight) {
		return weight >= this.minWeight && weight <= this.maxWeight;
	}
	
	/** 
	* Accessor method for <code>speed</code>.
	* 
	* @param speed movement speed for this race
	* 
	* @since 1.0
	*/
	private void setSpeed(int speed) {
		this.speed = speed;
	}
	
	/** 
	* Accessor method for <code>speed</code>.
	* 
	* @return value of the <code>speed</code> property.
	* 
	* @since 1.0
	*/
	protected int getSpeed() {
		return this.speed;
	}
	
	/** 
	* Accessor method for <code>languages</code>.
	* 
	* @param languages languages known by this race
	* 
	* @since 1.0
	*/
	private void setLanguages(String[] languages) {
		this.languages = languages;
	}
	
	/** 
	* Accessor method for <code>languages</code>.
	* 
	* @return copy of the <code>languages</code> property.
	* 
	* @since 1.0
	*/
	protected String[] getLanguages() {
		return Arrays.copyOf(this.languages, this.languages.length);
	}
	
	/** 
	* Accessor method for <code>extraLanguages</code>.
	* 
	* @param num number of additional languages known by this race
	* 
	* @since 1.0
	*/
	private void setExtraLanguages(int num) {
		this.extraLanguages = num;
	}
	
	/** 
	* Accessor method for <code>extraLanguages</code>.
	* 
	* @return value of the <code>extraLanguages</code> property.
	* 
	* @since 1.0
	*/
	protected int getExtraLanguages() {
		return this.extraLanguages;
	}
	
	/** 
	* Accessor method for <code>statModifiers</code>.
	* 
	* @param statModifiers array of modifications to be made to ability scores 
	* 					   for this race
	* 
	* @since 1.0
	*/
	private void setStatModifiers(int[] statModifiers) {
		this.statModifiers = statModifiers;
	}
	
	/** 
	* Accessor method for <code>statModifiers</code>.
	* 
	* @return copy of the <code>statModifiers</code> property.
	* 
	* @since 1.0
	*/
	protected int[] getStatModifiers() {
		return Arrays.copyOf(this.statModifiers, this.statModifiers.length);
	}
	
	/** 
	* Accessor method for <code>features</code>.
	* 
	* @param features an array of this race's features
	* 
	* @since 1.0
	*/
	private void setFeatures(String[] features) {
		this.features = features;
	}
	
	/** 
	* Accessor method for <code>features</code>.
	* 
	* @return copy of the <code>features</code> property.
	* 
	* @since 1.0
	*/
	protected String[] getFeatures() {
		return Arrays.copyOf(this.features, this.features.length);
	}
	
	/** 
	* Accessor method for <code>weaponProficiencies</code>.
	* 
	* @param weaponProficiencies an array of this race's weapon proficiencies
	* 
	* @since 1.0
	*/
	private void setWeaponProficiencies(String[] weaponProficiencies) {
		this.weaponProficiencies = weaponProficiencies;
	}
	
	/** 
	* Accessor method for <code>weaponProficiencies</code>.
	* 
	* @return copy of the <code>weaponProficiencies</code> property.
	* 
	* @since 1.0
	*/
	protected String[] getWeaponProficiencies() {
		return Arrays.copyOf(this.weaponProficiencies, 
											this.weaponProficiencies.length);
	}
	
	/** 
	* Accessor method for <code>toolProficiencies</code>.
	* 
	* @param toolProficiencies an array of this race's available tool 
	*                          proficiencies
	* 
	* @since 1.0
	*/
	private void setToolProficiencies(String[] toolProficiencies) {
		this.toolProficiencies = toolProficiencies;
	}
	
	/** 
	* Accessor method for <code>toolProficiencies</code>.
	* 
	* @return copy of the <code>toolProficiencies</code> property.
	* 
	* @since 1.0
	*/
	protected String[] getToolProficiencies() {
		return Arrays.copyOf(this.toolProficiencies, 
											this.toolProficiencies.length);
	}
	
	/** 
	* Accessor method for <code>numOfTools</code>.
	* 
	* @param num number of tool proficiencies that may be chosen
	* 
	* @since 1.0
	*/
	private void setNumOfTools(int num) {
		this.numOfTools = num;
	}
	
	/** 
	* Accessor method for <code>numOfTools</code>.
	* 
	* @return value of the <code>numOfTools</code> property.
	* 
	* @since 1.0
	*/
	protected int getNumOfTools() {
		return this.numOfTools;
	}
	
	/** 
	* Accessor method for <code>armorProficiencies</code>.
	* 
	* @param armorProficiencies an array of this race's armor proficiencies
	* 
	* @since 1.0
	*/
	private void setArmorProficiencies(String[] armorProficiencies) {
		
		this.armorProficiencies = armorProficiencies;
	}
	
	/** 
	* Accessor method for <code>armorProficiencies</code>.
	* 
	* @return copy of the <code>armorProficiencies</code> property.
	* 
	* @since 1.0
	*/
	protected String[] getArmorProficiencies() {
		return Arrays.copyOf(this.armorProficiencies, 
										this.armorProficiencies.length);
	}
	
	/** 
	* Accessor method for <code>skillProficiencies</code>.
	* 
	* @param skillProficiencies an array of this race's skill proficiencies
	* 
	* @since 1.0
	*/
	private void setSkillProficiencies(Skills[] skillProficiencies) {
		
		this.skillProficiencies = skillProficiencies;
	}
	
	/** 
	* Accessor method for <code>skillProficiencies</code>.
	* 
	* @return copy of the <code>skillProficiencies</code> property.
	* 
	* @since 1.0
	*/
	protected Skills[] getSkillProficiencies() {
		return Arrays.copyOf(this.skillProficiencies, 
										this.skillProficiencies.length);
	}
	
	/** 
	* Accessor method for <code>numOfSkills</code>.
	* 
	* @param numOfSkills number of skill proficiencies that may be chosen
	* 
	* @since 1.0
	*/
	private void setNumOfSkills(int numOfSkills) {
		
		this.numOfSkills = numOfSkills;
	}
	
	/** 
	* Accessor method for <code>numOfSkills</code>.
	* 
	* @return value of the <code>numOfSkills</code> property.
	* 
	* @since 1.0
	*/
	protected int getNumOfSkills() {
		return this.numOfSkills;
	}
	
	/** 
	* Returns a copy of this <code>CharRace</code>
	* 
	* @return copy of this <code>CharRace</code>.
	* 
	* @since 1.0
	*/	
	protected CharRace copyOf() {
		return new CharRace(this);
	}
}

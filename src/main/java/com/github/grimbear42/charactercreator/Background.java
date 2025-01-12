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
public class Background {
	/** 
	 * The name of the background
	 */
	private String backgroundName;
	/** 
	 * Skill proficiencies offered from the background
	 */
	private Skills[] skillProficiencies;
	/** 
	 * Number of skills the user may choose
	 */
	private int numOfSkills;
	/** 
	 * Tool proficiencies offered from the background
	 */
	private String[] toolProficiencies;
	/** 
	 * Number of tool proficiencies the user may choose
	 */
	private int numOfTools;
	/** 
	 * Number of additional languages the user may choose
	 */
	private int languages;
	/** 
	 * Equipment gained from the background
	 */
	private String[] equipment;
	/** 
	 * Feature gained from the background
	 */
	private String feature;
	
	/** 
	* Constructor for <code>Background</code> class
	* 
	* @param background a Background object
	* 
	* @since 1.0
	*/
	protected Background(Background background) {
		this(background.getBackgroundName(), 
				background.getSkillProficiencies(), 
				background.getNumOfSkills(), 
				background.getToolProficiencies(), 
				background.getNumOfTools(), 
				background.getExtraLanguages(), 
				background.getEquipment(), 
				background.getFeature()
		);
	}
	
	/** 
	* Constructor for <code>Background</code> class
	* 
	* @param backgroundName name of the background
	* @param skillProficiencies skills available to the user
	* @param numOfSkills number of skills that can be chosen
	* @param toolProficiencies tool proficiencies available to the user
	* @param numOfTools number of tool proficiencies that can be chosen
	* @param languages number of additional languages available to the user
	* @param equipment equipment provided to the user
	* @param feature features provided to the user
	* @throws IllegalArgumentException when any parameter is null or negative.
	*
	* @since 1.0
	*/
	protected Background(String backgroundName, Skills[] skillProficiencies, 
						int numOfSkills, String[] toolProficiencies, 
						int numOfTools, int languages, String[] equipment, 
						String feature) {
		if(backgroundName == null || skillProficiencies == null || 
				numOfSkills < 0 || toolProficiencies == null || 
				numOfTools < 0 || languages < 0 || feature == null) {
			throw new IllegalArgumentException();
		}
		setBackgroundName(backgroundName);
		setSkillProficiencies(skillProficiencies);
		setNumOfSkills(numOfSkills);
		setToolProficiencies(toolProficiencies);
		setNumOfTools(numOfTools);
		setLanguages(languages);
		setEquipment(equipment);
		setFeature(feature);
	}
	
	/** 
	* Accessor method for <code>skillProficiencies</code>.
	* 
	* @param skillProficiencies an array of <code>Skills</code> 
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
	* @param numOfSkills number of skills that may be chosen
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
	* Accessor method for <code>toolProficiencies</code>.
	* 
	* @param toolProficiencies an array of available tool proficiencies
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
	* Accessor method for <code>languages</code>.
	* 
	* @param languages number of languages that may be chosen
	* 
	* @since 1.0
	*/
	private void setLanguages(int languages) {
		this.languages = languages;
	}
	
	/** 
	* Accessor method for <code>languages</code>.
	* 
	* @return value of the <code>languages</code> property.
	* 
	* @since 1.0
	*/
	protected int getExtraLanguages() {
		return this.languages;
	}
	
	/** 
	* Accessor method for <code>equipment</code>.
	* 
	* @param equipment an array of equipment items
	* 
	* @since 1.0
	*/
	private void setEquipment(String[] equipment) {
		this.equipment = equipment;
	}
	
	/** 
	* Accessor method for <code>equipment</code>.
	* 
	* @return copy of the <code>equipment</code> property.
	* 
	* @since 1.0
	*/
	protected String[] getEquipment() {
		return Arrays.copyOf(this.equipment, this.equipment.length);
	}
	
	/** 
	* Accessor method for <code>feature</code>.
	* 
	* @param feature the feature provided by this background
	* 
	* @since 1.0
	*/
	private void setFeature(String feature) {
		this.feature = feature;
	}
	
	/** 
	* Accessor method for <code>feature</code>.
	* 
	* @return copy of the <code>feature</code> property.
	* 
	* @since 1.0
	*/
	protected String getFeature() {
		return String.valueOf(this.feature);
	}
	
	/** 
	* Accessor method for <code>backgroundName</code>.
	* 
	* @param name String representing the name of this background
	* 
	* @since 1.0
	*/
	private void setBackgroundName(String name) {
		this.backgroundName = name;
	}
	
	/** 
	* Accessor method for <code>backgroundName</code>.
	* 
	* @return copy of the <code>backgroundName</code> property.
	* 
	* @since 1.0
	*/
	protected String getBackgroundName() {
		return String.valueOf(this.backgroundName);
	}
	
	/** 
	* Returns a copy of this <code>Background</code>
	* 
	* @return copy of this <code>Background</code>.
	* 
	* @since 1.0
	*/
	protected Background copyOf() {
		return new Background(this);
	}
}

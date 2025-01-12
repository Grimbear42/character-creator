package com.github.grimbear42.charactercreator;

/**
 * Skill Class
 * 
 * Defines a Skill Object consisting of an item from the Skills enumeration, a 
 * proiciency flag, and the ability score that is associated with the individual 
 * skill.
 * 
 * @author Adam Barnard
 * @version 1.0 03/08/2024 
 */
public class Skill { 
	/** 
	 * An item from the <code>Skills/<code> enumeration class
	 */
	private Skills skill;
	/** 
	 * A respresentation of proficiency in a skill
	 */
	private boolean proficient;
	/** 
	 * The ability that provides a modifier to the skill
	 */
	private int ability;
	/** 
	 * A constant representing each ability used by each skill based on index 
	 * and ordinal.
	 */	
	private static final int[] ABILITYMAP = new int[]{
											Stat.DEX,
											Stat.WIS,
											Stat.INT,
											Stat.STR,
											Stat.CHA,
											Stat.INT,
											Stat.WIS,
											Stat.CHA,
											Stat.INT,
											Stat.WIS,
											Stat.INT,
											Stat.WIS,
											Stat.CHA,
											Stat.CHA,
											Stat.INT,
											Stat.DEX,
											Stat.DEX,
											Stat.WIS
											};
											
	/** 
	 * A constant representing the english name for each skill
	 */										
	public static final String[] SKILL_NAMES = new String[]{
		"Acrobatics",
		"Animal Handling",
		"Arcana",
		"Athletics",
		"Deception",
		"History",
		"Insight",
		"Intimidation",
		"Investigation",
		"Medicine",
		"Nature",
		"Perception",
		"Performance",
		"Persuasion",
		"Religion",
		"Sleight of hand",
		"Stealth",
		"Survival"
	};
	
	
	/**
	* Provides the index or ordinal for a skill of a given name 
	* 
	* @param skillName the name of the desired skill
	* @return the index or ordinal for the skill of that name
	* @throws IllegalArgumentException when <code>skillName</code> does not match an existing 
	* 								   skill.
	*
	* @since 1.0
	*/
	protected static int getSkillIndex(String skillName) {
		for(int i = 0; i < Skill.SKILL_NAMES.length; i++) {
			if(skillName.equals(Skill.SKILL_NAMES[i])) {
				return i;
			}
		}
		
		throw new IllegalArgumentException();
	}
	
	/** 
	* Constructor for <code>Skill</code> class
	* 
	* @param skill an item from the <code>Skills</code> enumeration class.
	* @throws IllegalArgumentException when <code>skill</code> does not match an existing 
	* 								   skill.
	*
	* @since 1.0
	*/
	protected Skill(Skills skill) {
		if(skill == null) {
			throw new IllegalArgumentException("Null Value");
		}
		setSkill(skill);
		setAbility();
		this.proficient = false;
	}
	
	/** 
	* Accessor method for <code>skill</code>.
	* 
	* @param skill an item from the <code>Skills</code> enumeration class.
	* 
	* @since 1.0
	*/
	private void setSkill(Skills skill) {
		this.skill = skill;
		
	}
	
	/** 
	* Accessor method for <code>skill</code>.
	* 
	* @return <code>skill</code> property.
	* 
	* @since 1.0
	*/
	protected Skills getSkill() {
		return this.skill;
	}
	
	/** 
	* Accessor method for <code>proficient</code>.
	* Sets value of <code>proficient</code> to <code>true</code>.
	* 
	* @since 1.0
	*/
	protected void setProficient() {
		this.proficient = true;
	}
	
	/** 
	* Accessor method for <code>proficient</code>.
	* 
	* @return value of <code>proficient</code> property.
	* 
	* @since 1.0
	*/
	protected boolean isProficient() {
		return proficient;
	}
	
	/** 
	* Accessor method for <code>ability</code>.
	* Sets the value of <code>ability</code> based on the value of 
	* <code>skill</code>.
	* 
	* 
	* @since 1.0
	*/
	private void setAbility() {
		this.ability = Skill.ABILITYMAP[this.getSkill().ordinal()];
	}
	
	/** 
	* Accessor method for <code>ability</code>.
	* 
	* @return value of <code>ability</code> property.
	* 
	* @since 1.0
	*/
	protected int getAbility() {
		return this.ability;
	}
	
}

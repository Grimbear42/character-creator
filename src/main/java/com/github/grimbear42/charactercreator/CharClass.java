package com.github.grimbear42.charactercreator;

import java.util.*;
/**
 * CharClass Class
 * 
 * Defines a CharClass Object consisting of a name, hit dice, proficiency bonus,
 * armor, weapon and skill proficiences, class features, and saving throw 
 * proficiencies.
 * 
 * @author Adam Barnard
 * @version 1.0 03/08/2024 
 */
public class CharClass {
	/** 
	 * The name of the class
	 */
	private String className;
	/** 
	 * The character's level in this class (currently limited to level 1)
	 */
	private int level;
	/** 
	 * The hit dice for this class
	 */
	private int hitDie;
	/** 
	 * The character's proficiency bonus (currently limited to level 1)
	 */
	private int proficiencyBonus;
	/** 
	 * An array of armor proficiencies provided by the class
	 */
	private String[] armorProficiencies;
	/** 
	 * An array of weapon proficiencies provided by the class
	 */
	private String[] weaponProficiencies;
	/** 
	 * An array of features provided by the class
	 */
	private String[] classFeatures;
	/** 
	 * An array of available skill proficiencies provided by the class
	 */
	private Skills[] availableSkills;
	/** 
	 * The number of skill proficiencies that may be chosen
	 */
	private int numOfSkills;
	/** 
	 * The default equipment loadout for this class
	 */
	private String[] equipment;
	/** 
	 * An array representing the saving throws this class has profiency in
	 */
	private int[] savingThrows;
	/** 
	 * A flag to determine if this character has the Unarmored Defense feature
	 */
	private boolean unarmoredDefense = false;
		
	
	/** 
	* Constructor for <code>CharClass</code> class
	* 
	* @param charClass A CharClass object
	*
	* @since 1.0
	*/
	protected CharClass(CharClass charClass) {
		this(charClass.getClassName(), charClass.getLevel(), 
				charClass.getHitDie(), charClass.getProficiencyBonus(), 
				charClass.getArmorProficiencies(), 
				charClass.getWeaponProficiencies(), 
				charClass.getClassFeatures(), charClass.getAvailableSkills(), 
				charClass.getNumOfSkills(), charClass.getEquipment(),
				charClass.getSavingThrows(), charClass.getUnarmoredDefense());
		
		
	}
	
	/** 
	* Constructor for <code>CharClass</code> class
	* 
	* @param className The name of the class
	* @param level The character's level in this class (currently limited to level 1)
	* @param hitDie The hit dice for this class
	* @param proficiencyBonus The character's proficiency bonus (currently limited to level 1)
	* @param armorProficiencies An array of armor proficiencies provided by the class
	* @param weaponProficiencies An array of weapon proficiencies provided by the class
	* @param classFeatures An array of features provided by the class
	* @param availableSkills An array of available skill proficiencies provided by the class
	* @param numOfSkills The number of skill proficiencies that may be chosen
	* @param equipment The default equipment loadout for this class
	* @param savingThrows An array representing the saving throws this class has profiency in
	* @param unarmoredDefense A flag to determine if this character has the Unarmored Defense feature
	* 
	* @throws IllegalArgumentException when any parameter is null or negative.
	*
	* @since 1.0
	*/
	protected CharClass(String className, int level, int hitDie, 
						int proficiencyBonus, String[] armorProficiencies, 
						String[] weaponProficiencies, String[] classFeatures, 
						Skills[] availableSkills, int numOfSkills, 
						String[] equipment, int[] savingThrows, 
						boolean unarmoredDefense) {
							
		if(className == null || level < 1 || hitDie < 0 || proficiencyBonus < 0 
				|| armorProficiencies == null || weaponProficiencies == null || 
				classFeatures == null || availableSkills == null || 
				numOfSkills < 0 || equipment == null || savingThrows == null){
			throw new IllegalArgumentException();
		}
		setClassName(className);
		setLevel(level);
		setHitDie(hitDie);
		setProficiencyBonus(proficiencyBonus);
		setArmorProficiencies(armorProficiencies);
		setWeaponProficiencies(weaponProficiencies);
		setClassFeatures(classFeatures);
		setAvailableSkills(availableSkills);
		setNumOfSkills(numOfSkills);
		setEquipment(equipment);
		setSavingThrows(savingThrows);
		if(unarmoredDefense) setUnarmoredDefense();
		
		
	}
	
	/** 
	* Accessor method for <code>className</code>.
	* 
	* @param className the name of the class
	* 
	* @since 1.0
	*/	
	private void setClassName(String className) {
		
		this.className = className;
	}
	
	/** 
	* Accessor method for <code>className</code>.
	* 
	* @return copy of the <code>className</code> property.
	* 
	* @since 1.0
	*/
	protected String getClassName() {
		return String.valueOf(this.className);
	}
	
	/** 
	* Accessor method for <code>level</code>.
	* This property is currently limited to 1.
	* 
	* @param level the character's current level in this class
	* 
	* @since 1.0
	*/
	private void setLevel(int level) {
		
		this.level = level;
	}
	
	/** 
	* Accessor method for <code>level</code>.
	* 
	* @return value of the <code>level</code> property.
	* 
	* @since 1.0
	*/
	protected int getLevel() {
		return this.level;
	}
	
	/** 
	* Accessor method for <code>hitDie</code>.
	* This number must correspond to a valid type of dice (4, 6, 8, or 12 sided)
	* 
	* @param hitDie the Hit Die for this class.
	* 
	* @since 1.0
	*/
	private void setHitDie(int hitDie) {
		if(hitDie != 4 && hitDie != 6 && hitDie != 8 && hitDie != 12) {
			throw new IllegalArgumentException("Invalid HitDie");
		}
		this.hitDie = hitDie;
	}
	
	/** 
	* Accessor method for <code>hitDie</code>.
	* 
	* @return value of the <code>hitDie</code> property.
	* 
	* @since 1.0
	*/
	protected int getHitDie() {
		return this.hitDie;
	}
	
	/** 
	* Accessor method for <code>proficiencyBonus</code>.
	* 
	* @param proficiencyBonus the character's proficiency bonus
	* 
	* @since 1.0
	*/
	private void setProficiencyBonus(int proficiencyBonus) {
		
		this.proficiencyBonus = proficiencyBonus;
	}
	
	/** 
	* Accessor method for <code>proficiencyBonus</code>.
	* 
	* @return value of the <code>proficiencyBonus</code> property.
	* 
	* @since 1.0
	*/
	protected int getProficiencyBonus() {
		return this.proficiencyBonus;
	}
	
	/** 
	* Accessor method for <code>armorProficiencies</code>.
	* 
	* @param armorProficiencies Armor proficiencies provided by the class
	* @throws IllegalArgumentException when armorProficiencies is an empty array
	* 
	* @since 1.0
	*/
	private void setArmorProficiencies(String[] armorProficiencies) {
		if(armorProficiencies.length == 0) {
			throw new IllegalArgumentException("Invalid Array");
		}
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
	* Accessor method for <code>weaponProficiencies</code>.
	* 
	* @param weaponProficiencies Weapon proficiencies provided by the class
	* @throws IllegalArgumentException when weaponProficiencies is an empty array
	* 
	* @since 1.0
	*/
	private void setWeaponProficiencies(String[] weaponProficiencies) {
		if(weaponProficiencies.length == 0) {
			throw new IllegalArgumentException("Invalid Array");
		}
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
	* Accessor method for <code>classFeatures</code>.
	* 
	* @param classFeatures Features provided by the class
	* @throws IllegalArgumentException when classFeatures is an empty array
	* 
	* @since 1.0
	*/
	private void setClassFeatures(String[] classFeatures) {
		if(classFeatures.length == 0) {
			throw new IllegalArgumentException("Invalid Array");
		}
		this.classFeatures = classFeatures;
	}
	
	/** 
	* Accessor method for <code>classFeatures</code>.
	* 
	* @return copy of the <code>classFeatures</code> property.
	* 
	* @since 1.0
	*/
	protected String[] getClassFeatures() {
		return Arrays.copyOf(this.classFeatures, this.classFeatures.length);
	}
	
	/** 
	* Accessor method for <code>availableSkills</code>.
	* 
	* @param availableSkills skills that may be chosen for this class
	* @throws IllegalArgumentException when availableSkills is an empty array
	* 
	* @since 1.0
	*/
	private void setAvailableSkills(Skills[] availableSkills) {
		if(availableSkills.length == 0) {
			throw new IllegalArgumentException("Invalid Array");
		}
		this.availableSkills = availableSkills;
	}
	
	/** 
	* Accessor method for <code>availableSkills</code>.
	* 
	* @return copy of the <code>availableSkills</code> property.
	* 
	* @since 1.0
	*/
	protected Skills[] getAvailableSkills() {
		return Arrays.copyOf(this.availableSkills, this.availableSkills.length);
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
	* Accessor method for <code>equipment</code>.
	* 
	* @param equipment Default equipment loadout for this class
	* @throws IllegalArgumentException when equipment is an empty array
	* 
	* @since 1.0
	*/
	private void setEquipment(String[] equipment) {
		if(equipment.length == 0) {
			throw new IllegalArgumentException("Invalid Array");
		}
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
	* Accessor method for <code>savingThrows</code>.
	* 
	* @param savingThrows Saving Throws this class has proficiency in
	* @throws IllegalArgumentException when savingThrows is an empty array
	* 
	* @since 1.0
	*/
	private void setSavingThrows(int[] savingThrows) {
		if(savingThrows.length == 0) {
			throw new IllegalArgumentException("Invalid Array");
		}
		this.savingThrows = savingThrows;
	}
	
	/** 
	* Accessor method for <code>savingThrows</code>.
	* 
	* @return copy of the <code>savingThrows</code> property.
	* 
	* @since 1.0
	*/
	protected int[] getSavingThrows() {
		return Arrays.copyOf(this.savingThrows, this.savingThrows.length);
	}
	
	/** 
	* Accessor method for <code>unarmoredDefense</code>.
	* Sets the unarmoredDefense flag to true
	* 
	* @since 1.0
	*/
	private void setUnarmoredDefense() {
		this.unarmoredDefense = true;
	}
	
	/** 
	* Accessor method for <code>unarmoredDefense</code>.
	* 
	* @return value of the <code>unarmoredDefense</code> property.
	* 
	* @since 1.0
	*/
	protected boolean getUnarmoredDefense() {
		return this.unarmoredDefense;
	}
	
	/** 
	* Returns a copy of this <code>CharClass</code>
	* 
	* @return copy of this <code>CharClass</code>.
	* 
	* @since 1.0
	*/
	protected CharClass copyOf() {
		return new CharClass(this);
	}
	
	
}

package com.github.grimbear42.charactercreator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
/**
 * Stat Class
 * 
 * Defines a Stat Object consisting of an ability score, its modifier value, its 
 * saving throw modifier and whether proficiency bonus is applied to saving 
 * throws.
 * 
 * @author Adam Barnard
 * @version 1.0 03/08/2024 
 */

public class Stat {
	/** 
	 * The ability score
	 */
	private int value = 0;
	/** 
	 * The modifier for this ability
	 */
	private int modifier = 0;
	/** 
	 *The modifier for Saving Throws with this ability
	 */
	private int savingThrow = 0;
	/** 
	 * Whether to apply a character's proficiency bonus to saving throws for 
	 * this ability.
	 */
	private boolean proficient = false;
	
	/** 
	 * A Random for simulating dice rolls.
	 */
	private static Random rand = new Random();	
	
	/** 
	 * A constant to convert an ability to its pre-defined index
	 */
	public static final int STR = 0;
	/** 
	 * A constant to convert an ability to its pre-defined index
	 */
	public static final int DEX = 1;
	/** 
	 * A constant to convert an ability to its pre-defined index
	 */
	public static final int CON = 2;
	/** 
	 * A constant to convert an ability to its pre-defined index
	 */
	public static final int INT = 3;
	/** 
	 * A constant to convert an ability to its pre-defined index
	 */
	public static final int WIS = 4;
	/** 
	 * A constant to convert an ability to its pre-defined index
	 */
	public static final int CHA = 5;
	/** 
	 * A constant to correlate each ability to a String representing its name, 
	 * based on the ability's index.
	 */
	public static final String[] STATNAMES = new String[] {
												"Strength", 
												"Dexterity", 
												"Constitution", 
												"Intelligence", 
												"Wisdom", 
												"Charisma"
												};
	/** 
	 * Pre-defined ability scores as defined by the Player's Handbook.
	 */
	public static final List<Integer> PREROLLSTATS = Arrays.asList(8, 10, 12, 13, 14, 15);
	
	
	/**
	* Generates an ability score by simulating rolling 4 six-sided dice and 
	* adding the three high rolls.
	* 
	* @return the result of the simulated dice roll
	*
	* @since 1.0
	*/
	private static int statRoller() {
		int[] nums = new int[]{-1,-1,-1,-1};
		nums[0] = rand.nextInt(6) + 1;
		for(int i = 1; i < nums.length; i++) {
			int currRoll = rand.nextInt(6) + 1;
			nums[i] = Math.min(currRoll, nums[i - 1]);
			if(nums[i] != currRoll) {
				nums[i - 1] = currRoll;
			}
		}
		
		return nums[0] + nums[1] + nums[2];		 
	}
	
	/**
	* Randomly generates a set of 6 ability scores using the method defined in 
	* the Player's Handbook. 
	* 
	* @return the result of the simulated dice roll
	*
	* @since 1.0
	*/
	protected static List<Integer> rollStats() {
		List<Integer> output = new ArrayList<>();
		for(int i = 0; i < STATNAMES.length; i++) {
			output.add(statRoller());
		}
		
		return output;
	}
	
	/** 
	* Constructor for <code>Stat</code> class
	* 
	* @param value the value to be assigned to the new ability.
	* @throws IllegalArgumentException when <code>value</code> is less than 3.
	*
	* @since 1.0
	*/
	protected Stat(int value) {
		if(value < 3) {
			throw new IllegalArgumentException("Invalid Ability Score");
		}
		setValue(value);
	}
	
	/** 
	* Accessor method for <code>value</code>.
	* Updates properties <code>modifier</code> and <code>savingThrow</code> as 
	* well.
	* 
	* @param value the value to which the ability score will be set
	* 
	* @since 1.0
	*/
	private void setValue(int value) {
		this.value = value;
		setModifier();
		setSavingThrow();
	}
	
	/** 
	* Accessor method for <code>value</code>.
	* 
	* @return value of the <code>value</code> property.
	* 
	* @since 1.0
	*/
	protected int getValue() {
		return this.value;
	}
	
	/** 
	* Accessor method for <code>modifier</code>.
	* Sets value of <code>modifier</code> based on the <code>value</code> 
	* property.
	* 
	* 
	* @since 1.0
	*/
	private void setModifier() {
		this.modifier = (this.value - 10) / 2;
	}
	
	/** 
	* Accessor method for <code>modifier</code>.
	* 
	* @return value of the <code>modifier</code> property.
	* 
	* @since 1.0
	*/
	public int getModifier() {
		return this.modifier;
	}
	
	
	/** 
	* Accessor method for <code>savingThrow</code>.
	* Sets value of <code>savingThrow</code> based on the <code>value</code> 
	* property.
	* 
	* 
	* @since 1.0
	*/
	private void setSavingThrow() {
		if(!isProficient()) {
			this.savingThrow = (this.value - 10) / 2;
		} else {
			//TODO update to support characters beyond 1st level
			this.savingThrow = (value - 10) / 2 + 2;
		}
	}
	
	/** 
	* Accessor method for <code>savingThrow</code>.
	* 
	* @return value of the <code>savingThrow</code> property.
	* 
	* @since 1.0
	*/
	protected int getSavingThrow() {
		return this.savingThrow;
	}
		
	/** 
	* Accessor method for <code>proficient</code>.
	* Sets value of <code>proficient</code> to <code>true</code>.
	* Updates property <code>savingThrow</code> 
	* 
	* 
	* @since 1.0
	*/
	public void setProficient() {
		this.proficient = true;
		setSavingThrow();
	}
	
	/** 
	* Accessor method for <code>proficient</code>.
	* 
	* @return value of the <code>proficient</code> property.
	* 
	* @since 1.0
	*/
	public boolean isProficient() {
		return this.proficient;
	}
	
}

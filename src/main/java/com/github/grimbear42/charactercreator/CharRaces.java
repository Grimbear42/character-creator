package com.github.grimbear42.charactercreator;

/**
 * CharRaces Class
 * 
 * Provides an interface to interact with all of the available CharRace objects.
 * 
 * @author Adam Barnard
 * @version 1.0 03/08/2024 
 */
public class CharRaces {
	/** 
	 * An array of all available CharRaces 
	 */
	private static CharRace[] charRaces;
	
	/**
	* Provides an array of all available Race Names
	* 
	* @return an array of Strings containg the name of each available Race
	*
	* @since 1.0
	*/
	protected static String[] getRaceNames() {
		 if(charRaces == null) {
			 populateCharRaces();
		 }
		 String[] charRaceNames = new String[charRaces.length];
		 int index = 0;
		 for(CharRace charRace : charRaces) {
			 charRaceNames[index++] = charRace.getRaceName();
		 }
		 
		 return charRaceNames;
	}
	
	/**
	* Provides the CharRace object associated with a specific Race name. 
	* 
	* @param raceName the name of the desired race
	* @return a CharRace object for the desired race
	* @throws IllegalArgumentException when raceName does not match an existing 
	* 								   race.
	*
	* @since 1.0
	*/
	protected static CharRace getRace(String raceName) {
		if(charRaces == null) {
			populateCharRaces();
		}
		for(CharRace charRace : charRaces) {
			if(raceName.equals(charRace.getRaceName())) {
				return charRace.copyOf();
			}
		}
		
		throw new IllegalArgumentException("No Race with name " + raceName);
	}
	
	/**
	* Creates an array of all available races
	* Additional races can be added by adding additional CharRace constructors
	*
	* @since 1.0
	*/
	private static void populateCharRaces() {
		charRaces = new CharRace[]{
						new CharRace("Hill Dwarf",
										50,
										300,
										44,
										56,
										115,
										211,
										25,
										new String[]{"Dwarvish", "Common"},
										0,
										new int[]{0,0,2,0,1,0},
										new String[]{
											"Battleaxe", 
											"Handaxe", 
											"Throwing Hammer", 
											"Warhammer"},
										new String[]{
											"Smith's Tools", 
											"Brewer's Supplies", 
											"Mason's Tools"},
										1,
										new String[]{"Darkvision 60ft", 
										"Advantage on Poison Saving Throws", 
										"Resistance against poison damage", 
										"Add double your proficiency bonus to any skill checks on History of stonework"},
										new String[]{},
										new Skills[]{},
										0
										
						),
						new CharRace("Mountain Dwarf",
										50,
										300,
										44,
										56,
										130,
										226,
										25,
										new String[]{"Dwarvish", "Common"},
										0,
										new int[]{2,0,2,0,0,0},
										new String[]{
											"Battleaxe",
											"Handaxe",
											"Throwing Hammer",
											"Warhammer"},
										new String[]{
											"Smith's Tools",
											"Brewer's Supplies",
											"Mason's Tools"},
										1,
										new String[]{
											"Darkvision 60ft", 
											"Advantage on Poison Saving Throws", 
											"Resistance against poison damage", 
											"Add double your proficiency bonus to any skill checks on History of stonework"},
										new String[]{
											"Light Armor",
											"Medium Armor"},
										new Skills[]{},
										0
						),
						new CharRace("High Elf",
										100,
										700,
										54,
										74,
										90,
										170,
										30,
										new String[]{"Elvish", "Common"},
										1,
										new int[]{0,2,0,1,0,0},
										new String[]{
											"Longsword",
											"Shortsword",
											"Shortbow",
											"Longbow"},
										new String[]{},
										0,
										new String[]{
											"Darkvision 60ft",
											"Advantage on saving throws against being charmed",
											"Cannot be put to sleep",
											"Trance",
											"Gain one cantrip from Wizard Spell List"},
										new String[]{},
										new Skills[]{Skills.PERCEPTION},
										1
						)
			};
	}
}

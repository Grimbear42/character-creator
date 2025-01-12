package com.github.grimbear42.charactercreator;

/**
 * CharClasses Class
 * 
 * Provides an interface to interact with all of the available CharClass objects.
 * 
 * @author Adam Barnard
 * @version 1.0 03/08/2024 
 */
public class CharClasses {
	/** 
	 * An array of all available CharClasses 
	 */
	private static CharClass[] charClasses;
	
	/**
	* Provides an array of all available Class Names
	* 
	* @return an array of Strings containg the name of each available Class
	*
	* @since 1.0
	*/
	protected static String[] getClassNames() {
		 if(charClasses == null) {
			 populateCharClasses();
		 }
		 String[] charClassNames = new String[charClasses.length];
		 int index = 0;
		 for(CharClass charClass : charClasses) {
			 charClassNames[index++] = charClass.getClassName();
		 }
		 
		 return charClassNames;
	}
	
	/**
	* Provides the CharClass object associated with a specific Race name. 
	* 
	* @param className the name of the desired character class
	* @return a CharClass object for the desired character class
	* @throws IllegalArgumentException when className does not match an existing 
	* 								   race.
	*
	* @since 1.0
	*/
	protected static CharClass getClass(String className) {
		if(charClasses == null) {
			populateCharClasses();
		}
		for(CharClass charClass : charClasses) {
			if(className.equalsIgnoreCase(charClass.getClassName())) {
				return charClass.copyOf();
			}
		}
		
		throw new IllegalArgumentException("No Class with name " + className);
	}
	
	/**
	* Creates an array of all available character classes
	* Additional classes can be added by adding additional CharClass
	* constructors
	*
	* @since 1.0
	*/
	private static void populateCharClasses() {
		charClasses = new CharClass[]{
						new CharClass("Barbarian", 
										1, 
										12, 
										2, 
										new String[]{
											"Light Armor", 
											"Medium Armor", 
											"Shields"
										}, 
										new String[]{
											"Simple Weapons", 
											"Martial Weapons"
										}, 
										new String[]{
											"Rage", 
											"Unarmored Defense"
										}, 
										new Skills[]{
											Skills.ANIMAL_HANDLING, 
											Skills.ATHLETICS, 
											Skills.INTIMIDATION, 
											Skills.NATURE, 
											Skills.PERCEPTION, 
											Skills.SURVIVAL
										},
										2,
										new String[]{
											"Greataxe",  
											"Handaxe X2", 
											"Javelin X4", 
											"Explorer's Pack"
										},
										new int[]{Stat.STR, Stat.CON},
										true
									)
					  };
	}
	
}

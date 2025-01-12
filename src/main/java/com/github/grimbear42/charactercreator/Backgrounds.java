package com.github.grimbear42.charactercreator;

/**
 * Backgrounds Class
 * 
 * Provides an interface to interact with all of the available Background 
 * objects.
 * 
 * @author Adam Barnard
 * @version 1.0 03/08/2024 
 */
public class Backgrounds {
	/** 
	 * An array of all available Backgrounds 
	 */
	private static Background[] backgrounds;
	
	/**
	* Provides an array of all available Background Names
	* 
	* @return an array of Strings containg the name of each available Background
	*
	* @since 1.0
	*/
	protected static String[] getBackgroundNames() {
		 if(backgrounds == null) {
			 populateBackgrounds();
		 }
		 String[] backgroundNames = new String[backgrounds.length];
		 int index = 0;
		 for(Background background : backgrounds) {
			 backgroundNames[index++] = background.getBackgroundName();
		 }
		 
		 return backgroundNames;
	}
	
	/**
	* Provides the Background object associated with a specific Background name. 
	* 
	* @param backgroundName the name of the desired character background
	* @return a Background object for the desired character background
	* @throws IllegalArgumentException when backgroundName does not match an 
	* 								   existing race.
	*
	* @since 1.0
	*/
	protected static Background getBackground(String backgroundName) {
		if(backgrounds == null) {
			populateBackgrounds();
		}
		for(Background background : backgrounds) {
			if(background.getBackgroundName().equals(backgroundName)) {
				return background.copyOf();
			}
		}
		
		return null;
	}
	
	/**
	* Creates an array of all available character backgrounds
	* Additional backgrounds can be added by adding additional Background
	* constructors
	*
	* @since 1.0
	*/
	private static void populateBackgrounds() {
		backgrounds = new Background[]{new Background(
												"Acolyte",
												new Skills[]{Skills.INSIGHT, Skills.RELIGION},
												2,
												new String[]{},
												0,
												2,
												new String[]{
													"A holy symbol",
													"A prayer book or prayer wheel",
													"5 sticks of incense",
													"vestments",
													"a set of common clothers",
													"a belt pouch containing 15gp"
												},
												"Shelter of the Faithful"
												)
										};
	}
}

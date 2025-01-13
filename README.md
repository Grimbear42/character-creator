# Final CS1 - Character Creator

This repository contains my final project for Computer Science 1. This version of the application is a direct copy of my original project into a Maven file structure.  Although this version of the application met all of the requirements of the project it is very much an unfinished product.  Over time I plan on refining this project and hopefully create a finished product, even though the 5th edition ruleset is being superseded.  I avoided the use of Data Structures when building this project as they were beyond the scope of the course, although I plan to incorporate them over time in future revisions.

# Project Description

For this project I have developed a tool for creating a character under the Dungeons and Dragons 5th Edition ruleset.  
Character creation rules were take from the first printing of the Player's Handbook only.  
No rules, classes or races released afterwards have been included.  This project was created using Java and JavaFX.

## Installation Instructions
To install and execute this application:
1. Download a copy of the respository and unzip in your desired directory.  
2. Compile all .java files within the repository
3. Run the following command from your command line "java --module-path="Path to your JavaFX SDK" --add-modules="javafx.controls,javafx.media,javafx.fxml" "CharacterCreator.java"
(Disclaimer:  The required command may vary if you are running an OS other than Windows)
No other installations or configurations should be required.

## Sample Output
Pictures below provide an example of the tool
![Splash Screen with a large button reading "Create a new character"](/img/SplashScreen.jpg "Character Creator Splash Screen")
![A window with options to enter a character name, and select a race and class](/img/NameRaceClass.jpg "Name, Race, and Class Selection Screen")
![A window with options to assign scores to different abilities](/img/Stats.jpg "Stat Selection Screen")
![A window with options to select alignment, background, height, weight, eye color, hair color, and age](/img/Description.jpg "Character Description Screen")
![A window with options to select proficiencies and languages](/img/Proficiency.jpg "Proficiency Selection Screen")
![A window displaying a completed character sheet](/img/Display.jpg "Character Display Screen")

## Description
This application utilizes Java, JavaFX with FXML functionality with a Model, 
View, Controller concept.  The Data Model classes include JavaDoc comments 
throughout to simplify interaction with the API.  Additional Race, Class, and 
Background options can be added by altering the CharRaces, CharClasses, and 
Backgrounds classes respectively.  Each class creates an array of their 
respective object type, with a constructor for each utilized class, race and 
background.  If you wish to use this application as is, no further action is
required on your part beyond executing the main class App.java
My basic design of data for this application is heavily Object-Oriented.  Each 
character is it's own object, as well as each class, race, background, stat, and 
skill.  I attempted to design such that the contollers minimized interaction with 
anything other than the Charac class, although refinement is still required in 
several places.

## Known Issues

### Application Wide
Compiler Warnings when compiling StatController.jave due to unresolved issue with generics</br>
Accessibility Options missing for all application elements</br>
Missing most asthetic elements

### Name, Class, and Race Selection Screen
Limited Races available (Currently supports Hill Dwarf, Mountain Dwarf, and High Elf)</br>
Limited Classes available (Currently only supports Barbarian)</br>

### Stat Selection
Missing Point Buy system implementation</br>
Switching between stat selection options may result in a doubling of available scores to choose from</br>

## Description Selection Screen
Limited Backgrounds available (Currently only supports the Acolyte background)</br>
Clicking on 'Accept Description' with an invalid value into the Hair Color, Eye Color or Age fields will result loss of function of the 'Accept Description' button until application restart.</br>

## Proficiency Selection Screen
The upper left skill selection list does not function properly. (It will tell you to select 2 skills, then after submitting, will tell you that you may only select one, although you should be able to select 2)</br>

## Display Screen
Armor Class does not reflect any armor you may be wearing.

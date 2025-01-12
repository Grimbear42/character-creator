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

## Commentary and References
This was a much more complex problem to solve than I imagined it would be when I 
first submitted my project proposal.  I struggled with effectively designing the 
Character model to include splitting portions into various classes.  Initially, 
I designed each Race as a child of the CharRace class, (and similar for the 
CharClass class) but I ran into a lot of problems with this method, so I switched 
to the current implementation.  An example of the challenges involved in the data 
model would be Skill roll modifiers.  Each skill has an ability that it is 
associated with that provides its modifier to all rolls for that skill.  Every 
class grants proficiency to certain skills, which adds an additional bonus to 
rolls for those skills.  Additionally, some races also add this bonus to 
specific skills.  This requires skills to get data from the Character, the 
Character's race and the Character's class to be fully developed.  These kinds 
of design issues will most likely become less difficult once I learn more about 
design philosphies.  Some design issues might have been easier with the use of 
Lists and Maps.  I decided to avoid those data structures since they were beyond 
the scope of this class.
I learned a significant amount from working with JavaFX for the first time.  I 
struggled initially with being able to change scenes while also passing data.  
The following resources (in addition to the JavaFX API documentation) were 
extremely helpful in solving multiple JavaFX issues.</br>
[JavaFX Tutorial](https://jenkov.com/tutorials/javafx/index.html)</br>
[Bro Code JavaFX switch scenes](https://www.youtube.com/watch?v=hcM-R-YOKkQ)</br>
[Bro Code JavaFX ChoiceBox](https://www.youtube.com/watch?v=hwCbXOM4_Qc)</br>
[Bro Code JavaFX Spinner](https://www.youtube.com/watch?v=hSTEVJe4HSE)</br>
[Bro Code JavaFX ListView](https://www.youtube.com/watch?v=Pqfd4hoi5cc)</br>
While attempting to resolve the compiler warnings regarding the ChoiceBoxes in 
my StatController class, I found the following page that helped me resolve parts 
of the problem:</br>
[StackOverflow](https://stackoverflow.com/questions/26195243/creating-an-observable-list-collection)</br>
I was able to use the following page for assistance in adding images to a markdown document:</br>
[Adding Images to MarkDown Pages](https://marinegeo.github.io/2018-08-10-adding-images-markdown/)</br>
Finally, thanks to Professor Veliz for providing a huge amount of resources 
prior to the beginning of this project.


## Introduction

Our group is trying to develop an integrated development environment that supports the Slogo programming language. This IDE is run on an interactive per expression basis, or a read-eval-print loop for interpreted languages. Our primary design goal is to develop four different APIs that are easy to learn, use, read, maintain, and also powerful enough to satisfy the requirements of our program. Our program will be flexible on the front end, allowing users to change their view, and on the background making it easy for users to add more features in the future. Editing the front end to include different buttons/features will be open, and proper use of interface design will encourage such implementations. The interpreter will remain closed to changes; however, will be open to the addition of new commands. 


## Design Overview

Internal Front-end API:
+Image view
+Text field
+Buttons

The internal front-end API constructs the graphical user interface of a program. It creates buttons and listens to user input events. This api also contains a text field for the user to input commands. Displays errors. 

External Front-end API:
+User input
+Button/or other events (ones that are not handled by the front end)

Communicating user input, button events depending on how the specific language is going to be implemented. 

Internal Back-end API:
+Parsing command
+User input events
+Turtle graphics package

Parses the user input and implements button commands. Implements changes to the graphical interface. 

External Back-end API:
+Changes in graphic
+Error checking/other important alerts

Sends errors received from the internal back-end up to the front-end which are properly displayed there. Sends changes in graphics to the front end.  
	
## User Interface

## API Details

## API Example Code
fd 100: forward 100 pixels
bd 100: backward 100 pixels
lt 90: left-turn 90 degrees
rt 90: right-turn 90 degrees
du: drawer unabled
da: drawer abled
ht: hide turtle
st: show turtle
clear: reset the window
home: turtle go to default place, without clearing existing paint
repeat 5-(PROCEDURE): repeat the procedure 5 times
setX, setY: set the position of the turtle, right and up positive
setAngle: set the angle of the turtle, horizontal right to be 

## Design Considerations

We discussed the pros and cons of where the logic for the commands, buttons, and updating the picture will be located. We deemed that the logic should entirely appear in the backend. This maintains a cleaner separation between the two subsections of the program. The front is solely responsible for display purposes and the backend is responsible for parsing through logic and changes that occur from user input. We discussed how complex animations will represent an ambiguity, and tried to design for such complex program inputs with the Command and SimpleCommand classes. The two external APIs are entirely dependent on their respective internal APIs. Their functionality is dependent on the existence and behaviors of the internal APIs. This dependency may get cleared up in the future but for now remains a problem. 

## Team Responsibilities

Jing
Primary - Parsing
Secondary - Error checking

Erik 
Primary - Compiling commands into image
Secondary - other backend as necessary


Kelley
Primary - text field, image view
Secondary - external api


Dorian
Primary - Menu Bar, Console
Secondary - frontend external api, debugging

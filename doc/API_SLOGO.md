Dorian Barber (dpb20)
Erik Riis (evr4)
Jing Yang (jy201)
Kelley Scroggs (jks38)

SLogo Architecture Design:

1. When does parsing need to take place and what does it need to start properly: Parsing needs to take place when the user creates some input into the IDE, may be in the form of a button, enter key, or some other user action. In order to properly start there needs to be some input to parse. 

2. What is the result of parsing and who receives it: The result of parsing is some SLogo function. The external backend receives the user input, parses it to obtain relevant data which is passed to internal backend which performs some functionality which then gets sent to the frontend for implementation. 

3. When are errors detected and how are they reported: Errors are detected in the external backend, specifically when parsing occurs. If an error is caught it is then sent back to the frontend in order to be displayed to the user. 

4. What do commands know, when do they know it, and how do they get it: The command that the user inputs knows if it is a valid command and what its function is. This happens after the user input is parsed in the backend. The backend internal will contain all of the actual functionality of the commands, so the parsed command and its input parameter would be passed there.

5. How is the GUI updated after a command has completed execution: The output of the command function in the backend of the project gets passed back to the front end in order to update GUI components.

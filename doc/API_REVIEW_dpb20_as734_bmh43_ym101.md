dpb20 as734 asa48 bmh43 ym101

Part 1
====

My API design is intended to be flexible by limiting the number of public methods that are accessible by the user. This will create an environment such that the user has very few possible methods to use. The internal front end API is currently implemented such that the user can create certain additions to the front-end, but prevents the user from tampering with the implementation details of the frontend. The API is encapsulating the implementation details by using abstract classes and interfaces to keep private methods that hold valuable implementation details. This way the user cannot edit or change those details to damage the program. Since the frontend is the only means the user is accessing the program, it is crucial that this it successfully encapsulates all implementation details. One major error cases that the frontend will handle is when the user inputs an incorrect command. The way this will be handled is the frontend will send that command to the backend and the backend will return a result. If the command was a valid command it will return the standard result, otherwise it will return an error line dependent on the kind of error. I think the API design at the core is strong because it prevents the user from using methods that should not be used and only allows them methods that are accessible. 

Part 2
=====

I think design patterns are currently represented through the mediator design pattern. Currently considering a model-view controller design pattern. I am most excited to work on the styling and appearance of the program. I looked at someone else's version of cell society and it looked significnatly better than what my group had as a user interface. I plan to use some cs styling to brush up the design and create a cleaner feel. I think the main idea is to look for JavaFX classes that solve the problem that is faced. I think the border pane class along with the Hbox and Vbox classes will be extremely helpful in creating a nice design. I am most worried about passing the image of the turtle drawing. We are still unsure if the creation of the image should occur in the backend or in the frontend. 
1. The user inputs a command
    The string of the command goes to the backend and a result is returned and printed in the console box. 
2. The user changes a language use
    The user can pick from a drop down menu the language they would like to select and any text that appears on the interface will change to the appropriate language. 
3. The user changes a background color
    From a drop down menu the user can select from a series of options. One of them being a specific background color to include. The background color will most likely never cross with any possible color of the turtle.
4. The user presses the up arrow key. 
    When the user presses an up arrow key the most recent command entered into the text field is brought back into the text box. If the user continue to presses the up arrow key the previous command is returned. 
5. The user wants to save the current image made.
    The user presses the save image button and it will prompt the user to go to a directory and name and save the image. 


Notes from discussion:
-using CSS
-border pane
-mediator



side note: creating an error catching class -- external frontend
this object is initialized and gets the relevant information 
maybe can be an error and a standard return value? -- depends

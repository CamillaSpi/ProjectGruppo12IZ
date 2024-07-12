# About Project
The target of this project is to develop an application implementing a Scientific Programmable Calculator supporting complex numbers.
The calculator developed support basic operations on complex numbers like addiction, subtraction, moltiplication, division, square root and invert sign;
Operations on the stack containing the operands inserted like dup, drop, clear...;
The calculator also gives the possibility to perform operations with variables (the variable's name must be from a to z, and who store different sets of variables values and to restore them;
The calculator also gives to users the possibilty to save personalized operation, use them, save them to a file and restore them in other usage session.
The users can also execute trascendental operations like MOD and ARG
The calculator has a quite friendly UI divided in different section in order to separete the different kinds of services offered. 

In the "Standard Interface" there is a text area in which user can write the operand in chartesian form and store it with enter button or with enter key, and a button for all basic operations and stack operations.
In the "Variables Interface" there is a text area in which user can write the variable (in range of a to z) and presses different button to perform operations on it (like store value into variable, restore value from variable to stack, add value or subtract value to variable). In this interface there is a button that allow the user to see all the variable's value already stored in that session.
In the "Operation Interface" there are two texta area to write the name and the definition of a user customized operations, and there are different button to save it, to execute it (on the operands inserted), to show it and to delete it ( in cascade ). In th interface there is a button that allow the user to see all the user defined operations already stored in that session.
In the "Trascendental Interface" there is a text area in which user can write the operand in chartesian form and store it with enter button or with enter key, and a button for all trascendental operations.


# HOW IT WORK
The Complex number need to be in one of this form:
"a+bj" , "a" , "+a" , "-a" , "bj" , "+bj", "-bj" , "+a+bj", "-a+bj", "+a-bj", "-a-bj".
a and b can also be real numbers (with . to separate the decimal and integer parts.
(So the number inserted need to not have space between characters)
The variables must be written in lower case and must be in range from a to z, only one variables for operations.
The name of an user operations must contains only alfanumeric characters and the name must be different from that already supported operation by calcualtor.
The operation must contains only already defined operation separated by only one space ( including the push into stack and the save and restore of the variables value ).





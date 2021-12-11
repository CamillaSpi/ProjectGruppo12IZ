/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandClassPackage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import modelClassPackage.ComplexNumber;
import modelClassPackage.MyOperandCollection;
import modelClassPackage.Variables;

/**
 *
 * @author Gruppo 12 IZ
 */
public class HashCommandTable {

    private final ObservableMap<String, ConcreteCommandPersonalized> concreteCommandHash;
    private final HashMap<String, String> basicCommandHash;
    private MyOperandCollection collector;
    private final Variables vars;

    /**
     * it create an object of this class, inizialize a basic hash structure for 
     * associate simbol of operation with the name of the class that allows the 
     * relative basic command, create an observable HashMap to store effective 
     * concrete command created by the user with the relative name, the collection
     * that contain operand and the vars structure that contain the variable. 
     * @param collector is the structure were are saved operand, is passed to every concretecommand created.
     * @param vars is the structure were are saved the variable, is passed to every concretecommand created.
     * @see MyOperandCollection, Variables, HashMap
     */
    public HashCommandTable(MyOperandCollection collector, Variables vars) {
        this.concreteCommandHash = FXCollections.observableHashMap();
        this.basicCommandHash = new HashMap<>();
        basicCommandHash.put("+", "AddCommand");
        basicCommandHash.put("-", "SubtractCommand");
        basicCommandHash.put("*", "MultiplyCommand");
        basicCommandHash.put("/", "DivideCommand");
        basicCommandHash.put("sqrt", "SquareRootCommand");
        basicCommandHash.put("+-", "InvertSignCommand");
        basicCommandHash.put("drop", "DropCommand");
        basicCommandHash.put("dup", "DupCommand");
        basicCommandHash.put("swap", "SwapCommand");
        basicCommandHash.put("over", "OverCommand");
        basicCommandHash.put("clear", "ClearCommand");
        basicCommandHash.put(">x", "SaveToVariableCommand");
        basicCommandHash.put("<x", "SaveFromVariableCommand");
        basicCommandHash.put("+x", "AddToVariableCommand");
        basicCommandHash.put("-x", "SubtractToVariableCommand");
        basicCommandHash.put("mod", "ModCommand");
        basicCommandHash.put("arg", "ArgCommand");
        basicCommandHash.put("save", "SaveVariablesCommand");
        basicCommandHash.put("restore", "RestoreVariablesCommand");
        this.collector = collector;
        this.vars = vars;
    }

    /**
     * it allows to set the attribute collector if it change.
     *
     * @param collector is the new operand collector to set.
     * @see MyOperandCollection, ConcreteCommandPersonalized
     */
    public void setCollector(MyOperandCollection collector) {
        this.collector = collector;
    }

    /**
     * It create a personalized Command starting from the string passed as the
     * sequence of operations composing the definition. The
     * ConcreteCommandPersonalized Object is than added to the
     * concreteCommandHash with the name passed. If the passed name
     * corresponding to an already existing user defined operation, the
     * corresponding command will be updated.
     *
     * @param sequenceDefinition the string containing the operation's name,
     * defining the new User defined operation.
     * @param operationName the name for the user defined operation.
     * @return true if the personalizedCommand is correctly created otherwise
     * false.
     * @see MyOperandCollection, ConcreteCommandPersonalized
     */
    public boolean createPersonalizedCommand(String sequenceDefinition, String operationName) {
        //if the name passed is equal to that of a basic operation, the operation personalized cannot be created.
        if (basicCommandHash.containsKey(operationName)) {
            return false;
        }
        //Starting from the string passed all the operation's name are identified
        String[] stringOfCommands = sequenceDefinition.split(" ");
        Class<?> operation;
        Constructor<?> commandConstructor;
        Command newCommand;
        List<Command> commandList = new LinkedList<>();
        for (String stringCommand : stringOfCommands) {
            System.out.println("dopo fro");
            //check if the string is one corrisponding to the basic operation
            if (stringCommand.length() == 2 && vars.checkRange(stringCommand.substring(1))) {
                String substitute = stringCommand.substring(0, 1).concat("x");
                if (basicCommandHash.containsKey(substitute)) {
                    try {
                        operation = Class.forName("commandClassPackage." + this.basicCommandHash.get(substitute));
                        commandConstructor = operation.getConstructor(MyOperandCollection.class, Variables.class, String.class);
                        //create a new command corresponding to the operation
                        newCommand = (Command) commandConstructor.newInstance(collector, vars, stringCommand.substring(1));
                        //add this new command to the list of command
                        commandList.add(newCommand);
                    } catch (Exception ex) {
                        return false;
                    }
                }
            } else if (basicCommandHash.containsKey(stringCommand)) {
                System.out.println("containskey");
                try {
                    operation = Class.forName("commandClassPackage." + this.basicCommandHash.get(stringCommand));
                    //create a new command corresponding to the operation
                    if (stringCommand.equals("save") || stringCommand.equals("restore")){
                        System.out.println("nel nostro");
                        commandConstructor = operation.getConstructor(Variables.class);
                        newCommand = (Command) commandConstructor.newInstance(vars);
                    }else{
                        System.out.println("in quellaltro");
                        commandConstructor = operation.getConstructor(MyOperandCollection.class);
                        newCommand = (Command) commandConstructor.newInstance(collector);
                    }
                    //add this new command to the list of command
                    commandList.add(newCommand);
                } catch (Exception ex) {
                    System.out.println(ex);
                    return false;
                }
            } //check if the string is one corresponding to the user defined operation
            else if (concreteCommandHash.containsKey(stringCommand)) {
                //add this command to the list of command
                commandList.add(concreteCommandHash.get(stringCommand));
            } else {
                ComplexNumber maybe = ComplexNumber.create(stringCommand);
                if (maybe != null) {
                    //maybe a complexNumber
                    commandList.add(new EnterCommand(collector, maybe));
                } else {
                    System.out.println("in culo adio");
                    return false;
                }
            }
        }
        //starting from the list creadet, create a new commandPersonalized object
        ConcreteCommandPersonalized personalizedCommand = new ConcreteCommandPersonalized(operationName, sequenceDefinition, commandList);
        //add this new personalizedCommand to the hashMap containing all the user defined command
        concreteCommandHash.put(operationName, personalizedCommand);
        return true;
    }

    /**
     * It delete a personalized Command starting from the name.If the remove
     * operation return null, the elements is not contained in the hashmap, then
     * false was returned, otherwise the personalized command exists.Now we
     * check if this command is inserted in other personalized commands and if
     * yes the personalized command is removed.
     *
     * @param name
     * @return If the elements doesn't exist then false was returned otherwise
     * true.
     */
    public boolean delete(String name) {
        if (name == null) {
            return false;
        }
        ConcreteCommandPersonalized toDelete = (ConcreteCommandPersonalized) concreteCommandHash.remove(name);
        if (toDelete == null) {
            return false;
        }
        // If i'm there the ConcreteCommandPersonalized exists, so maybe its was inserted in other list
        concreteCommandHash.entrySet().stream().filter(maybeToDelete -> (maybeToDelete.getValue().contains(name))).forEachOrdered(maybeToDelete -> {
            concreteCommandHash.remove(maybeToDelete.getKey());
        });
        return true;
    }

    /**
     * it returns the user defined command corresponding to the name passed, if
     * it exists, otehrwise null
     *
     * @param commandName the name of which obtain the corresponding user
     * defined command.
     * @return the command if exists otherwise null.
     * @see ConcreteCommandPersonalized
     */
    public Command getUserCommand(String commandName) {
        if (concreteCommandHash.containsKey(commandName)) {
            return concreteCommandHash.get(commandName);
        } else {
            return null;
        }
    }

    /**
     * it returns the observable map create at this moment for user commands.
     *
     * @return the structure if exists otherwise null.
     * @see ConcreteCommandPersonalized, ObservableMap
     */
    public ObservableMap<String, ConcreteCommandPersonalized> getMyCommandHash() {
        return this.concreteCommandHash;
    }

    /**
     * It reads from a file the name and the definition of user operations
     * defined by user in previous usage session if it is possible. Otherwise,
     * if the name of the File is not correct or the content is not right the
     * operation will not be performed. If the reading went well the operations
     * contained in the task will be added to that defined in the current usage
     * session.
     *
     * @param fileName the file from which to read the contents
     * @return true if the reading operation went well otherwise false.
     * @see ConcreteCommandPersonalized, File
     */
    public boolean readCommandFromFile(File fileName) {
        String opName;
        String userCommandDefinition;

        try (Scanner in = new Scanner(new BufferedReader(new FileReader(fileName)))) {
            in.useLocale(Locale.US);
            in.useDelimiter(",");
            while (in.hasNext()) {
                opName = in.next();
                userCommandDefinition = in.next();
                createPersonalizedCommand(userCommandDefinition, opName);
            }
        } catch (FileNotFoundException ex) {
            return false;
        }
        return true;
    }

    /**
     * It prints to a file the name and the definition of user operations
     * defined by user in current usage session if it is possible.Otherwise,
     * if the name of the File is not correct or the content is not right the
     * operation will not be performed.If the printing went well the operations
     * contained in the task will be printed on the file passed.
     *
     * @param file is the file were save all the current user defined operations.
     * @return true if the reading operation went well otherwise false.
     * @see ConcreteCommandPersonalized, File
     */
    public boolean printCommandToFile(File file) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
            concreteCommandHash.entrySet().forEach(m -> {
                out.print(m.getKey() + "," + m.getValue().getCommands() + ",");
            });
        } catch (IOException ex) {
            return false;
        }
        return true;
    }
}

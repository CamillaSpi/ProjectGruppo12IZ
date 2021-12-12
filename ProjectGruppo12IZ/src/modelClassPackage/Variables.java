/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelClassPackage;

import java.io.Serializable;
import java.util.Map;
import java.util.Stack;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

/**
 * This is a class containing a Map as attribute, in order to contain variables
 * as keys and associated complex Number as values.
 *
 * @author Gruppo 12 IZ
 */
public class Variables implements Serializable {

    private ObservableMap<String, ComplexNumber> myVariables;
    private final Stack<ObservableMap<String, ComplexNumber>> myVariablesStack;

    /**
     * <p>
     * It inizializes the attribute myVariables, as an HashMap with String as
     * Keys and ComplexNumber as Values.
     * </p><!-- -->
     * @see ComplexNumber
     */
    public Variables() {
        this.myVariables = FXCollections.observableHashMap();
        myVariablesStack = new Stack<>();
    }

    /**
     * <p>
     * It checks if the string passed has only one character included in the
     * range from "a" to "z".
     * </p><!-- --> 
     * @param s the string to be analized
     * @return True if the String has only one character in the range from "a"
     * to "z", false otherwise.
     */
    public boolean checkRange(String s) {
        return s != null && s.length() == 1 && s.charAt(0) >= 'a' && s.charAt(0) <= 'z';
    }

    /**
     * <p>
     * It returns the value associated with the key passed if exists one,
     * otherwise null.
     * </p><!-- -->
     * @param key the key of which returns the associated value
     * @return the value associated with the key passed if it exists else return
     * null.
     * @see ComplexNumber
     */
    public ComplexNumber getValue(String key) {
        return myVariables.get(key);
    }
    
    /**
     * <p>
     * It returns the attribute myVariables
     * </p><!-- -->
     * @return myVariable the map attribute, containing couples
     * Key-Value
     * @see ComplexNumber
     */
    public ObservableMap<String, ComplexNumber> getMyVariables() {
        return myVariables;
    }

    /**
     * <p>
     * It associates the ComplexNumber passed as value with the String passed as
     * key and put this couple as item in the myVariable map. If already exists
     * a value associated with the specified key, this value will be replaced by
     * the new one.
     * </p><!-- -->
     * @param key it contains the variable (key) on which save a value
     * @param value it contains the value of the key (ComplexNumber)
     * @return a bolean value that represents if the number is correctly saved or
     * not.
     * @see ComplexNumber
     */
    public boolean saveToVariable(String key, ComplexNumber value) {
        if (checkRange(key)) {
            this.myVariables.put(key, value);
            return true;
        }
        return false;
    }

    /**
     * <p>
     * The method checks if the key is written in the correct form and returns
     * the complexnumber associated if it exists.
     * </p><!-- -->
     * @param key it contains the name of the variable written in the UI.
     * @return The complexNumber if the value associated with the key exists,
     * otherwise null, also if the key is not correct.
     * @see ComplexNumber
     */
    public ComplexNumber saveFromVariable(String key) {
        ComplexNumber val = this.getValue(key);
        if (checkRange(key) && val != null) {
            return val;
        }
        return null;
    }

    /**
     * <p>
     * It subtracts the value passed as second parameter from the value associated to the key passed
     * as first parameter, if the operation is concluded succesfully it stores the
     * results as value of the key itself.
     * </p><!-- -->
     * @param key the variable associated to the value on which perform
     * the subtraction.
     * @param subtracting the value to subtract from.
     * @return true if the operation is executed, false otherwise.
     * @see ComplexNumber
     * @see Calculator
     */
    public boolean subtractToVariable(String key, ComplexNumber subtracting) {
        if (checkRange(key) && subtracting != null) {
            ComplexNumber value = this.getValue(key);
            if (value != null) {
                this.saveToVariable(key, Calculator.subtraction(value, subtracting));
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * It adds the ComplexNumber passed as value with the ComplexNumber
     * associated with the Strings passed as key. If doesn't exist a value
     * associated with the specified key, returns false.
     * </p><!-- -->
     * @param key the variable associated with the value on which perform the
     * addiction
     * @param value the value to add.
     * @return a boolean value that represents if the number is correctly added or
     * not.
     * @see ComplexNumber
     * @see Calculator
     */
    public boolean addToVariable(String key, ComplexNumber value) {
        if (checkRange(key) && value != null) {
            ComplexNumber var = this.getValue(key);
            if (var != null) {
                this.saveToVariable(key, Calculator.addiction(var, value));
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * Puts into the variables' map the key and the value passed as parameters.If there
 is already a value, it will be replaced.</p><!-- -->
   * @param key the variable associated with the value on which perform the action
     * @param value the value to add.
     * @see ComplexNumber
     *
     */
    public void put(String key, ComplexNumber value) {
        this.myVariables.put(key, value);
    }

    /**
     * <p>
     * Method toSring of the variables' stack
     * </p><!-- -->
     * @return a string definition for the current object
     * @see ComplexNumber
     */
    @Override
    public String toString() {
        String s = "";
        s = myVariables.entrySet().stream().map(entry -> "(" + entry.getKey() + ", " + entry.getValue() + "), ").reduce(s, String::concat);
        return s.substring(0, s.length() - 2);
    }

    /**
     * <p>
     * It saves a copy of the current collection of variables into a stack, that can be re-used doing a restore.
     * </p><!-- -->
     * @return true if the stack of variables has a length greater than the old before a save operation, false otherwise
     * @see ComplexNumber
     */
    public boolean saveVariablesIntoStack() {
        int length = myVariablesStack.size();
        ObservableMap<String, ComplexNumber> myVariablesCopy =  FXCollections.observableHashMap();
        myVariablesCopy.putAll(myVariables);
        myVariablesStack.add(myVariablesCopy);
        return myVariablesStack.size() > length;
    }
    
    /**
     * <p>
     * It restores a copy of the collection of variables into the current collection, overwriting the value on the variables or
     * adding new ones. 
     * </p><!-- -->
     * @return false if the stack of variables is empty, so it can't be restored, otherwise
     * it returns true if the new stack of variables length is smaller than the previous before the restoring. 
     * @see ComplexNumber
     */
     public boolean restoreVariablesFromStack() {
        if(myVariablesStack.isEmpty())
            return false;
        int length = myVariablesStack.size();
        myVariables.clear();
        myVariables.putAll(myVariablesStack.pop());
        return myVariablesStack.size() < length;
    }
    

}

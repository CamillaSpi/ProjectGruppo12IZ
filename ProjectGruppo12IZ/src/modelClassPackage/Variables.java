/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelClassPackage;

import java.util.HashMap;
import java.util.Map;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * This is a class containing a Map as attribute, in order to contain variables 
 * as keys and associated complex Number as values.
 * @author Gruppo 12 IZ
 */
public class Variables {
    private final Map<String,ComplexNumber> myVariables;
    
    /**
    * It inizialize the attribute myVariables, as an HashMap with
    * String as Keys and ComplexNumber as Values.
    * <p> <!-- -->
    * @see ComplexNumber
    */   
    public Variables(){
        this.myVariables = new HashMap<>();
    }
    
    /**
    * It checks if the string passed has only one character included in the range from "a" to "z"
    * <p> <!-- -->
    * @param s the string to be analized
    * @return True if the String has only one character in the range from "a" to "z", false otherwise.
    */ 
    public boolean checkRange(String s){
        return s!=null && s.length()== 1 && s.charAt(0) >= 'a' && s.charAt(0) <= 'z';
    }
    
    
    /**
    * It returns the value associated with the key passed if exists one, otherwise null.
    * <p> <!-- -->
    * @param key the key of which returns the associated value
    * @return the value associated with the key passed if it exists else return null.
    * @see ComplexNumber
    */ 
    public ComplexNumber getValue(String key){
        return myVariables.get(key);  
    }
    
    public StringProperty getValueProperty(String key){
        StringProperty ret = new SimpleStringProperty();
        ret.setValue(myVariables.get(key).complexStringProperty().toString());
        return ret;
    }
    
    public StringProperty getKeyProperty(String key){
        if(myVariables.get(key) != null){
            StringProperty ret = new SimpleStringProperty();
            ret.setValue(key);
            return ret;
        }
        else 
            return null;
    }
    
    /**
    * It returns the attribute myVariables
    * <p> <!-- -->
    * @return myVariable the map attribute, containing couples Key-Value
    * @see ComplexNumber
    */ 
    public Map<String, ComplexNumber> getMyVariables() {
        return myVariables;
    }
    
    
    /**
    * It associates the ComplexNumber passed as value with the String passed as key 
    * and put this couple as item in the myVariable map. 
    * If already exists a value associated with the specified key, this value will be replaced by the new one.
    * <p> <!-- -->
    * 
    * @param key its contains the real part of the complex number
    * @param value its contains the imaginary part of the complex number
    * @return a bolean value that represent if the number is correctly saved or not.
    * 
    */
    public boolean saveToVariable(String key, ComplexNumber value){
        if(checkRange(key)){
            this.myVariables.put(key, value); 
            return true;
        }
        return false;
    }
    
    /**
    * The method checks if the key is written in the correct form and returns the complexnumber associated if it exists.
    * <p> <!-- -->
    * 
    * @param key it contains the name of the variable written in the UI.
    * @return The complexNumber if the value associated with the key exists, otherwise null, also if the key is not correct.
    * 
    */
    public ComplexNumber saveFromVariable(String key){
        ComplexNumber val = this.getValue(key);
        if(checkRange(key) && val != null){
            return val;
        }
        return null;
    }
    
    /**
    * It subtract the value passed from the value associated to the key passed as parameter,
    * if the operation is concluded succesfully it stores the results as value of the key itself.
    * <p> <!-- -->
    * @param key  the variable associated to the value on which perform the subtraction.
    * @param subtracting the value to subtract from that associated with the key passed.
    * @return true if the operation is executed, false otherwise.
    * @see ComplexNumber, Calculator
    */ 
    public boolean subtractToVariable(String key, ComplexNumber subtracting){
        if(checkRange(key) && subtracting != null){
            ComplexNumber value = this.getValue(key);
            if( value != null){
                this.saveToVariable(key, Calculator.subtraction(value, subtracting));
                return true;
            }
        }
        return false;
    }
    
     /**
     * It add the ComplexNumber passed as value with the ComplexNumber
     * associated with the Strings passed as key. If didn't exists a value
     * associated with the specified key, return false.
     * <p>
     * <!-- -->
     *
     * @param key the variable associated with the value on which perform the
     * addiction
     * @param value its contains the imaginary part of the complex number
     * @return a bolean value that represent if the number is correctly added or
     * not.
     *
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
 public void put(String key, ComplexNumber value){
     this.myVariables.put(key, value);
 }
    
    /**
    * It returns the attribute myVariables
    * <p> <!-- -->
    * @return a string definition for the current object
    * 
    */ 
    @Override
    public String toString() {
        String s = "";
        for(Map.Entry<String,ComplexNumber> entry : myVariables.entrySet())
            s += "(" + entry.getKey()+ ", " + entry.getValue() + "), ";
        return s.substring(0, s.length()-2);
    }
    
    
}

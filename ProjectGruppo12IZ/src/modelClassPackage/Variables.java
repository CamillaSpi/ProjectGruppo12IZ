/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelClassPackage;

import java.util.HashMap;
import java.util.Map;

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
        if(checkRange(key) && value != null){
            this.myVariables.put(key.toString(), value); 
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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelClassPackage;

import java.util.HashMap;
import java.util.Map;

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
    * @param key its the string that rapresent the name of the the variable 
    * @param value its contains the ComplexNumber to save in the variable
    * @return a boolean value that represent if the number is correctly saved or not.
    * 
    */
    public boolean saveToVariable(String key, ComplexNumber value){
        if(checkRange(key) && value != null){
            this.myVariables.put(key.toString(), value); 
            return true;
        }
        return false;
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

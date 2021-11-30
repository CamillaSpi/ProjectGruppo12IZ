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
        return s.length()== 1 && s.charAt(0) >= 'a' && s.charAt(0) <= 'z';
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
    * It associates the ComplexNumber passed as value with the String passed as key 
    * and put this couple as item in the myVariable map. 
    * If already exists a value associated with the specified key, this value will be replaced by the new one.
    * <p> <!-- -->
    * @param key the key to which associate the specified value.
    * @param value the value to associate with the specified key.
    * @see ComplexNumber
    */ 
    public void setValue(String key, ComplexNumber value){
        myVariables.put(key, value);
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
    * It returns the attribute myVariables
    * <p> <!-- -->
    * 
    * @param key its contains the real part of the complex number
    * @param value its contains the imaginary part of the complex number
    * @return a bollean value that represent if the number is correct save or not.
    * 
    */
    public boolean saveToVariables(Character key, ComplexNumber value){
        if(key != null && value != null)
            if (key >= 'a' && key <= 'z'){
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

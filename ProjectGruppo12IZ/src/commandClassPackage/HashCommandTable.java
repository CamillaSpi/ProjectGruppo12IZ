/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandClassPackage;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import modelClassPackage.MyOperandCollection;

/**
 *
 * @author Gruppo 12 IZ
 */
public class HashCommandTable{
    
    private final HashMap concreteCommandHash;
    private final HashMap basicCommandHash;

    public HashCommandTable() {
        this.concreteCommandHash = new HashMap<String,ConcreteCommandPersonalized>();
        this.basicCommandHash = new HashMap<String, String>();
        basicCommandHash.put("+", "AddCommand");
        basicCommandHash.put("-", "SubtractCommand");
        basicCommandHash.put("*", "MultiplyCommand");
        basicCommandHash.put("/", "DivideCommand");
        basicCommandHash.put("sqrt", "SquareRootCommand");
        basicCommandHash.put("+/-", "InvertSignCommand");
        basicCommandHash.put("drop", "DropCommand");
        basicCommandHash.put("dup", "AddCommand");
        basicCommandHash.put("swap", "SwapCommand");
        basicCommandHash.put("over", "AddCommand");
        basicCommandHash.put("clear", "AddCommand");
        basicCommandHash.put("ciao", "ciao");
    }
    
    /*
    * camilla ha scoperto tutto questo dategli 1 milione di dollari
    */
    public void createPersonalizedCommand(MyOperandCollection collector, String userString) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        String[] listOfCommands = userString.split(" ");
        Class<?> camiScoperta;
        Constructor<?> nandoRosica;
        Command instance;
        for(String command: listOfCommands){
            camiScoperta = Class.forName("commandClassPackage." + this.basicCommandHash.get("drop"));
            nandoRosica = camiScoperta.getConstructor(MyOperandCollection.class);
            instance = (Command) nandoRosica.newInstance(collector);
        }
        
        

        
    }
    
    
}

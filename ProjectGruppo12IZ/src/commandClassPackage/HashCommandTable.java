/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandClassPackage;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import modelClassPackage.MyOperandCollection;

/**
 *
 * @author Gruppo 12 IZ
 */
public class HashCommandTable{
    
    private final HashMap<String,ConcreteCommandPersonalized> concreteCommandHash;
    private final HashMap basicCommandHash;

    public HashMap<String, ConcreteCommandPersonalized> getConcreteCommandHash() {
        return concreteCommandHash;
    }

    public HashCommandTable() {
        this.concreteCommandHash = new HashMap<>();
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
    
    public boolean delete(String name){
        if (name == null )
            return false;
        ConcreteCommandPersonalized toDelete = (ConcreteCommandPersonalized) concreteCommandHash.remove(name);
        if(toDelete == null)
            return false;
        // If i'm there the ConcreteCommandPersonalized exists, so maybe its was inserted in other list
        for(Map.Entry<String, ConcreteCommandPersonalized> maybeToDelete : concreteCommandHash.entrySet() ){
            if(maybeToDelete.getValue().contains(name)){
                concreteCommandHash.remove(maybeToDelete.getKey());
            }
        }
        return true;
    }
    
    
}

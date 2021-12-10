/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandClassPackage;

import modelClassPackage.ComplexNumber;
import modelClassPackage.MyOperandCollection;
import modelClassPackage.Variables;

/**
 *
 * @author Gruppo 12 IZ
 */
public class SaveFromVariableCommand implements Command{
    private final MyOperandCollection collector;
    private final Variables vars;
    private final String var;
    private ComplexNumber value;
    
    /**
     * This method creates an object that represents Save From Variable operation in order to execute and undo the command,
     * assert if one between collection, variables, var are null .
     * <p> <!-- -->
     * @param collector is the collection were SaveFromVariable pushes.
     * @param vars is the collection of variables.
     * @param var is the specified value on which the function operates.
     * @see MyOperandCollection,Variables
     */
    public SaveFromVariableCommand(MyOperandCollection collector,Variables vars, String var) {
        assert (collector != null && vars != null && var != null);
        this.collector = collector;
        this.vars = vars;
        this.var = var;
    }
    
    /**
     * This method implements execute method for save from variable operation from Command interface
     * @return true if the var has a value and the operation is performed, false otherwise
     */
    @Override
    public boolean execute() {
        value = vars.saveFromVariable(var);
        if (value != null){
            collector.insert(value);
            return true;
        }
        else
            return false;
    }

    @Override
    public void undo() {
        value = collector.remove();
        vars.saveToVariable(var, value);
    }
    
}

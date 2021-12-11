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
public class AddToVariableCommand implements Command{

    private final MyOperandCollection collector;
    private final Variables vars;
    private final String variables;
    private ComplexNumber oldValueVar;
    private ComplexNumber OperandFromStack;

    /**
     * This method creates an object that represents add to variable operation 
     * in order to execute and undo the command, assert if collection is null or 
     * if vars is null or if variables is null
     * <p> <!-- -->
     * @param collector is the collection were addend is taken
     * @param vars is the collection were addend has to be insert
     * @param variables is the var were execute the operation
     * @see MyOperandCollection, Variables, ComplexNumber
     */
    public AddToVariableCommand(MyOperandCollection collector, Variables vars, String variables) {
        assert collector != null;
        this.collector = collector;
        assert vars != null;
        this.vars = vars;
        assert variables != null;
        this.variables = variables;
        
        
    }
    
    /**
     * This method implements execute method for add to variable operation from 
     * Command interface, return false if it can't be performed.
     * @return boolean that check if the operation is performed or not.
     */
    @Override
    public boolean execute() {
        ComplexNumber value = collector.last();
        if(value == null)
            return false;
        this.OperandFromStack = value;
        
        this.oldValueVar = vars.getValue(this.variables);
        
        if (this.oldValueVar == null)
            return false;
        collector.remove();
        return vars.addToVariable(this.variables, this.OperandFromStack);
        
    }

    /**
     * This method implements undo method for add to variable operation 
     * from Command interface.
     */
    @Override
    public void undo() {
        vars.saveToVariable(this.variables, this.oldValueVar);
        collector.insert(this.OperandFromStack);
        
    }
    
}

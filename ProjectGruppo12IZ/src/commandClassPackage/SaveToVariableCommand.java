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
 * @author Mattia
 */
public class SaveToVariableCommand implements Command{

    private final MyOperandCollection collector;
    private final Variables vars;
    private final String var;
    private ComplexNumber varValue;
    private ComplexNumber removedOperand;

    /**
     * This method create an object that rappresent SaveToVariable operation in order to execute and undo the command.
     * <p> <!-- -->
     * @param collector is the collection were take last operand.
     * @param vars is the collection were call SaveToVariable method.
     * @param var is the name of the variable were call SaveToVariable.
     * @see MyOperandCollection
     */
    public SaveToVariableCommand(MyOperandCollection collector, Variables vars, String var) {
        assert collector != null;
        this.collector = collector;
        assert vars != null;
        this.vars = vars;
        assert var != null;
        this.var = var;

    }
    
    /**
     * This method implements execute method for SaveToVariable operation from Command interface.
     * @return true or false if operation executed.
     */
    @Override
    public boolean execute() {       
        varValue = vars.getValue(var);
        removedOperand = collector.last();
        if(removedOperand == null)
            return false;
        if(vars.saveToVariable(var, removedOperand) == false)
            return false;
        collector.remove();
        return true;
    }

    /**
     * This method implements undo method for SaveToVariable operation from Command interface
     */
    @Override
    public void undo() {
        vars.saveToVariable(var, varValue);
        collector.insert(removedOperand);
    }
}

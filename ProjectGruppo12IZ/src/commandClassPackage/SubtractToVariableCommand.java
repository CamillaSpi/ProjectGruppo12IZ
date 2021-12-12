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
public class SubtractToVariableCommand implements Command{

    private final MyOperandCollection collector;
    private final Variables vars;
    private final String variables;
    private ComplexNumber oldValueVar;
    private ComplexNumber OperandFromStack;

    /**
     * <p>
     * This method creates an object that represents subtract to variable operation in order to execute and undo the command,
     * assert if collection is null or if vars is null or if variables is null
     * </p> <!-- -->
     * @param collector is the collection were subtracting is taken
     * @param vars is the collection were minuend is taken
     * @param variables is the var were execute the operation
     * @see MyOperandCollection, Variables
     */
    public SubtractToVariableCommand(MyOperandCollection collector, Variables vars, String variables) {
        assert collector != null;
        this.collector = collector;
        assert vars != null;
        this.vars = vars;
        assert variables != null;
        this.variables = variables;
        
        
    }
    
    /**
     * <p>
     * This method implements execute method for subtract to variable operation from Command interface
     * </p> <!-- -->
     * @return false if the variable value is null or the operand's stack is empty, otherwise
     * returns true if the subtract to variable is performed or false if not. 
     * @see ComplexNumber, MyOperandCollection, Variables
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
        return vars.subtractToVariable(this.variables, this.OperandFromStack);
        
    }

    /**
     * <p>
     * This method implements undo method for subtract to variable operation from Command interface, 
     * saving the old value into the variable and inserting in operand's stack the old value.
     * </p> <!-- -->
     * @see Variables, MyOperandCollection
     */
    @Override
    public void undo() {
        vars.saveToVariable(this.variables, this.oldValueVar);
        collector.insert(this.OperandFromStack);
    }
}

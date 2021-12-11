/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commandClassPackage;

import modelClassPackage.Calculator;
import modelClassPackage.ComplexNumber;
import modelClassPackage.MyOperandCollection;

/**
 * This is the costructor method for InvertSignCommand, this class implements
 * the Command interface with the override of the methods
 * @author Gruppo 12 IZ
 * 
 */
public class InvertSignCommand implements Command {
    private final MyOperandCollection collector;
    private ComplexNumber value;

    /**
     * It creates an object of the Invert Sign Command if the collector is not null.
     * @param collector
     * @see MyOperandCollection
     */
    public InvertSignCommand(MyOperandCollection collector) {
       assert collector != null;
       this.collector = collector;
    }

    /**
     * It executes the operation of invert sign on the last element if it is not null calling calculator's method,
     * removes the old value and pushes the new value into the stack.
     * @return false if the last stack element is null, true otherwise
     * @see Calculator,ComplexNumber,MyOperandCollection
     */
    @Override
    public boolean execute() {
        value = this.collector.last();
        if(value == null)
            return false;
        this.collector.remove();
        ComplexNumber NewValue = Calculator.invertSign(value);
        assert NewValue != null;
        this.collector.insert(NewValue);
        return true;
    }
    /**
     * It does the undo of the invert sign operation, so it removes the last element from the stack 
     * and pushes the previously value saved before the execute.
     * @see MyOperandCollection
     */
    @Override
    public void undo() {
        this.collector.remove();
        this.collector.insert(value);
    }

}

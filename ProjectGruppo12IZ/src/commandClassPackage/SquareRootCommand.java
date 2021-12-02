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
 * This is the costructor method for SquareRootCommand, this class implemenets
 * the Command interface with the override of the methods
 * @author Gruppo 12 IZ
 * 
 */
public class SquareRootCommand implements Command {
    private final MyOperandCollection collector;
    private ComplexNumber value;

    /**
     * It create an object of the SquareRootCommand if the collector is not null 
     * and the last element is not null
     * @param collector
     */
    public SquareRootCommand(MyOperandCollection collector) {
       assert collector != null;
       this.collector = collector;
       
    }

    /**
     * It execute the operation of square root on the last element and, if its not null,
     * pushes the result of the operation as last operand
     */
    @Override
    public boolean execute() {
        value = this.collector.last();
        if(value == null)
            return false;
        this.collector.remove();
        ComplexNumber NewValue = Calculator.squareRoot(value);
        assert NewValue != null;
        this.collector.insert(NewValue);
        return true;
    }
    /**
     * It undo the operation of square root, so take the last element and push 
     * the previously saved value
     */
    @Override
    public void undo() {
        this.collector.remove();
        this.collector.insert(value);
    }

}

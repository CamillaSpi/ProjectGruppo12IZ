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
 * @author Gruppo 12 IZ
 * 
 */
public class SquareRootCommand implements Command {
    private final MyOperandCollection collector;
    private ComplexNumber value;

    /**
     * <p>
     * It creates an object of the SquareRootCommand if the collector is not null.
     * </p> <!-- -->
     * @param collector the collection on which the command will be executed.
     * @see MyOperandCollection
     */
    public SquareRootCommand(MyOperandCollection collector) {
       assert collector != null;
       this.collector = collector;
    }

    /**
     * <p>
     * It executes the operation of square root on the last element it is not null, and
     * pushes the result of the operation as last operand
     * </p> <!-- -->
     * @return true if the operation is executed and the collector is not empty, false otherwise
     * @see MyOperandCollection
     * @see ComplexNumber
     * @see Calculator
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
     * <p>
     * It undo the operation of square root, so it removes the last element and push 
     * the previously saved one.
     * </p> <!-- -->
     * @see MyOperandCollection
     */
    @Override
    public void undo() {
        this.collector.remove();
        this.collector.insert(value);
    }

}

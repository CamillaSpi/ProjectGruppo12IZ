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
 *
 * @author Gruppo 12 IZ
 */
public class ArgCommand implements Command{
    private final MyOperandCollection collector;
    private ComplexNumber val;

    /**
     * <p>
     * It creates an object of the ArgCommand if the collector is not null.
     * </p> <!-- -->
     * @param collector collector
     * @see ComplexNumber 
     * @see MyOperandCollection
     */
    public ArgCommand(MyOperandCollection collector) {
        assert collector != null;
        this.collector = collector;
    }
    
    /**
     * <p>
     * It executes the operation of argument on the last inserted operand in the 
     * collector removing it and pushes the result of the operation as last operand.
     * </p> <!-- -->
     * @return true if the collection contains at least 1 element, false otherwise
     * @see ComplexNumber 
     * @see MyOperandCollection
     */
    @Override
    public boolean execute() {
        if (collector.collectionLength() <= 0)
            return false;                 
        val = collector.last();
        ComplexNumber res = Calculator.arg(val);
        if (res == null)
            return false;
        collector.remove();
        collector.insert(res);
        return true;
    }

    /**
     * <p>
     *It executes the undo of the argument operation removing the last inserted 
     * element that is the result of the operation, and pushes the operand that 
     * has been involved in the argument operation.
     * </p> <!-- -->
     * @see ComplexNumber 
     * @see MyOperandCollection
     */
    @Override
    public void undo() {
        collector.remove();
        collector.insert(val);
    }
    
}

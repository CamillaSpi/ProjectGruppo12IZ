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
     * It creates an object of the ArgCommand if the collector is not null.
     * @param collector
     * @see ComplexNumber, MyOperandCollection
     */
    public ArgCommand(MyOperandCollection collector) {
        assert collector != null;
        this.collector = collector;
    }
    
    /**
     *It executes the operation of argument on the last inserted operand in the collector removing it
     * and pushes the result of the operation as last operand.
     * @return true if the collection contains at least 1 element, false otherwise
     * @see ComplexNumber, MyOperandCollection
     */
    @Override
    public boolean execute() {
        if (collector.collectionLength() <= 0)
            return false;                 
        val = collector.remove();
        ComplexNumber res = Calculator.arg(val);
        collector.insert(res);
        return true;
    }

    /**
     *It executes the undo of the argument operation removing the last inserted element that is the result of the operation,
     * and pushes the operand that has been involved in the argument operation.
     * @see ComplexNumber, MyOperandCollection
     */
    @Override
    public void undo() {
        collector.remove();
        collector.insert(val);
    }
    
}

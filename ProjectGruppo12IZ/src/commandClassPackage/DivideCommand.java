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
public class DivideCommand implements Command {

    private final MyOperandCollection collector;
    private ComplexNumber dividend;
    private ComplexNumber divider;

    /**
     * <p>
     * It creates an object of the DivideCommand if the collector is not null
     * and contains enough element to perform the division operation.
     * </p> <!-- -->
     *
     * @param collector collector
     * @see ComplexNumber
     * @see MyOperandCollection
     */
    public DivideCommand(MyOperandCollection collector) {
        assert collector != null;
        this.collector = collector;
    }

    /**
     * <p>
     * It executes the operation of division on the last two inserted operands
     * in the collector removing them, and pushes the result of the operation as
     * last operand.
     * </p> <!-- -->
     *
     * @return true if the operation is performed, false otherwise.
     * @see ComplexNumber
     * @see MyOperandCollection
     */
    @Override
    public boolean execute() {
        ComplexNumber first = collector.last();
        ComplexNumber second = collector.secondLast();
        if (first == null || second == null) {
            return false;
        }
        this.dividend = second;
        this.divider = first;
        //executes the division of the two removed operands
        ComplexNumber result = Calculator.division(dividend, divider);
        if (result == null) {
            return false;
        }
        //removes the last two inserted operands
        collector.remove();
        collector.remove();
        //inserts the result of the division in the collection
        collector.insert(result);
        return true;
    }

    /**
     * <p>
     * It executes the undo of the division operation removing the last inserted
     * element that is the result of the operation, and pushes the two operands
     * that have been involved in the division operation.
     * </p> <!-- -->
     *
     * @see ComplexNumber
     * @see MyOperandCollection
     */
    @Override
    public void undo() {
        //removes the last operand inserted that is the result of the division
        collector.remove();
        //pushes the two elements that have been divided
        collector.insert(dividend);
        collector.insert(divider);
    }

}

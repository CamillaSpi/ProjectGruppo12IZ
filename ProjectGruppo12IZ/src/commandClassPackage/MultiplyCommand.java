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
public class MultiplyCommand implements Command{
    private final MyOperandCollection collector;
    private ComplexNumber firstOperand;
    private ComplexNumber secondOperand;
    
    /**
     * <p>
     * It creates an object of the MultiplyCommand if the collector is not null.
     * </p> <!-- -->
     * @param collector collector
     * @see MyOperandCollection
     */
    public MultiplyCommand(MyOperandCollection collector){
        assert collector != null;
        this.collector = collector;
    }
    
    /**
     * <p>
     *It executes the operation of multiplication on the last inserted operands in the collector, calling calculator's method and removing them
     * from the collection, and pushes the result of the operation as last operand.
     * </p> <!-- -->
     * @return true if the collection contains at least 2 element, false otherwise
     * @see ComplexNumber 
     * @see Calculator 
     * @see MyOperandCollection
     */
    @Override
    public boolean execute() {
        ComplexNumber value1 = collector.last();
        ComplexNumber value2 = collector.secondLast();
        if(value1 == null || value2 == null)
            return false;
        this.firstOperand = value1;
        this.secondOperand = value2;
        //remove the last two inserted operands
        collector.remove();
        collector.remove();
        //execute the multiplication of the two removed operands
        ComplexNumber result = Calculator.multiplication(firstOperand, secondOperand);
        //insert the result of the multiplication in the collection
        collector.insert(result);
        return true;
    }
    
    /**
     * <p>
     * It executes the undo of the multiplication operation removing the last inserted element that is the result of the operation,
     * and pushes the operands that have been involved in the operation.
     * </p> <!-- -->
     * @see MyOperandCollection
     */
    @Override
    public void undo() {
        //removes the last operand inserted that is the result of the multiplication
        collector.remove();
        //pushes the two elements that have been multiplied
        collector.insert(secondOperand);
        collector.insert(firstOperand);
    }
    
}

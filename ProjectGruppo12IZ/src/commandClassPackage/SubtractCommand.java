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
public class SubtractCommand implements Command{
    private final MyOperandCollection collector;
    private ComplexNumber firstOperand;
    private ComplexNumber secondOperand;
    
    
    
    /**
     * <p>
     * It creates an object of the SubtractCommand if the collector is not null.
     * </p> <!-- -->
     * @param collector the collection on which the subtract command is executed.
     * @see MyOperandCollection
     */
    public SubtractCommand(MyOperandCollection collector){
        assert collector != null;
        this.collector = collector;
    }   
 
    /**
     * <p>
     * It executes the operation of subtraction on the last two inserted operand in the collector removing them,
     * and pushes the result of the operation as last operand.
     * </p> <!-- -->
     * @return false if the collection doesn't contain at least two elements, true otherwise
     * @see ComplexNumber, MyOperandCollection, Calculator
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
        //execute the subtraction of the two removed operands
        ComplexNumber result = Calculator.subtraction(secondOperand, firstOperand);
        //insert the result of the subtraction in the collection
        collector.insert(result);
        return true;
    }
    
    /**
     * <p>
     * It executes the undo of the subtraction operation removing the last inserted element that is the result of the operation,
     * and pushes the two operands that have been involved in the subtraction operation.
     * </p> <!-- -->
     * @see MyOperandCollection
     */
    @Override
    public void undo() {
        //removes the last operand inserted that is the result of the subtraction
        collector.remove();
        //pushes the two elements that have been subtracted
        collector.insert(secondOperand);
        collector.insert(firstOperand);
    }
    
}

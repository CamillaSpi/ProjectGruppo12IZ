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
    private final ComplexNumber firstOperand;
    private final ComplexNumber secondOperand;
    
    
    
    /**
     * It create an object of the SubtractCommand if the collector is not null and 
     * contains enough element to perform the subtraction operation.
     * @param collector
     * @see ComplexNumber, MyOperandCollection
     */
    public SubtractCommand(MyOperandCollection collector){
        assert collector != null;
        this.collector = collector;
        ComplexNumber value1 = collector.last();
        ComplexNumber value2 = collector.secondLast();
        assert value1 != null && value2 != null;
        this.firstOperand = value1;
        this.secondOperand = value2;
    }
    
    
    /**
     *It executes the operation of subtraction on the last two inserted operand in the collector removing them,
     * and pushes the result of the operation as last operand.
     * @see ComplexNumber, MyOperandCollection
     */
    @Override
    public void execute() {
        //remove the last two inserted operands
        collector.remove();
        collector.remove();
        //execute the subtraction of the two removed operands
        ComplexNumber result = Calculator.subtraction(secondOperand, firstOperand);
        //insert the result of the subtraction in the collection
        collector.insert(result);
    }
    
    /**
     * It executes the undo of the subtraction operation removing the last inserted element that is the result of the operation,
     * and pushes the two operands that have been involved in the subtraction operation.
     * @see ComplexNumber, MyOperandCollection
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

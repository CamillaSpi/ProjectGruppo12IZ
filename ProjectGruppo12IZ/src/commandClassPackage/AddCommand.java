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
public class AddCommand implements Command{
    private final MyOperandCollection collector;
    private ComplexNumber firstOperand;
    private ComplexNumber secondOperand;
        
    /**
     * <p>
     * It create an object of the AddCommand if the collector is not null and 
     * contains enough element to perform the addiction operation.
     * </p> <!-- -->
     * @param collector
     * @see ComplexNumber, MyOperandCollection
     */
    public AddCommand(MyOperandCollection collector){
        assert collector != null;
        this.collector = collector;
    }
    /**<p>
     * It return the first operand of the AddCommand, it could return null, 
     * if it is call before execute this command null.
     * </p><!-- -->
     * 
     * @return a ComplexNumber
     * @see ComplexNumber
     */
    public ComplexNumber getFirstOperand() {
        return firstOperand;
    }
    /**<p>
     * It return the second operand of the AddCommand, it could return null, 
     * if it is call before execute this command null.
     * </p><!-- -->
     * 
     * @return a ComplexNumber
     * @see ComplexNumber
     */
    public ComplexNumber getSecondOperand() {
        return secondOperand;
    }
    
    
    /**
     * <p>
     * It execute the operation of addiction on the last two inserted operand in 
     * the collector removing them, and pushes the result of the operation as 
     * last operand, if it is possible otherwise retur false and not complete the operation.
     * </p><!-- -->
     * @return boolean that check if the operation is completed.
     * @see ComplexNumber, MyOperandCollection
     */
    @Override
    public boolean execute() {
        //save effective first and second value if is possible
        ComplexNumber value1 = collector.last();
        ComplexNumber value2 = collector.secondLast();
        if(value1 == null || value2 == null)
            return false;
        this.firstOperand = value1;
        this.secondOperand = value2;
        //remove the last two inserted operands
        collector.remove();
        collector.remove();
        //execute the addiction of the two removed operands
        ComplexNumber result = Calculator.addiction(firstOperand, secondOperand);
        //insert the result of the addiction in the collection
        collector.insert(result);
        return true;
    }
    
    /**
     * <p>
     * It execute the undo of the addiction operation removing the last inserted 
     * element that is the result of the operation, and pushes the two operands 
     * that have been involved in the addiction operation.
     * </p><!-- -->
     * @see ComplexNumber, MyOperandCollection
     */
    @Override
    public void undo() {
        //removes the last operand inserted that is the result of the addiction
        collector.remove();
        //pushes the two elements that have been added
        collector.insert(secondOperand);
        collector.insert(firstOperand);
    }
    
}

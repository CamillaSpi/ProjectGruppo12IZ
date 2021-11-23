/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelClassPackage;

import java.util.Stack;

/**
 * This is defined as an extension of the java Stack class adapted for acalculator use
 * container complexNumber.
 *
 * @author Gruppo 12 IZ
 * 
 */
public class OperandCollection extends Stack<ComplexNumber>{
    
    /**
    * It inserts (if the param is not null) at the top of the collection a complexNumber object passed as 
    * <p> <!-- -->
    * a parameter within the collection.
    * @param a complex number to enter
    * @see ComplexNumber
    */
    public void insert(ComplexNumber a){
        if(a != null)
            super.push(a);
        else
            System.out.println("I can't insert the complex number.");
    }
    /**
    * It removes and returns (if the collection is not empty) the complexNumber at the top of the collection.
    * <p> <!-- -->
    * @return the complexNumber removed or null
    * @see ComplexNumber
    */
    public ComplexNumber remove(){
        if(!super.empty())
            return super.pop();
        else
            System.out.println("The OperandCollection was just empty.");
        return null;
    }
    /**
    * It returns without remove (if the collection is not empty) the complexNumber at the top of the collection.
    * <p> <!-- -->
    * @return the top complexNumber or null
    * @see ComplexNumber
    */
    public ComplexNumber last(){
        if(!super.empty())
            return super.peek();
        else{
            System.out.println("There are no element inside the OperandCollection.");
        }
        return null;
    }
    /**
    * It returns the number of elements inside the collection.
    * <p> <!-- -->
    * @return the int length
    */
    public int collectionLength(){
        return super.elementCount;
    }

}

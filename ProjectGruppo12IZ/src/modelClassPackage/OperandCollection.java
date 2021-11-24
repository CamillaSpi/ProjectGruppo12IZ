/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelClassPackage;

import java.util.Iterator;
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

    public void stamp(){
        //get an iterator for the stack 
        System.out.println("Stack elements:"); 
        //traverse the stack using iterator in a loop and print each element 
        Iterator iterator = this.iterator(); 
        while(iterator.hasNext()){ 
            System.out.println(iterator.next() + " "); 
        } 
    } 
    
    /*@Override
    public Iterator<OperandCollection> iterator() {
        Iterator<OperandCollection> it = new Iterator<OperandCollection>() {

            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentIndex < collectionLength() && this[currentIndex] != null;
            }

            @Override
            public Type next() {
                return arrayList[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }*/
}

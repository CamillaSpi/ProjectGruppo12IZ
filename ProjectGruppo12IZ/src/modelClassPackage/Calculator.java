/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelClassPackage;

import java.math.BigDecimal;

/**
 *
 * @author Gruppo 12 IZ
 */
public class Calculator {
    
     /**
     *
     * executes the addiction of two Complex Numbers and return the sum, if these are not null, otherwise return null.
     *
     * @param a its contains the first complex number to add
     * @param b its contains the second complex number to add
     * 
     */
    static ComplexNumber addiction(ComplexNumber a, ComplexNumber b){
        if(a == null || b == null){
            System.out.println("Addiction cannot be performed");
            return null;
        }
        BigDecimal realres = a.getReal().add(b.getReal());
        BigDecimal imagres = a.getImaginary().add(b.getImaginary());
        ComplexNumber res = new ComplexNumber(realres, imagres);
        return res;
    }
    static ComplexNumber subtraction(ComplexNumber a, ComplexNumber b){
        return null;
    }
    static ComplexNumber multiplication(ComplexNumber a, ComplexNumber b){
        return null;
    }
    static ComplexNumber division(ComplexNumber a, ComplexNumber b){
        return null;
    }
    static ComplexNumber squareRoot(ComplexNumber a){
        return null;
    }
    
    /**
     *
     * calculate and return the invers of a Complex Numbers, if these is not null, otherwise return null.
     *<p> <!-- -->
     * @param a its contains the input complex number
     * 
     * @return return a ComplexNumber or null
     * @see ComplexNumber
     * 
     */
    static ComplexNumber invertSign(ComplexNumber a){
        if(a != null)
            return new ComplexNumber(a.getReal().negate(), a.getImaginary().negate());
        else
            System.out.println("opretion not possible: the input number is incorrect");
        return null;
    }
    
    
      /**
     *
     * calculate and return the conjugated of a Complex Numbers, if these is not null, otherwise return null.
     *<p> <!-- -->
     * @param a its contains the input complex number
     * 
     * @return return the conjugated ComplexNumber or null
     * @see ComplexNumber
     * 
     */
    static ComplexNumber conjugated(ComplexNumber a) {
         if(a != null)
            return new ComplexNumber(a.getReal(), a.getImaginary().negate());
        else
            System.out.println("Operation not possible: the input number is incorrect");
        return null;
    }

}

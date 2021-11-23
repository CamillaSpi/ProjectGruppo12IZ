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
     * executes the addiction of two Complex Numbers and returns the sum, if these are not null, otherwise returns null.
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
    /**
     *
     * executes the subtraction of two Complex Numbers and returns the result, if these are not null, otherwise returns null.
     *
     * @param a its contains the minuend complex number
     * @param b its contains the subtrahend  complex number
     * @return the result of the subtraction a - b
     * @see ComplexNumber
     * 
     * 
     */
    static ComplexNumber subtraction(ComplexNumber a, ComplexNumber b){
        if(a==null || b==null){
            System.out.println("Subtraction cannot be performed");
            return null;
        }
        BigDecimal real,imaginary;
        real = a.getReal().subtract(b.getReal());
        imaginary = a.getImaginary().subtract(b.getImaginary());
        ComplexNumber result = new ComplexNumber(real,imaginary);
        return result;
    }
    /**
     *
     * executes the multiplication of two Complex Numbers and returns the result, if these are not null, otherwise returns null; the result is calculated 
     * following the math formula: first = (a + ib) second = (c + id) result = (ac - bd) + i(ad + bc).
     *
     * @param first its contains the first factor complex number of the multiplication
     * @param second its contains the second factor complex number of the multiplication
     * @return the result of the multiplication first*second 
     * @see ComplexNumber
     * 
     */
    static ComplexNumber multiplication(ComplexNumber first, ComplexNumber second){
        if(first==null || second==null){
            System.out.println("Multiplication cannot be performed");
            return null;
        }
        BigDecimal real,imaginary;
        BigDecimal a = first.getReal();
        BigDecimal c = second.getReal();
        BigDecimal b = first.getImaginary();
        BigDecimal d = second.getImaginary();
        real = a.multiply(c).subtract(b.multiply(d));
        imaginary = a.multiply(d).add(b.multiply(c));
        ComplexNumber result = new ComplexNumber(real,imaginary);
        return result;
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

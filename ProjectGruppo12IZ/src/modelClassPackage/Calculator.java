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
     * Executes the addiction of two Complex Numbers and return the sum, if these are not null, otherwise return null.
     *
     * @param a the first complex number to add
     * @param b the second complex number to add
     * @return 
     */
    static ComplexNumber addiction(ComplexNumber a, ComplexNumber b){
        if(a == null || b == null){
            System.out.println("Addiction cannot be performed");
            return null;
        }
        BigDecimal realRes = a.getReal().add(b.getReal());
        BigDecimal imagRes = a.getImaginary().add(b.getImaginary());
        ComplexNumber res = new ComplexNumber(realRes, imagRes);
        return res;
    }
    static ComplexNumber subtraction(ComplexNumber a, ComplexNumber b){
        return null;
    }
    static ComplexNumber multiplication(ComplexNumber a, ComplexNumber b){
        return null;
    }
    
    
    
    
    
    /**
    * Executes the division of two complex number passed as parameters and return the result of the division, if these are not null and the second is different from zero, otherwise return null.
    * <p> <!-- -->
    * @param a the dividend of the division
    * @param b the divisor of the division
    * @return the result of the operation or null if the divisor is equal to zero or one of the input parameters is null
    * @see ComplexNumber
    */
    static ComplexNumber division(ComplexNumber a, ComplexNumber b){
        if(a == null || b == null){
            System.out.println("Division cannot be performed");
            return null;
        }
        if(new ComplexNumber("0","0").equals(b)){
            System.out.println("Division cannot be performed with divisor equal to 0");
            return null;
        }
        ComplexNumber coniugDivisor = Calculator.conjugated(b);
        ComplexNumber num = Calculator.multiplication(a, coniugDivisor);
        ComplexNumber div = Calculator.multiplication(b, coniugDivisor);
        BigDecimal realRes = num.getReal().divide(div.getReal());
        BigDecimal imagRes = num.getImaginary().divide(div.getReal());
        ComplexNumber res = new ComplexNumber(realRes, imagRes);
        return res;
    }
    
    
    static ComplexNumber squareRoot(ComplexNumber a){
        return null;
    }
    static ComplexNumber invertSign(ComplexNumber a){
        return null;
    }
    

}

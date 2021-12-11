/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelClassPackage;

import static java.lang.Math.PI;
import static java.lang.Math.atan;
import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import java.math.BigDecimal;
import java.math.MathContext;

/**
 *
 * @author Gruppo 12 IZ
 */
public class Calculator {

    /**
     *
     * Executes the addiction of two Complex Numbers and return the sum, if
     * these are not null, otherwise return null.
     *
     * @param a the first complex number to add
     * @param b the second complex number to add
     * @return
     */
    public static ComplexNumber addiction(ComplexNumber a, ComplexNumber b) {
        if (a == null || b == null) {
            return null;
        }
        BigDecimal realRes = a.getReal().add(b.getReal());
        BigDecimal imagRes = a.getImaginary().add(b.getImaginary());
        ComplexNumber res = new ComplexNumber(realRes, imagRes);
        return res;
    }

    /**
     *
     * Executes the subtraction of two Complex Numbers and returns the result,
     * if these are not null, otherwise returns null.
     *
     * @param a its contains the minuend complex number
     * @param b its contains the subtrahend complex number
     * @return the result of the subtraction a - b
     * @see ComplexNumber
     *
     *
     */
    public static ComplexNumber subtraction(ComplexNumber a, ComplexNumber b) {
        if (a == null || b == null) {
            return null;
        }
        BigDecimal real, imaginary;
        real = a.getReal().subtract(b.getReal());
        imaginary = a.getImaginary().subtract(b.getImaginary());
        ComplexNumber result = new ComplexNumber(real, imaginary);
        return result;
    }

    /**
     *
     * Executes the multiplication of two Complex Numbers and returns the
     * result, if these are not null, otherwise returns null; the result is
     * calculated following the math formula: first = (a + ib) second = (c + id)
     * result = (ac - bd) + i(ad + bc).
     *
     * @param first its contains the first factor complex number of the
     * multiplication
     * @param second its contains the second factor complex number of the
     * multiplication
     * @return the result of the multiplication first*second
     * @see ComplexNumber
     *
     */
    public static ComplexNumber multiplication(ComplexNumber first, ComplexNumber second) {
        if (first == null || second == null) {
            return null;
        }
        BigDecimal real, imaginary;
        BigDecimal a = first.getReal();
        BigDecimal c = second.getReal();
        BigDecimal b = first.getImaginary();
        BigDecimal d = second.getImaginary();
        real = a.multiply(c).subtract(b.multiply(d));
        imaginary = a.multiply(d).add(b.multiply(c));
        ComplexNumber result = new ComplexNumber(real, imaginary);
        return result;
    }

    /**
     * Executes the division of two complex number passed as parameters and
     * return the result of the division, if these are not null and the second
     * is different from zero, otherwise return null.
     * <p>
     * <!-- --> 
     * @param a the dividend of the division
     * @param b the divisor of the division
     * @return the result of the operation or null if the divisor is equal to
     * zero or one of the input parameters is null
     * @see ComplexNumber
     */
    public static ComplexNumber division(ComplexNumber a, ComplexNumber b) {
        if (a == null || b == null) {
            return null;
        }
        if (new ComplexNumber("0", "0").equals(b)) {
            return null;
        }

        ComplexNumber coniugDivisor = Calculator.conjugated(b);
        ComplexNumber num = Calculator.multiplication(a, coniugDivisor);
        ComplexNumber div = Calculator.multiplication(b, coniugDivisor);
        BigDecimal realRes = num.getReal().divide(div.getReal(), new MathContext(10));
        BigDecimal imagRes = num.getImaginary().divide(div.getReal(), new MathContext(10));
        ComplexNumber res = new ComplexNumber(realRes, imagRes);
        return res;
    }
     /**
     *
     * Calculate and return the square root of a Complex Number, if these is not
     * null, otherwise return null.
     * The function convert the complex number in trigonometric from but return the number in Cartesian form
     * <p>
     * <!-- --> 
     * @param a its contains the input complex number
     * @return return a ComplexNumber or null
     * @see ComplexNumber
     *
     */

    public static ComplexNumber squareRoot(ComplexNumber a) {
        if (a == null) {
            return null;
        }
        BigDecimal real = a.getReal();
        BigDecimal imaginary = a.getImaginary();
        double angle = 0;

        
        Double r = sqrt(real.pow(2).add(imaginary.pow(2)).doubleValue());
        if (real.compareTo(new BigDecimal("0")) == 0) {
            if (imaginary.compareTo(new BigDecimal("0")) == 0) {
                return new ComplexNumber(new BigDecimal(0), new BigDecimal(0));
            } else {
                if (imaginary.compareTo(new BigDecimal("0")) > 0) {
                    angle = PI / 2;
                } else {
                    angle = -PI / 2;
                }
            }
        } else {
            if (real.compareTo(new BigDecimal("0")) > 0) {
                if (imaginary.compareTo(new BigDecimal("0")) == 0) {
                    return new ComplexNumber(new BigDecimal(sqrt(real.doubleValue()), new MathContext(10)), new BigDecimal(0));
                }
                angle = atan2(imaginary.doubleValue(), real.doubleValue());

            } else {
                if (imaginary.compareTo(new BigDecimal("0")) == 0) {
                    return new ComplexNumber(new BigDecimal(0), new BigDecimal(sqrt(real.negate().doubleValue()), new MathContext(10)));
                } else {
                    if (imaginary.compareTo(new BigDecimal("0")) > 0) {
                        angle = atan2(imaginary.doubleValue(), real.doubleValue()) + PI;
                    } else {
                        angle = atan2(imaginary.doubleValue(), real.doubleValue()) - PI;
                    }
                    //if the real part is negative, switch imaginary and real
                    BigDecimal imaginaryResult = new BigDecimal(sqrt(r) * (cos((angle + 2 * PI) / 2)), new MathContext(10));
                    BigDecimal realResult = new BigDecimal(sqrt(r) * (sin((angle + 2 * PI) / 2)), new MathContext(10));
                    return new ComplexNumber(realResult, imaginaryResult);
                }

            }
        }
        BigDecimal realResult = new BigDecimal(sqrt(r) * (cos((angle + 2 * PI) / 2)), new MathContext(10));
        BigDecimal imaginaryResult = new BigDecimal(sqrt(r) * (sin((angle + 2 * PI) / 2)), new MathContext(10));
        return new ComplexNumber(realResult, imaginaryResult);
    }

    /**
     * Calculate and return the reverse of a Complex Number, if these is not
     * null, otherwise return null.
     * <p>
     * <!-- --> 
     * @param a its contains the input complex number
     * @return return a ComplexNumber or null
     * @see ComplexNumber
     *
     */
    public static ComplexNumber invertSign(ComplexNumber a) {
        if (a != null) {
            return new ComplexNumber(a.getReal().negate(), a.getImaginary().negate());
        }
        return null;
    }

    /**
     * Calculate and return the conjugated of a Complex Numbers, if these is not
     * null, otherwise return null.
     * <p>
     * <!-- -->
     * @param a its contains the input complex number
     * @return return the conjugated ComplexNumber or null
     * @see ComplexNumber
     *
     */
    public static ComplexNumber conjugated(ComplexNumber a) {
        if (a != null) {
            return new ComplexNumber(a.getReal(), a.getImaginary().negate());
        }
        return null;
    }
    
    /**
     * Calculates and returns the module of a Complex Number, if it is not
     * null in its parts, otherwise returns null.
     * <p>
     * <!-- --> 
     *
     * @param num it contains the input complex number
     * @return return the module of a ComplexNumber or null
     * @see ComplexNumber
     *
     */
    public static ComplexNumber mod(ComplexNumber num) {
        if (num != null && num.getReal() != null && num.getImaginary() != null) {
            MathContext mc = new MathContext(10);
            BigDecimal result = num.getReal().pow(2,mc).add(num.getImaginary().pow(2,mc),mc);
            Double mod = sqrt(result.doubleValue());
            return new ComplexNumber(new BigDecimal(mod,mc),new BigDecimal(0));
        }
        return null;
    }

    /**
     * Calculates and returns the argument of a Complex Number, if it is not
     * null in its part or its parts are zero (in this case the arg is not defined), otherwise returns null.
     * <p>
     * <!-- --> 
     *
     * @param num it contains the input complex number
     * @return return the argument of a ComplexNumber or null
     * @see ComplexNumber
     *
     */
    public static ComplexNumber arg(ComplexNumber num) {
        if (num != null && num.getReal() != null && num.getImaginary() != null && (!num.getReal().equals(0) || !num.getImaginary().equals(0))) {
            MathContext mc = new MathContext(10);
            BigDecimal a = num.getReal();
            BigDecimal b = num.getImaginary();
            if (a.doubleValue() == 0 && b.doubleValue() > 0)
                return new ComplexNumber(new BigDecimal(PI/2,mc),new BigDecimal(0));
            else
                if (a.doubleValue() == 0 && b.doubleValue() < 0)
                    return new ComplexNumber(new BigDecimal(-PI/2,mc),new BigDecimal(0));
                else
                    if (a.doubleValue() > 0)
                        if(b.doubleValue() < 0)
                            return new ComplexNumber(new BigDecimal(-atan((b.doubleValue()*(-1))/a.doubleValue()),mc), new BigDecimal(0));
                        else
                            return new ComplexNumber(new BigDecimal(atan(b.doubleValue()/a.doubleValue()),mc), new BigDecimal(0));
                    else
                        if (a.doubleValue() < 0 && b.doubleValue() >= 0)
                            return new ComplexNumber(new BigDecimal(-atan(b.doubleValue()/(a.doubleValue())*(-1)) + PI,mc), new BigDecimal(0));
                        else
                            if (a.doubleValue() < 0 && b.doubleValue() < 0)
                                return new ComplexNumber(new BigDecimal(atan((b.doubleValue()*(-1))/(a.doubleValue()*(-1))) - PI,mc), new BigDecimal(0));
        }
        return null;
    }
}

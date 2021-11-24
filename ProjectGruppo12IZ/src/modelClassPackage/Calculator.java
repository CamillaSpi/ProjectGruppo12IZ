/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelClassPackage;

import static java.lang.Math.PI;
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
    static ComplexNumber addiction(ComplexNumber a, ComplexNumber b) {
        if (a == null || b == null) {
            System.out.println("Addiction cannot be performed");
            return null;
        }
        BigDecimal realRes = a.getReal().add(b.getReal());
        BigDecimal imagRes = a.getImaginary().add(b.getImaginary());
        ComplexNumber res = new ComplexNumber(realRes, imagRes);
        return res;
    }

    /**
     *
     * executes the subtraction of two Complex Numbers and returns the result,
     * if these are not null, otherwise returns null.
     *
     * @param a its contains the minuend complex number
     * @param b its contains the subtrahend complex number
     * @return the result of the subtraction a - b
     * @see ComplexNumber
     *
     *
     */
    static ComplexNumber subtraction(ComplexNumber a, ComplexNumber b) {
        if (a == null || b == null) {
            System.out.println("Subtraction cannot be performed");
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
     * executes the multiplication of two Complex Numbers and returns the
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
    static ComplexNumber multiplication(ComplexNumber first, ComplexNumber second) {
        if (first == null || second == null) {
            System.out.println("Multiplication cannot be performed");
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
     * <!-- --> @param a the dividend of the division
     *
     * @param b the divisor of the division
     * @return the result of the operation or null if the divisor is equal to
     * zero or one of the input parameters is null
     * @see ComplexNumber
     */
    static ComplexNumber division(ComplexNumber a, ComplexNumber b) {
        if (a == null || b == null) {
            System.out.println("Division cannot be performed");
            return null;
        }
        if (new ComplexNumber("0", "0").equals(b)) {
            System.out.println("Division cannot be performed with divisor equal to 0");
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
     * calculate and return the square root of a Complex Number, if these is not
     * null, otherwise return null.
     * The function convert the complex number in trigonometric but return the number in Cartesian form
     * <p>
     * <!-- --> @param a its contains the input complex number
     *
     * @return return a ComplexNumber or null
     * @see ComplexNumber
     *
     */

    static ComplexNumber squareRoot(ComplexNumber a) {
        if (a == null) {
            System.out.println("square Root cannot be performed");
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
     *
     * calculate and return the invers of a Complex Number, if these is not
     * null, otherwise return null.
     * <p>
     * <!-- --> @param a its contains the input complex number
     *
     * @return return a ComplexNumber or null
     * @see ComplexNumber
     *
     */
    static ComplexNumber invertSign(ComplexNumber a) {
        if (a != null) {
            return new ComplexNumber(a.getReal().negate(), a.getImaginary().negate());
        } else {
            System.out.println("opretion not possible: the input number is incorrect");
        }
        return null;
    }

    /**
     *
     * calculate and return the conjugated of a Complex Numbers, if these is not
     * null, otherwise return null.
     * <p>
     * <!-- --> @param a its contains the input complex number
     *
     * @return return the conjugated ComplexNumber or null
     * @see ComplexNumber
     *
     */
    static ComplexNumber conjugated(ComplexNumber a) {
        if (a != null) {
            return new ComplexNumber(a.getReal(), a.getImaginary().negate());
        } else {
            System.out.println("Operation not possible: the input number is incorrect");
        }
        return null;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelClassPackage;

import java.math.BigDecimal;
import java.util.regex.Pattern;

/**
 *
 * @author Gruppo 12 IZ
 *
 */
public class ComplexNumber {

    private final BigDecimal real;
    private final BigDecimal imaginary;

    /**
     *
     * Initialies a new istance of the ComplexNumber class.
     *
     * @param real its contains the real part of the complex number
     * @param imaginary its contains the imaginary part of the complex number
     * (without j)
     */
    public ComplexNumber(BigDecimal real, BigDecimal imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    /**
     * Initialies a new istance of the ComplexNumber class.
     *
     * @param real this string contains the real part of the complex number
     * @param imaginary this string contains the imaginary part of the complex
     * number (without j)
     */
    public ComplexNumber(String real, String imaginary) {
        this.real = new BigDecimal(real);
        this.imaginary = new BigDecimal(imaginary);
    }

    /**
     *
     * This is a static class that analyze the string and if the strings is in
     * Cartesian form return an ComplexNumber object
     *
     * @param complexNumber the string to analyze
     * @return a ComplexNumber if the string is in Cartesian form otherwise null
     */
    public static ComplexNumber create(String complexNumber) {

        Pattern complexNumberPattern;
        if (complexNumber == null) {
            System.out.println("The string is empty");
            return null;
        }
        //check if the last elements is a j or a number otherwise there is a problem
        if (complexNumber.charAt(complexNumber.length() - 1) != 'j' && (complexNumber.charAt(complexNumber.length() - 1) < '0' && complexNumber.charAt(complexNumber.length() - 1) > '9')) {
            System.out.println("The last elements is not a j or a number");
            return null;
        }
        //Check the first value on the 
        if (complexNumber.charAt(0) == '+' || complexNumber.charAt(0) == '-') {
            // it contains  +/-
            if (complexNumber.charAt(complexNumber.length() - 1) == 'j') {
                // its contains j 
                if (complexNumber.substring(1).contains("+") || complexNumber.substring(1).contains("-")) {
                    // it contains - x - j
                    complexNumberPattern = Pattern.compile("{1,}[+-][0-9]{1,}[+-][0-9]{1,}j");
                    if (complexNumberPattern.matcher(complexNumber).matches()) {
                        String realStr = complexNumber.charAt(0) + complexNumber.substring(1).split("[+-]")[0];
                        return new ComplexNumber(realStr, complexNumber.substring(realStr.length(), complexNumber.length() - 1));
                    }
                } else {
                    //it contains +- j
                    complexNumberPattern = Pattern.compile("{1,}[+-][0-9]{1,}j");
                    if (complexNumberPattern.matcher(complexNumber).matches()) {
                        return new ComplexNumber("0", complexNumber.substring(0, complexNumber.length() - 1));
                    }
                }
            } else {
                //contains +- x
                complexNumberPattern = Pattern.compile("{1,}[+-][0-9]");
                if (complexNumberPattern.matcher(complexNumber).matches()) {
                    return new ComplexNumber(complexNumber, "0");
                }
            }
        } else {
            //its dont start with +/-
            if (complexNumber.charAt(complexNumber.length() - 1) == 'j') {
                // its contains j 
                if (complexNumber.substring(1).contains("+") || complexNumber.substring(1).contains("-")) {
                    // it contains x - j
                    complexNumberPattern = Pattern.compile("[0-9]{1,}[+-][0-9]{1,}j");
                    if (complexNumberPattern.matcher(complexNumber).matches()) {
                        return new ComplexNumber(complexNumber.substring(0).split("[+-]")[0], complexNumber.substring(0, complexNumber.length() - 1).split("[+-]")[1]);
                    }

                } else {
                    //it contains j
                    complexNumberPattern = Pattern.compile("[0-9]{1,}j");
                    if (complexNumberPattern.matcher(complexNumber).matches()) {
                        return new ComplexNumber("0", complexNumber.substring(0, complexNumber.length() - 1));
                    }

                }
            } else {
                //it contains x
                complexNumberPattern = Pattern.compile("{1,}[0-9]");
                if (complexNumberPattern.matcher(complexNumber).matches()) {
                    return new ComplexNumber(complexNumber, "0");
                }

            }
        }
        return null;
    }

    /**
     *
     * @return the real part of the complex number
     */
    public BigDecimal getReal() {
        return real;
    }

    /**
     *
     * @return the real part of the complex number
     */
    public BigDecimal getImaginary() {
        return imaginary;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ComplexNumber other = (ComplexNumber) obj;

        return this.real.compareTo(other.getReal()) == 0 && this.imaginary.compareTo(other.getImaginary()) == 0;
    }

    @Override
    public String toString() {
        return "ComplexNumber{" + "real=" + real + ", imaginary=" + imaginary + '}';
    }

}

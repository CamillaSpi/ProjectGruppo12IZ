/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelClassPackage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author nando
 * @time Nov 22, 2021 4:44:07 PM
 */
public class ComplexNumber {

    private final double real;
    private final double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public static ComplexNumber create(String complexNumber) {

        Pattern complexNumberPattern;
        double real = 0;
        double imaginary = 0;
        Boolean flag = false;
        if (complexNumber == null){
            System.out.println("The string is empty");
            return null;
        }
        if (complexNumber.charAt(complexNumber.length()-1) != 'j' && (complexNumber.charAt(complexNumber.length()-1) < '0' && complexNumber.charAt(complexNumber.length()-1) > '9')) {
            System.out.println("The last elements is not a j or a number");
            return null;
        }

        if (complexNumber.charAt(0) == '+' || complexNumber.charAt(0) == '-') {
            // it contains  -
            if (complexNumber.charAt(complexNumber.length() - 1) == 'j') {
                // its contains - j 
                if (complexNumber.substring(1).contains("+") || complexNumber.substring(1).contains("-")) {
                    // it contains - x - j
                    complexNumberPattern = Pattern.compile("{1,}[+-][0-9]{1,}[+-][0-9]{1,}j");
                    if (complexNumberPattern.matcher(complexNumber).matches()) {
                        String realSTr = complexNumber.charAt(0) + complexNumber.substring(1).split("[+-]")[0];
                        real = Double.parseDouble(realSTr);
                        imaginary = Double.parseDouble(complexNumber.substring(realSTr.length(), complexNumber.length() - 1));
                    
                        flag = true;
                    }
                } else {
                    //it contains - j
                    complexNumberPattern = Pattern.compile("{1,}[+-][0-9]{1,}j");
                    if (complexNumberPattern.matcher(complexNumber).matches()) {
                        imaginary = Double.parseDouble(complexNumber.substring(0, complexNumber.length() - 1));
                        flag = true;
                    }
                }
            } else {
                complexNumberPattern = Pattern.compile("{1,}[+-][0-9]");
                if (complexNumberPattern.matcher(complexNumber).matches()) {
                    real = Double.parseDouble(complexNumber);
                    flag = true;
                }
            }
        } else {
            if (complexNumber.charAt(complexNumber.length() - 1) == 'j') {
                // its contains j 
                if (complexNumber.substring(1).contains("+") || complexNumber.substring(1).contains("-")) {
                    // it contains x - j
                    complexNumberPattern = Pattern.compile("[0-9]{1,}[+-][0-9]{1,}j");
                    if (complexNumberPattern.matcher(complexNumber).matches()) {
                        real = Double.parseDouble(complexNumber.substring(0).split("[+-]")[0]);
                        imaginary = Double.parseDouble(complexNumber.substring(0, complexNumber.length() - 1).split("[+-]")[1]);
                        flag = true;
                    }
                } else {
                    //it contains j
                    complexNumberPattern = Pattern.compile("[0-9]{1,}j");
                    if (complexNumberPattern.matcher(complexNumber).matches()) {
                        imaginary = Double.parseDouble(complexNumber.substring(0, complexNumber.length() - 1));
                        flag = true;
                    }
                }
            } else {
                complexNumberPattern = Pattern.compile("{1,}[0-9]");
                if (complexNumberPattern.matcher(complexNumber).matches()) {
                    real = Double.parseDouble(complexNumber);
                    flag = true;
                }
            }
        }
        if (flag) {
            return new ComplexNumber(real, imaginary);
        } else {
            System.out.println("Not in Cartesian form");
            return null;
        }
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
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
        if (Double.doubleToLongBits(this.real) != Double.doubleToLongBits(other.real)) {
            return false;
        }
        return Double.doubleToLongBits(this.imaginary) == Double.doubleToLongBits(other.imaginary);
    }



    @Override
    public String toString() {
        return "ComplexNumber{" + "real=" + real + ", imaginary=" + imaginary + '}';
    }

}

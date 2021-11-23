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

    private final float real;
    private final float imaginary;

    public ComplexNumber(float real, float imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }


    public static ComplexNumber create(String complexNumber) {
        return null;
    }

    public float getReal() {
        return real;
    }

    public float getImaginary() {
        return imaginary;
    }

    @Override
    public String toString() {
        return "ComplexNumber{" + "real=" + real + ", imaginary=" + imaginary + '}';
    }

   
}

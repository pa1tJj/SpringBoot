package com.jone.heath.heathy;

import com.jone.heath.bmi.core.BmiCalculator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BmiCalculator b = new BmiCalculator();
        System.out.print("ti'nh ti? le^.:" + b.getBmi(55, 1.65));
    }
}

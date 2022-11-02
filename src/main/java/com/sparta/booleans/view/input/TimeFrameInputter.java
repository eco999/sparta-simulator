package com.sparta.booleans.view.input;

import com.sparta.booleans.exceptions.InvalidTimeFrameMonthException;
import com.sparta.booleans.exceptions.NegativeIntInputException;
import com.sparta.booleans.utility.logging.CustomLoggerConfiguration;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

//how many years and dates they want

public class TimeFrameInputter implements Inputable{
    public Logger logger = CustomLoggerConfiguration.myLogger;
    //how many years and dates they want
    @Override
    public int getInputInt() {
        Scanner scanner = new Scanner(System.in);
        int input = -1;
        try{
            input = scanner.nextInt();
            if(input < 0){
                throw new NegativeIntInputException();
            }
        }catch (NegativeIntInputException e){
            logger.log(Level.WARNING,e.getMessage());
            System.out.println("Re-enter a number: ");
            input = getInputInt();
        }
        return input;
    }

    @Override
    public int getTotalMonths() {
        System.out.println("Enter Years and months for simulation");
        return  (getYears()*12) + getMonths();
    }

    public int getTotalMonths(int years, int months) {
        System.out.println("Enter Years and months for simulation");
        return  (years * 12) + months;
    }

    private int getYears() {
        System.out.println("Enter the number of years: ");
        return getInputInt();
    }

    private int getMonths() throws InvalidTimeFrameMonthException {
        System.out.println("Enter the number of months: ");
        int input = 999;
        try{
            input = getInputInt();
            if(input > 11) {
                throw new InvalidTimeFrameMonthException();
            }
        }catch (InvalidTimeFrameMonthException e){
            logger.log(Level.WARNING,e.getMessage());
            input = getMonths();
        }
        return input;

    }
}

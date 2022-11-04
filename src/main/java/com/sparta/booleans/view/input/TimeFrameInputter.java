package com.sparta.booleans.view.input;

import com.sparta.booleans.exceptions.InvalidTimeFrameMonthException;
import com.sparta.booleans.exceptions.InvalidIntInputException;

import java.util.Scanner;

//how many years and dates they want

public class TimeFrameInputter implements Inputable{
    //how many years and dates they want
    @Override
    public int getInputInt() {
        Scanner scanner = new Scanner(System.in);
        int input = -1;
        try{
            input = scanner.nextInt();
            if(input < 1){
                throw new InvalidIntInputException();
            }
        }catch (InvalidIntInputException e){
            throw e;
            /*System.out.println(e.getMessage());
            System.out.println("Re-enter a number: ");
            input = getInputInt();*/
        }
        return input;
    }



    // Asks user for number of years and returns the months
    @Override
    public int getTotalMonths() {
        return  (getYears()*12);
    }


    /**
     * Asks the user for a choice of report.
     * @return int 1 for yearly breakdown, 2 for final summary
     */
    @Override
    public int getOutputChoice() {
        System.out.println("""
                Select a choice for the report,\s
                1: A yearly breakdown,\s
                2: A simulation summary""");
        int input = 999;
        try{
            input = getInputInt();
            if(input > 2) {
                throw new InvalidIntInputException();
            }
        }catch (InvalidIntInputException e){
            System.out.println(e.getMessage());
            input = getMonths();
        }
        return input;
    }



    private int getYears() {
        System.out.println("Enter the number of years: ");
        return getInputInt();
    }

    public int getMonths() throws InvalidTimeFrameMonthException {
        System.out.println("Enter the number of months: ");
        int input = 999;
        try{
            input = getInputInt();
            if(input > 11) {
                throw new InvalidTimeFrameMonthException();
            }
        }catch (InvalidTimeFrameMonthException e){
            throw e;
            /*System.out.println(e.getMessage());
            input = getMonths();*/
        }
        return input;

    }
}

package com.pfc;

import java.util.List;
import java.util.Scanner;

public class Main { 
    public static void main(String[] args) {
        runProgram();


    }

    public static void runProgram(){
        int number = getNumber();
        List<Int>
    }
    public static void numberError(String errorType){
        System.out.println("*");
        System.out.println("*******************");
        System.out.println("*");
        System.out.println(errorType);
        System.out.println("* Listen to me!");
        System.out.println("* Now lets try again... A Number less that 1 Billion and greater than 0!");
    }

    public static int getNumber(){
        Scanner sc = new Scanner(System.in);
        boolean isValid = false;
        System.out.println("*");
        System.out.println("*******************");
        System.out.println("*");
        System.out.println("* Let's start this Boy O's!");
        int number = 0;
        while(!isValid){
            System.out.println("* Give me a number between 1 and not a Billion.");
            System.out.println("* Enter Number: ");
            try{
                number = Integer.parseInt(sc.nextLine());
                if(number < 1){
                    numberError(" that is GREATER than 0!");
                }else if(number == 1000000000){
                    numberError("* Didn't you listen? I said a NUMBER that is NOT a Billion!");
                }else if(number > 1000000000){
                    numberError("Oh good for you. You found a loop hole. I didn't say anything about not greater than a Billion. Now try again with one less than a Billion.");
                }else{
                    isValid = true;
                }
            }
            catch (NumberFormatException ex){
                numberError("* Didn't you listen? I said a NUMBER. Not a Symbol or letter");
            }
        }
        return number;
    }

    public static int[] proccessFactors(int number){
        System.out.println("Yup");
    }


}
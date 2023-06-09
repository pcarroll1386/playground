package com.pfc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main { 
    public static void main(String[] args) {
        runProgram();


    }

    public static void runProgram(){
        int number = getNumber();
        List<Integer> factors = processFactors(number);
        boolean isPrime = checkIfPrime(factors);
        reportFindings(number, factors, isPrime);
    }
    public static void numberError(String errorType){
        System.out.println("*");
        System.out.println("*******************");
        System.out.println("*");
        System.out.println(errorType);
        System.out.println("*");
        System.out.println("* Listen to me!");
        System.out.println("*");
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
            System.out.println("*");
            System.out.println("* Give me a number between 1 and not a Billion.");
            System.out.println("*");
            System.out.println("* Enter Number: ");
            try{
                number = Integer.parseInt(sc.nextLine());
                if(number < 1){
                    System.out.println("*");
                    numberError("* Didn't you listen? I said a NUMBER that is GREATER than 0!");
                }else if(number == 1000000000){
                    System.out.println("*");
                    numberError("* Didn't you listen? I said a NUMBER that is NOT a Billion!");
                }else if(number > 1000000000){
                    System.out.println("*");
                    numberError("Oh good for you. You found a loop hole. I didn't say anything about not greater than a Billion. Now try again with one less than a Billion.");
                }else{
                    isValid = true;
                }
            }
            catch (NumberFormatException ex){
                String message = ex.getMessage();
                String[] messageParts = message.split(":");
                message = messageParts[1];
                message = message.replace("\"", "").strip();
                try{
                    float convertedMessage = Float.parseFloat(message);
                    numberError("* Oh haha... very funny, you KNOW I meant whole number. come on!");
                }catch (NumberFormatException e){
                    System.out.println("*");
                    numberError("* Didn't you listen? I said a NUMBER. Not a Symbol or letter");
                }
            }
        }
        System.out.println("*");
        return number;
    }

    public static List<Integer> processFactors(int number){
        System.out.println("Processing: Please wait!");
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i < number; i++) {
            int result = number % i;
            if(result == 0){
                factors.add(i);
            }
        }
        return factors;
    }

    public static boolean checkIfPrime(List<Integer> factors){
        System.out.println("*");
        System.out.println("* Processing Complete Loading results.");
        boolean isPrime;
        if(factors.size() >= 3){
            isPrime = false;
        }else{
            isPrime = true;
        }
        return isPrime;
    }

    public static void reportFindings(int number, List<Integer> factors, boolean isPrime){
        System.out.println("*");
        System.out.println("* I have crunched the numbers... My word is gold.");
        System.out.println("*");
        System.out.println("* You entered: " + number + ".");
        System.out.println("*");
        if(number < 10){
            System.out.println("* Wow... you really stretched for that one didn't you?");
            System.out.println("*");
        } else if (number > 999999) {
            System.out.println("* Eee Gods! I know I said less than a Billion but shit!");
            System.out.println("*");
        }

        if(isPrime){
            System.out.println("* So fun news first! " + number + " is a Prime Number! Woot woot!");
            System.out.println("*");
            System.out.println("* And because it is a prime number I am not going to list all the factors. Figure it out.");
            System.out.println("*");
        }else {
            System.out.println("* Well I hate to break it to you but, " + number + " is not a prime number");
            System.out.println("*");
            System.out.println("* I know... There, there, poor thing.");
            System.out.println("*");
            System.out.println("* Now for the fun news. The following are all factors of " + number + "!");
            Collections.sort(factors);
            for (Integer n : factors) {
                System.out.println("*");
                System.out.println("* " + n);
            }
            System.out.println("*");
        }
        System.out.println("* Well That is it... Go away.");
        System.out.println("*******************");
    }

}
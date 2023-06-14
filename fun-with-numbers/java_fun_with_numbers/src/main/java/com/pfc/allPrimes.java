package com.pfc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class allPrimes {
    public static void main(String[] args) {
        start(999999999);

    }

    private static Result processOdds(int n, List<Integer> primes){
        double squared = Math.sqrt(n);
        squared = Math.floor(squared);
        Result result = new Result();
        int range = (int) squared;
        for (int i = 3; i <= range; i +=2) {
            result = processNumber(n, i, primes);
            n = result.getNumber();
        }
        if(n > 2){
            result.addPrime(n);
        }
        return result;
    }

    private static Result processNumber(int n, int i, List<Integer> primes){
        boolean isRunning = true;
        while(isRunning){
            if(n % i == 0){
                primes.add(i);
                n = n/i;
            }else{
                isRunning = false;
            }
        }
        Result result = new Result();
        result.setNumber(n);
        result.setPrimes(primes);
        return result;
    }

    private static void start(int number){
        List<Integer> primes = new ArrayList<>();
        Result result = processNumber(number, 2, primes);
        result = processOdds(result.getNumber(), result.getPrimes());
        System.out.println(result.getPrimeSet());
        System.out.println(result.getPrimes());
    }
    private static class Result{
        private int number;
        private List<Integer> primes;


        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public List<Integer> getPrimes() {
            return primes;
        }

        public void setPrimes(List<Integer> primes) {
            this.primes = primes;
        }

        public void addPrime(int i) {
            this.primes.add(i);
        }

        public HashSet<Integer> getPrimeSet() {
            return new HashSet<Integer>(this.getPrimes());
        }
    }
}

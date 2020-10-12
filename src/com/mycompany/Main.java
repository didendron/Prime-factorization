package com.mycompany;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static long firstFactor;
    private static long secondFactor;
    private static StringBuilder factorization = new StringBuilder();
    private static ArrayList<Long>numbers=new ArrayList<>();


    public static void main(String[] args) throws InterruptedException {

        System.out.println("Enter a natural number:");
        Scanner in=new Scanner(System.in);
        long number=in.nextLong();
        factorization.append(number).append("=").append(1);
        factorize(number);

        System.out.println(factorization);
        Thread.sleep(30000);
    }


    public static StringBuilder factorize(long number) {


        if (isPrime(number)) {
            factorization.append("*").append(number);
            return factorization;
        } else {
            numbers.add(secondFactor);
            numbers.add(firstFactor);

            factorize(numbers.remove(numbers.size()-1));
            factorize(numbers.remove(numbers.size()-1));
            return factorization;
        }
    }

    public static boolean isPrime(long number) {
        if (number == 2) return true;
        if (number == 3) return true;
        if ((number % 2) == 0) {
            firstFactor=2;
            secondFactor=number/2;
            return false;
        } else {
            long lessFactor = 3;
            boolean condition = true;
            int counter = -1;
            while (condition) {
                long greaterFactor = number / lessFactor;
                while ((greaterFactor % 2 == 0) || ((greaterFactor % 3 == 0) && (lessFactor > 3))
                        || ((greaterFactor % 5 == 0) && (lessFactor > 5)) || ((greaterFactor % 7 == 0) && (lessFactor > 7))
                ) {
                    counter++;
                    if (lessFactor == 5) counter = 0;
                    if (counter == 0) {
                        lessFactor += 2;
                        greaterFactor = number / lessFactor;
                    } else {
                        lessFactor += 4;
                        greaterFactor = number / lessFactor;
                        counter = -1;
                    }

                }


                if (greaterFactor * lessFactor == number) {
                    firstFactor=lessFactor;
                    secondFactor=greaterFactor;
                    return false;
                }
                counter++;
                if (lessFactor == 5) counter = 0;
                if (counter == 0) {
                    lessFactor += 2;
                } else {
                    lessFactor += 4;
                    counter = -1;
                }


                while ((lessFactor % 3 == 0) || ((lessFactor != 5) && (lessFactor % 5 == 0)) || ((lessFactor != 7) && (lessFactor % 7 == 0))
                        || ((lessFactor != 11) && (lessFactor % 11 == 0)) || ((lessFactor != 13) && (lessFactor % 13 == 0))
                        || ((lessFactor != 17) && (lessFactor % 17 == 0)) || ((lessFactor != 19) && (lessFactor % 19 == 0))
                        || ((lessFactor != 23) && (lessFactor % 23 == 0))

                ) {
                    counter++;
                    if (lessFactor == 5) counter = 0;
                    if (counter == 0) {
                        lessFactor += 2;
                    } else {
                        lessFactor += 4;
                        counter = -1;
                    }


                }


                if (greaterFactor < lessFactor) condition = false;
            }
            return true;
        }
    }

}

package com.zackparr;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String fileName = "primenumbers.txt";

        WriteFile data = new WriteFile(fileName, true);

        Scanner scan = new Scanner(System.in);
        int start;
        int end;
        int counter = 0;

        do {
            System.out.println("Please enter a starting integer: ");
            start = scan.nextInt();
        }while (start<1);

        do {
            System.out.println("Please enter an ending integer: ");
            end = scan.nextInt();
        }while (end<start);

        if(start<=2){
            System.out.println("2");
            try {
                data.writeToFile("2");
            } catch (IOException e){
                System.out.println(e.getMessage());
            }
            counter = 1;
        }

        if(start%2==0) start++;
        if(end%2==0) end--;

        for(int i=start; i<=end; i+=2){
            if(isPrime(i)){
                System.out.println(String.valueOf(i));
                try {
                    data.writeToFile(String.valueOf(i));
                } catch (IOException e){
                    System.out.println(e.getMessage());
                }
                counter++;
            }
        }

        System.out.println(String.valueOf(counter) + " prime numbers.");
    }

    private static boolean isPrime(int n){
        if(n==1) return false;

        for(int i=3; i<=Math.sqrt(n); i+=2){
            if(n%i==0) return false;
        }
        return true;
    }
}

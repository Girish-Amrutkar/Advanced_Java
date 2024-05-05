package com.jspiders.springrest.controller;
import java.util.Scanner;

public class Palindrome { // Corrected class name
    
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter a string to check if it's a palindrome:");
        String input = scanner.nextLine();
        
        if (isPalindrome(input.toLowerCase())) {
            System.out.println("The string \"" + input + "\" is a palindrome.");
        } else {
            System.out.println("The string \"" + input + "\" is not a palindrome.");
        }
        
        scanner.close();
    }
}

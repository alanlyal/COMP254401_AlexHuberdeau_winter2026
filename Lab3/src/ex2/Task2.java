package ex2;

import java.util.Scanner;
public class Task2 {
    public static boolean Palindrome(String word, int high, int low) {
        if (low >= high) {
            return true;
        }
        if (word.charAt(low) != word.charAt(high)) {//checks to see if the first letter is not the same as the last letter
            return false;
        }
        return Palindrome(word, high - 1, low + 1);//check the next letters that are inside the word
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter a word and ill check if its a palindrom: ");
        String input = scan.nextLine();
        if(Palindrome(input, input.length()-1,0))// checks the last position and first position using the function palindrom
        {
            System.out.println(input+ " is a palindrom");
        }
        else {
            System.out.println(input+ " is not palindrom");
        }
        scan.close();
    }
//
}

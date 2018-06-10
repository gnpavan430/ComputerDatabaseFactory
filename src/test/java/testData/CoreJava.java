package testData;

import java.util.Scanner;

public class CoreJava {
    static int number,reverseNumber,sum=0,temp;
    public static void main(String args[]){
        System.out.println("Enter a number. We will let you know whether it is a Palindrome or not");
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        System.out.println("Entered number is"+number);
        temp=number;
        while(number>0){
            reverseNumber=number%10;
            sum = (sum*10)+reverseNumber;
            number=number/10;

        }
        if(sum==temp){
            System.out.println("Number is a palindrome");
        }
        else{
            System.out.println("Number is not a Palindrome");
        }
    }
}

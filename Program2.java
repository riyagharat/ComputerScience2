// Riya Gharat        N00901846
// 09/04/2015

/* Prompt: Construct ONE program solving  5.24 and  5.25 on pages 195 and 196  of the book, 
        The input will be a bit different than what the author of the book specifies.
        I want it to be single odd positive int, say  10001 (which will simply be
        the last denominator used in both calculations--be careful the last denominator
        ,not the last value of i--so for problem 5.24 that means the last fraction
        is 9999/10001, not 97/99. Of course for problem 5.25 you need to determine the
        last fraction by determining the appropriate last value of i.) Use formatting so that there
        are 12 digits diplayed after the decimal point for each answer. Remember, just a single int should
        display (output) the answers to BOTH problems.

   Prompt 5.24: Write a program to sum the series
   Prompt 5.25: Approximate Pi with the following series.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.lang.*;

public class Program2{
   public static void main(String Args[]){
   
      //Create a String variable for input
      Scanner input = new Scanner(System.in);
      
      System.out.print("Please enter a positive, odd integer: ");
      int num = input.nextInt();

      //instantiate and declare sum of series variable
      double sumOfSeries = 0;
      
      //for loop that runs from 1 to value and sums the values accordingly      
      for(int i = 1; i <= num; i+=2){
         sumOfSeries += (double)i/(i+2);
      }
      
      //Prints out value to screen
      DecimalFormat numberFormat = new DecimalFormat("#.000000000000");            
      System.out.println("Sum of A Series: " + numberFormat.format(sumOfSeries));
      
      //instantiate and declare approximationg of PI variable
      double approximatePI = 0;
      
      //New value for num
      int newNum = ((num+1)/2);
      
      //for loop that runs from 1 to newNum where newNum produced the number num in the denominator
      for(int i = 1; i <= 501; i++){
         approximatePI += (double)((Math.pow(-1,i+1))/((2*i)-1));
      }
      
      //Prints out value to screen
      DecimalFormat numberFormat2 = new DecimalFormat("#.000000000000");
      System.out.println("Approximate Value of PI: " + numberFormat2.format(4*approximatePI));
      
      }
}
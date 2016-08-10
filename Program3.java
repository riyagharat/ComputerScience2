// Riya Gharat        N00901846
// 09/26/2015

/* Prompt: 
1.    Write a class named Strict that has the method equals as specified in the book on page 316.
2.    The class named Strict should also have a method 
      public static int  howmany(int[][] m1, int[][] m2) that returns how many cell values are identical
      in the two arrays (it only counts if they are identical in the same cell.)
3.    The class named Strict should also have a method
      public static int diagonal(int[][] m1, int[][] m2) that returns how many cell values are identical
      along the diagonal (that is, checking only cells [0][0], [1][1], and [2][2] from the two arrays.)
4.    The class named Strict should also have a method 
      public static double  average(int[][] m1,int[][] m2)that returns the average of all the cell values  
      from  the arrays (one answer.)
5.    The class named Strict should also have a method
      public static void display(int[][] m1, int[][] m2) that displays only those values of the arrays that
      are odd in rectangular form (row by row for each array.)
      You may assume the values entered are between 0 and 99 for formatting purposes. Make it pretty!
6.    The class named Strict should also have a method 
      public static boolean silly(int[][] m1, int[][] m2) that returns true if the two arrays have all numbers satisfying
      1 < numbers <=10  and returns  false  otherwise.
  
    Write a public class named your n number (lowercase n)  that permits the user to provide sample input like in the
       textbook and then displays the results of equals, howmany, diagonal , average (2 digits after 
       the decimal point), display, and silly. Skip one line after the answer for each method is printed.
     
Both classes should be in the same file.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.lang.*;

public class Program3{

   public static void main(String[] args){
      Scanner input = new Scanner(System.in);
      Strict run = new Strict();
      DecimalFormat numberFormat = new DecimalFormat("#.00");
      
      // instantiate and assign values into an array m1
      int[][] m1;
      m1 = new int[3][3];
      
      System.out.println("Enter lists, the first 9 are for the first array and the next 9 are for the second one: ");      
      for(int row = 0; row < m1.length; row++){
         for(int col = 0; col < m1[row].length; col++){
            m1[row][col] = input.nextInt();         
         }
      }
      
      // instantiate and assign values into an array m2
      int[][] m2;
      m2 = new int[3][3];
      
  //    System.out.println("Enter list2: ");
      for(int row = 0; row < m2.length; row++){
        for(int col = 0; col < m2[row].length; col++){
            m2[row][col] = input.nextInt();
        }
      }
      System.out.println("");
      
      //print statements that access the Strict class and its methods
      
      //calls the equals method
      System.out.println("The arrays are strictly equal: "+ run.equals(m1, m2));
            
      System.out.println("");
      
      //calls the howMany method
      System.out.println("There are " + run.howMany(m1, m2) + " number(s) that are identical in m1 and m2.");
      
      System.out.println("");
      
      //calls the diagonal method
      System.out.println("There are " + run.diagonal(m1, m2) + " number(s) that are identical along the diagonal in m1 and m2.");
      
      System.out.println("");
      
      //calls the average method
      System.out.println("The average of all the values in both arrays is: " + numberFormat.format(run.average(m1, m2)));
      
      System.out.println("");
      
      //calls the display method
      System.out.println("Display of all the values in both arrays that are odd: ");
      System.out.println("");
      run.display(m1, m2);
      
      System.out.println("");
      
      //calls the silly method
      System.out.println("The arrays contain values 1 < numbers <= 10: "+ run.silly(m1, m2));
      
      System.out.println("");
   }
}
   
class Strict{
  
   //checks to see if both arrays are strictly equal   
   public static boolean equals(int[][] m1, int[][] m2){
   
     boolean verify = true;
     for(int row = 0; row < m1.length; row++){
       for(int col = 0; col < m1[row].length; col++){
         if(m1[row][col] != m2[row][col]){
           verify = false;
           break;
         }
       }
     }
     return verify;
   }
   
   //counts how many cells are identical in both arrays
   public static int howMany(int[][] m1, int[][] m2){
   
      int count = 0;
         for(int row = 0; row < m1.length; row++){
           for(int col = 0; col < m1[row].length; col++){
               if(m1[row][col] == m2[row][col]){
                  count++;
               }
           }
         }
         return count;   
   }
   
   //counts how many cells are identical diagonally
   public static int diagonal(int[][] m1, int[][] m2){
   
      int count = 0;
      for(int row = 0; row < m1.length; row++){
         for(int col = 0; col < m1[row].length; col++){
            if(row == col){
               if(m1[row][col] == m2[row][col]){
                  count++;
               }
             }
         }
      }
      return count;
   }
   
   //calculates the average of both arrays
   public static double average(int[][] m1, int[][] m2){
   
      int sum = 0;
      for(int row = 0; row < m1.length; row++){
        for(int col = 0; col < m1[row].length; col++){
            sum = sum + m1[row][col]; 
        }
      }
      
      for(int row = 0; row < m2.length; row++){
        for(int col = 0; col < m2[row].length; col++){
            sum = sum + m2[row][col];  
        }
      }
      
      double average;
      average = (sum/18.0);
      
      return average;
   }
   
   //displays all the odd numbers in both arrays
   public static void display(int[][] m1, int[][] m2){
   
      for(int row = 0; row < m1.length; row++){
           for(int col = 0; col < m1[row].length; col++){
               if(((m1[row][col])%2) == 1){
                  if(((m1[row][col])/10) == 0){
                     System.out.print((" " + m1[row][col])+ "   ");
                  }else{
                     System.out.print((m1[row][col])+ "   ");
                  }
               }else{
                  System.out.print("     ");
               }
           }
           System.out.println("");
       }
       
       System.out.println("");
       System.out.println("");
       
       for(int row = 0; row < m2.length; row++){
           for(int col = 0; col < m2[row].length; col++){
               if(((m2[row][col])%2) == 1){
                  if(((m2[row][col])/10) == 0){
                     System.out.print((" " + m2[row][col])+ "   ");
                  }else{
                     System.out.print((m2[row][col])+ "   ");
                  }
               }else{
                  System.out.print("     ");
               }
           }
           System.out.println("");
       }
   }
   
   //checks if the values in both arrays are greater than 1 and less than or equal to 10
   public static boolean silly(int[][] m1, int[][] m2){
   
      boolean verify = true;
      
      for(int row = 0; row < m1.length; row++){
         for(int col = 0; col < m1[row].length; col++){
            if(((m1[row][col]) < 2) || ((m1[row][col]) > 10)){
               verify = false;
               break;
            }
         }
      }
         
      if(verify == true){
         for(int row = 0; row < m2.length; row++){
            for(int col = 0; col < m2[row].length; col++){
               if(((m2[row][col]) < 2) || ((m2[row][col]) > 10)){
                  verify = false;
                  break;
               }
            }
         }
      }    
      return verify;
   }
}
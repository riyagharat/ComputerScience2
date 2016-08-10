// Riya Gharat        N00901846
// 09/04/2015

/* Prompt: 
Write a program that prompts the user to enter the distance to drive, the fuel
efficiency of the car in miles per gallon, and the price per gallon, and
displays the cost of the trip. */

import java.io.*;
import java.util.*;
import java.text.*;

public class Program1{
   public static void main(String Args[]){
      //Scanner object for user input
      Scanner input = new Scanner(System.in);
      
      //Prompts user to enter input
      System.out.println("Enter the following information: ");
      
      System.out.print("Enter the Driving Distance: ");
      double drivingDistance = input.nextDouble();
      
      System.out.print("Enter Miles Per Gallon: ");
      double milesPerGallon = input.nextDouble();
      
      System.out.print("Enter Price Per Gallon: ");
      double pricePerGallon = input.nextDouble();
      
      double costOfTrip = ((drivingDistance/milesPerGallon)*pricePerGallon);
      DecimalFormat numberFormat = new DecimalFormat("#.00");
            
      System.out.println("The cost of driving is $"+numberFormat.format(costOfTrip));
      
      }
}
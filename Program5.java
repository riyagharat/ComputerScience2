// Riya Gharat        N00901846
// 09/26/2015

/* Prompt:

Design classes vehicle, car, american_car, foreign_car, truck, and bicycle with ALL appropriate inheritances. 
vehicle is the parent because everything is 
a vehicle or a member of a descendant of vehicle. 
The design of the classes is VERY important. Each of these classes will be in the file with your nnumber
class that has the main() method. 

Your code must override the toString method in each class to display ALL the relevant information from the record.
Also design an application class (your nnumber class with a main)  that tests your classes and processes a file of records.

The file of data to be used will be constructed by me with the following format used (examples are here):


vehicle 
owner's name (string)
address (string)
phone (string)
email (string)

car 
owner's name (string)
address (string)
phone (string)
email (string)
true or false for convertible (boolean)
color (string)

american car 
owner's name (string)
address (string)
phone (string)
email (string)
true or false for convertible (boolean)
color (string)
true or false for made in Detroit (boolean)
true or false for union shop (boolean)

foreign car 
owner's name (string)
address (string)
phone (string)
email  (string)
true or false for convertible (boolean)
color (string)
country of manufacturer (string)
import duty (float)

bicycle 
owner's name (string)
address (string)
phone (string)
email (string)
# of speeds (int)

truck 
owner's name (string)
address (string)
phone (string)
email (string) 
# of tons (float)
cost of truck (float)
date purchased (format below in exmample)


etc.....these records can appear in any order and there can be up to 200 of them.

Records will have a blank line between them.

You will need to use an array of vehicle to store the data.

Write an application class (your nnumber with a main) that reads a file (from the command line) and fills an array of type vehicle[] with new vehicle 
(params), new car (params), new american car (params) new foreign car(params) , new truck (params),
new bicycle (params), etc.: the params depend on the first line that identifies each record. params is just a shorthand name for parameter list (the arguments
to a method.)

To get the file , in jGrasp you must click on the tab file/check run args, and then type the name of the file in the box at the top.
I will test your program with my own file! You must not type in the name of the file in your code because it is only specified at run time.
The name of the file in your code will be args[0] when you use public static void main(String[], args) throws FileNotFoundException .
Because the input comes from the file instead of the keyboard you should be able to modify Scanner to deal with wrapping!
Scanner x = new Scanner(new File(args[0])). Google "java scanner" to learn about Scanner and/or "java command line" to learn about args[0].
This information is located on pages 478-480 of Liang's 10th Edition. 

Print the output from each of the following calls:

	1.  Call a printAll method that can be passed an array of type vehicle[] and which prints each element of 
            the array using the appropriate toString() methods. ArrayList is fine if you wish to use it.

	2.  Call a sort method that can be passed an array of type vehicle[] and which sorts the array by email addresses 
	    and prints the new sorted array using appropriate toString() methods. Any sort method is fine, but it should
            sort according to unicode (case sensitive, that is to say that all upper case is before any lower case)!

	3.  Call a method that prints the number of records.

	4.  Call a method that prints just the bicycles and trucks (from the sorted array using the appropriate toString() methods).

        5.  Call a method that prints the vehicles in area code 987.

Be sure to declare variables as private, to extend all the classes appropriately, and to have the right constructors (using super where 
appropriate), and the getters and setters for ALL the variables. MUST SEND ALL THE OUTPUT FROM PRINTING TO THE CONSOLE, NOT TO A WINDOW.

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.lang.*;

public class Program5{

   // Comparing the emails of Vehicle Objects
   static class EmailComparator implements Comparator<Vehicle>{
      public int compare(Vehicle one, Vehicle two){
         String emailOne = one.getEmail();
         String emailTwo = two.getEmail();
         
         return emailOne.compareTo(emailTwo);
      }
   }

   public static void main(String[] args) throws FileNotFoundException{
      
      //Create a File instance
      File file = new File(args[0]);
      Scanner input = new Scanner(file);
      
      ArrayList<Vehicle> arrayOfVehicles = new ArrayList<>();
      while (input.hasNextLine()){
         String test = input.nextLine();
         
         // If type vehicle
         if(test.equals("vehicle")){
            String name = input.nextLine();
            String address = input.nextLine();
            String phone = input.nextLine();
            String email = input.nextLine();
            // create vehicle object
            arrayOfVehicles.add(new Vehicle(name, address, phone, email));
         // If type truck   
         }else if(test.equals("truck")){
            String name = input.nextLine();
            String address = input.nextLine();
            String phone = input.nextLine();
            String email = input.nextLine();
            float tons = input.nextFloat();
            float cost = input.nextFloat();
            input.nextLine();
            String date = input.nextLine();
            // create truck object
            arrayOfVehicles.add(new Truck(name, address, phone, email, tons, cost, date));
         // If type bicycle   
         }else if(test.equals("bicycle")){
            String name = input.nextLine();
            String address = input.nextLine();
            String phone = input.nextLine();
            String email = input.nextLine();
            int speeds = input.nextInt();
            // create bicycle object
            arrayOfVehicles.add(new Bicycle(name, address, phone, email, speeds));
         // If type american car   
         }else if(test.equals("american car")){
            String name = input.nextLine();
            String address = input.nextLine();
            String phone = input.nextLine();
            String email = input.nextLine();
            boolean convertible = input.nextBoolean();
            input.nextLine();
            String color = input.nextLine();
            boolean detroit = input.nextBoolean();
            boolean union = input.nextBoolean();
            // create american car object
            arrayOfVehicles.add(new AmericanCar(name, address, phone, email, convertible, color, detroit, union));
         // If type foreign car   
         }else if(test.equals("foreign car")){
            String name = input.nextLine();
            String address = input.nextLine();
            String phone = input.nextLine();
            String email = input.nextLine();
            boolean convertible = input.nextBoolean();
            input.nextLine();
            String color = input.nextLine();
            String country = input.nextLine();
            float duty = input.nextFloat();
            // create foreign car object
            arrayOfVehicles.add(new ForeignCar(name, address, phone, email, convertible, color, country, duty));
         // If type car   
         }else if(test.equals("car")){
            String name = input.nextLine();
            String address = input.nextLine();
            String phone = input.nextLine();
            String email = input.nextLine();
            boolean convertible = input.nextBoolean();
            input.nextLine();
            String color = input.nextLine();
            // create car object
            arrayOfVehicles.add(new Car(name, address, phone, email, convertible, color));
            
         }
      
      }
      
      //Close the file
      input.close();
      
      
      // Calls printAll
      System.out.println("All the Vehicles");
      System.out.println("");
      printAll(arrayOfVehicles);
      System.out.println("");
      System.out.println("");
      System.out.println("");
      
      // Calls sort
      System.out.println("Sorting by Email ID");
      System.out.println("");
      sort(arrayOfVehicles);
      System.out.println("");
      System.out.println("");
      System.out.println("");
      
      // Calls numberOfEntries
      System.out.println("Number of Entries");
      System.out.println("");
      numberOfEntries(arrayOfVehicles);
      System.out.println("");
      System.out.println("");
      System.out.println("");
      
      // Calls justBT
      System.out.println("Just Bicycles and Trucks");
      System.out.println("");
      justBT(arrayOfVehicles);
      System.out.println("");
      System.out.println("");
      System.out.println("");
      
      // Calls areaCode
      System.out.println("Area Code 987");
      System.out.println("");
      areaCode(arrayOfVehicles);
      
  }
      
   //Methods
   
   //Prints the arraylist
   public static void printAll(ArrayList<Vehicle> array){
      for (int i = 0; i <= array.size()-1; i++){
         System.out.println(array.get(i).toString());  
         System.out.println("");
      }
   
   }
   
   //sorts email id in arraylist
   public static void sort(ArrayList<Vehicle> array){
      Collections.sort(array, new EmailComparator());
       
       for (int i = 0; i <= array.size()-1; i++){
         System.out.println(array.get(i).toString());  
         System.out.println("");
       }        
            
         System.out.println("");
      }              
   
   //prints number of entries
   public static void numberOfEntries(ArrayList<Vehicle> array){
      System.out.println("The number of entries: " + array.size());
   
   }
   
   //prints the bicycles and trucks
   public static void justBT(ArrayList<Vehicle> array){
      for (int i = 0; i <= array.size()-1; i++){
         if (array.get(i) instanceof Bicycle){
            System.out.println(array.get(i).toString());
            System.out.println("");
         }else if (array.get(i) instanceof Truck){
            System.out.println(array.get(i).toString());
            System.out.println("");
         }
      }
   
   }
   
   //prints the vehicles with area code 987
   public static void areaCode(ArrayList<Vehicle> array){
      String number;
      for (int i = 0; i <= array.size()-1; i++){
         number = array.get(i).getPhoneNumber();
          if((number.substring(1,4)).equals("987")){
            System.out.println(array.get(i).toString());
            System.out.println("");
         }
      }

   
   }


static class Vehicle{

   //fields for Vehicle
   private String ownerName;
   private String address;
   private String phoneNumber;
   private String email;
   
   //Vehicle constructors
   public Vehicle(){
   }
   
   public Vehicle(String ownerName, String address, String phoneNumber, String email){
   
      this.ownerName = ownerName;
      this.address = address;
      this.phoneNumber = phoneNumber;
      this.email = email;
   
   }
   
   //methods for the Vehicle Class
   public String getOwnerName(){
      return ownerName;
   }
   
   public void setOwnerName(String newOwnerName){
      this.ownerName = newOwnerName;
   }
   
   public String getAddress(){
      return address;
   }
   
   public void setAddress(String newAddress){
      this.address = newAddress;
   }
   
   public String getPhoneNumber(){
      return phoneNumber;
   }
   
   public void setPhoneNumber(String newPhoneNumber){
      this.phoneNumber = newPhoneNumber;
   }
   
   public String getEmail(){
      return email;
   }
   
   public void setEmail(String newEmail){
      this.email = newEmail;
   }
   
   public boolean equals(Object obj){
      return true;   
   }
   @Override
   public String toString(){
return "Type: Vehicle" + "\n" + "Name: " + getOwnerName()+ "\n" + "Address: " + getAddress() + "\n" + "Phone: " + getPhoneNumber() + "\n" +
         "Email: " + getEmail();
   }
}

static class Car extends Vehicle{

   //fields for Car
   private boolean convertible;
   private String color;
   
   //Car constructor
   public Car(){
   }
   
   public Car(String ownerName, String address, String phoneNumber, String email, boolean convertible, String color){
      setOwnerName(ownerName);
      setAddress(address);
      setPhoneNumber(phoneNumber);
      setEmail(email);
      this.convertible = convertible;
      this.color = color;
   }
   
   //methods for the Car Class
   public boolean getConvertible(){
      return convertible;
   }
   
   public void setConvertible(boolean newConvertible){
      this.convertible = newConvertible;
   }
   
   public String getColor(){
      return color;
   }
   
   public void setColor(String newColor){
      this.color = newColor;
   }
   
   public boolean equals(Object obj){
      return true; 
   }
   @Override
   public String toString(){
      return "Type: Car" + "\n" + "Name: " + getOwnerName()+ "\n" + "Address: " + getAddress() + "\n" + "Phone: " + getPhoneNumber() + "\n" +
         "Email: " + getEmail() + "\n" + "Convertible: " + getConvertible() + "\n" + "Color: " + getColor();
   }
}

static class AmericanCar extends Car{

 //fields for American Car
   private boolean madeInDetroit;
   private boolean unionShop;
   
   //American Car constructor
      
   public AmericanCar(String ownerName, String address, String phoneNumber, String email, boolean convertible, String color, boolean madeInDetroit, boolean unionShop){
      setOwnerName(ownerName);
      setAddress(address);
      setPhoneNumber(phoneNumber);
      setEmail(email);
      setConvertible(convertible);
      setColor(color);
      this.madeInDetroit = madeInDetroit;
      this.unionShop = unionShop;
   
   }
   
   //methods for the American Car Class
   public boolean getMadeInDetriot(){
      return madeInDetroit;
   }
   
   public void setMadeInDetriot(boolean newMadeInDetroit){
      this.madeInDetroit = newMadeInDetroit;
   }
   
   public boolean getUnionShop(){
      return unionShop;
   }
   
   public void setUnionShop(boolean newUnionShop){
      this.unionShop = newUnionShop;
   }
   
   public boolean equals(Object obj){
      return true; 
   }
   @Override
   public String toString(){
      return "Type: American Car" + "\n" + "Name: " + getOwnerName()+ "\n" + "Address: " + getAddress() + "\n" + "Phone: " + getPhoneNumber() + "\n" +
         "Email: " + getEmail() + "\n" + "Convertible: " + getConvertible() + "\n" + "Color: " + getColor() + "\n" +
         "Union Shop: " + unionShop + "\n" + "Detroit: " + madeInDetroit;
   }
}

static class ForeignCar extends Car{

 //fields for Foreign Car
   private String countryOfManufacture;
   private float duty;
   
   //Foreign Car constructor
   public ForeignCar(String ownerName, String address, String phoneNumber, String email, boolean convertible, String color, String countryOfManufacture, float duty){ 
   
      setOwnerName(ownerName);
      setAddress(address);
      setPhoneNumber(phoneNumber);
      setEmail(email);
      setConvertible(convertible);
      setColor(color);
      this.countryOfManufacture = countryOfManufacture;
      this.duty = duty;
   }
   
   //methods for the Foreign Car Class
   public String getCountryOfManufacture(){
      return countryOfManufacture;
   }
   
   public void setCountryOfManufacture(String newCountryOfManufacture){
      this.countryOfManufacture = newCountryOfManufacture;
   }
   
   public float getDuty(){
      return duty;
   }
   
   public void setDuty(float newDuty){
      this.duty = newDuty;
   }
   
   public boolean equals(Object obj){
      return true;
   }
   @Override
   public String toString(){
      return "Type: Foreign Car" + "\n" + "Name: " + getOwnerName()+ "\n" + "Address: " + getAddress() + "\n" + "Phone: " + getPhoneNumber() + "\n" +
         "Email: " + getEmail() + "\n" + "Convertible: " + getConvertible() + "\n" + "Color: " + getColor() + "\n" +
         "Manufacture Country: " + countryOfManufacture + "\n" + "Duty: " + duty;
   }

}

static class Bicycle extends Vehicle{

 //fields for Bicycle
   private int numberOfSpeeds;
   
   //Bicycle constructor
   public Bicycle(String ownerName, String address, String phoneNumber, String email, int numberOfSpeeds){
      setOwnerName(ownerName);
      setAddress(address);
      setPhoneNumber(phoneNumber);
      setEmail(email);
      this.numberOfSpeeds = numberOfSpeeds;
      
      
   }
   
   //methods for the Bicycle Class
   public int getNumberOfSpeeds(){
      return numberOfSpeeds;
   }
   
   public void setNumberOfSpeeds(int newNumberOfSpeeds){
      this.numberOfSpeeds = newNumberOfSpeeds;
   }
   
   public boolean equals(Object obj){
      return true;
   }
   @Override
   public String toString(){
      return "Type: Bicycle" + "\n" + "Name: " + getOwnerName()+ "\n" + "Address: " + getAddress() + "\n" + "Phone: " + getPhoneNumber() + "\n" +
         "Email: " + getEmail() + "\n" + "Speeds: " + numberOfSpeeds;
   }
}

static class Truck extends Vehicle{

 //fields for Truck
   private float numberOfTons;
   private float cost;
   private String date;
      
   //Truck constructor
   public Truck(String ownerName, String address, String phoneNumber, String email, float numberOfTons, float cost, String date){
      
      setOwnerName(ownerName);
      setAddress(address);
      setPhoneNumber(phoneNumber);
      setEmail(email);
      this.numberOfTons = numberOfTons;
      this.cost = cost;
      this.date = date;
   
   }
   
   //methods for the Truck Class
   public float getNumberOfTons(){
      return numberOfTons;
   }
   
   public void setNumberOfTons(float newNumberOfTons){
      this.numberOfTons = newNumberOfTons;
   }
   
   public float getCost(){
      return cost;
   }
   
   public void setCost(float newCost){
      this.cost = newCost;
   }
   
   public String getDate(){
      return date;
   }
   
   public void setDate(String newDate){
      this.date = newDate;
   }
   
   public boolean equals(Object obj){
      return true;
   }
   @Override
   public String toString(){
      return "Type: Truck" + "\n" + "Name: " + getOwnerName()+ "\n" + "Address: " + getAddress() + "\n" + "Phone: " + getPhoneNumber() + "\n" +
         "Email: " + getEmail() + "\n" + "Tons: " + numberOfTons + "\n" + "Cost: " + cost + "\n" +
         "Date: " + date;
   }
}
}


import java.io.File;
import java.util.Scanner;

/**
 * Write a description of class CarSalesman here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CarSalesman
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class CarSalesman
     */
    public CarSalesman()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * calculates the new price of the car
     * if the original cost is less than 30,000,
     * then apply a tax of 7%
     * else apply a tax of 5%
     */
    public static double calculateSelingPrice(double cost)
    {
        double tax = 0.1;
        double newPrice = 0;
        if (cost < 30000) {
            tax += 7.0/100; // 7%
            newPrice = cost + (cost * tax);
        } else {
            tax += 5.0/100; // 5%
            newPrice = cost + (cost * tax);
        }
        return newPrice;
    }
    
    /**
     * Calculates total sales using the sellingPrice and the quantity
     */
    public static double calculateSales(double sellingPrice, int quantity) {
        return sellingPrice * quantity;
    }
    
    /**
     * Read a file called "cars.txt" which contain the following info for each car
     * carName - the name of the car
     * year - the car's model year
     * cost - the original cost of the car
     * quantity - the number of cars to sell
     * 
     * Use the calculateSelingPrice above to know how much to sell the car
     * Use the calculateSales to know how much 
     * 
     * Print the number of different cars processed
     * Print the total number of cars to be sold
     * Print the year for the latest car model
     */
    public static void main (String [] args) {
        int count = 0;
        String carName = "";
        int year = 0, latestModel =0, earliestModel = 2020;
        double cost = 0, newPrice, sales, sumSales = 0, sumCost = 0;
        int quantity = 0, totalCars = 0;
        Scanner input = new Scanner("try");
        try{
            input = new Scanner(new File("cars.txt"));
        }catch (java.io.FileNotFoundException e) {}
    
        while (input.hasNextLine() && input.hasNext()) {
            count++;
            carName= input.next();
            year = input.nextInt();
            cost = input.nextDouble();
            quantity = input.nextInt();
            
            if (latestModel < year) {
                latestModel = year;
            }
            if (year < earliestModel) {
                earliestModel = year;
            }
            newPrice = calculateSelingPrice(cost);
            sales = calculateSales(newPrice, quantity);
            double totalCost = calculateSales(cost, quantity);
            totalCars += quantity;
            sumSales += sales;
            sumCost += totalCost;
            
            System.out.println(carName + "\t" + year + "\t" +
                cost + "\t" + quantity + "\t" + newPrice + "\t" +
                sales);
        }
        
        double avgSales = sumSales / totalCars;
        double avgCost = sumCost / totalCars;
        double avgReturn = avgSales - avgCost;
        double avgReturnPerct = avgReturn /avgSales *100;
        System.out.println("Nume of different car types in garage= " + count);
        System.out.println("Total cars= " + totalCars);
        System.out.println("Latst model year= " + latestModel);
        System.out.println("Earliest model year= " + earliestModel);
        System.out.printf("Average cost price= %.2f\n" , avgCost);
        System.out.printf("Average saeles price= %.2f\n" , avgSales);
        System.out.printf("Average return= %.2f\n" , avgReturn);
        System.out.printf("Average return percentage= %.2f\n" , avgReturnPerct);
    }
    
}

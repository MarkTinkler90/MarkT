package pool.reader;
import java.util.Scanner;
import java.text.DecimalFormat;
/**
 *
 * @author m1904074
 */
public class PoolReader {

public static void main(String[] args) {
    getUserName();  //takes user to unput username
    }

private static Scanner sc = new Scanner (System.in);  //sets up scanner for user input
private static String userName;  //user is saved here to be called back later on
    
private static void getUserName() {  //method for taking the username
        
    System.out.println("What is your user name?");
    userName = sc.next();  //user name gets picked up here
    shape("");  //user gets sent to choose the pool shape
    }

public static void shape(String pShape){  //method for choosing the pool shape
    System.out.println("What is the shape of the pool? (Rectangle/Circle)");
    pShape = sc.next().toLowerCase();  //user types in the shape of the pool
    
    if (null != pShape)switch (pShape) {  
            case "rectangle":
                recCalc(0,0,0,0);  //takes user to input the dimensions of a ractangular pool
                break;
            case "circle":
                circCalc(0,0);  //takes user to input the dimensions of a circular pool
                break;
            default:
                System.out.println("Shape not recognised");
                shape("");  //repeats the question if input doesn't correspond to either shape
                break;
        }
    }
   
public static void recCalc(double rWidth, double rLength, double rDeep, double rShallow){  //method to calculate a rectangular pool
    System.out.println("What is the width of the pool in meters?");
    rWidth = sc.nextDouble(); //takes the width of the pool
    System.out.println("What is the length of the pool in meters?");
    rLength = sc.nextDouble();  //takes the length of the pool
    System.out.println("What is the shallow depth of the pool in meters?");
    rShallow = sc.nextDouble();  //takes the shallow end of the pool
    System.out.println("What is the deep side depth of the pool in meters?");
    rDeep = sc.nextDouble();   //takes the deep side of the pool
    double rOverDepth = rDeep - rShallow;  //calculates and saves the difference in pool depths for later calculations
    double rBase = Math.sqrt(Math.pow(rOverDepth, 2) + Math.pow(rLength, 2)) * rWidth;   // calculates the base area of the pool for later calculations
    double rSurface = ((rLength * rShallow) * 2) + ((rWidth * rShallow) * 2)  
                + (rOverDepth * rWidth) + (rOverDepth * rLength) + rBase;   //calculates and saves the surface area of the pool
    double rVolume = (rLength * rWidth * rShallow) + ((rOverDepth * rLength * rWidth)/2);  //calculates and saves the volume of the pool
    
    recOutput(rLength, rWidth, rShallow, rDeep, rSurface, rVolume);  //takes user to format the output of this pool whilst carrying the recent input data over
    }
    
private static DecimalFormat df2 = new DecimalFormat("0.00");  //formatting for measurements to all be to 2 decimal places
private static String sAlign = "| %-14s| %-14s| \r\n";  //spacing for the formatted output
private static String sBoarder = ("+-------------------------------+\n");  //top and bottom boarder for the formatted output
private static String sLine = ("|---------------+---------------| \n");   //line break between each outputted measurement
private static String sEmpty = ("|               |               | \n");   //format for empty line to make output more presentable 
   
private static void recOutput(double rLength, double rWidth, double rShallow, double rDeep, double rSurface, double rVolume) {  //method for rectanguilar output formatting
    System.out.print(sBoarder);  //calls previous boarder format
    System.out.format(sAlign,"User",userName); //output for the first line of information
    System.out.print(sLine);  //calls the line break formatting
    System.out.format(sAlign,"Pool Shape", "Rectangle");  //output for the second line of information
    System.out.print(sLine);  //calls the line break formatting
    System.out.print(sEmpty); //calls the empty line formatting
    System.out.print(sLine);  //calls the line break formatting
    System.out.format(sAlign,"Length",df2.format(rLength) + "m");  //output for the third line of information
    System.out.print(sLine);  //calls the line break formatting
    System.out.format(sAlign,"Width",df2.format(rWidth) + "m");   //output for the fourth line of information
    System.out.print(sLine);  //calls the line break formatting
    System.out.format(sAlign,"Deep End",df2.format(rDeep) + "m");  //output for the fifth line of information
    System.out.print(sLine);  //calls the line break formatting
    System.out.format(sAlign,"Shallow End",df2.format(rShallow) + "m");  //output for the sixth line of information
    System.out.print(sLine);  //calls the line break formatting
    System.out.format(sAlign,"Surface Area",df2.format(rSurface) + "m²");  //output for the seventh line of information
    System.out.print(sLine);  //calls the line break formatting
    System.out.format(sAlign,"Volume",df2.format(rVolume) + "m³");  //output for the eighth line of information
    System.out.print(sBoarder); //calls previous boarder format      
    System.out.println("\n");  //line break
        
    again("");  //takes user to be asked if they want another pool
    }
 
public static void circCalc(double cRadius, double cDepth){  //method to calculate a circular pool
    System.out.println("What is the radius of the circle in meters?");
    cRadius = sc.nextDouble();  //takes the radius of the pool
    System.out.println("What is the depth of the pool in meters?");
    cDepth = sc.nextDouble();  //takes the depth of the pool
    double cSurface = (2*(3.14*cRadius*cDepth)) + (3.14 * Math.pow(cRadius, 2));  //calculates the surface area of the pool
    double cVolume = 3.14 * Math.pow(cRadius, 2) * cDepth;  //calculates the volume of the pool
    
    circOutput(cRadius, cDepth, cSurface, cVolume);  //takes user to format the output of this pool whilst carrying the recent input data over
    }

private static void circOutput(double cRadius, double cDepth, double cSurface, double cVolume) {
    System.out.print(sBoarder);  //calls previous boarder format
    System.out.format(sAlign,"User",userName); //output for the first line of information
    System.out.print(sLine);  //calls the line break formatting
    System.out.format(sAlign,"Pool Shape", "Circle"); //output for the second line of information
    System.out.print(sLine);  //calls the line break formatting
    System.out.print(sEmpty); //calls the empty line formatting
    System.out.print(sLine);  //calls the line break formatting
    System.out.format(sAlign,"Diameter",df2.format(cRadius * 2) + "m"); //output for the third line of information
    System.out.print(sLine);  //calls the line break formatting
    System.out.format(sAlign,"Depth",df2.format(cDepth) + "m"); //output for the fourth line of information
    System.out.print(sLine);  //calls the line break formatting
    System.out.format(sAlign,"Surface Area",df2.format(cSurface) + "m²"); //output for the fifth line of information
    System.out.print(sLine);  //calls the line break formatting
    System.out.format(sAlign,"Volume",df2.format(cVolume) + "m³"); //output for the sixth line of information
    System.out.print(sBoarder);  //calls previous boarder format  
    System.out.println("\n"); //line break
    
    again(""); //takes user to be asked if they want another pool
    }
    
public static void again(String newPool){
    System.out.println("Would you like to input a new pool?");
    newPool = sc.next().toLowerCase();
    
    if (null != newPool)switch (newPool) {
            case "yes":
                shape(""); //takes user to choose the pool shape again
                break;
            case "no":
                System.out.println("Goodbye");
                System.exit(0);  //closes the program
                break;
            default:
                System.out.println("Response not recognised");
                again("");  //repeats the question if input doesn't correspond to the question
                break;
        }
    }
}

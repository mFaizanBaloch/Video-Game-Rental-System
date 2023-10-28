//FA22-BCS-114 Saad Shahzad
//FA22-BCS-134 Haider Ali
//FA22-BCS-135 Mohammad Faizan
//Project Title: Video Game Rental System

//exported to github 28th oct

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    static ArrayList<Game> game = new ArrayList<>();
    static ArrayList<Customer> customer = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
        
    public static void main (String args[]) {
        Menu();
    
        int choice = 0;
        
        do {          
            choice = scan.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Case 1");
                    //functionalities
                    break;
                case 2:
                    System.out.println("Case 2");
                    //functionalities
                    break;
                case 3:
                    System.out.println("Case 3");
                    //functionalities
                    break;
                case 4:
                    System.out.println("Case 4");
                    //functionalities
                    break;
                case 5:
                    System.out.println("Case 5");
                    //functionalities
                    break;
                case 6:
                    System.out.println("Case 6");
                    //functionalities
                    break;
                case 7:
                    System.out.println("Case 7");
                    //functionalities
                    break;
                case 8:
                    System.out.println("Case 8");
                    //functionalities
                    break;
                case 9:
                    System.out.println("Case 9");
                    //functionalities
                    break;
                case 10:
                    System.out.println("Case 10");
                    //functionalities
                    break;
                default:
                    Menu();
            }
        } while (true);
    
    
    }
    
    static void Menu () {
        System.out.println("-----------------------------------------");
        System.out.println("         VIDEO GAME RENTAL SYSTEM");
        System.out.println("               Main Menu:");
        System.out.println("-----------------------------------------");
        System.out.println("Enter the number of operation needed:");
        System.out.println("1. Add a video game");
        System.out.println("2. Remove a video game");
        System.out.println("3. Update a video game");
        System.out.println("4. Search and display a video game");
        System.out.println("5. Add a customer profile");
        System.out.println("6. Remove a customer profile");
        System.out.println("7. Update a customer profile");
        System.out.println("8. Search and display a customer profile");
        System.out.println("9. Make a rental transaction");
        System.out.println("10. Exit the program");
        System.out.println("-----------------------------------------");
        System.out.print("Choice: ");
    }
    
    
}

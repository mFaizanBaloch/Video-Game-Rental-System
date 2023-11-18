//FA22-BCS-114 Saad Shahzad
//FA22-BCS-134 Haider Ali
//FA22-BCS-135 Mohammad Faizan
//Project Title: Video Game Rental System

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    static Scanner scan = new Scanner(System.in);
    //static ArrayList<Game> gameList = new ArrayList<>();
    //static ArrayList<Customer> customerList = new ArrayList<>();
    static ArrayList<Staff> staffList = new ArrayList<>();
    public static boolean flag1 = false;
    public static boolean flag2 = false;
    static int staffCounter = -1;
    
    public static void main(String args[]) {
   
        int choice1 = 0;
        
        do {
            
            MainMenu();
            choice1 = scan.nextInt(); // Input choice from user to traverse the main menu.
            int choice2 = 0;
            
            switch (choice1) {
                case 1: // Calling Video game menu.
                    choice2 = 0;
                    GameMenu();
                    
                    do {
                        choice2 = scan.nextInt();
                        
                        switch (choice2) {
                            case 1: // Add a video game.
                                System.out.println("  Adding a video game functionality...");
                                flag1 = true;
                                choice2 = 0;
                                break;
                                
                            case 2: // Remove a video game.
                                System.out.println("  Removing a video game functionality...");
                                flag1 = true;
                                choice2 = 0;
                                break;
                                
                            case 3: // Update a video game.
                                System.out.println("  Updating a video game functionality...");
                                flag1 = true;
                                choice2 = 0;
                                break;
                                
                            case 4: // Search and display a video game.
                                System.out.println("  searching and displaying a video game functionality...");
                                flag1 = true;
                                choice2 = 0;
                                break;
                                
                            case 5: // Return to main menu.
                                flag1 = true;
                                choice2 = 0;
                                MainMenu();
                                break;
                                
                            default: // Recalls game menu.
                                GameMenu();
                                break;
                        }
                    } while (choice2 != 0);
                    break;
                    
                case 2: // Calling Customer menu.
                    choice2 = 0;
                    CustomerMenu();
                    
                    do {
                        choice2 = scan.nextInt();
                        switch (choice2) {
                            case 1: // Add a customer profile.
                                System.out.println("  Adding a customer profile functionality...");
                                flag1 = true;
                                choice2 = 0;
                                break;
                                
                            case 2: // Remove a customer profile.
                                System.out.println("  Removing a customer profile functionality...");
                                flag1 = true;
                                choice2 = 0;
                                break;
                                
                            case 3: // Update a customer profile.
                                System.out.println("  Updating a customer profile functionality...");
                                flag1 = true;
                                choice2 = 0;
                                break;
                                
                            case 4: // Search and display customer profile.
                                System.out.println("  Searching and updating a customer profile functionality...");
                                flag1 = true;
                                choice2 = 0;
                                break;
                                
                            case 5: // Return to main menu.
                                flag1 = true;
                                choice2 = 0;
                                MainMenu();
                                break;
                                
                            default: // Recalls customer menu.
                                CustomerMenu();
                                break;
                        }
                    } while (choice2 != 0);
                    break;
                    
                case 3: // Calling Staff menu.
                    choice2 = 0;
                    StaffMenu();

                    do {
                        choice2 = scan.nextInt();
                        switch (choice2) {
                            case 1: // Add a staff member.
                                System.out.println("        \nPlease enter valid data below:");                                

                                System.out.print("Enter staff name: ");
                                scan.nextLine();
                                String name = scan.nextLine();
                                System.out.print("Enter staff ID: ");
                                String id = scan.nextLine();
                                System.out.print("Enter staff rank: ");
                                String rank = scan.nextLine();
                                
                                staffCounter++; // Incrementing the staff ArrayList index counter
                                Staff tempStaffObj = new Staff(id, name, rank); // Temporary object of staff
                                staffList.add(staffCounter, tempStaffObj); // Appending temp to ArrayList of objects of staff
                                
                                flag1 = true;
                                choice2 = 0;
                                break;
                                
                            case 2: // Remove a staff member.
                                flag2 = true;
                                System.out.println("        \nEnter ID of staff to delete its data:");
                                System.out.print("Enter staff ID: ");
                                scan.nextLine();
                                id = scan.nextLine();
                                
                                for (int i = 0; i < staffCounter + 1; i++) {
                                    Staff temp = staffList.get(i);
                                    String tempId = temp.getStaffId();
                                    
                                    if (tempId.equals(id)) {
                                        staffList.remove(i); // Removing object from staffList
                                        staffCounter--;
                                        flag1 = true;
                                        flag2 = false;
                                        break;
                                    }
                                }

                                choice2 = 0;
                                break;
                                
                            case 3: // Update a staff member.
                                flag2 = true;
                                System.out.println("        \nEnter ID of staff member, to update their data:");
                                System.out.print("Enter staff ID: ");
                                scan.nextLine();
                                id = scan.nextLine();
                                
                                
                                for (int i = 0; i < staffCounter + 1; i++) {
                                    Staff temp = staffList.get(i);
                                    String tempId = temp.getStaffId();
                                    
                                    if (tempId.equals(id)) { // Entering updated data to temp object
                                        
                                        System.out.println("        \nPlease enter updated data below:");
                                        System.out.print("Enter staff name (Previous name: " + temp.getStaffName() + "): ");
                                        name = scan.nextLine();
                                        temp.setStaffName(name);
                                        System.out.print("Enter staff ID (Previous ID: " + temp.getStaffId() + "): ");
                                        id = scan.nextLine();
                                        temp.setStaffId(id);
                                        System.out.print("Enter staff rank (Previous rank: " + temp.getStaffRank() + "): ");                                        
                                        rank = scan.nextLine();     
                                        temp.setStaffRank(rank);
                                        
                                        staffList.set(i, temp); // Setting updated data to required index through temp object
                                        
                                        flag1 = true;
                                        flag2 = false;
                                        break;
                                    }
                                }
                                
                                choice2 = 0;
                                break;
                                
                            case 4: // Search and display staff member.
                                flag2 = true;
                                System.out.println("1. Display all staff members.");
                                System.out.println("2. Display a specific staff member.");
                                System.out.print("        \nEnter the number of operation to perfom: ");
                                scan.nextLine();
                                id = scan.nextLine();
                                
                                
                                if (id.equals("1")) {
                                    for (int i = 0; i < staffCounter + 1; i++) {
                                        System.out.println();
                                        System.out.print(staffList.get(i));
                                    }
                                    
                                    System.out.print("\nPress ENTER key to continue...");
                                    
                                    try { // Continues the program when user enters ENTER key.
                                        System.in.read();
                                    }  
                                    catch(Exception e) {
                                    }
                                    
                                    flag1 = true;
                                    flag2 = false;
                                    choice2 = 0;
                                    break;
                                }
                                
                                else if (id.equals("2")) {
                                    System.out.print("        \nEnter ID of staff member to display their data: ");    
                                    id = scan.nextLine();
                                    
                                    for (int i = 0; i < staffCounter + 1; i++) {
                                        Staff temp = staffList.get(i);
                                        String tempId = temp.getStaffId();

                                        if (tempId.equals(id)) {
                                            System.out.println();
                                            System.out.println(temp);
                                            System.out.print("Press ENTER key to continue...");

                                            try { // Continues the program when user enters ENTER key.
                                                System.in.read();
                                            }  
                                            catch(Exception e) {
                                            } 

                                            flag1 = true;
                                            flag2 = false;
                                            break;
                                        }
                                    }

                                    choice2 = 0;
                                    break;
                                }
                                
                                else {
                                    flag1 = false;
                                    choice2 = 0;
                                    break;   
                                }
   
                            case 5: // Return to main menu.
                                flag1 = true;
                                choice2 = 0;
                                MainMenu();
                                break;
                                
                            default: // Recalls staff menu.
                                StaffMenu();
                                break;
                        }
                    } while (choice2 != 0);
                    break;
                    
                case 4: // Recording transaction.
                    System.out.println("Transactions functionality...");
                    choice1 = 0;
                    break;
                    
                case 5: // Exiting the program.
                    System.out.println("Exiting program...");
                    choice1 = 0;
                    break;
                    
                default: // Recalls main menu.
                    MainMenu();
                    break;
            }
        } while (choice1 != 0);
    }
    
    static void MainMenu() {
        for (int i = 0; i < 100; i++) { // Printing blank spaces.
                System.out.println("\b"); 
            }
        
        if (flag1) {
            System.out.println("           Operation successful!");
            flag1 = false;
        }
        
        if (flag2) {
            System.out.println("   Operation failed due to wrong input!");
            flag2 = false;
        }
        
        System.out.println("-----------------------------------------");
        System.out.println("         VIDEO GAME RENTAL SYSTEM");
        System.out.println("                Main Menu:");
        System.out.println("-----------------------------------------");
        System.out.println("Enter the number to display required menu:");
        System.out.println("1. Video Game menu (non-functional)");
        System.out.println("2. Customer menu (non-functional)");
        System.out.println("3. Staff menu (functional)");
        System.out.println("4. Record a transaction (non-functional)");
        System.out.println("5. Exit the program (functional)");
        System.out.println("-----------------------------------------");
        System.out.print("Choice: ");
    }
    
    static void GameMenu() {
        for (int i = 0; i < 100; i++) { // Printing blank spaces.
                System.out.println("\b"); 
            }
        
        if (flag1) {
            System.out.println("           Operation successful!");
            flag1 = false;
        }
        
        System.out.println("-----------------------------------------");
        System.out.println("         VIDEO GAME RENTAL SYSTEM");
        System.out.println("             Video Game Menu:");
        System.out.println("-----------------------------------------");
        System.out.println("Enter the number to perform operation:");
        System.out.println("1. Add a video game");
        System.out.println("2. Remove a video game");
        System.out.println("3. Update a video game's data");
        System.out.println("4. Search and Display a video game");
        System.out.println("5. Return to Main Menu");
        System.out.println("-----------------------------------------");
        System.out.print("Choice: ");
    }
    
    static void CustomerMenu() {
        for (int i = 0; i < 100; i++) { // Printing blank spaces.
                System.out.println("\b"); 
            }
        
        if (flag1) {
            System.out.println("           Operation successful!");
            flag1 = false;
        }
        
        System.out.println("-----------------------------------------");
        System.out.println("         VIDEO GAME RENTAL SYSTEM");
        System.out.println("              Customer Menu:");
        System.out.println("-----------------------------------------");
        System.out.println("Enter the number to perform operation:");
        System.out.println("1. Add a customer profile");
        System.out.println("2. Remove a customer profile");
        System.out.println("3. Update a customer's profile");
        System.out.println("4. Search and Display a customer profile");
        System.out.println("5. Return to Main Menu");
        System.out.println("-----------------------------------------");
        System.out.print("Choice: ");
    }
    
    static void StaffMenu() {
        for (int i = 0; i < 100; i++) { // Printing blank spaces.
                System.out.println("\b"); 
            }
        
        if (flag1) {
            System.out.println("           Operation successful!");
            flag1 = false;
        }
        
        System.out.println("-----------------------------------------");
        System.out.println("         VIDEO GAME RENTAL SYSTEM");
        System.out.println("               Staff Menu:");
        System.out.println("-----------------------------------------");
        System.out.println("Enter the number to perform operation:");
        System.out.println("1. Add a staff member");
        System.out.println("2. Remove a staff member");
        System.out.println("3. Update a staff member's data");
        System.out.println("4. Search and Display a staff member");
        System.out.println("5. Return to Main Menu");
        System.out.println("-----------------------------------------");
        System.out.print("Choice: ");
    }  
}

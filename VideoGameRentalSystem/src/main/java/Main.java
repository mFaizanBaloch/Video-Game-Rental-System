//FA22-BCS-114 Saad Shahzad
//FA22-BCS-134 Haider Ali
//FA22-BCS-135 Mohammad Faizan
//Project Title: Video Game Rental System

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Game> gameList = new ArrayList<>();
    static ArrayList<Customer> customerList = new ArrayList<>();
    static ArrayList<Staff> staffList = new ArrayList<>();
    public static boolean flag1 = false;
    public static boolean flag2 = false;
    static int staffCounter = -1;
    static int gameCounter = -1;
    static int customerCounter = -1;
    
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
                                System.out.println("        \nPlease enter valid data below:");                                

                                System.out.print("Enter video game title: ");
                                scan.nextLine();
                                String title = scan.nextLine();
                                System.out.print("Enter platform of this video game: ");
                                String platform = scan.nextLine();
                                System.out.print("Enter no. of total copies: ");
                                int totalCopies = scan.nextInt();
                                System.out.print("Enter no. of rented copies: ");
                                int rentedCopies = scan.nextInt();
                                System.out.print("Enter game ID: ");
                                scan.nextLine();
                                String id = scan.nextLine();
                                System.out.print("Enter rental price: ");
                                String rentalPrice = scan.nextLine();
                                System.out.println("Note: RENTAL PRICE IS IN PKR, AND RENTAL IS FOR ONE WEEK.");
                                
                                gameCounter++; // Incrementing the game ArrayList index counter
                                Game tempGameObj = new Game(id, title, platform, totalCopies, rentedCopies, rentalPrice); // Temporary object of game
                                gameList.add(gameCounter, tempGameObj); // Appending temp to ArrayList of objects of game
                                
                                flag1 = true;
                                choice2 = 0;
                                break;
                                
                            case 2: // Remove a video game.
                                flag2 = true;
                                System.out.println("        \nEnter ID of game to delete its data:");
                                System.out.print("Enter game ID: ");
                                scan.nextLine();
                                id = scan.nextLine();
                                
                                for (int i = 0; i < gameCounter + 1; i++) {
                                    Game temp = gameList.get(i);
                                    String tempId = temp.getGameId();
                                    
                                    if (tempId.equals(id)) {
                                        gameList.remove(i); // Removing object from gameList
                                        gameCounter--;
                                        flag1 = true;
                                        flag2 = false;
                                        break;
                                    }
                                }

                                choice2 = 0;
                                break;
                                
                            case 3: // Update a video game.
                                flag2 = true;
                                System.out.println("        \nEnter ID of video game, to update its data:");
                                System.out.print("Enter game ID: ");
                                scan.nextLine();
                                id = scan.nextLine();
                                
                                
                                for (int i = 0; i < gameCounter + 1; i++) {
                                    Game temp = gameList.get(i);
                                    String tempId = temp.getGameId();
                                    
                                    if (tempId.equals(id)) { // Entering updated data to temp object
                                        
                                        System.out.println("        \nPlease enter updated data below:");
                                        System.out.print("Enter video game title (Previous title: " + temp.getTitle() + "): ");
                                        title = scan.nextLine();
                                        temp.setTitle(title);
                                        System.out.print("Enter platform (Previous platform: " + temp.getPlatform() + "): ");                                        
                                        platform = scan.nextLine();     
                                        temp.setPlatform(platform);
                                        System.out.print("Enter no. of total copies (Previous number: " + temp.getTotalCopies() + "): ");
                                        totalCopies = scan.nextInt();
                                        temp.setTotalCopies(totalCopies);
                                        System.out.print("Enter no. of rented copies (Previous number: " + temp.getRentedCopies() + "): ");
                                        rentedCopies = scan.nextInt();
                                        temp.setRentedCopies(rentedCopies);
                                        temp.setAvailableCopies(totalCopies - rentedCopies);
                                        System.out.print("Enter game ID (Previous ID: " + temp.getGameId() + "): ");
                                        scan.nextLine();
                                        id = scan.nextLine();
                                        temp.setGameId(id);
                                        System.out.print("Enter rental price (Previous price: " + temp.getRentalPrice() + "): ");
                                        rentalPrice = scan.nextLine();
                                        temp.setRentalPrice(rentalPrice);
                                        gameList.set(i, temp); // Setting updated data to required index through temp object
                                        
                                        flag1 = true;
                                        flag2 = false;
                                        break;
                                    }
                                }
                                
                                choice2 = 0;
                                break;
                                
                            case 4: // Search and display a video game.
                                flag2 = true;
                                System.out.println("1. Display all video games.");
                                System.out.println("2. Display a specific video game.");
                                System.out.print("        \nEnter the number of operation to perfom: ");
                                scan.nextLine();
                                String opt = scan.nextLine();
                                
                                if (opt.equals("1")) {
                                    for (int i = 0; i < gameCounter + 1; i++) {
                                        System.out.println();
                                        System.out.print(gameList.get(i));
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
                                
                                else if (opt.equals("2")) {
                                    System.out.print("        \nEnter game ID to display its data: ");    
                                    id = scan.nextLine();
                                    
                                    for (int i = 0; i < gameCounter + 1; i++) {
                                        Game temp = gameList.get(i);
                                        String tempId = temp.getGameId();

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
                                System.out.println("        \nPlease enter valid data below:");                                

                                System.out.print("Enter customer name: ");
                                scan.nextLine();
                                String name = scan.nextLine();
                                System.out.print("Enter CNIC: ");
                                String cnic = scan.nextLine();
                                System.out.print("Enter Phone no.: ");
                                String phone = scan.nextLine();
                                System.out.print("Enter no. of ongoing rentals: ");
                                int rentals = scan.nextInt();
                                scan.nextLine();
                                
                                customerCounter++; // Incrementing the customer ArrayList index counter
                                Customer tempCustomerObj = new Customer(cnic, phone, rentals, name); // Temporary object of customer
                                customerList.add(customerCounter, tempCustomerObj); // Appending temp to ArrayList of objects of customer
                                
                                flag1 = true;
                                choice2 = 0;
                                break;
                                
                            case 2: // Remove a customer profile.
                                flag2 = true;
                                System.out.println("        \nEnter CNIC of customer to delete their profile:");
                                System.out.print("Enter CNIC: ");
                                scan.nextLine();
                                cnic = scan.nextLine();
                                
                                for (int i = 0; i < customerCounter + 1; i++) {
                                    Customer temp = customerList.get(i);
                                    String tempCnic = temp.getCnic();
                                    
                                    if (tempCnic.equals(cnic)) {
                                        customerList.remove(i); // Removing object from customerList
                                        customerCounter--;
                                        flag1 = true;
                                        flag2 = false;
                                        break;
                                    }
                                }

                                choice2 = 0;
                                break;
                                
                            case 3: // Update a customer profile.
                                flag2 = true;
                                System.out.println("        \nEnter customer CNIC, to update their data:");
                                System.out.print("Enter CNIC: ");
                                scan.nextLine();
                                cnic = scan.nextLine();
                                
                                
                                for (int i = 0; i < customerCounter + 1; i++) {
                                    Customer temp = customerList.get(i);
                                    String tempCnic = temp.getCnic();
                                    
                                    if (tempCnic.equals(cnic)) { // Entering updated data to temp object
                                        
                                        System.out.println("        \nPlease enter updated data below:");
                                        System.out.print("Enter customer name (Previous name: " + temp.getName() + "): ");
                                        name = scan.nextLine();
                                        temp.setName(name);
                                        System.out.print("Enter CNIC (Previous CNIC: " + temp.getCnic() + "): ");
                                        cnic = scan.nextLine();
                                        temp.setCnic(cnic);
                                        System.out.print("Enter Phone no. (Previous no.: " + temp.getPhoneNo() + "): ");                                        
                                        phone = scan.nextLine();     
                                        temp.setPhoneNo(phone);
                                        
// experimental                           System.out.print("Enter no. of ongoing rentals (Previous no.: " + temp.getOngoingRentals() + "): ");
//                                        rentals = scan.nextInt();
//                                        scan.nextLine();
//                                        temp.setOngoingRentals(rentals);
                                        
                                        customerList.set(i, temp); // Setting updated data to required index through temp object
                                        
                                        flag1 = true;
                                        flag2 = false;
                                        break;
                                    }
                                }
                                
                                choice2 = 0;
                                break;
                                
                                
                            case 4: // Search and display customer profile.
                                flag2 = true;
                                System.out.println("1. Display all customer profiles.");
                                System.out.println("2. Display a specific customer profile.");
                                System.out.print("        \nEnter the number of operation to perfom: ");
                                scan.nextLine();
                                String opt = scan.nextLine();
                                
                                if (opt.equals("1")) {
                                    for (int i = 0; i < customerCounter + 1; i++) {
                                        System.out.println();
                                        System.out.print(customerList.get(i));
                                        System.out.print("Rented games: ");
                                        Customer temp = customerList.get(i);
                                        temp.displayRentedGames();
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
                                
                                else if (opt.equals("2")) {
                                    System.out.print("        \nEnter CNIC of customer to display their data: ");    
                                    cnic = scan.nextLine();
                                    
                                    for (int i = 0; i < customerCounter + 1; i++) {
                                        Customer temp = customerList.get(i);
                                        String tempId = temp.getCnic();

                                        if (tempId.equals(cnic)) {
                                            System.out.println();
                                            System.out.print(temp);
                                            System.out.print("Rented games: ");
                                            temp.displayRentedGames();
                                            System.out.println();
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
                                String opt = scan.nextLine();
                                
                                
                                if (opt.equals("1")) {
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
                                
                                else if (opt.equals("2")) {
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
                    flag1 = false;
                    flag2 = true;
                    System.out.println("1. Rent a video game.");
                    System.out.println("2. Return of a rented game.");
                    System.out.print("        \nEnter the number of operation to perfom: ");
                    scan.nextLine();
                    int opt = scan.nextInt();

                    
                    switch (opt) {
                        case 1: // Rent transaction.
                            System.out.print("Enter customer CNIC: ");
                            scan.nextLine();
                            String cnic = scan.next();

                            for (int i = 0; i < customerCounter + 1; i++) {
                                Customer tempCustomerObj = customerList.get(i);
                                String tempCnic = tempCustomerObj.getCnic();
                                flag1 = false;
                                flag2 = true;
                                
                                if (tempCnic.equals(cnic)) {
                                    System.out.println("Customer Profile found!");
                                    System.out.println("=======================");
                                    System.out.println();
                                    
                                    for (int j = 0; j < gameCounter + 1; j++) { // Displaying all available games.
                                        System.out.print(gameList.get(j));
                                        System.out.println();
                                    }

                                    System.out.println("=======================");
                                    System.out.print("Enter the game ID to rent game: ");
                                    String id = scan.next();

                                    for (int k = 0; k < gameCounter + 1; k++) {
                                        Game tempGameObj = gameList.get(k);
                                        String tempId = tempGameObj.getGameId();
                                        flag1 = false;
                                        flag2 = true;

                                        if (tempId.equals(id)) {
                                            String concatenatedInfo = tempGameObj.getTitle() + " (" + tempId + ")";
                                            tempCustomerObj.incrementOngoingRentals();
                                            tempCustomerObj.gamesRented.add(concatenatedInfo); // Adds game title and id to an Arraylist in Customer profile.
                                            customerList.set(i, tempCustomerObj); // Placing temp customer object to required position.
                                            
                                            tempGameObj.incrementRentedCopies(); // Incrementing rented copies of the specific game.
                                            gameList.set(k, tempGameObj); // Playing temp game obj to required position.
                                            
                                            flag1 = true;
                                            flag2 = false;
//                                            choice1 = 0;
                                            break;
                                        }
                                    }  
                                    break;    
                                }   
                            }
                            
//                            choice1 = 0;
                            break;
                            
                                        
                        case 2: // Return transaction.
                            System.out.print("Enter customer CNIC: ");
                            scan.nextLine();
                            cnic = scan.next();

                            for (int i = 0; i < customerCounter + 1; i++) {
                                Customer tempCustomerObj = customerList.get(i);
                                String tempCnic = tempCustomerObj.getCnic();
                                flag1 = false;
                                flag2 = true;
                                
                                if (tempCnic.equals(cnic)) {
                                    System.out.println();
                                    System.out.println("Available Games:");
                                    System.out.println("=======================");
                                    System.out.println();
                                    
                                    for (int j = 0; j < tempCustomerObj.counter; j++) { // Displaying all rented available games by customer.
                                        System.out.println("Customer's ongoing rental games:");
                                        tempCustomerObj.displayRentedGames();
                                        System.out.println();
                                    }

                                    System.out.println("=======================");
                                    System.out.print("Enter the game ID to return it: ");
                                    String id = scan.next();

                                    for (int k = 0; k < gameCounter + 1; k++) {
                                        Game tempGameObj = gameList.get(k);
                                        String tempId = tempGameObj.getGameId();
                                        String tempTitle = tempGameObj.getTitle();
                                        String tempConcat = tempTitle + " (" + tempId + ")";
                                        flag1 = false;
                                        flag2 = true;

                                        if (tempId.equals(id)) {
                                            tempCustomerObj.gamesRented.remove(tempConcat); // Removes the game from customer's rentals.
                                            tempCustomerObj.decrementOngoingRentals(); // Decrement of ongoing rentals counter.
                                            customerList.set(i, tempCustomerObj); // Placing temp customer object at required index of customer list.
                                            
                                            tempGameObj.decrementRentedCopies();
                                            gameList.set(k, tempGameObj);

                                            flag1 = true;
                                            flag2 = false;
//                                            choice1 = 0;
                                            break;
                                        }
                                    }
                                    break;    
                                }   
                            }
                            
//                            choice1 = 0;
                            break;
        
                        default:
                            flag1 = false;
                            flag2 = true;
                            break;
                    }
                    
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
        System.out.println("1. Video Game menu");
        System.out.println("2. Customer menu");
        System.out.println("3. Staff menu");
        System.out.println("4. Record a transaction");
        System.out.println("5. Exit the program");
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

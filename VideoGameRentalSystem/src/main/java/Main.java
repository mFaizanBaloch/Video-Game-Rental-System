// This is the main class. Its purpose is to apply CRUD operations on objects of other classes (staff, game, customer, rental).

//FA22-BCS-114 Saad Shahzad
//FA22-BCS-134 Haider Ali
//FA22-BCS-135 Mohammad Faizan
//Project Title: Video Game Rental System

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    
    static ArrayList<Game> gameList;
    static ArrayList<Customer> customerList;
    static ArrayList<Staff> staffList;
    static ArrayList<Rental> rentalList;
    static int staffCounter = -1, gameCounter = -1, customerCounter = -1, rentalCounter = -1;
    
    static File gameFile, staffFile, customerFile, rentalFile;
    
    
    public static void main(String args[]) {
        gameList = new ArrayList<>();
        customerList = new ArrayList<>();
        staffList = new ArrayList<>();
        rentalList = new ArrayList<>();
        
        GUIinitial guiinitial = new GUIinitial();
        
        // TESTING:
        populateGamesInArrayList();
        populateCustomersInArrayList();
        populateStaffInArrayList();
        
        populateGamesInFile();
        populateCustomersInFile();
        populateRentalsInFile();
        populateStaffsInFile();

        
    }
    
    // FUNCTIONALITIES:
    public static void addVideoGame(String id, String title, String pltf, int totalCopies, String rentalPrice) {
        gameCounter++; // Incrementing the game ArrayList index counter.
        Game tempGameObj = new Game(id, title, pltf, totalCopies, /*rentedCopies,*/ rentalPrice); // Temporary object of game.
        gameList.add(gameCounter, tempGameObj); // Appending temp to ArrayList of objects of game.
        populateGamesInFile(); // Game ArrayList gets written in the file.
    }
    public static void updateVideoGame(String id, String title, String pltf, int totalCopies, String rentalPrice) {
        for (int i = 0; i < gameCounter + 1; i++) {
            Game temp = gameList.get(i);
            String tempId = temp.getGameId();
            
            if (tempId.equals(id)) { // Entering updated data to temp object.
                System.out.println("check");
                GUImain.flagValidation = true;
                temp.setTitle(title);   
                temp.setPlatform(pltf);
                temp.setTotalCopies(totalCopies);
                temp.setRentalPrice(rentalPrice);
                gameList.set(i, temp); // Temp object is set at the index of required object (acting as updated obj).
                populateGamesInFile(); // Game ArrayList gets written in the file.
                break;
            }
            else {
                GUImain.flagValidation = false;
            }
        }
        
        
    }
    public static void removeVideoGame(String id) {
        for (int i = 0; i < gameCounter + 1; i++) {
            Game temp = gameList.get(i);
            String tempId = temp.getGameId();
            
            if (tempId.equals(id)) {
                GUImain.flagValidation = true;                
                gameList.remove(i); // Removing object from gameList
                gameCounter--;
                populateGamesInFile(); // Game ArrayList gets written in the file.
                break;
            }
            else {
                GUImain.flagValidation = false;
            }
        }
    }
    
    public static void addStaff(String id, String name, String username, String password) {
        staffCounter++; // Incrementing the staff ArrayList index counter
        Staff tempStaffObj = new Staff(id, name, username, password); // Temporary object of staff
        staffList.add(staffCounter, tempStaffObj); // Appending temp to ArrayList of objects of staff
        populateStaffsInFile(); // Staff ArrayList gets written in the file.
    }
    public static void removeStaff(String username) {
        for (int i = 0; i < staffCounter + 1; i++) {
            Staff temp = staffList.get(i);
            String tempUsername = temp.getStaffUsername();
            
            if (tempUsername.equals(username)) {
                staffList.remove(i);
                staffCounter--;
                populateStaffsInFile(); // Staff ArrayList gets written in the file.
                break;
            }
        }
    }
     
    public static void addCustomer(String cnic, String name) {
        customerCounter++;  // Incrementing the customer ArrayList index counter
        Customer tempCustomerObject = new Customer(cnic, name); // Temporary object of customer
        customerList.add(tempCustomerObject); // Appending temp to ArrayList of objects of customer
        populateCustomersInFile(); // Customer ArrayList gets written in the file.
    }
    public static void updateCustomer(String cnic, String name) {
        for (int i = 0; i < customerCounter + 1; i++) {
            Customer temp = customerList.get(i);
            String tempCnic = temp.getCnic();
            
            if (tempCnic.equals(cnic)) {
                temp.setName(name);
                customerList.set(i, temp); // Sets updated temp object to required place
                populateCustomersInFile(); // Customer ArrayList gets written in the file.
                break;
            }
        }
    }
    public static void removeCustomer(String cnic) {
        for (int i = 0; i < customerCounter + 1; i++) {
            Customer temp = customerList.get(i);
            String tempCnic = temp.getCnic();
            
            if (tempCnic.equals(cnic)) {
                customerList.remove(i);
                customerCounter--;
                populateCustomersInFile(); // Customer ArrayList gets written in the file.
                break;
            }
        }
    }

    public static void makeRental(String gameId, String customerCnic, String staffId, String days) {
        rentalCounter++;    // Incrementing the rental ArrayList index counter
        Rental tempRentalObject = new Rental(gameId, customerCnic, staffId, days);  // Temporary object
        rentalList.add(tempRentalObject);   // Appending of temp to rental ArrayList of objects
        populateRentalsInFile(); // Rental ArrayList gets written in the file.
    }
    
    
    
    // FUNCTIONS FOR TESTING (manually populating ArrayLists):
    public static void populateGamesInArrayList() {
        addVideoGame("XBfifa23", "FIFA 23", "XBOX", 15, "80");
        addVideoGame("XBhitman3", "Hitman 3", "XBOX", 10, "60");
        addVideoGame("PStsushima", "Ghost of Tsushima", "PS4", 20, "75");
        addVideoGame("PSmarvelspd", "Marvel Spiderman", "PS4", 10, "70");
        addVideoGame("XBgow4", "Gears of War 4", "XBOX", 10, "65");
    }
    public static void populateCustomersInArrayList() {
        addCustomer("555111", "Hufaiza");
        addCustomer("555222", "Basim");
        addCustomer("555333", "Ibrahim");
    }
    public static void populateStaffInArrayList() {
        addStaff("001", "Ali", "ali", "ali001");
        addStaff("002", "Ahmad", "ahmad", "ahmad002");
        addStaff("003", "Azan", "azan", "azan003");
    }
    
    
    
    // FUNCTIONS FOR FILE HANDLING:
    public static void populateGamesInFile() {
        try {
            gameFile = new File("logs/gameData.txt");
        
            if (!gameFile.exists()) {
                gameFile.createNewFile();
            }

            FileWriter fw = new FileWriter(gameFile);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < gameCounter + 1; i++) {
                Game temp = gameList.get(i);
                bw.write(gameList.get(i).getFormatedData());
            }
            
            bw.close();
        }
        
        catch (IOException e) {
            System.out.println("Could not populate ArrayList to gameFile!");
        }
    }
    
    public static void populateCustomersInFile() {
        try {
            customerFile = new File("logs/customerData.txt");
        
            if (!customerFile.exists()) {
                customerFile.createNewFile();
            }

            FileWriter fw = new FileWriter(customerFile);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < customerCounter + 1; i++) {
                Customer temp = customerList.get(i);
                bw.write(customerList.get(i).getFormatedData());
            }

            bw.close();
        }
        
        catch (IOException e) {
            System.out.println("Could not populate ArrayList to customerFile!");
        }
    }
    
    public static void populateRentalsInFile()  {
        try {
            rentalFile = new File("logs/rentalData.txt");

            if (!rentalFile.exists()) {
                rentalFile.createNewFile();
            }

            FileWriter fw = new FileWriter(rentalFile);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < rentalCounter + 1; i++) {
                Rental temp = rentalList.get(i);
                bw.write(rentalList.get(i).getFormatedData());
            }

            bw.close();
        }
        
        catch (IOException e) {
            System.out.println("Could not populate ArrayList to rentalFile!");    
        }
    }
    
    public static void populateStaffsInFile() {
        try {
            staffFile = new File("logs/staffData.txt");
        
            if (!staffFile.exists()) {
                staffFile.createNewFile();
            }

            FileWriter fw = new FileWriter(staffFile);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < staffCounter + 1; i++) {
                Staff temp = staffList.get(i);
                bw.write(staffList.get(i).getFormatedData());
            }

            bw.close();
        }
        
        catch (IOException e) {
            System.out.println("Could not populate ArrayList to staffFile!");  
        }
    }

    public static void loadGamesFromFile() {
        try {
            gameFile = new File("logs/gameData.txt");
        
            if (!gameFile.exists()) {
                gameFile.createNewFile();
            }
        
            FileReader fr = new FileReader(gameFile);
            BufferedReader br = new BufferedReader(fr);
            
            
            String line;

            while ((line = br.readLine()) != null) {
                String parts[] = line.split("|");
                
            }
        
            
            
        }
        
        catch (IOException e) {
            System.out.println("Could not load ArrayList to gameFile!");
        }
        
        
    
    }
}
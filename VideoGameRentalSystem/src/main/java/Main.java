// This is the main class. Its purpose is to apply CRUD operations on objects of other classes (staff, game, customer, rental).

//FA22-BCS-114 Saad Shahzad
//FA22-BCS-134 Haider Ali
//FA22-BCS-135 Mohammad Faizan
//Project Title: Video Game Rental System

import java.util.ArrayList;

public class Main {
    
    static ArrayList<Game> gameList;
    static ArrayList<Customer> customerList;
    static ArrayList<Staff> staffList;
    static ArrayList<Rental> rentalList;
    static int staffCounter = -1, gameCounter = -1, customerCounter = -1, rentalCounter = -1;
    
    public static void main(String args[]) {
        gameList = new ArrayList<>();
        customerList = new ArrayList<>();
        staffList = new ArrayList<>();
        rentalList = new ArrayList<>();
        
        GUIinitial guiinitial = new GUIinitial();
        
        // TESTING:
        populateGames();
        populateCustomers();
        populateStaff();
    }
    
    // FUNCTIONALITIES:
    public static void addVideoGame(String id, String title, String pltf, int totalCopies, String rentalPrice) {
        gameCounter++; // Incrementing the game ArrayList index counter.
        Game tempGameObj = new Game(id, title, pltf, totalCopies, /*rentedCopies,*/ rentalPrice); // Temporary object of game.
        gameList.add(gameCounter, tempGameObj); // Appending temp to ArrayList of objects of game.
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
    }
    public static void removeStaff(String username) {
        for (int i = 0; i < staffCounter + 1; i++) {
            Staff temp = staffList.get(i);
            String tempUsername = temp.getStaffUsername();
            
            if (tempUsername.equals(username)) {
                staffList.remove(i);
                staffCounter--;
            }
        }
    }
     
    public static void addCustomer(String cnic, String name) {
        customerCounter++;  // Incrementing the customer ArrayList index counter
        Customer tempCustomerObject = new Customer(cnic, name); // Temporary object of customer
        customerList.add(tempCustomerObject); // Appending temp to ArrayList of objects of customer
    }
    public static void updateCustomer(String cnic, String name) {
        for (int i = 0; i < customerCounter + 1; i++) {
            Customer temp = customerList.get(i);
            String tempCnic = temp.getCnic();
            
            if (tempCnic.equals(cnic)) {
                temp.setName(name);
                customerList.set(i, temp); // Sets updated temp object to required place
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
            }
        }
    }

    public static void makeRental(String gameId, String customerCnic, String staffId, String days) {
        rentalCounter++;    // Incrementing the rental ArrayList index counter
        Rental tempRentalObject = new Rental(gameId, customerCnic, staffId, days);  // Temporary object
        rentalList.add(tempRentalObject);   // Appending of temp to rental ArrayList of objects
    }
    
    // FUNCTIONS FOR TESTING:
    public static void populateGames() {
        addVideoGame("XBfifa23", "FIFA 23", "XBOX", 15, "80");
        addVideoGame("XBhitman3", "Hitman 3", "XBOX", 10, "60");
        addVideoGame("PStsushima", "Ghost of Tsushima", "PS4", 20, "75");
        addVideoGame("PSmarvelspd", "Marvel Spiderman", "PS4", 10, "70");
        addVideoGame("XBgow4", "Gears of War 4", "XBOX", 10, "65");
    }
    public static void populateCustomers() {
        addCustomer("555111", "Hufaiza");
        addCustomer("555222", "Basim");
        addCustomer("555333", "Ibrahim");
    }
    public static void populateStaff() {
        addStaff("001", "Ali", "ali", "ali001");
        addStaff("002", "Ahmad", "ahmad", "ahmad002");
        addStaff("003", "Azan", "azan", "azan003");
    }
}
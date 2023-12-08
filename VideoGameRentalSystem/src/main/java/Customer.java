//FA22-BCS-114 Saad Shahzad
//FA22-BCS-134 Haider Ali
//FA22-BCS-135 Mohammad Faizan
//Project Title: Video Game Rental System

import java.util.ArrayList;

public class Customer {
    private String cnic, phoneNo, name;
    private int ongoingRentals = 0;
    static ArrayList<String> gamesRented;
    static int counter = -1;
            
    public Customer(String cnic, String phoneNo, int ongoingRentals, String name) {
        gamesRented = new ArrayList<>();
        this.cnic = cnic;
        this.phoneNo = phoneNo;
        this.ongoingRentals = ongoingRentals;
        this.name = name;
    }

    public String getCnic() {
        return this.cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getPhoneNo() {
        return this.phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getOngoingRentals() {
        return this.ongoingRentals;
    }

// experimental         public void setOngoingRentals(int ongoingRentals) {
//                          this.ongoingRentals = ongoingRentals;
//                      }
    
    public void incrementOngoingRentals() {
        this.ongoingRentals++;
        this.counter++;
    }
    
    public void decrementOngoingRentals() {
        this.ongoingRentals--;
        this.counter--;
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void displayRentedGames() {
        System.out.println(gamesRented);
    }
    
    @Override
    public String toString() {
        return "Name: " + this.name + "\nCNIC: " + this.cnic + "\nPhone: " + this.phoneNo + "\nNo. of ongoing rentals: " + this.ongoingRentals + "\n";
    }
}
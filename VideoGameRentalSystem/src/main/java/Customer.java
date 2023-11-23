//FA22-BCS-114 Saad Shahzad
//FA22-BCS-134 Haider Ali
//FA22-BCS-135 Mohammad Faizan
//Project Title: Video Game Rental System

import java.util.ArrayList;

public class Customer {
    private String cnic = new String();
    private String phoneNo = new String();
    private int ongoingRentals;
    private String name = new String();
    static ArrayList<Game> gamesRented = new ArrayList<>();
    
    public Customer(String cnic, String phoneNo, int ongoingRentals, String name) {
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

    public void setOngoingRentals(int ongoingRentals) {
        this.ongoingRentals = ongoingRentals;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    
    
    @Override
    public String toString() {
        return "Name: " + this.name + "\nCNIC: " + this.cnic + "\nPhone: " + this.phoneNo + "\nOngoing Rentals: " + this.ongoingRentals + "\n";
    }
}

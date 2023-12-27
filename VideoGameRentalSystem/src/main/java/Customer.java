// This class stores customer data.

//FA22-BCS-114 Saad Shahzad
//FA22-BCS-134 Haider Ali
//FA22-BCS-135 Mohammad Faizan
//Project Title: Video Game Rental System

public class Customer {
    private String cnic, name;
    private int ongoingRentals = 0;
            
    public Customer(String cnic, String name) {
        this.cnic = cnic;
        this.name = name;
    }

    public String getCnic() {
        return this.cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public int getOngoingRentals() {
        return ongoingRentals;
    }

    public void setOngoingRentals(int ongoingRentals) {
        this.ongoingRentals = ongoingRentals;
    }
    
    public void incrementOngoingRentals() {
        this.ongoingRentals++;
    }
    
    public void decrementOngoingRentals() {
        this.ongoingRentals--;
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getFormatedData() {
        return (this.cnic + "|" + this.name + "|" + this.ongoingRentals + "|" + "\n");
    }
    
    @Override
    public String toString() {
        return "\nName: " + this.name + "\nCNIC: " + this.cnic + "\nNo. of ongoing rentals: " + this.ongoingRentals + "\n";
    }
}
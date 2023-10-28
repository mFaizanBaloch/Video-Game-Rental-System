//FA22-BCS-114 Saad Shahzad
//FA22-BCS-134 Haider Ali
//FA22-BCS-135 Mohammad Faizan
//Project Title: Video Game Rental System

public class Customer {
    int cnic;
    int phoneNo;
    int ongoingRentals;
    String name = new String();

    public Customer() {}
    
    public Customer(int cnic, int phoneNo, int ongoingRentals, String name) {
        this.cnic = cnic;
        this.phoneNo = phoneNo;
        this.ongoingRentals = ongoingRentals;
        this.name = name;
    }
    
    
    
    
}

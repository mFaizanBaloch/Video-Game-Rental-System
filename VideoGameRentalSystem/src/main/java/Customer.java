//FA22-BCS-114 Saad Shahzad
//FA22-BCS-134 Haider Ali
//FA22-BCS-135 Mohammad Faizan
//Project Title: Video Game Rental System

public class Customer {
    private int cnic;
    private int phoneNo;
    private int ongoingRentals;
    private String name = new String();

    public Customer(int cnic, int phoneNo, int ongoingRentals, String name) {
        this.cnic = cnic;
        this.phoneNo = phoneNo;
        this.ongoingRentals = ongoingRentals;
        this.name = name;
    }

    public int getCnic() {
        return this.cnic;
    }

    public void setCnic(int cnic) {
        this.cnic = cnic;
    }

    public int getPhoneNo() {
        return this.phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
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
}

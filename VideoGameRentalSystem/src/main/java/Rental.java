// This class is used to store data about transactions.

//FA22-BCS-114 Saad Shahzad
//FA22-BCS-134 Haider Ali
//FA22-BCS-135 Mohammad Faizan
//Project Title: Video Game Rental System

import java.time.LocalDate;

public class Rental {
    private String gameId, customerCnic, staffId, days;
    private LocalDate purchase;
    private LocalDate retrn;
    
    public Rental(String gameId, String customerCnic, String staffId, String days) {
        this.gameId = gameId;
        this.customerCnic = customerCnic;
        this.staffId = staffId;
        this.purchase = LocalDate.now();
        this.days = days;
        this.retrn = purchase.plusDays(Integer.parseInt(days));
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getCustomerCnic() {
        return customerCnic;
    }

    public void setCustomerCnic(String customerCnic) {
        this.customerCnic = customerCnic;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public LocalDate getPurchase() {
        return purchase;
    }

    public void setPurchase(LocalDate purchase) {
        this.purchase = purchase;
    }

    public LocalDate getRetrn() {
        return retrn;
    }

    public void setRetrn(LocalDate retrn) {
        this.retrn = retrn;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }
    
    @Override
    public String toString() {
        return "\nCNIC: " + customerCnic + "\nGame ID: " + gameId + "\nStaff ID: " + staffId + "\nPurchase Date: " + purchase + "\nExpected Return: " + retrn + '\n';
    }
}
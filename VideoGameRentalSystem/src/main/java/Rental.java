//FA22-BCS-114 Saad Shahzad
//FA22-BCS-134 Haider Ali
//FA22-BCS-135 Mohammad Faizan
//Project Title: Video Game Rental System

import java.time.LocalDate;

public class Rental {
    private String gameTitle, customerWhoBought, staffWhoSold;
    private LocalDate purchase;
    private LocalDate retrn;
    //date of purchase
    //date of return
    //days left

    public Rental(String gameTitle, String customerWhoBought, String staffWhoSold, String days) {
        this.gameTitle = gameTitle;
        this.customerWhoBought = customerWhoBought;
        this.staffWhoSold = staffWhoSold;
        this.purchase = LocalDate.now();
        this.retrn = LocalDate.of(purchase.getYear(), purchase.getMonth(), (purchase.getDayOfMonth() + Integer.parseInt(days)));
    }

    public String getGameTitle() {
        return staffWhoSold;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public String getCustomerWhoBought() {
        return staffWhoSold;
    }

    public void setCustomerWhoBought(String customerWhoBought) {
        this.customerWhoBought = customerWhoBought;
    }

    public String getStaffWhoSold() {
        return this.staffWhoSold;
    }

    public void setStaffWhoSold(String staffWhoSold) {
        this.staffWhoSold = staffWhoSold;
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
    
    
    
    
}

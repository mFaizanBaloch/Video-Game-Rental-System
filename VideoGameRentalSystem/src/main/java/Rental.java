//FA22-BCS-114 Saad Shahzad
//FA22-BCS-134 Haider Ali
//FA22-BCS-135 Mohammad Faizan
//Project Title: Video Game Rental System

public class Rental {
    private String gameTitle, customerWhoBought, staffWhoSold;
    
    //date of purchase
    //date of return
    //days left

    public Rental(String gameTitle, String customerWhoBought, String staffWhoSold) {
        this.gameTitle = gameTitle;
        this.customerWhoBought = customerWhoBought;
        this.staffWhoSold = staffWhoSold;
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
    
    
    
}

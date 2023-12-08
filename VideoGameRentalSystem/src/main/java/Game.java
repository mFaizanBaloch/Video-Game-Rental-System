//FA22-BCS-114 Saad Shahzad
//FA22-BCS-134 Haider Ali
//FA22-BCS-135 Mohammad Faizan
//Project Title: Video Game Rental System

public class Game {
    private String gameId, title, rentalPrice;
    private int totalCopies;
    
    private String platform; // (to be changed to enum)
//    private int rentedCopies, availableCopies; // (discarded)
    
    public Game(String gameId, String title, String platform, int totalCopies, /*int rentedCopies,*/ String rentalPrice) {
        this.gameId = gameId;
        this.title = title;
        this.platform = platform;
        this.totalCopies = totalCopies;
        this.rentalPrice = rentalPrice;
//        this.rentedCopies = rentedCopies;
//        availableCopies = totalCopies - rentedCopies;
    }

    public String getGameId() {
        return this.gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlatform() {
        return this.platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
    
    public int getTotalCopies() {
        return this.totalCopies;
    }
    
    public void setTotalCopies(int copies) {
        this.totalCopies = copies;   
    }
    
//    public int getRentedCopies() {
//        return this.rentedCopies;
//    }
//    
//    public void setRentedCopies(int rentedCopies) {
//        this.rentedCopies = rentedCopies;   
//    }
//    
//    public void incrementRentedCopies() {
//        this.rentedCopies++;
//        this.availableCopies--;
//    }
//
//    public void decrementRentedCopies() {
//        this.rentedCopies--;
//        this.availableCopies++;
//    }    
//    
//    public int getAvailableCopies() {
//        return this.availableCopies;
//    }
//    
//    public void setAvailableCopies(int availableCopies) {
//        this.availableCopies = availableCopies;   
//    }
    
    public String getRentalPrice() {
        return this.rentalPrice;
    }
    
    public void setRentalPrice(String rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    @Override
    public String toString() {
        return "\nTitle: " + this.title + "\nPlatform: " + this.platform + "\nRental Price: " + this.rentalPrice
                + " RS" + "\nTotal Copies: " + this.totalCopies + "\nGame ID: " + this.gameId + "\n";
    }
    
    public String toString(int x) {
        // int x has no use, it is only to overload toString() function.
        return this.title + ", " + this.platform + ", " + this.rentalPrice + " RS, " + this.gameId + ", " + this.totalCopies + "\n";
    }
    
}

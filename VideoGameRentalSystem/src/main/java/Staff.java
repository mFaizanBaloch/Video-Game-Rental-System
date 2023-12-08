//FA22-BCS-114 Saad Shahzad
//FA22-BCS-134 Haider Ali
//FA22-BCS-135 Mohammad Faizan
//Project Title: Video Game Rental System

public class Staff {
    private String staffId, staffName, staffRank;
    
    public Staff(String staffId, String staffName, String staffRank) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.staffRank = staffRank;
    }

    public String getStaffId() {
        return this.staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return this.staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffRank() {
        return this.staffRank;
    }

    public void setStaffRank(String staffRank) {
        this.staffRank = staffRank;
    }

    @Override
    public String toString() {
        return "Name: " + this.staffName + "\nID: " + this.staffId + "\nRank: " + this.staffRank + "\n";
    }
}

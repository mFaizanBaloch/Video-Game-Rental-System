//FA22-BCS-114 Saad Shahzad
//FA22-BCS-134 Haider Ali
//FA22-BCS-135 Mohammad Faizan
//Project Title: Video Game Rental System

public class Staff {
    private String staffId, staffName, staffUsername, staffPassword;
    
    public Staff(String staffId, String staffName, String staffUsername, String staffPassword) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.staffUsername = staffUsername;
        this.staffPassword = staffPassword;
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

    public String getStaffUsername() {
        return staffUsername;
    }

    public void setStaffUsername(String staffUsername) {
        this.staffUsername = staffUsername;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }
    
    @Override
    public String toString() {
        return "\nName: " + this.staffName + "\nID: " + this.staffId + "\nUsername: " + this.staffUsername + "\nPass: " + this.staffPassword + "\n";
    }
}

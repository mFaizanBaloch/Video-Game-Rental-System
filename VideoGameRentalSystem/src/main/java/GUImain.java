// This class holds all the application's main GUI. User entered data is usually flowing outwards from this class.

//FA22-BCS-114 Saad Shahzad
//FA22-BCS-134 Haider Ali
//FA22-BCS-135 Mohammad Faizan
//Project Title: Video Game Rental System

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUImain extends JFrame {

    // DECLARATIONS :
    static boolean flagValidation =  false;
    static Staff activeLogin;  // For setting the active staff member who is accessing the system.
    
    
    Font fontSubtext;                                                                                               // for setting default font
    Color colorVeryBlue, colorWhite;                                                                                // VeryBlue for backgrounds, White for foregrounds
    JPanel panelDashboard, panelAddGame, panelUpdateGame, panelRemoveGame, panelDisplayGame,
            panelDisplayStaff, panelRemoveStaff, panelAddCustomer, panelUpdateCustomer,
            panelRemoveCustomer, panelDisplayCustomer, panelRental, panelReturn;
    JMenuBar menuBar;
    JMenu menuMain, menuGame, menuStaff, menuCustomer;
    JMenuItem itemAddGame, itemUpdateGame, itemRemoveGame, itemDisplayGame, itemDashboard, itemRental, itemReturn;  // game menu + main menu items
    JMenuItem itemDisplayStaff, itemRemoveStaff, itemLogoutStaff;                                                   // staff menu items
    JMenuItem itemAddCustomer, itemUpdateCustomer, itemRemoveCustomer, itemDisplayCustomer;                         // customer menu items
    JLabel lblTotalGame, lblTotalStaff, lblTotalCustomer, lblCompanyName, lblProjectName;                           // for dashboard panel
    JLabel lblRentalMenu, lblRentedDays, lblIdOfStaff, lblCnicOfCustomer, lblIdOfGame;                              // for rental panel of main menu
    JLabel lblReturnMenu, lblEnterSR;                                                                               // for return panel of main menu
    JLabel lblAddGameMenu, lblUpdateGameMenu, lblRemoveGameMenu, lblDisplayGameMenu;                                // for all submenus of game menu
    JLabel lblDisplayStaffMenu;                                                                                     // for all submenus of game menu
    JLabel lblGameId, lblGameTitle, lblGamePlatform, lblGameTotalCopies, lblGamePrice;                              // for add game + update game panels
    JLabel lblValidateGame;                                                                                         // for update game + remove game panels
    JLabel lblRemovalMessage, lblCaptcha;                                                                           // for remove staff panel
    JLabel lblAddCustomerMenu, lblUpdateCustomerMenu, lblRemoveCustomerMenu, lblDisplayCustomerMenu;                // for all submenus of customer menu 
    JLabel lblCnic, lblCustomerName, lblValidateCustomer;                                                           // for add customer + update customer panels
    JButton btnSubmitRentalTransaction, btnSubmitReturnTransaction;                                                 // submit buttons
    JButton btnSubmitAddGame, btnSubmitUpdateGame, btnSubmitRemoveGame;                                             // submit buttons
    JButton btnSubmitAddCustomer, btnSubmitUpdateCustomer, btnSubmitRemoveCustomer;                                 // submit buttons  
    JButton btnProceedRemoveStaff;                                                                                  // proceed buttons
    JTable tableGame = new JTable(25, 5);
    JTable tableStaff = new JTable(25,3);
    JTable tableCustomer = new JTable(25,4);
    JTable tableTransactions = new JTable(15, 6);
    JTextField txtfldGameId, txtfldGameTitle, txtfldGameTotalCopies, txtfldGamePrice, txtfldValidateGame;           // for add game + update game panels
    JTextField txtfldCaptcha;                                                                                       // for remove staff panel
    JTextField txtfldCnic, txtfldCustomerName, txtfldValidateCustomer;                                              // for add customer + update customer panels
    JTextField txtfldCnicOfCustomer, txtfldIdOfStaff, txtfldIdOfGame, txtfldlRentedDays;                            // for rental transaction panel
    JTextField txtfldSR;                                                                                            // for return panel of main menu
    JTextArea txtareaRemoveStaff;                                                                                   // for remove staff panel
    JRadioButton rdBtnPlatformXBOX, rdBtnPlatformPS4;                                                               // for add game + update game panels
    ButtonGroup platf = new ButtonGroup();                                                                          // for XBOX and PS4 choice radio buttons
    
    
    // CONSTRUCTOR :
    public GUImain(){        
        initComponents();       // Initializes components and panels.
        initMenuBar();          // Initialize Menu Bar.
        settingsMenuBar();      // Sets up Menu bar.
        panelSettingsStats();   // Sets up Stats panel (acts as summary page).
        
        
        // JFRAME SETTINGS :
        super.setTitle("Video Game Rental");
        super.setDefaultCloseOperation(3);
        super.setSize(500, 480);
        super.setResizable(false);
        super.setLayout(null);
        super.setLocationRelativeTo(null);
        super.add(panelDashboard); 
        super.setJMenuBar(menuBar);
        super.setVisible(true);
            
        
        // ACTION LISTENERS FOR SUBMENU BUTTONS :
        itemDashboard.addActionListener(new ActionListener() {              // Calls Dashboard panel.
            @Override
            public void actionPerformed(ActionEvent e) {
                panelSettingsStats();
                getContentPane().removeAll();
                panelDashboard.setVisible(true);
                add(panelDashboard);
                panelDashboard.revalidate();
                panelDashboard.repaint();
            }
        });
        itemRental.addActionListener(new ActionListener() {            // Calls Rental panel.
            @Override
            public void actionPerformed(ActionEvent e) {
                panelSettingsRentalTransactions();
                getContentPane().removeAll();
                panelRental.setVisible(true);
                add(panelRental);
                panelRental.revalidate();
                panelRental.repaint();
            }
        });
        itemReturn.addActionListener(new ActionListener() {             // Calls Return panel.
            @Override
            public void actionPerformed(ActionEvent e) {
                panelSettingsReturn();
                getContentPane().removeAll();
                panelReturn.setVisible(true);
                add(panelReturn);
                panelReturn.revalidate();
                panelReturn.repaint();
            }
        });
        itemAddGame.addActionListener(new ActionListener() {            // Calls Add game panel.
            @Override
            public void actionPerformed(ActionEvent e) {
                panelSettingsAddGame();
                getContentPane().removeAll();
                panelAddGame.setVisible(true);
                add(panelAddGame);
                panelAddGame.revalidate();
                panelAddGame.repaint();
            }
        });        
        itemUpdateGame.addActionListener(new ActionListener () {        // Calls Update game panel.
            @Override
            public void actionPerformed(ActionEvent e) {
                panelSettingsUpdateGame();
                getContentPane().removeAll();
                panelUpdateGame.setVisible(true);
                add(panelUpdateGame);
                panelUpdateGame.revalidate();
                panelUpdateGame.repaint(); 
            }
        });
        itemRemoveGame.addActionListener(new ActionListener () {        // Calls Remove game panel.
            @Override
            public void actionPerformed(ActionEvent e) {
                panelSettingsRemoveGame();
                getContentPane().removeAll();
                panelRemoveGame.setVisible(true);
                add(panelRemoveGame);
                panelRemoveGame.revalidate();
                panelRemoveGame.repaint(); 
            }
        });
        itemDisplayGame.addActionListener(new ActionListener () {       // Calls Display game panel.
            @Override
            public void actionPerformed(ActionEvent e) {
                panelSettingsDisplayGame();
                getContentPane().removeAll();
                panelDisplayGame.setVisible(true);
                add(panelDisplayGame);
                panelDisplayGame.revalidate();
                panelDisplayGame.repaint();  
            }
        });
        itemDisplayStaff.addActionListener(new ActionListener () {      // Calls Display staff panel.
            @Override
            public void actionPerformed(ActionEvent e) {
                panelSettingsDisplayStaff();
                getContentPane().removeAll();
                panelDisplayStaff.setVisible(true);
                add(panelDisplayStaff);
                panelDisplayStaff.revalidate();
                panelDisplayStaff.repaint();
            }
        });
        itemRemoveStaff.addActionListener(new ActionListener () {      // Calls Remove staff panel.
            @Override
            public void actionPerformed(ActionEvent e) {
                panelSettingsRemoveStaff();
                getContentPane().removeAll();
                panelRemoveStaff.setVisible(true);
                add(panelRemoveStaff);
                panelRemoveStaff.revalidate();
                panelRemoveStaff.repaint();
            }
        });
        itemLogoutStaff.addActionListener(new ActionListener() {        // Logs out the staff member, and calls login/register screen.
            @Override
            public void actionPerformed(ActionEvent e) {
                int inp = JOptionPane.showConfirmDialog(rootPane, "Do you wish to log out of your account?", "", 0, 3);
                if (inp == 0) {
                    activeLogin = null;
                    dispose();
                    GUIinitial guiinitial = new GUIinitial(); // To call the login/register screen.
                    JOptionPane.showMessageDialog(rootPane, "Your account was logged out.", "", 1);
                }
            }
        });
        itemAddCustomer.addActionListener(new ActionListener() {        // Calls Add customer panel.
            @Override
            public void actionPerformed(ActionEvent e) {
                panelSettingsAddCustomer();
                getContentPane().removeAll();
                panelAddCustomer.setVisible(true);
                add(panelAddCustomer);
                panelAddCustomer.revalidate();
                panelAddCustomer.repaint();
            }
        });
        itemUpdateCustomer.addActionListener(new ActionListener() {     // Calls Update customer panel.
            @Override
            public void actionPerformed(ActionEvent e) {
                panelSettingsUpdateCustomer();
                getContentPane().removeAll();
                panelUpdateCustomer.setVisible(true);
                add(panelUpdateCustomer);
                panelUpdateCustomer.revalidate();
                panelUpdateCustomer.repaint();
            }
        });
        itemRemoveCustomer.addActionListener(new ActionListener() {     // Calls Remove customer panel.
            @Override
            public void actionPerformed(ActionEvent e) {
                panelSettingsRemoveCustomer();
                getContentPane().removeAll();
                panelRemoveCustomer.setVisible(true);
                add(panelRemoveCustomer);
                panelRemoveCustomer.revalidate();
                panelRemoveCustomer.repaint();
            }
        });
        itemDisplayCustomer.addActionListener(new ActionListener() {    // Calls Display customer panel.
            @Override
            public void actionPerformed(ActionEvent e) {
                panelSettingsDisplayCustomer();
                getContentPane().removeAll();
                panelDisplayCustomer.setVisible(true);
                add(panelDisplayCustomer);
                panelDisplayCustomer.revalidate();
                panelDisplayCustomer.repaint();
            }
        });
        
        
        // ACTION LISTENERS FOR ON-PANEL BUTTONS :
        btnSubmitRentalTransaction.addActionListener(new ActionListener() { // Submit button for making a rental.
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flagC = false, flagS = false, flagG = false;
                
                // Checking whether there is a customer profile with entered cnic:
                for (int i = 0; i < Main.customerCounter + 1; i++) {
                    Customer temp = Main.customerList.get(i);
                    String tempCnic = temp.getCnic();
                    
                    if (tempCnic.equals(txtfldCnicOfCustomer.getText())) {
                        flagC = true;
                        break;
                    }
                }
                
                // Checking whether the staff id is of the active staff account:
                if (activeLogin.getStaffId().equals(txtfldIdOfStaff.getText())) {
                    flagS = true;
                }
                
                // Checking whether there is a game with entered game id:
                for (int i = 0; i < Main.gameCounter + 1; i++) {
                    Game temp = Main.gameList.get(i);
                    String tempId = temp.getGameId();
                    
                    if (tempId.equals(txtfldIdOfGame.getText())) {
                        flagG = true;
                        break;
                    }
                }
                
                // When all ids/cnics are correct, data is passed to function in main:
                if (flagC && flagS && flagG) { 
                    Main.makeRental(txtfldIdOfGame.getText(), txtfldCnicOfCustomer.getText(), txtfldIdOfStaff.getText(), txtfldlRentedDays.getText());
                    
                    System.out.println(Main.rentalList + "\n"); // (test display)
                    
                    // Incrementing customer's ongoing rentals:
                    for (int i = 0; i < Main.customerCounter + 1; i++) {
                        Customer temp = Main.customerList.get(i);
                        String tempCnic = temp.getCnic();

                        if (tempCnic.equals(txtfldCnicOfCustomer.getText())) {
                            temp.incrementOngoingRentals();
                            Main.customerList.set(i, temp); // Replacing old data with updated data (ongoing rentals)
                            Main.populateCustomersInFile(); // Customer ArrayList gets written in the file.
                        }
                    }

                    // Success notfication:
                    JOptionPane.showMessageDialog(rootPane, "Transaction succesful!", "", 1);
                    
                    // Resetting text fields:
                    txtfldCnicOfCustomer.setText("");
                    txtfldIdOfGame.setText("");
                    txtfldIdOfStaff.setText("");
                    txtfldlRentedDays.setText("");
                    
                    // Calling dashboard panel:
                    getContentPane().removeAll();
                    panelDashboard.setVisible(true);
                    add(panelDashboard);
                    panelDashboard.revalidate();
                    panelDashboard.repaint();
                }
                
                else {  // In case ids/cnic is not entered correctly.
                    JOptionPane.showMessageDialog(rootPane, "Something went wrong! Data not correct.", "", 0);
                }
            }
        });
        btnSubmitReturnTransaction.addActionListener(new ActionListener() { // Submit button to make return transaction.
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag1 = true;

                // Confirmation to return the transaction:
                JOptionPane.showMessageDialog(rootPane, "Make sure to collect payment and game from the customer!", "", 1);
                int inp = JOptionPane.showConfirmDialog(rootPane, "Return the transaction?", "", 0, 2);
                
                if (inp == 0) {
                    int indexFromSR = Integer.parseInt(txtfldSR.getText()) - 1; // Will be used to navigate rentalList.
                    txtfldSR.setText("");
                    
                    for (int i = 0; i < Main.customerCounter + 1; i++) { // Will be used to decrement ongoing rentals from the customer.
                        Customer temp = Main.customerList.get(i);
                        String tempCnic = temp.getCnic();
                        
                        if (tempCnic.equals(Main.rentalList.get(indexFromSR).getCustomerCnic())) {
                            temp.decrementOngoingRentals();
                            Main.customerList.set(i, temp); // Replacing old data with updated data (ongoing rentals)
                            
                            Main.rentalList.remove(indexFromSR);
                            System.out.println(Main.rentalList + "\n"); // (test display)
                            
                            Main.rentalCounter--;
                            
                            Main.populateRentalsInFile(); // Rental ArrayList gets written in the file.
                            Main.populateCustomersInFile(); // Customer ArrayList gets written in the file.
                            flag1 = false;
                            break;
                        }
                    }
                }
                
                if (!flag1) {
                    // Success notfication:
                    JOptionPane.showMessageDialog(rootPane, "Return succesful!", "", 1);
                    
                    // Resetting text fields:
                    txtfldSR.setText("");
                    
                    // Calling dashboard panel:
                    getContentPane().removeAll();
                    panelDashboard.setVisible(true);
                    add(panelDashboard);
                    panelDashboard.revalidate();
                    panelDashboard.repaint();
                }
                
                if (flag1) {
                    JOptionPane.showMessageDialog(rootPane, "Something went wrong! Try again", "", 0);
                    txtfldSR.setText("");
                }
            }
        });
        btnSubmitAddGame.addActionListener(new ActionListener() {           // Submit button to add a game.
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag1 = false;

                for (int i = 0; i < Main.gameCounter + 1; i++) {
                    Game tempGame = Main.gameList.get(i);
                    String tempGameId = tempGame.getGameId();

                    // Checking whether game id already exists.
                    if (tempGameId.equals(txtfldGameId.getText())) {
                        JOptionPane.showMessageDialog(rootPane, "Game ID already exists in the database! try again.", "", 0);
                        flag1 = true;
                        break;
                    }
                }

                if (!flag1) {
                    // Converting String data to Integer:
                    int totalCopies = Integer.parseInt(txtfldGameTotalCopies.getText());

                    // Passing user entered data, consequently creating a new object for gameList:
                    if (rdBtnPlatformXBOX.isSelected()) {
                        Main.addVideoGame(txtfldGameId.getText(), txtfldGameTitle.getText(), 
                            "XBOX",totalCopies, /*rentedCopies,*/ txtfldGamePrice.getText());
                    }
                    else if (rdBtnPlatformPS4.isSelected()) {
                        Main.addVideoGame(txtfldGameId.getText(), txtfldGameTitle.getText(), 
                            "PS4",totalCopies, /*rentedCopies,*/ txtfldGamePrice.getText());
                    }

                    System.out.println(Main.gameList + "\n"); // (test display)

                    // Resetting of text fields and game counter for dashboard panel:
                    txtfldGameId.setText("");
                    txtfldGameTitle.setText("");
                    platf.clearSelection();
                    txtfldGameTotalCopies.setText("");
                    txtfldGamePrice.setText("");
                    lblTotalGame.setText("Total Video Games: " + (Main.gameCounter + 1));
                    
                    // Success notification:
                    JOptionPane.showMessageDialog(rootPane, "Game added successfully!", "", 1); 
                    
                    // Calling dashboard panel:
                    getContentPane().removeAll();
                    panelDashboard.setVisible(true);
                    add(panelDashboard);
                    panelDashboard.revalidate();
                    panelDashboard.repaint();
                }
            }
        });
        btnSubmitUpdateGame.addActionListener(new ActionListener() {        // Submit button to update existing game.
        @Override
            public void actionPerformed(ActionEvent e) {
                // Converting String data to Integer:
                int totalCopies = Integer.parseInt(txtfldGameTotalCopies.getText());

                // Passing user entered data, consequently updating an existing object of gameList:
               
                if (rdBtnPlatformXBOX.isSelected()) {
                    Main.updateVideoGame(txtfldValidateGame.getText(), txtfldGameTitle.getText(), 
                        "XBOX", totalCopies, txtfldGamePrice.getText());
                }
                else if (rdBtnPlatformPS4.isSelected()) {
                    Main.updateVideoGame(txtfldValidateGame.getText(), txtfldGameTitle.getText(), 
                        "XBOX", totalCopies, txtfldGamePrice.getText());
                }
                
                // Resetting text fields and radio buttons:
                txtfldValidateGame.setText("");
                txtfldGameTitle.setText("");
                platf.clearSelection();
                txtfldGameTotalCopies.setText("");
                txtfldGamePrice.setText("");
                
                // Validation messages:
                if (flagValidation) { // When game data is updated successfully.
                    System.out.println(Main.gameList + "\n"); // (test display)
                    JOptionPane.showMessageDialog(rootPane, "Updated successfully!", "", 1);    
                    
                    // Calling dashboard panel:
                    getContentPane().removeAll();
                    panelDashboard.setVisible(true);
                    add(panelDashboard);
                    panelDashboard.revalidate();
                    panelDashboard.repaint();
                }
                
                else if (!flagValidation){ // When game data could not be updated (error: incorrect game ID).
                    System.out.println("INVALID GAME ID\n");
                    JOptionPane.showMessageDialog(rootPane, "Update failed! Please enter correct game ID", "", 0); 
                } 
            }
        });
        btnSubmitRemoveGame.addActionListener(new ActionListener() {        // Submit button for removing an existing game.
            @Override
            public void actionPerformed(ActionEvent e) {
                int inp = JOptionPane.showConfirmDialog(rootPane, "Do you really wish to remove this game?", "", 0, 2);

                if (inp == 0) {
                    // Passing user entered data, consequently removing an existing object of gameList:
                    Main.removeVideoGame(txtfldValidateGame.getText());

                    // Resetting text field
                    txtfldValidateGame.setText("");

                    // Validation messages:
                    if (flagValidation) { // When game data is removed successfully.
                        System.out.println(Main.gameList + "\n"); // (test display)
                        JOptionPane.showMessageDialog(rootPane,"Removed successfully!", "", 1);

                        // Resetting dashboard panel game label:
                        lblTotalGame.setText("Total Video Games: " + (Main.gameCounter + 1));

                        // Calling dashboard panel:
                        getContentPane().removeAll();
                        panelDashboard.setVisible(true);
                        add(panelDashboard);
                        panelDashboard.revalidate();
                        panelDashboard.repaint();        
                    }
                    else if (!flagValidation) { // error: incorrect game ID, hence could not be removed.
                        JOptionPane.showMessageDialog(rootPane, "Remove failed! Please enter correct game ID", "", 0); 
                    }
                }
                
                else if (inp == 1) {
                    JOptionPane.showMessageDialog(rootPane, "Nothing was removed.", "", 1);
                    txtfldValidateGame.setText("");
                }
            }
        });
        btnSubmitAddCustomer.addActionListener(new ActionListener() {       // Submit button to add a new customer.
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag1 = false;

                for (int i = 0; i < Main.customerCounter + 1; i++) {
                    Customer tempCustomer = Main.customerList.get(i);
                    String tempCnin = tempCustomer.getCnic();

                    // Checking whether cnic already exists.
                    if (tempCnin.equals(txtfldCnic.getText())) {
                        JOptionPane.showMessageDialog(rootPane, "CNIC already registered with a profile! try again.", "", 0);
                        flag1 = true;
                        break;
                    }
                }

                if (!flag1) {
                    // Passing data to create a new customer object
                    Main.addCustomer(txtfldCnic.getText(), txtfldCustomerName.getText());
                    System.out.println(Main.customerList + "\n"); // (test display)  
                    
                    // Resetting of text fields and customer counter for dashboard panel:
                    txtfldCnic.setText("");
                    txtfldCustomerName.setText("");
                    lblTotalCustomer.setText("Total Registered Customers: " + (Main.customerCounter + 1));
                    
                    // Success notification:
                    JOptionPane.showMessageDialog(rootPane, "Customer profile registered successfully!", "", 1);
                    
                    // Calling dashboard panel:
                    getContentPane().removeAll();
                    panelDashboard.setVisible(true);
                    add(panelDashboard);
                    panelDashboard.revalidate();
                    panelDashboard.repaint();
                }   
            }
        });
        btnSubmitUpdateCustomer.addActionListener(new ActionListener() {    // To update customer object.
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag1 = true;
                
                for (int i = 0; i < Main.customerCounter + 1; i++) {
                    Customer temp = Main.customerList.get(i);
                    String tempCnic = temp.getCnic();
                    
                    if (tempCnic.equals(txtfldValidateCustomer.getText())) {
                        flag1 = false;
                        
                        // Passing data to function in main, to update customer data:
                        Main.updateCustomer(txtfldValidateCustomer.getText(), txtfldCustomerName.getText());
                        System.out.println(Main.customerList + "\n"); // (test display)
                        
                        // Success notification:
                        JOptionPane.showMessageDialog(rootPane, "Customer data has been updated!", "", 1);
                        
                        // Resetting of fields:
                        txtfldCustomerName.setText("");
                        txtfldValidateCustomer.setText("");
                    }
                }
                
                if (flag1) {
                    // If profile is not found, a error message is shown.
                    JOptionPane.showMessageDialog(rootPane, "Customer profile not found! Try again", "", 0);
                }
                
                if (!flag1) {
                    // Calling dashboard panel:
                    getContentPane().removeAll();
                    panelDashboard.setVisible(true);
                    add(panelDashboard);
                    panelDashboard.revalidate();
                    panelDashboard.repaint();
                }
            }
        });
        btnSubmitRemoveCustomer.addActionListener(new ActionListener() {    // To remove a customer object.
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int inp = JOptionPane.showConfirmDialog(rootPane, "Do you want to remove this customer profile?", "", 0, 3);
                
                if (inp == 0) {
                    boolean flag1 = true;
                
                    for (int i = 0; i < Main.customerCounter + 1; i++) {
                        Customer temp = Main.customerList.get(i);
                        String tempCnic = temp.getCnic();

                        if (tempCnic.equals(txtfldValidateCustomer.getText())) {
                            // Passing data to function in main to remove the customer:
                            Main.removeCustomer(txtfldValidateCustomer.getText());
                            System.out.println(Main.customerList + "\n"); // (test display)

                            // Success notification:
                            JOptionPane.showMessageDialog(rootPane, "The customer profile has been deleted.", "", 1);
                            flag1 = false;
                        }
                    }

                    if (flag1) {
                        // When wrong CNIC is entered:
                        JOptionPane.showMessageDialog(rootPane, "Entered CNIC not present in database! Try again.", "", 0);
                    }

                    if (!flag1) {
                        // Resetting dashboard panel customer label:
                        lblTotalCustomer.setText("Total Registered Customers: " + (Main.customerCounter + 1));

                        // Calling dashboard panel:
                        getContentPane().removeAll();
                        panelDashboard.setVisible(true);
                        add(panelDashboard);
                        panelDashboard.revalidate();
                        panelDashboard.repaint();
                    }
                }
                
                else if (inp == 1) {
                    JOptionPane.showMessageDialog(rootPane, "Nothing was removed.", "", 1);
                    txtfldValidateCustomer.setText("");
                }
            }
        });
        btnProceedRemoveStaff.addActionListener(new ActionListener() {      // Proceed button to move to decide whether the acc will be deleted or not.
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtfldCaptcha.getText().equals("I HAVE FULLY READ AND I FULLY AGREE")) {
                    int inp = JOptionPane.showConfirmDialog(rootPane, "You are about to delete your account, proceed?", "Warning!", 0, 2);
                    if (inp == 0) {
                        String passInp = JOptionPane.showInputDialog(rootPane, "Enter your password to delete your account (LAST CHANCE TO REVERT!)");
                        if (passInp.equals(activeLogin.getStaffPassword())) {
                            Main.removeStaff(activeLogin.getStaffUsername()); // Removes staff object from the list.
                            activeLogin = null;
                            dispose();
                            GUIinitial guiinitial = new GUIinitial(); // To call the login/register screen.
                            JOptionPane.showMessageDialog(rootPane, "Your account was deleted.", "", 1);
                            System.out.println(Main.staffList + "\n"); // (test display);
                        }
                        else {
                            JOptionPane.showMessageDialog(rootPane, "Something went wrong!", "", 0);
                            getContentPane().removeAll();
                            panelDashboard.setVisible(true);
                            add(panelDashboard);
                            panelDashboard.revalidate();
                            panelDashboard.repaint();   
                        }
                    }
                    else if (inp == 1) {
                        JOptionPane.showMessageDialog(rootPane, "Redirecting to main menu", "", 1);
                        getContentPane().removeAll();
                        panelDashboard.setVisible(true);
                        add(panelDashboard);
                        panelDashboard.revalidate();
                        panelDashboard.repaint();   
                    }
                }
                else {
                    JOptionPane.showMessageDialog(rootPane, "Incorrect captcha!", "", 0);
                    txtfldCaptcha.setText("");
                }
            }       
        });
        
    } // END OF CONSTRUCTOR.

    
    // FUNCTIONS FOR INITIALIZATION :
    public void initMenuBar() {             // Initializes submenus for menubar.
        menuBar = new JMenuBar();
        menuMain = new JMenu("Main");
        menuGame = new JMenu("Game");
        menuStaff = new JMenu("Staff");
        menuCustomer =  new JMenu("Customer");
        itemAddGame = new JMenuItem("Add");
        itemUpdateGame = new JMenuItem("Update");
        itemRemoveGame = new JMenuItem("Remove");
        itemDisplayGame = new JMenuItem("Game Inventory");
        itemDashboard = new JMenuItem("Dashboard");
        itemRental = new JMenuItem("Make a Rental");
        itemReturn = new JMenuItem("Display or Return");
        itemDisplayStaff = new JMenuItem("Display Members");
        itemRemoveStaff = new JMenuItem("Remove my Account");
        itemLogoutStaff = new JMenuItem("Logout");
        itemAddCustomer = new JMenuItem("Add");
        itemUpdateCustomer = new JMenuItem("Update");
        itemRemoveCustomer = new JMenuItem("Remove");
        itemDisplayCustomer = new JMenuItem("Display Profiles");
    }
    public void initComponents() {          // Initializes all components and panels.
        panelDashboard = new JPanel();
        panelAddGame = new JPanel();
        panelUpdateGame = new JPanel();
        panelRemoveGame = new JPanel();
        panelDisplayGame = new JPanel();
        panelDisplayStaff = new JPanel();
        panelRemoveStaff = new JPanel();
        panelAddCustomer = new JPanel();
        panelUpdateCustomer = new JPanel();
        panelRemoveCustomer = new JPanel();
        panelDisplayCustomer = new JPanel();
        panelRental = new JPanel();
        panelReturn = new JPanel();
        
        lblTotalGame = new JLabel("Total Video Games: " + (Main.gameCounter + 1));
        lblTotalStaff = new JLabel("Total Staff Members: " + (Main.staffCounter + 1));
        lblTotalCustomer = new JLabel("Total Registered Customers: " + (Main.customerCounter + 1));
        lblCompanyName = new JLabel("GameFlix");
        lblProjectName = new JLabel("Video Game Rental System");
        lblAddGameMenu = new JLabel("Add a new Video Game");
        lblUpdateGameMenu = new JLabel("Update a Video Game's data");
        lblRemoveGameMenu = new JLabel("Remove a Video Game");
        lblDisplayGameMenu = new JLabel("Displaying all Video Games");
        lblDisplayStaffMenu = new JLabel("Displaying all Staff members");
        lblGameId = new JLabel("Enter Game ID:");
        lblGameTitle = new JLabel("Enter Title:");
        lblGamePlatform = new JLabel("Select Platform:");
        lblGameTotalCopies = new JLabel("Enter Total Copies:");
        lblGamePrice = new JLabel("Enter Price:");
        lblValidateGame = new JLabel();
        lblRemovalMessage = new JLabel();
        lblCaptcha = new JLabel();
        lblAddCustomerMenu = new JLabel("Add new customer profile");
        lblUpdateCustomerMenu = new JLabel("Update a customer's profile");
        lblRemoveCustomerMenu = new JLabel("Remove a customer's profile");
        lblDisplayCustomerMenu = new JLabel("Displaying customer profiles");
        lblCnic = new JLabel("Enter Customer CNIC:");
        lblCustomerName = new JLabel("Enter Customer Name:");
        lblValidateCustomer = new JLabel();
        lblRentalMenu = new JLabel("Make a Rental transaction");
        lblRentedDays = new JLabel("Enter no. of days to rent:");
        lblIdOfStaff = new JLabel("Staff ID of seller:");
        lblIdOfGame = new JLabel("Game ID of game being sold:");
        lblCnicOfCustomer = new JLabel("CNIC of buyer:");
        lblEnterSR = new JLabel("Enter SR of transaction to return it:");
        lblReturnMenu = new JLabel("Displaying transactions");
        
        txtfldGameId = new JTextField();
        txtfldGameTitle = new JTextField();
        txtfldGameTotalCopies = new JTextField();
        txtfldGamePrice = new JTextField();
        txtfldValidateGame = new JTextField();
        txtfldCaptcha = new JTextField();
        txtfldCnic = new JTextField();
        txtfldCustomerName = new JTextField();
        txtfldValidateCustomer = new JTextField();
        txtfldCnicOfCustomer = new JTextField();
        txtfldIdOfStaff = new JTextField();
        txtfldIdOfGame = new JTextField();
        txtfldlRentedDays = new JTextField();
        txtfldSR = new JTextField();
        
        txtareaRemoveStaff = new JTextArea();
        
        btnSubmitRentalTransaction = new JButton("Submit");
        btnSubmitReturnTransaction = new JButton("Submit");
        btnSubmitAddGame = new JButton("Submit");
        btnSubmitUpdateGame = new JButton("Submit");
        btnSubmitRemoveGame = new JButton("Submit");
        btnSubmitAddCustomer = new JButton("Submit");
        btnSubmitUpdateCustomer = new JButton("Submit");
        btnSubmitRemoveCustomer = new JButton("Submit");
        btnProceedRemoveStaff = new JButton("Proceed");
        
        rdBtnPlatformXBOX = new JRadioButton("XBOX");
        rdBtnPlatformPS4 = new JRadioButton("PS4");
        platf.add(rdBtnPlatformXBOX);
        platf.add(rdBtnPlatformPS4);
        
        fontSubtext = new Font("Calibri", 0, 18);
        
        colorVeryBlue = new Color(24, 29, 49);
        colorWhite = new Color(255,255,255);
    }
    
    
    // FUNCTIONS FOR SETTINGS:
    public void settingsMenuBar() {                 // Settings for menubar.
        menuMain.add(itemDashboard);
        menuMain.add(itemRental);
        menuMain.add(itemReturn);
        menuGame.add(itemAddGame);
        menuGame.add(itemUpdateGame);
        menuGame.add(itemRemoveGame);
        menuGame.add(itemDisplayGame);
        menuStaff.add(itemDisplayStaff);
        menuStaff.add(itemRemoveStaff);
        menuStaff.add(itemLogoutStaff);
        menuCustomer.add(itemAddCustomer);
        menuCustomer.add(itemUpdateCustomer);
        menuCustomer.add(itemRemoveCustomer);
        menuCustomer.add(itemDisplayCustomer);
        
        menuBar.add(menuMain);
        menuBar.add(menuGame);
        menuBar.add(menuStaff);
        menuBar.add(menuCustomer);
        menuBar.setVisible(true);
    }
    public void panelSettingsStats() {              // Settings for Stats panel.
        compSettingsStatsPanel();
        panelDashboard.setLayout(null);
        panelDashboard.setVisible(true);
        panelDashboard.setSize(500,480);
        panelDashboard.setBackground(colorVeryBlue);
        panelDashboard.add(lblTotalGame);
        panelDashboard.add(lblTotalStaff);
        panelDashboard.add(lblTotalCustomer);
        panelDashboard.add(lblCompanyName);
        panelDashboard.add(lblProjectName);
    }
    public void panelSettingsRentalTransactions() {       // Settings for Rental panel.
        compSettingsRentalPanel();
        panelRental.setLayout(null);
        panelRental.setVisible(true);
        panelRental.setSize(500,480);
        panelRental.setBackground(colorVeryBlue);
        panelRental.add(lblRentalMenu);
        panelRental.add(lblCnicOfCustomer);
        panelRental.add(lblIdOfStaff);
        panelRental.add(lblIdOfGame);
        panelRental.add(lblRentedDays);
        panelRental.add(txtfldCnicOfCustomer);
        panelRental.add(txtfldIdOfStaff);
        panelRental.add(txtfldIdOfGame);
        panelRental.add(txtfldlRentedDays);
        panelRental.add(btnSubmitRentalTransaction);
    }
    public void panelSettingsReturn() {                 // Settings for Return panel.
        compSettingsReturnPanel();
        panelReturn.setLayout(null);
        panelReturn.setVisible(true);
        panelReturn.setSize(500,480);
        panelReturn.setBackground(colorVeryBlue);
        panelReturn.add(lblReturnMenu);
        panelReturn.add(tableTransactions);
        panelReturn.add(lblEnterSR);
        panelReturn.add(txtfldSR);
        panelReturn.add(btnSubmitReturnTransaction);
    }
    public void panelSettingsAddGame() {                // Settings for Add game panel.  
        compSettingsAddGamePanel();
        panelAddGame.setLayout(null);
        panelAddGame.setVisible(false);
        panelAddGame.setSize(500,480);
        panelAddGame.setBackground(colorVeryBlue);
        panelAddGame.add(lblAddGameMenu);
        panelAddGame.add(lblGameId);
        panelAddGame.add(lblGameTitle);
        panelAddGame.add(lblGamePlatform);
        panelAddGame.add(lblGameTotalCopies);
        panelAddGame.add(lblGamePrice);
        panelAddGame.add(txtfldGameId);
        panelAddGame.add(txtfldGameTitle);
        panelAddGame.add(txtfldGameTotalCopies);
        panelAddGame.add(txtfldGamePrice);
        panelAddGame.add(btnSubmitAddGame);
        panelAddGame.add(rdBtnPlatformXBOX);
        panelAddGame.add(rdBtnPlatformPS4);
    }
    public void panelSettingsUpdateGame() {         // Settings for Update game panel.
        compSettingsUpdateGamePanel();
        panelUpdateGame.setLayout(null);
        panelUpdateGame.setVisible(false);
        panelUpdateGame.setSize(500,480);
        panelUpdateGame.setBackground(colorVeryBlue);
        panelUpdateGame.add(lblUpdateGameMenu);
        panelUpdateGame.add(lblValidateGame);
        panelUpdateGame.add(lblGameTitle);
        panelUpdateGame.add(lblGamePlatform);
        panelUpdateGame.add(lblGameTotalCopies);
        panelUpdateGame.add(lblGamePrice);
        panelUpdateGame.add(txtfldValidateGame);
        panelUpdateGame.add(txtfldGameTitle);
        panelUpdateGame.add(txtfldGameTotalCopies);
        panelUpdateGame.add(txtfldGamePrice);
        panelUpdateGame.add(btnSubmitUpdateGame);
        panelUpdateGame.add(rdBtnPlatformXBOX);
        panelUpdateGame.add(rdBtnPlatformPS4);
    }
    public void panelSettingsRemoveGame() {         // Settings for Remove game panel.
        compSettingsRemoveGamePanel();
        panelRemoveGame.setLayout(null);
        panelRemoveGame.setVisible(false);
        panelRemoveGame.setSize(500,480);
        panelRemoveGame.setBackground(colorVeryBlue);
        panelRemoveGame.add(lblRemoveGameMenu);
        panelRemoveGame.add(lblValidateGame);
        panelRemoveGame.add(txtfldValidateGame);
        panelRemoveGame.add(btnSubmitRemoveGame);
    }
    public void panelSettingsDisplayGame() {        // Settings for Display game panel.
        compSettingsDisplayGamePanel();
        getContentPane().removeAll();
        panelDisplayGame.setLayout(null);
        panelDisplayGame.setVisible(false);
        panelDisplayGame.setSize(500,480);
        panelDisplayGame.setBackground(colorVeryBlue);
        panelDisplayGame.add(lblDisplayGameMenu);
        panelDisplayGame.add(tableGame);
    }
    public void panelSettingsDisplayStaff() {       // Settings for Display staff panel.
        compSettingsDisplayStaffPanel();
        getContentPane().removeAll();
        panelDisplayStaff.setLayout(null);
        panelDisplayStaff.setVisible(false);
        panelDisplayStaff.setSize(500, 480);
        panelDisplayStaff.setBackground(colorVeryBlue);
        panelDisplayStaff.add(lblDisplayStaffMenu);
        panelDisplayStaff.add(tableStaff);
    }
    public void panelSettingsRemoveStaff() {        // Settings for Remove staff panel.
        compSettingsRemoveStaffPanel();
        panelRemoveStaff.setLayout(null);
        panelRemoveStaff.setVisible(false);
        panelRemoveStaff.setSize(500,480);
        panelRemoveStaff.setBackground(colorVeryBlue);
        panelRemoveStaff.add(lblRemovalMessage);
        panelRemoveStaff.add(lblCaptcha);
        panelRemoveStaff.add(txtfldCaptcha);
        panelRemoveStaff.add(txtareaRemoveStaff);
        panelRemoveStaff.add(btnProceedRemoveStaff);
    }
    public void panelSettingsAddCustomer() {        // Settings for Add customer panel.
        compSettingsAddCustomerPanel();
        panelAddCustomer.setLayout(null);
        panelAddCustomer.setVisible(false);
        panelAddCustomer.setSize(500,480);
        panelAddCustomer.setBackground(colorVeryBlue);
        panelAddCustomer.add(lblAddCustomerMenu);
        panelAddCustomer.add(lblCnic);
        panelAddCustomer.add(lblCustomerName);
        panelAddCustomer.add(txtfldCnic);
        panelAddCustomer.add(txtfldCustomerName);
        panelAddCustomer.add(btnSubmitAddCustomer);
    }
    public void panelSettingsUpdateCustomer() {     // Settings for Update customer panel.
        compSettingsUpdateCustomerPanel();
        panelUpdateCustomer.setLayout(null);
        panelUpdateCustomer.setVisible(false);
        panelUpdateCustomer.setSize(500,480);
        panelUpdateCustomer.setBackground(colorVeryBlue);
        panelUpdateCustomer.add(lblUpdateCustomerMenu);
        panelUpdateCustomer.add(lblValidateCustomer);
        panelUpdateCustomer.add(lblCustomerName);
        panelUpdateCustomer.add(txtfldValidateCustomer);
        panelUpdateCustomer.add(txtfldCustomerName);
        panelUpdateCustomer.add(btnSubmitUpdateCustomer);
    }
    public void panelSettingsRemoveCustomer() {     // Settings for Remove customer panel.
        compSettingsRemoveCustomerPanel();
        panelRemoveCustomer.setLayout(null);
        panelRemoveCustomer.setVisible(false);
        panelRemoveCustomer.setSize(500,480);
        panelRemoveCustomer.setBackground(colorVeryBlue);
        panelRemoveCustomer.add(lblRemoveCustomerMenu);
        panelRemoveCustomer.add(lblValidateCustomer);
        panelRemoveCustomer.add(txtfldValidateCustomer);
        panelRemoveCustomer.add(btnSubmitRemoveCustomer);
    }
    public void panelSettingsDisplayCustomer() {    // Settings for Display customer panel.
        compSettingsDisplayCustomerPanel();
        panelDisplayCustomer.setLayout(null);
        panelDisplayCustomer.setVisible(false);
        panelDisplayCustomer.setSize(500,480);
        panelDisplayCustomer.setBackground(colorVeryBlue);
        panelDisplayCustomer.add(lblDisplayCustomerMenu);
        panelDisplayCustomer.add(tableCustomer);
    }
    
    
    // FUNCTIONS FOR COMPONENT SETTINGS FOR DIFFERENT PANELS:
    public void compSettingsStatsPanel() {                     // Settings for Stats panel.
        lblTotalGame.setBounds(100,195,300,40);
        lblTotalGame.setForeground(colorWhite);
        lblTotalGame.setFont(new Font("Calibri", 0, 18));
        lblTotalStaff.setBounds(100,245,300,40);
        lblTotalStaff.setForeground(colorWhite);
        lblTotalStaff.setFont(new Font("Calibri", 0, 18));
        lblTotalCustomer.setBounds(100,295,300,40);
        lblTotalCustomer.setForeground(colorWhite);
        lblTotalCustomer.setFont(new Font("Calibri", 0, 18));
        lblCompanyName.setFont(new Font("Calibri", 0, 42));
        lblCompanyName.setBounds(165,55,300,50);
        lblCompanyName.setForeground(colorWhite);
        lblProjectName.setFont(fontSubtext);
        lblProjectName.setBounds(146,85,300,50);
        lblProjectName.setForeground(colorWhite);
    }
    public void compSettingsRentalPanel() {               // Settings for Transactions panel.
        lblRentalMenu.setFont(fontSubtext);
        lblRentalMenu.setBounds(145,22,250,50);
        lblRentalMenu.setForeground(colorWhite);
        lblCnicOfCustomer.setBounds(55, 110, 200, 25);
        lblCnicOfCustomer.setForeground(colorWhite);
        lblIdOfStaff.setBounds(55, 160, 200, 25);
        lblIdOfStaff.setForeground(colorWhite);
        lblIdOfGame.setBounds(55, 210, 200, 25);
        lblIdOfGame.setForeground(colorWhite);        
        lblRentedDays.setBounds(55, 260, 200, 25);        
        lblRentedDays.setForeground(colorWhite);
        txtfldCnicOfCustomer.setBounds(250, 110, 180, 25);
        txtfldCnicOfCustomer.setText("");
        txtfldIdOfStaff.setBounds(250, 160, 180, 25);
        txtfldIdOfStaff.setText("");
        txtfldIdOfGame.setBounds(250, 210, 180, 25);
        txtfldIdOfGame.setText("");
        txtfldlRentedDays.setBounds(250, 260, 180, 25);
        txtfldlRentedDays.setText("");
        btnSubmitRentalTransaction.setBounds(202, 360, 80, 25);
    }
    public void compSettingsReturnPanel() {             // Settings for Return panel.
        lblReturnMenu.setFont(fontSubtext);
        lblReturnMenu.setBounds(160,22,250,50);
        lblReturnMenu.setForeground(colorWhite);
        
        lblEnterSR.setBounds(105, 320, 250, 25);
        lblEnterSR.setForeground(colorWhite);
        txtfldSR.setBounds(320, 320, 60, 25);
        txtfldSR.setText("");
        btnSubmitReturnTransaction.setBounds(200, 370, 80, 25);
        
        // Table settings:
        tableTransactions.revalidate();
        tableTransactions.repaint();
        tableTransactions.setDefaultEditor(Object.class, null);
        tableTransactions.setBounds(15,65,455,240);
        tableTransactions.getColumnModel().getColumn(0).setPreferredWidth(5);
        tableTransactions.getColumnModel().getColumn(4).setPreferredWidth(50);
        tableTransactions.getColumnModel().getColumn(5).setPreferredWidth(20);
        
         // Resetting table enteries:
        for (int i = 0; i < 15; i++) {
            tableTransactions.setValueAt("", i, 0);
            tableTransactions.setValueAt("", i, 1);
            tableTransactions.setValueAt("", i, 2);
            tableTransactions.setValueAt("", i, 3);
            tableTransactions.setValueAt("", i, 4);
            tableTransactions.setValueAt("", i, 5);
        }

        // Presetting headings:
        tableTransactions.setValueAt("SR", 0, 0);
        tableTransactions.setValueAt("GAME", 0, 1);
        tableTransactions.setValueAt("CUSTOMER", 0, 2);
        tableTransactions.setValueAt("STAFF", 0, 3);
        tableTransactions.setValueAt("RETURN", 0, 4);
        tableTransactions.setValueAt("PRICE", 0, 5);
        
        // Populating the table with latest data:
        for (int i = 0; i < Main.rentalCounter + 1; i++) {
            String gameTitle, customerName, staffName;
            float price = 0;
            
            gameTitle = new String();
            customerName = new String();
            staffName = new String();
            
            for (int j = 0; j < Main.gameCounter + 1; j++) {    // Will fetch game's title against the entered game ID in rental class.
                Game temp = Main.gameList.get(j);
                String tempId = temp.getGameId();
                if (tempId.equals(Main.rentalList.get(i).getGameId())) {
                    gameTitle = temp.getTitle();
                    int x = Integer.parseInt(Main.rentalList.get(i).getDays());
                    int y = Integer.parseInt(temp.getRentalPrice());
                    price = x * y;
                }
            }
            
            for (int j = 0; j < Main.staffCounter + 1; j++) {    // Will fetch staff's name against the entered staff ID in rental class.
                Staff temp = Main.staffList.get(j);
                String tempId = temp.getStaffId();
                if (tempId.equals(Main.rentalList.get(i).getStaffId())) {
                    staffName = temp.getStaffName();
                }
            }
            
            for (int j = 0; j < Main.customerCounter + 1; j++) {    // Will fetch customer's name against the entered CNIC in rental class.
                Customer temp = Main.customerList.get(j);
                String tempCnic = temp.getCnic();
                if (tempCnic.equals(Main.rentalList.get(i).getCustomerCnic())) {
                    customerName = temp.getName();
                }
            }
            
            tableTransactions.setValueAt(i+1, i+1, 0);
            tableTransactions.setValueAt(gameTitle, i+1, 1);
            tableTransactions.setValueAt(customerName, i+1, 2);
            tableTransactions.setValueAt(staffName, i+1, 3);
            tableTransactions.setValueAt(Main.rentalList.get(i).getRetrn(), i+1, 4);
            tableTransactions.setValueAt(price, i+1, 5);
        }
    }
    public void compSettingsAddGamePanel() {                    // Settings for Add game panel.
        lblAddGameMenu.setFont(fontSubtext);
        lblAddGameMenu.setBounds(165,22,300,50);
        lblAddGameMenu.setForeground(colorWhite);
        lblGameTitle.setBounds(80, 85, 150, 50);
        lblGameTitle.setForeground(colorWhite);
        lblGamePlatform.setBounds(80, 125, 150, 50);
        lblGamePlatform.setForeground(colorWhite);
        lblGameId.setBounds(80, 165, 150, 50);
        lblGameId.setForeground(colorWhite);
        lblGameTotalCopies.setBounds(80, 205, 150, 50);
        lblGameTotalCopies.setForeground(colorWhite);
        lblGamePrice.setBounds(80, 285, 150, 50);
        lblGamePrice.setForeground(colorWhite);
        txtfldGameTitle.setBounds(225, 100, 180, 25);
        txtfldGameTitle.setText("");
        txtfldGameId.setBounds(225, 180, 180, 25);
        txtfldGameId.setText("");
        txtfldGameTotalCopies.setBounds(225, 220, 180, 25);
        txtfldGameTotalCopies.setText("");
        txtfldGamePrice.setBounds(225, 300, 180, 25);
        txtfldGamePrice.setText("");
        btnSubmitAddGame.setBounds(202, 360, 80, 25);
        rdBtnPlatformXBOX.setBounds(225,140,60,20);
        rdBtnPlatformXBOX.setBackground(colorVeryBlue);
        rdBtnPlatformXBOX.setForeground(colorWhite);
        rdBtnPlatformPS4.setBounds(300,140,50,20);
        rdBtnPlatformPS4.setBackground(colorVeryBlue);
        rdBtnPlatformPS4.setForeground(colorWhite);
    }
    public void compSettingsUpdateGamePanel() {                 // Settings for Update game panel.
        lblUpdateGameMenu.setFont(fontSubtext);
        lblUpdateGameMenu.setBounds(145,22,300,50);
        lblUpdateGameMenu.setForeground(colorWhite);        
        lblValidateGame.setText("Enter Game ID to update its data:");
        lblValidateGame.setBounds(45, 70, 300, 50);
        lblValidateGame.setForeground(colorWhite);
        lblGameTitle.setBounds(80, 130, 150, 50);
        lblGameTitle.setForeground(colorWhite);
        lblGamePlatform.setBounds(80, 170, 150, 50);
        lblGamePlatform.setForeground(colorWhite);
        lblGameTotalCopies.setBounds(80, 210, 150, 50);
        lblGameTotalCopies.setForeground(colorWhite);
        lblGamePrice.setBounds(80, 290, 150, 50);
        lblGamePrice.setForeground(colorWhite);
        txtfldValidateGame.setBounds(255, 83, 180, 25);
        txtfldValidateGame.setText("");
        txtfldGameTitle.setBounds(225, 145, 180, 25);
        txtfldGameTitle.setText("");
        txtfldGameTotalCopies.setBounds(225, 225, 180, 25);
        txtfldGameTotalCopies.setText("");
        txtfldGamePrice.setBounds(225, 305, 180, 25);
        txtfldGamePrice.setText("");
        btnSubmitUpdateGame.setBounds(202, 360, 80, 25);
        rdBtnPlatformXBOX.setBounds(225,185,60,20);
        rdBtnPlatformXBOX.setBackground(colorVeryBlue);
        rdBtnPlatformXBOX.setForeground(colorWhite);
        rdBtnPlatformPS4.setBounds(300,185,50,20);
        rdBtnPlatformPS4.setBackground(colorVeryBlue);
        rdBtnPlatformPS4.setForeground(colorWhite);
    }
    public void compSettingsRemoveGamePanel() {                 // Settings for Remove game panel.
        lblRemoveGameMenu.setFont(fontSubtext);
        lblRemoveGameMenu.setBounds(160,22,300,50);
        lblRemoveGameMenu.setForeground(colorWhite);
        lblValidateGame.setText("Enter Game ID to remove its data:");
        lblValidateGame.setBounds(150, 140, 300, 50);
        lblValidateGame.setForeground(colorWhite);
        txtfldValidateGame.setBounds(155, 190, 180, 25);
        txtfldValidateGame.setText("");
        btnSubmitRemoveGame.setBounds(202, 320, 80, 25);
    }
    public void compSettingsDisplayGamePanel() {                // Settings for Display game panel.
        lblDisplayGameMenu.setFont(fontSubtext);
        lblDisplayGameMenu.setBounds(145,22,300,50);
        lblDisplayGameMenu.setForeground(colorWhite);        
        
        tableGame.revalidate();
        tableGame.repaint();
        tableGame.setDefaultEditor(Object.class, null);

        tableGame.setBounds(15,75,455,320);
        tableGame.getColumnModel().getColumn(0).setPreferredWidth(180);
        tableGame.getColumnModel().getColumn(2).setPreferredWidth(45);
        tableGame.getColumnModel().getColumn(4).setPreferredWidth(45);

        // Resetting table enteries:
        for (int i = 0; i < 25; i++) {
            tableGame.setValueAt("", i, 0);
            tableGame.setValueAt("", i, 1);
            tableGame.setValueAt("", i, 2);
            tableGame.setValueAt("", i, 3);
            tableGame.setValueAt("", i, 4);
        }

        // Presetting headings:
        tableGame.setValueAt("TITLE", 0, 0);
        tableGame.setValueAt("PLATFORM", 0, 1);
        tableGame.setValueAt("TOTAL", 0, 2);
        tableGame.setValueAt("GAME ID", 0, 3);
        tableGame.setValueAt("RS", 0, 4);
//        tableGame.setValueAt("RC", 0, 5);
//        tableGame.setValueAt("AC", 0, 6);
        
        // Populating the table with latest data:
        for (int i = 0; i < Main.gameCounter + 1; i++) {
            tableGame.setValueAt(Main.gameList.get(i).getTitle(), i+1, 0);
            tableGame.setValueAt(Main.gameList.get(i).getPlatform(), i+1, 1);
            tableGame.setValueAt(Main.gameList.get(i).getTotalCopies(), i+1, 2);
            tableGame.setValueAt(Main.gameList.get(i).getGameId(), i+1, 3);
            tableGame.setValueAt(Main.gameList.get(i).getRentalPrice(), i+1, 4);
//            tableGame.setValueAt(Main.gameList.get(i).getRentedCopies(), i+1, 5);
//            tableGame.setValueAt(Main.gameList.get(i).getAvailableCopies(), i+1, 6);
        }
    }
    public void compSettingsDisplayStaffPanel() {               // Settings for Display staff panel.
        lblDisplayStaffMenu.setFont(fontSubtext);
        lblDisplayStaffMenu.setBounds(145,22,300,50);
        lblDisplayStaffMenu.setForeground(colorWhite);
        
        tableStaff.revalidate();
        tableStaff.repaint();
        tableStaff.setDefaultEditor(Object.class, null);
        tableStaff.setBounds(15,75,455,320);
        tableStaff.getColumnModel().getColumn(0).setPreferredWidth(10);
        
        // Resetting table enteries:
        for (int i = 0; i < 25; i++) {
            tableStaff.setValueAt("", i, 0);
            tableStaff.setValueAt("", i, 1);
            tableStaff.setValueAt("", i, 2);
        }

        // Presetting headings:
        tableStaff.setValueAt("SR", 0, 0);
        tableStaff.setValueAt("NAME", 0, 1);
        tableStaff.setValueAt("STAFF ID", 0, 2);
        
        // Populating the table with latest data:
        for (int i = 0; i < Main.staffCounter + 1; i++) {
            tableStaff.setValueAt(i+1, i+1, 0);
            tableStaff.setValueAt(Main.staffList.get(i).getStaffName(), i+1, 1);
            tableStaff.setValueAt(Main.staffList.get(i).getStaffId(), i+1, 2);
        }
    }
    public void compSettingsRemoveStaffPanel() {                // Settings for Remove staff panel.
        txtareaRemoveStaff.setBounds(45, 50, 400, 150);
        txtareaRemoveStaff.setBackground(colorVeryBlue);
        txtareaRemoveStaff.setForeground(colorWhite);
        txtareaRemoveStaff.setFont(new Font("Calibri", 0, 16));
        txtareaRemoveStaff.setLineWrap(true);
        txtareaRemoveStaff.setWrapStyleWord(true);
        txtareaRemoveStaff.setEditable(false);
        txtareaRemoveStaff.setFocusable(false);
        txtareaRemoveStaff.setText("BE ADVISED that this action will delete your account and its data entirely from the database. You will not be able to recover your deleted"
                + " account and data, and you will have to register as a new staff account to access the system again.\n\nYou must understand the risk before attempting"
                + " to delete your account, and own full responsibility of your actions.");
        lblCaptcha.setBounds(100,225,350,30);
        lblCaptcha.setText("I HAVE FULLY READ AND I FULLY AGREE");
        lblCaptcha.setForeground(Color.RED);
        lblCaptcha.setFont(fontSubtext);
        lblRemovalMessage.setBounds(95,255,200,50);
        lblRemovalMessage.setText("Fill in the above sentence here:");
        lblRemovalMessage.setForeground(colorWhite);
        txtfldCaptcha.setBounds(95,290,295,30);
        txtfldCaptcha.setText("");
        btnProceedRemoveStaff.setBounds(200, 360, 85, 25);
    }
    public void compSettingsAddCustomerPanel() {                // Settings for Add customer panel.                
        lblAddCustomerMenu.setFont(fontSubtext);
        lblAddCustomerMenu.setBounds(145,22,300,50);
        lblAddCustomerMenu.setForeground(colorWhite);
        lblCnic.setBounds(75, 150, 300, 25);
        lblCnic.setForeground(colorWhite);
        lblCustomerName.setBounds(75, 200, 300, 25);
        lblCustomerName.setForeground(colorWhite);
        txtfldCnic.setBounds(230, 150, 180, 25);
        txtfldCnic.setText("");
        txtfldCustomerName.setBounds(230, 200, 180, 25);
        txtfldCustomerName.setText("");
        btnSubmitAddCustomer.setBounds(200, 300, 80, 25);
    }
    public void compSettingsUpdateCustomerPanel() {             // Settings for Update customer panel.
        lblUpdateCustomerMenu.setFont(fontSubtext);
        lblUpdateCustomerMenu.setBounds(140,22,300,50);
        lblUpdateCustomerMenu.setForeground(colorWhite);
        lblValidateCustomer.setBounds(120, 110, 250, 25);
        lblValidateCustomer.setForeground(colorWhite);
        lblValidateCustomer.setText("Enter customer's CNIC to update their data:");
        lblCustomerName.setBounds(75, 240, 160, 25);
        lblCustomerName.setForeground(colorWhite);
        txtfldValidateCustomer.setBounds(150, 140, 180, 25);
        txtfldValidateCustomer.setText("");
        txtfldCustomerName.setBounds(225, 240, 180, 25);
        txtfldCustomerName.setText("");
        btnSubmitUpdateCustomer.setBounds(200, 320, 80, 25);
    }
    public void compSettingsRemoveCustomerPanel() {             // Settings for Remove customer panel.
        lblRemoveCustomerMenu.setFont(fontSubtext);
        lblRemoveCustomerMenu.setBounds(140,22,300,50);
        lblRemoveCustomerMenu.setForeground(colorWhite);
        lblValidateCustomer.setBounds(120, 150, 250, 25);
        lblValidateCustomer.setForeground(colorWhite);
        lblValidateCustomer.setText("Enter customer's CNIC to update their data:");
        txtfldValidateCustomer.setBounds(155, 190, 180, 25);
        txtfldValidateCustomer.setText("");
        btnSubmitRemoveCustomer.setBounds(200, 320, 80, 25);
        
    }
    public void compSettingsDisplayCustomerPanel() {            // Settings for Display customer panel.
        lblDisplayCustomerMenu.setFont(fontSubtext);
        lblDisplayCustomerMenu.setBounds(145,22,300,50);
        lblDisplayCustomerMenu.setForeground(colorWhite);
        
        tableCustomer.revalidate();
        tableCustomer.repaint();
        tableCustomer.setDefaultEditor(Object.class, null);
        tableCustomer.setBounds(15,75,455,320);
        tableCustomer.getColumnModel().getColumn(0).setPreferredWidth(10);
        tableCustomer.getColumnModel().getColumn(3).setPreferredWidth(10);
        
        // Resetting table enteries:
        for (int i = 0; i < 25; i++) {
            tableCustomer.setValueAt("", i, 0);
            tableCustomer.setValueAt("", i, 1);
            tableCustomer.setValueAt("", i, 2);
            tableCustomer.setValueAt("", i, 3);
        }

        // Presetting headings:
        tableCustomer.setValueAt("SR", 0, 0);
        tableCustomer.setValueAt("NAME", 0, 1);
        tableCustomer.setValueAt("CNIC", 0, 2);
        tableCustomer.setValueAt("RENTALS", 0, 3);
        
        // Populating the table with latest data:
        for (int i = 0; i < Main.customerCounter + 1; i++) {
            tableCustomer.setValueAt(i+1, i+1, 0);
            tableCustomer.setValueAt(Main.customerList.get(i).getName(), i+1, 1);
            tableCustomer.setValueAt(Main.customerList.get(i).getCnic(), i+1, 2);
            tableCustomer.setValueAt(Main.customerList.get(i).getOngoingRentals(), i+1, 3);
        }
    }
    
}
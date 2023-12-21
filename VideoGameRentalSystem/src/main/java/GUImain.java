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
import javax.swing.JTextField;

public class GUImain extends JFrame {

    // DECLARATIONS :
    static boolean flagValidation =  false;

    Font fontSubtext; // Subtext is for general text used everywhere
    Color colorVeryBlue, colorWhite; // VeryBlue for backgrounds, White for foregrounds
    JPanel panelStats, panelAddGame, panelUpdateGame, panelRemoveGame, panelDisplayGame;
    JMenuBar menuBar;
    JMenu menuMain, menuGame, menuStaff, menuCustomer, menuTransaction;
    JMenuItem itemAddGame, itemUpdateGame, itemRemoveGame, itemDisplayGame, itemStats;
    JLabel lblTotalGame, lblTotalStaff, lblTotalCustomer, lblCompanyName, lblProjectName; // for stats panel
    JLabel lblAddGameMenu, lblUpdateGameMenu, lblRemoveGameMenu, lblDisplayGameMenu; //for game menu's sub menus
    JLabel lblGameId, lblGameTitle, lblGamePlatform, lblGameTotalCopies, lblGamePrice /*, lblGameRentedCopies*/; // for add, update game panels
    JLabel lblValidateGame; //for update, remove game panels
    JButton btnSubmitAddGame, btnSubmitUpdateGame, btnSubmitRemoveGame; // submit buttons
    JTable tableTest = new JTable(25, 5);        
    JTextField txtfldGameId, txtfldGameTitle, /*txtfldGamePlatform,*/ txtfldGameTotalCopies, txtfldGamePrice, txtfldValidateGame /*, txtfldGameRentedCopies*/; // for add, update game panels
    JRadioButton rdBtnPlatformXBOX, rdBtnPlatformPS4; // for add, update game panels
    ButtonGroup platf = new ButtonGroup(); // for add, update game panels
    
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
        super.add(panelStats); 
        super.setJMenuBar(menuBar);
        super.setVisible(true);
        
       

        
        
        // ACTION LISTENERS FOR SUBMENU BUTTONS :
        itemStats.addActionListener(new ActionListener() {              // Calls Stats panel.
            @Override
            public void actionPerformed(ActionEvent e) {
                panelSettingsStats();
                getContentPane().removeAll();
                panelStats.setVisible(true);
                add(panelStats);
                panelStats.revalidate();
                panelStats.repaint();
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
        
        
        
        // ACTION LISTENERS FOR ON-PANEL BUTTONS :
        btnSubmitAddGame.addActionListener(new ActionListener() {       // Submit button to add a game.
            @Override
            public void actionPerformed(ActionEvent e) {
                // Converting String data to Integer:
                int totalCopies = Integer.parseInt(txtfldGameTotalCopies.getText());
//                int rentedCopies = Integer.parseInt(txtfldGameRentedCopies.getText());

                // Passing user entered data, consequently creating a new object for gameList:

                if (rdBtnPlatformXBOX.isSelected()) {
                    Main.addVideoGame(txtfldGameId.getText(), txtfldGameTitle.getText(), 
                        "XBOX",totalCopies, /*rentedCopies,*/ txtfldGamePrice.getText());
                }
                else if (rdBtnPlatformPS4.isSelected()) {
                    Main.addVideoGame(txtfldGameId.getText(), txtfldGameTitle.getText(), 
                        "PS4",totalCopies, /*rentedCopies,*/ txtfldGamePrice.getText());
                }

//                Main.addVideoGame(txtfldGameId.getText(), txtfldGameTitle.getText(), 
//                        txtfldGamePlatform.getText(),totalCopies, /*rentedCopies,*/ txtfldGamePrice.getText());
                System.out.println(Main.gameList + "\n"); // (test display)
                // Resetting text fields, radio buttons and stats submenu labels:
                txtfldGameId.setText("");
                txtfldGameTitle.setText("");
//                txtfldGamePlatform.setText("");
                platf.clearSelection();
                txtfldGameTotalCopies.setText("");
//                txtfldGameRentedCopies.setText("");
                txtfldGamePrice.setText("");
                lblTotalGame.setText("Total Video Games: " + (Main.gameCounter + 1));
                // Success notification:
                JOptionPane.showMessageDialog(rootPane, "Game added successfully!"); 
                // Calling Stats panel:
                getContentPane().removeAll();
                panelStats.setVisible(true);
                add(panelStats);
                panelStats.revalidate();
                panelStats.repaint();
            }
        });
        //////for game menu's update game menu:
        btnSubmitUpdateGame.addActionListener(new ActionListener() {    // Submit button to update existing game.
        @Override
            public void actionPerformed(ActionEvent e) {
                // Converting String data to Integer:
                int totalCopies = Integer.parseInt(txtfldGameTotalCopies.getText());
//                int rentedCopies = Integer.parseInt(txtfldGameRentedCopies.getText());
                // Passing user entered data, consequently updating an existing object of gameList:
                
                if (rdBtnPlatformXBOX.isSelected()) {
                    Main.updateVideoGame(txtfldValidateGame.getText(), txtfldGameTitle.getText(), 
                        "XBOX", totalCopies, /*rentedCopies,*/ txtfldGamePrice.getText());
                }
                else if (rdBtnPlatformPS4.isSelected()) {
                    Main.updateVideoGame(txtfldValidateGame.getText(), txtfldGameTitle.getText(), 
                        "XBOX", totalCopies, /*rentedCopies,*/ txtfldGamePrice.getText());
                }
                
//                Main.updateVideoGame(txtfldValidateGame.getText(), txtfldGameTitle.getText(), 
//                        txtfldGamePlatform.getText(), totalCopies, /*rentedCopies,*/ txtfldGamePrice.getText());
                // Resetting text fields and radio buttons:
                txtfldValidateGame.setText("");
                txtfldGameTitle.setText("");
//                txtfldGamePlatform.setText("");
                platf.clearSelection();
                txtfldGameTotalCopies.setText("");
//                txtfldGameRentedCopies.setText("");
                txtfldGamePrice.setText("");
                // Validation messages:
                if (flagValidation) { // When game data is updated successfully.
                    System.out.println(Main.gameList + "\n"); // (test display)
                    JOptionPane.showMessageDialog(rootPane, "Updated successfully!");    
                    // Calling Stats panel:
                    getContentPane().removeAll();
                    panelStats.setVisible(true);
                    add(panelStats);
                    panelStats.revalidate();
                    panelStats.repaint();
                }
                else if (!flagValidation){ // When game data could not be updated (error: incorrect game ID).
                    System.out.println("INVALID GAME ID\n");
                    JOptionPane.showMessageDialog(rootPane, "Update failed! Please enter correct game ID"); 
                } 
            }
        });
        btnSubmitRemoveGame.addActionListener(new ActionListener() {    // Submit button for removing an existing game.
            @Override
            public void actionPerformed(ActionEvent e) {
                // Passing user entered data, consequently removing an existing object of gameList:
                Main.removeVideoGame(txtfldValidateGame.getText());
                // Resetting text field
                txtfldValidateGame.setText("");
                // Validation messages:
                if (flagValidation) { // When game data is removed successfully.
                    System.out.println(Main.gameList + "\n"); // (test display)
                    JOptionPane.showMessageDialog(rootPane,"Removed successfully!");
                    // Resetting Stats panel game label:
                    lblTotalGame.setText("Total Video Games: " + (Main.gameCounter + 1));
                    // Calling Stats panel:
                    getContentPane().removeAll();
                    panelStats.setVisible(true);
                    add(panelStats);
                    panelStats.revalidate();
                    panelStats.repaint();        
                }
                else if (!flagValidation) { // error: incorrect game ID, hence could not be removed.
                    System.out.println("INVALID GAME ID\n");
                    JOptionPane.showMessageDialog(rootPane, "Remove failed! Please enter correct game ID"); 
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
        menuTransaction = new JMenu("Transaction");    
        itemAddGame = new JMenuItem("Add Game");
        itemUpdateGame = new JMenuItem("Update Game");
        itemRemoveGame = new JMenuItem("Remove Game");
        itemDisplayGame = new JMenuItem("Display Game");
        itemStats = new JMenuItem("Stats");
    }
    public void initComponents() {          // Initializes all components and panels.
        panelStats = new JPanel();
        panelAddGame = new JPanel();
        panelUpdateGame = new JPanel();
        panelRemoveGame = new JPanel();
        panelDisplayGame = new JPanel();
        
        lblTotalGame = new JLabel("Total Video Games: " + (Main.gameCounter + 1));
        lblTotalStaff = new JLabel("Total Staff Members: " + (Main.staffCounter + 1));
        lblTotalCustomer = new JLabel("Total Registered Customers: " + (Main.customerCounter + 1));
        lblCompanyName = new JLabel("GameFlix");
        lblProjectName = new JLabel("Video Game Rental System");
        lblAddGameMenu = new JLabel("Add a new Video Game");
        lblUpdateGameMenu = new JLabel("Update a Video Game's data");
        lblRemoveGameMenu = new JLabel("Remove a Video Game");
        lblDisplayGameMenu = new JLabel("Displaying all Video Games");
        lblGameId = new JLabel("Enter Game ID:");
        lblGameTitle = new JLabel("Enter Title:");
        lblGamePlatform = new JLabel("Select Platform:");
        lblGameTotalCopies = new JLabel("Enter Total Copies:");
//        lblGameRentedCopies = new JLabel("Enter Rented Copies:");
        lblGamePrice = new JLabel("Enter Price:");
        lblValidateGame = new JLabel();
        
        txtfldGameId = new JTextField();
        txtfldGameTitle = new JTextField();
//        txtfldGamePlatform = new JTextField();
        txtfldGameTotalCopies = new JTextField();
//        txtfldGameRentedCopies = new JTextField();
        txtfldGamePrice = new JTextField();
        txtfldValidateGame = new JTextField();
        
        btnSubmitAddGame = new JButton("Submit");
        btnSubmitUpdateGame = new JButton("Submit");
        btnSubmitRemoveGame = new JButton("Submit");
        
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
        menuMain.add(itemStats);
        menuGame.add(itemAddGame);
        menuGame.add(itemUpdateGame);
        menuGame.add(itemRemoveGame);
        menuGame.add(itemDisplayGame);
        
        menuBar.add(menuMain);
        menuBar.add(menuGame);
        menuBar.add(menuStaff);
        menuBar.add(menuCustomer);
        menuBar.add(menuTransaction);
        menuBar.setVisible(true);
    }
    public void panelSettingsStats() {              // Settings for Stats panel.
        compSettingsStatsPanel();
        panelStats.setLayout(null);
        panelStats.setVisible(true);
        panelStats.setSize(500,480);
        panelStats.setBackground(colorVeryBlue);
        panelStats.add(lblTotalGame);
        panelStats.add(lblTotalStaff);
        panelStats.add(lblTotalCustomer);
        panelStats.add(lblCompanyName);
        panelStats.add(lblProjectName);
        
    }    
    public void panelSettingsAddGame() {            // Settings for Add game panel.  
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
//        panelAddGame.add(lblGameRentedCopies);
        panelAddGame.add(lblGamePrice);
        panelAddGame.add(txtfldGameId);
        panelAddGame.add(txtfldGameTitle);
//        panelAddGame.add(txtfldGamePlatform);
        panelAddGame.add(txtfldGameTotalCopies);
//        panelAddGame.add(txtfldGameRentedCopies);
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
//        panelUpdateGame.add(lblGameRentedCopies);
        panelUpdateGame.add(lblGamePrice);
        panelUpdateGame.add(txtfldValidateGame);
        panelUpdateGame.add(txtfldGameTitle);
//        panelUpdateGame.add(txtfldGamePlatform);
        panelUpdateGame.add(txtfldGameTotalCopies);
//        panelUpdateGame.add(txtfldGameRentedCopies);
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
        panelDisplayGame.add(tableTest);
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
//        lblGameRentedCopies.setBounds(80, 245, 150, 50);
//        lblGameRentedCopies.setForeground(colorWhite);
        lblGamePrice.setBounds(80, 285, 150, 50);
        lblGamePrice.setForeground(colorWhite);
        txtfldGameTitle.setBounds(225, 100, 180, 25);
        txtfldGameTitle.setText("");
//        txtfldGamePlatform.setBounds(225, 140, 180, 25);
        txtfldGameId.setBounds(225, 180, 180, 25);
        txtfldGameId.setText("");
        txtfldGameTotalCopies.setBounds(225, 220, 180, 25);
        txtfldGameTotalCopies.setText("");
//        txtfldGameRentedCopies.setBounds(225, 260, 180, 25);
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
//        lblGameRentedCopies.setBounds(80, 250, 150, 50);
//        lblGameRentedCopies.setForeground(colorWhite);
        lblGamePrice.setBounds(80, 290, 150, 50);
        lblGamePrice.setForeground(colorWhite);
        txtfldValidateGame.setBounds(255, 83, 180, 25);
        txtfldValidateGame.setText("");
        txtfldGameTitle.setBounds(225, 145, 180, 25);
        txtfldGameTitle.setText("");
//        txtfldGamePlatform.setBounds(225, 185, 180, 25);
        txtfldGameTotalCopies.setBounds(225, 225, 180, 25);
        txtfldGameTotalCopies.setText("");
//        txtfldGameRentedCopies.setBounds(225, 265, 180, 25);
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
        
        tableTest.revalidate();
        tableTest.repaint();

        tableTest.setBounds(15,75,455,320);
        tableTest.getColumnModel().getColumn(0).setPreferredWidth(200);
//        tableTest.getColumnModel().getColumn(1).setPreferredWidth(45);
        tableTest.getColumnModel().getColumn(2).setPreferredWidth(45);
//        tableTest.getColumnModel().getColumn(3).setPreferredWidth(85);
        tableTest.getColumnModel().getColumn(4).setPreferredWidth(45);
//        tableTest.getColumnModel().getColumn(5).setPreferredWidth(40);
//        tableTest.getColumnModel().getColumn(6).setPreferredWidth(40);
        
        
        
        // Resetting table enteries:
        for (int i = 0; i < 25; i++) {
            tableTest.setValueAt("", i, 0);
            tableTest.setValueAt("", i, 1);
            tableTest.setValueAt("", i, 2);
            tableTest.setValueAt("", i, 3);
            tableTest.setValueAt("", i, 4);
        }

        // Presetting headings:
        tableTest.setValueAt("TITLE", 0, 0);
        tableTest.setValueAt("PLATFORM", 0, 1);
        tableTest.setValueAt("TOTAL", 0, 2);
        tableTest.setValueAt("GAME ID", 0, 3);
        tableTest.setValueAt("RS", 0, 4);
//        tableTest.setValueAt("RC", 0, 5);
//        tableTest.setValueAt("AC", 0, 6);
        
        // Populating the table with latest data:
        for (int i = 0; i < Main.gameCounter + 1; i++) {
            tableTest.setValueAt(Main.gameList.get(i).getTitle(), i+1, 0);
            tableTest.setValueAt(Main.gameList.get(i).getPlatform(), i+1, 1);
            tableTest.setValueAt(Main.gameList.get(i).getTotalCopies(), i+1, 2);
            tableTest.setValueAt(Main.gameList.get(i).getGameId(), i+1, 3);
            tableTest.setValueAt(Main.gameList.get(i).getRentalPrice(), i+1, 4);

//            tableTest.setValueAt(Main.gameList.get(i).getRentedCopies(), i+1, 5);
//            tableTest.setValueAt(Main.gameList.get(i).getAvailableCopies(), i+1, 6);
        }
        

    }
    
    
    
}
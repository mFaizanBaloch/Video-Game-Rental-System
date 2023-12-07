//FA22-BCS-114 Saad Shahzad
//FA22-BCS-134 Haider Ali
//FA22-BCS-135 Mohammad Faizan
//Project Title: Video Game Rental System

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

public class GUImain extends JFrame{
    // FLAGS:
    static boolean flagValidation=  false;


    // PANELS:
    JPanel panelStats = new JPanel();
    JPanel panelAddGame = new JPanel();
    JPanel panelUpdateGame = new JPanel();
    JPanel panelRemoveGame = new JPanel();
    JPanel panelDisplayGame = new JPanel();
    
    // MENU:
    JMenuBar menuBar = new JMenuBar();
    JMenu menuMain = new JMenu("Main");
    JMenu menuGame = new JMenu("Game");
    JMenu menuStaff = new JMenu("Staff");
    JMenu menuCustomer =  new JMenu("Customer");
    JMenu menuTransaction = new JMenu("Transaction");    
    JMenuItem itemAddGame = new JMenuItem("Add Game");
    JMenuItem itemUpdateGame = new JMenuItem("Update Game");
    JMenuItem itemRemoveGame = new JMenuItem("Remove Game");
    JMenuItem itemDisplayGame = new JMenuItem("Display Game");
    JMenuItem itemStats = new JMenuItem("Stats");
    
    // LABELS:
    //////for main menu (stats):
    JLabel lblTotalGame = new JLabel("Total Video Games: " + (Main.gameCounter + 1));
    JLabel lblTotalStaff = new JLabel("Total Staff Members: " + (Main.staffCounter + 1));
    JLabel lblTotalCustomer = new JLabel("Total Registered Customers: " + (Main.customerCounter + 1));
    JLabel lblCompanyName = new JLabel("GameFlix");
    JLabel lblProjectName = new JLabel("Video Game Rental System");
    //////for game menu (submenus):
    JLabel lblAddGameMenu = new JLabel("Add a new Video Game");
    JLabel lblUpdateGameMenu = new JLabel("Update a Video Game's data");
    JLabel lblRemoveGameMenu = new JLabel("Remove a Video Game");
    JLabel lblDisplayGameMenu = new JLabel("Displaying all Video Games");
    //////for game menu (add game, update game):
    JLabel lblGameId = new JLabel("Enter Game ID:");
    JLabel lblGameTitle = new JLabel("Enter Title:");
    JLabel lblGamePlatform = new JLabel("Enter Platform:");
    JLabel lblGameTotalCopies = new JLabel("Enter Total Copies:");
    JLabel lblGameRentedCopies = new JLabel("Enter Rented Copies:");
    JLabel lblGamePrice = new JLabel("Enter Price:");
    //////for game menu (update game, remove game):
    JLabel lblValidateGame = new JLabel();
    
    
    // TEXT AREA:
    JTextArea txtareaDisplay = new JTextArea();
    
    
    // TEXT FIELDS:
    //////for game menu's add game panel:
    JTextField txtfldGameId = new JTextField();
    JTextField txtfldGameTitle = new JTextField();
    JTextField txtfldGamePlatform = new JTextField();
    JTextField txtfldGameTotalCopies = new JTextField();
    JTextField txtfldGameRentedCopies = new JTextField();
    JTextField txtfldGamePrice = new JTextField();
    JTextField txtfldValidateGame = new JTextField();
    
    
    // BUTTONS:
    //////for game menu's add game panel:
    JButton btnSubmitAddGame = new JButton("Submit");
    JButton btnSubmitUpdateGame = new JButton("Submit");
    JButton btnSubmitRemoveGame = new JButton("Submit");
    
    // SCROLL PANE:
    JScrollPane scroll;
    // TABLE:
    JTable tableTest;
    
    // FONTS AND COLORS:
    Font fontSubtext = new Font("Calibri", 0, 18);
    Color colorVeryBlue = new Color(24, 29, 49);
    Color colorWhite = new Color(255,255,255);
    
    
    public GUImain(){
        settingsMenuBar(); // Settings for Menu Bar.
        panelSettingsStats(); // Settings for components and panel of Stats.

        // JFRAME SETTINGS:
        super.setTitle("Video Game Rental");
        super.setDefaultCloseOperation(3);
        super.setSize(500, 480);
        super.setResizable(false);
        super.setLayout(null);
        super.setLocationRelativeTo(null);
        super.add(panelStats);
//        super.add(scrlTables);
        super.setJMenuBar(menuBar);
        super.setVisible(true);
        
        
        // ACTION LISTENERS FOR PANELS:
        //////for main menu's stats menu panel call:        
        itemStats.addActionListener(new ActionListener() {
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
        //////for game menu's sub-menu (add game) panel call:
        itemAddGame.addActionListener(new ActionListener() {
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
        //////for game menu's sub-menu (update game) panel call:
        itemUpdateGame.addActionListener(new ActionListener () {
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
        ////// for game menu's sub-menu (remove game) panel call:
        itemRemoveGame.addActionListener(new ActionListener () {
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
        //////for game menu's sub-menu (search game) panel call:
        itemDisplayGame.addActionListener(new ActionListener () {
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
        
        
        
        // ACTION LISTENERS FOR BUTTONS:
        //////for game menu's add game menu:
        btnSubmitAddGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Setting text fields' data to variables:
                String gameId = txtfldGameId.getText();
                String gameTitle = txtfldGameTitle.getText();
                String gamePlatform = txtfldGamePlatform.getText();
                String ttlCps = txtfldGameTotalCopies.getText();
                int totalCopies = Integer.parseInt(ttlCps);
                String rntCps = txtfldGameRentedCopies.getText();
                int rentedCopies = Integer.parseInt(rntCps);
                String gamePrice = txtfldGamePrice.getText();
                // Calling Main class to call add video game function:
                Main.addVideoGame(gameId, gameTitle, gamePlatform, totalCopies, rentedCopies, gamePrice);
                System.out.println(Main.gameList + "\n");
                // Resetting text fields and stats submenu labels:
                txtfldGameId.setText("");
                txtfldGameTitle.setText("");
                txtfldGamePlatform.setText("");
                txtfldGameTotalCopies.setText("");
                txtfldGameRentedCopies.setText("");
                txtfldGamePrice.setText("");
                lblTotalGame.setText("Total Video Games: " + (Main.gameCounter + 1));
                // Success notification:
                JOptionPane.showMessageDialog(rootPane, "Game added successfully!"); 
                // Calling main menu's stats submenu panel:
                getContentPane().removeAll();
                panelStats.setVisible(true);
                add(panelStats);
                panelStats.revalidate();
                panelStats.repaint();
            }
        });
        //////for game menu's update game menu:
        btnSubmitUpdateGame.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                // Getting data fields to store in variables:
                String gameId = txtfldValidateGame.getText();
                String gameTitle = txtfldGameTitle.getText();
                String gamePlatform = txtfldGamePlatform.getText();
                String ttlCps = txtfldGameTotalCopies.getText();
                int totalCopies = Integer.parseInt(ttlCps);
                String rntCps = txtfldGameRentedCopies.getText();
                int rentedCopies = Integer.parseInt(rntCps);
                String gamePrice = txtfldGamePrice.getText(); 
                // Sending variables to Main class and calling function to update game data:
                Main.updateVideoGame(gameId, gameTitle, gamePlatform, totalCopies, rentedCopies, gamePrice);
                // Resetting text fields:
                txtfldValidateGame.setText("");
                txtfldGameTitle.setText("");
                txtfldGamePlatform.setText("");
                txtfldGameTotalCopies.setText("");
                txtfldGameRentedCopies.setText("");
                txtfldGamePrice.setText("");
                // Validation for message dialog box:
                if (flagValidation) { // When game data is updated successfully.
                    System.out.println(Main.gameList + "\n");
                    JOptionPane.showMessageDialog(rootPane, "Updated successfully!");    
                    // Calling main menu's submenu stats panel:
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
        //////for game menu's remove game menu:
        btnSubmitRemoveGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Getting data from text field to store in variable:
                String gameId = txtfldValidateGame.getText();
                // Sending gameID to Main class and calling function to remove game:
                Main.removeVideoGame(gameId);
                // Resetting text field
                txtfldValidateGame.setText("");
                // Validation for message dialog box:
                if (flagValidation) { // When game data is removed successfully.
                    System.out.println(Main.gameList + "\n");
                    JOptionPane.showMessageDialog(rootPane,"Removed successfully!");
                    // Resetting game counter to display on stats menu panel:
                    lblTotalGame.setText("Total Video Games: " + (Main.gameCounter + 1));
                    // Calling main menu's submenu stats panel:
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
        
        
        
        
        
        
        
        
        
    } /*end of constructor*/
    
    
    
    ////////// FUNCTION TO SET MENU BAR:
    public void settingsMenuBar() {
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
    
    
    ////////// FUNCTIONS FOR SETTING PANELS:
    public void panelSettingsStats() {
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
    public void panelSettingsAddGame() {
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
        panelAddGame.add(lblGameRentedCopies);
        panelAddGame.add(lblGamePrice);
        panelAddGame.add(txtfldGameId);
        panelAddGame.add(txtfldGameTitle);
        panelAddGame.add(txtfldGamePlatform);
        panelAddGame.add(txtfldGameTotalCopies);
        panelAddGame.add(txtfldGameRentedCopies);
        panelAddGame.add(txtfldGamePrice);
        panelAddGame.add(btnSubmitAddGame);
    }
    public void panelSettingsUpdateGame() {
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
        panelUpdateGame.add(lblGameRentedCopies);
        panelUpdateGame.add(lblGamePrice);
        panelUpdateGame.add(txtfldValidateGame);
        panelUpdateGame.add(txtfldGameTitle);
        panelUpdateGame.add(txtfldGamePlatform);
        panelUpdateGame.add(txtfldGameTotalCopies);
        panelUpdateGame.add(txtfldGameRentedCopies);
        panelUpdateGame.add(txtfldGamePrice);
        panelUpdateGame.add(btnSubmitUpdateGame);
    }
    public void panelSettingsRemoveGame() {
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
    public void panelSettingsDisplayGame() {
        compSettingsDisplayGamePanel();
        getContentPane().removeAll();
        panelDisplayGame.setLayout(null);
        panelDisplayGame.setVisible(false);
        panelDisplayGame.setSize(500,480);
        panelDisplayGame.setBackground(colorVeryBlue);
        panelDisplayGame.add(lblDisplayGameMenu);
//        panelDisplayGame.add(txtareaDisplay);
        panelDisplayGame.add(tableTest);
    }
    
    
    
    
    
    
    ////////// FUNCTIONS FOR SETTING COMPONENTS TO DIFFERENT PANELS:
     public void compSettingsStatsPanel() {
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
    public void compSettingsAddGamePanel() {
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
        lblGameRentedCopies.setBounds(80, 245, 150, 50);
        lblGameRentedCopies.setForeground(colorWhite);
        lblGamePrice.setBounds(80, 285, 150, 50);
        lblGamePrice.setForeground(colorWhite);
        txtfldGameTitle.setBounds(225, 100, 180, 25);
        txtfldGamePlatform.setBounds(225, 140, 180, 25);
        txtfldGameId.setBounds(225, 180, 180, 25);
        txtfldGameTotalCopies.setBounds(225, 220, 180, 25);
        txtfldGameRentedCopies.setBounds(225, 260, 180, 25);
        txtfldGamePrice.setBounds(225, 300, 180, 25);
        btnSubmitAddGame.setBounds(202, 360, 80, 25);
    }
    public void compSettingsUpdateGamePanel() {
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
        lblGameRentedCopies.setBounds(80, 250, 150, 50);
        lblGameRentedCopies.setForeground(colorWhite);
        lblGamePrice.setBounds(80, 290, 150, 50);
        lblGamePrice.setForeground(colorWhite);
        txtfldValidateGame.setBounds(255, 83, 180, 25);
        txtfldGameTitle.setBounds(225, 145, 180, 25);
        txtfldGamePlatform.setBounds(225, 185, 180, 25);
        txtfldGameTotalCopies.setBounds(225, 225, 180, 25);
        txtfldGameRentedCopies.setBounds(225, 265, 180, 25);
        txtfldGamePrice.setBounds(225, 305, 180, 25);
        btnSubmitUpdateGame.setBounds(202, 360, 80, 25);
    }
    public void compSettingsRemoveGamePanel() {
        lblRemoveGameMenu.setFont(fontSubtext);
        lblRemoveGameMenu.setBounds(160,22,300,50);
        lblRemoveGameMenu.setForeground(colorWhite);
        lblValidateGame.setText("Enter Game ID to remove its data:");
        lblValidateGame.setBounds(150, 140, 300, 50);
        lblValidateGame.setForeground(colorWhite);
        txtfldValidateGame.setBounds(155, 190, 180, 25);
        btnSubmitRemoveGame.setBounds(202, 320, 80, 25);
    }
    public void compSettingsDisplayGamePanel() {
        lblDisplayGameMenu.setFont(fontSubtext);
        lblDisplayGameMenu.setBounds(145,22,300,50);
        lblDisplayGameMenu.setForeground(colorWhite);        
//        txtareaDisplay.setBounds(15, 75, 455, 320);
//        txtareaDisplay.setLineWrap(true);
//        txtareaDisplay.setEditable(false);
//        for (int i = 0; i < Main.gameCounter + 1; i++) {
//            txtareaDisplay.append(Main.gameList.get(i).toString(0));
//        }


        tableTest = new JTable(25, 7);        
        
//        tableTest = new JTable();
        tableTest.setBounds(15,75,455,320);
        tableTest.getColumnModel().getColumn(0).setPreferredWidth(200);
        tableTest.getColumnModel().getColumn(1).setPreferredWidth(45);
        tableTest.getColumnModel().getColumn(2).setPreferredWidth(45);
//        tableTest.getColumnModel().getColumn(3).setPreferredWidth(85);
        tableTest.getColumnModel().getColumn(4).setPreferredWidth(40);
        tableTest.getColumnModel().getColumn(5).setPreferredWidth(40);
        tableTest.getColumnModel().getColumn(6).setPreferredWidth(40);
        
        tableTest.setValueAt("TITLE", 0, 0);
        tableTest.setValueAt("PLT", 0, 1);
        tableTest.setValueAt("RS", 0, 2);
        tableTest.setValueAt("GAME ID", 0, 3);
        tableTest.setValueAt("TC", 0, 4);
        tableTest.setValueAt("RC", 0, 5);
        tableTest.setValueAt("AC", 0, 6);
        
        for (int i = 0; i < Main.gameCounter + 1; i++) {
            tableTest.setValueAt(Main.gameList.get(i).getTitle(), i+1, 0);
            tableTest.setValueAt(Main.gameList.get(i).getPlatform(), i+1, 1);
            tableTest.setValueAt(Main.gameList.get(i).getRentalPrice(), i+1, 2);
            tableTest.setValueAt(Main.gameList.get(i).getGameId(), i+1, 3);
            tableTest.setValueAt(Main.gameList.get(i).getTotalCopies(), i+1, 4);
            tableTest.setValueAt(Main.gameList.get(i).getRentedCopies(), i+1, 5);
            tableTest.setValueAt(Main.gameList.get(i).getAvailableCopies(), i+1, 6);
        }
        
                
    }
    
    
    
}
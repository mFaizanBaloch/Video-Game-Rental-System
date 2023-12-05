//FA22-BCS-114 Saad Shahzad
//FA22-BCS-134 Haider Ali
//FA22-BCS-135 Mohammad Faizan
//Project Title: Video Game Rental System

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUImain extends JFrame{
    // Panels:
    JPanel panelStats = new JPanel();
    JPanel panelAddGame = new JPanel();
    JPanel panelUpdateGame = new JPanel();
    JPanel panelRemoveGame = new JPanel();
    JPanel panelSearchGame = new JPanel();
    
    
    // Menu and related:
    JMenuBar menuBar = new JMenuBar();
    JMenu menuMain = new JMenu("Main");
    JMenu menuGame = new JMenu("Game");
    JMenu menuStaff = new JMenu("Staff");
    JMenu menuCustomer =  new JMenu("Customer");
    JMenu menuTransaction = new JMenu("Transaction");    
    JMenuItem itemAddGame = new JMenuItem("Add Game");
    JMenuItem itemUpdateGame = new JMenuItem("Update Game");
    JMenuItem itemRemoveGame = new JMenuItem("Remove Game");
    JMenuItem itemSearchGame = new JMenuItem("Search Game");
    JMenuItem itemStats = new JMenuItem("Stats");
    
    // Labels:
        //.....for main menu, stats:
    JLabel lblTotalGame = new JLabel("Total Video Games: " + (Main.gameCounter + 1));
    JLabel lblTotalStaff = new JLabel("Total Staff Members: " + (Main.staffCounter + 1));
    JLabel lblTotalCustomer = new JLabel("Total Registered Customers: " + (Main.customerCounter + 1));
    JLabel lblCompanyName = new JLabel("GameFlix");
    JLabel lblProjectName = new JLabel("Video Game Rental System");
        //.....for game menu's sub-menus:
    JLabel lblAddGameMenu = new JLabel("Add a Video Game");
    JLabel lblUpdateGameMenu = new JLabel("Update a Video Game");
    JLabel lblRemoveGameMenu = new JLabel("Remove a Video Game");
    JLabel lblSearchGameMenu = new JLabel("Search and Display a Video Game");
        //.....for game menu's add game panel:
    JLabel lblGameId = new JLabel("Enter Game ID:");
    JLabel lblGameTitle = new JLabel("Enter Title:");
    JLabel lblGamePlatform = new JLabel("Enter Platform:");
    JLabel lblGameTotalCopies = new JLabel("Enter Total Copies:");
    JLabel lblGameRentedCopies = new JLabel("Enter Rented Copies:");
    JLabel lblGamePrice = new JLabel("Enter Price:");
    
    // Text Fields:
        //.....for game menu's add game panel:
    JTextField txtfldGameId = new JTextField();
    JTextField txtfldGameTitle = new JTextField();
    JTextField txtfldGamePlatform = new JTextField();
    JTextField txtfldGameTotalCopies = new JTextField();
    JTextField txtfldGameRentedCopies = new JTextField();
    JTextField txtfldGamePrice = new JTextField();
    
    
    
    // Fonts and Colors:
    Font fontSubtext = new Font("Calibri", 0, 18);
    Color colorVeryBlue = new Color(24, 29, 49);
    Color colorWhite = new Color(255,255,255);
    
    
    public GUImain(){
        // JFrame settings:
        super.setTitle("Video Game Rental");
        super.setDefaultCloseOperation(3);
        super.setSize(500, 480);
        super.setResizable(false);
        super.setLayout(null);
        
        
        // MenuBar settings:
        menuMain.add(itemStats);
        
        menuGame.add(itemAddGame);
        menuGame.add(itemUpdateGame);
        menuGame.add(itemRemoveGame);
        menuGame.add(itemSearchGame);
        
        menuBar.add(menuMain);
        menuBar.add(menuGame);
        menuBar.add(menuStaff);
        menuBar.add(menuCustomer);
        menuBar.add(menuTransaction);
        menuBar.setVisible(true);
        
        
        // Components' settings:
            //.....for main menu's stats panel:
        lblTotalGame.setBounds(100,195,300,40);
        lblTotalGame.setForeground(colorWhite);
        lblTotalStaff.setBounds(100,245,300,40);
        lblTotalStaff.setForeground(colorWhite);
        lblTotalCustomer.setBounds(100,295,300,40);
        lblTotalCustomer.setForeground(colorWhite);
        lblCompanyName.setFont(new Font("Calibri", 0, 42));
        lblCompanyName.setBounds(165,55,300,50);
        lblCompanyName.setForeground(colorWhite);
        lblProjectName.setFont(fontSubtext);
        lblProjectName.setBounds(146,85,300,50);
        lblProjectName.setForeground(colorWhite);
            //.....for game menu's add game panel:
        lblAddGameMenu.setFont(fontSubtext);
        lblAddGameMenu.setBounds(180,22,300,50);
        lblAddGameMenu.setForeground(colorWhite);
        lblGameId.setBounds(80, 100, 150, 50);
        lblGameId.setForeground(colorWhite);
        lblGameTitle.setBounds(80, 140, 150, 50);
        lblGameTitle.setForeground(colorWhite);
        lblGamePlatform.setBounds(80, 180, 150, 50);
        lblGamePlatform.setForeground(colorWhite);
        lblGameTotalCopies.setBounds(80, 220, 150, 50);
        lblGameTotalCopies.setForeground(colorWhite);
        lblGameRentedCopies.setBounds(80, 260, 150, 50);
        lblGameRentedCopies.setForeground(colorWhite);
        lblGamePrice.setBounds(80, 300, 150, 50);
        lblGamePrice.setForeground(colorWhite);
        txtfldGameId.setBounds(225, 115, 180, 25);
        txtfldGameId.setForeground(colorWhite);
        txtfldGameTitle.setBounds(225, 155, 180, 25);
        txtfldGameTitle.setForeground(colorWhite);
        txtfldGamePlatform.setBounds(225, 195, 180, 25);
        txtfldGamePlatform.setForeground(colorWhite);
        txtfldGameTotalCopies.setBounds(225, 235, 180, 25);
        txtfldGameTotalCopies.setForeground(colorWhite);
        txtfldGameRentedCopies.setBounds(225, 275, 180, 25);
        txtfldGameRentedCopies.setForeground(colorWhite);
        txtfldGamePrice.setBounds(225, 315, 180, 25);
        txtfldGamePrice.setForeground(colorWhite);
        
        
        lblUpdateGameMenu.setFont(fontSubtext);
        lblUpdateGameMenu.setBounds(165,22,300,50);
        lblUpdateGameMenu.setForeground(colorWhite);        
        
        lblRemoveGameMenu.setFont(fontSubtext);
        lblRemoveGameMenu.setBounds(165,22,300,50);
        lblRemoveGameMenu.setForeground(colorWhite);
        
        lblSearchGameMenu.setFont(fontSubtext);
        lblSearchGameMenu.setBounds(120,22,300,50);
        lblSearchGameMenu.setForeground(colorWhite);
        
        
        // Panel settings:
            //.....for main menu's stats panel:
        panelStats.setLayout(null);
        panelStats.setVisible(true);
        panelStats.setSize(500,480);
        panelStats.setBackground(colorVeryBlue);
        panelStats.add(lblTotalGame);
        panelStats.add(lblTotalStaff);
        panelStats.add(lblTotalCustomer);
        panelStats.add(lblCompanyName);
        panelStats.add(lblProjectName);
            //.....for game menu's add game panel:
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
        
        panelUpdateGame.setLayout(null);
        panelUpdateGame.setVisible(false);
        panelUpdateGame.setSize(500,480);
        panelUpdateGame.setBackground(colorVeryBlue);
        panelUpdateGame.add(lblUpdateGameMenu);
        
        panelRemoveGame.setLayout(null);
        panelRemoveGame.setVisible(false);
        panelRemoveGame.setSize(500,480);
        panelRemoveGame.setBackground(colorVeryBlue);
        panelRemoveGame.add(lblRemoveGameMenu);
        
        panelSearchGame.setLayout(null);
        panelSearchGame.setVisible(false);
        panelSearchGame.setSize(500,480);
        panelSearchGame.setBackground(colorVeryBlue);
        panelSearchGame.add(lblSearchGameMenu);
        
        
        
        // Adding to JFrame:
        super.add(panelStats);
        super.add(panelAddGame);
        super.add(panelUpdateGame);
        super.add(panelRemoveGame);
        super.add(panelSearchGame);
        
        super.setJMenuBar(menuBar);
        super.setVisible(true);
        
        
        
        
        
        itemAddGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Calling add game panel:
                getContentPane().removeAll();
                panelAddGame.setVisible(true);
                add(panelAddGame);
                panelAddGame.revalidate();
                panelAddGame.repaint();
            }
        });
        
        itemUpdateGame.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Calling update game panel:
                getContentPane().removeAll();
                panelUpdateGame.setVisible(true);
                add(panelUpdateGame);
                panelUpdateGame.revalidate();
                panelUpdateGame.repaint(); 
            }
        });
        
        itemRemoveGame.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Calling remove game panel:
                getContentPane().removeAll();
                panelRemoveGame.setVisible(true);
                add(panelRemoveGame);
                panelRemoveGame.revalidate();
                panelRemoveGame.repaint(); 
            }
        });
        
        itemSearchGame.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Calling search game panel:
                getContentPane().removeAll();
                panelSearchGame.setVisible(true);
                add(panelSearchGame);
                panelSearchGame.revalidate();
                panelSearchGame.repaint(); 
            }
        });
        
        
        
        itemStats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Calling main menu's stats panel:
                getContentPane().removeAll();
                panelStats.setVisible(true);
                add(panelStats);
                panelStats.revalidate();
                panelStats.repaint();
            }
        });
        
        
        
        
        
        
        
        
    }
       
    
    
}
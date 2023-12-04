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

public class GUImain extends JFrame{
    // Panels:
    JPanel panelStats = new JPanel();
    JPanel panelAddGame = new JPanel();
    JPanel panelUpdateGame = new JPanel();
    
    
    
    // Menu and related:
    JMenuBar menuBar = new JMenuBar();
    JMenu menuMain = new JMenu("Main");
    JMenu menuGame = new JMenu("Game");
    JMenu menuStaff = new JMenu("Staff");
    JMenu menuCustomer =  new JMenu("Customer");
    JMenu menuTransaction = new JMenu("Transaction");    
    JMenuItem itemAddGame = new JMenuItem("Add Game");
    JMenuItem itemUpdateGame = new JMenuItem("Update Game");
    JMenuItem itemStats = new JMenuItem("Stats");
    
    // Labels:
    JLabel lblTotalGame = new JLabel("Total Video Games: " + (Main.gameCounter + 1));
    JLabel lblTotalStaff = new JLabel("Total Staff Members: " + (Main.staffCounter + 1));
    JLabel lblTotalCustomer = new JLabel("Total Registered Customers: " + (Main.customerCounter + 1));
    JLabel lblCompanyName = new JLabel("GameFlix");
    JLabel lblProjectName = new JLabel("Video Game Rental System");
    JLabel lblAddGameMenu = new JLabel("Add a Video Game");
    JLabel lblUpdateGameMenu = new JLabel("Update a Video Game");
    
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
        
        menuBar.add(menuMain);
        menuBar.add(menuGame);
        menuBar.add(menuStaff);
        menuBar.add(menuCustomer);
        menuBar.add(menuTransaction);
        menuBar.setVisible(true);
        
        
        // Components' settings:
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
        
        lblAddGameMenu.setFont(fontSubtext);
        lblAddGameMenu.setBounds(180,30,300,50);
        lblAddGameMenu.setForeground(colorWhite);
        
        lblUpdateGameMenu.setFont(fontSubtext);
        lblUpdateGameMenu.setBounds(165,30,300,50);
        lblUpdateGameMenu.setForeground(colorWhite);        
        
        
        
        // Panel settings:
        panelStats.setLayout(null);
        panelStats.setVisible(true);
        panelStats.setSize(500,480);
        panelStats.setBackground(colorVeryBlue);
        panelStats.add(lblTotalGame);
        panelStats.add(lblTotalStaff);
        panelStats.add(lblTotalCustomer);
        panelStats.add(lblCompanyName);
        panelStats.add(lblProjectName);
        
        panelAddGame.setLayout(null);
        panelAddGame.setVisible(false);
        panelAddGame.setSize(500,480);
        panelAddGame.setBackground(colorVeryBlue);
        panelAddGame.add(lblAddGameMenu);
        
        panelUpdateGame.setLayout(null);
        panelUpdateGame.setVisible(false);
        panelUpdateGame.setSize(500,480);
        panelUpdateGame.setBackground(colorVeryBlue);
        panelUpdateGame.add(lblUpdateGameMenu);
        
        
        
        // Adding to JFrame:
        super.add(panelStats);
        super.add(panelAddGame);
        super.add(panelUpdateGame);
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
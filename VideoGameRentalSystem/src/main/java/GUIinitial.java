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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUIinitial extends JFrame {

    // DECLARATIONS:
    JPanel panelLogin, panelRegister;
    JLabel lblLogin, lblRegister, lblId, lblName, lblUsername, lblPassword, lblScreenSwitch;
    JTextField txtfldId, txtfldName, txtfldUsername;
    JPasswordField passfldPassword;
    JButton btnSubmitLogin, btnSubmitRegister, btnRegisterScreen, btnLoginScreen;
    Font fontHeading;
    Color colorVeryBlue, colorWhite;

    public GUIinitial() {
        initComponents();   // Initializes all components and panels.
        settingsForLogin(); // Sets up first pop up panel (login panel)

        // JFRAME SETTINGS :
        super.setTitle("Portal");
        super.setDefaultCloseOperation(3);
        super.setSize(500, 400);
        super.setResizable(false);
        super.setLayout(null);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
        super.add(panelLogin);

        // ACTION LISTENERS FOR BUTTONS:
        btnRegisterScreen.addActionListener(new ActionListener() {          // Switches to Register screen.
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsForRegister();
                getContentPane().removeAll();
                add(panelRegister);
                panelRegister.revalidate();
                panelRegister.repaint();
            }
        });
        btnLoginScreen.addActionListener(new ActionListener() {             // Switches to Login screen.
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsForLogin();
                getContentPane().removeAll();
                add(panelLogin);
                panelLogin.revalidate();
                panelLogin.repaint();
            }
        });
        btnSubmitRegister.addActionListener(new ActionListener() {          // Registers a new staff account.
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag1 = false;

                for (int i = 0; i < Main.staffCounter + 1; i++) {
                    Staff tempStaff = Main.staffList.get(i);
                    String tempUsername = tempStaff.getStaffUsername();

                    // Checking whether username already exists.
                    if (tempUsername.equals(txtfldUsername.getText())) {
                        System.out.println("username already exists!");
                        JOptionPane.showMessageDialog(rootPane, "Username already exists! try again.", "", 0);
                        flag1 = true;
                        break;
                    }
                }

                if (!flag1) {
                    // Passing data to create a new staff object
                    Main.addStaff(txtfldId.getText(), txtfldName.getText(),
                            txtfldUsername.getText(), String.valueOf(passfldPassword.getPassword()));
                    System.out.println(Main.staffList + "\n"); // (test display)  

                    // Resetting of text fields:
                    txtfldId.setText("");
                    txtfldName.setText("");
                    txtfldUsername.setText("");
                    passfldPassword.setText("");

                    // Success notification:
                    JOptionPane.showMessageDialog(rootPane, "Staff registered successfully!", "", 3);
                    settingsForLogin();
                    getContentPane().removeAll();
                    add(panelLogin);
                    panelLogin.revalidate();
                    panelLogin.repaint();
                }
            }
        });
        btnSubmitLogin.addActionListener(new ActionListener() {             // Login functionality for staff.
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag1 = false;
                Staff forActiveStaff = null;
                // Checking whether username and password match.
                for (int i = 0; i < Main.staffCounter + 1; i++) {
                    Staff tempStaff = Main.staffList.get(i);
                    String tempUsername = tempStaff.getStaffUsername();
                    String tempPassword = tempStaff.getStaffPassword();

                    if (tempUsername.equals(txtfldUsername.getText())) {
                        if (tempPassword.equals(String.valueOf(passfldPassword.getPassword()))) {
                            JOptionPane.showMessageDialog(rootPane, "Login success! Welcome " + tempStaff.getStaffName(), "", 1);
                            forActiveStaff = tempStaff;
                            flag1 = true;
                            break;
                        }
                    }
                }

                // If login is successful.
                if (flag1) {
                    dispose();
                    GUImain guimain = new GUImain();
                    guimain.activeLogin = forActiveStaff; // This sets up the logged in member as active member.
                } // If login fails.
                else if (!flag1) {
                    JOptionPane.showMessageDialog(rootPane, "Incorrect credentials!", "", 0);
                    txtfldUsername.setText("");
                    passfldPassword.setText("");
                }
            }
        });
    }

    // FUNCTION FOR INITIALIZING:
    public void initComponents() {
        panelLogin = new JPanel();
        panelRegister = new JPanel();

        lblLogin = new JLabel("Login");
        lblRegister = new JLabel("Register");
        lblId = new JLabel("Staff ID:");
        lblName = new JLabel("Name:");
        lblUsername = new JLabel("Username:");
        lblPassword = new JLabel("Password:");
        lblScreenSwitch = new JLabel();

        txtfldUsername = new JTextField();
        txtfldId = new JTextField();
        txtfldName = new JTextField();

        passfldPassword = new JPasswordField();

        btnSubmitLogin = new JButton("Submit");
        btnSubmitRegister = new JButton("Submit");
        btnRegisterScreen = new JButton("Register");
        btnLoginScreen = new JButton("Login");

        fontHeading = new Font("Calibri", 0, 24);

        colorVeryBlue = new Color(24, 29, 49);
        colorWhite = new Color(255, 255, 255);
    }

    // FUNCTION FOR SETTING UP COMPONENTS AND PANELS:
    public void settingsForLogin() {
        panelLogin.setLayout(null);
        panelLogin.setVisible(true);
        panelLogin.setSize(500, 400);
        panelLogin.setBackground(colorVeryBlue);

        lblLogin.setFont(fontHeading);
        lblLogin.setBounds(215, 25, 100, 40);
        lblLogin.setForeground(colorWhite);
        lblUsername.setBounds(100, 110, 100, 25);
        lblUsername.setForeground(colorWhite);
        lblPassword.setBounds(100, 150, 100, 25);
        lblPassword.setForeground(colorWhite);
        lblScreenSwitch.setBounds(110, 320, 185, 25);
        lblScreenSwitch.setForeground(colorWhite);
        lblScreenSwitch.setText("No account? Register here:");
        txtfldUsername.setBounds(180, 110, 195, 25);
        txtfldUsername.setText("");
        passfldPassword.setBounds(180, 150, 195, 25);
        passfldPassword.setText("");
        btnSubmitLogin.setBounds(200, 210, 85, 25);
        btnRegisterScreen.setBounds(275, 320, 85, 25);

        panelLogin.add(lblLogin);
        panelLogin.add(lblUsername);
        panelLogin.add(lblPassword);
        panelLogin.add(lblScreenSwitch);
        panelLogin.add(txtfldUsername);
        panelLogin.add(passfldPassword);
        panelLogin.add(btnSubmitLogin);
        panelLogin.add(btnRegisterScreen);
    }

    public void settingsForRegister() {
        panelRegister.setLayout(null);
        panelRegister.setVisible(true);
        panelRegister.setSize(500, 400);
        panelRegister.setBackground(colorVeryBlue);

        lblRegister.setFont(fontHeading);
        lblRegister.setBounds(200, 25, 100, 40);
        lblRegister.setForeground(colorWhite);
        lblId.setBounds(100, 80, 100, 25);
        lblId.setForeground(colorWhite);
        lblName.setBounds(100, 120, 100, 25);
        lblName.setForeground(colorWhite);
        lblUsername.setBounds(100, 160, 100, 25);
        lblUsername.setForeground(colorWhite);
        lblPassword.setBounds(100, 200, 100, 25);
        lblPassword.setForeground(colorWhite);
        lblScreenSwitch.setBounds(100, 320, 185, 25);
        lblScreenSwitch.setForeground(colorWhite);
        lblScreenSwitch.setText("Already registered? Login here:");
        txtfldId.setBounds(180, 80, 195, 25);
        txtfldId.setText("");
        txtfldName.setBounds(180, 120, 195, 25);
        txtfldName.setText("");
        txtfldUsername.setBounds(180, 160, 195, 25);
        txtfldUsername.setText("");
        passfldPassword.setBounds(180, 200, 195, 25);
        passfldPassword.setText("");
        btnSubmitRegister.setBounds(200, 250, 85, 25);
        btnLoginScreen.setBounds(285, 320, 85, 25);

        panelRegister.add(lblRegister);
        panelRegister.add(lblId);
        panelRegister.add(lblName);
        panelRegister.add(lblUsername);
        panelRegister.add(lblPassword);
        panelRegister.add(lblScreenSwitch);
        panelRegister.add(txtfldId);
        panelRegister.add(txtfldName);
        panelRegister.add(txtfldUsername);
        panelRegister.add(passfldPassword);
        panelRegister.add(btnSubmitRegister);
        panelRegister.add(btnLoginScreen);
    }
}
package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JTextField textField;
    JPasswordField passwordField;
    JButton b1,b2;
    Login(){

        JLabel namelabel = new JLabel("Username");
        namelabel.setBounds(40,20,100,30);
        namelabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        namelabel.setForeground(Color.BLACK);
        add(namelabel);

        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        password.setFont(new Font("Tahoma", Font.BOLD, 16));
        password.setForeground(Color.BLACK);
        add(password);

        textField = new JTextField();
        textField.setBounds(150,20,150,30);
        textField.setFont(new Font("Tahoma", Font.ITALIC, 14));
        textField.setBackground(new Color(255, 226, 116));
        add(textField);

        passwordField = new JPasswordField();
        passwordField.setBounds(150,70,150,30);
        passwordField.setFont(new Font("Tahoma", Font.ITALIC, 14));
        passwordField.setBackground(new Color(255, 226, 116));
        add(passwordField);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login1.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel image = new JLabel(imageIcon1);
        image.setBounds(400,-50,400,300);
        add(image);

        b1 = new JButton("Login");
        b1.setBounds(40,150,150,30);
        b1.setBackground(Color.BLACK);
        b1.setFont(new Font("Serif", Font.BOLD, 14));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        b2 = new JButton("Cancel");
        b2.setBounds(200,150,150,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Serif", Font.BOLD, 14));
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(new Color(109,164,170));
        setSize(750,300);
        setLocation(400,250);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Login();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            try{
                conn c = new conn();
                String  user = textField.getText();
                String  pass = passwordField.getText();

                String q = "select * from login where ID = '" + user + "' and psw = '"+pass+"'";
                ResultSet resultSet = c.statement.executeQuery(q);
                if(resultSet.next()){
                    new Reception();
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                }

            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        else{
            System.exit(0);
        }
    }
}

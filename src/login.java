import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login implements ActionListener{
    
    JFrame fr;
    JPanel p,p1,p3,p2;
    JLabel l1,l2,l3;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    
    login(){
        
        fr=new JFrame("LOGIN");
        p =new JPanel();
        p1=new JPanel();
        p2=new JPanel();
        GridLayout lay=new GridLayout(3,2);
        lay.setVgap(30);
        lay.setHgap(10);
        p.setLayout(lay);
        p.setBounds(0,70,300,200);
        
        l3=new JLabel("*STATIONARY MANAGMENT*",SwingConstants.CENTER);
        l3.setVerticalAlignment(SwingConstants.CENTER);
        l3.setFont(new Font("Verdana", Font.PLAIN, 20));
        p1.setBackground(Color.red);
        p1.setBounds(0,10,300,50);
        p1.add(l3);
        
        l1=new JLabel("USERNAME :");
        l1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        t1=new JTextField("");
        
        l2=new JLabel("PASSWORD :");
        l2.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        t2=new JPasswordField("");
        
        b1=new JButton("LOGIN");
        b1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        b1.addActionListener(this);
        b2=new JButton("NEW USER");
        b2.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        b2.addActionListener(this);
        
        p2.setBackground(Color.RED);
        p2.setBounds(20,200,300,30);
        
        
        p.add(l1);
        p.add(t1);
        p.add(l2);
        p.add(t2);
        p.add(b1);
        p.add(b2);
        p3=new JPanel();
        p3.setSize(350,200);
        p3.add(p1);
        p3.add(p);
        fr.add(p3);
        fr.add(p2);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(350,270);
        fr.setLayout(null);
        fr.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
       
        if(e.getSource()==b1){
            String s1,s2;
            s1=t1.getText();
            s2=t2.getText();
            if(s1.equals("")){
                JOptionPane.showMessageDialog(fr,"USERNAME IS REQUIRED","Alert",JOptionPane.WARNING_MESSAGE);
            }
            else if(s1=="" || s2.length()<8){
            JOptionPane.showMessageDialog(fr,"PASSWORD SHOULD BE OF MIN. LENGTH 8!!","Alert",JOptionPane.WARNING_MESSAGE);
        }
            else{
            try{
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dikshant", "root", "");
            PreparedStatement pstmt = con.prepareStatement("select * from login where username=? and password=?");
            pstmt.setString(1,s1);
            pstmt.setString(2,s2);
            
            ResultSet rs=pstmt.executeQuery();
            if(!rs.next()){
                 JOptionPane.showMessageDialog(fr,"NO USER FOUND","Alert",JOptionPane.WARNING_MESSAGE);
            }
            else{
                  JOptionPane.showMessageDialog(fr,"LOGIN SUCCESSFULL");
                  fr.dispose();
                  new shop(rs.getString(1),rs.getString(3),rs.getString(4));
            }
            con.close();
            
            t1.setText("");
            t2.setText("");
            }
            
            catch(Exception fe){
                
            JOptionPane.showMessageDialog(fr,fe.getMessage());
            
        }
            }
    }
        if(e.getSource()==b2){
            //fr.dispose();
            newuser obj=new newuser();
            
            
            
            
        }
    }

    public static void main(String[] args){
        new login();
    }

    

    

    
}
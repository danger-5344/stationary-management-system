import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class newuser implements ActionListener{
    
    JDialog fr;
    JFrame f;
    JPanel p,p1,p2,p3;
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t5;
    JPasswordField t4;
    JButton b1;
   
    
    newuser(){
        f=new JFrame();
        fr=new JDialog(f,"CREATE-ACCOUNT",true);
        
        p =new JPanel();
        p2=new JPanel();
        p3=new JPanel();
     
        GridLayout lay=new GridLayout(6,2);
        lay.setVgap(10);
        lay.setHgap(5);
        p.setLayout(lay);
        p.setBounds(10,70,300,200);
        
        l6=new  JLabel("*CREATE-ACCOUNT*",SwingConstants.CENTER);
        l6.setVerticalAlignment(SwingConstants.CENTER);
        l6.setFont(new Font("Verdana", Font.PLAIN, 20));
        p1=new JPanel();
        p1.setBackground(Color.red);
        p1.setBounds(10,10,300,50);
        p1.add(l6);
        
        l1=new JLabel("NAME :");
        l1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        t1=new JTextField();
        
        l2=new JLabel("USERNAME :");
        l2.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        t2=new JTextField();
        
        l3=new JLabel("EMAIL :");
        l3.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        t3=new JTextField();
        
        l5=new JLabel("PHONE NO. :");
        l5.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        t5=new JTextField();
        
        l4=new JLabel("PASSWORD :");
        l4.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        t4=new JPasswordField();
        
        b1=new JButton("SUBMIT");
        b1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        b1.addActionListener(this);
       
        
         
        p3.setBackground(Color.RED);
        p3.setBounds(10,280,300,35);
        
        p.add(l1);
        p.add(t1);
        p.add(l2);
        p.add(t2);
        p.add(l3);
        p.add(t3);
        p.add(l5);
        p.add(t5);
        p.add(l4);
        p.add(t4);
        p.add(b1);
        
        p2.add(p1);
        p2.add(p);
        p2.setLayout(null);
        p2.setSize(310,270);
        fr.add(p2);
        fr.add(p3);
        
        fr.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        fr.setSize(330,360);
        fr.setLayout(null);
        fr.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
       
        if(e.getSource()==b1){
            String s1,s2,s3,s5,s4;
            s1=t1.getText();
            s2=t2.getText();
            s3=t3.getText();
            s5=t5.getText();
            s4=t4.getText();
            if(s1.equals("") || s2.equals("") || s3.equals("") || s4.equals("") || s5.equals("")){
                JOptionPane.showMessageDialog(fr,"EVERY FIELD IS MANDATORY","Alert",JOptionPane.WARNING_MESSAGE);
            }
            else if(s1=="" || s4.length()<8){
            JOptionPane.showMessageDialog(fr,"PASSWORD SHOULD BE OF MIN. LENGTH 8!!","Alert",JOptionPane.WARNING_MESSAGE);
        }
            else{
            
            try{
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dikshant", "root", "");
            PreparedStatement pstmt = con.prepareStatement("select * from login where username=?");
            pstmt.setString(1,s2);
            
            
            ResultSet rs=pstmt.executeQuery();
            if(!rs.next()){
                  pstmt= con.prepareStatement("insert into login values(?,?,?,?,?)");
                  pstmt.setString(1,s1);
                  pstmt.setString(2,s2);    
                  pstmt.setString(3,s3);
                  pstmt.setString(4,s5);
                  pstmt.setString(5,s4);
                  
                  int i=pstmt.executeUpdate();
                  if(i!=0){
                      JOptionPane.showMessageDialog(fr,"ACCOUNT CREATED SUCCESSFULLY.");
                      fr.dispose();
                      new login();
                  }
                  
            }
            else{
                  JOptionPane.showMessageDialog(fr,"USER ALREADY EXIST!");
            }
            con.close();
            
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t5.setText("");
            t4.setText("");
            }
            
            catch(Exception fe){
                
            JOptionPane.showMessageDialog(fr,fe.getMessage());
            
        }
      }
    }
       
       
    }
    
}
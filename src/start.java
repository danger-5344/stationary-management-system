import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class start{    
JProgressBar jb;    
int i=0,num=0;  
JFrame fr;
JPanel p1,p2;
JLabel l1,l2;
start(){ 
fr=new JFrame("Loading....");
p1=new JPanel();
p2=new JPanel();

l1=new JLabel("*STATIONARY MANAGMENT*",SwingConstants.CENTER);
l1.setFont(new Font("Verdana", Font.PLAIN, 20));
p1.setBackground(Color.red);
p1.setBounds(10,10,300,40);
p1.add(l1);

l2=new JLabel("System Loading Please wait....");
l2.setFont(new Font("System", Font.BOLD, 13));
l2.setForeground(Color.RED);
l2.setBounds(70,70,300,40);



jb=new JProgressBar(0,2000);    
jb.setBounds(35,130,250,20);         
jb.setValue(0);    
jb.setStringPainted(true); 

p2.setBackground(Color.red);
p2.setBounds(10,160,300,30);


fr.add(p1);
fr.add(l2);
fr.add(jb);
fr.add(p2);
fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
fr.setSize(330,230);   
fr.setLayout(null);
fr.setVisible(true);
}    
public void iterate(){    
while(i<=2000){    
  jb.setValue(i); 
  
  i=i+50; 
  
  try{Thread.sleep(150);}catch(Exception e){}    
}
if(i==2050){
l2.setText("-*-System Loaded Successfully-*-");
try{Thread.sleep(1000);}catch(Exception e){} 
fr.dispose();
new login();
}
}    
public static void main(String[] args) {    
    start m=new start();      
    m.iterate();    
}    
}    
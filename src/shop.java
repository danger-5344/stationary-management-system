
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.Component.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class shop implements ItemListener, ActionListener, ChangeListener {

    JFrame fr;
    JPanel p, p1, p2, p3;
    JLabel lp, lq, l1, l2, l3;
    JTextField t1, t2, t3, t4;
    JScrollPane sp1, sp2;
    JCheckBox c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;
    SpinnerModel sm1, sm2, sm3, sm4, sm5, sm6, sm7, sm8, sm9, sm10;
    JSpinner s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;
    int u1, u2, u3, u4, u5, u6, u7, u8, u9, u10;
    JTable jt;
    DefaultTableModel model;
    String col[] = {"PROD-NAME", "QTY.", "U_AMT", "AMT."};
    String data = "";
    JButton b1, b2, bu;
    int sum = 0, bno = 0;
    String sb1, sb2, sb3;

    shop(String st1, String st2, String st3) {
        sb1 = st1;
        sb2 = st2;
        sb3 = st3;
        data = "";
        data = String.format("%-11s : %-11s\n", "Name", sb1);
        data = data + String.format("%-11s : %-11s\n", "Email", sb2);
        data = data + String.format("%-11s : %-11s\n", "Phone No.", sb3);
        fr = new JFrame("STATIONARY SHOP");

        p1 = new JPanel();
        p = new JPanel();
        p.setLayout(null);
        GridLayout lay = new GridLayout(3, 2);
        lay.setVgap(10);
        lay.setHgap(10);

        p1.setLayout(lay);
        p1.setBackground(Color.red);
        p.setBackground(Color.red);
        p1.setBounds(5, 5, 190, 90);
        p.setBounds(10, 10, 200, 100);

        l1 = new JLabel("NAME :");
        l1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        t1 = new JTextField(st1);
        t1.setEnabled(false);

        l2 = new JLabel("EMAIL :");
        l2.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        t2 = new JTextField(st2);
        t2.setEnabled(false);

        l3 = new JLabel("PHONE NO. :");
        l3.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        t3 = new JTextField(st3);
        t3.setEnabled(false);

        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);
        p1.add(l3);
        p1.add(t3);
        p.add(p1);

        lp = new JLabel("PRODUCT");
        lq = new JLabel("QUANTITY");
        c1 = new JCheckBox("Pen");
        c1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {

                s1.setEnabled(e.getStateChange() == 1);
            }
        });
        c2 = new JCheckBox("Pencil");
        c2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {

                s2.setEnabled(e.getStateChange() == 1);
            }
        });
        c3 = new JCheckBox("Eraser");
        c3.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {

                s3.setEnabled(e.getStateChange() == 1);
            }
        });
        c4 = new JCheckBox("Sharpener");
        c4.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {

                s4.setEnabled(e.getStateChange() == 1);
            }
        });
        c5 = new JCheckBox("Ruler");
        c5.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {

                s5.setEnabled(e.getStateChange() == 1);
            }
        });
        c6 = new JCheckBox("Glue");
        c6.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {

                s6.setEnabled(e.getStateChange() == 1);
            }
        });
        c7 = new JCheckBox("Notebook");
        c7.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {

                s7.setEnabled(e.getStateChange() == 1);
            }
        });
        c8 = new JCheckBox("Stapler");
        c8.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {

                s8.setEnabled(e.getStateChange() == 1);
            }
        });
        c9 = new JCheckBox("Tape");
        c9.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {

                s9.setEnabled(e.getStateChange() == 1);
            }
        });
        c10 = new JCheckBox("Scissor");
        c10.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {

                s10.setEnabled(e.getStateChange() == 1);
            }
        });
        sm1 = new SpinnerNumberModel(0, 0, 100, 1);
        sm2 = new SpinnerNumberModel(0, 0, 100, 1);
        sm3 = new SpinnerNumberModel(0, 0, 100, 1);
        sm4 = new SpinnerNumberModel(0, 0, 100, 1);
        sm5 = new SpinnerNumberModel(0, 0, 100, 1);
        sm6 = new SpinnerNumberModel(0, 0, 100, 1);
        sm7 = new SpinnerNumberModel(0, 0, 100, 1);
        sm8 = new SpinnerNumberModel(0, 0, 100, 1);
        sm9 = new SpinnerNumberModel(0, 0, 100, 1);
        sm10 = new SpinnerNumberModel(0, 0, 100, 1);
        s1 = new JSpinner(sm1);
        s1.setEnabled(false);
        s1.addChangeListener(this);
        s2 = new JSpinner(sm2);
        s2.setEnabled(false);
        s2.addChangeListener(this);
        s3 = new JSpinner(sm3);
        s3.setEnabled(false);
        s3.addChangeListener(this);
        s4 = new JSpinner(sm4);
        s4.setEnabled(false);
        s4.addChangeListener(this);
        s5 = new JSpinner(sm5);
        s5.setEnabled(false);
        s5.addChangeListener(this);
        s6 = new JSpinner(sm6);
        s6.setEnabled(false);
        s6.addChangeListener(this);
        s7 = new JSpinner(sm7);
        s7.setEnabled(false);
        s7.addChangeListener(this);
        s8 = new JSpinner(sm8);
        s8.setEnabled(false);
        s8.addChangeListener(this);
        s9 = new JSpinner(sm9);
        s9.setEnabled(false);
        s9.addChangeListener(this);
        s10 = new JSpinner(sm10);
        s10.setEnabled(false);
        s10.addChangeListener(this);
        p2 = new JPanel();
        p2.setLayout(new GridLayout(11, 2, 10, 10));
        p2.add(lp);
        p2.add(lq);
        p2.add(c1);
        p2.add(s1);
        p2.add(c2);
        p2.add(s2);
        p2.add(c3);
        p2.add(s3);
        p2.add(c4);
        p2.add(s4);
        p2.add(c5);
        p2.add(s5);
        p2.add(c6);
        p2.add(s6);
        p2.add(c7);
        p2.add(s7);
        p2.add(c8);
        p2.add(s8);
        p2.add(c9);
        p2.add(s9);
        p2.add(c10);
        p2.add(s10);
        bu = new JButton("UPDATE");
        bu.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        bu.setBounds(50, 460, 100, 20);
        bu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buactionPerformed(e);
            }
        });
        sp1 = new JScrollPane(p2);
        sp1.setBounds(10, 120, 200, 320);
        sp1.setBackground(Color.blue);

        model = new DefaultTableModel(col, 0);
        jt = new JTable(model);
        sp2 = new JScrollPane(jt);
        sp2.setBounds(10, 10, 480, 420);
        p3 = new JPanel();
        p3.setBounds(220, 10, 500, 480);
        p3.setBackground(Color.red);
        p3.setLayout(null);
        b1 = new JButton("Calculate T_Amt.");
        b1.setBounds(10, 440, 150, 20);
        b1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                b1actionPerformed(e);
            }
        });
        b2 = new JButton("Purchase");
        b2.setBounds(390, 440, 100, 20);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                b2actionPerformed(e);
            }
        });
        b2.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        t4 = new JTextField("Total Amount:");
        t4.setBounds(220, 440, 100, 20);

        p3.add(sp2);
        p3.add(b1);
        p3.add(t4);
        p3.add(b2);

        fr.add(p);
        fr.add(sp1);
        fr.add(p3);
        fr.add(bu);

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(750, 540);
        fr.setLayout(null);
        fr.setVisible(true);

    }

    public void buactionPerformed(ActionEvent e) {
        int sno = 0;
        int i = 0, t = 0, t2 = 0, ta = 0;
        model.setRowCount(0);
        if (e.getSource() == bu) {
            if (c1.isSelected()) {

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dikshant", "root", "");
                    PreparedStatement pstmt = con.prepareStatement("select * from item where PRODUCT=?");
                    pstmt.setString(1, c1.getText());
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                        t = rs.getInt(2);
                        ta = rs.getInt(3);
                        if ((ta - u1) < 0) {
                            JOptionPane.showMessageDialog(fr, "Pen Quantity is not Available,Please Select The Quantity Less Than Or Equal To---> " + ta);
                        } else {
                            t2 = u1;
                        }
                    }
                    con.close();
                } catch (Exception fe) {
                    JOptionPane.showMessageDialog(fr, fe.getMessage());
                }

                model.addRow(new Object[]{c1.getText(), String.valueOf(t2), String.valueOf(t), String.valueOf(t * t2)});
                t = 0;
                t2 = 0;
                ta = 0;
                i++;

            }
            if (c2.isSelected()) {

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dikshant", "root", "");
                    PreparedStatement pstmt = con.prepareStatement("select * from item where PRODUCT=?");
                    pstmt.setString(1, c2.getText());
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                        t = rs.getInt(2);
                        ta = rs.getInt(3);
                        if ((ta - u2) < 0) {
                            JOptionPane.showMessageDialog(fr, "Pencil Quantity is not Available,Please Select The Quantity Less Than Or Equal To---> " + ta);
                        } else {
                            t2 = u2;
                        }

                    }
                    con.close();
                } catch (Exception fe) {
                    JOptionPane.showMessageDialog(fr, fe.getMessage());
                }

                model.addRow(new Object[]{c2.getText(), String.valueOf(t2), String.valueOf(t), String.valueOf(t * t2)});
                t = 0;
                t2 = 0;
                ta = 0;
                i++;

            }
            if (c3.isSelected()) {

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dikshant", "root", "");
                    PreparedStatement pstmt = con.prepareStatement("select * from item where PRODUCT=?");
                    pstmt.setString(1, c3.getText());
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                        t = rs.getInt(2);
                        ta = rs.getInt(3);
                        if ((ta - u3) < 0) {
                            JOptionPane.showMessageDialog(fr, "Eraser Quantity is not Available,Please Select The Quantity Less Than Or Equal To---> " + ta);
                        } else {
                            t2 = u3;
                        }

                    }
                    con.close();
                } catch (Exception fe) {
                    JOptionPane.showMessageDialog(fr, fe.getMessage());
                }

                model.addRow(new Object[]{c3.getText(), String.valueOf(t2), String.valueOf(t), String.valueOf(t * t2)});
                t = 0;
                t2 = 0;
                ta = 0;
                i++;

            }
            if (c4.isSelected()) {

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dikshant", "root", "");
                    PreparedStatement pstmt = con.prepareStatement("select * from item where PRODUCT=?");
                    pstmt.setString(1, c4.getText());
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                        t = rs.getInt(2);
                        ta = rs.getInt(3);
                        if ((ta - u4) < 0) {
                            JOptionPane.showMessageDialog(fr, "Sharpener Quantity is not Available,Please Select The Quantity Less Than Or Equal To---> " + ta);
                        } else {
                            t2 = u4;
                        }

                    }
                    con.close();
                } catch (Exception fe) {
                    JOptionPane.showMessageDialog(fr, fe.getMessage());
                }

                model.addRow(new Object[]{c4.getText(), String.valueOf(t2), String.valueOf(t), String.valueOf(t * t2)});
                t = 0;
                t2 = 0;
                ta = 0;
                i++;

            }
            if (c5.isSelected()) {

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dikshant", "root", "");
                    PreparedStatement pstmt = con.prepareStatement("select * from item where PRODUCT=?");
                    pstmt.setString(1, c5.getText());
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                        t = rs.getInt(2);
                        ta = rs.getInt(3);
                        if ((ta - u5) < 0) {
                            JOptionPane.showMessageDialog(fr, "Ruler Quantity is not Available,Please Select The Quantity Less Than Or Equal To---> " + ta);
                        } else {
                            t2 = u5;
                        }
                    }
                    con.close();
                } catch (Exception fe) {
                    JOptionPane.showMessageDialog(fr, fe.getMessage());
                }

                model.addRow(new Object[]{c5.getText(), String.valueOf(t2), String.valueOf(t), String.valueOf(t * t2)});
                t = 0;
                t2 = 0;
                ta = 0;
                i++;

            }
            if (c6.isSelected()) {

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dikshant", "root", "");
                    PreparedStatement pstmt = con.prepareStatement("select * from item where PRODUCT=?");
                    pstmt.setString(1, c6.getText());
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                        t = rs.getInt(2);
                        ta = rs.getInt(3);
                        if ((ta - u6) < 0) {
                            JOptionPane.showMessageDialog(fr, "Glue Quantity is not Available,Please Select The Quantity Less Than Or Equal To---> " + ta);
                        } else {
                            t2 = u6;
                        }
                    }
                    con.close();
                } catch (Exception fe) {
                    JOptionPane.showMessageDialog(fr, fe.getMessage());
                }

                model.addRow(new Object[]{c6.getText(), String.valueOf(t2), String.valueOf(t), String.valueOf(t * t2)});
                t = 0;
                t2 = 0;
                ta = 0;
                i++;

            }
            if (c7.isSelected()) {

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dikshant", "root", "");
                    PreparedStatement pstmt = con.prepareStatement("select * from item where PRODUCT=?");
                    pstmt.setString(1, c7.getText());
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                        t = rs.getInt(2);
                        ta = rs.getInt(3);
                        if ((ta - u7) < 0) {
                            JOptionPane.showMessageDialog(fr, "Notebook Quantity is not Available,Please Select The Quantity Less Than Or Equal To---> " + ta);
                        } else {
                            t2 = u7;
                        }
                    }
                    con.close();
                } catch (Exception fe) {
                    JOptionPane.showMessageDialog(fr, fe.getMessage());
                }

                model.addRow(new Object[]{c7.getText(), String.valueOf(t2), String.valueOf(t), String.valueOf(t * t2)});
                t = 0;
                t2 = 0;
                i++;

            }
            if (c8.isSelected()) {

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dikshant", "root", "");
                    PreparedStatement pstmt = con.prepareStatement("select * from item where PRODUCT=?");
                    pstmt.setString(1, c8.getText());
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                        t = rs.getInt(2);
                        ta = rs.getInt(3);
                        if ((ta - u8) < 0) {
                            JOptionPane.showMessageDialog(fr, "Stapler Quantity is not Available,Please Select The Quantity Less Than Or Equal To---> " + ta);
                        } else {
                            t2 = u8;
                        }
                    }
                    con.close();
                } catch (Exception fe) {
                    JOptionPane.showMessageDialog(fr, fe.getMessage());
                }

                model.addRow(new Object[]{c8.getText(), String.valueOf(t2), String.valueOf(t), String.valueOf(t * t2)});
                t = 0;
                t2 = 0;
                ta = 0;
                i++;

            }
            if (c9.isSelected()) {

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dikshant", "root", "");
                    PreparedStatement pstmt = con.prepareStatement("select * from item where PRODUCT=?");
                    pstmt.setString(1, c9.getText());
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                        t = rs.getInt(2);
                        ta = rs.getInt(3);
                        if ((ta - u9) < 0) {
                            JOptionPane.showMessageDialog(fr, "Tape Quantity is not Available,Please Select The Quantity Less Than Or Equal To---> " + ta);
                        } else {
                            t2 = u9;
                        }
                    }
                    con.close();
                } catch (Exception fe) {
                    JOptionPane.showMessageDialog(fr, fe.getMessage());
                }

                model.addRow(new Object[]{c9.getText(), String.valueOf(t2), String.valueOf(t), String.valueOf(t * t2)});
                t = 0;
                t2 = 0;
                ta = 0;
                i++;

            }
            if (c10.isSelected()) {

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dikshant", "root", "");
                    PreparedStatement pstmt = con.prepareStatement("select * from item where PRODUCT=?");
                    pstmt.setString(1, c10.getText());
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                        t = rs.getInt(2);
                        ta = rs.getInt(3);
                        if ((ta - u10) < 0) {
                            JOptionPane.showMessageDialog(fr, "Scissor Quantity is not Available,Please Select The Quantity Less Than Or Equal To---> " + ta);
                        } else {
                            t2 = u10;
                        }
                    }
                    con.close();
                } catch (Exception fe) {
                    JOptionPane.showMessageDialog(fr, fe.getMessage());
                }

                model.addRow(new Object[]{c10.getText(), String.valueOf(t2), String.valueOf(t), String.valueOf(t * t2)});
                t = 0;
                t2 = 0;
                ta = 0;
                i++;

            }

        }
    }

    public void b1actionPerformed(ActionEvent e) {
        sum = 0;
        if (e.getSource() == b1) {

            for (int j = 0; j < model.getRowCount(); j++) {
                sum = sum + Integer.parseInt((String) model.getValueAt(j, 3));
            }
            t4.setText(String.valueOf(sum));
        }

    }

    public void b2actionPerformed(ActionEvent e) {
        String temp;

        if (sum > 0) {
            int a = JOptionPane.showConfirmDialog(fr, "Do You Want To Purchase?");
            if (a == JOptionPane.YES_OPTION) {

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dikshant", "root", "");
                    java.util.Date date = new java.util.Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    java.sql.Timestamp sqlTime = new java.sql.Timestamp(date.getTime());

                    PreparedStatement pstmt = con.prepareStatement("insert into purchase_data values(?,?,?,?,?,?,?)");
                    PreparedStatement ps = con.prepareStatement("select * from purchase_data");
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
                        bno = rs.getInt(1);
                    }
                    bno = bno + 1;
                    pstmt.setInt(1, bno);
                    pstmt.setString(2, sb1);
                    pstmt.setString(3, sb2);
                    pstmt.setString(4, sb3);
                    pstmt.setDate(5, sqlDate);
                    pstmt.setTimestamp(6, sqlTime);
                    pstmt.setInt(7, sum);
                    int i = pstmt.executeUpdate();

                    if (i != 0) {
                        JOptionPane.showMessageDialog(fr, "PURCHASE COMPLETED");
                    } else {
                        JOptionPane.showMessageDialog(fr, "-*-*-*-SOME-ISSUE-*-*-*-");
                    }

                    con.close();
                } catch (Exception fe) {
                    System.out.println(fe.getMessage());
                }

                data = data + String.format("%-11s : %-11s\n\n", "Bill No.", String.valueOf(bno));
                
                data = data + String.format("%-9s%9s%9s%9s\n", col[0], col[1], col[2], col[3]);
                for (int i = 0; i < model.getRowCount(); i++) {
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        temp = (String) model.getValueAt(i, j);
                        if (j == 0) {
                            data = data + String.format("%-9s", temp);
                        } else {
                            data = data + String.format("%9s", temp);
                        }

                    }
                    data = data + "\n";

                }
                data = data + "------------------------------------\n";
                data = data + String.format("%36s\n", "TOTAL AMOUNT====> " + String.valueOf(sum));

                try {
                    OutputStream out = new FileOutputStream("Bill_Invoice.txt");

                    // Converts the string into bytes
                    byte[] dataBytes = data.getBytes();

                    // Writes data to the output stream
                    out.write(dataBytes);
                    JOptionPane.showMessageDialog(fr, "Data is written to Bill_Invoice.txt.");
                    data = "";
                    data = String.format("%-11s : %-11s\n", "Name", sb1);
                    data = data + String.format("%-11s : %-11s\n", "Email", sb2);
                    data = data + String.format("%-11s : %-11s\n", "Phone No.", sb3);
                    // Closes the output stream
                    out.close();
                } catch (IOException ec) {
                    ec.getStackTrace();
                }
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        u1 = (int) s1.getValue();
        u2 = (int) s2.getValue();
        u3 = (int) s3.getValue();
        u4 = (int) s4.getValue();
        u5 = (int) s5.getValue();
        u6 = (int) s6.getValue();
        u7 = (int) s7.getValue();
        u8 = (int) s8.getValue();
        u9 = (int) s9.getValue();
        u10 = (int) s10.getValue();
    }

    public static void main(String[] args) {
        new shop("dikshant", "dikshant@gmail.com", "6386615077");
    }
}

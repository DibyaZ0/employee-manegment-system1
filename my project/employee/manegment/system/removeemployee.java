package employee.manegment.system;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;

import javax.swing.*;

public class removeemployee extends JFrame implements ActionListener{

    Choice choiceEMPID;

    JButton delete,back;

    removeemployee(){

        JLabel label = new JLabel("EMPLOYEE ID");
        label.setBounds(50,50,150,20);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        add(label);

        choiceEMPID = new Choice();
        choiceEMPID.setBounds(200,50,150,30);
        add(choiceEMPID);

        try{
          connection c = new connection();
          ResultSet resultSet = c.statement.executeQuery("SELECT * FROM employee");
          while(resultSet.next()){
            choiceEMPID.add(resultSet.getString("empid"));
          }
        }catch(Exception e){
            e.printStackTrace();
        }


        JLabel labelName = new JLabel("Name");
        labelName.setBounds(50,100,150,20);
        labelName.setFont(new Font("Tahoma",Font.BOLD,20));
        add(labelName);

        
        JLabel textname = new JLabel();
        textname.setBounds(200,100,150,30);
        add(textname);


        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50,150,150,20);
        labelphone.setFont(new Font("Tahoma",Font.BOLD,20));
        add(labelphone);

        
        JLabel textphone = new JLabel();
        textphone.setBounds(200,150,150,30);
        add(textphone);

        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,200,150,20);
        labelemail.setFont(new Font("Tahoma",Font.BOLD,20));
        add(labelemail);
                
        JLabel textemail = new JLabel();
        textemail.setBounds(200,200,150,30);
        add(textemail);

        try{
           connection c = new connection();
           ResultSet resultSet = c.statement.executeQuery("SELECT * FROM employee WHERE empid = '"+choiceEMPID.getSelectedItem()+"'");
           while(resultSet.next()){
           textname.setText(resultSet.getString("name")); 
           textphone.setText(resultSet.getString("phone")); 
           textemail.setText(resultSet.getString("email")); 


           }
        }catch(Exception e){
          e.printStackTrace();
        }


        choiceEMPID.addItemListener(new ItemListener() {
          @Override
          public void itemStateChanged(ItemEvent e){
            try{
              connection c = new connection();
              ResultSet resultSet = c.statement.executeQuery("SELECT * FROM employee WHERE empid = '"+choiceEMPID.getSelectedItem()+"'");
              while(resultSet.next()){
              textname.setText(resultSet.getString("name")); 
              textphone.setText(resultSet.getString("phone")); 
              textemail.setText(resultSet.getString("email")); 
              } 
            }catch(Exception E){
              E.printStackTrace();
            }
          }
        });

        delete = new JButton("DELETE");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);


        back = new JButton("BACK");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(700,80,200,200);
        add(img);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
        Image i22 = i11.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image = new JLabel(i33);
        image.setBounds(0,0,1120,630);
        add(image);


       setSize(1000,400);
       setLocation(300,200);
       setLayout(null);
       setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
       if(e.getSource()==delete) {
        try{
          connection c = new connection();
          String query = "delete from employee where empid = '"+choiceEMPID.getSelectedItem()+"'";
          c.statement.executeUpdate(query);
          JOptionPane.showMessageDialog(null,"Employee id deleted successfully");
          setVisible(false);
          new main_class();
        }catch(Exception ex){
          ex.printStackTrace();
        }
       }else{
        setVisible(false);
       }
    }
    public static void main(String[] args) {
        new removeemployee();
    }
}

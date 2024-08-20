package employee.manegment.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.sql.ResultSet;


public class viewemployee extends JFrame implements ActionListener{

    JTable table;

    Choice choiceEMP;

    JButton searchbtn,print,update,back;

    viewemployee(){

     getContentPane().setBackground(new Color(255,131,122));
     JLabel search = new JLabel("Search by employee id");
     search.setBounds(20,20,150,30);
     add(search);

     choiceEMP = new Choice();
     choiceEMP.setBounds(180,20,150,30);
     add(choiceEMP);

     try{
        connection c = new connection();
       ResultSet resultSet = c.statement.executeQuery("SELECT * FROM employee");
       while(resultSet.next()){
        choiceEMP.add(resultSet.getString("empid"));
       }
     }catch(Exception e){
         e.printStackTrace();
     }

     table = new JTable();

     try{

      connection c = new connection();
      ResultSet resultSet = c.statement.executeQuery("SELECT * FROM employee");
      table.setModel(DbUtils.resultSetToTableModel(resultSet));

     }catch(Exception e){

      e.printStackTrace();

     }

     JScrollPane jp = new JScrollPane(table);
     jp.setBounds(0,100,900,600);
     add(jp);


     searchbtn = new JButton("Search");
     searchbtn.setBounds(20,70,80,20);
     searchbtn.addActionListener(this);
     add(searchbtn);

     print = new JButton("Print");
     print.setBounds(120,70,80,20);
     print.addActionListener(this);
     add(print);

     update = new JButton("Update");
     update.setBounds(220,70,80,20);
     update.addActionListener(this);
     add(update);

     back = new JButton("Back");
     back.setBounds(320,70,80,20);
     back.addActionListener(this);
     add(back);


       setSize(900,700);
       setLayout(null);
       setLocation(300,100);
       setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
      if(e.getSource() == searchbtn){
        String query = "SELECT * FROM employee WHERE empid = '"+choiceEMP.getSelectedItem()+"'";
        try{
           connection c= new connection();
           ResultSet resultSet = c.statement.executeQuery(query);
           table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch(Exception E){
          E.printStackTrace();
        }
      }else if(e.getSource() == print){
        try{
           table.print();//it can work within 1 line code because in window print is the inbuilt function so it can be properly work.
        }catch(Exception E){
          E.printStackTrace();
        }
      }else if(e.getSource() == update){
        setVisible(false);
        new updateemployee(choiceEMP.getSelectedItem());
      }else{
        setVisible(false);
        new main_class();
      }
    } 
    public static void main(String[] args) {
       new viewemployee();
    }
}

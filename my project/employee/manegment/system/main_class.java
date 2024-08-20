package employee.manegment.system;  

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class main_class extends JFrame {
    main_class() {

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg")); 
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 1120, 630);
        add(img);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(340,155,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        img.add(heading);//here we can add img beacause by adding we can konow that the haeding above the background image


        JButton add = new JButton("Add Employee");
        add.setBounds(350,270,150,40);
        add.setForeground(Color.WHITE);//by using we just change the color of text
        add.setBackground(Color.BLACK);//it is color of backgroung of button
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new addemployee();
                setVisible(false);
            }
        });
        img.add(add);

        JButton view = new JButton("View Employee");
        view.setBounds(565,270,150,40);
        view.setForeground(Color.WHITE);//by using we just change the color of text
        view.setBackground(Color.BLACK);//it is color of backgroung of button
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new viewemployee();
                setVisible(false);
            }
        });
        img.add(view);
        
        JButton rem = new JButton("Remove Employee");
        rem.setBounds(440,370,150,40);
        rem.setForeground(Color.WHITE);//by using we just change the color of text
        rem.setBackground(Color.BLACK);//it is color of backgroung of button
        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new removeemployee();
            }
        });
        img.add(rem);
        
        
        setSize(1120, 630);
        setLocation(250, 100);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new main_class();
    }
}

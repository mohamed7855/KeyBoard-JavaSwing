package project;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
/**
 *
 * @author Omara
 */
public class test3 {
    public static void main(String[] args) {
        JFrame frame=new JFrame();
        JButton b1=new JButton("1");
        JButton b2=new JButton("2");
        JButton b3=new JButton("3");
        
        frame.add(b1); frame.add(b2);
        frame.add(b3);
        FlowLayout f=new FlowLayout(FlowLayout.RIGHT,20,20);
        
        frame.setLayout(f);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
      
        
        
    }
    
}

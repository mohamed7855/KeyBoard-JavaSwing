package project;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;

/**
 *
 * @author Omara
 */
public class action extends buttons implements ActionListener {

   action() {
        FlowLayout f = new FlowLayout(FlowLayout.CENTER);
        setSize(700, 300);

        text = new JTextArea(3, 60);
        text.setLineWrap(true);
        pannel = new JPanel();
        pannel.add(text);
        pannel.setBackground(Color.LIGHT_GRAY);
        pannel.setBounds(100, 60, 700, 200);

        setResizable(false);
        setLayout(f);
        setLocationRelativeTo(null);
        add(pannel);

        p1 = new JPanel();

        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        p1.setBackground(Color.LIGHT_GRAY);
        //p1.setForeground(Color.BLACK);
        for (int i = 0; i < firstRow.length; i++) {

            first_row[i] = new JButton(firstRow[i]);
            first_row[i].setBackground(Color.GRAY);
            first_row[i].setForeground(Color.BLACK);
            first_row[i].addActionListener(this);
            p1.add(first_row[i]);

        }
        add(p1);
        
        for (int i = 0; i < secondRow.length; i++) {
            second_row[i] = new JButton(secondRow[i]);
            if (i == 0) {
                second_row[i].setBackground(Color.CYAN);
                second_row[i].setForeground(Color.BLACK);

            }
            second_row[i].addActionListener(this);
            p2.add(second_row[i]);
        }
        add(p2);
        //p3.setBackground(Color.DARK_GRAY);
        for (int i = 0; i < thirdRow.length; i++) {
            third_row[i] = new JButton(thirdRow[i]);
            if (i == 0 || i == 12) {
                third_row[i].setBackground(Color.CYAN);
                third_row[i].setForeground(Color.BLACK);
            }
            third_row[i].addActionListener(this);
            p3.add(third_row[i]);
        }
        add(p3);
       
        for (int i = 0; i < fourthRow.length; i++) {
            fourth_row[i] = new JButton(fourthRow[i]);
            if (i == 0 || i == 12) {
                fourth_row[i].setBackground(Color.CYAN);
                fourth_row[i].setForeground(Color.BLACK);
            }
            fourth_row[i].addActionListener(this);
            p4.add(fourth_row[i]);
        }
        add(p4);

        for (int i = 0; i < fifthRow.length; i++) {
            fifth_row[i] = new JButton(fifthRow[i]);
            if (i == 0 || i == 1 || i == 3 || i == 4) {
                fifth_row[i].setBackground(Color.CYAN);
                fifth_row[i].setForeground(Color.BLACK);
            }
            fifth_row[i].addActionListener(this);
            p5.add(fifth_row[i]);
        }
        add(p5);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    int flag = 0, caps = 0, ctrlf = 0;
    String copy_txt, cut_txt;

    public String cutText(String x) {
        String temp = this.text.getSelectedText();

        String txt = x;
        int lengthTemp = temp.length();
        int locationOfTemp = txt.indexOf(temp);
        String test = txt.substring(0, locationOfTemp);

        if (locationOfTemp == 0) {
            this.text.setText(x.substring(lengthTemp, txt.length()));
        } else if (txt.length() == (test.length() + lengthTemp)) {
            this.text.setText(txt.substring(0, (txt.length() - lengthTemp)));
        } else {
            temp = txt.substring(0, (locationOfTemp));
            this.text.setText(temp.concat(txt.substring((temp.length() + lengthTemp), (txt.length()))));
        }

        return temp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String txt = text.getText();

        if (e.getSource().equals(third_row[0])) {
            if (caps == 0) {
                caps = 1;
                third_row[0].setForeground(Color.red);
            } else if (caps == 1) {
                caps = 0;
                third_row[0].setForeground(Color.black);
            }
        }
        if (e.getSource().equals(fourth_row[0]) || e.getSource().equals(fourth_row[12])) {
            flag = 1;
            fourth_row[0].setForeground(Color.red);
            fourth_row[12].setForeground(Color.red);
        }

        for (int i = 0; i < firstRow.length - 1; i++) {
            if (e.getSource().equals(first_row[i])) {

                this.text.setText(txt + firstRow[i].toLowerCase());

            }
        }
        for (int i = 1; i < secondRow.length; i++) {

            if (e.getSource().equals(second_row[i])) {
                if (flag == 1 || caps == 1) {
                    this.text.setText(txt + secondRow[i]);
                    flag = 0;
                    fourth_row[0].setForeground(Color.BLACK);
                    fourth_row[12].setForeground(Color.BLACK);
                } else {
                    this.text.setText(txt + secondRow[i].toLowerCase());
                }
            }

        }

        for (int i = 1; i < thirdRow.length - 1; i++) {
            if (e.getSource().equals(third_row[i])) {
                if (flag == 1 || caps == 1) {
                    this.text.setText(txt + thirdRow[i]);
                    flag = 0;
                    fourth_row[0].setForeground(Color.BLACK);
                    fourth_row[12].setForeground(Color.BLACK);
                } else {
                    this.text.setText(txt + thirdRow[i].toLowerCase());
                }
            }
        }

        for (int i = 1; i < fourthRow.length - 1; i++) {
            if (e.getSource().equals(fourth_row[i])) {
                if (flag == 1 || caps == 1) {
                    this.text.setText(txt + fourthRow[i]);
                    flag = 0;
                    fourth_row[0].setForeground(Color.BLACK);
                    fourth_row[12].setForeground(Color.BLACK);
                } else if (ctrlf == 1 && i == 3) {
                    copy_txt = text.getSelectedText();
                    ctrlf = 0;
                } else if (ctrlf == 1 && i == 4) {
                    txt += copy_txt;
                    text.setText(txt);
                    ctrlf = 0;
                } else if (ctrlf == 1 && i == 2) {
                    copy_txt = cutText(txt);
                    ctrlf = 0;
                } else {
                    this.text.setText(txt + fourthRow[i].toLowerCase());
                }
            }
        }

        if (e.getSource().equals(fifth_row[0])) {
            ctrlf = 1;
        }

        if (e.getSource().equals(fifth_row[2])) {
            this.text.setText(txt + " ");
        }
        if (e.getSource().equals(second_row[0])) {
            this.text.setText(txt + "    ");
        }
        if (e.getSource().equals(third_row[12])) {
            this.text.setText(txt + "\n");
        }

        if (e.getSource().equals(first_row[13])) {
            txt = txt.substring(0, txt.length() - 1);
            this.text.setText(txt);
        }


    }
}

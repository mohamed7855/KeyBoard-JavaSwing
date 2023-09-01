package project;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Omara
 */
abstract public class buttons extends JFrame {

    String firstRow[] = {"~", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "+", "   <<---  "};
    JButton[] first_row = new JButton[14];
    String secondRow[] = {"   Tab  ", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "[", "]", "\\"};
    JButton[] second_row = new JButton[secondRow.length];
    String thirdRow[] = {"   Caps   ", "A", "S", "D", "F", "G", "H", "J", "K", "L", ":", "\"", "  Enter  "};
    JButton[] third_row = new JButton[thirdRow.length];
    String fourthRow[] = {"  Shift    ", "Z", "X", "C", "V", "B", "N", "M", ",", ".", "?", "/", "  Shift    "};
    JButton[] fourth_row = new JButton[fourthRow.length];
    String fifthRow[] = {"  Ctrl  ", "   Alt  ", "                              Space                             ", "   Alt  ", "  Ctrl  "};
    JButton[] fifth_row = new JButton[fifthRow.length];
    JTextArea text;
    JPanel p1, p2, p3, p4, p5, pannel;

    abstract protected String cutText(String x);

}

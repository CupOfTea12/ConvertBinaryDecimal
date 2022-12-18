/*
Code made by CupOfTea (github- CupOfTea12) 
Commission for Kola101010

In short : converter decimal to binary and binary to decimal
Version : 1.0
*/
package convert;

//---LIBRARIES---//
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Convert extends JFrame implements ActionListener {

//---GLOBAL-VARIABILES---//    
private JLabel lblInput, lblOutput;
private JTextField txtInput, txtOutput;
private JRadioButton rbDecToBin, rbBinToDec;
private JButton btnConvert, btnClear;

//---ABSTRACT---//
public Convert() {
    // set the title and layout for the frame
    setTitle("Decimal to Binary Converter");
    setLayout(new FlowLayout());

    // initialize the GUI elements and add them to the frame
    lblInput = new JLabel("Enter a number: ");
    add(lblInput);
    txtInput = new JTextField(10);
    add(txtInput);

    // create a button group for the radio buttons
    ButtonGroup bg = new ButtonGroup();
    rbDecToBin = new JRadioButton("Decimal to Binary");
    bg.add(rbDecToBin);
    add(rbDecToBin);
    rbBinToDec = new JRadioButton("Binary to Decimal");
    bg.add(rbBinToDec);
    add(rbBinToDec);

    btnConvert = new JButton("Convert");
    add(btnConvert);
    btnClear = new JButton("Clear");
    add(btnClear);
    lblOutput = new JLabel("Result: ");
    add(lblOutput);
    txtOutput = new JTextField(30);
    txtOutput.setEditable(false);
    add(txtOutput);

    // add action listeners to the buttons
    btnConvert.addActionListener(this);
    btnClear.addActionListener(this);

    // set the default close operation
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

//---ACTIONLISTENER---//
public void actionPerformed(ActionEvent e) {
    // get the input from the text field
    String input = txtInput.getText();

    // check which button was clicked
    if (e.getSource() == btnConvert) {
        if (rbDecToBin.isSelected()) {
            // convert decimal to binary
            try {
                // try to convert the input to an integer
                int n = Integer.parseInt(input);
                // convert the integer to binary
                String binary = Integer.toBinaryString(n);
                // set the output in the text field
                txtOutput.setText(binary);
            } catch (NumberFormatException ex) {
                // show an error message if the input is not a number
                JOptionPane.showMessageDialog(null, "Please enter a decimal number!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (rbBinToDec.isSelected()) {
            // convert binary to decimal
            try {
                // try to convert the input to a binary integer
                int n = Integer.parseInt(input, 2);
                // set the output in the text field
                txtOutput.setText(Integer.toString(n));
            }catch (NumberFormatException ex){
                
            }
        
        }
    }
}
//---MAIN-CLASS---//

public static void main(String[] args) {
// create a new Converter frame
Convert converter = new Convert();
// set the size and location of the frame
converter.setSize(400, 150);
converter.setLocationRelativeTo(null); // center the frame on the screen
converter.setVisible(true);
}
}







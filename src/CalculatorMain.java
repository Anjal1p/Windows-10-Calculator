/*
 * Name: Anjali Prabhala
 * NetID: axp171330
 * Class: CS 2336 
 * Section: 2
 * Description: This program is an implementation of the windows 10 
 * programmer calculator. The main functions of this program is the 
 * conversion from binary to decimal, decimal to binary, hexadecimal to decimal,
 * decimal to hexadecimal, binary to hexadecimal, hexadecimal to binary, octal to 
 * binary, binary to octal, and so on (all conversions). Other functions include 
 * regular calculator expressions like using addition, subtraction, multiplication 
 * and division. This program was implemented using java swing and gui.
 *  
 */
package ogexample;

import javax.swing.JFrame;

//main method
public class CalculatorMain {
	public static void main(String[] args) {
		//calculator main frame
		Frame myCalc = new Frame();
		myCalc.setTitle("Calculator");
		//set the bounds for the size of the window
		myCalc.setBounds(100, 100, 375, 595);
		//the window closes
		myCalc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myCalc.setVisible(true);			
	}
	
}

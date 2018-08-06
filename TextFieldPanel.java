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

//imports
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextFieldPanel extends JPanel implements KeyListener, DocumentListener {

	// variables
	private static JTextField inputTextField;
	//font variable
	private Font font = new Font("Segoe UI", Font.BOLD, 30);
	private static int currentNumberInDecimal = 0;

	//constructor
	public TextFieldPanel() {
		//add default
		inputTextField = new JTextField(12);
		inputTextField.setHorizontalAlignment(JTextField.RIGHT);
		inputTextField.setFont(font);
		inputTextField.setBounds(6, 55, 359, 65);
		
		add(inputTextField);

		inputTextField.addKeyListener(this);
		inputTextField.getDocument().addDocumentListener(this);
	}

	//helper methods
	//get the input in the textField
	public static JTextField getTextField() {
		return inputTextField;
	}
	//get the input in decimal conversion
	public static int getCurrentNumberInDecimal() {
		return currentNumberInDecimal;
	}

	// DocumentListener
	public void insertUpdate(DocumentEvent e) {
		String input = getTextField().getText();
		//while there is input in the textField
		if (!input.isEmpty()) {
			//set the value for the decimal conversion
			currentNumberInDecimal = ButtonsPanel.convertNumberFrom(input);
			String currentNumberInBin = Integer.toBinaryString(currentNumberInDecimal);
			while (currentNumberInBin.length() < 64)
				currentNumberInBin = "0" + currentNumberInBin;
			int count = 0;
			//conversion depending on the bits
			for (int x = 0, y = 1, z = 2, w = 3; x < 64 && y < 65 && z < 66 && w < 67; x += 4, y += 4, z += 4, w += 4) 
			{
				String bitX = Character.toString(currentNumberInBin.charAt(x));
				String bitY = Character.toString(currentNumberInBin.charAt(y));
				String bitZ = Character.toString(currentNumberInBin.charAt(z));
				String bitW = Character.toString(currentNumberInBin.charAt(w));
				String halfByte = bitX + bitY + bitZ + bitW;
				count++;
			}
		}
	}

	public void removeUpdate(DocumentEvent e) {
		String input = getTextField().getText();
		//while there is input in the textField
		if (!input.isEmpty()) {
			//set the value for the decimal conversion
			currentNumberInDecimal = ButtonsPanel.convertNumberFrom(input);
			String currentNumberInBin = Integer.toBinaryString(currentNumberInDecimal);
			while (currentNumberInBin.length() < 64)
				currentNumberInBin = "0" + currentNumberInBin;
			int count = 0;
			//conversion depending on the bits
			for (int x = 0, y = 1, z = 2, w = 3; x < 64; x += 4, y += 4, z += 4, w += 4) 
			{
				String bitX = Character.toString(currentNumberInBin.charAt(x));
				String bitY = Character.toString(currentNumberInBin.charAt(y));
				String bitZ = Character.toString(currentNumberInBin.charAt(z));
				String bitW = Character.toString(currentNumberInBin.charAt(w));
				String halfByte = bitX + bitY + bitZ + bitW;
				count++;
			}
		}
	}

	public void changedUpdate(DocumentEvent e) {
	}

	// KeyListener
	//takes in the numbers when they are typed from the keyboard
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if (ConversionPanel.getHexRadButton().isSelected() && ((c < '0') || (c > '9')) && ((c < 'A') || (c > 'F'))
				&& (c != KeyEvent.VK_BACK_SPACE)) {
			e.consume();
		} else if (ConversionPanel.getDecRadButton().isSelected() && ((c < '0') || (c > '9'))
				&& (c != KeyEvent.VK_BACK_SPACE)) {
			e.consume();
		} else if (ConversionPanel.getOctRadButton().isSelected() && ((c < '0') || (c > '7'))
				&& (c != KeyEvent.VK_BACK_SPACE)) {
			e.consume();
		} else if (ConversionPanel.getBinRadButton().isSelected() && ((c < '0') || (c > '1'))
				&& (c != KeyEvent.VK_BACK_SPACE)) {
			e.consume();
		}
	}

	// Other key methods
	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}
}
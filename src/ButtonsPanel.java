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

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

//adds buttons and sets action listener when a button is clicked
public class ButtonsPanel extends JPanel implements ActionListener {
	//all the buttons used in the calculator
	private static String buttonText[] = { "\u2191", "Mod", "CE", "C", "\u232B", "\u00F7", 
			"A", "B", "7", "8", "9", "\u00D7", 
			"C", "D", "4", "5", "6", "\u2212", 
			"E", "F", "1", "2", "3", "+",
			"(", ")", "\u00B1", "0", ".", "=" };
	private static JButton buttons[] = new JButton[buttonText.length];
	private int count = 0; // counter
	// font command
	private Font font = new Font("", Font.PLAIN, 12);
	
	//Used for calculations
	private int firstNum = 0;
	private int secondNum = 0;
	//used when user performs operations like addition
	private String operation = "";
	//result displayed in the textField
	private int result = 0;
	// output of the button
	private String output = "";

	// constructor
	public ButtonsPanel() {
		
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(buttonText[i]);
			buttons[i].setFont(new Font("", Font.PLAIN, 12));
			if (buttonText[i].matches("[A-F]")) {
				buttons[i].setEnabled(false);
			}
		}
		//For buttons, using gridBagLayout
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.PAGE_START;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = .20;
		c.weighty = .20;
		c.insets = new Insets(1, 1, 1, 2);

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				c.gridx = j;
				c.gridy = i;

				add(buttons[count++], c);
			}
		}
		// Add ActionListener to buttons
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].addActionListener(this);
		}
	}

	// other useful methods
	
	//helper method to return buttons
	protected static JButton getButton(int i) {
		return buttons[i];
	}
	
	/*
	 * Method Name: convertNumberFrom
	 * parameters: string
	 * return: int
	 * Description: convertsa number from string to integer and performs coversion(binary,dec,etc.)
	 */
	protected static int convertNumberFrom(String number) {
		if (ConversionPanel.getHexRadButton().isSelected()) {
			return Integer.valueOf(number, 16).intValue();
		} else if ((ConversionPanel.getDecRadButton().isSelected())) {
			return Integer.valueOf(number, 10).intValue();
		} else if ((ConversionPanel.getOctRadButton().isSelected())) {
			return Integer.valueOf(number, 8).intValue();
		} else if ((ConversionPanel.getBinRadButton().isSelected())) {
			return Integer.valueOf(number, 2).intValue();
		}
		return 0;
	}
	/*
	 * Method Name: convertNumberTo
	 * parameters: int
	 * return: String
	 * Description: convertsa number from integer to String and performs coversion (binary,dec,etc.)
	 */
	protected static String convertNumberTo(int number) {
		if (ConversionPanel.getHexRadButton().isSelected()) {
			return Integer.toHexString(number);
		} else if (ConversionPanel.getDecRadButton().isSelected()) {
			return Integer.toString(number);
		} else if (ConversionPanel.getOctRadButton().isSelected()) {
			return Integer.toOctalString(number);
		} else if (ConversionPanel.getBinRadButton().isSelected()) {
			return Integer.toBinaryString(number);
		}
		return "";
	}
	
	//add actions when buttons are clicked
	@Override
	public void actionPerformed(ActionEvent e) {
		//checks the buttons clicked and performs action accordingly
		//if a number/letter is clicked, adds that input to the textField
		// Row 1 for calculator
		if (e.getSource() == buttons[2]) {
			String input = TextFieldPanel.getTextField().getText();
			if (input != null && input.length() > 0) {
				TextFieldPanel.getTextField().setText("");
			}
		}
		if (e.getSource() == buttons[4]) {
			String input = TextFieldPanel.getTextField().getText();
			if (input != null && input.length() > 0) {
				TextFieldPanel.getTextField().setText(input.substring(0, input.length() - 1));
			}
		}
		// divide
		if (e.getSource() == buttons[5]) {
			String input = TextFieldPanel.getTextField().getText();
			firstNum = convertNumberFrom(input);
			TextFieldPanel.getTextField().setText("");
			operation = "/";
		}

		// Row 2
		if (e.getSource() == buttons[6]) {
			String input = TextFieldPanel.getTextField().getText();
			TextFieldPanel.getTextField().setText(input + "A");
		}
		if (e.getSource() == buttons[7]) {
			String input = TextFieldPanel.getTextField().getText();
			TextFieldPanel.getTextField().setText(input + "B");
		}
		if (e.getSource() == buttons[8]) {
			String input = TextFieldPanel.getTextField().getText();
			TextFieldPanel.getTextField().setText(input + "7");
		}
		if (e.getSource() == buttons[9]) {
			String input = TextFieldPanel.getTextField().getText();
			TextFieldPanel.getTextField().setText(input + "8");
		}
		if (e.getSource() == buttons[10]) {
			String input = TextFieldPanel.getTextField().getText();
			TextFieldPanel.getTextField().setText(input + "9");
		}
		//multiply
		if (e.getSource() == buttons[11]) {
			String input = TextFieldPanel.getTextField().getText();
			firstNum = convertNumberFrom(input);
			TextFieldPanel.getTextField().setText("");
			operation = "*";
		}
		// Row 3
		if (e.getSource() == buttons[12]) {
			String input = TextFieldPanel.getTextField().getText();
			TextFieldPanel.getTextField().setText(input + "C");
		}
		if (e.getSource() == buttons[13]) {
			String input = TextFieldPanel.getTextField().getText();
			TextFieldPanel.getTextField().setText(input + "D");
		}
		if (e.getSource() == buttons[14]) {
			String input = TextFieldPanel.getTextField().getText();
			TextFieldPanel.getTextField().setText(input + "4");
		}
		if (e.getSource() == buttons[15]) {
			String input = TextFieldPanel.getTextField().getText();
			TextFieldPanel.getTextField().setText(input + "5");
		}
		if (e.getSource() == buttons[16]) {
			String input = TextFieldPanel.getTextField().getText();
			TextFieldPanel.getTextField().setText(input + "6");
		}
		if (e.getSource() == buttons[17]) {
			String input = TextFieldPanel.getTextField().getText();
			firstNum = convertNumberFrom(input);
			TextFieldPanel.getTextField().setText("");
			operation = "-";
		}
		// Row 4
		if (e.getSource() == buttons[18]) {
			String input = TextFieldPanel.getTextField().getText();
			TextFieldPanel.getTextField().setText(input + "E");
		}
		if (e.getSource() == buttons[19]) {
			String input = TextFieldPanel.getTextField().getText();
			TextFieldPanel.getTextField().setText(input + "F");
		}
		if (e.getSource() == buttons[20]) {
			String input = TextFieldPanel.getTextField().getText();
			TextFieldPanel.getTextField().setText(input + "1");
		}
		if (e.getSource() == buttons[21]) {
			String input = TextFieldPanel.getTextField().getText();
			TextFieldPanel.getTextField().setText(input + "2");
		}
		if (e.getSource() == buttons[22]) {
			String input = TextFieldPanel.getTextField().getText();
			TextFieldPanel.getTextField().setText(input + "3");
		}
		if (e.getSource() == buttons[23]) {
			String input = TextFieldPanel.getTextField().getText();
			firstNum = convertNumberFrom(input);
			TextFieldPanel.getTextField().setText("");
			operation = "+";
		}
		// Row 5
		if (e.getSource() == buttons[24]) {
			String input = TextFieldPanel.getTextField().getText();
			TextFieldPanel.getTextField().setText(input + "(");
		}
		if (e.getSource() == buttons[25]) {
			String input = TextFieldPanel.getTextField().getText();
			TextFieldPanel.getTextField().setText(input + ")");
		}
		if (e.getSource() == buttons[27]) {
			String input = TextFieldPanel.getTextField().getText();
			TextFieldPanel.getTextField().setText(input + "0");
		}
		//not used for hex/dec/bin conversion
		if (e.getSource() == buttons[28]) {
			String input = TextFieldPanel.getTextField().getText();
			TextFieldPanel.getTextField().setText(input + ".");
		}
		//equals sign
		if (e.getSource() == buttons[29]) {
			// for performing regular calculations(addition, subtraction, * and /
			if (operation == "mod") {
				String input = TextFieldPanel.getTextField().getText();
				secondNum = convertNumberFrom(input);
				result = firstNum % secondNum;
				output = convertNumberTo(result);
				TextFieldPanel.getTextField().setText(output);
			}
			//action for division of two numbers
			else if (operation == "/") {
				String input = TextFieldPanel.getTextField().getText();
				secondNum = convertNumberFrom(input);
				if(secondNum == 0) {
					result = 0;
					output = "Infinity";
				}
				else {
					result = firstNum / secondNum;
					output = convertNumberTo(result);
				}
				TextFieldPanel.getTextField().setText(output);
			} 
			//action for multiplication of two numbers
			else if (operation == "*") {
				String input = TextFieldPanel.getTextField().getText();
				secondNum = convertNumberFrom(input);
				result = firstNum * secondNum;
				output = convertNumberTo(result);
				TextFieldPanel.getTextField().setText(output);
			} 
			//action for subtraction of two numbers
			else if (operation == "-") {
				String input = TextFieldPanel.getTextField().getText();
				secondNum = convertNumberFrom(input);
				result = firstNum - secondNum;
				output = convertNumberTo(result);
				TextFieldPanel.getTextField().setText(output);
			} 
			//action for addition of two numbers
			else if (operation == "+") {
				String input = TextFieldPanel.getTextField().getText();
				secondNum = convertNumberFrom(input);
				result = firstNum + secondNum;
				output = convertNumberTo(result);
				TextFieldPanel.getTextField().setText(output);
			}
		}
	}

}

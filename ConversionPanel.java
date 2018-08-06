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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ConversionPanel extends JPanel implements ActionListener {

	private static JRadioButton hex;
	private static JRadioButton dec;
	private static JRadioButton oct;
	private static JRadioButton bin;
	private ButtonGroup baseButtonGroup;

//CONSTRUCTOR	
	public ConversionPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createTitledBorder(""));
		
		hex = new JRadioButton("Hex");
		dec = new JRadioButton("Dec");
		oct = new JRadioButton("Oct");
		bin = new JRadioButton("Bin");
		
		baseButtonGroup = new ButtonGroup();
	
		//Adding radio buttons to group
		baseButtonGroup.add(hex);
		baseButtonGroup.add(dec);
		dec.setSelected(true);
		baseButtonGroup.add(oct);
		baseButtonGroup.add(bin);
		
		//Adding to panel
		add(hex);
		add(dec);
		add(oct);
		add(bin);
		
		//Adding ActionListener
		hex.addActionListener(this);
		dec.addActionListener(this);
		oct.addActionListener(this);
		bin.addActionListener(this);
	}
	
	//helper methods to get the buttons the user is interacting with
	public static JRadioButton getHexRadButton() { return hex; }
	public static JRadioButton getDecRadButton() { return dec; }
	public static JRadioButton getOctRadButton() { return oct; }
	public static JRadioButton getBinRadButton() { return bin; }
	
	//ActionListener
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == hex) {
			
			int number = TextFieldPanel.getCurrentNumberInDecimal();
			
			if(number != 0) {
				//convert number to hexadecimal
				TextFieldPanel.getTextField().setText(ButtonsPanel.convertNumberTo(number));
			}

			//set ABCDE to true
			ButtonsPanel.getButton(6).setEnabled(true);
			ButtonsPanel.getButton(7).setEnabled(true);
			ButtonsPanel.getButton(12).setEnabled(true);
			ButtonsPanel.getButton(13).setEnabled(true);
			ButtonsPanel.getButton(18).setEnabled(true);
			ButtonsPanel.getButton(19).setEnabled(true);
			
			//set all numbers to true
			ButtonsPanel.getButton(8).setEnabled(true);
			ButtonsPanel.getButton(9).setEnabled(true);
			ButtonsPanel.getButton(10).setEnabled(true);
			
			ButtonsPanel.getButton(14).setEnabled(true);
			ButtonsPanel.getButton(15).setEnabled(true);
			ButtonsPanel.getButton(16).setEnabled(true);
			
			ButtonsPanel.getButton(20).setEnabled(true);
			ButtonsPanel.getButton(21).setEnabled(true);
			ButtonsPanel.getButton(22).setEnabled(true);
			ButtonsPanel.getButton(27).setEnabled(true);
			
		}
		if(e.getSource() == dec) {
			
			int number = TextFieldPanel.getCurrentNumberInDecimal();
			
			if(number != 0) {
				//convert number to decimal
				TextFieldPanel.getTextField().setText(ButtonsPanel.convertNumberTo(number));
			}
				//set A, B, C, D, E, F to false
				ButtonsPanel.getButton(6).setEnabled(false);
				ButtonsPanel.getButton(7).setEnabled(false);
				ButtonsPanel.getButton(12).setEnabled(false);
				ButtonsPanel.getButton(13).setEnabled(false);
				ButtonsPanel.getButton(18).setEnabled(false);
				ButtonsPanel.getButton(19).setEnabled(false);
			
			//set all numbers to true
				ButtonsPanel.getButton(8).setEnabled(true);
				ButtonsPanel.getButton(9).setEnabled(true);
				ButtonsPanel.getButton(10).setEnabled(true);
				
				ButtonsPanel.getButton(14).setEnabled(true);
				ButtonsPanel.getButton(15).setEnabled(true);
				ButtonsPanel.getButton(16).setEnabled(true);
				
				ButtonsPanel.getButton(20).setEnabled(true);
				ButtonsPanel.getButton(21).setEnabled(true);
				ButtonsPanel.getButton(22).setEnabled(true);
				ButtonsPanel.getButton(27).setEnabled(true);
			
		}
		if(e.getSource() == oct) {
		
			int number = TextFieldPanel.getCurrentNumberInDecimal();
			
			if(number != 0) {
				//convert number to octal
				TextFieldPanel.getTextField().setText(ButtonsPanel.convertNumberTo(number));
			}
				//set A, B, C, D, E, F to false
				ButtonsPanel.getButton(6).setEnabled(false);
				ButtonsPanel.getButton(7).setEnabled(false);
				ButtonsPanel.getButton(12).setEnabled(false);
				ButtonsPanel.getButton(13).setEnabled(false);
				ButtonsPanel.getButton(18).setEnabled(false);
				ButtonsPanel.getButton(19).setEnabled(false);
				
			//set 8 and 9 to false
			ButtonsPanel.getButton(9).setEnabled(false);
			ButtonsPanel.getButton(10).setEnabled(false);
			//set all other numbers to true
			ButtonsPanel.getButton(8).setEnabled(true);
			
			ButtonsPanel.getButton(14).setEnabled(true);
			ButtonsPanel.getButton(15).setEnabled(true);
			ButtonsPanel.getButton(16).setEnabled(true);
			
			ButtonsPanel.getButton(20).setEnabled(true);
			ButtonsPanel.getButton(21).setEnabled(true);
			ButtonsPanel.getButton(22).setEnabled(true);
			ButtonsPanel.getButton(27).setEnabled(true);
		
		}
		if(e.getSource() == bin) {
			int number = TextFieldPanel.getCurrentNumberInDecimal();
			
			if(number != 0) {
				//convert number to binary
				TextFieldPanel.getTextField().setText(ButtonsPanel.convertNumberTo(number));
			}
			
			//set A, B, C, D, E, F to false
			ButtonsPanel.getButton(6).setEnabled(false);
			ButtonsPanel.getButton(7).setEnabled(false);
			ButtonsPanel.getButton(12).setEnabled(false);
			ButtonsPanel.getButton(13).setEnabled(false);
			ButtonsPanel.getButton(18).setEnabled(false);
			ButtonsPanel.getButton(19).setEnabled(false);
			
			//set all numbers to false
			ButtonsPanel.getButton(8).setEnabled(false);
			ButtonsPanel.getButton(9).setEnabled(false);
			ButtonsPanel.getButton(10).setEnabled(false);
			
			ButtonsPanel.getButton(14).setEnabled(false);
			ButtonsPanel.getButton(15).setEnabled(false);
			ButtonsPanel.getButton(16).setEnabled(false);
			
			ButtonsPanel.getButton(21).setEnabled(false);
			ButtonsPanel.getButton(22).setEnabled(false);
			//except 1 and 0
		}
	}
}
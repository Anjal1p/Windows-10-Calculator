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
import java.awt.Color; 
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
//contains objects of all the other object classes
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

//Main frame of the java program

//variables
public class Frame extends JFrame {
	private TextFieldPanel inputPanel;
	private ConversionPanel basePanel;
	private ButtonsPanel buttonPanel;
	private JToggleButton qword;
	private JButton and, not, or, xor, rsh, lsh;
	private JLabel menu, title;
	
	public Frame () {
		//layout of the frame
		setLayout(null);

		//where the user enters the text
		inputPanel = new TextFieldPanel();
		//set the default font, background and foreground
		inputPanel.setFont(new Font("Lucida Grande", Font.PLAIN, 13));			
		inputPanel.setBackground(new Color(238,238,238));
		inputPanel.setForeground(Color.BLACK);
		inputPanel.setBounds(6, 55, 359, 65);
		add(inputPanel);
		
		//label next to the title (button used in the windows 10 calculator
		//to switch between calculator modes like scientific, programmer)
		menu = new JLabel("   \u2630");
		//set font and bounds (size)
		menu.setFont(new Font("Baskerville", Font.PLAIN, 20));
		menu.setBounds(2, 6, 61, 37);
		add(menu);
		
		//title on the top of the frame
		title = new JLabel("PROGRAMMER");
		title.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		title.setBounds(64, 14, 263, 40);
		add(title);
		
		//basePanel - panel that includes hex, bin, dec and oct buttons
		basePanel = new ConversionPanel();
		basePanel.setBounds(6, 153, 63, 140);
		basePanel.setBorder(new EmptyBorder(0,0,0,0));
		add(basePanel);
	
		//adds buttons to the calculator
		buttonPanel = new ButtonsPanel();
		//set bounds as to where the buttons are placed on the frame
		buttonPanel.setBounds(6, 336, 359, 231);
		add(buttonPanel);	
		//buttons implemented for touch and feel
	    and = new JButton(" And");
		and.setBounds(306, 290, 57, 46);
		add(and);
		
		not = new JButton(" Not");
		not.setBounds(246, 290, 57, 46);
		add(not);
		
		xor = new JButton(" Xor");
		xor.setBounds(186, 290, 57, 46);
		add(xor);
		
		or = new JButton(" Or");
		or.setBounds(126, 290, 57, 46);
		add(or);
		
		rsh = new JButton(" Rsh");
		rsh.setBounds(67, 290, 57, 46);
		add(rsh);
		
		lsh = new JButton(" Lsh");
		lsh.setBounds(7,290, 57, 46);
		add(lsh);
		
		//qword button implementation for touch and feel
		qword = new JToggleButton("QWORD");
		qword.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		qword.setBounds(142, 245, 100, 40);
		add(qword);			
	}	
}
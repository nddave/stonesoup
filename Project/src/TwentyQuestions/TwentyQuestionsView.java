package TwentyQuestions;

// import 
import io.CommutativeExpressionWriter;
import DataStructures.*;
// import awt
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
// import swing 
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.omg.CORBA.Current;

import DataStructures.BinaryTreeNode;

//TwentyQuestionsView.java
/**
 * Draws the game Features the logic
 */

public class TwentyQuestionsView extends JPanel {
	// image is a component TwentyQuestionsController
	private JLabel image;
	// declaring variables for the GUI
	// the controller
	private TwentyQuestionsController controller;
	// Binary Tree Node implementation that holds the current node
	private DefaultBinaryTreeNode<String> current;
	// Binary Tree Node implementation that holds the previous node
	private DefaultBinaryTreeNode<String> previous;
	// Panel to hold the menu
	private JPanel menuPanel;
	// panel for the center
	private JPanel center;
	// center panel
	private JPanel south;
	// Button to start the game
	private JButton start;
	// button to restart the game
	private JButton restart;
	// button to answer yes
	private JButton yes;
	// button to answer no
	private JButton no;
	// text field in center panel which holds the question
	private JTextField question;

	// Constructor
	/*
	 * Calls the 20Q image Sets the current node to root of tree
	 */
	public TwentyQuestionsView() {
		super(new BorderLayout());
		// brings in image 20Q.jpg
//		image = new Image("20Q.jpg");
		// makes a new instace of the controller
		controller = new TwentyQuestionsController();
		// starts at the root of the treee
		current = controller.tree.getRoot();
		// calls the method which initializes the GUI
		initGUI();

	}

	/**
	 * Create GUI components
	 */
	public void initGUI() {
		// use a border layout
		setLayout(new BorderLayout());

		// add instructions panel to NORTH
		add(createInstructions(), BorderLayout.NORTH);

		// add question/answer panel to CENTER
		add(createCenterPanel(), BorderLayout.CENTER);

		// add Yes/No or Restart buttons panel to SOUTH
		add(createSouthPanel(), BorderLayout.SOUTH);

	}

	/**
	 * Creates a panel in the center, consisting of a menu and a picture
	 * 
	 * @return center panel
	 */
	public JPanel createCenterPanel() {
		// use a border layout
		center = new JPanel(new BorderLayout());
		
		image = drawCup("logo.png");
		// Add 20Q image to east
		center.add(image, BorderLayout.CENTER);

		// Add menu to west
		center.add(createMenu(), BorderLayout.SOUTH);

		center.setOpaque(true);
		center.setBackground(new Color(#00aeef));

		return center;
	}

	/**
	 * Create menu list for user to choose from
	 * 
	 * @return menu panel
	 */
	public JPanel createMenu() {
		// makes a new panel
		menuPanel = new JPanel(new GridLayout(1, 2));
		// list the menu for the desserts
		JTextArea menu1 = new JTextArea(
				"The objective of this exercise is to select for you a story that will best guide you through your Youth"
						+ "Leader's journey and inspire you to surmount any trials and tribulations in the process.");
		// lists the menu for the non-deserts
		JTextArea menu2 = new JTextArea(
				"This short questionnaire will help you arrive at a lesson plan in order to best guide the Young Leader's journey.");
		// this cannot be edited
		menu1.setEditable(false);

		// allows words to go to next line
		menu1.setLineWrap(true);

		// prevents words from splitting
		menu1.setWrapStyleWord(true);

		// Insets constructor summary: (top, left, bottom, right)
		menu1.setMargin(new Insets(30, 30, 30, 5));

		menu2.setEditable(false);
		// allows words to go to next line
		menu2.setLineWrap(true);

		// prevents words from splitting
		menu2.setWrapStyleWord(true);

		// Insets constructor summary: (top, left, bottom, right)
		menu2.setMargin(new Insets(30, 30, 30, 5));

		// adds the desserts menu to the BorderLayout in the East
		menuPanel.add(menu1);
		// adds the non-deserts menu to the BorderLayout in the West
		menuPanel.add(menu2);
		// set this to be opaque
		menu1.setOpaque(true);
		// set the background of menu1 to light grey
		menu1.setBackground(new Color(#00aeef));
		// set this to be opaque
		menu2.setOpaque(true);
		// set the background of menu2 to light green
		menu2.setBackground(new Color(#ffffff));

		return menuPanel;
	}
	
	/**
	 * drawing out the image 
	 * @param imagePath
	 * @return
	 */
	public JLabel drawCup(String imagePath){
		//create a new JLabel to add the image tp
		JLabel children = new JLabel();

		try{
			//read in the image
			BufferedImage pic = ImageIO.read(new File(imagePath));
			//put the picture in the image
			children.setHorizontalAlignment(SwingConstants.CENTER);
			children.setIcon(new ImageIcon(pic));
			//set the background color of the label
			children.setBackground(new Color(0, 174, 239));
			//show the background color
			children.setOpaque(true);
		}catch (IOException ex){	
		}
		//center the alignment of the picture
		children.setHorizontalAlignment(SwingConstants.CENTER);
		return children;
	}

	/**
	 * Create instructions for game
	 * 
	 * @return instructions
	 */
	public JTextArea createInstructions() {
		JTextArea instructions = new JTextArea(
				"Hello. Thank you for being a wonderful and engaged volunteer. Befor you start your journey with your"
						+ "Youth Leader, it is essential that you have your Magic Stone. ");
		// instructions not editable
		instructions.setEditable(false);

		// allows words to go to next line
		instructions.setLineWrap(true);

		// prevents words from splitting
		instructions.setWrapStyleWord(true);

		// change font
		instructions.setFont(new Font("SANS_SERIF", Font.PLAIN, 17));

		// change font color
		instructions.setForeground(Color.white);

		// Insets constructor summary: (top, left, bottom, right)
		instructions.setMargin(new Insets(30, 30, 30, 30));

		// Set background color
		instructions.setOpaque(true);
		instructions.setBackground(new Color(#00aeef));

		return instructions;
	}

	/**
	 * South panel w/ start button to start with Once pressed: 1. yes/no buttons
	 * 2. questions will appear 3. "Start" button and picture in center panel
	 * disappear
	 */
	public JPanel createSouthPanel() {
		south = new JPanel(new GridLayout(1, 1));
		// adds start button and its functionality
		startGame();
		return south;
	}

	/**
	 * "Yes" button looks at left child
	 */
	public void yes() {
		yes = new JButton("Yes");

		// "yes" button's action listener
		yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previous = current;
				current = current.getLeft();

				// if current is not a node, not a leaf
				if (current != null) {
					question.setText((String) current.getData());
					validate();
				}

				// Once you hit a leaf, set a final message
				else {
					question.setText("Wonderful! Hopefully, you found a story and lesson plan that will help you move forward in your journey! ");
					south.remove(yes);
					south.remove(no);
					validate();
					// add a restart button that restores the game
					restartGame();

				}

				// if current.getNext() is
			}
		});

		// add Yes button to left
		south.add(yes, BorderLayout.WEST);
		validate();

	}

	/**
	 * "No" button looks at right child
	 */
	public void no() {

		no = new JButton("No");

		no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previous = current;
				current = current.getRight();

				// if current is not a leaf
				if (current != null) {
					question.setText(current.getData().toString());
					validate();
				}

				// Once you hit a leaf, set a final message
				else {
					// Call the function that creates an option panel
					optionPane();

					// Save changes user made
					CommutativeExpressionWriter.writeCommutativeExpr(
							controller.tree, "food.xml");

					// add a restart button that restores the game
					restartGame();

				}
			}
		});

		// add No button to right
		south.add(no, BorderLayout.EAST);
		validate();
	}

	/**
	 * Displays the restart button
	 */
	public void restartGame() {
		// creates a restart button
		restart = new JButton("Restart");

		validate();
		// actionlistener for the restart button
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// removes the restart button
				south.remove(restart);
				// remove the question panel
				center.remove(question);
				// add the image
//				center.add(image);
				// add the menu panel
				center.add(menuPanel);
				// repaint!
				repaint();
				validate();
				// start the game again :)
				startGame();
			}

		});
		// add the button to the south panel
		south.add(restart);
		validate();
	}

	/**
	 * Start the game by: 1. Remove restart button 2. Add start button
	 */
	public void startGame() {
		// create a new button to start the game
		start = new JButton("Start");
		// add an actionListener
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current = controller.tree.getRoot();
				// remove the start button
				south.remove(start);
				validate();

				// remove the picture + menu
				center.remove(image);
				center.remove(menuPanel);

				// add JTextArea to center panel and update text to whatever
				// current's data is
				question = new JTextField();
				question.setEditable(false);
				question.setBackground(new Color(#00aeef));

				// Insets constructor summary: (top, left, bottom, right)
				question.setText(current.getData().toString());
				question.setHorizontalAlignment(JTextField.CENTER);
				validate();
				// adds the question panel to the center
				center.add(question);

				validate();

				// create JPanel with GridLayout -- 1 rows, 2 columns
				south.setLayout(new GridLayout(1, 2));
				validate();

				// create yes button
				yes();

				// create no button
				no();

			}
		});
		// add the start button to the south panel
		south.add(start);
		validate();
	}

	/**
	 * Creates a JOptionPane Calls enterAnswer, enterQuestion, and enterYN
	 */
	public void optionPane() {
		south.remove(yes);
		south.remove(no);
		Object[] object = new Object[] { "No", "Yes" };

		// Create a new JPanel with 3 JTextFields and add to optionPane
		JPanel textFields = new JPanel();
		textFields.setLayout(new GridLayout(3, 1));

		JTextField instruct = new JTextField(
				"Please fill out both fields below. Then, click yes or no"
						+ ", corresponding to the answer to your question");
		// cannot edit this
		instruct.setEditable(false);
		// text for the answer
		JTextField answer = new JTextField(
				"Fill in the answer to the food that you crave!");
		// text for the question to be set by the player
		JTextField question2 = new JTextField(
				"Fill in the question to your answer!");

		textFields.add(instruct);
		textFields.add(answer);
		textFields.add(question2);

		// Add JPanel to JOptionPane
		int choice = JOptionPane.showOptionDialog(this, textFields, "Texts",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				object, null);
		// get the anwer
		String strAnswer = answer.getText();
		// get the question
		String strQuestion = question2.getText();
		// get the data from the previous node
		String origData = previous.getData();
		// and make a new node that is called origAnswer to store
		DefaultBinaryTreeNode<String> origAnswer = new DefaultBinaryTreeNode<String>(
				origData);

		// if answer is Yes, add left child
		if (choice == 1) {
			// set the previous node to be the question
			previous.setData(strQuestion);
			DefaultBinaryTreeNode<String> newChild = new DefaultBinaryTreeNode<String>(
					strAnswer);
			// and set the left child to be the answer
			previous.setLeft(strAnswer);
			// set the original to be the right child
			previous.setRight(origData);
			// and ask to restart the game
			question.setText("Please press restart");
		}

		// if No, add right child
		else {
			// //set the previous node to be the question
			previous.setData(strQuestion);
			DefaultBinaryTreeNode<String> newChild = new DefaultBinaryTreeNode<String>(
					strAnswer);
			// and set the right child to be the answer
			previous.setRight(strAnswer);
			// set the original to be the left child
			previous.setLeft(origData);
			// and ask to restart the game
			question.setText("Please press restart");
		}

	}

}
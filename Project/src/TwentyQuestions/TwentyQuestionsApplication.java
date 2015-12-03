package TwentyQuestions;

import javax.swing.JFrame;

/*
 * JFrame that displays everything
 */

public class TwentyQuestionsApplication
{
	public static void main( String[] args )
	{
		// create a new JFrame to hold the guessing game 
		JFrame TQFrame = new JFrame("20 Questions Guessing Game! :P");
		
		// set size
		TQFrame.setSize( 600, 610 );

		// add game panel to JFrame
		TQFrame.add( new TwentyQuestionsView() );
		
		// exit normally on closing the window
		TQFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		// show frame
		TQFrame.setVisible( true );
		
	}
	
}
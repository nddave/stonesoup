package TwentyQuestions;

//import awt
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//import javax
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Image extends JPanel
{
	//image 
	protected BufferedImage img;
	//scale of the image
	protected int scale;
	
	// Constructor
	// Takes in an image file and reads it
	
	public Image(String imagePath)
	{
		// Reads an image
		scale = 1;
		try
		{
			img = ImageIO.read(new File(imagePath));
			
		} catch (IOException e)
		{
			//if the file is unable to be read
			System.out.println("file IO exception");
			e.printStackTrace();
		}
	}
	
	/**
	 * Paint method for picture
	 */
	public void paint(Graphics g)
	{
		g.drawImage(img, 0, 0, scale*img.getWidth(), scale*img.getHeight(),
				0, 0, img.getWidth(), img.getHeight(), null);
	}
}
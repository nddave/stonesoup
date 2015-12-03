package TwentyQuestions;

//import from io
import io.CommutativeExpressionReader;
import io.CommutativeExpressionWriter;
import DataStructures.*; 

//import awt
import java.awt.Graphics;
import java.awt.image.BufferedImage;
//import io 
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
// import from DataStructures
import DataStructures.BinaryTree;
import DataStructures.BinaryTreeNode;
import DataStructures.LinkedList;

/**
 * Builds the tree
 *
 */

public class TwentyQuestionsController extends JComponent
{
	// Instance Properties
	protected BinaryTreeNode<String>[] nodes;
	protected BinaryTree<String> tree;
	
	// Constructor
	/**
	 * Initializes nodes, tree, and linked list
	 */
	public TwentyQuestionsController()
	{
		// Initialize nodes and tree
		nodes = (BinaryTreeNode<String>[])new BinaryTreeNode[31];
		tree = new DefaultBinaryTree<String>();
		buildTree();
	}
	
	
	/**
	* Draws the binary tree
	* Returns a BinaryTree
	*/
	public BinaryTree<String> buildTree()
	{
		//reads the binary tree from the xml file 
		tree = CommutativeExpressionReader.readCommutativeExpr("food.xml");
		return tree;
	}
	
}
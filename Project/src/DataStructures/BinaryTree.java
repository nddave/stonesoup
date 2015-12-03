package DataStructures;

//import DefaultBinaryTreeNode;
//import LinkedList;

/**
 * This is the interface for Binary Tree.
 * This will be a rooted Binary Tree.
 * The Binary Tree will consist of BinaryTreeNodes.
 */
public interface BinaryTree<T> 
{
	/**
	 * This method gets the root
	 */
	public DefaultBinaryTreeNode<T> getRoot();
	
	/**
	 * This method sets the root
	 */
	public void setRoot(BinaryTreeNode<T> binaryTreeNode);
	
	/**
	 * This helper method will insert a left child to the current node
	 */
	public void insertLeft(DefaultBinaryTreeNode<T> currentNode,T paramData);
	
	/**
	 * This helper method will insert a right child to the current node
	 */
	public void insertRight(DefaultBinaryTreeNode<T> currentNode, T paramData);
	
	/**
	 * This method will get the left child of a node
	 */
	public DefaultBinaryTreeNode<T> getLeftChild(DefaultBinaryTreeNode<T> currentNode);
	
	/**
	 * This method will get the right child of a node
	 */
	public DefaultBinaryTreeNode<T> getRightChild(DefaultBinaryTreeNode<T> currentNode);
		
	/**
	 * This method will get the inorderTraversal.
	 * Must recursively traverse left, refer to data, recursively traverse right. 
	 */
	public LinkedList<T> inorderTraversal(DefaultBinaryTreeNode<T> currentNode, T traversalType);
	
	/**
	 * This method will get the preorderTraversal.
	 * Must refer to data, recursively traverse left, recursively traverse right.
	 */
	public LinkedList<T> preorderTraversal(DefaultBinaryTreeNode<T> currentNode, T traversalType);
	
	/**
	 * This method will get the postorderTraversal.
	 * Must recursively traverse left, recursively traverse right, refer to data.
	 */
	public LinkedList<T> postorderTraversal(DefaultBinaryTreeNode<T> currentNode, T traversalType);
}
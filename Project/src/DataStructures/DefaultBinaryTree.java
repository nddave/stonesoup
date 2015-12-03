package DataStructures;
/**
 * This class will Implement the BinaryTree ADT
 */
public class DefaultBinaryTree<T> implements BinaryTree<T>
{
	/**
	 * Instance Fields
	 */
	DefaultBinaryTreeNode<T> root;
	
	/**
	 * Constructor
	 */
	public DefaultBinaryTree()
	{
		root = null;
	}
	
	/**
	 * This method gets the root
	 */
	public DefaultBinaryTreeNode<T> getRoot()
	{
		return this.root;
	}
	
	public void setRoot(BinaryTreeNode<T> node) {
		// set the root as a node
		root = (DefaultBinaryTreeNode<T>) node;		
	}
	
	/**
	 * This method sets the root
	 */
	public void setRoot(T data)
	{
		//create temporary DefaultBinaryTreeNode
		DefaultBinaryTreeNode<T> tempNode = new DefaultBinaryTreeNode<T>();
		//set the data for this temporary node
		tempNode.setData(data);
		//assign the temporary node to the root
		this.root = tempNode;
	}	
	
	/**
	 * This method will get the left child of a node
	 */
	public DefaultBinaryTreeNode<T> getLeftChild(DefaultBinaryTreeNode<T> currentNode)
	{
		//gets the left child
		return currentNode.getLeft();
	}
	
	/**
	 * This method will get the right child of a node
	 */
	public DefaultBinaryTreeNode<T> getRightChild(DefaultBinaryTreeNode<T> currentNode)
	{
		return currentNode.getRight();
	}
	

	/**
	 * This helper method will insert a left child to the current node
	 */
	public void insertLeft(DefaultBinaryTreeNode<T> currentNode, T paramData)
	{
		//make sure that there isn't already a left child
		if(currentNode.getLeft() == null)
			currentNode.setLeft(paramData);
		//otherwise, tell user cannot set left child
		else
			System.out.println("Already a left child, try again.");
	}
	
	/**
	 * This helper method will insert a right child to the current node
	 */
	public void insertRight(DefaultBinaryTreeNode<T> currentNode, T paramData)
	{
		//make sure there isn't already a right child
		if(currentNode.getRight() == null)
			currentNode.setRight(paramData);
		//otherwise, tell user cannot set right child
		else
			System.out.println("Already a right child, try again");
	}
	
	/**
	 * This method will get the inorderTraversal.
	 * Must recursively traverse left, refer to data, recursively traverse right. 
	 */
	public LinkedList<T> inorderTraversal(DefaultBinaryTreeNode<T> currentNode, T traversalType)
	{		
		//create temporary LinkedList<T> to return
		LinkedList<T> tempList = new LinkedList<T>();
		
		/**base case: if the current node has no children**/
		if(currentNode.getLeft() == null && currentNode.getRight() == null)
		{
			tempList.insertFirst(currentNode.getData());
			return tempList;
		}
		
		/**recursive case: more tree left**/
		tempList.insertFirst(traversalType);
		//recursively traverse left
		tempList.head.setNext(inorderTraversal(getLeftChild(currentNode), traversalType).getFirstNode());
		//refer to data
		tempList.insertAfter(tempList.getLastNode(),currentNode.getData());
		//recursively traverse right
		tempList.getLastNode().setNext(inorderTraversal(getRightChild(currentNode), traversalType).getFirstNode());
		//return the temporary LinkeList
		return tempList;
	}
	
	/**
	 * This method will get the preorderTraversal.
	 * Must refer to data, recursively traverse left, recursively traverse right.
	 */
	public LinkedList<T> preorderTraversal(DefaultBinaryTreeNode<T> currentNode, T traversalType)
	{
		//create temporary LinkedList<T> to return
		LinkedList<T> tempList = new LinkedList<T>();
				
		/**base case: if the current node has no children**/
		if(currentNode.getLeft() == null && currentNode.getRight() == null)
		{
			tempList.insertFirst(currentNode.getData());
			return tempList;
		}
		
		/**recursive case: more tree left**/
		tempList.insertFirst(traversalType);
		//refer to data
		tempList.insertAfter(tempList.getFirstNode(), currentNode.getData());
		//recursively traverse left
		tempList.getLastNode().setNext(preorderTraversal(getLeftChild(currentNode), traversalType).getFirstNode());
		//recursively traverse right
		tempList.getLastNode().setNext(inorderTraversal(getRightChild(currentNode), traversalType).getFirstNode());
		//return the temporary LinkeList
		return tempList;
	}
	
	/**
	 * This method will get the postorderTraversal.
	 * Must recursively traverse left, recursively traverse right, refer to data.
	 */
	public LinkedList<T> postorderTraversal(DefaultBinaryTreeNode<T> currentNode, T traversalType)
	{
		//create temporary LinkedList<T> to return
		LinkedList<T> tempList = new LinkedList<T>();
				
		/**base case: if the current node has no children**/
		if(currentNode.getLeft() == null && currentNode.getRight() == null)
		{
			tempList.insertFirst(currentNode.getData());
			return tempList;
		}
		
		/**recursive case: more tree left**/
		tempList.insertFirst(traversalType);
		//recursively traverse left
		tempList.getLastNode().setNext(preorderTraversal(getLeftChild(currentNode), traversalType).getFirstNode());
		//recursively traverse right
		tempList.getLastNode().setNext(inorderTraversal(getRightChild(currentNode), traversalType).getFirstNode());
		//refer to data
		tempList.insertAfter(tempList.getLastNode(),currentNode.getData());
		//return the temporary LinkeList
		return tempList;
	}

}
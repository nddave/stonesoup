package DataStructures;

/**
 * This class will Implement the BinaryTreeNode ADT
 */
public class DefaultBinaryTreeNode<T> implements BinaryTreeNode<T> {
	T data;
	DefaultBinaryTreeNode<T> left;
	DefaultBinaryTreeNode<T> right;

	/**
	 * Constructor
	 */
	public DefaultBinaryTreeNode() {
		// initializes the variables to null
		data = null;
		left = null;
		right = null;
	}

	public DefaultBinaryTreeNode(T data) {
		super();
		this.data = data;
	}

	/**
	 * This method will get the data in the node
	 */
	public T getData() {
		return this.data;
	}

	/**
	 * This method will get the pointer to the left child
	 */
	public DefaultBinaryTreeNode<T> getLeft() {
		return this.left;
	}

	/**
	 * This method will get the pointer to the right child
	 */
	public DefaultBinaryTreeNode<T> getRight() {
		return this.right;
	}

	/**
	 * This method will set the data for the node
	 */
	public void setData(T paramData) {
		this.data = paramData;
	}

	public void setLeft(BinaryTreeNode<T> node) {
		left = (DefaultBinaryTreeNode<T>) node;
	}

	public void setRight(BinaryTreeNode<T> node) {
		right = (DefaultBinaryTreeNode<T>) node;
	}

	/**
	 * This method will set the data for the left child
	 */
	public void setLeft(T paramData) {
		// create new temporary BinaryTreeNode
		DefaultBinaryTreeNode<T> tempNode = new DefaultBinaryTreeNode<T>();
		// set the temporary node's data to have paramData
		tempNode.setData(paramData);
		// assign the pointer of the left node to this temporary node
		this.left = tempNode;
	}

	/**
	 * This method will set the data for the right child
	 */
	public void setRight(T paramData) {
		// create new temporary BinaryTreeNode
		DefaultBinaryTreeNode<T> tempNode = new DefaultBinaryTreeNode<T>();
		// set the temporary node's data to have paramData
		tempNode.setData(paramData);
		// assign the pointer of the left node to this temporary node
		this.right = tempNode;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}

}
package referenceBasedTreeImplementation;

/**
 * Class that represents a Node on a Binary Search Tree
 * 
 * @author Alex, Matthew, Quintin, Miguel
 *
 * @param <E> Allowing for Binary Trees to be of any Type
 */
public class BSTreeNode<E> {

	private Comparable holding = null;
	private BSTreeNode parentNode = null;
	private BSTreeNode leftSubNode = null;
	private BSTreeNode rightSubNode = null;
	
	/**
	 * Constructor for a BSTreeNode
	 * @param holding Comparable object to be stored in the node 
	 */
	public BSTreeNode(Comparable holding) {
		this.holding = holding;
	}

	/**
	 * Method to get the comparable object being held in the node 
	 * @return what is being held in this node
	 */
	public Object getHolding() {
		return holding;
	}

	/**
	 * Method to set what comparable object is being sored in the node 
	 * @param holding the value that will be stored in the node
	 */
	public void setHolding(Comparable holding) {
		this.holding = holding;
	}
	
	/**
	 * Method to get the parentNode of a node
	 * @return the parentNode
	 */
	public BSTreeNode getParentNode() {
		return parentNode;
	}


	/**
	 *  Method to set the parentNode for a Node
	 * @param parentNode the parentNode to set
	 */
	public void setParentNode(BSTreeNode parentNode) {
		this.parentNode = parentNode;
	}

	/**
	 * Method to get the leftSubNode of a node
	 * @return the leftSubNode
	 */
	public BSTreeNode getLeftSubNode() {
		return leftSubNode;
	}

	/**
	 * Method to set the leftSubNode for a Node
	 * @param leftSubNode the leftSubNode to set
	 */
	public void setLeftSubNode(BSTreeNode leftSubNode) {
		this.leftSubNode = leftSubNode;
	}

	/**
	 * Method to get the rightSubNode of a node
	 * @return the rightSubNode
	 */
	public BSTreeNode getRightSubNode() {
		return rightSubNode;
	}

	/**
	 * Method to set the rightSubNode for a Node
	 * @param rightSubNode the rightSubNode to set
	 */
	public void setRightSubNode(BSTreeNode rightSubNode) {
		this.rightSubNode = rightSubNode;
	}
	
	/**
	 * This method will be used to compare nodes using the compareTo() method 
	 * @param nodeToAdd the new node 
	 * @return Number < 0 if this.holding is smaller; Number > 0 if this.holding is larger; 0 if the values are the same
	 */
	public int compareNode(BSTreeNode nodeToAdd) {
		return this.holding.compareTo(nodeToAdd.getHolding());
	}

}

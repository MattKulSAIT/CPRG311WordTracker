package referenceBasedTreeImplementation;

public class BSTreeNode <E> {

	private Comparable holding = null;
	private BSTreeNode parentNode = null;
	private BSTreeNode leftSubNode = null;
	private BSTreeNode rightSubNode = null;
	
	public BSTreeNode(Comparable holding) {
		this.holding = holding;
	}

	/**
	 * @return what is being held in this node
	 */
	public Object getHolding() {
		return holding;
	}

	/**
	 * @param holding the value that will be stored in the node
	 */
	public void setHolding(Comparable holding) {
		this.holding = holding;
	}
	
	/**
	 * @return the parentNode
	 */
	public BSTreeNode getParentNode() {
		return parentNode;
	}


	/**
	 * @param parentNode the parentNode to set
	 */
	public void setParentNode(BSTreeNode parentNode) {
		this.parentNode = parentNode;
	}

	/**
	 * @return the leftSubNode
	 */
	public BSTreeNode getLeftSubNode() {
		return leftSubNode;
	}

	/**
	 * @param leftSubNode the leftSubNode to set
	 */
	public void setLeftSubNode(BSTreeNode leftSubNode) {
		this.leftSubNode = leftSubNode;
	}

	/**
	 * @return the rightSubNode
	 */
	public BSTreeNode getRightSubNode() {
		return rightSubNode;
	}

	/**
	 * @param rightSubNode the rightSubNode to set
	 */
	public void setRightSubNode(BSTreeNode rightSubNode) {
		this.rightSubNode = rightSubNode;
	}

}

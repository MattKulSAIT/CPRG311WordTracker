package referenceBasedTreeImplementation;

import java.io.Serializable;
import java.util.NoSuchElementException;

import exceptions.TreeException;
import utilities.*;

/**
 * Class that represents a Binary Search tree
 * 
 * @author Matthew, Alex, Quintin, Miguel 
 *
 */
public class BSTree implements BSTreeADT, Serializable{
	//We need some stuff for serializable to work I think 
	//Also not sure if we need to do seriablizable for the nodes
	//Attribuest I think we need
	private int size;
	private BSTreeNode rootNode;
	
	/**
	 * Construtor for a Binary search tree object 
	 */
	public BSTree() {
		this.rootNode = null;
		this.size = 0;
	}
	
	/**
	 * Constructor for a Binary Search Tree with the root node object
	 * @param newEntry the value to be stored in the node at the root of the tree
	 */
	public BSTree(Comparable newEntry) {
		this.rootNode = new BSTreeNode(newEntry);
		this.size = 1;
	}
	
	/**
	 * Method to get the root node for the Binary Tree
	 * 
	 * @return rootNode the root node of the tree
	 * @throws TreeException if the size of the tree is 0
	 */
	@Override
	public BSTreeNode getRoot() throws TreeException {
			if(rootNode == null) {
				throw new TreeException("This tree is Empty");
				
			}
			else {
				return rootNode;
			}
		
	}

	/**
	 * method to return the hight of the binary tree
	 * 
	 * @returns height of the tree
	 */
	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		int height;
		return 0;
	}

	/**
	 * method to get the size of the binary tree 
	 * @return size the size of the tree
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Method to check if a tree is empty
	 * @return true if size = 0 otherwise it returns true
	 */
	@Override
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * method to delete everything in the Binary tree 
	 */
	@Override
	public void clear() {
		size = 0;
		rootNode.setHolding(null);
		rootNode.setLeftSubNode(null);
		rootNode.setRightSubNode(null);
		rootNode = null;
	}

	/**
	 * Method to check if a Binary tree contains a object 
	 * 
	 * @param entry a Comparable object that you want to look for 
	 * @return true if th obpject is in the tree and false if its not in there
	 * @throws TreeException if the tree is empty.
	 */
	@Override
	public boolean contains(Comparable entry) throws TreeException {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Method to search the tree and return the Node with the specified value
	 * 
	 * @param entry a Comparable object that you want to look for 
	 * @return BSTreeNode object holdind the value that matches entry
	 * @throws TreeException if the tree is empty.
	 */
	@Override
	public BSTreeNode search(Comparable entry) throws TreeException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Method to add an object to the Binary Search Tree
	 * 
	 * @param newEntry the object to be added to the tree
	 * @return true if the object was added 
	 * @throws TreeException if the tree is empty.
	 */
	@Override
	public boolean add(Comparable newEntry) throws NullPointerException {
		// TODO Auto-generated method stub
		if(newEntry == null) {
			throw new NullPointerException();
		}
		if(size == 0) {
			BSTreeNode newNode = new BSTreeNode(newEntry);
			rootNode = newNode;
			size++;
			return true;
		}
		else {
			//This is for if its not the first node in the tree
			BSTreeNode newNode = new BSTreeNode(newEntry);
			BSTreeNode currentNode = this.rootNode;
			boolean noHomeFound = true;
			
			while(noHomeFound) {
				int i = currentNode.compareNode(newNode);
				
				//currentNode is larger; look at leftSubNode
				if(i>0) {
					if(currentNode.getLeftSubNode() == null) {
						currentNode.setLeftSubNode(newNode);
						newNode.setParentNode(currentNode);
						size++;
						return true;
					}
					else {
						currentNode = currentNode.getLeftSubNode();
					}
				}
				//Nodes are the same size should not be added 
				else if(i==0) {
					return false;
				}
				//currentNode is smaller; look at rightSubNode
				else {
					if(currentNode.getRightSubNode() == null) {
						currentNode.setRightSubNode(newNode);
						newNode.setParentNode(currentNode);
						size++;
						return true;
					}
					else {
						currentNode = currentNode.getRightSubNode();
					}
				}
			}
			
			return false;
		}
		
	}

	/**
	 * A method to get an Iterator that follows the LVR traversal Pattern
	 * 
	 * @return Iterator Object represeting the tree following LVR traversal 
	 */
	@Override
	public Iterator inorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * A method to get an Iterator that follows the VLR traversal Pattern
	 * 
	 * @return Iterator Object represeting the tree following VLR traversal 
	 */
	@Override
	public Iterator preorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * A method to get an Iterator that follows the LRV traversal Pattern
	 * 
	 * @return Iterator Object represeting the tree following LRV traversal 
	 */
	@Override
	public Iterator postorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Class to make an Iterator object 
	 * 
	 * @author Matthew, Alex, Quintin, Miguel 
	 *
	 */
	class Iterator implements utilities.Iterator{

		Object[] theArray = new Object[size];
		
		/**
		 * method to check if the iterator has a next value
		 * 
		 * @return true if there is more values in the iterator 
		 */
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		/**
		 * method to return the next value in the iterator 
		 * 
		 * @return the next object in the iterator 
		 * @throws NoSuchElementException if there is no elements in the iterator
		 */
		@Override
		public Object next() throws NoSuchElementException {
			// TODO Auto-generated method stub
			return null;
		}		
	}
}

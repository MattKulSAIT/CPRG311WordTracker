package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import exceptions.TreeException;
import referenceBasedTreeImplementation.BSTree;



public class BSTreeTests {

	private static BSTree testBST;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		testBST = null;
	}

	@Before
	public void setUp() throws Exception {
		testBST = new BSTree();
	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	@Test
	public void testGetRoot() {
		testBST = new BSTree();
		
		assertThrows(TreeException.class, () ->testBST.getRoot());
		
		//TODO finish this method 
		//add one node check again 
		//add another one or two and chech again
		
	}

	@Test
	public void testGetHeight() {
		testBST = new BSTree();
		
		assertEquals(0, testBST.getHeight());
		
		//TODO finish this method 
		
	}
	
	@Test
	public void testGetSize() {
		testBST = new BSTree();
		
		assertEquals(0, testBST.size());
		
		//TODO finish this method 
		//add a new and check again
		
	}
	
	@Test
	public void testIsEmpty() {
		testBST = new BSTree();
		
		assertTrue(testBST.isEmpty());
		
		//TODO finish this method 
		//Add somthing 
		
		assertFalse(testBST.isEmpty());
		
	}
	
	@Test
	public void testClear() {
		testBST = new BSTree();
				
		//TODO finish this method 
		//add some stuff before tests
		
		
		assertTrue(testBST.isEmpty());
		assertEquals(0, testBST.size());
		assertThrows(TreeException.class, () ->testBST.getRoot());
		
	}
	
	public void testContains() {
		testBST = new BSTree();
		
		//TODO DO this method 

	}
	
	public void testSearch() {
		testBST = new BSTree();
		
		//TODO DO this method 

	}
	
	public void testAdd() throws TreeException {
		testBST = new BSTree();
		
		//TODO DO this method 
		//add 1 thing
		
		
		assertEquals(1, testBST.size());
		//assertEquals(WhaterYouAdded, testBST.getRoot());
		
		//add 3 more stuff root should still be the same
		assertEquals(4, testBST.size());
		//assertEquals(WhaterYouAdded, testBST.getRoot());
		
		//Check for height, Im not sure what the hight will be as it depends on what we add

	}
	
	public void testInorderIterator() {
		testBST = new BSTree();
		
		//TODO DO this method 
		//Add like 5 or 6 things then call this method
		//Check to make sure it followed LVR traversal 
	}
	
	public void testPreorderIterator() {
		testBST = new BSTree();
		
		//TODO DO this method 
		//Add like 5 or 6 things then call this method
		//Check to make sure it followed VLR traversal 
	}
	
	public void testPostorderIterator() {
		testBST = new BSTree();
		
		//TODO DO this method 
		//Add like 5 or 6 things then call this method
		//Check to make sure it followed LRV traversal 

	}
}

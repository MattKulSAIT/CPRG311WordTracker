package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import exceptions.TreeException;
import referenceBasedTreeImplementation.BSTree;
import referenceBasedTreeImplementation.BSTree.Iterator;
import referenceBasedTreeImplementation.BSTreeNode;



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
	public void testGetRoot() throws TreeException {
		testBST = new BSTree();
		
		assertThrows(TreeException.class, () ->testBST.getRoot());

		testBST.add("V");
		assertEquals("V", testBST.getRoot().getHolding());
		
		
		testBST.add("Q");
		testBST.add("A");
		assertEquals("V", testBST.getRoot().getHolding());
		
	}

	@Test
	public void testGetHeight() {
		testBST = new BSTree();
		
		assertEquals(0, testBST.getHeight());

		testBST.add("A");
		assertEquals(1, testBST.getHeight());
		
		testBST.add("B");
		testBST.add("C");
		testBST.add("F");
		assertEquals(4, testBST.getHeight());
		
		//Maybe add a few more test to this maybe
	}
	
	@Test
	public void testGetSize() {
		testBST = new BSTree();
		
		assertEquals(0, testBST.size());
		
		testBST.add("V");
		testBST.add("Q");
		testBST.add("A");
		
		assertEquals(3, testBST.size());		
	}
	
	@Test
	public void testIsEmpty() {
		testBST = new BSTree();
		
		assertTrue(testBST.isEmpty());

		testBST.add("A");
		assertFalse(testBST.isEmpty());
		
	}
	
	@Test
	public void testClear() {
		testBST = new BSTree();
		
		assertTrue(testBST.isEmpty());
		assertEquals(0, testBST.size());
		testBST.add("V");
		testBST.add("Q");
		testBST.add("A");
		assertEquals(3, testBST.size());
		testBST.clear();
		assertEquals(0, testBST.size());
		assertThrows(TreeException.class, () ->testBST.getRoot());
		
	}
	
	@Test
	public void testContains() throws TreeException {
		testBST = new BSTree();
		assertThrows(TreeException.class, () ->testBST.contains("P"));
		
		testBST.add("V");
		testBST.add("Q");
		testBST.add("A");
		
		assertTrue(testBST.contains("V"));
		assertTrue(testBST.contains("A"));
		assertFalse(testBST.contains("Z"));
		assertFalse(testBST.contains("B"));
	}
	
	@Test
	public void testSearch() throws TreeException {
		testBST = new BSTree();
		assertThrows(TreeException.class, () ->testBST.search("P"));
		
		
		testBST.add("V");
		testBST.add("Q");
		testBST.add("A");
		
		BSTreeNode nodeFound= testBST.search("Q");
		assertEquals("Q", nodeFound.getHolding());
		
		//Test to make sure null is returned if object searching for is not there
		assertEquals(null, testBST.search("P"));
	}
	
	@Test
	public void testAdd() throws TreeException {
		testBST = new BSTree();

		testBST.add("S");
		
		assertEquals(1, testBST.size());
		assertEquals("S", testBST.getRoot().getHolding());
		
		testBST.add("V");
		testBST.add("Q");
		testBST.add("A");
		assertEquals(4, testBST.size());
		assertEquals("S", testBST.getRoot().getHolding());
		
		//Testing to make sure duplicates dont get added 
		testBST.add("S");
		assertEquals(4, testBST.size());
		
		//Testing to make sure Nodes go in the right spot
		BSTreeNode root = testBST.getRoot();
		assertEquals("V", root.getRightSubNode().getHolding());
		assertEquals("Q", root.getLeftSubNode().getHolding());
		
		BSTreeNode subNodes = root.getLeftSubNode();
		assertEquals("A", subNodes.getLeftSubNode().getHolding());
		
		//Test adding Null
		assertThrows(NullPointerException.class, () ->testBST.add(null));
		
		assertEquals(3, testBST.getHeight());

	}
	
	@Test
	public void testInorderIterator() {
		testBST = new BSTree();
		
		testBST.add("S");
		testBST.add("V");
		testBST.add("Q");
		testBST.add("A");
		
		Iterator i = testBST.inorderIterator();
		
		assertTrue(i.hasNext());
		assertEquals("A",i.next().getHolding());
		assertEquals("Q",i.next().getHolding());
		assertEquals("S",i.next().getHolding());
		assertEquals("V",i.next().getHolding());
		assertFalse(i.hasNext());
		//fail();
		//TODO DO this method 
		
	}

	@Test
	public void testPreorderIterator() {
		testBST = new BSTree();
		
		testBST.add("S");
		testBST.add("V");
		testBST.add("Q");
		testBST.add("A");
		
		Iterator i = testBST.preorderIterator();
		
		assertTrue(i.hasNext());
		assertEquals("S",i.next().getHolding());
		assertEquals("Q",i.next().getHolding());
		assertEquals("A",i.next().getHolding());
		assertEquals("V",i.next().getHolding());
		assertFalse(i.hasNext());
		
	}
	
	@Test
	public void testPostorderIterator() {
		testBST = new BSTree();
		//fail();
		//TODO DO this method 
		testBST.add("S");
		testBST.add("V");
		testBST.add("Q");
		testBST.add("A");
		
		Iterator i = testBST.postorderIterator();
		
		assertTrue(i.hasNext());
		assertEquals("A",i.next().getHolding());
		assertEquals("Q",i.next().getHolding());
		assertEquals("V",i.next().getHolding());
		assertEquals("S",i.next().getHolding());
		assertFalse(i.hasNext());

	}
}

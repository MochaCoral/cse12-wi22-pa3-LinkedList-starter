/**
 * Name: Morales, Kyle
 * Email:kmmorale@ucsd.edu
 * Sources used: Zybooks, piazza answers, PA documentation
 * 
 * Description: Custom JUnit testers for the implementation 
 * of MyLinkedList<E>
 */

import static org.junit.Assert.*;
import org.junit.*;

/**
 * 10 JUnit tests that cover cases that the public tester doesn't touch on.
 * 
 * IMPORTANT: Do not change the method headers and points are awarded 
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class MyLinkedListCustomTester {
	private MyLinkedList<String> emptyStringList;
	private MyLinkedList<Integer> threeIntegerList;
	private int[] intData = {10, 27, 2000};
	private boolean exceptionThrown;
		
	/**
	 * This sets up the test fixture. JUnit invokes this method before
	 * every testXXX method. The @Before tag tells JUnit to run this method
	 * before each test.
	 */
	@Before
	public void setUp() throws Exception {
		emptyStringList = new MyLinkedList<String>();
		threeIntegerList = new MyLinkedList<Integer>();
		exceptionThrown = false;
	}

	private void populateLinkedList() {
		MyLinkedList<Integer>.Node node0 = 
			this.threeIntegerList.new Node(this.intData[0]);
		MyLinkedList<Integer>.Node node1 =
			this.threeIntegerList.new Node(this.intData[1]);
		MyLinkedList<Integer>.Node node2 =
			this.threeIntegerList.new Node(this.intData[2]);
		this.threeIntegerList.head.next = node0;
		node0.next = node1;
		node1.prev = node0;
		node1.next = node2;
		node2.prev = node1;	
		node2.next = this.threeIntegerList.tail;
		this.threeIntegerList.tail.prev = node2;
		this.threeIntegerList.size = 3;
	}

	/**
	 * TODO: test the add method when [fill in a possible edge case here]
	 */

	 // Test edge case involving adding null 
	@Test
	public void testAdd() {
		try {
			this.emptyStringList.add(null);
		}
		catch(NullPointerException e) {
			exceptionThrown = true;
		}
		assertTrue("Null Pointer exception should be thrown", exceptionThrown);
	}

	
	/**
	 * TODO: test the add with index method when [...]
	 */

	 // Test edge case involving out of bounds index
	@Test
	public void testAddWithIndexTestOne() {
		try {
			this.threeIntegerList.add(3, 69);
		}
		catch(IndexOutOfBoundsException e) {
			exceptionThrown = true;
		}
		assertTrue("Index out of bounds should be thrown (AddWithIndex)", exceptionThrown);

	}

	/**
	 * TODO: test the add with index method when [fill in another one here]
	 */	

	 // add a null element to an array
	@Test
	public void testAddWithIndexTestTwo() {
		try {
			this.threeIntegerList.add(1, null);
		}
		catch(NullPointerException e) {
			exceptionThrown = true;
		}
		assertTrue("Null Pointer Exception should be thrown", exceptionThrown);
	}

	/**
	 * TODO: test the get method when [...]
	 */

	 //test out of bounds index 
	@Test
	public void testGet() {
		try {
			this.threeIntegerList.get(4);
		}
		catch(IndexOutOfBoundsException e) {
			exceptionThrown = true;
		}
		assertTrue("index out of bounds exception thrown(get)", exceptionThrown);
	}

	/**
	 * TODO: test the getNth method when [...]
	 */

	 // test get last integer in an integer MLL
	@Test
	public void testGetNth() {
		this.populateLinkedList();
		assertEquals("Check that the third element is returend correctly",
			this.threeIntegerList.head.getNext().getNext().getNext(), 
			this.threeIntegerList.getNth(2));
	}

	/**
	 * TODO: test the set method when [...]
	 */

	 //test set on an empty list
	@Test
	public void testSet() {
		try{
			this.emptyStringList.set(0, "Bruh");
		}
		catch(IndexOutOfBoundsException e) {
			exceptionThrown = true;
		}
		assertTrue("index out of bounds is thrown for empty list",
			exceptionThrown);
	}

	/**
	 * TODO: test the remove method when [...]
	 */

	 // test remove out of bounds index
	@Test
	public void testRemoveTestOne() {
		try {
			this.threeIntegerList.remove(4);
		}
		catch(IndexOutOfBoundsException e) {
			exceptionThrown = true;
		}
		assertTrue("Index out of bounds exception is thrown(Remove)", exceptionThrown);
	}
	
	/**
	 * TODO: test the remove method when [fill in another one here]
	 */

	 // call remove on an empty list
	@Test
	public void testRemoveTestTwo() {
		try {
			this.emptyStringList.remove(0);
		}
		catch(IndexOutOfBoundsException e) {
			exceptionThrown = true;
		}
		assertTrue("An empty array should throw an index out of bounds exception", 
			exceptionThrown);
	}

	/**
	 * TODO: test the clear method when [...]
	 */

	 //call clear on an empty list 
	@Test
	public void testClear() {
		this.emptyStringList.clear();
		assertTrue("The list should be empty", emptyStringList.isEmpty());
	}

	/**
	 * TODO: test the size method when [...]
	 */

	 //call size on a non-empty list
	@Test
	public void testSize() {
		this.populateLinkedList();
		assertEquals("this list should return a size of 3", 3, this.threeIntegerList.size());
	}
}
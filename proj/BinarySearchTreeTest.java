package assign9;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;
/**
 * Tests the methods of the Binary Search Tree
 * 
 * @author Grant Tinkham
 */

public class BinarySearchTreeTest {
	
	BinarySearchTree<String> testList = new BinarySearchTree<String>();
	LinkedList<String> otherList = new LinkedList<String>();
	

	@Test
	public void testAdd() {

		assertEquals(0,  testList.size());
		assertTrue(testList.add("apple"));
		assertEquals(1,  testList.size());
		assertTrue(testList.add("act"));
		assertEquals(2,  testList.size());
		assertTrue(testList.add("bad"));
		assertEquals(3,  testList.size());
		assertFalse(testList.add("bad"));
		

	}
	@Test
	public void testAdd2() {

		SpellChecker sc = new SpellChecker(new File("dictionary.txt"));
		sc.addToDictionary("act");
	}

	@Test
	public void testAddAll() {
		
		otherList.add("act");
		otherList.addLast("apple");
		otherList.addLast("bad");
		otherList.addLast("can");
		otherList.addLast("dog");
		otherList.addLast("eat");
		otherList.addLast("google");
		otherList.addLast("hat");
		otherList.addLast("idea");
		otherList.addLast("jean");
		assertTrue(testList.addAll(otherList));
		assertFalse(testList.addAll(otherList));

	}

	@Test
	public void testClear() {
		testList.add("apple");
		testList.add("act");
		testList.add("bad");
		assertFalse(testList.isEmpty());
		testList.clear();
		assertTrue(testList.isEmpty());
		
	}

	@Test
	public void testContains() {
		
		testList.add("apple");
		testList.add("act");
		testList.add("bad");
		assertTrue(testList.contains("apple"));
		assertTrue(testList.contains("bad"));
		assertTrue(testList.contains("act"));
		assertFalse(testList.contains("error"));
	}

	@Test
	public void testContainsAll() {
		//testList.add("gate");
		otherList.add("act");
		otherList.addLast("apple");
		otherList.addLast("bad");
		otherList.addLast("can");
		otherList.addLast("dog");
		otherList.addLast("eat");
		otherList.addLast("google");
		otherList.addLast("hat");
		otherList.addLast("idea");
		otherList.addLast("jean");
		assertFalse(testList.containsAll(otherList));
		assertTrue(testList.addAll(otherList));
		assertTrue(testList.containsAll(otherList));
	}

	@Test
	public void testFirst() {
		
		testList.add("apple");
		assertEquals(testList.first(),"apple");
		testList.add("act");
		assertEquals(testList.first(),"act");
		testList.add("bad");
		assertEquals(testList.first(),"act");
		
	}

	@Test
	public void testIsEmpty() {
		assertTrue(testList.isEmpty());
		testList.add("apple");
		assertFalse(testList.isEmpty());
	}

	@Test
	public void testLast() {
		testList.add("apple");
		assertEquals(testList.last(),"apple");
		testList.add("act");
		assertEquals(testList.last(),"apple");
		testList.add("bad");
		assertEquals(testList.last(),"bad");
	}

	@Test
	public void testRemove() {
		testList.add("apple");
		testList.add("act");
		testList.add("bad");
		assertTrue(testList.contains("apple"));
		assertTrue(testList.contains("bad"));
		assertTrue(testList.contains("act"));
		assertFalse(testList.contains("error"));
		assertTrue(testList.remove("apple"));
		assertFalse(testList.contains("apple"));
		assertTrue(testList.contains("bad"));
		assertTrue(testList.contains("act"));
		assertTrue(testList.remove("act"));
		assertTrue(testList.contains("bad"));
		assertTrue(testList.remove("bad"));
		assertEquals(0, testList.size());
	}
	

	@Test
	public void testRemoveAll() {
		otherList.addLast("apple");
		otherList.addLast("bad");
		otherList.addLast("can");
		otherList.addLast("dog");
		otherList.addLast("eat");
		otherList.addLast("google");
		otherList.addLast("hat");
		otherList.addLast("idea");
		otherList.addLast("jean");
		assertFalse(testList.containsAll(otherList));
		assertTrue(testList.addAll(otherList));
		assertTrue(testList.containsAll(otherList));
		assertTrue(testList.removeAll(otherList));
		assertFalse(testList.containsAll(otherList));

		
	}

	@Test
	public void testSize() {
		assertEquals(0,  testList.size());
		testList.add("apple");
		assertEquals(1,  testList.size());
		testList.add("act");
		assertEquals(2,  testList.size());
		testList.add("bad");
		assertEquals(3,  testList.size());
		
	}
	@Test
	public void testParent() {
		
		testList.add("apple");
		testList.add("act");
		testList.add("bad");
	}

	@Test
	public void testToArrayList() {
		testList.add("apple");
		testList.add("act");
		testList.add("bad");
		testList.add("aa");
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("aa");
		expected.add("act");
		expected.add("apple");
		expected.add("bad");

		ArrayList<String> actual = testList.toArrayList();
		
		assertEquals(expected, actual);
	}

}

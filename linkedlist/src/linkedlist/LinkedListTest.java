package linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListTest {

	@Test
	void checkFirstNode() {

		List <Integer> list = new List<>("Integer list");
		
		list.addFirst(10);
		list.addLast(25);
		
		assertEquals(10, list.returnFirstNodeValue());
		
		list.addFirst(15);
		
		assertEquals(15, list.returnFirstNodeValue());

	}
	
	@Test
	void checkLastNode() {
		
		List <Double> list = new List<> ("Double list");
		
		list.addFirst(3.1);
		list.addLast(11.75);
		
		assertEquals(11.75, list.returnLastNodeValue());
		
		list.addLast(19.72);
		
		assertEquals(19.72, list.returnLastNodeValue());
	}
	
	@Test
	void addAndRemoveAtIndex() {
		
		List <Integer> list = new List<>();
		
		list.addFirst(3);
		list.add(1, 1);
		list.add(4, 2);
		list.add(1, 3);
		list.addLast(5);
		
		// list contents: 3,1,4,1,5
		assertEquals(3, list.returnValueAtIndex(0));
		assertEquals(4, list.returnValueAtIndex(2));
		
		list.remove(3);
		// list contents: 3,1,4,5
		assertEquals(5, list.returnValueAtIndex(3));
		
		list.addFirst(9);
		// list contents: 9,3,1,4,5
		assertEquals(9, list.returnFirstNodeValue());
		assertEquals(4, list.returnValueAtIndex(3));
	}
	
	@Test
	void isListEmpty () {
		
		List <String> list = new List<>("String list");
		
		assertTrue(list.isEmpty());
		
		list.addFirst("Doug");
		list.addLast("Shugarts");
		
		assertFalse(list.isEmpty());
		
		assertEquals("Doug" , list.returnValueAtIndex(0));
		assertEquals("Shugarts" , list.returnValueAtIndex(1));
		
		list.remove(1);
		list.remove(0);
		
		assertTrue(list.isEmpty());
	}
	
	@Test
	void checkListSize () {
		
		List <Integer> list = new List<>();
		
		list.addFirst(5);
		list.addLast(7);
		list.add(-2, 1);
		
		assertEquals(3, list.getSize());
		
		list.remove(0);
		
		assertEquals(2, list.getSize());
	}

}

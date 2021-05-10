package linkedlist;

public class LinkedListDriver {

	public static void main(String[] args) {

		List <Integer> list = new List<>();
		
		list.addFirst(15);
		list.add(35, 1);
		list.addLast(25);
		list.add(41, 2);
		list.add(55, 3);
		list.addLast(99);
		list.add(73,4);
		/**list.addLast(20);**/
		
		list.setListName("My test list");
		list.print();

		list.remove(4);
		list.addFirst(-23);
		list.addLast(-55);
		list.print();
		
	}

}

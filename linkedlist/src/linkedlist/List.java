package linkedlist;

public class List <T> implements LinkedListInterface <T> {
	
	private Node <T> firstNode;
	private Node <T> lastNode;
	private String listName;
	private int size = 0;
	
	public List() {
		
		this("default list");
	}
	
	public List (String name) {
		
		this.setListName(name);
		this.firstNode = this.lastNode = null;
	}
	
	
	//sets and gets
	
	
	public int getSize() {
		return this.size;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}
	
	public T returnFirstNodeValue () {
		
		return this.firstNode.getData();
	}
	
	public T returnLastNodeValue() {
		
		return this.lastNode.getData();
	}
	
	public T returnValueAtIndex (int index) {
		
		Node<T> temp = this.firstNode;
		int count = 0;
		T returnValue = null;
		
		while (temp != null) {
			
			if (count == index) {
				
				returnValue = temp.getData();
			}
			
			temp = temp.getNext();
			count ++;
		}
		
		return returnValue;
	}
	
	// interface methods
	@Override
	public boolean isEmpty() {
		
		return (this.size == 0 ? true : false);
	}

	@Override
	public int size() {
	
		return size;
	}

	@Override
	public void addFirst(T data) {
		
		if (this.isEmpty()) {
			
			this.firstNode = this.lastNode = new Node <T> (data);
			this.size++;
		}
		
		else {
			
			this.firstNode = new Node<T> (data, this.firstNode);			
			this.size++;
		}
	}

	@Override
	public void addLast(T data) {

		if (isEmpty()) {
			
			this.firstNode = this.lastNode = new Node <T> (data);
			this.size++;
		}
		
		else {
		
			Node <T> temp = this.firstNode;
			
			for (int count = 1; count <= this.size; count ++) {
				
				if (count == this.size) {
					
					temp.setNext(new Node<T>(data));
				}
				
				temp = temp.getNext();
			}

			this.lastNode = temp;
			this.size ++;
		}	
	}

	@Override
	public void add(T data, int index) throws IndexOutOfBoundsException {
		
		if ((index < 0) || (index > this.size())) {
			
			throw new IndexOutOfBoundsException ("Index cannot be a negative number or exceed the length of the list.");
		}
		
		else if (index == 0){
			
			this.addFirst(data);
			this.size++;
		}

		else {
			Node <T> insert = new Node<T>(data);
			Node <T> temp = this.firstNode;
			Node <T> placeHolder;
			
			for (int count = 0; count <= index; count++) {
				
				if (count == index - 1) {
					
					placeHolder = temp.getNext();
					temp.setNext(insert);	
					insert.setNext(placeHolder);
					
					}
				
				temp = temp.getNext();
				
				}

			this.lastNode = temp;
		}
		
		this.size++;
	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {

		if ((index < 0) || (index > this.size()-1)) {
			
			throw new IndexOutOfBoundsException ("Index cannot be a negative number or exceed the length of the list.");
		}
		
		if (this.getSize() == 1) {
			
			this.firstNode = null;
			this.size --;
			return null;
		}
		
		else {
			
			Node <T> temp = this.firstNode;
			Node <T> preceding = new Node <T>();
			Node <T> following = new Node <T>();
			Node <T> returnValue = new Node <T>();
			int count = 0;
			
			while (temp != null) {
				
				if (count == (index-1)) {
					
					preceding = temp;	
				}
				
				else if (count == index) {
					
					returnValue = temp;
				}
				
				else if (count == (index+1)) {
					
					following = temp;
				}
				
				count ++;
				temp = temp.getNext();
			}
			
			preceding.setNext(following);
			this.size --;
			return returnValue.getData();
		}	
	}

	@Override
	public void print() {
	
		Node <T> temp = this.firstNode;
		System.out.println("List name: " + this.getListName()+ ", " + "list size: " + this.getSize());
		
		while (temp != null) {
			
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
		System.out.print("\n\n");
	}
	
}

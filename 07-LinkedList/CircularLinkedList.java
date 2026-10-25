package cll;

import java.util.Scanner;

class Node{
	
	int data;
	Node next;
	
	public Node(int data) {
		
		this.data=data;
		this.next=null;
		
	}
	
}

public class CircularLinkedList {
	
	Node head;
	Node tail;
	
	public CircularLinkedList() {
		
		head = null;
		tail = null;
		
	}
	
	public boolean isEmpty() {
		
		return (head==null);
		
	}
	
	public void insertAtHead(int data) {
		
		Node newNode = new Node(data);
		
		if(head==null) {
			
			newNode.next = newNode; //add
			head = newNode;
			tail = newNode;
			
		}else {
			
			newNode.next = head;
			head = newNode;
			tail.next = head; //add
			
		}
		
	}
	
	public void insertAtTail(int data) {
		
		Node newNode = new Node(data);
		
		if(head==null) {
			
			newNode.next = newNode; //add
			head = newNode;
			tail = newNode;
			
		}else {
			
			tail.next = newNode;
			tail = newNode;
			tail.next = head; //add
			
		}
			
	}
	
	public void insertAtPosition(int pos, int data) {
		
		Node newNode = new Node(data);
		
		int totalNodes = countNodes();
		
		Node prev = null, current = head;
		
		if(pos == 1) {
			
			//if list is empty
			if(head==null) {
				
				newNode.next = newNode;//add
				head = tail = newNode;
				
			}else {
				
				tail.next = newNode; //add 
				newNode.next = head;
				head = newNode;
				
			}
			
		}
		else if(pos>1 && pos <= totalNodes + 1) {
			
			if( pos == totalNodes + 1) {
				
				tail.next = newNode;
				tail = newNode;
				tail.next = head; //add
				
			}else {
				
				for(int i =1; i<pos; i++) {
					
					prev = current;
					current = current.next;
					
				}
				
				newNode.next = current;
				prev.next = newNode;
				
			}
			
		}else {
			
			System.out.println("Invalid node position");
			
		}
		
	}
	
	public void deleteAtHead() {
		
		if(head == null) {
			
			System.out.println("Singly Linked List is Empty");
			
		}// if only one node
		else if( head == tail) {
			
			head = tail = null;
			
		}//more than one node
		else {
			
			Node temp = head;
			head = head.next;
			tail.next = head; //add
			temp = null;
			
		}
		
	}
	
	public void deleteAtTail() {
		
		if(head == null) {
			
			System.out.println("Singly Linked List is Empty");
			
		}
		else if( head == tail) {
			
			head = tail = null;
			
		}else {
			
			//more than one node
			Node current = head;
			//while traversing upto second last node
			while(current.next != tail) {
				
				current = current.next;
				
			}
			current.next = null;//remove the last node
			tail = current; // update the tail to second last node
			tail.next = head; //add
			
		}
		
	}
	
	public void deleteAtPosition(int pos) {
		
		//if list is empty
		if(head == null) {
			
			System.out.println("Singly List is Empty");
			
		}
		//deleting head node
		else if(pos == 1) {
			
			//single node case
			if(head == tail) {
				
				head = null;
				tail = null;
				
			}else {
				
				//more then one node
				Node temp = head;
				head = head.next;
				tail.next = head; //add
				temp = null;				
				
			}
			
		}
		//deleting node at tail or between head and tail
		else if(pos > 1 && pos <= countNodes()) {
			
			Node prev = null, current = head;
			
			for(int i = 1; i < pos; i++) {
				
				prev = current;
				current = current.next;
				
			}
			//deleting last node
			if(current.next == head) {
				
				prev.next = null; 
				tail = prev;
				tail.next = head; //add
				
			}
			//deleting specific node between head and tail
			else {
				
				prev.next = current.next;
				
			}
			
		}else {
			
			System.out.println("Invalid Node position");
			
		}
		
	}
	
	public void displayList() {
		
		Node current = head;
		
		if(head == null) {
			
			System.out.println("The Singly list is empty!");
			return;
			
		}
		
		while(true) {
			
			System.out.print(current.data+" --> ");
			current = current.next;
			if(current == tail.next) {
				break; //add
			}
			
		}
		
		System.out.print("NULL");
		System.out.println();
		
	}
	
	//function to count total nodes
	public int countNodes() {
		
		int count = 0;
		//node current will point to head
		Node current = head;
		
		if(head == null ) {
			return count; //add
		}
		
		do {
			
			current = current.next;
			//increment th count by 1 for each node
			count++;
			
		}while(current != head); //change
		
		return count;
		
	}
	
	public void search(int key) {
		
		Node current = head;
		int flag = 0;
		int pos = 1;
		
		if(head == null) {
			System.out.println(key + " not found");
		}
		
		do {
			
			if(current.data == key) {
				
				System.out.println(key + " found at " +pos+ " position" );
				flag = 1;
				
			}
			current = current.next;
			pos++;
			
		}while(current != head);
		
		if(flag ==0) {
			
			System.out.println(key + " not found");
			
		}
		
	}
	
	public static void main(String[] args) {
		
		CircularLinkedList cll = new CircularLinkedList();
		
		Scanner sc = new Scanner(System.in);
		
		int data, pos;
		int choice;
		
		do {
			
			System.out.println("1. Insert At Head");
			System.out.println("2. Insert At Tail");
			System.out.println("3. Insert At Position");
			System.out.println("4. Display List");
			System.out.println("5. Delete At Head");
			System.out.println("6. Delete At Tail");
			System.out.println("7. Delete At Position");
			System.out.println("8. Reverse List");
			System.out.println("9. Search for Key");
			System.out.println("10. Total Nodes");
			System.out.println("11. Exit");
			
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			
			switch(choice) {
			
				case 1:
					System.out.println("Insert at Head - Enter data:");
					data = sc.nextInt();
					cll.insertAtHead(data);
					cll.displayList();
				break;
				
				case 2:
					System.out.println("Insert at Tail - Enter data:");
					data = sc.nextInt();
					cll.insertAtTail(data);
					cll.displayList();
				break;
				
				case 3:
					System.out.println("Insert at Position - Enter Position:");
					pos = sc.nextInt();
					
					System.out.println("Enter Data:");
					data = sc.nextInt();
					
					cll.insertAtPosition(pos, data);
					System.out.println(" ");
					
					cll.displayList();
				break;
				
				case 4:
					System.out.println("Displaying List:");
					cll.displayList();
				break;
				
				case 5:
					System.out.println("Delete at Head:");
					cll.deleteAtHead();
					cll.displayList();
				break;
				
				case 6:
					System.out.println("Delete At Tail:");
					cll.deleteAtTail();
					cll.displayList();
				break;
				
				case 7:
					System.out.println("Delete At Position - Enter position");
					pos = sc.nextInt();
					cll.deleteAtPosition(pos);
					cll.displayList();
				break;
				
				case 8:
					System.out.println("Reverse list:");
					//cll.reverseList();
					cll.displayList();
				break;
				
				case 9:
					System.out.println("Enter key to search:");
					data = sc.nextInt();
					cll.search(data);
				break;
				
				case 10:
					
					System.out.println("Total Nodes : " + cll.countNodes());
					
				break;
				
				case 11:
					
					System.out.println("Exiting...");
					
				break;
				
				default:
					System.out.println("Insert correct choice");
			
			}
			
		}while(choice!=11);
		
		sc.close();
		
	}

}

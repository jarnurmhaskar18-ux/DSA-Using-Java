package sll;

import java.util.Scanner;

class Node{
	
	int data;
	Node next;
	 
	public Node(int data) {
		
		this.data=data;
		this.next=null;
		
	}
}

public class SinglyLinkedList {
	
	Node head;
	Node tail;
	
	public SinglyLinkedList() {
		
		head = null;
		tail = null;
		
	}
	
	public boolean isEmpty() {
		
		return (head==null);
		
	}
	
	public void insertAtHead(int data) {
		
		Node newNode = new Node(data);
		
		if(head==null) {
			
			head = newNode;
			tail = newNode;
			
		}else {
			
			newNode.next = head;
			head = newNode;
			
		}
		
	}
	
	public void insertAtTail(int data) {
		
		Node newNode = new Node(data);
		
		if(head==null) {
			
			head = newNode;
			tail = newNode;
			
		}else {
			
			tail.next = newNode;
			tail = newNode;
			
		}
		
		
	}
	
	public void insertAtPosition(int pos, int data) {
		
		Node newNode = new Node(data);
		
		int totalNodes = countNodes();
		
		Node prev = null, current = head;
		
		if(pos ==1) {
			
			if(head==null) {
				
				head = newNode;
				tail = newNode;
				
			}else {
				
				newNode.next = head;
				head = newNode;
				
			}
			
		}
		else if(pos>1 && pos <= totalNodes + 1) {
			
			if( pos == totalNodes + 1) {
				
				tail.next = newNode;
				tail = newNode;
				
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
			
		}
		
	}
	
	
	//deleting node at head or tail or between head or tail
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
			if(current.next == null) {
				
				prev.next = null;
				tail = prev;
				
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
		
		while(current!=null) {
			
			System.out.print(current.data+" --> ");
			current = current.next;
			
		}
		
		System.out.print("NULL");
		System.out.println();
		
	}
	
	//function to count total nodes
	public int countNodes() {
		
		int count = 0;
		//node current will point to head
		Node current = head;
		
		while(current!=null) {
			
			//increment th count by 1 for each node
			count++;
			current = current.next;
			
		}
		
		return count;
		
	}

	//reverse the node of list
	public void reverseList() {
		
		Node curr = head, prev = null, temp;
		tail = curr;//set curr as tail
		// check if list is empty
		if(head == null) {
			
			System.out.println("List is Empty");
			return;
			
		}
		//traverse all the nodes of linked list
		while(curr != null) {
			
			//store next node in temp
			temp = curr.next;
			
			//reverse the current nodes next reference
			curr.next = prev;
			
			//move pointers one position ahead
			prev = curr;
			curr = temp;
			
		}
		
		head = prev; //set prev as head
		
	}
	
	public void search(int key) {
		
		Node current = head;
		int flag = 0;
		int pos = 1;
		
		while(current != null) {
			
			if(current.data == key) {
				
				System.out.println(key + " found at " +pos+ " position" );
				flag = 1;
				
			}
			current = current.next;
			pos++;
			
		}
		
		if(flag ==0) {
			
			System.out.println(key + " not found");
			
		}
		
	}
	

	public static void main(String[] args) {
		
		SinglyLinkedList sll = new SinglyLinkedList();
		
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
					sll.insertAtHead(data);
					sll.displayList();
				break;
				
				case 2:
					System.out.println("Insert at Tail - Enter data:");
					data = sc.nextInt();
					sll.insertAtTail(data);
					sll.displayList();
				break;
				
				case 3:
					System.out.println("Insert at Position - Enter Position:");
					pos = sc.nextInt();
					
					System.out.println("Enter Data:");
					data = sc.nextInt();
					
					sll.insertAtPosition(pos, data);
					System.out.println(" ");
					
					sll.displayList();
				break;
				
				case 4:
					System.out.println("Displaying List:");
					sll.displayList();
				break;
				
				case 5:
					System.out.println("Delete at Head:");
					sll.deleteAtHead();
					sll.displayList();
				break;
				
				case 6:
					System.out.println("Delete At Tail:");
					sll.deleteAtTail();
					sll.displayList();
				break;
				
				case 7:
					System.out.println("Delete At Position - Enter position");
					pos = sc.nextInt();
					sll.deleteAtPosition(pos);
					sll.displayList();
				break;
				
				case 8:
					System.out.println("Reverse list:");
					sll.reverseList();
					sll.displayList();
				break;
				
				case 9:
					System.out.println("Enter key to search:");
					data = sc.nextInt();
					sll.search(data);
				break;
				
				case 10:
					
					System.out.println("Total Nodes : " + sll.countNodes());
					
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
/*
 * 1. Insert At Head
2. Insert At Tail
3. Insert At Position
4. Display List
5. Delete At Head
6. Delete At Tail
7. Delete At Position
8. Reverse List
9. Search for Key
10. Total Nodes
11. Exit
Enter your choice
1
Insert at Head - Enter data:
23
23 --> NULL
1. Insert At Head
2. Insert At Tail
3. Insert At Position
4. Display List
5. Delete At Head
6. Delete At Tail
7. Delete At Position
8. Reverse List
9. Search for Key
10. Total Nodes
11. Exit
Enter your choice
2
Insert at Tail - Enter data:
34
23 --> 34 --> NULL
1. Insert At Head
2. Insert At Tail
3. Insert At Position
4. Display List
5. Delete At Head
6. Delete At Tail
7. Delete At Position
8. Reverse List
9. Search for Key
10. Total Nodes
11. Exit
Enter your choice
2
Insert at Tail - Enter data:
10
23 --> 34 --> 10 --> NULL
1. Insert At Head
2. Insert At Tail
3. Insert At Position
4. Display List
5. Delete At Head
6. Delete At Tail
7. Delete At Position
8. Reverse List
9. Search for Key
10. Total Nodes
11. Exit
Enter your choice
5
Delete at Head:
34 --> 10 --> NULL
1. Insert At Head
2. Insert At Tail
3. Insert At Position
4. Display List
5. Delete At Head
6. Delete At Tail
7. Delete At Position
8. Reverse List
9. Search for Key
10. Total Nodes
11. Exit
Enter your choice
6
Delete At Tail:
34 --> NULL
1. Insert At Head
2. Insert At Tail
3. Insert At Position
4. Display List
5. Delete At Head
6. Delete At Tail
7. Delete At Position
8. Reverse List
9. Search for Key
10. Total Nodes
11. Exit
Enter your choice
2
Insert at Tail - Enter data:
34
34 --> 34 --> NULL
1. Insert At Head
2. Insert At Tail
3. Insert At Position
4. Display List
5. Delete At Head
6. Delete At Tail
7. Delete At Position
8. Reverse List
9. Search for Key
10. Total Nodes
11. Exit
Enter your choice
2
Insert at Tail - Enter data:
56
34 --> 34 --> 56 --> NULL
1. Insert At Head
2. Insert At Tail
3. Insert At Position
4. Display List
5. Delete At Head
6. Delete At Tail
7. Delete At Position
8. Reverse List
9. Search for Key
10. Total Nodes
11. Exit
Enter your choice
7
Delete At Position - Enter position
2
34 --> 56 --> NULL
1. Insert At Head
2. Insert At Tail
3. Insert At Position
4. Display List
5. Delete At Head
6. Delete At Tail
7. Delete At Position
8. Reverse List
9. Search for Key
10. Total Nodes
11. Exit
Enter your choice
8
Reverse list:
56 --> 34 --> NULL
1. Insert At Head
2. Insert At Tail
3. Insert At Position
4. Display List
5. Delete At Head
6. Delete At Tail
7. Delete At Position
8. Reverse List
9. Search for Key
10. Total Nodes
11. Exit
Enter your choice
9
Enter key to search:
56
56 found at 1 position
1. Insert At Head
2. Insert At Tail
3. Insert At Position
4. Display List
5. Delete At Head
6. Delete At Tail
7. Delete At Position
8. Reverse List
9. Search for Key
10. Total Nodes
11. Exit
Enter your choice
9
Enter key to search:
78
78 not found
1. Insert At Head
2. Insert At Tail
3. Insert At Position
4. Display List
5. Delete At Head
6. Delete At Tail
7. Delete At Position
8. Reverse List
9. Search for Key
10. Total Nodes
11. Exit
Enter your choice
10
Total Nodes : 2
1. Insert At Head
2. Insert At Tail
3. Insert At Position
4. Display List
5. Delete At Head
6. Delete At Tail
7. Delete At Position
8. Reverse List
9. Search for Key
10. Total Nodes
11. Exit
Enter your choice

 */

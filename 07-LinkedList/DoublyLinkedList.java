package dll;

import java.util.Scanner;

class Node{
	
	int data;
	Node next;
	Node prev;//add
	 
	public Node(int data) {
		
		this.data=data;
		this.prev=null;//add
		this.next=null;
		
	}
}

public class DoublyLinkedList {
	
	Node head;
	Node tail;
	
	public DoublyLinkedList() {
		
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
			head.prev= newNode;//add
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
			newNode.prev = tail;//add
			tail = newNode;
			
		}
		
	}
	
	public void insertAtPosition(int pos, int data) {
		//change all flow without using countnode method
		Node newNode = new Node(data);
		
		if(pos ==1) {
			//list is empty
			if(head==null) {
				
				head = newNode;
				tail = newNode;
				
			}else {//list contains more than one or more nodes
				
				newNode.next = head;
				head.prev= newNode;//add
				head = newNode;
				
			}
			
		}
		else {
			Node current = head;
			int currPos = 1;
			while(current != null && currPos < pos) {
				current = current.next;
				currPos++;
			}
			if(pos < 1 || pos > currPos) {
				System.out.println("Invalid node position");
				return;
			}
			//insert at tail
			if(current==null) {
				if(tail ==null) {
					
					head = newNode;
					tail = newNode;
					
				}else {
					
					tail.next = newNode;
					newNode.prev = tail;//add
					tail = newNode;
					
				}
			}else {
				newNode.next =current;
				newNode.prev = current.prev;
				current.prev.next = newNode;
				current.prev = newNode;
			}
			
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
			head.prev = null;//add
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
			//traversing note required because of prev reference
			//more than one node
			Node temp = tail;
			tail = tail.prev;
			tail.next = null;
			temp = null;
			
		}
		
	}
	
	public void deleteAtPosition(int pos) {
		
		Node current = head;
		int totalNodes = countNodes();
		
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
				head.prev = null;//add
				temp = null;				
				
			}
			
		}
		//deleting node at tail or between head and tail
		else if(pos > 1 && pos <= totalNodes) {
			
			if(pos==totalNodes) {
				
				//if only one node
				if(head.next==null) {
					
					head = null;
					tail = null;
					
				}else {
					
					Node temp = tail;
					tail = tail.prev;
					tail.next = null;
					temp = null;
					
				}
			}
			//deleting middle
			else {
				
				for(int i = 1; i < pos; i++) {
					
					current = current.next;
					
				}
				current.prev.next = current.next;
				current.next.prev = current.prev;
				current.prev = null;
				current.next =null;
				
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
	
	public void displayReverseList() {
		
		Node current = tail;
		
		if(head == null) {
			
			System.out.println("The Singly list is empty!");
			return;
			
		}
		
		while(current!=null) {
			
			System.out.print(current.data+" --> ");
			current = current.prev;
			
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
		
		DoublyLinkedList dll = new DoublyLinkedList();
		
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
					dll.insertAtHead(data);
					dll.displayList();
				break;
				
				case 2:
					System.out.println("Insert at Tail - Enter data:");
					data = sc.nextInt();
					dll.insertAtTail(data);
					dll.displayList();
				break;
				
				case 3:
					System.out.println("Insert at Position - Enter Position:");
					pos = sc.nextInt();
					
					System.out.println("Enter Data:");
					data = sc.nextInt();
					
					dll.insertAtPosition(pos, data);
					System.out.println(" ");
					
					dll.displayList();
				break;
				
				case 4:
					System.out.println("Displaying List:");
					dll.displayList();
				break;
				
				case 5:
					System.out.println("Delete at Head:");
					dll.deleteAtHead();
					dll.displayList();
				break;
				
				case 6:
					System.out.println("Delete At Tail:");
					dll.deleteAtTail();
					dll.displayList();
				break;
				
				case 7:
					System.out.println("Delete At Position - Enter position");
					pos = sc.nextInt();
					dll.deleteAtPosition(pos);
					dll.displayList();
				break;
				
				case 8:
					System.out.println("Reverse list:");
					dll.displayReverseList();
				break;
				
				case 9:
					System.out.println("Enter key to search:");
					data = sc.nextInt();
					dll.search(data);
				break;
				
				case 10:
					
					System.out.println("Total Nodes : " + dll.countNodes());
					
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
3
Insert at Position - Enter Position:
2
Enter Data:
89
 
23 --> 89 --> 34 --> NULL
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
4
Displaying List:
23 --> 89 --> 34 --> NULL
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
34 --> 89 --> 23 --> NULL
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
89
89 found at 2 position
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
Total Nodes : 3
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
6
Delete At Tail:
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
5
Delete at Head:
The Singly list is empty!
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

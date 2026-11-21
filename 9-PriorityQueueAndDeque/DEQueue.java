package deque;

import java.util.Scanner;

class Node{
	
	int data;
	Node next;
	Node prev;
	 
	public Node(int data) {
		
		this.data=data;
		this.prev=null;
		this.next=null;
		
	}
}

public class DEQueue {
	
	Node front, rear;
	int size;
	
	public DEQueue() {
		
		front = rear = null;
		size = 0;
		
	}
	
	public boolean isEmpty() {
		
		return (front == null);
	
	}
	
	//return number of elements of deque
	public int getsize() {
		
		return size;
		
	}
	
	//insert an element at the front end
	public void insertFront(int data) {
		
		Node newNode = new Node(data);
		
		if(newNode == null) {
			
			System.out.println("Overflow");
			
		}else {
			
			if(front == null) {
				
				rear = front = newNode;
				
			}else {
				
				newNode.next = front;
				front.prev = newNode;
				front = newNode;
				
			}
			
			size++;
			
		}
		
	}
	
	public void insertRear(int data) {
		
		Node newNode = new Node(data);
		
		if(newNode == null) {
			
			System.out.println("Overflow");
			
		}else {
			
			if(front == null) {
				
				rear = front = newNode;
				
			}else {
				
				newNode.prev = rear;
				rear.next = newNode;
				rear = newNode;
				
			}
			
			size++;
			
		}
		
	}
	
	public void deleteFront() {
		
		if(isEmpty()) {
			
			System.out.println("Underflow- Deque is empty");
			
		}else {
			
			Node temp = front;
			front = front.next;
			
			if(front == null) {
				
				rear = null;
				
			}else {
				
				front.prev = null;
				
			}
			
			size--;
			
		}
		
	}
	
	public void deleteRear() {
		
		if(isEmpty()) {
			
			System.out.println("Underflow- Deque is empty");
			
		}else {
			
			Node temp = rear;
			rear = rear.prev;
			
			if(rear == null) {
				
				front = null;
				
			}else {
				
				rear.next = null;
				
			}
			
			size--;
			
		}
		
	}
	
	public int getFront() {
		
		if(isEmpty()) {
			
			return Integer.MIN_VALUE;
			
		}
		return front.data;
		
	}
	
	public int getRear() {
		
		if(isEmpty()) {
			
			return Integer.MIN_VALUE;
			
		}
		return rear.data;
		
	}
	
	public void display() {
		
		Node current = front;
		
		if(front == null) {
			
			System.out.println("The Deque is empty!");
			return;
			
		}
		
		System.out.println("The data in double ended queue:");
		System.out.print("NULL <-> ");
		while(current!=null) {
			
			System.out.print(current.data+" <-> ");
			current = current.next;
			
		}
		
		System.out.print("NULL");
		System.out.println();
		
	}

	public static void main(String[] args) {
		
		DEQueue dq = new DEQueue();
		
		Scanner sc = new Scanner(System.in);
		
		int data, pos;
		int choice;
		
		do {
			
			System.out.println("1. Insert At Front");
			System.out.println("2. Insert At Rear");
			System.out.println("3. Display List");
			System.out.println("4. Delete At Head");
			System.out.println("5. Delete At Tail");
			System.out.println("6. Total Nodes");
			System.out.println("7. Exit");
			
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			
			switch(choice) {
			
				case 1:
					System.out.println("Insert at Front - Enter data:");
					data = sc.nextInt();
					dq.insertFront(data);
					dq.display();
				break;
				
				case 2:
					System.out.println("Insert at Rear - Enter data:");
					data = sc.nextInt();
					dq.insertRear(data);
					dq.display();
				break;
				
				case 3:
					System.out.println("Displaying List:");
					dq.display();
				break;
				
				case 4:
					System.out.println("Delete at Front:");
					dq.deleteFront();
					dq.display();
				break;
				
				case 5:
					System.out.println("Delete At Rear:");
					dq.deleteRear();
					dq.display();
				break;
				
				case 6:
					
					System.out.println("Total Nodes : " + dq.getsize());
					
				break;
				
				case 7:
					
					System.out.println("Exiting...");
					
				break;
				
				default:
					System.out.println("Insert correct choice");
			
			}
			
		}while(choice!=7);
		
		sc.close();
		
	}

}
/*
 * 1. Insert At Front
2. Insert At Rear
3. Display List
4. Delete At Head
5. Delete At Tail
6. Total Nodes
7. Exit
Enter your choice
1
Insert at Front - Enter data:
56
The data in double ended queue:
NULL <-> 56 <-> NULL
1. Insert At Front
2. Insert At Rear
3. Display List
4. Delete At Head
5. Delete At Tail
6. Total Nodes
7. Exit
Enter your choice
2
Insert at Rear - Enter data:
34
The data in double ended queue:
NULL <-> 56 <-> 34 <-> NULL
1. Insert At Front
2. Insert At Rear
3. Display List
4. Delete At Head
5. Delete At Tail
6. Total Nodes
7. Exit
Enter your choice
1
Insert at Front - Enter data:
56
The data in double ended queue:
NULL <-> 56 <-> 56 <-> 34 <-> NULL
1. Insert At Front
2. Insert At Rear
3. Display List
4. Delete At Head
5. Delete At Tail
6. Total Nodes
7. Exit
Enter your choice
4
Delete at Front:
The data in double ended queue:
NULL <-> 56 <-> 34 <-> NULL
1. Insert At Front
2. Insert At Rear
3. Display List
4. Delete At Head
5. Delete At Tail
6. Total Nodes
7. Exit
Enter your choice
5
Delete At Rear:
The data in double ended queue:
NULL <-> 56 <-> NULL
1. Insert At Front
2. Insert At Rear
3. Display List
4. Delete At Head
5. Delete At Tail
6. Total Nodes
7. Exit
Enter your choice
6
Total Nodes : 1
1. Insert At Front
2. Insert At Rear
3. Display List
4. Delete At Head
5. Delete At Tail
6. Total Nodes
7. Exit
Enter your choice
7
Exiting...
*/

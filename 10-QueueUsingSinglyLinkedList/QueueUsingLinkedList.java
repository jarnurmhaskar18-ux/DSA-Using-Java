package queue;

import java.util.Scanner;

class Node{
	
	int data;
	Node next;
	 
	public Node(int data) {
		
		this.data=data;
		this.next=null;
		
	}
}

//class to implement queue operations using a linked list
class Queue{
	
	//pointer to tht front and rear of the linked list
	Node front, rear;
	
	//constructor to initalize front and rear
	public Queue() {
		
		front = rear = null;
		
	}
	
	boolean isEmpty() {
		//if the front and rear are null the queue is empty otherwise not
		return front == null && rear == null;
		
	}
	
	//function to add elements to queue
	void enqueue(int data) {
		
		//craete a new node
		Node newNode = new Node(data);
		
		//if queue is empty new node is rear and front
		if(rear == null) {
			
			front = rear = newNode;
			return;
			
		}
		
		//add the newnode at the end of the queue and change rear
		rear.next = newNode;
		rear = newNode;
		
	}
	
	//function to remove element from queue
	void dequeue() {
		
		//if queue is empty return
		if(isEmpty()) {
			System.out.println("Queue Underflow");
			return;
		}
		
		//store prevois front and move one node ahead
		Node temp = front;
		System.out.println("Deleted Element:" + temp.data);
		front = front.next;
		
		//if front becomes null then cahnge rear also to null
		if(front == null) {
			
			rear = null;
			
		}
		
	}
	
	//function to get the front element of the queue
	int getFront() {
		
		//check if queue is empty
		if(isEmpty()) {
			
			System.out.println("Queue is Empty");
			return Integer.MIN_VALUE;
			
		}
		return front.data;
		
	}
	
	//funtion to get rear element of queue
	int getRear() {
		
		//check if queue is empty
		if(isEmpty()) {
			
			System.out.println("Queue is Empty");
			return Integer.MIN_VALUE;
			
		}
		return rear.data;
		
	}
	
	public void displayQueue() {
		
		Node current = front;
		
		if(front == null) {
			
			System.out.println("Queue is Empty");
			return;
			
		}
		
		System.out.println("The Data in Queue are:");
		
		while(current != null) {
			
			System.out.print(current.data + " --> ");
			current = current.next;
			
		}
		
		System.out.print("NULL");
		System.out.println();
		
	}
	
	
}

public class QueueUsingLinkedList {

	public static void main(String[] args) {
		
		Queue q = new Queue();
		
		Scanner sc = new Scanner(System.in);
		
		int val;
		
		int choice;
		
		do {
			
			System.out.println("\n1. Insert(enqueue)");
			System.out.println("2. Delete (dequeue)");
			System.out.println("3. Display");
			System.out.println("4. Exit");
			
			System.out.println("Enter your choice:");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
					
					System.out.println("Enter value to be enqueued(insert):");
					val = sc.nextInt();
					q.enqueue(val);
					q.displayQueue();
				
			break;
				
			case 2:
				
				q.dequeue();
				
			break;
			
			case 3:
				 
				q.displayQueue();
			
			break;
			
			case 4:
				
				System.out.println("Exiting...");
				
			break;
			
			default:
				System.out.println("wrong choice");
				
			}
			
		}while(choice != 4);
		
		sc.close();
		
		
	}

}
/*

1. Insert(enqueue)
2. Delete (dequeue)
3. Display
4. Exit
Enter your choice:
2
Queue Underflow

1. Insert(enqueue)
2. Delete (dequeue)
3. Display
4. Exit
Enter your choice:
1
Enter value to be enqueued(insert):
23
The Data in Queue are:
23 --> NULL

1. Insert(enqueue)
2. Delete (dequeue)
3. Display
4. Exit
Enter your choice:
1
Enter value to be enqueued(insert):
34
The Data in Queue are:
23 --> 34 --> NULL

1. Insert(enqueue)
2. Delete (dequeue)
3. Display
4. Exit
Enter your choice:
1
Enter value to be enqueued(insert):
36
The Data in Queue are:
23 --> 34 --> 36 --> NULL

1. Insert(enqueue)
2. Delete (dequeue)
3. Display
4. Exit
Enter your choice:
2
Deleted Element:23

1. Insert(enqueue)
2. Delete (dequeue)
3. Display
4. Exit
Enter your choice:
3
The Data in Queue are:
34 --> 36 --> NULL

1. Insert(enqueue)
2. Delete (dequeue)
3. Display
4. Exit
Enter your choice:
4
Exiting...
*/
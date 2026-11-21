package priorityQueue;

import java.util.Scanner;

class Node{
	
	int data;
	int priority; //lower value higher priority
	Node next;
	 
	public Node(int data, int priority) {
		
		this.data=data;
		this.priority = priority;//add
		this.next=null;
		
	}
}

public class PriorityQueue {
	
	Node head;
	
	public PriorityQueue(){
		
		head = null;
		
	}
	
	//removes element with highest priority
	public Node dequeue() {
		
		Node temp = head;
		head = head.next;
		return head;
		
	}
	
	//function to insert element according to priority
	public void enqueue(int d, int p) {
		
		Node curr = head;
		Node newNode = new Node(d, p);
		
		//if queueu is empty
		if(head==null) {
			
			head = newNode;
			return;

		}
		
		if(head.priority > p) {
			
			//insert new node before head
			newNode.next = head;
			head = newNode;
			
		}else {
			
			//traverse the list and find a position to insert newnode
			while(curr.next != null && curr.next.priority < p) {
				
				curr = curr.next;
				
			}
			//either at the ends of the list or at required posiition
			newNode.next = curr.next;
			curr.next = newNode;
			
		}
		
	}
	
	public boolean isEmpty() {
		
		return (head == null)? true:false;
		
	}
	
	public void display() {
		
		Node current = head;
		
		if(head == null) {
			
			System.out.println("The priority queue is empty");
			return;
			
		}
		System.out.println("The data in priority queue are:");
		
		while(current != null) {
			
			System.out.print(current.data + "," + current.priority + " --> ");
			current = current.next;
			
		}
		System.out.print("NULL");
		System.out.println();
		
	}

	public static void main(String[] args) {
		
		PriorityQueue q = new PriorityQueue();
		
		Scanner sc = new Scanner(System.in);
		
		int val, priority;
		
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
					System.out.println("Enter Priority of Value:");
					priority = sc.nextInt();
					q.enqueue(val,priority);
					q.display();
				
			break;
				
			case 2:
				
				q.dequeue();
				
			break;
			
			case 3:
				 
				q.display();
			
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

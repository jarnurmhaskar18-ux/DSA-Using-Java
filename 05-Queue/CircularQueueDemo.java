package queue;

import java.util.Scanner;

class MyCircularQueue{
	
	int QUEUESIZE;
	int arr[];
	int q_front;  
	int q_rear;
	
	public MyCircularQueue(int size) {
		QUEUESIZE=size;
		arr = new int [QUEUESIZE];
		q_front= -1;//-1 for circular queue
		q_rear= -1;
	}
	
	public void enqueue(int val) {
		
		//checks for empty queue for adding first element
		if(isEmpty() == true) {
			
			q_rear = 0;
			q_front = 0;
			arr[q_rear] = val;
			
			
		}else {
			
			q_rear = (q_rear+1) % QUEUESIZE;
			arr[q_rear] = val;
			
		}
		
	}
	
	public int dequeue() {
		
		int q_element;
		
		if(q_front == q_rear) //only one element in the queue
		{
			q_element = arr[q_front];
			q_rear = -1;//resetting rear for empty queue
			q_front = -1; // resetting front for empty queue
			
		}else {//more than one element 
			
			q_element = arr[q_front];
			q_front = (q_front+1) % QUEUESIZE;
			
		}
		
		return q_element;
		
	}
	
	public boolean isEmpty() {
		
		if(q_rear == -1) {
			
			return true;
			
		}else {
			
			return false;
		}
		
	}
	
	public boolean isFull() {
		
		if((q_rear+1)%QUEUESIZE==q_front) {
			
			return true;
			
		}else {
			
			return false;
			
		}
		
	}
	
	public int size() {
		
		if(q_rear > q_front) {
			
			return q_rear-q_front+1;
			
		}else {
			
			return QUEUESIZE-q_rear-q_front+1;
			
		}
		
	}
	
	public void displayAllElements() {
		
		if(q_rear == -1) {
			
			System.out.println("No Elements to display");
			return;
		}
		
		System.out.println("Elements in the queue are:");
		for(int i = q_front; i!=q_rear; i=(i+1)%QUEUESIZE) {
			
			System.out.println(arr[i]+"");
			
		}
		
		System.out.println(arr[q_rear]+" ");
		System.out.println("");
		
	}
	
}

public class CircularQueueDemo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		MyCircularQueue q = new MyCircularQueue(5);
		
		int val;
		
		int choice;
		
		do {
			
			System.out.println("\n1. Insert(enqueue)");
			System.out.println("2. Delete (dequeue)");
			System.out.println("3. Display");
			System.out.println("4. Display Size");
			System.out.println("5. Exit");
			
			System.out.println("Enter your choice:");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				
				if(q.isFull()==false) {
					
					System.out.println("Enter value to be enqueued(insert):");
					val = sc.nextInt();
					q.enqueue(val);
					
				}else {
					
					System.out.println("Queue is Full, Cannot Enqueue Values");
					
				}
			break;
				
			case 2:
				
				if(q.isEmpty()==false) {
					
					val = q.dequeue(); 
					System.out.println("Dequeued Element is:"+ val);
					
				}else {
					
					System.out.println("Queue is Empty, Cannot Dequeue Values");
					
				}
				
			break;
			
			case 3:
				 
				q.displayAllElements();
			
			break;
			
			case 4:
				
				System.out.println("Size of Queue is:"+ q.size());
			break;
			
			case 5:
				
				System.out.println("Exiting...");
				
			break;
			
			default:
				System.out.println("wrong choice");
				
			}
			
		}while(choice != 5);
		
		sc.close();
	}

}

package queue;

import java.util.Scanner;

class MyQueue{
	int QUEUESIZE;
	int arr[];
	int q_front;  
	int q_rear;
	
	public MyQueue(int size) {
		QUEUESIZE=size;
		arr = new int [QUEUESIZE];
		q_front=0;
		q_rear=-1;
	}
	
	void enqueue(int val) {
		q_rear=q_rear+1;
		arr[q_rear]=val;
	}
	
	public int dequeue() {
		int q_element;
		q_element=arr[q_front];
		q_front=q_front+1;
		return q_element;
	}
	public boolean isEmpty() {
		
		if(q_rear == -1 || q_front > q_rear) {	
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean isFull() {
		
		if( q_rear == QUEUESIZE-1) {
			return true;
		}else {
			return false;
		}
	}
	
	public int size() {
		
		return q_rear+1;
	}
	
	public void displayAllElements() {
		
		if(isEmpty()) {
			
			System.out.println("\n Queue is Empty. no elements to display");
			
		}else {
			
			System.out.println("Elements in the queue are: ");
			for(int i = q_front; i<= q_rear; i++) {
				System.out.println(arr[i]+"");
			}
			System.out.println(" ");
		}
	}
}

public class QueueDemo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		MyQueue q = new MyQueue(5);
		
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

/*
 * 
1. Insert(enqueue)
2. Delete (dequeue)
3. Display
4. Display Size
5. Exit
Enter your choice:
1
Enter value to be enqueued(insert):
12

1. Insert(enqueue)
2. Delete (dequeue)
3. Display
4. Display Size
5. Exit
Enter your choice:
1
Enter value to be enqueued(insert):
45

1. Insert(enqueue)
2. Delete (dequeue)
3. Display
4. Display Size
5. Exit
Enter your choice:
1
Enter value to be enqueued(insert):
23

1. Insert(enqueue)
2. Delete (dequeue)
3. Display
4. Display Size
5. Exit
Enter your choice:
4
Size of Queue is:3

1. Insert(enqueue)
2. Delete (dequeue)
3. Display
4. Display Size
5. Exit
Enter your choice:
3
Elements in the queue are: 
12
45
23
 

1. Insert(enqueue)
2. Delete (dequeue)
3. Display
4. Display Size
5. Exit
Enter your choice:
2
Dequeued Element is:12

1. Insert(enqueue)
2. Delete (dequeue)
3. Display
4. Display Size
5. Exit
Enter your choice:
2
Dequeued Element is:45

1. Insert(enqueue)
2. Delete (dequeue)
3. Display
4. Display Size
5. Exit
Enter your choice:
2
Dequeued Element is:23

1. Insert(enqueue)
2. Delete (dequeue)
3. Display
4. Display Size
5. Exit
Enter your choice:
2
Queue is Empty, Cannot Dequeue Values

1. Insert(enqueue)
2. Delete (dequeue)
3. Display
4. Display Size
5. Exit
Enter your choice:
2
Queue is Empty, Cannot Dequeue Values

1. Insert(enqueue)
2. Delete (dequeue)
3. Display
4. Display Size
5. Exit
Enter your choice:

 */

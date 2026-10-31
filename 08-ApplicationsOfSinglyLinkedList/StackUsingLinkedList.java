package stack;

import java.util.Scanner;

//class representing node in linkedlist
class Node{
	
	int data;
	Node next;
	 
	public Node(int data) {
		
		this.data=data;
		this.next=null;
		
	}
}

//class to implement stack using singly linked list
class Stack{
	
	//head off linked list
	Node head;//this will be thie top of the stack(tail is not used because top is needed only not tail)
	
	//constructor to initialize the stack
	Stack(){
		this.head = null;
	}
	
	//function to check if stack is empty or not
	boolean isEmpty() {
		
		return head==null;
		
	}
	
	//function to push an element onto the stack
	void push(int data) {
		
		//craete new node with given data
		Node newNode = new Node(data);
		
		//check if the memory allocation for new node failed(RAM space therefore dead code)
		if(newNode == null) {
			
			System.out.println("Stack Overflow");
			return;
			
		}
		
		//link the newnode to the current top
		newNode.next = head;
		
		//update the top to the new node
		head = newNode;
		
	}
	
	//function to remove the top element from the stack
	void pop() {
		
		//check if stack is empty(stack underflow)
		if(isEmpty()) {
			
			System.out.println("\nStack Underflow");
			return;
			
		}else {
			
			//assign the current top to a temporary variable
			Node temp = head;
			
			System.out.println("Popped Element is :"+ temp.data);
			
			//update the top to the next node
			head = head.next;
			temp = null;
			
		}
		
	}
	
	int peek() {
		
		//if stack is not empty return top element 
		if(isEmpty()) {
			
			System.out.println("\nStack is empty");
			return Integer.MIN_VALUE;
			
		}else {
			
			return head.data;
			
		}
		
	}
	
	public void displayStack() {
		
		Node current = head;
		
		if(head == null) {
			
			System.out.println("The stack is empty");
			return;
			
		}
		
		System.out.println("The data in stak are:");
		
		while(current != null) {
			
			System.out.print(current.data + " --> ");
			current = current.next;
			
		}
		System.out.print("NULL");
		System.out.println();
		
	}
	
}

public class StackUsingLinkedList {

	public static void main(String[] args) {
		
		//craeting a stack
		Stack st = new Stack();
		
		Scanner sc = new Scanner(System.in);
		int choice;
		int val;
		do {
			System.out.println("====Menu====");
			System.out.println("1. Push");
			System.out.println("2. Pop");
			System.out.println("3. Peek");
			System.out.println("4. Display All");
			System.out.println("5.Exit");
			System.out.println("Enter your choice");
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter element to push:");
				val=sc.nextInt();
				st.push(val);
				break;
			case 2:
				st.pop();
				break;
			case 3:
				System.out.println("Top Element is:"+ st.peek());
				break;
			case 4:
				st.displayStack();
				break;
			case 5:
				System.out.println("Exiting the program...");
				break;
			default:
				System.out.println("Enter correct Choice number");
			}
		}while(choice!=5);	
		sc.close();
		
		
	}

}
/*====Menu====
1. Push
2. Pop
3. Peek
4. Display All
5.Exit
Enter your choice
2

Stack Underflow
====Menu====
1. Push
2. Pop
3. Peek
4. Display All
5.Exit
Enter your choice
3

Stack is empty
Top Element is:-2147483648
====Menu====
1. Push
2. Pop
3. Peek
4. Display All
5.Exit
Enter your choice
1
Enter element to push:
23
====Menu====
1. Push
2. Pop
3. Peek
4. Display All
5.Exit
Enter your choice
1
Enter element to push:
34
====Menu====
1. Push
2. Pop
3. Peek
4. Display All
5.Exit
Enter your choice
1
Enter element to push:
45
====Menu====
1. Push
2. Pop
3. Peek
4. Display All
5.Exit
Enter your choice
4
The data in stak are:
45 --> 34 --> 23 --> NULL
====Menu====
1. Push
2. Pop
3. Peek
4. Display All
5.Exit
Enter your choice
2
Popped Element is :45
====Menu====
1. Push
2. Pop
3. Peek
4. Display All
5.Exit
Enter your choice
3
Top Element is:34
====Menu====
1. Push
2. Pop
3. Peek
4. Display All
5.Exit
Enter your choice
5
Exiting the program...
*/
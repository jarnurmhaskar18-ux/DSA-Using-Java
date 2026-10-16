package st;

import java.util.Scanner;
//implementation of stack using array
class MyStack{
	
	private int maxSize;
	private int top;
	private int[] stackArray;
	
	//constructor to initialize stack
	public MyStack(int size) {
		maxSize=size;
		stackArray = new int[maxSize];
		top=-1;
	}
	//push operation
	public void push(int value) {
		if(top==maxSize-1) {
			System.out.println("Stack is full cannot enter elements.");
		}else {
			stackArray[++top]=value;//because initially top is -1 it must be 0 for entering elements 
		}
	}
	//pop operation
	public void pop() {
		if(top==-1) {
			System.out.println("Stack is empty, Cannot retrieve elements.");
		}else {
			System.out.println("\n Popped element is: "+stackArray[top--]);//first retrive element then decrement so top--
		}
	}
	//peek operation
	public void peek() {
		if(top==-1) {
			System.out.println("Stack is empty");
		}else {
			System.out.println("Top element is:"+stackArray[top]);//only retriving top element not removing it so top only
		}
	}
	public void displayAll() {
		if(top==-1) {
			System.out.println("\n Stack is Empty. no element to dispay.");
		}else {
			System.out.println("Elements in the stack are:");
			
			for(int i=top;i>=0;i--) {
				System.out.println(stackArray[i]+" ");
			}
			System.out.println(" ");
		}
	}
}



public class StackDemo {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int s;
		int choice;
		int val;
		System.out.println("Enter the size of stack:");
		s=sc.nextInt();
		MyStack st = new MyStack(s);
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
				st.peek();
				break;
			case 4:
				st.displayAll();
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
/*Enter the size of stack:
5
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
3
Top element is:45
====Menu====
1. Push
2. Pop
3. Peek
4. Display All
5.Exit
Enter your choice
1
Enter element to push:
67
====Menu====
1. Push
2. Pop
3. Peek
4. Display All
5.Exit
Enter your choice
1
Enter element to push:
89
====Menu====
1. Push
2. Pop
3. Peek
4. Display All
5.Exit
Enter your choice
1
Enter element to push:
87
====Menu====
1. Push
2. Pop
3. Peek
4. Display All
5.Exit
Enter your choice
1
Enter element to push:
67
====Menu====
1. Push
2. Pop
3. Peek
4. Display All
5.Exit
Enter your choice
1
Enter element to push:
56
Stack is full cannot enter elements.
====Menu====
1. Push
2. Pop
3. Peek
4. Display All
5.Exit
Enter your choice
2

 Popped element is: 67
====Menu====
1. Push
2. Pop
3. Peek
4. Display All
5.Exit
Enter your choice
4
Elements in the stack are:
87 
89 
67 
45 
 
====Menu====
1. Push
2. Pop
3. Peek
4. Display All
5.Exit
Enter your choice
2

 Popped element is: 87
====Menu====
1. Push
2. Pop
3. Peek
4. Display All
5.Exit
Enter your choice
2

 Popped element is: 89
====Menu====
1. Push
2. Pop
3. Peek
4. Display All
5.Exit
Enter your choice
2

 Popped element is: 67
====Menu====
1. Push
2. Pop
3. Peek
4. Display All
5.Exit
Enter your choice
2

 Popped element is: 45
====Menu====
1. Push
2. Pop
3. Peek
4. Display All
5.Exit
Enter your choice
2
Stack is empty, Cannot retrieve elements.
====Menu====
1. Push
2. Pop
3. Peek
4. Display All
5.Exit
Enter your choice
2
Stack is empty, Cannot retrieve elements.
====Menu====
1. Push
2. Pop
3. Peek
4. Display All
5.Exit
Enter your choice

Enter the size of stack:
5
====Menu====
1. Push
2. Pop
3. Peek
4. Display All
5.Exit
Enter your choice
7
Enter correct Choice number
====Menu====
1. Push
2. Pop
3. Peek
4. Display All
5.Exit
Enter your choice
*/
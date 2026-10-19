package application;

import java.util.Scanner;

class MyStack3{
	
	private int maxSize;
	private int top;
	private char[] stackArray;
	
	//Constructor to initialize the stack
	public MyStack3(int size) {
		
		maxSize = size;
		stackArray = new char [maxSize];
		top =-1; 
		
	}
	
	//push operation
	public void push(char value) {
		if(isFull()) {
			System.out.println("Stack is Full! Cannot puch Element! ");
		}else {
			stackArray[++top] = value;			
		}
	}
	
	//pop operation
	public char pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty! cannot pop element!");
			return 'E';
		}else {
			return stackArray[top--];
		}
	}
	
	
	//peek operation
	public char peek() {
		if(isEmpty()) {
			System.out.println("Stack is empty!");
			return 'F';
		}else {
			return stackArray[top];
		}
	}
	
	//check if the stack is full
	public boolean isFull() {
		return (top == maxSize-1);
	}
	
	//check if stack is empty
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public void displayAll() {
		
		if(top==-1) {
			System.out.println("\nStack is empty! no elements to display");
		}else {
			for(int i = top; i<=0; i-- ) {
				System.out.println(stackArray[i]+"");
			}
			System.out.println("");
		}
	}
	
}

public class ParanthesisBalancing {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		MyStack3 st = new MyStack3(10);
		
		System.out.println("Please enter postfix expression:");
		
		String exp = sc.nextLine();
		
		boolean isValid = true;
		
		char c;
		
		//scan all char one by one
		for(int i =0; i<exp.length(); i++) {
			c = exp.charAt(i);
			char stChar;
			
			if(c == '{' || c=='[' || c=='(') {
				
				st.push(c);
				
			}else {
				
				if(st.isEmpty()) {
					
					isValid = false;
					break;
					
				}else {
					
					stChar = st.pop();
					if((stChar != '(' && c == ')') || (stChar != '{' && c == '}') || (stChar != '[' && c == ']')) {
						
						isValid = false;
						break;
						
					}
				}
				
			}
			
		}
		
		if(isValid == true && st.isEmpty()) {
			
			System.out.println("\nParanthesis are Balanced");
			
		}else {
			
			System.out.println("\nParanthesis are NOT Balanced");
			sc.close();
			
		}
		
	}

}

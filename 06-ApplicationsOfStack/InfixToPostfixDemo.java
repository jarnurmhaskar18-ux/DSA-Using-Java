package application;

import java.util.Scanner;

class MyStack{
	
	private int maxSize;
	private int top;
	private char[] stackArray;
	
	//Constructor to initialize the stack
	public MyStack(int size) {
		
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

public class InfixToPostfixDemo {
	
	//function to return precedence of operators
		int prec(char c) {
			if(c=='^') {
				return 3;
			}else if(c=='/'|| c=='*') {
				return 2;
			}else if(c=='+' || c=='-') {
				return 1;
			}else {
				return -1;
			}
		}
		
		//function to perform infix to postfix exp conversion
		void infixToPostfix(String s, MyStack st) {
			
			StringBuilder result = new StringBuilder();
			
			for(int i =0; i < s.length(); i++) {
				
				char c = s.charAt(i);
				
				//if scanned char is an operand add it to ouput string
				if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9')) {
					result.append(c);
					//if scanned char is"("
				}else if(c=='(') {
					st.push(c);
					//if scanned char is ")"
					//pop and add to output string from the stack
					//until "(" is encountered				
				}else if(c==')') {
					
					while(st.peek()!='(') {
						result.append(st.pop());
					}
					st.pop();
				}
				//if an operator is scanned
				else {
					while(!st.isEmpty() && (prec(c)<prec(st.peek()) || prec(c)== prec(st.peek()))) {
						result.append(st.pop());
					}
					st.push(c);
				}
				
			}
			
			//pop all remaining elements from stack
			while(!st.isEmpty()) {
				result.append(st.pop());
			}
			System.out.println("Postfix Expression:"+result.toString());
		}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		MyStack st = new MyStack(15);
		
		System.out.println("Please Enter Infix expression:");
		
		String exp = sc.nextLine();
		
		InfixToPostfixDemo ip = new InfixToPostfixDemo();
		
		ip.infixToPostfix(exp, st);
		
		sc.close();
		
	}

}

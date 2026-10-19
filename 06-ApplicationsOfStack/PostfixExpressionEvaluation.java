package application;

import java.util.Scanner;
import java.lang.Math;

class MyStack2{
	
	private int maxSize;
	private int top;
	private int[] stackArray;
	
	//constructor to initialize the stack
	public MyStack2(int size) {
		
		maxSize = size;
		stackArray = new int[maxSize];
		top = -1;
		
	}
	
	//push operation
	public void push(int value) {
		
		if(isFull()) {
			System.out.println("Stack is Full! Cannot puch Element! ");
		}else {
			stackArray[++top] = value;			
		}
		
	}
	
	//pop operation
	public int pop() {
		
		if(isEmpty()) {
			System.out.println("Stack is empty! cannot pop element!");
			return -1 ;
		}else {
			return stackArray[top--];
		}
		
	}
	
	//peek operation
	public int peek() {
		
		if(isEmpty()) {
			System.out.println("Stack is empty!");
			return -1 ;
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

public class PostfixExpressionEvaluation {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		MyStack2 st = new MyStack2(15);
		
		System.out.println("Please enter postfix expression: ");
		
		String exp = sc.nextLine();
		
		for(int i = 0; i<exp.length(); i++) {
			char c = exp.charAt(i);
		
		
			//if scanned char is operand (number here) push it to the stack
			if(Character.isDigit(c)) {
				st.push(c-'0');//to convert in int
			}
			
			//if the scanned character is operator pop topmost two elements of stack perform calc and push to the stack
			else {
				int val1 = st.pop();
				int val2 = st.pop();
				System.out.println(val1 +" "+c+" "+val2);
				
				switch(c) {
				
				case '+':
					st.push(val2+val1);
				break;
				
				case '-':
					st.push(val2-val1);
				break;
				
				case '/':
					st.push(val2/val1);
				break;
				
				case '*':
					st.push(val2*val1);
				break;
				
				case '^':
					int power = (int) Math.pow(val2, val1);
					st.push(power);
				break;
				
				default:
					System.out.println("Invalid Character Found.");
				
				}
				
			}
			
		}
		
		System.out.println("Answer="+st.pop());
		sc.close();
		
	}

}
/*
 * Please enter postfix expression: 
42^3*3-84/11+/+
2 ^ 4
3 * 16
3 - 48
4 / 8
1 + 1
2 / 2
1 + 45
Answer=46

Please enter postfix expression: 
231*+9-
1 * 3
3 + 2
9 - 5
Answer=-4

Please enter postfix expression: 
23*54*+9-
3 * 2
4 * 5
20 + 6
9 - 26
Answer=17

Please enter postfix expression: 
623+-382/+*2^3+
3 + 2
5 - 6
2 / 8
4 + 3
7 * 1
2 ^ 7
3 + 49
Answer=52
 */

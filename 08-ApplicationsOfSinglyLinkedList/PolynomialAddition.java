package poly;

class Node{
	
	int coeff;
	int pow;
	Node next;
	
	Node(int coeff, int pow){
		 
		this.coeff = coeff;
		this.pow = pow;
		next = null; 
		
	}
	
}

public class PolynomialAddition {
	
	static Node addPolynomial(Node head1, Node head2) {//returns node and passing head of list because others node are accessible via head
		
		//if any list is empty then return the other list
		if(head1 == null) {
			return head2;
		}
		if(head2==null) {
			return head1;
		}
		
		//if head1.pow is greater, then recursively find its next node and return head1
		if(head1.pow > head2.pow) {
			
			Node nextPtr = addPolynomial( head1.next, head2);
			head1.next = nextPtr;
			return head1;
			
		}
		//if head2.pow is greater, then recursively find its next node and return head2
		else if(head1.pow < head2.pow) {
			
			Node nextPtr = addPolynomial( head1, head2.next);
			head2.next = nextPtr;
			return head2;
			
		}
		//else store the sum of head1.coeff and head2.coeff in the head1.coeff then find its next node and return head1
		Node nextPtr = addPolynomial(head1.next , head2.next);
		head1.coeff += head2.coeff;
		head1.next = nextPtr;
		return head1; //as we are storing the addition in head1
		
	}
	
	static void printList(Node head) {
		
		Node curr = head;
		
		while(curr != null) {
			
			System.out.print(curr.coeff + "x^" + curr.pow + " ");
			curr = curr.next;
			
		}
		
		System.out.println();
		
	}

	public static void main(String[] args) {
		
		//1st polynomial : 4x^3+3x^1+3x^0
		Node head1 = new Node(4, 3);
		head1.next = new Node(3, 1);
		head1.next.next = new Node(3, 0);
		
		//2nd polynomial : 2x^1-7x^0
		Node head2 = new Node(2, 1);
		head2.next = new Node(-7, 0);
		
		Node head = addPolynomial(head1, head2);
		
		printList(head);
		
		
	}

}
//4x^3 5x^1 -4x^0 

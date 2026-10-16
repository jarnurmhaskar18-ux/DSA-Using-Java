package hashing2;

import java.util.Scanner;

class HashTable{
	
	private static final int SIZE = 10;
	private final int[] hashTable; //final means array reference cannot be changed after initialization
	
	//constructer(default)
	public HashTable() {
		hashTable = new int[SIZE];
		//-1 indicates empty
		for(int i = 0; i<SIZE;i++) {
			hashTable[i] = -1;
		}
	}
	
	//insert key using digit extraction hashing
	public void insert(int key, int digitPosition) {
		
		//handle negative numbers 
		long absoluteKey = Math.abs((long) key);
		
		//count number of digits
		int numDigits = String.valueOf(absoluteKey).length();
		
		//validate digit position
		if(digitPosition <= 0 || digitPosition > numDigits) {
			
			System.out.println("Invalid Digit Position: "+digitPosition+" for "+key);
			return;
			
		}
		
		/*Extract digit from left to right 
		 Example:
		 Key = 12345 , digitPosition= 3, Extracted Digit = 3
		 Formula: (key/10^(numDigits - digitPosition)) % 10
		 */
		
		int divisor = (int) Math.pow(10, numDigits - digitPosition);
		
		int index = (int) ((absoluteKey/divisor) % 10);
		
		int startIndex = index;
		
		//linear probing in case of collision 
		while(hashTable[index]!=-1) {
			
			System.out.println("\nCollision found at address "+index+" for "+key);
			System.out.println("Searching next empty slot using linear probing!");
			
			index = (index+1) % SIZE;
			
			//check whether the complete table has been searched
			if(index==startIndex) {
				System.out.println("\nHash table is full. cannot insert "+key);
				return;
			}
			
		}
		
		System.out.println("\nNo Collsion at addresss "+index+" for "+key);
		
		hashTable[index] = key;
		
	}
	
	//display hash table
	public void display() {
		
		System.out.println("\n\nFinal Hash Table:");
		
		for(int i = 0; i < SIZE; i++) {
			
			if(hashTable[i]!=-1) {
				System.out.println("Index "+i+": "+hashTable[i]);
			}else {
				System.out.println("Index "+i+": NULL");
			}
		}
		
	}
	
}

public class DigitExtractionHashing {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//create hash table
		HashTable ht = new HashTable();
		
		System.out.println("Hashing using Digit Extraction with Linear Probing");
		
		//accept input from user
		System.out.println("\nEnter Comma-seperated Integer values");
		
		String input = sc.nextLine();
		
		System.out.println("Enter digit position to extract 1 = leftmost digit:");
		
		int digitPosition = sc.nextInt();
		
		//split input using commas
		String[] values = input.split(",");
		
		System.out.println("Input values:");
		
		//insert each key
		for(String value : values) {
			
			System.out.println(value.trim()+" ");
			
		}
		
		System.out.println();
		
		for(String value : values) {
			
			try {
				
				int key = Integer.parseInt(value.trim());
				ht.insert(key, digitPosition);
				
			}catch(NumberFormatException e) {
				
				System.out.println("Invalid input ignored:"+value);
			}
			
		}
		
		//display final hash table
		ht.display();
		
		sc.close();
		
		
	}

}

/*
 * Hashing using Digit Extraction with Linear Probing

Enter Comma-seperated Integer values
4289,5690,1234,2398,5634,3219
Enter digit position to extract 1 = leftmost digit:
1
Input values:
4289 
5690 
1234 
2398 
5634 
3219 


No Collsion at addresss 4 for 4289

No Collsion at addresss 5 for 5690

No Collsion at addresss 1 for 1234

No Collsion at addresss 2 for 2398

Collision found at address 5 for 5634
Searching next empty slot using linear probing!

No Collsion at addresss 6 for 5634

No Collsion at addresss 3 for 3219


Final Hash Table:
Index 0: NULL
Index 1: 1234
Index 2: 2398
Index 3: 3219
Index 4: 4289
Index 5: 5690
Index 6: 5634
Index 7: NULL
Index 8: NULL
Index 9: NULL

 */

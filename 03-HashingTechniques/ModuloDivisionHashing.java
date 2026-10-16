package hashing;

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
	
	//hash function key modulo division returns remainder
	private int hashFunction(int key) {
		return key % SIZE; //Math.floorMod(key,SIZE);
							//floorMod(x,y)=x-(floorDiv(x,y)*y) , x/y remiander is round down
	}
	
	//insert key using linear probing
	public void insertLinearProbing(int key) {
		int index = hashFunction(key);
		int startIndex = index;
		
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
	
	//display the hashtable
	public void displayProbing(){
		
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

public class ModuloDivisionHashing {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		HashTable ht = new HashTable();
		
		System.out.println("Hashing using Modulo Division with Linear Probing");
		
		//accept input from user
		System.out.println("\nEnter Comma-seperated Integer values");
		
		String input = sc.nextLine();
		
		//split input using commas
		String[] values = input.split(",");
		
		System.out.println("\nProcession input values...");
		
		//insert each key
		for(String value : values) {
			
			try {
				
				int key = Integer.parseInt(value.trim());
				ht.insertLinearProbing(key);
				
			}catch(NumberFormatException e) {
				
				System.out.println("Invalid input ignored:"+value);
			}
			
		}
		
		//display final hash table
		ht.displayProbing();
		
		sc.close();
		
	}
}

/*Hashing using Modulo Division with Linear Probing

Enter Comma-seperated Integer values
25,42,96,101,46

Procession input values...

No Collsion at addresss 5 for 25

No Collsion at addresss 2 for 42

No Collsion at addresss 6 for 96

No Collsion at addresss 1 for 101

Collision found at address 6 for 46
Searching next empty slot using linear probing!

No Collsion at addresss 7 for 46


Final Hash Table:
Index 0: NULL
Index 1: 101
Index 2: 42
Index 3: NULL
Index 4: NULL
Index 5: 25
Index 6: 96
Index 7: 46
Index 8: NULL
Index 9: NULL
*/
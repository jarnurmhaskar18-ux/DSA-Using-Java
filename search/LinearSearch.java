package search;

import java.util.Scanner;

public class LinearSearch {
	
	public static int linearSearch(int[] num, int size, int key) {
		
		for(int i=0;i<size;i++) {
			if(num[i] == key) {
				return i;
			}
		}
		return -1;
	}
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int size;
		int key;
		System.out.println("Enter the array size:");
		size = sc.nextInt();
		
		int[] num = new int[size];
		
		System.out.println("Enter the elements:");
		
		for(int i=0;i<size;i++) {
			num[i]=sc.nextInt();
		}
		
		System.out.println("Enter the elements to be searched(key):");
		key = sc.nextInt();
		
		int result = linearSearch(num, size, key);
		
		if(result!=-1) {
			System.out.println("Element found at index:"+result);
		}else {
			System.out.println("Element not found in the array.");
		}
		
		sc.close();
		
	}

}

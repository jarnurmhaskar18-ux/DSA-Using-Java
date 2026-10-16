package search;

import java.util.Scanner;

public class BinarySearch {
	
	public static int binarySearch(int [] arr, int n, int target) {
		
		int low = 0 ;
		int high = n-1;
		
		while(low<=high) {
			int mid = low + (high - low) / 2;
			if(arr[mid] == target) {
				return mid;
			}
			if(arr[mid] < target) {
				low = mid + 1;
			}else {
				high = mid - 1;
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
		
		int result = binarySearch(num, size, key);
		
		if(result!=-1) {
			System.out.println("Element found at index:"+result);
		}else {
			System.out.println("Element not found in the array.");
		}
		
		sc.close();
		
	}

}

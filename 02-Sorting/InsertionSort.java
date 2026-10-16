package sort;

import java.util.Scanner;

public class InsertionSort {
	
	public static void insertionSort(int[] list) {
		
		int n = list.length;
		for(int key = 1; key < n; key++) {
			int walker = key - 1;
			int hold = list[key];
			while(walker>=0 && hold<list[walker]) {
				list[walker+1] = list[walker];
				walker--;
			}
			
			list[walker+1] = hold;
			System.out.print("\nPass: "+key+ "\t");
			for(int i = 0 ; i< n; i++) {
				System.out.print(list[i]+" ");
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of elements:");
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		System.out.println("Enter "+n+" integers:");
		
		for(int i =0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		
		System.out.println("Unsorted array:");
		for(int value:arr) {
			System.out.println(value+" ");
		}
		insertionSort(arr);
		System.out.println("\nSorted list in assc order:");
		for(int value: arr) {
			System.out.println(value+" ");
		}
	}
}

package sort;

import java.util.Scanner;

public class SelectionSort {
	
	public static void selectionSort(long[] list,int size){
		
		 long temp;
		 int pos;
		 
		 for(int hold = 0; hold<size-1;hold++) {
			 pos = hold;
			 
			 for(int walker = hold+1; walker<size; walker++) {
				 if(list[walker]<list[pos]) {
					 pos=walker;
				 }
			 }
			 
			 if(hold!=pos) {
				 temp=list[pos];
				 list[pos]=list[hold];
				 list[hold]=temp;
			 }
			 
			 System.out.print("\nPass "+(hold+1)+":\t");
			 for(int i=0; i<size;i++) {
				 System.out.print(list[i]+" ");
			 }
		 }
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of elements:");
		int n = sc.nextInt();
		long[] arr = new long[n];
		
		System.out.println("Enter "+n+" integers:");
		
		for(int i =0;i<n;i++) {
			arr[i]=sc.nextLong();
		}   
		
		System.out.println("Unsorted array:");
		for(long value:arr) {
			System.out.println(value+" ");
		}
		selectionSort(arr, n);
		System.out.println("\nSorted list in assc order:");
		for(long value: arr) {
			System.out.println(value+" ");
		}
	}
	
}

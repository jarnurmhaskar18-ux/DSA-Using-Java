package sort;

import java.util.Scanner;

public class ShellSort {
	
	public static void shellSort(long arr[], int n) {
		int pass=1;
		for(int gap=n/2;gap>0;gap/=2) {
			for(int i = gap;i<n;i++) {
				long temp=arr[i];
				int j;
				for(j=i;j>=gap && arr[j-gap]>temp;j-=gap) {
					arr[j]=arr[j-gap];
				}
				arr[j] = temp;
			}
			System.out.print("\nGap:"+gap);
			System.out.print("\n Pass "+ pass +":");
			for(int i=0;i<n;i++) {
				System.out.print(" "+arr[i]);
			}
			pass++;
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
		shellSort(arr, n);
		System.out.println("\nSorted list in assc order:");
		for(long value: arr) {
			System.out.println(value+" ");
		}
	}

}

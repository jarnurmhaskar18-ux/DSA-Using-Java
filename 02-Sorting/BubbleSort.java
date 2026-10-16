package sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BubbleSort {
	
	public static void bubbleSort(long[] list) {
		
		int size = list.length;
		
		for(int hold = 0;hold  < size-1; hold++) {
			
			boolean swapped = false;
			
			for(int walker = 0; walker< size- hold - 1; walker++) {
				
				if(list[walker] > list[walker+1]) {
					
					long temp = list[walker];
					list[walker] = list[walker+1];
					list[walker+1] = temp;
					
					swapped = true;
				}
			}
			
			System.out.println("\n\nPass: "+ ( hold + 1) + "\t");
			
			for(int i =0; i <size; i++) {
				System.out.println(list[i]+" ");
			}
			if (!swapped) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		
		try {
			Scanner sc = new Scanner(new File("num.txt"));
			
			ArrayList<Long> numbers = new ArrayList<Long>();
			
			while(sc.hasNextLong()) {
				numbers.add(sc.nextLong());
			}
			sc.close();
			
			long[] myArray = new long[numbers.size()];
			
			for(int i =0; i < numbers.size(); i++) {
				myArray[i] = numbers.get(i);
			}
			System.out.println("\nUnsorted Array:");
			
			for(long value : myArray) {
				System.out.println(value+ " ");
			}
			
			bubbleSort(myArray);
			
			System.out.println("\n\n Sorted list in ascending order:");
			
			for(long value: myArray) {
				System.out.println(value +" ");
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("Error: num.txt file not found");
		}
		catch(Exception e) {
			System.out.println("Error"+e);
		}
	}
}

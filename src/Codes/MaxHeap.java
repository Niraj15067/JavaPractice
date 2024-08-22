package Codes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxHeap {

	public static void main(String[] args) {
		ArrayList<Integer> heap = new ArrayList<>();
		boolean choice = true;
		Scanner sc = new Scanner(System.in);
		while (choice) {
			System.out.println("Do you want to insert ? ");
			choice = sc.nextBoolean();
			if (!choice) {
				break;
			}
			System.out.println("Enter the value : ");
			int val = sc.nextInt();
			int minVal = insert(val, heap);
			System.out.println(minVal);
		}
		choice = true;
		while (choice) {
			System.out.println("Do you want to remove ? ");
			choice = sc.nextBoolean();
			if (!choice) {
				break;
			}
			int minVal = remove(heap);
			System.out.println(minVal);
		}
		System.out.println(heap);
		sc.close();
	}

	private static int insert(int val, List<Integer> max) {
		max.add(val);
		heapifyUp(max.size() - 1, max);
		return max.get(0);
	}

	private static void heapifyUp(int index, List<Integer> max) {
		int parentIdx = (index-1)/2;
		while(index > 0 && max.get(parentIdx)<max.get(index)) {
			swap(index, parentIdx, max);
		}
	}

	private static void swap(int index, int parentIdx, List<Integer> max) {
		int temp = max.get(index);
		max.set(index, max.get(parentIdx));
		max.set(parentIdx, temp);
	}

	private static int remove(List<Integer> max) {
		
		return -1;
	}
}

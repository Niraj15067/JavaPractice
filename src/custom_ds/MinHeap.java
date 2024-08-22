package custom_ds;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinHeap {

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
			int minVal = insertMinHeap(val, heap);
			System.out.println(minVal);
		}
		choice = true;
		while (choice) {
			System.out.println("Do you want to remove ? ");
			choice = sc.nextBoolean();
			if (!choice) {
				break;
			}
			int minVal = removeMinHeap(heap);
			System.out.println(minVal);
		}
		System.out.println(heap);
		sc.close();

	}

	public static int insertMinHeap(int val, List<Integer> min) {
		int index = min.size();
		min.add(index, val);
		while (index != 0) {
			int parentIndex = (index - 1) / 2;
			int parentVal = min.get(parentIndex);
			int currentVal = min.get(index);
			if (currentVal < parentVal) {
				currentVal += parentVal;
				parentVal = currentVal - parentVal;
				currentVal -= parentVal;
			}
			min.set(index, currentVal);
			min.set(parentIndex, parentVal);
			index = parentIndex;
		}
		return min.get(0);
	}

	public static int removeMinHeap(List<Integer> min) {
		if(min.size()==0) {
			return -1;
		}
		if(min.size()==1) {
			return min.remove(0);
		}
		int removed = min.get(0);
		int last = min.get(min.size() - 1);
		min.set(0, last);
		min.remove(min.size() - 1);
		int idx = 0;
		boolean remove = false;
		while (!remove) {
			int current = min.get(idx);
			int left = idx * 2 + 1;
			int right = idx * 2 + 2;
			int leftVal = (left < min.size()) ? min.get(left) : Integer.MAX_VALUE; // Updated
			int rightVal = (right < min.size()) ? min.get(right) : Integer.MAX_VALUE; // Updated
			if (current > leftVal || current > rightVal) { // Updated
				if (leftVal < rightVal) {
					min.set(idx, leftVal);
					min.set(left, current);
					idx = left;
				} else {
					min.set(idx, rightVal);
					min.set(right, current);
					idx = right;
				}
			} else {
				remove = true;
			}
		}
		return removed;
	}

}

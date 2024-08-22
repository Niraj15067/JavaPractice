package Codes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UnionAndIntersection {

	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 4, 5, 7 };
		int arr2[] = { 2, 3, 5, 6 };

		//two pointer methods for the same.
		List<Integer> union = getUnion(arr1,arr2);
		System.out.println(union);
		List<Integer> intersection = getIntersect(arr1,arr2);
		System.out.println(intersection);
//		TreeSet<Integer> set = new TreeSet<>();
//		for (int i : arr1) {
//			set.add(i);
//		}
//		for (int i : arr2) {
//			set.add(i);
//		}
//		System.out.println(set);
//
//		TreeSet<Integer> intersect = new TreeSet<>();
//		List<Integer> list = new ArrayList<>();
//
//		for (int i : arr1) {
//			intersect.add(i);
//		}
//		for (int i : arr2) {
//			if (intersect.contains(i)) {
//				list.add(i);
//				intersect.remove(i);
//			}
//		}
//		System.out.println(list);
	}

	private static List<Integer> getIntersect(int[] arr1, int[] arr2) {
		ArrayList<Integer> result = new ArrayList<>();
		int i =0,j=0;
		while(i<arr1.length && j<arr2.length) {
			if(arr1[i]>arr2[j]) {
				j++;
			}else if(arr1[i]<arr2[j]) {
				i++;
			}else {
				result.add(arr1[i]);//adding to the list only if they are equal otherwise skipping according to the greater.
				i++;
				j++;
			}
		}
		return result;
	}

	private static List<Integer> getUnion(int[] arr1, int[] arr2) {
		int ptr1 = 0;
		int ptr2 = 0;
		ArrayList<Integer> result = new ArrayList<>();
		while(ptr1<arr1.length &&  ptr2<arr2.length) {
			if(arr1[ptr1]<arr2[ptr2]) {
				result.add(arr1[ptr1]);
				ptr1++;
			}else if(arr1[ptr1]>arr2[ptr2]) {
				result.add(arr2[ptr2]);
				ptr2++;
			}else {
				result.add(arr1[ptr1]);
				ptr1++;
				ptr2++;
			}
				
		}
		while(ptr1<arr1.length) {
			result.add(arr1[ptr1]);
			ptr1++;
		}
		while(ptr2<arr2.length) {
			result.add(arr2[ptr2]);
			ptr2++;
		}
		return result;
	}
}

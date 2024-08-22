package custom_ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
	TreeNode root;

	private class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		public TreeNode(int val) {
			super();
			this.val = val;
		}

		@Override
		public String toString() {
			return "TreeNode [left=" + left + ", right=" + right + ", val=" + val + "]";
		}

	}

	public void constructTree(Scanner sc) {
		System.out.println("Enter the root: ");
		root = new TreeNode(sc.nextInt());
		constructTree(sc, root);
	}

	private void constructTree(Scanner sc, TreeNode node) {

		System.out.println("Do you want to enter the left of node: " + node.val);
		boolean left = sc.nextBoolean();
		if (left) {
			System.out.println("Enter the value for the left of : " + node.val);
			TreeNode l = new TreeNode(sc.nextInt());
			node.left = l;
			constructTree(sc, node.left);
		}
		System.out.println("Do you want to enter the right of node: " + node.val);
		boolean right = sc.nextBoolean();
		if (right) {
			System.out.println("Enter the value for the right of : " + node.val);
			TreeNode r = new TreeNode(sc.nextInt());
			node.right = r;
			constructTree(sc, node.right);
		}
	}

	private void display() {
		display(root, 0);
	}

	private void display(TreeNode node, int level) {

		if (node == null) {
			return;
		}
		display(node.right, level + 1);
		if (level != 0) {
			for (int i = 0; i < level - 1; i++) {
				System.out.print("|\t\t");
			}
			System.out.println("|---------->" + node.val);
		} else {
			System.out.println("|-->" + node.val);
		}

		display(node.left, level + 1);
	}

	private ArrayList<Integer> maximumValue(TreeNode node) {
		ArrayList<Integer> max = new ArrayList<>();
		if (node == null) {
			return max;
		}
		maximumValue(node, max);
		return max;
	}

	private void maximumValue(TreeNode node, ArrayList<Integer> ans) {

		Queue<TreeNode> q = new LinkedList<>();
		q.offer(node);
		while (!q.isEmpty()) {
			int size = q.size(); 
			int max = Integer.MIN_VALUE;

			for (int i = 0; i < size; i++) {
				TreeNode c = q.poll();
				max = Math.max(c.val, max);
				if (c.left != null)
					q.offer(c.left);
				if (c.right != null)
					q.offer(c.right);
			}
			ans.add(max);
		}
	}

	private int maxBinTreeGCD(ArrayList<ArrayList<Integer>> arr, int N) {
		Collections.sort(arr, (l1, l2) -> l1.get(0) - l2.get(0));
		int maxGcd = Integer.MIN_VALUE;
		for (int i = 0; i < N - 1; i++) {
			if(i+1<N-1 && arr.get(i).get(0)==arr.get(i+1).get(0)) {
				maxGcd = Math.max(maxGcd, findGCD(arr.get(i).get(1), arr.get(i+1).get(1)));
			}
		}
		if(maxGcd==Integer.MIN_VALUE)
			return 0;
		return maxGcd;
	}

	private int findGCD(int a, int b) {
		int result = Math.min(a, b);
		while (result > 0) {
			if (a % result == 0 && b % result == 0) {
				break;
			}
			result--;
		}
		return result;
	}

	public static void main(String[] args) {

		BFS bfs = new BFS();
		Scanner sc = new Scanner(System.in);
		bfs.constructTree(sc);
		bfs.display();
		ArrayList<Integer> maximumValue = bfs.maximumValue(bfs.root);
		System.out.println(maximumValue);
//		int maxBinTreeGCD = bfs.maxBinTreeGCD(new ArrayList<ArrayList<Integer>>() {
//			{
//				add(new ArrayList<>(Arrays.asList(1, 8)));
//				add(new ArrayList<>(Arrays.asList(1, 16)));
//				add(new ArrayList<>(Arrays.asList(16, 21)));
//				add(new ArrayList<>(Arrays.asList(8, 9)));
//				add(new ArrayList<>(Arrays.asList(9, 18)));
//				add(new ArrayList<>(Arrays.asList(8, 18)));
//				add(new ArrayList<>(Arrays.asList(16, 42)));
//			}
//		}, 8);
//		System.out.println(maxBinTreeGCD);
	}
}

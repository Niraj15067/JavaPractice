package custom_ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class DFS {

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

	// height of a binary tree.
	private int height() {
		return height(root);
	}

	// we need post order as we have to add up above after processing the below
	// nodes.
	private int height(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int left = height(node.left);
		int right = height(node.right);

		int height = Math.max(left, right) + 1;

		return height;
	}

	public List<List<Integer>> allPathSum(int target) {
		List<List<Integer>> ans = new ArrayList<>();
		allPathSum1(ans, target, new ArrayList<>(), root);
		return ans;
	}

	private void allPathSum(List<List<Integer>> result, int target, List<Integer> currentPath, TreeNode node) {
		if (node == null) {
			return;
		}

		// Add the current node's value to the current path
		currentPath.add(node.val);

		// Check if the current node is a leaf and if the target sum is reached
		if (node.left == null && node.right == null && target == node.val) {
			// If yes, add the current path to the result list
			result.add(new ArrayList<>(currentPath));
		} else {
			// If not a leaf, recursively search the left and right subtrees
			allPathSum(result, target - node.val, currentPath, node.left);
			allPathSum(result, target - node.val, currentPath, node.right);
		}

		// Backtrack: Remove the current node's value from the current path
		currentPath.remove(currentPath.size() - 1);
	}

	// where sum might lie in the underlying paths not necessarily from the root to
	// the leaf.
	private void allPathSum1(List<List<Integer>> result, int target, List<Integer> currentPath, TreeNode node) {
		if (node == null) {
			return;
		}
		currentPath.add(node.val);
		int sum = 0;
		for (int i = currentPath.size() - 1; i >= 0; i--) {
			sum += currentPath.get(i);
			if (sum == target) {
				result.add(new ArrayList<>(currentPath.subList(i, currentPath.size())));
				break;
			}
		}

		allPathSum1(result, target, currentPath, node.left);
		allPathSum1(result, target, currentPath, node.right);

		currentPath.remove(currentPath.size() - 1);
	}

	// morris inorder traversal
	public ArrayList<Integer> morrisInorderTraversal(TreeNode node) {
		ArrayList<Integer> ans = new ArrayList<>();
		TreeNode current, pre;
		current = node;
		while (current != null) {
			if (current.left == null) {
				ans.add(current.val);
				current = current.right;
			} else {
				pre = current.left;
				while (pre.right != null && pre.right != current) {
					pre = pre.right;
				}
				if (pre.right == null) {
					pre.right = current;
					current = current.left;
				} else {
					pre.right = null;
					ans.add(current.val);
					current = current.right;
				}
			}
		}

		return ans;
	}

	public ArrayList<Integer> morrispreorderTraversal(TreeNode node) {

		ArrayList<Integer> ans = new ArrayList<>();
		TreeNode current, pre;
		current = node;
		while (current != null) {
			if (current.left == null) {
				ans.add(current.val);
				current = current.right;
			} else {
				pre = current.left;
				while (pre.right != null && pre.right != current) {
					pre = pre.right;
				}
				if (pre.right == null) {
					pre.right = current;
					ans.add(current.val);
					current = current.left;
				} else {
					pre.right = null;
					current = current.right;
				}
			}
		}
		return ans;
	}

	public ArrayList<Integer> morrispostorderTraversal(TreeNode node) {

		ArrayList<Integer> res = new ArrayList<>();
		TreeNode current = root;

		while (current != null) {
			if (current.right == null) {
				res.add(current.val);
				current = current.left;
			} else {
				TreeNode pre = current.right;
				while (pre.left != null && pre.left != current) {
					pre = pre.left;
				}
				if (pre.left == null) {
					pre.left = current;
					res.add(current.val);
					current = current.right;
				} else {
					pre.left = null;
					current = current.left;
				}
			}
		}
		// reverse the res
		Collections.reverse(res);
		return res;
	}

	public boolean isSubtree(TreeNode T, TreeNode S) {
		if (T == null) {
			return false;
		}
		if (S == null) {
			return true;
		}
		if (traverse(T, S)) {
			return true;
		}
		return isSubtree(T.left, S) || isSubtree(T.right, S);
	}

	private boolean traverse(TreeNode t, TreeNode s) {

		if (t == null && s == null) {
			return true;
		}
		if (t == null || s == null) {
			return false;
		}
		if (t.val != s.val) {
			return false;
		}

		boolean left = traverse(t.left, s.left);
		boolean right = traverse(t.right, t.right);
		return left && right;
	}

	public int rangeSumBST(TreeNode root, int low, int high) {
		if (root == null)
			return 0;

		List<Integer> inorder = new ArrayList<>();
		inOrder(inorder, root);
		int left = -1, sum = 0, right = -1;
		for (int i = 0; i < inorder.size(); i++) {
			if (inorder.get(i) == low) {
				left = i;
			}
			if (inorder.get(i) == high) {
				right = i;
			}
		}
		for (int i = left; i <= right; i++) {
			sum += inorder.get(i);
		}
		return sum;
	}

	private void inOrder(List<Integer> inorder, TreeNode node) {
		if (node == null) {
			return;
		}
		inOrder(inorder, node.left);
		inorder.add(node.val);
		inOrder(inorder, node.right);
	}

	// range sum using stack for inorder traversal
	private int rangeSumBST1(TreeNode node, int low, int high) {
		if (node == null) {
			return 0;
		}
		Stack<TreeNode> stack = new Stack<>();
		int sum = 0;
		while (!stack.isEmpty() || node != null) {

			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			TreeNode current = stack.pop();
			if (current.val >= low && current.val <= high) {
				sum += current.val;
			}
			node = current.right;
		}
		return sum;
	}

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> a = new ArrayList<>();
		List<Integer> b = new ArrayList<>();
		
		build(a,root1);
		build(b,root2);
		
		if(a.size()!=b.size())
			return false;
		int j=0;
		for(int i : a) {
			if(i!=b.get(j++)) {
				return false;
			}
		}
		return true;
	}

	private void build(List<Integer> a, TreeNode node) {
		if(node == null) {
			return;
		}
		if(node.left==null && node.right==null) {
			a.add(node.val);
			return;
		}
		build(a,node.left);
		build(a, node.right);
	}

	public static void main(String[] args) {

		DFS dfs = new DFS();
		dfs.constructTree(new Scanner(System.in));
		
		DFS dfs1 = new DFS();
		dfs1.constructTree(new Scanner(System.in));
		
		boolean leafSimilar = dfs.leafSimilar(dfs.root, dfs1.root);
		System.out.println(leafSimilar);

//		DFS dfs1 = new DFS();
//		dfs1.constructTree(new Scanner(System.in));
//
//		boolean ans = dfs1.isSubtree(dfs.root, dfs1.root);
//		System.out.println(ans);

//		int inOrderUsingStack = dfs.inOrderUsingStack(dfs.root, 7, 15);
//		int rangeSumBST = dfs.rangeSumBST(dfs.root, 7, 15);
//		System.out.println(rangeSumBST);

//		ArrayList<Integer> morrisInorderTraversal = dfs.morrisInorderTraversal(dfs.root);
//		ArrayList<Integer> morrispreorderTraversal = dfs.morrispreorderTraversal(dfs.root);
//		ArrayList<Integer> morrispostorderTraversal = dfs.morrispostorderTraversal(dfs.root);
//		System.out.println(morrisInorderTraversal);
//		System.out.println(morrispreorderTraversal);
//		System.out.println(morrispostorderTraversal);

//		List<List<Integer>> allPathSum = dfs.allPathSum(7);
//		System.out.println(allPathSum);
//		
//		System.out.println("height of the tree is : "+ dfs.height());
	}
}

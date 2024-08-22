package custom_ds;

public class BST {

	Node root;

	private class Node {
		int val;
		Node left;
		Node right;
		int height;

		Node(int val) {
			this.val = val;
		}
	}

	public void display() {
		display(root, "Root node: ");
		prettyDisplay(root, 0);
	}
	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(Node node) {
		if(node==null) {
			return;
		}
		System.out.print(node.val+" ");
		preOrder(node.left);
		preOrder(node.right);
	}
	public void inOrder() {
		inOrder(root);
	}
	private void inOrder(Node node) {
		if(node==null) {
			return;
		}
		preOrder(node.left);
		System.out.print(node.val+" ");
		preOrder(node.right);
	}
	
	public void postOrder() {
		postOrder(root);
	}
	private void postOrder(Node node) {
		if(node==null) {
			return;
		}
		preOrder(node.left);
		System.out.print(node.val);
		System.out.print(node.val+" ");
	}
	private void display(Node node, String details) {
		 if (node == null) {
		      return;
		    }
		    System.out.println(details + node.val);
		    display(node.left, "Left child of " + node.val + " : ");
		    display(node.right, "Right child of " + node.val + " : ");
	}

	public void insert(int val) {
		root = insert(val, root);
	}

	private Node insert(int val, Node node) {
		if (node == null) {
			node = new Node(val);
			return node;
		}
		if (val < node.val) {
			node.left = insert(val, node.left);
		}
		if (val > node.val) {
			node.right = insert(val, node.right);
		}
		return node;
	}

	public void populate(int[] arr) {
		populate(arr, 0, arr.length);
	}

	private void populate(int[] arr, int start, int end) {

		if (start >= end) {
			return;
		}

		int mid = (start + end) / 2;
		insert(arr[mid]);
		populate(arr, start, mid);
		populate(arr, mid + 1, end);
	}
	private void prettyDisplay(Node node, int level) {
	    if (node == null) {
	      return;
	    }

	    prettyDisplay(node.right, level + 1);

	    if (level != 0) {
	      for (int i = 0; i < level - 1; i++) {
	        System.out.print("|\t\t");
	      }
	      System.out.println("|------->" + node.val);
	    } else {
	      System.out.println(node.val);
	    }
	    prettyDisplay(node.left, level + 1);
	  }
}

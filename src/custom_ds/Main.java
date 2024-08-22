package custom_ds;

public class Main {

	public static void main(String[] args) {
		BST bst = new BST();
		int[] arr = {1,2,3,4,5,6,7,8,9,101,11,};
		bst.populate(arr);
		bst.display();
	}
}

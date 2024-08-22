package codesss;

public class MiddleOf3 {

	public static void main(String[] args) {
		int a = 20, b = 20, c = 8;
		int middle = a>b?(b<c?c:b):b<c?b:c;
		System.out.println(middle);
	}

}

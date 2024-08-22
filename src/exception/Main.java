package exception;

public class Main {

	public static void main(String[] args) {
		String name = "niraj";
		try {
			if(name.equals("niraj")){
				throw new MyException("Names are same");
			}
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}

	}

}

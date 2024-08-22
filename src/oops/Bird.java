package oops;

public class Bird implements Animal {

	@Override
	public void eat() {
		System.out.println("Bird eats insects.");

	}

	@Override
	public void sleep() {
		System.out.println("Bird is sleeping");

	}

	String region;

	public void sleep(Integer hours) {
		System.out.println("the bird has been Integer sleeping since: " + hours);
	}

	public void sleep(int hours) {
		System.out.println("the bird has been int sleeping since: " + hours);
	}

	public void sleep(byte hours) {
		System.out.println("the bird has been byte sleeping since: " + hours);
	}

	public void sleep(short hours) {
		System.out.println("the bird has been short sleeping since: " + hours);
	}

	public void sleep(long hours) {
		System.out.println("the bird has been long sleeping since: " + hours);
	}

	@Override
	public void sound() {
		System.out.println("Bird Chirps");

	}

}

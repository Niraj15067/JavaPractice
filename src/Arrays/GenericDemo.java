package Arrays;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo<T> {

	private T data;

	public GenericDemo(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public static void main(String[] args) {
		GenericDemo<Integer> a = new GenericDemo<Integer>(10);
		System.out.println(a.getData());
		GenericDemo<String> b = new GenericDemo<String>("Niraj");
		System.out.println(b.getData());
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		GenericDemo<List<Integer>> c = new GenericDemo<>(list);
		System.out.println(c);
	}

	@Override
	public String toString() {
		return "GenericDemo [data=" + data + "]";
	}
	
}

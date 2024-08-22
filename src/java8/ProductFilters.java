package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProductFilters {

	public static void main(String[] args) {
		List<Product> products = Arrays.asList(new Product(1, "Product A", 10.99), new Product(2, "Product B", 9.99),
				new Product(3, "Product C", 12.99), new Product(4, "Product D", 8.99));

		List<Custom> customers = Arrays.asList(new Custom(1, "John Doe", "john@doe.com"),
				new Custom(2, "Bob Smith", "john@example.com"), new Custom(3, "Natsu Dragneel", "nalu@example.com"),
				new Custom(4, "John Wick", "john@wick.com"), new Custom(5, "Lucy Heartfilia", "lucy@dragneel.com"));

		List<Order> orders = Arrays.asList(
				new Order(1, customers.get(0), Arrays.asList(products.get(0), products.get(1))),
				new Order(2, customers.get(1), Arrays.asList(products.get(1), products.get(1))),
				new Order(3, customers.get(1), Arrays.asList(products.get(0), products.get(1))),
				new Order(4, customers.get(2), Arrays.asList(products.get(0), products.get(1))));
		Custom key = orders.stream().collect(Collectors.groupingBy(x -> x.getCustomer(), Collectors.counting()))
				.entrySet().stream().max((a, b) -> Long.compare(a.getValue(), b.getValue())).map(Map.Entry::getKey)
				.orElse(null);
		System.out.println("Customer with the most orders is : " + key);

		// correct
		Custom result = orders.stream().collect(Collectors.groupingBy(Order::getCustomer, Collectors.counting()))
				.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
		System.out.println("Customer with the most orders is : " + result);
		System.out.println("=================================================");
		// get list of products that has been ordered by more than one customers.

//		Map<String, Long> collect = orders.stream()
//				.flatMap(x -> x.getProducts().stream().map(p -> new PC(p, x.getCustomer())))
//				.collect(Collectors.groupingBy(x -> x.getProduct().getName() + "--" + x.getCustomer().getName(),
//						Collectors.counting()));

		Map<String, Integer> collect = orders.stream()
				.flatMap(x -> x.getProducts().stream().map(p -> new PC(p, x.getCustomer())))
				.collect(Collectors.groupingBy(pc -> pc.getProduct().getName(),
						Collectors.mapping(pc -> pc.getCustomer().getName(), Collectors.toSet())))
				.entrySet().stream().collect(Collectors.filtering(x -> x.getValue().size() > 1,
						Collectors.toMap(Map.Entry::getKey, e -> e.getValue().size())));

		Map<String, Set<String>> collect2 = orders.stream()
				.flatMap(o -> o.getProducts().stream().map(x -> new PC(x, o.getCustomer())))
				.collect(Collectors.groupingBy(x -> x.getProduct().getName(),
						Collectors.mapping(x -> x.getCustomer().getName(), Collectors.toSet())))
				.entrySet().stream().collect(Collectors.filtering(x -> x.getValue().size() > 1,
						Collectors.toMap(x -> x.getKey(), x -> x.getValue())));

		Map<String, Integer> collect3 = orders.stream()
				.flatMap(x -> x.getProducts().stream().map(a -> new PC(a, x.getCustomer())))
				.collect(Collectors.groupingBy(pc -> pc.getProduct().getName(),
						Collectors.mapping(x -> x.getCustomer().getName(), Collectors.toSet())))
				.entrySet().stream().collect(Collectors.filtering(x -> x.getValue().size() > 1,
						Collectors.toMap(x -> x.getKey(), x -> x.getValue().size())));

		for (Entry<String, Set<String>> entry : collect2.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		System.out.println("=================================================");
		// Calculate the average order value for each customer.
		Map<String, Double> collect4 = orders.stream()
				.flatMap(x -> x.getProducts().stream().map(a -> new PC(a, x.getCustomer())))
				.collect(Collectors.groupingBy(x -> x.getCustomer().getName(),
						Collectors.averagingDouble(x -> x.getProduct().getPrice())));

		System.out.println("Average order value for each customer");
		for (Entry<String, Double> entry : collect4.entrySet()) {
			System.out.println(entry.getKey() + "--" + entry.getValue());

		}
		System.out.println("=================================================");
		// another more efficient way to calculate avg order value for each customer.
		Map<String, Double> collect5 = orders.stream().collect(Collectors.groupingBy(x -> x.getCustomer().getName(),
				Collectors.flatMapping(x -> x.getProducts().stream(), Collectors.averagingDouble(x -> x.getPrice()))));

		for (Entry<String, Double> entry : collect5.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}

		Map<String, Integer> collect6 = orders.stream()
				.flatMap(x -> x.getProducts().stream().map(a -> Map.entry(a.getName(), x.getCustomer().getName())))
				.collect(Collectors.collectingAndThen(
						Collectors.groupingBy(Map.Entry::getKey,
								Collectors.mapping(Map.Entry::getValue, Collectors.toSet())),
						map -> map.entrySet().stream().filter(x -> x.getValue().size() > 1)
								.collect(Collectors.toMap(Map.Entry::getKey, x -> x.getValue().size()))));

		for (Entry<String, Integer> entry : collect6.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		int[] arr = { 1, 2, 3, 4, 4, 5, 5, 65, 6, 5 };
//		List<Integer> list = Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new));
		List<Integer> list2 = Arrays.stream(arr).boxed().toList();
		System.out.println(list2);
		Map<Product, Long> collect7 = orders.stream().collect(Collectors.flatMapping(x -> x.getProducts().stream(),
				Collectors.groupingBy(Function.identity(), Collectors.counting())));
		System.out.println("Count of products ordered times");
		for (Entry<Product, Long> entry : collect7.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
		

	}
}

class PC {

	private Product product;
	private Custom customer;

	public PC(Product product, Custom customer) {
		super();
		this.product = product;
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "PC [product=" + product + ", customer=" + customer + "]";
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Custom getCustomer() {
		return customer;
	}

	public void setCustomer(Custom customer) {
		this.customer = customer;
	}

}

class Product {
	private int id;
	private String name;
	private double price;

	public Product(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}

class Order {
	private int id;
	private Custom customer;
	private List<Product> products;

	public Order(int id, Custom customer, List<Product> products) {
		this.id = id;
		this.customer = customer;
		this.products = products;
	}

	public int getId() {
		return id;
	}

	public Custom getCustomer() {
		return customer;
	}

	public List<Product> getProducts() {
		return products;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + ", products=" + products + "]";
	}

}

class Custom {
	private int id;
	private String name;
	private String email;

	public Custom(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Custom [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

}

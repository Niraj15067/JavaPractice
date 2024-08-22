package task;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class CollectorImplement implements Collector<Cheque, IntermidiateState, Double> {

	@Override
	public Supplier<IntermidiateState> supplier() {
		// TODO Auto-generated method stub
		return () -> {
			return new IntermidiateState();
		};
	}

	@Override
	public BiConsumer<IntermidiateState, Cheque> accumulator() {
		// TODO Auto-generated method stub
		return new BiConsumer<IntermidiateState, Cheque>() {

			@Override
			public void accept(IntermidiateState a, Cheque t) {
				a.add(t.amount);;
			}
		
		};
	}

	@Override
	public BinaryOperator<IntermidiateState> combiner() {
		// TODO Auto-generated method stub
		return new BinaryOperator<IntermidiateState>() {

			@Override
			public IntermidiateState apply(IntermidiateState t, IntermidiateState u) {
				t.add(u.getAmount());
				return t;
			}
		};
	}

	@Override
	public Function<IntermidiateState, Double> finisher() {
		// TODO Auto-generated method stub
		return new Function<IntermidiateState, Double>() {

			@Override
			public Double apply(IntermidiateState t) {

				return t.getAmount();
			}
		};
	}

	@Override
	public Set<Characteristics> characteristics() {
		// TODO Auto-generated method stub
		HashSet<Characteristics> h = new HashSet<>();
		h.add(Characteristics.UNORDERED);
		h.add(Characteristics.CONCURRENT);

		return h;
	}


}


class IntermidiateState{
	
	Double amount;

	public IntermidiateState()
	{
		amount=Double.valueOf(0);
	}	
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public void add(Double newValue) {
		amount=amount+newValue;
	}
	
}

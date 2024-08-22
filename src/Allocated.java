
public class Allocated {

	Measure m;
	IntRange range;

}

class Measure {
	public enum Type {
		CONSTANT, VARIABLE
	}

	private Type type;

	private int value;

	private int estimatedValue;

	private int computedValue;

	private IntRange range;

	private String unit;

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getEstimatedValue() {
		return estimatedValue;
	}

	public void setEstimatedValue(int estimatedValue) {
		this.estimatedValue = estimatedValue;
	}

	public int getComputedValue() {
		return computedValue;
	}

	public void setComputedValue(int computedValue) {
		this.computedValue = computedValue;
	}

	public IntRange getRange() {
		return range;
	}

	public void setRange(IntRange range) {
		this.range = range;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}

class IntRange {
	private int min;
	private int max;

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	// Constructors, getters, and setters
}
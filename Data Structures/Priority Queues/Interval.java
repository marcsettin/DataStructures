
public class Interval {
	private double start;	// start point of the interval.
	private double end;	// end point of the interval.
	private double length; // This is the field in which the priority queue will be keyed.
	private static final double error = 1e-09; // Error in the comparison function.

	/**
		Constructor: arguments s and e are the start and end points of the interval resp.
		Assumes that end > start.
	*/
	public Interval(double s, double e) {
		start = s;
		end = e;
		length = end - start;
	}

	/**
		Accessor method to access the start point of the interval.
	*/
	public double getStart() {
		return start;
	}

	/**
		Accessor method to access the end point of the interval.
	*/
	public double getEnd() {
		return end;
	}

	/**
		Accessor method to access the length of the interval.
	*/
	public double getLength() {
		return length;
	}

	/**
		Comparison method to compare two intervals.
		Comparison is based on length first, then start point, and error is the amount of error allowed in comparing doubles (floating point values).
	*/
	public int compareTo(Interval r) {
		double diff = length - r.length;
		if (Math.abs(diff) < error) {
			diff = start - r.start;
			if (Math.abs(diff) < error) {
				return 0;
			}
		}
		return (int) (diff / error);
	}

	/**
		Method to return the string representation of the interval.
	*/
	public String toString() {
		return "Interval: start = " + start + " end = " + end + " length = " + length + ".";
	}
}

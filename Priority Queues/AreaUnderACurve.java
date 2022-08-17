import java.util.Scanner;

public class AreaUnderACurve {

	private static double f(double x) {
		return x * x + x + 1; 
	}

	private static double computeArea(double a, double b) {
		double error = 1e-08; // This is the comparison error. See document for description.

		PriorityQueue P = new PriorityQueue(100);
		double prevArea = (b - a) * f(b);
		P.insert(new Interval(a, b));

		do {
			Interval x = P.remove_max();
			double x1 = x.getStart();
			double x2 = x.getEnd();
			double fx1 = f(x1);
			double fx2 = f(x2);
			double m = (x1 + x2) / 2.0;
			double fm = f(m);

			double newArea = prevArea - ((x2 - x1) * fx2) + ((m - x1) * f(m)) + ((x2 - m) * f(x2));
			if (Math.abs(newArea - prevArea) < error)
				return newArea;
			P.insert(new Interval(x1, m));
			P.insert(new Interval(m, x2));
			prevArea = newArea;
		} while(true);
	}

	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("We have the function f(x) = x^2 + x + 1.");
		System.out.print("Please enter lower value a: ");
		double a = kb.nextDouble();
		System.out.print("Please enter upper value b: ");
		double b = kb.nextDouble();

		double area = computeArea(a, b);
		System.out.println("\nAn approximation for the area under the curve f(x) \nbetween a = " + a + " and b = " + b + " is " + area);
	}
}

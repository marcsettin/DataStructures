import java.util.Random;

public class IntSetDriver {
	
	public static void main(String [] srgs) {
		Random rand = new Random(1);
		
		final int n = 100;
		int [] a = new int[n];
		
		// Get random input between 0 and n-1
		a[0] = 0;
		for (int i = 1; i < n; i++) {
			int j = rand.nextInt(i);
			a[i] = a[j];
			a[j] = i;
		}
		
		IntSet s = new IntSet();
		
		// Do a bunch of inserts.
		int i;
		for (i = 0; i < n/2; i++) {
			System.out.println("Inserting: " + a[i]);
			s.insert(a[i]);
		}
		s.print();
		
		// Do a bunch of removes.
		for (int j = 0; j < 10; j++) {
			System.out.println("removing: " + a[j]);
			s.remove(a[j]);
		}
		s.print();
		
		// Do a bunch of inserts again.
		for (; i < n; i++) {
			System.out.println("Inserting: " + a[i]);
			s.insert(a[i]);
		}
		s.print();
	}
}

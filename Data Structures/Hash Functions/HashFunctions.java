import java.util.Random;

public class HashFunctions {

	private int C;		// The largest possible key that can be hashed.
	private int size;	// The size of the hash table.
	Random rand;

	public HashFunctions(int s) {
		C = s * s;
		size = s;
		rand = new Random();
	}

	public int hash1(int k) {
		return k % size;
	}

	public int hash2(int k) {
		return (int) (k * ((double) size / C));
	}

	public int hash3(int k) {
		return (int) (((2971L * k + 101923L) % 128189L)  % (long) size);
	}

	public int hash4(int k) {
		rand.setSeed(k);
		return rand.nextInt(size);
	}
}

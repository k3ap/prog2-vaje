package vaje1;

public class RazcepNaPrafaktorje {
	
	private static int[] mreza;
	private static final int M = 6000000;
	
	public static void resetiraj() {
		for (int i = 2; i < Math.sqrt(M); i++) {
			if (mreza[i] == 0) {
				for (int j = 2*i; j < M; j += i) {
					if (mreza[j] == 0) 
						mreza[j] = i;
				}
			}
		}
	}
	
	public static int delitelj(int num) {
		if (mreza[num] == 0) {
			return num;
		} else {
			return mreza[num];
		}
	}
	
	public static void izpisiDelitelje(int num) {
		int prev = 0;
		int np = 0;
		while (num > 1) {
			int d = delitelj(num);
			if (d == prev) {
				np++;
			} else {
				if (prev != 0) {
					if (np == 1)
						System.out.format("%d ", prev);
					else
						System.out.format("%d^%d ", prev, np);
				}
				prev = d;
				np = 1;
			}
			num /= d;
		}
		System.out.format("%d^%d\n", prev, np);
	}

	public static void main(String[] args) {
		mreza = new int[M];
		resetiraj();
		izpisiDelitelje(5761665);
	}

}

package vaje1;

public class OdvodPolinoma {
	
	public static int[] odvod(int[] koeficienti, int n) {
		while (n-- > 0) {
			koeficienti = odvod(koeficienti);
		}
		return koeficienti;
	}
	
	public static int[] odvod(int[] koeficienti) {
		int[] k2 = new int[koeficienti.length - 1];
		for (int i = 1; i < koeficienti.length; i++) {
			k2[i-1] = i * koeficienti[i];
		}
		return k2;
	}
	
	public static void izpisi(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.format("%d ", a[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		izpisi( odvod(new int[] {1, 2, 3}) );
		izpisi( odvod(new int[] {4, -1, 2, 0, 1}, 2) );
		izpisi( odvod(new int[] {1}) );
	}

}

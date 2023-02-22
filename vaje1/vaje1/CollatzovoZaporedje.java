package vaje1;

public class CollatzovoZaporedje {
	
	public static int naslednji(int num) {
		if (num % 2 == 0) {
			return num / 2;
		} else {
			return 3*num+1;
		}
	}
	
	public static int dolzinaZaporedja(int num) {
		int l = 1;
		while (num > 1) {
			num = naslednji(num);
			l++;
		}
		return l;
	}
	
	public static int najvecjiClen(int num) {
		int m = num;
		while (num > 1) {
			num = naslednji(num);
			m = Math.max(m, num);
		}
		return m;
	}
	
	public static void izpisiZaporedje(int num) {
		while (num > 1) {
			System.out.format("%d ", num);
			num = naslednji(num);
		}
		System.out.println("1");
	}

	public static void main(String[] args) {
		final int start = 6; 
		System.out.format("Dolzina za %d: %d\n", start, dolzinaZaporedja(start));
		System.out.format("Najvecji za %d: %d\n", start, najvecjiClen(start));
		izpisiZaporedje(start);
	}

}

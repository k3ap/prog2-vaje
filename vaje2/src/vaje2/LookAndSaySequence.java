package vaje2;

public class LookAndSaySequence {
	
	public static String next(String s) {
		String res = "";
		char prev = '\0';
		int cnt = 0;
		for (char ch : s.toCharArray()) {
			if (ch == prev) {
				cnt++;
			} else {
				if (prev != '\0') {
					res += Integer.toString(cnt) + prev;
				}
				prev = ch;
				cnt = 1;
			}
		}
		if (cnt > 0) {
			res += Integer.toString(cnt) + prev;
		}
		return res;
	}
	
	public static String[] prvih_n(String zacetek, int n) {
		String[] res = new String[n];
		for (int i = 0; i < n; i++) {
			res[i] = zacetek;
			zacetek = next(zacetek);
		}
		return res;
	}

	public static void main(String[] args) {
		String[] tabela = prvih_n("1", 10);
		for (int i = 0; i < tabela.length; i++) {
			System.out.println(tabela[i]);
		}
	}

}

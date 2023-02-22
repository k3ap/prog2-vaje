package vaje1;

public class PoudarjanjeZnakov {
	
	public static String senzacija(String s) {
		s = s.toUpperCase();
		String s2 = s.substring(0, 1);
		for (int i = 1; i < s.length(); i++) {
			s2 += " " + s.substring(i, i+1);
		}
		return s2;
	}
	
	public static String zvezdice(String s) {
		boolean poudarjeno = false;
		String out = "";
		for (char ch : s.toCharArray()) {
			if (ch == '*') {
				poudarjeno = !poudarjeno;
			} else if (poudarjeno) {
				out += String.format("%c", ch).toUpperCase();
			} else {
				out += String.format("%c", ch);
			}
		}
		return out;
	}

	public static void main(String[] args) {
		System.out.println(senzacija("zadnja novica"));
		System.out.println(zvezdice("Zadnja *novica* danes"));
	}

}

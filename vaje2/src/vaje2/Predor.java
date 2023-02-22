package vaje2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class Vozilo {
	private int s, t;
	public final String r;
	
	public Vozilo(String ln) {
		String[] arr = ln.split(" ");
		s = Integer.parseInt(arr[0]);
		t = Integer.parseInt(arr[1]);
		r = arr[2];
	}
	
	public boolean obravnavaj(double dolzina, double omejitev) {
		return hitrost(dolzina) > omejitev;
	}
	
	public double hitrost(double dolzina) {
		return dolzina / (double) (t-s);
	}
}

public class Predor {
	
	public static final double DOLZINA = 622;  // m
	public static final double OMEJITEV = 22.22222;  // m/s
	
	public static int poisciKriminalce(String inname, String outname) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(inname));
		FileWriter writer = new FileWriter(outname);
		String ln;
		int cnt = 0;
		double m = 0;
		while ((ln = reader.readLine()) != null) {
			Vozilo v = new Vozilo(ln);
			if (v.obravnavaj(DOLZINA, OMEJITEV)) {
				cnt++;
				writer.write(v.r + "\n");
			}
			if (v.hitrost(DOLZINA) > m) {
				m = v.hitrost(DOLZINA);
			}
		}
		reader.close();
		writer.close();
		System.out.format("Rekorder: %f km/h\n", m * 3.6);
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		System.out.println(poisciKriminalce("podatki.txt", "prestopniki.txt"));
	}

}

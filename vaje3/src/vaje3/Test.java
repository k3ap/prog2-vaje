package vaje3;

import java.io.FileWriter;
import java.io.IOException;

public class Test {
	public static void main(String[] args) throws IOException {
		System.out.println("CIKEL");
		Graf cikel = Graf.cikel(7);
		cikel.izpis();
		
		System.out.println("POLN");
		Graf poln = Graf.poln(3);
		poln.izpis();
		
		Graf prazen = Graf.prazen(10);
		System.out.format("Število komponent praznega grafa: %d\n", prazen.steviloKomponent());
		System.out.format("Število komponent cikla: %d\n", cikel.steviloKomponent());
		
		FileWriter writer = new FileWriter("poln.graf");
		poln.shraniVDatoteko(writer);
		writer.close();
		
		cikel.razporedi(250, 250, 200);
		Okno okno = new Okno();
		okno.platno.nastaviGraf(cikel);
		okno.pack();
		okno.setVisible(true);
	}
}

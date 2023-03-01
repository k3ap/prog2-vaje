package vaje3;

public class Test {
	public static void main(String[] args) {
		System.out.println("CIKEL");
		Graf cikel = Graf.cikel(7);
		cikel.izpis();
		
		System.out.println("POLN");
		Graf poln = Graf.poln(3);
		poln.izpis();
		
		Graf prazen = Graf.prazen(10);
		System.out.format("Število komponent praznega grafa: %d\n", prazen.steviloKomponent());
		System.out.format("Število komponent cikla: %d\n", cikel.steviloKomponent());
	}
}

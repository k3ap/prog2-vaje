package vaje3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graf {
	private int stevecZaImenovanje;
	
	protected Map<String, Tocka> tocke;
	
	public Graf() {
		stevecZaImenovanje = 0;
		tocke = new HashMap<String, Tocka>();
	}
	
	public Tocka tocka(String ime) {
		if (tocke.containsKey(ime)) {
			return tocke.get(ime);
		} else {
			return null;
		}
	}
	
	public boolean povezava(String ime1, String ime2) {
		Tocka t1 = tocka(ime1);
		Tocka t2 = tocka(ime2);
		if (t1 == null || t2 == null) {
			return false;
		} else {
			return t1.jeSosed(t2);
		}
	}
	
	public Tocka dodajTocko(String ime) {
		Tocka t = tocka(ime);
		if (t != null) return t;
		t = new Tocka(new InformacijeOTocki(ime));
		tocke.put(ime, t);
		return t;
	}
	
	public Tocka dodajTocko() {
		String ime = String.format("t-%d", stevecZaImenovanje++); 
		Tocka t = new Tocka(new InformacijeOTocki(ime));
		tocke.put(ime, t);
		return t;
	}
	
	public void dodajPovezavo(String ime1, String ime2) {
		Tocka t1 = tocka(ime1);
		Tocka t2 = tocka(ime2);
		if (t1.equals(t2)) return;
		t1.dodajSoseda(t2);
		t2.dodajSoseda(t1);
	}
	
	public void odstraniPovezavo(String ime1, String ime2) {
		Tocka t1 = tocka(ime1);
		Tocka t2 = tocka(ime2);
		t1.odstraniSoseda(t2);
		t2.odstraniSoseda(t1);
	}
	
	public void odstraniTocko(String ime) {
		Tocka t = tocka(ime);
		for (Tocka sosed : t.sosedi) {
			sosed.odstraniSoseda(t);
		}
		tocke.remove(ime);
	}
	
	private List<Tocka> dodajTocke(int n) {
		ArrayList<Tocka> seznam = new ArrayList<Tocka>();
		while (n-->0) {
			seznam.add(dodajTocko());
		}
		return seznam;
	}
	
	public static Graf prazen(int n) {
		Graf g = new Graf();
		g.dodajTocke(n);
		return g;
	}
	
	public static Graf cikel(int n) {
		Graf g = new Graf();
		List<Tocka> tocke = g.dodajTocke(n);
		for (int i = 0; i < tocke.size() - 1; i++) {
			Tocka t = tocke.get(i);
			Tocka tn = tocke.get(i+1);
			g.dodajPovezavo(t.ime(), tn.ime());
		}
		g.dodajPovezavo(tocke.get(0).ime(), tocke.get(tocke.size()-1).ime());
		return g;
	}
	
	public static Graf poln(int n) {
		Graf g = new Graf();
		List<Tocka> tocke = g.dodajTocke(n);
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				g.dodajPovezavo(tocke.get(i).ime(), tocke.get(j).ime());
			}
		}
		return g;
	}
	
	public static Graf polnDvodelen(int n, int m) {
		Graf g = new Graf();
		List<Tocka> tocke = g.dodajTocke(n+m);
		for (int i = 0; i < n; i++) {
			for (int j = n; j < n+m; j++) {
				g.dodajPovezavo(tocke.get(i).ime(), tocke.get(j).ime());
			}
		}
		return g;
	}
	
	public void izpis() {
		System.out.print("Vozlišča: ");
		for (String ime : tocke.keySet()) {
			System.out.print(ime);
			System.out.print(" ");
		}
		System.out.println();
		for (Tocka t : tocke.values()) {
			t.izpisiPovezave();
		}
	}
	
	public int steviloKomponent() {
		DFSKomponente dfs = new DFSKomponente(this);
		return dfs.prestejKomponente();
	}
	
	public boolean povezan() {
		return steviloKomponent() == 1;
	}
}

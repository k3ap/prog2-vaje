package vaje3;

import java.util.HashSet;
import java.util.Set;

public class Tocka {
	protected InformacijeOTocki informacije;
	protected Set<Tocka> sosedi;
	
	public Tocka(InformacijeOTocki info) {
		informacije = info;
		sosedi = new HashSet<Tocka>();
	}
	
	public int stopnja() {
		return sosedi.size();
	}
	
	@Override
	public String toString() {
		return informacije.toString();
	}
	
	public boolean jeSosed(Tocka t) {
		for (Tocka x : sosedi) {
			if (x.equals(t)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean equals(Tocka o) {
		return informacije.equals(o.informacije);
	}
	
	public void dodajSoseda(Tocka t) {
		if (jeSosed(t)) return;
		sosedi.add(t);
	}
	
	public void odstraniSoseda(Tocka t) {
		sosedi.remove(t);
	}
	
	public String ime() {
		return informacije.ime;
	}
	
	public void izpisiPovezave() {
		for (Tocka t : sosedi) {
			System.out.format("Vozlišče %s je povezano z vozliščem %s\n", ime(), t.ime());
		}
	}
}

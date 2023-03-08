package vaje3;

public class InformacijeOTocki {
	protected String ime;
	protected float x, y;
	
	public InformacijeOTocki(String imeTocke) {
		ime = imeTocke;
		x = 0;
		y = 0;
	}
	
	@Override
	public String toString() {
		return ime;
	}
	
	public boolean equals(InformacijeOTocki o) {
		return ime.equals(o.ime);
	}
}

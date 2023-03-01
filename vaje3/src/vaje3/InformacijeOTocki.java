package vaje3;

public class InformacijeOTocki {
	protected String ime;
	
	public InformacijeOTocki(String imeTocke) {
		ime = imeTocke;
	}
	
	@Override
	public String toString() {
		return ime;
	}
	
	public boolean equals(InformacijeOTocki o) {
		return ime.equals(o.ime);
	}
}

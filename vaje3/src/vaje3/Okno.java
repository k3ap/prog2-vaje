package vaje3;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Okno extends JFrame {
	protected Platno platno;
	
	public Okno() {
		super();
		platno = new Platno(500, 500);
		this.add(platno);
		this.setTitle("Grafi");
	}
}

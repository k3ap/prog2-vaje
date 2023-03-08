package vaje3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Platno extends JPanel {
	protected Graf graf;
	
	protected Color barvaPovezave = Color.BLACK;
	protected Color barvaTocke = Color.BLUE;
	protected Color barvaRoba = Color.BLACK;
	protected int debelinaPovezave = 2;
	protected int debelinaRoba = 1;
	protected int polmer = 10;
	
	public Platno(int width, int height) {
		super();
		graf = null;
		this.setPreferredSize(new Dimension(width, height));
	}
	
	public void nastaviGraf(Graf g) {
		graf = g;
	}
	
	public void paintComponent(Graphics g) {
		// povezave
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(barvaPovezave);
		g2.setStroke(new BasicStroke(debelinaPovezave));
		for (Tocka t1 : graf.tocke.values()) {
			for (Tocka t2 : t1.sosedi) {
				g2.drawLine(
					Math.round(t1.informacije.x),
					Math.round(t1.informacije.y),
					Math.round(t2.informacije.x),
					Math.round(t2.informacije.y)
				);
			}
		}
		// pike
		g2.setStroke(new BasicStroke(debelinaRoba));
		for (Tocka t1 : graf.tocke.values()) {
			g2.setColor(barvaTocke);
			g2.fillOval(
				-polmer + Math.round(t1.informacije.x),
				-polmer + Math.round(t1.informacije.y),
				2*polmer, 2*polmer
			);
			g2.setColor(barvaRoba);
			g2.drawOval(
				-polmer + Math.round(t1.informacije.x),
				-polmer + Math.round(t1.informacije.y),
				2*polmer, 2*polmer
			);
			
		}
	}
}

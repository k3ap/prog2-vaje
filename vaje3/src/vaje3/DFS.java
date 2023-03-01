package vaje3;

import java.util.HashSet;
import java.util.Set;

public abstract class DFS {
	protected Graf graf;
	protected Set<String> seen;
	
	public DFS(Graf g) {
		graf = g;
		seen = new HashSet<String>();
	}
	
	public void run(String initial) {
		dfs(graf.tocka(initial), null, graf.tocka(initial));
	}
	
	public void run(Tocka initial) {
		dfs(initial, null, initial);
	}
	
	public void runAll() {
		for (Tocka t : graf.tocke.values()) {
			run(t);
		}
	}
	
	protected void dfs(Tocka curr, Tocka parent, Tocka initial) {
		if (seen.contains(curr.ime()))
			return;
		
		seen.add(curr.ime());
		dfs_body(curr, parent, initial);
		
		for (Tocka sosed : curr.sosedi) {
			dfs(sosed, curr, initial);
		}
	}
	
	protected abstract void dfs_body(Tocka curr, Tocka parent, Tocka initial);
}

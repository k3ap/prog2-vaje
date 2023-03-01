package vaje3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class DFSKomponente extends DFS {
	
	// map vozlišče - začetno DFS vozlišče
	protected Map<String, String> komponente;

	public DFSKomponente(Graf g) {
		super(g);
		komponente = new HashMap<String, String>();
	}

	@Override
	protected void dfs_body(Tocka curr, Tocka parent, Tocka initial) {
		komponente.put(curr.ime(), initial.ime());
	}
	
	public int prestejKomponente() {
		runAll();
		HashSet<String> seen = new HashSet<String>();
		for (String zacetek : komponente.values()) {
			seen.add(zacetek);
		}
		return seen.size();
	}
}

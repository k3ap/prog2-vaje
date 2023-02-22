package vaje2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SteviloBesed {
	
	public static void prestej(String inname, String outname) throws IOException {
		FileReader in = new FileReader(inname);
		FileWriter out = new FileWriter(outname);
		int chc;
		int cnt = 0;
		String word = "";
		while ((chc = in.read()) != -1) {
			char ch = (char) chc;
			if (ch == ' ' || ch == '\n') {
				if (word.length() > 0) {
					cnt++;
					out.write(word + "\n");
					word = "";
				}
			} else {
				word += ch;
			}
		}
		cnt++;
		out.write(word + "\n");
		System.out.println(cnt);
		in.close();
		out.close();
	}
	
	public static void main(String[] args) throws IOException {
		prestej("in.txt", "out.txt");
	}
}

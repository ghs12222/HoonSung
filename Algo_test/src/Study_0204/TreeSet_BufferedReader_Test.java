package Study_0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.TreeSet;

public class TreeSet_BufferedReader_Test {
	
	static int T;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine()); //checked exception
		
		TreeSet<String> ts = new TreeSet<>();
		LinkedList<String> names = new LinkedList<>();
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine()); //runtime
			ts.clear();
			names.clear();
			
			
		}
		
		
		
	}
}

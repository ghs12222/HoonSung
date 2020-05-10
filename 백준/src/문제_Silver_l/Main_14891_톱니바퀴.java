package 문제_Silver_l;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14891_톱니바퀴 {

	static int[][] chain;
	static boolean[] move;
	static int K;
	static int score;
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		chain = new int[4][8];
		for (int i = 0; i < 4; i++) {
			String s = br.readLine();
			for (int j = 0; j < 8; j++) {
				chain[i][j] = s.charAt(j)-'0';
			}
		}
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int target = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken());
			move = new boolean[4];
			move[target] = true;
			gameStart(target,dir);
		}
		
		score = 0;
		count = 0;
		for (int i = 0; i < 4; i++) {
			if(chain[i][0] == 1) {
				score += (int) Math.pow(2, i);
			}
		}
		System.out.println(score);
	}

	private static void gameStart(int target, int dir) {
		if(target+1<4 && !move[target+1] &&chain[target][2]!=chain[target+1][6]) {
			move[target] = true;
			gameStart(target+1,dir*-1);
		}
		if(target-1>=0 && !move[target-1] && chain[target][6] != chain[target-1][2]) {
			move[target] = true;
			gameStart(target-1, dir*-1);
		}
		
		if(dir == 1) {
			int tmp = chain[target][7];
			for (int i = 7; i > 0; i--) {
				chain[target][i] = chain[target][i-1];
			}
			chain[target][0] = tmp;
		}
		
		if(dir == -1) {
			int tmp = chain[target][0];
			for (int i = 0; i < 7; i++) {
				chain[target][i] = chain[target][i+1];
			}
			chain[target][7] = tmp;
		}
		
	}

}

package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_5671_지구온난화 {

	static int T, N, M;
	static boolean[] alphabet;
	static int[] getalphabet;
	static int alphabetcnt;
	static int[][] word;
	static int[] cnt, num;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
		}

		// word 초기화
		word = new int[N][27];
		for (int i = 0; i < N; i++) {
			Arrays.fill(word[i], 27);
		}

		// alphabet 초기화
		alphabet = new boolean[26];
		getalphabet = new int[26];
		Arrays.fill(getalphabet, 27);
		alphabetcnt = 0;

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			int checkcnt = 0;
			boolean[] check = new boolean[26];
			for (int j = 0; j < s.length(); j++) {
				int k = s.charAt(j) - 'a';
				if (!alphabet[k]) {
					alphabet[k] = true;
					getalphabet[alphabetcnt] = k;
					alphabetcnt++;
				}
				if (!check[k]) {
					check[k] = true;
					word[i][checkcnt] = k;
					checkcnt++;
				}
				Arrays.sort(word[i]);
			}
			Arrays.sort(getalphabet);
		}

		// 전체 프린트
		for (int i = 0; i < N; i++) {
			System.out.println("word[" + i + "]");
			for (int j = 0; j < 26; j++) {
				System.out.print(word[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("alphabetcnt = " + alphabetcnt);
		System.out.println("getalphabet");
		for (int i = 0; i < 26; i++) {
			System.out.print(getalphabet[i] + " ");
		}
		System.out.println();

		cnt = new int[M];
		Combi(0, 0);

	}

	private static void Combi(int start, int count) {
		if (count == M) {
			boolean[] check = new boolean[27];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 26; j++) {
					while(word[i][j] != 27) {
						check[word[i][j]] = true;
						
					}
				}
				
			}

			// 조합 출력
			for (int i = 0; i < M; i++) {
				System.out.print(cnt[i] + " ");
			}
			System.out.println();
			//

			return;
		}

		for (int i = start; i < alphabetcnt; i++) {
			cnt[count] = getalphabet[i];
			Combi(i + 1, count + 1);
		}

	}

}

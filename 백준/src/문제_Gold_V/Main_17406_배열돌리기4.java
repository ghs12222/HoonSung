package 문제_Gold_V;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17406_배열돌리기4 {

	static int N, M, K;
	static int[][] fix_map, map;
	static int[] R, C, S;
	static int[] num, cnt;
	static boolean[] flag;
	static int Min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		fix_map = new int[N][M];
		map = new int[N][M];
		R = new int[K];
		C = new int[K];
		S = new int[K];
		// 순열을 위한 배열
		num = new int[K];
		cnt = new int[K];
		flag = new boolean[K];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				fix_map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			R[i] = Integer.parseInt(st.nextToken()) - 1;
			C[i] = Integer.parseInt(st.nextToken()) - 1;
			S[i] = Integer.parseInt(st.nextToken());
		}

		Permi(0);

	}

	private static void Permi(int count) {
		if (count == K) {
			System.out.println(Arrays.toString(num));
			for (int i = 0; i < N; i++) {
				System.arraycopy(fix_map[i], 0, map[i], 0, M);
			}
			for (int i = 0; i < K; i++) {
				go(num[i]);
			}
		}

		for (int i = 0; i < K; i++) {
			if (!flag[i]) {
				flag[i] = true;
				num[count] = i;
				Permi(count + 1);
				flag[i] = false;
			}
		}
	}

	// R-S R
	private static void go(int target) {
		int tmp;
		int first;
		for (int k = 1; k <= S[target]; k++) {
			first = tmp = map[R[target]-k][C[target]-k];
//			while(!(first == map[R[target]+k][C[target]-k])) {
//				map[R[target]-k][C[target]-k] = map[R[target]-k+1][C[target]-k];
//			}
			
			for (int i = 0; i < k*2; i++) {
				map[R[target]-k+i][C[target]-k] = map[R[target]-k+i+1][C[target]-k];
			}
			for (int i = 0; i < k*2; i++) {
				map[R[target]+k][C[target]-k+i] = map[R[target]+k][C[target]-k+i+1];
			}
			for (int i = 0; i < k*2; i++) {
				map[R[target]+k-i][C[target]+k] = map[R[target]+k-i-1][C[target]-k];
			}
			for (int i = 0; i < k*2; i++) {
				map[R[target]-k][C[target]+k-i] = map[R[target]-k][C[target]+k-i-1];
			}
			map[R[target]-k][C[target]-k+1] = tmp;
			Print();
			
		}
	}

	static void Print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}

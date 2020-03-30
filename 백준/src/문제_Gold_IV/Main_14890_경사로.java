package 문제_Gold_IV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14890_경사로 {

	static int N, L;
	static int res;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		res = 0;
		
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			int gap = map[i][cnt] - map[i][cnt + 1];
			while ((gap == 1 || gap == 0) && cnt < N - 1) {
				gap = map[i][cnt] - map[i][cnt + 1];
				cnt++;
			}
			if (cnt == N - 1) {
				res++;
				System.out.println("1. i = " + i + ", res = " +res);
			}
		}
//		for (int i = 0; i < N; i++) {
//			int cnt = N - 1;
//			int gap = map[i][cnt] - map[i][cnt - 1];
//			while ((gap == 1 || gap == 0) && cnt > 1) {
//				gap = map[i][cnt] - map[i][cnt - 1];
//				cnt--;
//			}
//			if (cnt == 0) {
//				res++;
//				System.out.println("2. i = " + i + ", res = " +res);
//			}
//		}
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			int gap = map[cnt][i] - map[cnt + 1][i];
			while ((gap == 1 || gap == 0) && cnt < N - 1) {
				gap = map[cnt][i] - map[cnt + 1][i];
				cnt++;
			}
			if (cnt == N-1) {
				res++;
				System.out.println("3. i = " + i + ", res = " +res);
			}
		}
//		for (int i = 0; i < N; i++) {
//			int cnt = N - 1;
//			int gap = map[cnt][i] - map[cnt - 1][i];
//			while ((gap == 1 || gap == 0) && cnt > 1) {
//				gap = map[cnt][i] - map[cnt - 1][i];
//				cnt--;
//			}
//			if (cnt == 0) {
//				res++;
//				System.out.println("4. i = " + i + ", res = " +res);
//			}
//		}

		System.out.println(res);

	}

}

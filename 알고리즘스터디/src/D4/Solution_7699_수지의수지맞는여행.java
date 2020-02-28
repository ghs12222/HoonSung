package D4;

import java.util.Scanner;
import java.util.Stack;

public class Solution_7699_수지의수지맞는여행 {

	static int T, R, C;
	static char[][] map;
	static boolean[][] flag;
	static int[] dx = { 0, 0, 1, 0, -1 };
	static int[] dy = { 0, -1, 0, 1, 0 };
	static int cnt;
	static int res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			R = sc.nextInt();
			C = sc.nextInt();
			map = new char[R][C];
			flag = new boolean[R][C];
			for (int i = 0; i < R; i++) {
				String s = sc.next();
				map[i] = s.toCharArray();
			}
			res = Integer.MIN_VALUE;
			cnt = 1;
			bfs(0,0);
			
		}
		System.out.println(res);
	}

	private static void bfs(int x, int y) {
		Stack<Character> stack = new Stack<>();
//		stack.add(map[0][0]);
		
		
		for (int d = 0; d < 5; d++) {
			x+=dx[d];
			y+=dy[d];
			if(x>=0 && y>=0 && x<C && y<R && !flag[y][x]&& !stack.contains(map[y][x])) {
				cnt++;
//				flag[y][x] = true;
				stack.add(map[y][x]);
				bfs(x,y);
//				flag[y][x] = false;
				stack.pop();
				cnt--;
			}
			if(res<cnt)
				res=cnt;
			
		}
		stack.clear();
	}
	
}

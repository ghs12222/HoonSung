package 문제;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_인구이동 {
   static int[] dx = { 1, -1, 0, 0 };
   static int[] dy = { 0, 0, 1, -1 };

   static class pos {
      int x, y;

      pos(int x, int y) {
         this.x = x;
         this.y = y;
      }
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int N = sc.nextInt();
      int L = sc.nextInt();
      int R = sc.nextInt();

      int[][] map = new int[N][N];

      for (int i = 0; i < N; i++) {
         for (int j = 0; j < N; j++) {
            map[i][j] = sc.nextInt();
         }
      }

      int count = 0;

      while (true) {
         boolean chk = false;
         Queue<pos> queue = new LinkedList<>();
         boolean[][] visited = new boolean[N][N];

         for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
               int sum = 0;
               int avg = 0;
               int cnt = 0;
               List<pos> list = new ArrayList<>();
               for (int k = 0; k < 4; k++) {
                  int nx = i + dx[k];
                  int ny = j + dy[k];
                  if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                     continue;
                  if ((Math.abs(map[i][j] - map[nx][ny]) >= L && Math.abs(map[i][j] - map[nx][ny]) <= R)
                        && !visited[i][j]) {
                     chk = true;
                     visited[i][j] = true;
                     queue.add(new pos(i, j));
                     cnt++;
                     sum += map[i][j];
                  }
               }

               while (!queue.isEmpty()) {
                  pos p = queue.poll();
                  list.add(new pos(p.x, p.y));
                  for (int k = 0; k < 4; k++) {
                     int nx = p.x + dx[k];
                     int ny = p.y + dy[k];
                     if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                        continue;
                     if ((Math.abs(map[p.x][p.y] - map[nx][ny]) >= L
                           && Math.abs(map[p.x][p.y] - map[nx][ny]) <= R) && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new pos(nx, ny));
                        cnt++;
                        sum += map[nx][ny];
                     }
                  }
               }

               for (int l = 0; l < list.size(); l++) {
                  avg = sum / cnt;
                  pos p = list.get(l);
                  map[p.x][p.y] = avg;
               }
            }
         }

         count++;
         if (!chk) {
            count--;
            break;
         }
      }

      System.out.println(count);

   }

}
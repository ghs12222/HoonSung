package 기타;
import java.util.Scanner;

public class Solution_리모컨1 {

   static int a, b, c;

   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);

      a = sc.nextInt(); // 현재 온도
      b = sc.nextInt(); // 목표 온도
      c = Integer.MAX_VALUE;
      
      // 최대 버튼 횟수
      dfs(a, 0, c);

      System.out.println(c);
   }

   private static void dfs(int temp, int cnt, int pregap) {

      int res = Math.abs(temp - b);
      if (res >= pregap) {
         return;
      }
      
      if (temp == b) {
         if (cnt < c)
            c = cnt;

         return;
      }
      dfs(temp + 10, cnt + 1, res);
      dfs(temp + 5, cnt + 1, res);
      dfs(temp + 1, cnt + 1, res);
      dfs(temp - 10, cnt + 1, res);
      dfs(temp - 5, cnt + 1, res);
      dfs(temp - 1, cnt + 1, res);

   }

}
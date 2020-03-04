package Study_1st;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_최장증가부분수열 {

   static int T,N;
   static int[] count;
   static int[] su;
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      T=scan.nextInt();
      for (int t = 1; t <= T; t++) {
         N=scan.nextInt();
         count = new int[N];
         su = new int[N];
         Arrays.fill(count, 1);
         for (int i = 0; i < N; i++) {
            su[i]=scan.nextInt();
         }
         
         int max=0;
         for (int i = N-1; i >=0; i--) {
            int base = count[i];
            for (int j =i+1; j < N; j++) {
               if(su[i]<su[j]) {
                  count[i]=count[i]>count[j]+base? count[i]:count[j]+base;
                  max=max>count[i]?max:count[i];
               }
            }
         }
         
         System.out.println("#"+t+" "+ max);
         
      }
   }

}
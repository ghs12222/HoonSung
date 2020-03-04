package Àç±Í;

import java.util.Scanner;;
public class ¼ø¿­_Permutation_1 {
	static int N,M;
	public static void main(String[] args) {
	      Scanner sc = new Scanner(System.in);
	      N = sc.nextInt();
	      int[] arr = new int[N];
	      M = sc.nextInt();
	      
	      for(int i=0; i<N; i++) {
	         arr[i] = i+1;
	      }
	      
	      perm(arr,0,new int[M],new boolean[N]);
	   }
	   
	   static void perm(int[] arr,int idx,int[] result, boolean[] visited) {
	      if(idx == result.length) {
	         for(int i=0; i<result.length; i++) {
	            System.out.print(result[i]+" ");
	         }
	         System.out.println();
	         return;
	      }
	      
	      for(int i=0; i<N; i++) {
	         if(!visited[i]) {
	            visited[i] = true;
	            result[idx] = arr[i];
	            perm(arr,idx+1,result,visited);
	            visited[i] = false;
	         }
	      }
	   }

	}
package D3;
import java.util.Scanner;
public class Solution_5431_민석이의과제체크하기{
    static void func() {
        for(int i = 0 ; i < N; i++) {
            if(matrix[i]==false)
                System.out.print((i+1)+" ");
        }
    }
 
    static boolean matrix[];
    static int T, N, M;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            M = sc.nextInt();
            matrix = new boolean[N];
            for (int i = 0; i < M; i++) {
                matrix[sc.nextInt()-1] = true;
            }
 
            System.out.print("#" + test_case + " ");
            func();
            System.out.println();
        }
    }
}
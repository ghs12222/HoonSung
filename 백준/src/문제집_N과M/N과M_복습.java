package 문제집_N과M;

import java.util.Scanner;
 
public class N과M_복습 {
    
    static int[] change;
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        Scanner sc = new Scanner(System.in);
        
        change = new int[100];
        
        System.out.println("거스름돈을 입력해주세요:");
        int i = sc.nextInt();
        
        calc_change();
        
        System.out.println("지불해야하는 거스름돈 개수 :" + change[i]);
 
    }
    
    static void calc_change(){
        change[0]=0;
        
        for(int i=1; i<100; i++){
            change[i] = min_change(i)+1;
        }
        
    }
    
    static int min_change(int i){
        int min = change[i-1];
        if(i>=3){
            if(min>change[i-3]) min = change[i-3];
        }
        if(i>=4){
            if(min>change[i-4]) min = change[i-4];
        }
        return min;
    }
 
}
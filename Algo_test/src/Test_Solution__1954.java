import java.util.Scanner;
import java.util.Arrays;

public class Test_Solution__1954 {
	
	//static int T;
	static int N;
	static int[][] board;
	static int[] dy= {0, 0, -1};
	static int[] dx= {-1, 1, 0};
	static int[] idx= {0,1,2};
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		for (int k = 0; k < 10; k++) {		
			scann.nextInt();
			int x=0;
			int y=0;

			board=new int[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					board[i][j]=scann.nextInt();
					if(board[i][j]==2) {
						x=j;
						y=i;
					}
				}
			}
			System.out.println("a");
			while(y>0) {
				System.out.println(y);
				if(board[y][x+1]==0 && board[y][x-1]==0) {
					y--;
					board[y][x]=0;
					System.out.println("c");
				}
				else if(board[y][x+1]==1 && board[y][x-1]==0) {
					x++;
					board[y][x]=0;
					System.out.println("a");
				}
				else if(board[y][x+1]==0 && board[y][x-1]==1) {
					x--;
					board[y][x]=0;
					System.out.println("b");
				}
				
				/*
				if(x+1<100 && x-1>0 && y+1>100 && y-1>0) {
					if(board[y][x+1]==0 && board[y-1][x]==1 && board[y][x-1]==0) {
						y--;
					}
					else if(board[y][x+1]==1 && board[y-1][x]==1 && board[y][x-1]==0) {
						x++;
					}
					else if(board[y][x+1]==0 && board[y-1][x]==1 && board[y][x-1]==0) {
						y--;
					}
					*/
					
				
			}
			System.out.println("#"+k+" "+x);
		}
		
	
	
	}

}

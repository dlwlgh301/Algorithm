package d4;

import java.util.Scanner;
public class SwExpert1210 {//사다리타기 1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int tc =1; tc<=10; tc++) {
            int T = sc.nextInt();
            int [][]arr= new int[102][102];
            int x = 0;
            for(int i = 1; i <= 100; i++) {
                for(int j = 1; j<= 100; j++) {
                    arr[i][j]=sc.nextInt();
                }
            }
            for(int index = 1; index<=100; index++) {//2가있는 x index 저장
                if(arr[100][index]==2) {
                    x = index;
                    break;
                }
            }
            for(int i = 100; i>0; i--) {
                if(arr[i][x-1]==1) {
                    while(true) {
                        x--;
                        if(arr[i][x-1]!=1) break;
                    }
                }else if(arr[i][x+1]==1) {
                    while(true) {
                        x++;
                        if(arr[i][x+1]!=1) break;
                    }
                }
            }
            System.out.printf("#%d %d\n",tc, x-1);
        }
    }
}
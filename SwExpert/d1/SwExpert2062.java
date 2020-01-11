package d1;

import java.util.Arrays;
import java.util.Scanner;
 
public class SwExpert2062 {//중간값 찾기
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int []number=new int[N];
        for(int i =0 ; i<N; i++) {
            number[i]=sc.nextInt();
        }
        Arrays.sort(number);
        N=N/2;
        System.out.println(number[N]);        
    }
}
package d1;

import java.util.Scanner;

public class SwExpert2072 {//홀수만 더하기

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		int[] num = new int[10];
		
		for(int test_case = 0 ; test_case<T; test_case++) {
			int sum = 0;
			for(int i = 0; i<num.length; i++) {
				num[i]=sc.nextInt();
			}
			for(int i =0; i<num.length; i++) {
				if(num[i]%2==1) {
					sum+=num[i];
				}
			}
			System.out.printf("#%d %d\n",test_case+1,sum);
		}
		sc.close();
	}

}

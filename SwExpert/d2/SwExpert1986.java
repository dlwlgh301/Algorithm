package d2;

import java.util.Scanner;

public class SwExpert1986 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		for(int tc= 1; tc<=k; tc++) {
			int N = sc.nextInt();
			int sum=0;
			for(int i=1; i<=N; i++) {
				if(i%2==0) {
					sum=sum-i;
				}else sum=sum+i;
			}
			System.out.printf("#%d %d\n",tc,sum);
		}
	}

}

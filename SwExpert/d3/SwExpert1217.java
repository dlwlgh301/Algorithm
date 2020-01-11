package d3;

import java.util.Scanner;

public class SwExpert1217 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for(int tc =1; tc<=10; tc++) {
			int k=sc.nextInt();
			int N=sc.nextInt();
			int M=sc.nextInt();
			int result=pow(N,M);
			
			System.out.printf("#%d %d\n",k,result);
		}
	}
	private static int pow(int base, int exp) {
		
		if(exp==0) return 1;
		int num=pow(base,exp/2);
		if(exp%2==0) {
			return num*num;
		}else return num*num*base;
		
	}

}

package d2;

import java.util.Scanner;

public class SwExpert1945 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc =1 ; tc<=T; tc++) {
			int []nums = new int[5];
			int N= sc.nextInt();
			while(N!=1) {
				if(N%2==0) {
					N=N/2;
					nums[0]++;
				}
				if(N%3==0) {
					N=N/3;
					nums[1]++;
				}
				if(N%5==0) {
					N=N/5;
					nums[2]++;
				}
				if(N%7==0) {
					N=N/7;
					nums[3]++;
				}
				if(N%11==0) {
					N=N/11;
					nums[4]++;
				}
			}
			System.out.printf("#%d ",tc);
			for(int i =0; i<5; i++) {
				System.out.print(nums[i]+" ");
			}
			System.out.println();
		}
	}

}

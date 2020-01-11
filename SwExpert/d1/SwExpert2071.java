package d1;

import java.util.Scanner;

public class SwExpert2071 {//평균값 구하기

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		double[] num = new double[10];
		
		
		for(int test_case = 0 ; test_case<T; test_case++) {
			double sum = 0; double avg=0;
			for(int i = 0; i<num.length; i++) {
				num[i]=sc.nextDouble();
			}
			for(int i =0; i<num.length; i++) {
				sum+=num[i];
			}
			avg=sum/10.0;
			avg=Math.round(avg);
			int result=(int)avg;
			System.out.print("#"+(test_case+1)+" "+result+"\n");
		}
		sc.close();
	}

}

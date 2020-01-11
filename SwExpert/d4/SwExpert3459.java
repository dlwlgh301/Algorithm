package d4;

import java.util.Scanner;

public class SwExpert3459 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			long num = sc.nextLong();
			while(num>=10) {
				num = num/2+1;
				num = num/2 -1 ;
			}
			if(num==1 || (num>=6&&num<=9)) {
				System.out.printf("#%d %s\n",tc,"Bob");
			}else System.out.printf("#%d %s\n",tc,"Alice");
			
		}
	}
}

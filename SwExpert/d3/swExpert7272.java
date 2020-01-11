package d3;

import java.util.Scanner;

public class swExpert7272 {//안경이 안보여

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// char [] zero=
		char[] one = { 'A', 'D', 'O', 'P', 'Q', 'R' };
		char[] two = { 'B' };
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n1 = 0;
			int n2 = 0;
			String result = "";
			String s1="";
			String s2="";
			s1 = sc.next();
			s2 = sc.next();
			char[] str1 = new char[s1.length()];
			char[] str2 = new char[s2.length()];
			str1 = s1.toCharArray();
			str2 = s2.toCharArray();
			for (int i = 0; i < str1.length; i++) {
				if ("ADOPQR".contains(str1[i] + "")) {
					n1++;
				}
				if (str1[i] == 'B') {
					n1 = n1 + 2;
				}
			}
			for (int i = 0; i < str2.length; i++) {
				if ("ADOPQR".contains(str2[i] + "")) {
					n2++;
				}
				if (str2[i] == 'B') {
					n2 = n2 + 2;
				}
			}
			if (n1 == n2) {
				result = "SAME";
			} else
				result = "DIFF";
			System.out.printf("#%d %s\n", tc, result);
		}
	}
}

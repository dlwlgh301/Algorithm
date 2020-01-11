package d6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SwExpert1266 {
	static int [] prime = {2,3,5,7,11,13,17};
	
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=n; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double skillA = Double.parseDouble(st.nextToken());
			double skillB = Double.parseDouble(st.nextToken());
			double resultA=0,resultB=0;
			for(int i = 0; i<7; i++) {
				resultA += Math.pow(skillA/100, prime[i])*Math.pow(1- (skillA/100), 18-prime[i]);
				resultB += Math.pow(skillB/100, prime[i])*Math.pow(1- (skillA/100), 18-prime[i]);
			}
			System.out.println(resultA);
			System.out.println(resultB);
		}
	}
}
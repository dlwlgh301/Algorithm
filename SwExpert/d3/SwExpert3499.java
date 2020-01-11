package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SwExpert3499 {
	static StringTokenizer token;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k =Integer.parseInt(br.readLine());
		for(int tc =1 ; tc<=k; tc++) {
			ArrayList<String> temp1 = new ArrayList<>();
			ArrayList<String> temp2 = new ArrayList<>();
			ArrayList<String> result = new ArrayList<>();
			int N =Integer.parseInt(br.readLine());
			token = new StringTokenizer(br.readLine());
			int c=N/2;
			if(N%2==1) {
				c=c+1;
			}
			for(int i =0; i<c; i++) {
				temp1.add(token.nextToken());
			}
			for(int i=c; i<N; i++) {
				temp2.add(token.nextToken());
			}
			for(int i=0; i<c; i++) {
				result.add(temp1.get(i));
				if(N%2==1&&i==c-1) break;
				result.add(temp2.get(i));
			}
			System.out.printf("#%d ",tc);
			for(int i =0 ; i<N; i++) {
				System.out.print(result.get(i)+" ");
			}
			System.out.println();
		}
	}
}

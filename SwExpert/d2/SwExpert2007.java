package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SwExpert2007 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= n; tc++) {
			String inputs = br.readLine();
			for(int i = 1 ; i<inputs.length(); i++) {
				String temp=inputs.substring(0,i);
				String comp=inputs.substring(i,i+i);
				if(temp.equals(comp)) {
					System.out.printf("#%d %d\n",tc,i);
					break;
				}
			}
		}
	}
}

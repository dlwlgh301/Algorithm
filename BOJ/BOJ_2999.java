import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2999 {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String input=br.readLine();
		int n = input.length();
		int r = 0;
		for(int i = 1; i<=Math.sqrt(n); i++) {
			if(n%i==0) {
				r = i;
			}
		}
		int c = n/r;
		int cnt=0;
		char code[][]= new char[r][c];
		for(int i =0; i<c; i++) {
			for(int j = 0; j<r; j++) {
				code[j][i]=input.charAt(cnt++);
			}
		}
		for(int i = 0; i<r; i++) {
			for(int j = 0; j<c; j++) {
				System.out.print(code[i][j]);
			}
		}
	}

}

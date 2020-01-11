import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 1; i<=N; i++) {
			list.add(i);
		}
		int temp=0;
		System.out.print("<");
		while(list.size()!=0) {
			temp=(temp+K-1)%list.size();
			if(list.size()==1) {
				System.out.print(list.remove(temp));
			}
			else System.out.print(list.remove(temp)+", ");
		}
		System.out.print(">");
	}

}

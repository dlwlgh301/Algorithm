import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1931 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int conference [][] = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			conference[i][0]=Integer.parseInt(st.nextToken());
			conference[i][1]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(conference,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]==o2[1] ? o1[0]-o2[0] : o1[1]-o2[1];
			}
		});
		int endTime = -1;
		int cnt=0;
		for(int i =0; i<conference.length; i++) {
			if(conference[i][0]>=endTime) {
				cnt++;
				endTime=conference[i][1];
			}
		}
		System.out.println(cnt);
	}
}

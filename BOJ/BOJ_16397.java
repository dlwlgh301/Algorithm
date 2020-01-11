import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16397 {
	static int N,T,G;
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		visit = new boolean[100000];
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		int ans = solv();
		
		if(ans == -1) {
			System.out.println("ANG");
		}
		else {
			System.out.println(ans);
		}
	}
	private static int solv() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {N,0});
		visit[N]=true;
		
		while(!q.isEmpty()) {
			int temp[]=q.poll();
			int num = temp[0];
			int cnt = temp[1];
			
			if(cnt > T) {
				break;
			}
			
			if(num==G) {
				return cnt;
			}
			
			int bA = num+1;
			
			if(bA<100000 &&!visit[bA]) {
				visit[bA]=true;
				q.add(new int[] {bA,cnt+1});
			}
			int cur = num*2;
			if(cur>99999) continue;
			
			int bB = process(cur);
			
			if(bB<100000 &&!visit[bB]) {
				visit[bB]= true;
				q.add(new int[] {bB,cnt+1});
			}
		}
		return -1;
		
	}
	private static int process(int num) {
		int temp = num;
		int a = -1;
		while(temp!=0) {
			temp = temp/10;
			a++;
		}
		int m= (int) Math.pow(10, a);
		return num-m;
	}

}

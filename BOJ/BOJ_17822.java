import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_17822 {

	static int[][] round;
	static int N, M, T;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		T = sc.nextInt();
		round = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				round[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("원상태");
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				System.out.print(round[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		for(int i = 0; i<T; i++) {
			int x = sc.nextInt();
			int d = sc.nextInt();//0시계 1반시계
			int k = sc.nextInt();
			solve(x, d, k);
		}
		int ans = 0 ;
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				ans +=round[i][j];
			}
		}
		System.out.println(ans);
	}
	static boolean check;
	private static void solve(int x, int d, int k) {
		for (int i = 1; i <= N; i++) {
			if (i % x == 0) {
				for (int j = 0; j < k; j++) {
					rotate(i,d);
				}
			}
		}
		System.out.println("rotate 후"+x+" "+d+" "+k);
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				System.out.print(round[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		check = false;
		delete();
		System.out.println("delete 후");
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				System.out.print(round[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		if(!check) {
			update();
			System.out.println("update 후");
			for(int i = 1; i<=N; i++) {
				for(int j = 1; j<=M; j++) {
					System.out.print(round[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
		}
		
	}

	private static void update() {
		double count = 0;
		double sum = 0;
		double avg = 0;
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				if(round[i][j]!=0) {
					sum=sum+round[i][j];
					count++;
				}
			}
		}
		avg = sum/count;
		//System.out.println("avg: "+avg);
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				if(round[i][j]!=0) {
					if(round[i][j]>avg) round[i][j]--;
					else if (round[i][j]<avg) round[i][j]++;
				}
			}
		}
	}
	
	private static void delete() {
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				if(round[i][j]!=0) {
					visit = new boolean[N+1][M+1];
					BFS(i,j);
				}
			}
		}
	}
	static boolean visit[][];
	static int dx[]= {0,0,1,-1};
	static int dy[]= {1,-1,0,0};
	private static void BFS(int si, int sj) {
		Queue <Integer> q = new LinkedList<>();
		q.add(si);
		q.add(sj);
		visit[si][sj]=true;
		int temp = round[si][sj];
		while(!q.isEmpty()) {
			int qx = q.poll();
			int qy = q.poll();
			for(int i = 0; i<4; i++) {
				int tx = qx+dx[i];
				int ty = qy+dy[i];
				if(tx<=0||tx>N) continue;
				if(ty==0) {
					ty=M;
				}else if (ty>M) {
					ty=1;
				}
				if(visit[tx][ty]) continue;
				if(round[tx][ty]==temp) {
					round[si][sj]=0;
					round[tx][ty]=0;
					visit[tx][ty]=true;
					check = true;
					q.add(tx);
					q.add(ty);
				}
			}
		}
		
	}

	private static void rotate(int index,int d) {
		if(d==0) {
			int temp = round[index][M];
			for(int i = M; i>1; i--) {
				round[index][i]=round[index][i-1];
			}
			round[index][1]=temp;
		}else if (d==1) {
			int temp = round[index][1];
			for(int i = 1; i<M; i++) {
				round[index][i] = round[index][i+1];
			}
			round[index][M]=temp;
		}
	}
}

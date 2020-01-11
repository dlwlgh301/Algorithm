import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2151 {
	/*
	 * BOJ 2151 거울설치 
	 */
	static char map[][];
	static int visit[][][];
	static int N,sx,sy,ex,ey,flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map= new char[N][N];
		visit = new int[N][N][4];
		for(int i = 0; i<N; i++) {
			String input = br.readLine();
			map[i]=input.toCharArray();
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(map[i][j]=='#') {
					if(flag==0) {
						sx=i;
						sy=j;
						flag=1;
					}else {
						ex=i;
						ey=j;
					}
				}
				for(int k = 0; k<4; k++) {
					visit[i][j][k]=100000;
				}
			}
		}
		BFS();
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i<4; i++) {
			ans = Math.min(ans, visit[ex][ey][i]);
		}
		System.out.println(ans);

	}
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	private static void BFS() {
		Queue <posit> q = new LinkedList<>();
		for(int i = 0; i<4; i++) {
			q.add(new posit(sx,sy,i,0));
		}
		while(!q.isEmpty()) {
			posit temp = q.poll();
			
			int tx = temp.x+dx[temp.dir];
			int ty = temp.y+dy[temp.dir];
			if(tx<0||ty<0||tx>=N||ty>=N||map[tx][ty]=='*') continue;
			
			if(map[tx][ty]=='!') {
				if(temp.dir==0||temp.dir==1) {
					if(visit[tx][ty][2]>temp.cur+1) {
						visit[tx][ty][2]=temp.cur+1;
						q.add(new posit(tx,ty,2,temp.cur+1));
					}
					if(visit[tx][ty][3]>temp.cur+1) {
						visit[tx][ty][3]=temp.cur+1;
						q.add(new posit(tx,ty,3,temp.cur+1));
					}
				}else if(temp.dir==2||temp.dir==3) {
					if(visit[tx][ty][0]>temp.cur+1) {
						visit[tx][ty][0]=temp.cur+1;
						q.add(new posit(tx,ty,0,temp.cur+1));
					}
					if(visit[tx][ty][1]>temp.cur+1) {
						visit[tx][ty][1]=temp.cur+1;
						q.add(new posit(tx,ty,1,temp.cur+1));
					}
				} 
			}
			if(visit[tx][ty][temp.dir]>temp.cur) {
				visit[tx][ty][temp.dir]=temp.cur;
				q.add(new posit(tx,ty,temp.dir,temp.cur));
			}
		}
	}
	static class posit{
		int x;
		int y;
		int dir;//현재 방향
		int cur;//현재 설치한 거울 수
		public posit(int x, int y, int dir, int cur) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cur = cur;
		}
	}
}

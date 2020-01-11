import java.io.*;
import java.util.*;

public class BOJ_2644 {//촌수계산
	static boolean[] visited;
	static int [][] graph;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int people = Integer.parseInt(br.readLine()); 
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		graph= new int[people+1][people+1];
		visited=new boolean[people+1];
		int start=Integer.parseInt(tokenizer.nextToken());
		int end=Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(br.readLine()); 
		for(int i =0; i<m; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			int x= Integer.parseInt(tokenizer.nextToken());
			int y= Integer.parseInt(tokenizer.nextToken());
			graph[x][y]=1;
			graph[y][x]=1;
		}
		/*for(int i =0; i<=people; i++) {
			for(int j=0; j<=people; j++) {
				System.out.print(graph[i][j]);
			}
			System.out.println();
		}*/
		BFS(start,end);
	}
	private static void BFS(int start, int end) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		int level = 0;
		while(!q.isEmpty()) {
			int temp=q.poll();
			System.out.println(temp);
			visited[temp]=true;
			for(int i =1; i<visited.length; i++) {
				if(graph[temp][i]==1&&!visited[i]) {
					q.offer(i);
					visited[i]=true;
				}
			}
		}
		level++;
	}

}

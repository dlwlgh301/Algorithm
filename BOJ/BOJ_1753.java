import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * BOJ1753 최단경로
 */
public class BOJ_1753 {
	static class Node implements Comparable<Node>{
		int end;
		int weight;
		public Node(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}
		
	}
	
	static ArrayList<Node> map[];
	static int dist[];
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		dist = new int[V+1];
		visit = new boolean[V+1];
		map = new ArrayList[V+1];
		for(int i = 0; i<=V; i++) {
			dist[i] = Integer.MAX_VALUE-1;
			map[i] = new ArrayList<>();
		}
		st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			map[start].add(new Node(end,weight));
			
		}
		
		solve(K);
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=V; i++) {
			if(visit[i]) {
				sb.append(dist[i]+"\n");
			}else {
				sb.append("INF\n");
			}
		}
		System.out.println(sb);
		
	}
	private static void solve(int K) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[K]=0;
		pq.offer(new Node(K,0));
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int cur = node.end;
			
			if(visit[cur]) continue;
			visit[cur] = true;
			for(int i = 0; i<map[cur].size(); i++) {
				int next = map[cur].get(i).end;
				int weight = map[cur].get(i).weight;
				if(visit[next]) continue;
				if(dist[next]>dist[cur]+weight) {
					dist[next] = weight+dist[cur];
					pq.offer(new Node(next,dist[next])); 
				}
				
			}
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOKJ_1916 {

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
			return this.weight-o.weight;
		}
	}
	
	static ArrayList<Node> map[];
	static boolean visit[];
	static int dist[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		map = new ArrayList[V+1];
		dist = new int[V+1];
		visit = new boolean[V+1];
		for(int i = 0 ; i<=V; i++) {
			map[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		for(int i = 0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			map[from].add(new Node(to,weight));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		solv(start);
		
		System.out.println(dist[end]);
	}
	private static void solv(int start) {
		dist[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start,0));
		
		while(!pq.isEmpty()){
			Node node = pq.poll();
			int cur = node.end;
			if(visit[cur]) continue;
			visit[cur]= true;
			for(int i = 0; i<map[cur].size(); i++) {
				int next = map[cur].get(i).end;
				int weight = map[cur].get(i).weight;
				if(visit[next]) continue;
				if(dist[next]>dist[cur]+weight) {
					dist[next]=dist[cur]+weight;
					pq.offer(new Node(next,dist[next]));
				}
			}
			
		}
		
	}

}

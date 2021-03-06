import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1922 {

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
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		map = new ArrayList[V+1];
		visit = new boolean[V+1];
		for(int i = 0 ; i<=V; i++) {
			map[i] = new ArrayList<>();
		}
	
		for(int i = 0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			map[from].add(new Node(to,weight));
			map[to].add(new Node(from,weight));
			
		}
		
		int ans = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			visit[1]=true;
			for(int i = 0; i<map[cur].size(); i++) {
				pq.add(map[cur].get(i));
			}
			while(!pq.isEmpty()){
				Node node = pq.poll();
				int next = node.end;
				if(!visit[next]) {
					visit[next] = true;
					ans += node.weight;
					q.add(next);
					break;
				}
				
			}
		}
		System.out.println(ans);
	}
		
}

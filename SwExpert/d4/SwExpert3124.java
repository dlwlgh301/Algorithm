package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SwExpert3124 {
	static int[] p;
	static long result;
	static int cnt;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
		
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			TreeSet<Edge> tree = new TreeSet<>();
			result = 0;
			cnt=0;
			p = new int[V+1];
			makeSet();
			for(int i =0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				tree.add(new Edge(x,y,weight));
			}
			
			for (Edge e : tree) {
				unionSet(e);
				if (cnt == V - 1) {
					break;
				}
			}
			System.out.println("#"+tc+" "+result);
		}
	}
	static int findSet(int x) {
		if (x == p[x]) {
			return x;
		}
		/*
		 * int px = findSet(p[x]); p[x]=px; return p[x];
		 */
		return p[x] = findSet(p[x]);
	}
	static void unionSet(Edge e) {
		int x = findSet(e.x);
		int y = findSet(e.y);
		if (x != y) {
			p[y] = x;
			result += e.weight;
			cnt++;// 간선 개수
		}
	}
	private static void makeSet() {
		for (int i = 1; i < p.length; i++) {
			p[i] = i;
		}
	}
	static class Edge implements Comparable<Edge> {
		int x;
		int y;
		int weight;

		public Edge(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight > o.weight ? 1 : -1;
		}
	}

}

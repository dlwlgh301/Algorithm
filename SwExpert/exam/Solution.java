package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Solution {

	static int N;
	static int cntA = Integer.MAX_VALUE, cntD = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			cntA = Integer.MAX_VALUE;
			cntD = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<Integer> card = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				card.add(Integer.parseInt(st.nextToken()));
			}
			int mid = N / 2;
			solvASC(0, mid, card);
			solvDESC(0, mid, card);
			if(cntA==Integer.MAX_VALUE&&cntD==Integer.MAX_VALUE) {
				System.out.printf("#%d -1\n",tc);
			}
			else if(cntA<cntD) {
				System.out.printf("#%d %d\n",tc,cntA);
			}else if (cntD<cntA){
				System.out.printf("#%d %d\n",tc,cntD);
			}
		}
	}
	private static void solvASC(int depth, int mid, ArrayList<Integer> card) {// 오름차순
		if (depth > 5) {
			return;
		}
		//System.out.println("ASC:"+ card.toString());
		boolean flag = false;
		for (int i = 0; i < N - 1; i++) {
			if (card.get(i) - card.get(i + 1) == -1) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		if (flag) {
			if (depth < cntA) {
				cntA = depth;
				return;
			}
		}
		ArrayList<Integer> Da = new ArrayList<>();
		ArrayList<Integer> Db = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		for (int i = 0; i < mid; i++) {
			Da.add(card.get(i));
		}
		for (int i = mid; i < N; i++) {
			Db.add(card.get(i));
		}
		for (int i = 0; i < N; i++) {
			int ai = 0, bi = 0;
			temp.clear();
			if (i < mid) {
				for (int j = 0; j < mid - i; j++) {
					temp.add(Da.get(ai++));
				}
				for (int j = 0; j < i; j++) {
					temp.add(Db.get(bi++));
					temp.add(Da.get(ai++));
				}
				for (int j = 0; j < mid - i; j++) {
					temp.add(Db.get(bi++));
				}
			} else if (i >= mid) {
				for (int j = 0; j <= Math.abs(mid - i); j++) {
					temp.add(Db.get(bi++));
				}
				for (int j = 0; j < N - i - 1; j++) {
					temp.add(Da.get(ai++));
					temp.add(Db.get(bi++));
				}
				for (int j = 0; j <= Math.abs(mid - i); j++) {
					temp.add(Da.get(ai++));
				}
			}
			solvASC(depth + 1, mid, temp);
		}
	}
	private static void solvDESC(int depth, int mid, ArrayList<Integer> card) {// 내림차순
		if (depth > 5) {
			return;
		}
		System.out.println("DESC:"+ card.toString());
		boolean flag = false;
		for (int i = 0; i < N - 1; i++) {
			if (card.get(i) - card.get(i + 1) == 1) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		if (flag) {
			if (depth < cntD) {
				cntD = depth;
				return;
			}
		}
		ArrayList<Integer> Da = new ArrayList<>();
		ArrayList<Integer> Db = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		for (int i = 0; i < mid; i++) {
			Da.add(card.get(i));
		}
		for (int i = mid; i < N; i++) {
			Db.add(card.get(i));
		}
		for (int i = 0; i < N; i++) {
			int ai = 0, bi = 0;
			temp.clear();
			if (i < mid) {
				for (int j = 0; j < mid - i; j++) {
					temp.add(Da.get(ai++));
				}
				for (int j = 0; j < i; j++) {
					temp.add(Db.get(bi++));
					temp.add(Da.get(ai++));
				}
				for (int j = 0; j < mid - i; j++) {
					temp.add(Db.get(bi++));
				}
			} else if (i >= mid) {
				for (int j = 0; j <= Math.abs(mid - i); j++) {
					temp.add(Db.get(bi++));
				}
				for (int j = 0; j < N - i - 1; j++) {
					temp.add(Da.get(ai++));
					temp.add(Db.get(bi++));
				}
				for (int j = 0; j <= Math.abs(mid - i); j++) {
					temp.add(Da.get(ai++));
				}
			}
			solvDESC(depth + 1, mid, temp);
		}
	}
}

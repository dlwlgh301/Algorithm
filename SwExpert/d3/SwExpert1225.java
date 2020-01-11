package d3;

import java.io.*;
import java.util.*;

public class SwExpert1225 {//암호 생성기
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q=new LinkedList<>();
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(reader.readLine());
			
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			for(int i = 0; i<8; i++) {
				q.add(Integer.parseInt(tokenizer.nextToken()));
			}
			int count =1;
			while(true) {
				int num =q.poll() - count;
				if(num<=0) {
					q.add(0);
					break;
				}
				q.add(num);
				count++;
				if(count==6) {
					count=1;
				}
			}
			System.out.printf("#%d ",tc);
			for(int i =0; i<8; i++) {
				System.out.print(q.poll()+" ");
			}
			System.out.println();
		}
	}
}

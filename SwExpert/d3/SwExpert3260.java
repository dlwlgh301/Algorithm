package d3;

import java.util.Scanner;
import java.util.Stack;

public class SwExpert3260 {//큰 숫자 더하기 (스택)

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String x = sc.next();
			String y = sc.next();
			int flag = 0;
			int max = 0;
			int result = 0;
			char r1 = 0;
			char r2 = 0;
			Stack<Character> stack1 = new Stack<Character>();
			Stack<Character> stack2 = new Stack<Character>();
			Stack<Character> stack3 = new Stack<Character>();
			char[] num1 = new char[x.length()];
			char[] num2 = new char[y.length()];
			num1 = x.toCharArray();
			num2 = y.toCharArray();
			for (int i = 0; i < num1.length; i++) {
				stack1.push(num1[i]);
			}
			for (int i = 0; i < num2.length; i++) {
				stack2.push(num2[i]);
			}
			int a = stack1.size();
			int b = stack2.size();
			if (a > b) {
				max = a;
			} else
				max = b;
			for (int i = 0; i < max; i++) {
				if (!stack1.isEmpty()) {
					r1 = stack1.pop();
				}else { 
					r1=(int)'0';
				}
				if (!stack2.isEmpty()) {
					r2 = stack2.pop();
				}else {
					r2=(int)'0';
				}
				result = ((int) r1 - 48) + ((int) r2 - 48);
				if(result>=10) {//합이 10이 넘어가는경우
					if(flag==1) {//전의 합이 10이 넘었을경우
						result = result + 1;
					}
					result=result%10;
					stack3.push((char) (result + 48));
					flag=1;
				}else{//안넘어가는 경우
					if(flag==1) {
						result = result + 1;
						if(result>=10) {
							result=result%10;
							stack3.push((char) (result + 48));
							flag=1;
							continue;
						}
					}
					result=result%10;
					stack3.push((char) (result + 48));
					flag=0;
				}
			}
			if(flag==1) stack3.push('1');
			String sum = "";
			int index = stack3.size();
			for (int i = 0; i < index; i++) {
				sum = sum + Character.toString(stack3.pop());
			}

			System.out.printf("#%d %s\n", tc, sum);
		}
	}

}
/*if (result >= 10) {//합이 10 넘어가는경우
result = result % 10;
if (flag == 1) {//전의 합이 10넘어갔을경우
	result = result + 1;
	stack3.push((char) (result + 48));
}else {
	stack3.push((char) (result + 48));
}
} else {//합이 10 이 안넘어가는경우 
if (flag == 1) {//전의 합이 10넘어갔을경우
	result = result + 1;
	result = result % 10;
	stack3.push((char) (result + 48));
}else stack3.push((char) (result + 48));
}*/
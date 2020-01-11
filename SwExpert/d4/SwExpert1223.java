package d4;

import java.util.Scanner;
import java.util.Stack;

public class SwExpert1223 {

	public static void main(String[] args) {//계산기 4
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int K = sc.nextInt();
			Stack<Character> stack = new Stack<>();
			String str = sc.next();
			String result = "";
			char[] arr = str.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] >= '0' && arr[i] <='9') {
					result += arr[i];
				} else {
					while (!stack.isEmpty() && getPriority(arr[i]) <= getPriority(stack.peek())) {
						result += stack.pop();
					}
					stack.push(arr[i]);
				}
			}
			while (!stack.isEmpty()) {
				result += stack.pop();
			}
			int solv = getCaculate(result);
			
			System.out.printf("#%d %d\n",tc,solv);
		}

	}

	private static int getCaculate(String result) {
		char[] crr = result.toCharArray();
		Stack<Integer> stack = new Stack<>();
		int n1 = 0;
		int n2 = 0;
		int temp = 0;
		for (int i = 0; i < crr.length; i++) {
			if (crr[i] >= '0' && crr[i] <= '9') {
				stack.push((int) crr[i] - '0');
			} else if (crr[i] == '-') {
				n2 = stack.pop();
				n1 = stack.pop();
				temp = n1 - n2;
				stack.push(temp);
			} else if (crr[i] == '+') {
				n2 = stack.pop();
				n1 = stack.pop();
				temp = n1 + n2;
				stack.push(temp);
			} else if (crr[i] == '*') {
				n2 = stack.pop();
				n1 = stack.pop();
				temp = n1 * n2;
				stack.push(temp);
			} else if (crr[i] == '/') {
				n2 = stack.pop();
				n1 = stack.pop();
				temp = n1 / n2;
				stack.push(temp);
			}
		}
		return stack.peek();
	}
	static int getPriority(char ch) {
		int type = 0;
		switch (ch) {
		case '*':
		case '/':
			type = 2;
			break;
		case '+':
		case '-':
			type = 1;
			break;
		}
		return type;
	}
}

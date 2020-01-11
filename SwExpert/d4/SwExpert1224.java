package d4;

import java.util.Scanner;
import java.util.Stack;

public class SwExpert1224 {// 계산기 만들기 -->후위연산후 스택을 이용하여 계산

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int n = sc.nextInt();
			String num = sc.next();
			String result = DoPostOrder(num);
			int solv = getCaculate(result);
			System.out.printf("#%d %d\n", tc, solv);
		}
	}

	private static String DoPostOrder(String nums) {
		Stack<Character> stack = new Stack<>();
		char[] crr = nums.toCharArray();
		String result = "";
		// StringBuilder sb = new StringBuilder();
		for (char ch : crr) {
			if (ch == '(') {
				stack.push(ch);
			} else if (ch >= '0' && ch <= '9') {
				result = result + ch;
			} else if (ch == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					result += stack.pop();
				}
				stack.pop();
			} else {
				while (!stack.isEmpty() && getPriority(ch) <= getPriority(stack.peek())) {
					result += stack.pop();
				}
				stack.push(ch);
			}
		}
		while (!stack.isEmpty()) {
			result += stack.pop();
		}
		return result;
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

	static int getCaculate(String nums) {
		char[] crr = nums.toCharArray();
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
}

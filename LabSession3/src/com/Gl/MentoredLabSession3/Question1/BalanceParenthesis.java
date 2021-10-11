package com.Gl.MentoredLabSession3.Question1;

import java.util.Scanner;
import java.util.Stack;

public class BalanceParenthesis {

	static boolean areBracketsBalanced(String brackets) {
		if (brackets.length() % 2 == 1) {
			return false;
		} else {
			Stack<Character> stack = new Stack<>();

			for (int i = 0; i < brackets.length(); i++) {
				char b = brackets.charAt(i);

				if (b == '(' || b == '[' || b == '{') {
					stack.push(b);

				} else {
					char c;
					switch (b) {
					case ')':
						c = stack.pop();

						if (c == '}' || c == ']') {
							return false;
						}

						break;

					case '}':
						c = stack.pop();

						if (c == ')' || c == ']') {
							return false;
						}

						break;

					case ']':
						c = stack.pop();

						if (c == '}' || c == ')') {
							return false;
						}

						break;

					default:
						break;
					}
				}

			}
			return (stack.isEmpty());

		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Parenthesis");
		String exp = sc.next();
		System.out.println("The Parenthesis is balanced : " + areBracketsBalanced(exp));
		sc.close();
	}

}

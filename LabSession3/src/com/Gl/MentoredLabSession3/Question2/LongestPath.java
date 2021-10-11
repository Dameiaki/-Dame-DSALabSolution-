package com.Gl.MentoredLabSession3.Question2;

import java.util.ArrayList;
import java.util.List;

class Node {
	int nodeData;
	Node leftNode, rightNode;

	Node(int val) {
		nodeData = val;
		leftNode = rightNode = null;
	}
}

public class LongestPath {
	List<Integer> longestPath = new ArrayList<>();

	public static ArrayList<Integer> longestPath(Node root) {
		if (root == null) {
			ArrayList<Integer> path = new ArrayList<>();
			return path;
		}

		ArrayList<Integer> left = longestPath(root.leftNode);
		ArrayList<Integer> right = longestPath(root.rightNode);

		if (right.size() > left.size()) {
			right.add(root.nodeData);

		} else {
			left.add(root.nodeData);
		}

		return (left.size() > right.size() ? left : right);

	}

	public static void main(String[] args) {

		Node root = new Node(100);

		Node node1 = new Node(20);
		Node node2 = new Node(130);
		Node node3 = new Node(10);
		Node node4 = new Node(50);
		Node node5 = new Node(110);
		Node node6 = new Node(140);
		Node node7 = new Node(5);

		node3.leftNode = node7;

		node1.leftNode = node3;
		node1.rightNode = node4;

		node2.leftNode = node5;
		node2.rightNode = node6;

		root.leftNode = node1;
		root.rightNode = node2;

		ArrayList<Integer> path = longestPath(root);
		System.out.print(path.get(path.size() - 1));
		for (int i = path.size() - 2; i >= 0; i--) {
			System.out.print("--> " + path.get(i));

		}

	}

}

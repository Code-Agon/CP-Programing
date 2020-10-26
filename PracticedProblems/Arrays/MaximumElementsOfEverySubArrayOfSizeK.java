/**
Given an array arr[] of size N and an integer K. Find the maximum for each and every contiguous subarray of size K.

Example 1:

Input:
9 3
1 2 3 1 4 5 2 3 6

Output: 
3 3 4 5 5 5 6 

**/
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class CodeClass {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			ArrayList<Integer> res = max_of_subarrays(arr, n, k);
			for (int i = 0; i < res.size(); i++)
				System.out.print(res.get(i) + " ");
			System.out.println();
		}
	}

	static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
		ArrayList<Integer> list = new ArrayList<>();
		Deque<Integer> stack = new LinkedList<Integer>();
		int sum = 0, j;
		for (j = 0; j < k; ++j) {
			while (!stack.isEmpty() && arr[j] >= arr[stack.peekLast()]) {
				stack.removeLast();
			}
			stack.addLast(j);
		}
		list.add(arr[stack.peekFirst()]);
		for (; j < n; j++) {

			while ((!stack.isEmpty()) && stack.peek() <= j - k)
				stack.removeFirst();

			while (!stack.isEmpty() && arr[j] >= arr[stack.peekLast()]) {
				stack.removeLast();
			}
			stack.addLast(j);
			list.add(arr[stack.peekFirst()]);

		}
		return list;
	}
}

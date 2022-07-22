import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class AuthorSolution {
	
	public static void main(String[] args) {	
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		T = fs.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int n = fs.nextInt();
			int x = fs.nextInt();
			int y = fs.nextInt();
			ArrayList<Integer> ans = new ArrayList<>();
			for (int d = 1; d <= y - x; d++) {
				if ((y - x) % d != 0) {
					continue;
				}
				ArrayList<Integer> res = new ArrayList<>();
				boolean foundX = false;
				int cur = y;
				int need = n;
				while (cur >= 1 && need > 0) {
					res.add(cur);
					if (cur == x) {
						foundX = true;
					}
					--need;
					cur -= d;
				}
				cur = y;
				while (need > 0) {
					cur += d;
					res.add(cur);
					--need;
				}
				Collections.sort(res);
				if (need == 0 && foundX) {
					if (ans.isEmpty() || ans.get(ans.size() - 1) > res.get(res.size() - 1)) {
						ans = res;
					}
				}
			}
			for (int num : ans) {
				out.print(num + " ");
			}
			out.println();
		}
		out.close();
	}
	
	static void sort(int[] a) {
		ArrayList<Integer> arr = new ArrayList<>();
		for (int x : a) {
			arr.add(x);
		}
		Collections.sort(arr);
		for (int i = 0; i < a.length; i++) {
			a[i] = arr.get(i);
		}
	}
	
	static void swap(int[] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}

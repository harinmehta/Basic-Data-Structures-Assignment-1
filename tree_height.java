// package com.basicDS;
import java.util.*;
import java.io.*;

public class tree_height {
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class TreeHeight {
		int n;
		int parent[];
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
			}
		}

		int computeHeight2() {
                        // Replace this code with a faster implementation
			int maxHeight = 0;
			for (int vertex = 0; vertex < n; vertex++) {
				int height = 0;
				for (int i = vertex; i != -1; i = parent[i])
					height++;
				maxHeight = Math.max(maxHeight, height);
			}
			return maxHeight;
		}
		
		int computeHeight() {
			
			int root = 0;
			Map<Integer, List<Integer>> map = new HashMap<>();
			
			for(int vertex = 0; vertex < n; vertex ++) {
				
				if(parent[vertex] == -1) {
					root = vertex;
				}
				else {
					List<Integer> children;
					
					if(map.containsKey(parent[vertex])) {
						children = map.get(parent[vertex]);
					}
					else
						children = new ArrayList<>();
					
					children.add(vertex);
					
					map.put(parent[vertex], children);
				}
			}
			
			return 1 + height(root, map);
		}

		private int height(int root, Map<Integer, List<Integer>> map) {
			
			if(!map.containsKey(root)) return 0;
			
			int max = 1;
			
			for(int i = 0; i < map.get(root).size(); i++) {
				
				max = Math.max(max, 1 + height(map.get(root).get(i), map) );
				
			}
			
			return max;
		}
		
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}
package dfsbfs;

import java.io.*;
import java.util.*;

public class buildBFS {
	public static StringBuilder sb = new StringBuilder();
	public static boolean[] visited;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	
	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		// 시작노드 큐에 넣으면서 방문처리 
		q.offer(x);
		visited[x] = true;
		
		// 큐가 빌 때까지 
		while(!q.isEmpty()) {
			// 하나 빼면서 출력하고 , 인접 노드들 큐에 넣으면서 방문처리 
			int n = q.poll();
			sb.append(n + " ");
			for(int i=0; i<graph.get(n).size(); i++) {
				int y = graph.get(n).get(i);
				if(!visited[y]) {
					q.offer(y);
					visited[y] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 노드 개수 N 입력 받기 
		int N = Integer.parseInt(br.readLine());
		
		// 방문 표시 배열 세팅 
		visited = new boolean[N+1];
		
		// graph 세팅 - 비어있는 0번째 노드 
		graph.add(new ArrayList<Integer>());
		// graph 세팅 - 인접노드 입력받는대로 배열에 넣기 
		while(N-->0) {
			st = new StringTokenizer(br.readLine(), " ");
			ArrayList<Integer> nodes = new ArrayList<Integer>();
			while(st.hasMoreTokens()) nodes.add(Integer.parseInt(st.nextToken()));
			graph.add(nodes);
		}
		
		// bfs 호출 
		bfs(1);
		System.out.println(sb.toString());
	}
	
}

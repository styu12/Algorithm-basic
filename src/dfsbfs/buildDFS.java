package dfsbfs;

import java.io.*;
import java.util.*;

public class buildDFS {
	public static boolean[] visited;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	
	// dfs 함수 정의 
	public static void dfs(int x) {
		// 현재 노드 방문처리 
		visited[x] = true;
		System.out.print(x + " ");
		
		// 현재 노드와 연결된 다른 노드를 재귀적으로 방문 
		for(int i=0; i<graph.get(x).size(); i++) {
			int y = graph.get(x).get(i);
			if(!visited[y]) dfs(y);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 노드 개수 N 입력 
		int N = Integer.parseInt(br.readLine());
		
		// 방문 표시 배열 세팅 
		visited = new boolean[N+1];
		
		// 인접 노드 입력받으면서 그래프 세팅 
		// 0번 노드 채우기 -> 인덱스 직관적으로 
		graph.add(new ArrayList<Integer>());
		while(N-->0) {
			st = new StringTokenizer(br.readLine(), " ");
			ArrayList<Integer> nodes = new ArrayList<Integer>();
			while(st.hasMoreTokens()) nodes.add(Integer.parseInt(st.nextToken()));
			graph.add(nodes);
		}
		
		dfs(1);
	}
}




//package dfs;
//
//import java.io.*;
//import java.util.*;
//
//public class buildDFS {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		
//		// 노드 개수 입력 
//		int N = Integer.parseInt(br.readLine());
//		
//		ArrayList<Integer>[] graph = new ArrayList[N+1];
//		boolean[] visited = new boolean[N+1];
//		
//		// 연결된 노드들 입력 (그래프) 
//		for(int i=1; i<=N; i++) {
//			st = new StringTokenizer(br.readLine(), " ");
//			graph[i] = new ArrayList<Integer>();
//			while(st.hasMoreTokens()) graph[i].add(Integer.parseInt(st.nextToken()));
//		}
//		
//		dfs(1, graph, visited);
//	}
//	
//	public static void dfs(int x, ArrayList<Integer>[] graph, boolean[] visited) {
//		visited[x] = true;
//		System.out.print(x + ", ");
//		
//		for(int i=0; i<graph[x].size(); i++) {
//			if(!visited[graph[x].get(i)]) dfs(graph[x].get(i), graph, visited);
//		}
//	}
//}

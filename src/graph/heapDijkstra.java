package graph;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
	int index;
	int distance;
	
	public Node(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}
	
	public int compareTo(Node o) {
		return this.distance - o.distance;
	}
}

public class heapDijkstra {

	public static final int INF = (int)1e9; // 무한대 의미하는 값으로 10억 설정 
	// 노드 n개, 간선 m개, 시작노드번호 start 
	public static int n, m, start;
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	// 최단거리 테이블 
	public static int[] d;
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		// 시작점 거리 초기화 및 큐에 넣기  
		d[start] = 0;
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) { // 큐가 비어있지 않다면 
			// 최단거리가 가장 짧은 노드 꺼내기 
			Node node = pq.poll();
			int dist = node.distance; // 현재 노드까지의 비용 
			int now = node.index; // 현재 노드 
			// 현재 노드가 이미 처리된 적 있는 노드라면 무시 
			if(d[now]<dist) continue;
			// 현재 노드와 연결된 인접노드 확인 
			for(int i=0; i<graph.get(now).size(); i++) {
				int cost = d[now] + graph.get(now).get(i).distance;
				// 현재 노드를 거쳐서, 다른 노드로 가는 거리가 더 짧을 때 
				if(cost < d[graph.get(now).get(i).index]) {
					d[graph.get(now).get(i).index] = cost;
					pq.offer(new Node(graph.get(now).get(i).index, cost));
				}
			}
		}
	
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// n, m, start 입력받기 
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		// graph, d 세팅 
		for(int i=0; i<=n; i++) graph.add(new ArrayList<Node>());
		d = new int[n+1];
		
		// 간선정보 입력받기 
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			// a에서 b로 가는 비용이 c 
			graph.get(a).add(new Node(b,c));
		}
		
		// 최단거리 배열 모두 INF로 초기화 
		Arrays.fill(d, INF);
		
		// 다익스트라 알고리즘 수행 
		dijkstra(start);
		
		for(int i=1; i<=n; i++) {
			if(d[i] == INF) {
				System.out.println("INFINITE");
			}	else {
				System.out.println(d[i]);
			}
		}
	}
}

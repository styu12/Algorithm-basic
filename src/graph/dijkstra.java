package graph;

import java.io.*;
import java.util.*;

//class Node {
//	int index;
//	int distance;
//	
//	public Node(int index, int distance) {
//		this.index = index;
//		this.distance = distance;
//	}
//}

public class dijkstra {
	
	public static final int INF = (int)1e9; // 무한을 의미하는 값으로 10억 설정 
	// 노드 n개, 간선 m개, 시작노드번호 start
	// 노드의개수는 최대 100,000개라고 가정 
	public static int n, m, start;
	// 노드 연결정보 담는 graph 
	// 연결 정보에 distance(간선의 비용)도 들어가기 때문에 Integer가 아닌 Node를 담는 ArrayList 
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	public static boolean[] visit;
	
	// 최단 거리 테이 
	public static int[] d;
	
	// 방문하지 않은 노드 중에서, 가장거리가 짧은 노드를 반환 
	public static int getSmallestNode() {
		int min_value = INF;
		int index = 0; // 가장 최단거리가 짧은 노드의 인덱스 
		for(int i=1; i<=n; i++) {
			if(d[i] < min_value && !visit[i]) {
				min_value = d[i];
				index = i;
			}
		}
		return index;
	}
	
	public static void dijkstra(int start) {
		// 시작노드 0으로 거리 초기화 및 방문처리 
		d[start] = 0;
		visit[start] = true;
		// 시작노드의 인접노드 거리 초기화 
		for(int i=0; i<graph.get(start).size(); i++) {
			d[graph.get(start).get(i).index] = graph.get(start).get(i).distance;
		}
		
		// 시작노드를 제외한 전체 n-1개의 노드에 대해 반복
		for(int i=0; i<n-1; i++) {
			// 현재 가장 거리가 짧은 노드를 꺼내, 방문처리 
			int now = getSmallestNode();
			visit[now] = true;
			// 현재노드와 연결된 인접노드 확인 
			for(int j=0; j<graph.get(now).size(); j++) {
				int cost = d[now] + graph.get(now).get(j).distance;
				// 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우 
				if(cost < d[graph.get(now).get(j).index]) {
					d[graph.get(now).get(j).index] = cost;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		// graph 세팅 인덱스는 1~n 
		for(int i=0; i<n+1; i++) {
			graph.add(new ArrayList<Node>());
		}
		// 방문처리 배열 & 거리배열 세팅  인덱스는 1~n 
		visit = new boolean[n+1];
		d = new int[n+1];
		
		// 간선정보 입력 (m개) 
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			// a에서 b로 가는 거리가 c이다. 
			graph.get(a).add(new Node(b, c));
		}
		
		// 거리 배열은 전부 INF로 초기화 
		Arrays.fill(d, INF);
		
		// 다익스트라 알고리즘 수행 
		dijkstra(start);
		
		// 모든 노드로 가는 최단거리 출력
		for(int i=1; i<=n; i++) {
			// 갈 수 없는경우 INFINITY 출력 
			if(d[i] == INF) {
				System.out.println("INFINITY");
			} 	else {
				System.out.println(d[i]); // 갈 수 있으면 거리 출력 
			}
		}
	}
	
}

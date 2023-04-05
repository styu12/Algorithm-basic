/*
 * N개의 도시가 있다. 도시 간에 전보를 보낼 수 있다.  
 * X에서 Y로 전보를 보내려면 통로로 연결되어 있어야 하고, 각 통로는 일정 시간이 소요된다. 
 * C라는 도시에서 전보를 보낼 때 최대한 많이 퍼뜨릴 것이다. 
 * 이 때 C의 메세지를 받게 될 도시는 총 몇개이며, 모든 도시가 메세지를 받을 때까지 걸리는 시간은 얼마인가 
 * 
 * 도시의 개수 N, 통로개수 M, 메세지 보내려는 도시 C
 * (1 <= N <= 30,000) (1<=M<=200,000) (1<=C<=N)
 * 
 * 메세지 받는 도시의 총 개수와, 총 걸리는 시간 출력 
 * inputs							output 
 * 3 2 1							2 4
 * 1 2 4
 * 1 3 2 
 */

package graph;

import java.io.*;
import java.util.*;

class Node2 implements Comparable<Node2> {
	int index;
	int distance;
	
	public Node2(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}
	
	public int compareTo(Node2 o) {
		if(this.distance == o.distance) return this.index - o.index;
		return this.distance - o.distance;
	}
}

public class Sol1 {
	
	public static final int INF = (int)1e9; // 무한을 의미하는 값으로 10억 설정 
	public static int n, m; // 노드 n개, 간선 m개 
	public static ArrayList<ArrayList<Node2>> graph = new ArrayList<ArrayList<Node2>>();
	public static int[] d; // 최단거리 담는 배열 

	// 힙 다익스트라 
	public static void dijkstra(int start) {
		PriorityQueue<Node2> pq = new PriorityQueue<>();
		// 시작점은 거리 0으로 초기화하고 큐에 넣자 
		d[start] = 0;
		pq.offer(new Node2(start, 0));
		
		while(!pq.isEmpty()) {
			Node2 node = pq.poll(); // 제일 가까운 노드 뽑아 
			int index = node.index;
			int dist = node.distance;
			
			if(dist > d[index]) continue; // 이미 처리된 노드면 패스 
			
			//인접노드 확인 
			for(int i=0; i<graph.get(index).size(); i++) {
				int cost = d[index] + graph.get(index).get(i).distance;
				if(cost < d[graph.get(index).get(i).index]) {
					d[graph.get(index).get(i).index] = cost;
					pq.offer(new Node2(graph.get(index).get(i).index, cost));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// n, m, c 입력받기 
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		// graph, d 배열 세팅 (인덱스는 1~n) 
		for(int i=0; i<=n; i++) graph.add(new ArrayList<Node2>());
		d = new int[n+1];
		Arrays.fill(d, INF); // 전부 무한대로 세팅 
		
		// 간선 입력받기
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			// a에서 b로 가는 거리가 c 이다. 
			graph.get(a).add(new Node2(b, c));
		}
		
		// 다익스트라 알고리즘 수행 
		dijkstra(start);
		
		int cnt=0; int max=0;
		// d 돌면서 갈 수 있는 도시 개수와 최대 시간 출력 
		for(int i=2; i<=n; i++) {
			if(d[i] != INF) {
				cnt++;
				max = Math.max(max, d[i]);
			}
		}
		sb.append(cnt).append(" ").append(max);
		System.out.println(sb.toString());
	}
}

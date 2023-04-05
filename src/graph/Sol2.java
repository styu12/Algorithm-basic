/*
 * 미래도시에는 1번부터 N번까지의 도시가 있다. 회사끼리는 서로 도로로 연결되어 있다. 
 * 방문판매원 A는 현재 1번에 위치해 있으며, X번 회사에 방문에 물건을 판매하려 한다. 
 * 회사끼리의 도로는 양방향 도로이며, 정확히 1만큼의 시간이 소요된다. 
 * 소개팅에도 참석하기 위해 1 -> K -> X  순서로 회사를 방문하려한다. 
 * 이동 최소 시간을 계산하라 
 * 
 * 회사개수 N, M (1<=N,M<=100) 
 * M개의 줄에 걸쳐 도로 정보 주고, 마지막 줄에는 X와 K가 주어진다. (1<=K<=100) 
 * 최소시간을 출력하고, 방문할 수 없다면 -1을 출력하라 
 * 
 * input 					output
 * 5 7						3
 * 1 2
 * 1 3
 * 1 4
 * 2 4
 * 3 4
 * 3 5
 * 4 5
 * 4 5
 * 
 */
package graph;

import java.io.*;
import java.util.*;

public class Sol2 {

	public static final int INF = (int)1e9;
	public static int n,m,x,k;
	public static int[][] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 노드 n개, 간선 m개 
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// graph 세팅 (전부 거리 무한대로 초기화) 
		graph = new int[n+1][n+1];
		for(int i=0; i<=n; i++) Arrays.fill(graph[i], INF);
		for(int i=1; i<=n; i++) graph[i][i] = 0; // 자기 자신한테 거리는 0으로 초기화 
		
		// 간선정보 받기 
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 양방향 연결정보 그래프에 넣기 a->b b->a 모두 1  
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		// 플로이드 워셜 알고리즘 수행  i->t->j 확인하면서 최소 거리 업데이트 
		for(int t=1; t<=n; t++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][t] + graph[t][j]);
				}
			}
		}
		
		// x, k 입력받기 
		st = new StringTokenizer(br.readLine(), " ");
		x = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		if(graph[1][k] != INF && graph[k][x] != INF) {
			System.out.println(graph[1][k] + graph[k][x]);
		}	else {
			System.out.println(-1);
		}
	}
}

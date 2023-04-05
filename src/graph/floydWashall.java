package graph;

import java.io.*;
import java.util.*;

// 플로이드 워셜은 노드의 개수가 보통 500개 이하일 때만 사용할 수 있다. ( 안 그러면 시간 초과)  
public class floydWashall {

	public static final int INF = (int)1e9; // 무한을 의미하는 값으로 10억 설정 
	// 노드 n개, 간선 m개 
	public static int n, m;
	public static int[][] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// n,m 입력받기 
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// graph 세팅 인덱스는 1~n 
		graph = new int[n+1][n+1];
		
		// 거리값 전부 INF로 초기화 - 2차원 배열이니까 바로 fill 못 씀 
		for(int i=0; i<n+1; i++) {
			Arrays.fill(graph[i], INF);			
		}
		
		// 자기 자신으로 향하는 거리는 0으로 초기
		for(int i=1; i<=n; i++) {
			graph[i][i] = 0;
		}
		
		// 간선 정보 입력받기 
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			// a 에서 b로 가는 비용은 c이다. 
			graph[a][b] = c;
		}
		
		// 그래프 돌면서 플로이드 워셜 알고리즘 수행 
		// 모든 i->j 에 대해 i->k->j 랑 비교해서 작은 거리로 업데이트 (k를 들렀다 가는 길) 
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}
		
		// 수행결과 출력 
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(graph[i][j] == INF) {
					System.out.println("INFINITY");
				}	else {
					System.out.println(i + "->" + j + ": " + graph[i][j]);
				}
			}
		}
		
	}
}

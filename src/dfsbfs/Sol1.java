/*
 * N*M 크기의 얼음 틀
 * 구멍이 뚫려있으면 0, 막혀있으면 1 
 * 구멍이 뚫려있는 부분끼리 상,하,좌,우로 연결되어 있는 것으로 간주 
 * 얼음틀의 모양이 주어졌을 때 아이스크림의 개수를 출력 
 * 첫번재 줄에는 세로길이 N과 가로 길이 M이 주어짐 (1 <= N. M <= 1000)
 * input 		=> 		output
 * 4 5 
 * 00110					3
 * 00011
 * 11111
 * 00000
 */
package dfsbfs;

import java.io.*;

public class Sol1 {
	public static int N, M;
	public static int[][] graph;
	
	public static boolean dfs(int i, int j) {
		// graph를 벗어나면 즉시 종료  
		if(i<0 || i>N-1 || j<0 || j>M-1) return false;
		// 방문처리 하지 않았다면 
		if(graph[i][j] == 0) {
			// 방문처리 
			graph[i][j] = 1;
			// 상 하 좌 우 노드들 재귀적으로 호출  
			dfs(i-1, j);
			dfs(i+1, j);
			dfs(i, j-1);
			dfs(i, j+1);
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		
		// row, col 입력받기 
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);
		
		// graph 초기화 
		graph = new int[N][M];
		
		// 문자열 입력받으면서 각각 graph에 넣어주기 
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				graph[i][j] = str.charAt(j)-'0';
			}
		}
		
		int ans = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				// dfs가 true를 반환할 때(얼리기가 시작된 후 다 얼리고 true를 리턴 )만 카운트 
				if(dfs(i, j)) {
					ans++;
				}
			}
		}
		
		System.out.println(ans);
	}
}

/*
 * NxM 크기의 금광이 있다. 각 칸 별로 특정한 크기의 금이 들어있다. 
 * 채굴자는 첫번째 열부터 출발하여 금을 캐기 시작. 맨 처음에는 첫번째 열의 어느 행에서든 출발 가능
 * 이후에 m-1번에 걸쳐서 매번 오른쪽 위, 오른쪽, 오른쪽 아래 3가지 중 하나의 위치로 이동 
 * 채굴자가 얻을 수 있는 금의 최대 크기 출력 
 * 
 * 첫째 줄에 테스트케이스 T 입력 ( 1 <= T <= 1000)
 * n,m 입력 (1 <= n,m <= 20). 매장된 금의 개수 공백으로 구분되어 입력  (1 <= 금 <= 100) 
 * 
 * inputs 							=> 			outputs
 * 2											19
 * 3 4 											16					
 * 1 3 3 2 2 1 4 1 0 6 4 7
 * 4 4 
 * 1 3 1 5 2 2 4 1 5 0 2 3 0 6 1 2
 */

package dp;

import java.io.*;
import java.util.*;

public class Sol4 {

	public static int[][] graph;
	// 방향벡터 
	public static int[] dx = {-1, 0, 1};
	public static int[] dy = {-1, -1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			st = new StringTokenizer(br.readLine(), " ");
			
			// NxM 
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			// graph 세팅
			graph = new int[n][m];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 열 먼저 돌면서 최대 금값으로 덮어씌우기 
			for(int y=0; y<m; y++) {
				for(int x=0; x<n; x++) {
					int prev = 0;
					// 방향벡터 돌면서 직전열 최적값 확인 
					for(int k=0; k<3; k++) {
						int nx = x + dx[k];
						int ny = y + dy[k];
						// 범위 벗어나면 패스 
						if(nx<0 || nx>n-1 || ny<0 || ny>m-1) continue;
						// prev를 직전열 최적값 중 최대인 놈으로 갱신 
						prev = Math.max(prev, graph[nx][ny]);
					}
					// 현재 칸 최적값으로 갱신 
					graph[x][y] += prev;
				}
			}
			
			// 마지막 열 중 최대값을 답으로 출력
			int ans = 0;
			for(int i=0; i<n; i++) {
				ans = Math.max(ans, graph[i][m-1]);
			}
			sb.append(ans).append("\n");
			
		}
		
		System.out.println(sb.toString());
	}
	
}

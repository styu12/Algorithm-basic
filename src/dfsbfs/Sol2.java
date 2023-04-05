/*
 * 동빈이는 NxM 크기의 직사각형 미로에 갇혀있다. 미로에 있는 괴물들을 피해 탈출해야 한다. 
 * 출발 위치는 (1,1) 이며 출구는 (N,M) 이다. 한번에 한 칸 씩 이동
 * 괴물이 있으면 0 없으면 1로 표시. 반드시 탈출할 수 있는 형태로 제시
 * 탈출하기 위해 움직여야 하는 최소 칸의 개수 출력. 칸을 셀 때는 시작 칸과 마지막 칸을 모두 포함하여 계산 
 * 두 정수 N,M 이 주어지고 (4 <= N,M <= 200) 미로의 정보가 주어짐 (시작 칸과 마지막 칸은 모두 1이다. )
 * input	 			output
 * 5 6 			=>		10
 * 101010					
 * 111111
 * 000001
 * 111111
 * 111111
 */

package dfsbfs;

import java.io.*;
import java.util.*;

// 칸을 나타내는 Node 클래스 - x,y 좌표 
class Node {
	public int x;
	public int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Sol2 {

	public static int n,m;
	public static int[][] graph;
	
	// 이동 벡터 (상,하,좌,우)  
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static void bfs(int a, int b) {
		// Node 담는  큐 생성 
		Queue<Node> q = new LinkedList<>();
		// 출발 노드 담기 
		q.offer(new Node(a,b));
		while(!q.isEmpty()) {
			// 현재 노드 큐에서 꺼내기 
			Node curNode = q.poll();
			// 인접노드(상,하,좌,우)  큐에 담으면서 방문처리(경로수로 갱신 )
			for(int i=0; i<4; i++) {
				int nx = curNode.x + dx[i];
				int ny = curNode.y + dy[i];
				// 범위 벗어나면 패스 
				if(nx<0 || nx>n-1 || ny<0 || ny>m-1) continue;
				// 괴물 있는 곳이면 패스 
				if(graph[nx][ny] == 0) continue;
				// 처음 가는 곳 (방문 안한 곳만) 체크 
				if(graph[nx][ny] == 1) {
					// 큐에 넣고, 방문처리(이전 노드 값이랑 합치기)  
					q.offer(new Node(nx, ny));
					graph[nx][ny] += graph[curNode.x][curNode.y];
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		
		// n, m 입력 
		n = Integer.parseInt(inputs[0]);
		m = Integer.parseInt(inputs[1]);
		
		// graph 만들고  
		graph = new int[n][m];
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				graph[i][j] = str.charAt(j)-'0';
			}
		}
		
		// 출발점에서 bfs 호출 
		bfs(0,0);
		// 경로수로 노드 각각 갱신했으니 마지막 종점노드의 값 출력 
		System.out.println(graph[n-1][m-1]);
	}
}

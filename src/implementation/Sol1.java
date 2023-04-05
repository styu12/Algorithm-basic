/*
 * 여행가 A는 NxN 크기의 정사각형 위에 서 있음 
 * 가장 왼쪽 위 좌표는 (1,1) 가장 오른쪽 아래 좌표는 (N,N)이다 
 * 상, 하, 좌, 우 방향으로 움직일 수 있으며 시작좌표는 항상 (1,1) 이다 
 * 계획서를 보며 여행가를 움직인다. 
 * L: 왼쪽 1칸 R: 오른쪽 1칸 U: 위쪽 1칸 D: 아래쪽 1칸 
 * NxN 크기를 벗어나는 움직임은 무시된다.
 * N과 여행계획이 주어졌을 때 최종 도착좌표를 출력해라  
 * input				output 
 * 5					3 4
 * R R R U D D
 */

package implementation;

import java.io.*;

public class Sol1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] moves = br.readLine().split(" ");
		// 출발점 
		int x=1, y=1;
		
		
		// L R U D 에 따른 이동방
		int[] dx = {0, 0, -1, 1};
		int[] dy = {-1, 1, 0, 0};
		char[] moveTypes = {'L', 'R', 'U', 'D'};
		
		// 이동계획 하나씩 확인 
		for(int i=0; i<moves.length; i++) {
			char move = moves[i].charAt(0);
			int nx=-1, ny=-1;
			// 이동 후 좌표 구하기 
			for(int j=0; j<4; j++) {
				if(move == moveTypes[j]) {
					nx = x + dx[j];
					ny = y + dy[j];
				}
			}
			// 공간 벗어나는 경우 무시 
			if(nx<1 || nx>N || ny<1 || ny>N) continue;
			// 이동 수행 
			x=nx; y=ny;
		}
		
		System.out.println(x + " " + y);
	}
}

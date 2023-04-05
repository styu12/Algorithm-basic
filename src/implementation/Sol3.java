/*
 * 첫째줄에 8x8 좌표 평면상에서 현재 나이트가 위치한 곳의 좌표를 나타내는 두 문자로 구성된 문자열이 입력된다. 
 * 입력문자는 a1처럼 열과 행으로 이뤄진다. (열: a~h, 행: 1~8)
 * 나이트가 이동할 수 있는 경우의 수를 출력하시오 
 * input 		output
 * a1			2
 */

package implementation;

import java.io.*;

public class Sol3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		// 행 열 둘다 0~7 정수로 변환 -> 인덱스로 쓰게 
		int x = input.charAt(1) - '0' - 1;
		int y = input.charAt(0) - 'a';
		
		// 이동가능 케이스 배열
		int[] dx = {-1, -1, 1, 1, -2, -2, 2, 2};
		int[] dy = {-2, 2, -2, 2, -1, 1, -1, 1};
		
		int cnt = 0;
		// 이동가능 케이스 돌면서 카운트 
		for(int i=0; i<8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 8x8 넘어가면 무시 
			if(nx<0 || nx>7 || ny<0 || ny>7) continue;
			// 경우의수 증가 
			cnt++;
		}
		System.out.println(cnt);
	}
}

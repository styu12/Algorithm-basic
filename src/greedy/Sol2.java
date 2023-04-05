/*
 *  각 자리가 숫자 (0~9)로만 이루어진 문자열 S가 주어졌을 때 
 *  왼쪽부터 오른쪽으로 하나씩 순서대로 + 혹은 *의 연산 실행 (곱셈 먼저 하는 거 아니야) 
 *  연산 결과의 최댓값을 구해라  
 */

package greedy;

import java.io.*;

public class Sol2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		long ans = input.charAt(0) - '0';
		// 0 이랑 1 만 덧셈!! 나머지는 곱셈!! 
		for(int i=1; i<input.length(); i++) {
			int num = input.charAt(i) - '0';
			if(ans <= 1 ||  num <= 1) {
				ans += num;
			}	else {
				ans *= num;
			}
		}
		
		System.out.println(ans);
	}
}

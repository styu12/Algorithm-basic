/*
 * 정수 x가 주어졌을 때, 사용할 수 있는 연산은 4가지
 * 1. x가 5로 나누어떨어지면, 5로 나눈다.
 * 2. x가 3으로 나누어떨어지면, 3으로 나눈다.
 * 3. x가 2로 나누어떨어지면, 2로 나눈다.
 * 4. x에서 1을 뺀다. 
 * 정수 x가 주어졌을 때 1로 만들기 위한 연산의 최소 횟수를 출력하라 
 * 1 <= x <= 30000      
 * input			output 
 * 26					3
 */

package dp;

import java.io.*;

public class Sol2 {

	public static int[] d;
	public static int x;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		x = Integer.parseInt(br.readLine());
		d = new int[x+1];
		
		d[1] = 0;
		// dp 배열 채우기 
		for(int i=2; i<=x; i++) {
			// 1 빼는 연산 
			int tmp = d[i-1] + 1;
			// 2로 나누는 연산 
			if(i % 2 == 0) tmp = Math.min(tmp,  d[i/2]+1);
			// 3으로 나누는 연산 
			if(i % 3 == 0) tmp = Math.min(tmp, d[i/3]+1);
			// 5로 나누는 연산
			if(i % 5 == 0) tmp = Math.min(tmp, d[i/5]+1);
			d[i] = tmp;
		}
		
		System.out.println(d[x]);
	}
}

/*
 * N가지 종류의 화폐 -> 최소한으로 이용해서 M원이 되도록 한다.
 * N개의 화폐 정보가 주어졌을 때, M원을 만들 수 있는 최소한의 화폐개수를 출력 (만들 수 없으면 -1 출력)  
 * 0 <= N <= 100  1 <= M <= 10000
 * input 				output
 * 2 15		=>		5
 * 2 
 * 3		
 * 
 * 3 4		=> 		-1 
 * 3 
 * 5
 * 7		
 * 
 * 풀이 시간복잡도 : N*M => 10^6 정도 			
 */

package dp;

import java.io.*;
import java.util.*;

public class Sol3 {

	public static int[] d;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		
		// 화폐 n개 -> m원  
		int n = Integer.parseInt(inputs[0]);
		int m = Integer.parseInt(inputs[1]);
		
		// 화폐정보 세팅 
		int[] coins = new int[n];
		for(int i=0; i<n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		// dp 배열 세팅
		// 일단 전부 -1로 초기화
		d = new int[m+1]; 
		Arrays.fill(d, -1);
		
		d[0] = 0; // 0원은 0의 최적값  
		
		final int NO = 10000;
		// 1원부터 m원까지 최적값 갱신 
		for(int i=1; i<=m; i++) {
			// 가능한 화폐별로 직전 최적값 확인
			int tmp = NO;
			for(int j=0; j<n; j++) {
				int coin = coins[j];
				if(i>=coin && d[i-coin] != -1) tmp = Math.min(tmp, d[i-coin]+1);
			}
			// 직전 최적값이 아예 없으면 -1, 있으면 그 중 최소값 
			if(tmp == NO) d[i]=-1;
			else d[i]=tmp;
		}
		
		System.out.println(d[m]);
	
		
		
	}
}

/*
 * N명의 병사가 무작위로 나열. 병사들은 특정한 값의 전투력 보유 
 * 병사 배치할 때는 전투력 기준 내림차순 정렬할 것. 
 * 배치방법 : 특정 위치에 있는 병사 열외 + 그러면서도 남아있는 병사 수 최대로  
 * => 남아있는 병사 수를 최대가 되도록 하기 위해 열외시켜야 하는 병사 수 출력 
 * 
 * 첫째 줄에 병사수 N (1 <= N <= 2000) & 둘째 줄에 병사의 전투력 공백 기준으로 주어짐 (전투력은 10,000,000 보다 작거나 같은 자연수)  
 * input 						output
 * 7							2
 * 15 11 4 8 5 2 4
 */

package dp;

import java.io.*;
import java.util.*;

public class Sol5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 병사수 n 
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 병사수 배열 세팅 
		int[] soldiers = new int[n];
		for(int i=0; i<n; i++) {
			soldiers[i] = Integer.parseInt(st.nextToken());
		}
		
		// dp배열 세팅 
		int[] d = new int[n];
		Arrays.fill(d, 1); // 혼자서 수열 이룰 때 길이가 1이므로 디폴트 : 1
		// 병사 배열 돌면서 dp배열 업데이트 - 각 병사를 마지막 병사로 했을 때 가장 긴 부분수열 길이 저장!! 
		for(int i=0; i<n; i++) {
			// 현재 병사 이전의 다른 병사들의 dp 최적값 중 최대를 찾기 
			for(int j=0; j<i; j++) {
				// 내림차순 조건이 만족된다면 
				if(soldiers[j] >= soldiers[i]) {
					d[i] = Math.max(d[i], d[j]+1);
				}
			}
		}
		
		
		// 예외 병사 수 출력 - 즉, 가장긴 부분수열과 원래수열 간 길이 차이
		int max = 0;
		for(int i=0; i<n; i++) {
			max = Math.max(max, d[i]);
		}
		System.out.println(n-max);
		
	}
}

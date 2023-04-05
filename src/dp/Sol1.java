/*
 * 개미전사가 식량창고를 공격해서 식량을 뺏어온다. 
 * 식량창고는 일직선으로 이어져 잇다. 
 * 창고마다 정해진 양의 식량이 있고, 서로 인접한 식량창고는 공격할 수 없다. 
 * => 최소한 한 칸 이상 떨어진 식량창고를 공격해야 한다. 
 * 식량창고 N개에 대한 정보가 주어졌을 때, 얻을 수 있는 식량의 최댓값 출력 
 * 3 <= N <= 100, 식량개수 0 <= K <= 1000 
 * input				out 
 * 4					8
 * 1 3 1 5
 */

package dp;

import java.io.*;
import java.util.*;

public class Sol1 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 식량창고 n개 
		int n = Integer.parseInt(br.readLine());
		
		// 창고배열 세팅 
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// dp 세팅 
		int[] d = new int[n];
		d[0] = arr[0];
		d[1] = Math.max(arr[0], arr[1]);
		
		for(int i=2; i<n; i++) {
			d[i] = Math.max(d[i-1], d[i-2]+arr[i]);
		}
		
		System.out.println(d[n-1]);
	}
}

/*
 * 두 개의 배열 A, B 가 있다. N개의 원소로 구성되어 있으며, 모두 자연수이다. 
 * 최대 K번의 바꿔치기 연산 가능 (A B 원소 서로 바꾸기 )  
 * 최종목표는 A 배열 합을 최대로 만드는 것 
 * 최대 K번의 바꿔치기를 통해 만들 수 있는 A 배열 원소의 최댓값을 출력하라 (첫째줄에는 N과 K가 주어짐)  
 * 
 * input 			output
 * 5 3 					26
 * 1 2 5 4 3
 * 5 5 6 6 5
 */

package sorting;

import java.io.*;
import java.util.*;

public class So11 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 아이템 총 N개, 바꿔치기 최대 K번 
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		// 배열 a, b 
		Integer[] a = new Integer[n];
		Integer[] b = new Integer[n];
		
		// 배열 세팅 
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		// 배열 정렬 
		Arrays.sort(a);
		Arrays.sort(b, Collections.reverseOrder());
		
		// a의 최소값이 b의 최대값보다 작을 경우 바꿔치기 하자 (최대k번)  
		for(int i=0; i<n; i++) {
			// k번 다 썼으면 종료 
			if(k <= 0) break;
			
			// 바꿀 가치가 있으면 바꾸고, 아니면 바로 종료
			if(a[i] < b[i]) {
				int tmp = a[i];
				a[i] = b[i];
				b[i] = tmp;
				k--;
			}	else break;
		}
		
		// 합 구하기 
		int sum = 0;
		for(int i=0; i<n; i++) sum += a[i];
		System.out.println(sum);
	}
}

/*
 * N개의 원소를 포함한 수열이 오름차순 정렬되어 있음 
 * 이 수열에서 x가 등장하는 횟수를 계산 
 * (단, 시간복잡도 O(logN) 을 넘어갈 시 시간초과 판정) 
 *  첫째줄에 N과 x가 주어짐. 1 <= N <= 1,000,000  -10^9 <= x <= 10^9 
 *  둘째줄에 N개의 우너소 주어짐 => x의 개수 출력 
 *  (단 하나도 없다면 -1 출력) 
 *  input 				output
 *  7 2					4
 *  1 1 2 2 2 2 3 
 */

package binarySearch;

import java.io.*;
import java.util.*;

// x의 시작점을 찾는 이진탐색 한 번
// x의 끝점을 찾는 이직탐색 한 번 
// 총 두번의 이진탐색으로 해결 
public class Sol2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 원소 N개 , 찾는 원소 x
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 출발인덱스와 끝인덱스 담을 변수 
		int sIndex=0;
		int eIndex=0;
		
		int s=0; int e=n-1;
		while(s <= e) {
			// 중간지점 찾아 
			int q = (s+e) / 2;
			
			// x의 출발점 
			if(arr[q] == x && arr[q-1] != x) {
				sIndex = q;
				break;
			}
			
			// 작거나 같을 때 왼쪽 (출발점 찾으니까) 
			if(x <= arr[q]) e=q-1;
			else s=q+1; // 크면 오른쪽 
		}
		
		s=0; e=n-1;
		while(s <= e) {
			// 중간지점 찾아 
			int q = (s+e) / 2;
			
			// x의 끝점  
			if((arr[q] == x && q == n-1) ||  (arr[q] == x && arr[q+1] != x)) {
				eIndex = q;
				break;
			}
			
			// 작으면 왼쪽  
			if(x < arr[q]) e=q-1;
			else s=q+1; // 같거나 크면 오른쪽 (끝점 찾으니까)  
		}
		
		System.out.println(eIndex-sIndex+1);
	}
}

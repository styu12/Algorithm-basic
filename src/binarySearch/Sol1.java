/*
 * 떡볶이 떡 한번에 자르기
 * 절단기에 높이(H) 를 지정하면 줄지어진 떡을 한번에 절단. H보다 긴 떡은 H 윗부분의 떡이 잘려짐 
 * ex. 높이가 19, 14, 10, 17cm 인 떡이 나란히 있고 절단기 높이를 15로 지정하면 자른 뒤 
 *		남은 떡의 길이는 15, 14, 10, 15cm 가 될것.  
 * 		잘린 떡 길이는 4, 0, 0, 2cm -> 손님은 6cm를 가져감 
 * 손님이 왔을 때 요청한 길이가 총 M일 때, 적어도 M만큼의 떡을 얻기위한 절단기의 최대 높이를 출력 
 * 
 * 첫째 줄에 떡의 개수 N과 요청한 떡의 길이 M이 주어짐 (1<= N <= 1,000,000) (1 <= M <= 2,000,000,000)
 * 둘째 줄에는 떡의 개별 높이 주어짐 (손님은 항상 얻어갈 수 있는 양만큼만 요청 ) 높이는 0이상 10억 이하 정수 
 * input			output
 * 4 6 					15
 * 19 15 10 17 		
 */

// ############################ while 반복문 버전 #######################################

package binarySearch;

import java.io.*;
import java.util.*;

public class Sol1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 떡 개수 n개, 요청 길이 m 
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// 떡 배열 세팅 
		int[] ddeoks = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			ddeoks[i] = Integer.parseInt(st.nextToken());
		}
		
		// 이진탐색용 start, end 세팅 
		int s = 0;
		int e = (int)1e9; // 주어지는 떡 길이 최대 수 10억이니까
		
		// 길이 h 담아놓을 변수 
		int ans = 0;
		
		// 이진탐색 실행 - 멈추지말고 끝까지 
		while(s <= e) {
			// 중간지점에서 높이 찾기 
			int h = (s+e) / 2;
			
			// 떡 배열 돌면서 남는 떡 양 합하기 
			int sum = 0;
			for(int i=0; i<n; i++) {
				if(ddeoks[i] > h) sum += (ddeoks[i] - h); 
			}
			
			// 조건 만족하면 저장 & h 더 큰 쪽에서 탐색  
			if(sum >= m) {
				ans = h;
				s = h+1;
			}	else {
				// 만족 못하면 h 더 작은 쪽에서 탐색 
				e = h-1;
			}
		}
		
		System.out.println(ans);
	}
}



// ############################ 재귀적 호출 버전 #######################################

//package binarySearch;
//
//import java.io.*;
//import java.util.*;
//
//public class Sol1 {
//
//	public static int n,m; // 떡 n개, 요청길이 m 
//	public static int[] ddeoks; // 떡 길이 배열
//	public static int ans; // 높이 h를 저장해놓을 변수 
//	
//	
//	
//	// 특정 높이에서 조건 만족하는지 체크 
//	public static boolean check(int h) {
//		int sum = 0;
//		// 떡 배열 돌면서 남는 떡 길이 합하기 
//		for(int i=0; i<n; i++) {
//			if(ddeoks[i] > h) sum += (ddeoks[i]-h);
//		}
//		
//		// 요청길이 이상이면 true, 미만이면 false 
//		if(sum >= m) return true;
//		else return false;
//	}
//	
//	// 이진탐색 함수 - 중간에 멈추지 말고 전부 탐색할때까지 진행  
//	public static void binarySearch(int s, int e) {
//		if(s > e) return;
//		// 중간 지점 찾기 
//		int h = (s+e) / 2;
//		// 조건을 만족할 때 -> h 높여서 탐색 
//		if(check(h)) {
//			ans = h; // 현재 높이 저장 
//			binarySearch(h+1, e);
//		}	else {
//			// 조건 만족 못할 때 -> h 낮춰서 탐색,저장은 안 해  
//			binarySearch(s, h-1);
//		}
//	}
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		
//		// n, m 초기화 
//		n = Integer.parseInt(st.nextToken());
//		m = Integer.parseInt(st.nextToken());
//		
//		// 가장 긴 떡 길이 저장용변수 
//		int maxL = 0;
//		
//		// 떡 배열 초기화
//		ddeoks = new int[n];
//		st = new StringTokenizer(br.readLine(), " ");
//		for(int i=0; i<n; i++) {
//			int len = Integer.parseInt(st.nextToken());
//			ddeoks[i] = len;
//			maxL = Math.max(maxL, len);
//		}
//		
//		// 절단기 높이 이진탐색 진행 (0 ~ maxL-1)
//		binarySearch(0, maxL-1);
//		
//		System.out.println(ans);
//	}
//}

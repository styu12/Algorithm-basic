/*
 *  모험가가 N명 있는 마을
 *  공포도가 X인 모험가는 반드시 X명 이상의 그룹으로 모험을 떠나야 함
 *  모험을 떠날 수 있는 그룹 수의 최댓값을 구해라 
 *  (모든 모험가를 모험에 넣을 필요는 없다) 
 *  
 *  input : 2 3 1 2 2 -> output : 2개 그룹 
 */

package greedy;

import java.io.*;
import java.util.*;

public class Sol3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[] fears = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			fears[i] = Integer.parseInt(st.nextToken());
		}
		
		// 정렬 후 공포도가 낮은 애부터 순서대로 그룹 형성 
		// ex 1 1 2 2 2 2 2 3 3 3 3 4 5 6
		Arrays.sort(fears);
		
		int ans = 0;
		int cnt = 0;
 		for(int i=0; i<N; i++) {
 			cnt++;

 			if(cnt >= fears[i]) {
 				ans++;
 				cnt = 0;
 			}
 		}
		
		System.out.println(ans);
	}
}

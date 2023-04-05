/*
 * 정수 N이 입력되면 00시00분00초부터 N시59분59초까지의 모든 시각중에서 
 * 3이 하나라도 포함되는 모든 경우의 수를 출력해라
 * ex. 00시 03분 12초 / 00시 02분 30초 ... 
 * input N (0 ~ 23)		output
 * 5					11475
 */

package implementation;

import java.io.*;

public class Sol2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		// 최대 N시 59분 59
		// 시 0~N(h) , 분 0~59(m), 초 0~59(s)
		for(int h=0; h<=N; h++) {
			// 1의자리 혹은 10의자리에 3 등장 -> 60분 * 60초  -> 3600 플러스  
			if(h % 10 == 3) {
				cnt += 60*60;
				continue;
			}
			
			for(int m=0; m<60; m++) {
				// 1의자리 혹은 10의자리에 3등장 -> 60초 -> 60 플러스 
				if(m % 10 == 3 || m / 10 == 3) {
					cnt += 60;
					continue;
				}
				
				for(int s=0; s<60; s++) {
					// 1의자리 혹은 10의자리에 3등장 -> 1 플러스 
					if(s % 10 == 3 || s / 10 == 3) cnt++;
				}
				
			}
			
		}
		
		System.out.println(cnt);
		
	}
}

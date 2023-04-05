package greedy;

import java.io.*;

/*
 * N이 주어졌을 때 1. K로 나누거나 2. 1을 빼거나 둘 중 하나의 연산을 통해 (K는 2이상 ) 
 * 1을 만들 수 있는 최소한의 연산횟수 
 */
public class Sol1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		
		int N = Integer.parseInt(inputs[0]);
		int K = Integer.parseInt(inputs[1]);
		
		int cnt = 0;
		// N이 K보다 크다면, 반복 
		// 딱 떨어지는 수까지 뺄셈 ... 한번에 
		// 그 다음에 나눗셈 진행, 반
		while(N >= K) {
			int target = K * (N/K);
			cnt += (N-target);
			
			N = target / K;
			cnt++;
		}
		
		// 이제 더이상 나눗셈 불가 => 1까지는 뺄셈으로 
		cnt += (N-1);
		System.out.println(cnt);
	}
}

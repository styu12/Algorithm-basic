// bottom-up 방식 (반복문 활용)
//package dp;
//
//import java.io.*;
//
//public class fibonacci {
//	
//	public static long[] d = new long[101];
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(br.readLine());
//		
//		d[1] = 1;
//		d[2] = 1;
//		
//		for(int i=3; i<101; i++) {
//			d[i] = d[i-1] + d[i-2];
//		}
//		
//		System.out.println(d[n]);
//	}
//}


// top-down 방식 (재귀함수 활용) 
package dp;

import java.io.*;

public class fibonacci {
	
	public static long[] d = new long[101];
	
	public static long fibo(int x) {
		System.out.println("fibo(" + x +") ");
		if(x == 1 || x == 2) return 1;
		
		if(d[x] != 0) return d[x];
		
		d[x] = fibo(x-1) + fibo(x-2);
		return d[x];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(fibo(n));
	}
}

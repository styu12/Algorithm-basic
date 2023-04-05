package recursive;

import java.io.*;

public class GCD {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		
		int A = Integer.parseInt(inputs[0]);
		int B = Integer.parseInt(inputs[1]);
		
		System.out.println(gcd(A, B));
	}
	
	private static int gcd(int a, int b) {
		if(a % b == 0) return b;
		else {
			return gcd(b, a%b);
		}
	}
}

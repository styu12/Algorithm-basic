/*
 * 알파벳 대문자와 숫자(0~9)로 이루어진 문자열이 주어진다.
 * 모든 알파벳을 오름차순으로 정렬하여 출력한 뒤애, 그 뒤에 모든 숫자를 더한 값을 이어서 출력
 * input 					output
 * K1KA5CB7					ABCKK13
 * AJKDLSI412K4JSJ9D		ADDIJJJKKLSS20
 */

package implementation;

import java.io.*;
import java.util.*;

public class Sol4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		
		// 알파벳 담을 arraylist, 숫자 합 담을 변수 sum 준비 
		ArrayList<Character> alphas = new ArrayList<>();
		int sum = 0;
		
		// 알파벳이면 알파벳 배열에, 숫자면 숫자 배열에 넣기 
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(ch >= 'A' && ch <= 'Z') alphas.add(ch);
			else sum += ch-'0';
		}
		
		// 알파벳 아스키코드 순서로 오름차순 정렬 
		Collections.sort(alphas);
		
		// 알파벳 배열 돌면서 문자열 생성  
		for(int i=0; i<alphas.size(); i++) sb.append(alphas.get(i));
		
		// 마지막으로 합 문자열에 합치고 출력
		// 숫자가 없는 예외상황 처리 
		if(sum != 0) sb.append(sum);
		System.out.println(sb.toString());
	}

}

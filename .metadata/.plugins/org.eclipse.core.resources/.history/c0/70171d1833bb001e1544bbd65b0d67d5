package code_review;

import java.util.Arrays;

/*
	public static native void arraycopy
    	(Object src, int srcPos, Object dest, int destPos, int length);

	Object src  -> 복사하려는 배열
	int srcPos  -> 복사하려는 시작 인덱스
	Object dest -> 복사받으려는 배열 (붙여넣으려는)
	int destPos -> 복사받으려는 시작 인덱스 (붙여넣으려는)
	int length  -> 복사하려는 갯수

만약, srcPox + length 가 src.length 보다 크거나 destPos + length 가 dest.length 보다 크다면 
IndexOutOfBoundsException 이 발생하며 복사는 실행되지 않는다.
 */

class charNum{
	char[] abe = {};
}

public class Code_review {
	
	public static void main(String[] args) {
		
		char[] abc = { 'A', 'B', 'C', 'D'};
		char[] num = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

		System.out.println(abc);  // ABCD
		System.out.println(num);  // 0123456789
		
		int[] a = {1,2,3,4};
		System.out.println(a); // 숫자로 넣으면 메모리주소로 출력된다  / [I@58ceff1

		char[] result = new char[abc.length+num.length];
		
		int resultIndex = 2;
		for(int i=0; i<abc.length; i++) {
			result[resultIndex++] = abc[i];
		} 
		System.out.println(Arrays.toString(result)); // [  ,  , A, B, C, ,, , ]
		
		//    abc 0번째부터 result 0번째에 abc 길이만큼
		//    == result 배열에 abc 배열 전체를 다 넣어라
		System.arraycopy(abc, 0, result, 0, abc.length);
		
		//    num 0번째부터 result abc 길이에(result[4]에) num 길이만큼
		System.arraycopy(num, 0, result, abc.length, num.length);
		System.out.println(result);  // ABCD0123456789

		System.arraycopy(abc, 0, num, 0, abc.length);	
		System.out.println(num); // ABCD456789

		System.arraycopy(abc, 0, num, 6, 3);
		System.out.println(num);  // ABCD45ABC9
	}
}

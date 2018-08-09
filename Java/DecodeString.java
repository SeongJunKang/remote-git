
/*
Q .
Given an encoded string, return its corresponding decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is repeated exactly k times. Note: k is guaranteed to be a positive integer.

Note that your solution should have linear complexity because this is what you will be asked during an interview.

Example

For s = "4[ab]", the output should be
decodeString(s) = "abababab";

For s = "2[b3[a]]", the output should be
decodeString(s) = "baaabaaa";

For s = "z1[y]zzz2[abc]", the output should be
decodeString(s) = "zyzzzabcabc".

Input/Output

[execution time limit] 3 seconds (java)

[input] string s

A string encoded as described above. It is guaranteed that:

the string consists only of digits, square brackets and lowercase English letters;
the square brackets form a regular bracket sequence;
all digits that appear in the string represent the number of times the content in the brackets that follow them repeats, i.e. k in the description above;
there are at most 20 pairs of square brackets in the given string.
Guaranteed constraints:
0 ≤ s.length ≤ 80.

[output] string

TEST 
Test 1
Input: 
s: 4[ab]
Output:
Run the code to see output
Expected Output:
"abababab"
Console Output:
Empty

Test2
Input:
s : 2[b3[a]]
Output:
Run the code to see output
Expected Output:
"baaabaaa"
Console Output:
Empty

Test 3
Input:
s: z1[y]zzz2[abc]
Output:
Run the code to see output
Expected Output:
"zyzzzabcabc"
Console Output:
Empty

Test 4
Input:
s: 100[codesignal]
Output:
Run the code to see output
Expected Output:
"codesignal" * 100
Console Output:
Empty
*/
public class DecodeString {
	
	public static void main(String[] args) {
		decodeString("100[codesignal]");
	}
	
	/* answer */
	String decodeString(String s) {
		String rtn = s;
		Pattern p = Pattern.compile("(\\d{1,4}\\[)(\\w*?)(\\])");
		Matcher m = p.matcher(s);
		boolean a = false;
		while(a = m.find()) {
			String mat = m.group(0);
			int count = Integer.parseInt(mat.split("\\[")[0]);
			String str = mat.split("\\[")[1].replace("]", "");
			String replace = "";
			for(int i = 0; i < count ; i++) {
				replace += str;
			}
			rtn =rtn.replace(mat, replace);
		}
		if(rtn.contains("[")) {
			rtn = decodeString(rtn);
		}
		return rtn;
	}
}

package ksj.codesignal;
/*
Q.Given the string, check if it is a palindrome.

Example

For inputString = "aabaa", the output should be
checkPalindrome(inputString) = true;
For inputString = "abac", the output should be
checkPalindrome(inputString) = false;
For inputString = "a", the output should be
checkPalindrome(inputString) = true.
Input/Output

[execution time limit] 3 seconds (java)

[input] string inputString

A non-empty string consisting of lowercase characters.

Guaranteed constraints:
1 ≤ inputString.length ≤ 105.

[output] boolean

true if inputString is a palindrome, false otherwise.

Test 1
Input:
inputString: "aabaa"
Output:
Run the code to see output
Expected Output:
true
Console Output:
Empty

Test 2
Input:
inputString: "abac"
Output:
Run the code to see output
Expected Output:
false
Console Output:
Empty

Test 3
Input:
inputString: "a"
Output:
Run the code to see output
Expected Output:
true
Console Output:
Empty

Test 4
Input:
inputString: "az"
Output:
Run the code to see output
Expected Output:
false
Console Output:
Empty
 */

public class CheckPalindrome {

    public static void main(String[] args) {
        checkPalindrome("abccba");
    }

    static boolean checkPalindrome(String inputString) {
        String end = "";
        String start = inputString.substring(0,inputString.length()/2);
        for(int i = start.length() ; i > 0 ; i--) {
            end += start.substring(i-1,i);
        }
        if(end.equals(inputString.substring(inputString.length() - inputString.length()/2)))
            return true;
        else
            return false;
    }

}

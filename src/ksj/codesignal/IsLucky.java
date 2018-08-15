package ksj.codesignal;

/**
 * Ticket numbers usually consist of an even number of digits. A ticket number is considered lucky if the sum of the first half of the digits is equal to the sum of the second half.
 *
 * Given a ticket number n, determine if it's lucky or not.
 *
 * Example
 *
 * For n = 1230, the output should be
 * isLucky(n) = true;
 * For n = 239017, the output should be
 * isLucky(n) = false.
 * Input/Output
 *
 * [execution time limit] 3 seconds (java)
 *
 * [input] integer n
 *
 * A ticket number represented as a positive integer with an even number of digits.
 *
 * Guaranteed constraints:
 * 10 ≤ n < 106.
 *
 * [output] boolean
 *
 * true if n is a lucky ticket number, false otherwise.
 */
public class IsLucky {

    public static void main(String[] args) {
        isLucky(1230);
    }

    static boolean isLucky(int n) {
        String s = n+"";
        int frontInt = 0;
        int backInt = 0;
        for(int i = 0; i < s.substring(0,s.length()/2).length() ; i++) {
            frontInt += Integer.parseInt(s.substring(0,s.length()/2).substring(i,i+1));
            backInt += Integer.parseInt(s.substring(s.length()/2, s.length()).substring(i,i+1));
        }

        return frontInt == backInt ? true:false;
    }


}

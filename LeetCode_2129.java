/*
2129. Capitalize the Title

You are given a string title consisting of one or more words separated by a single space, where each word consists of English letters. Capitalize the string by changing the capitalization of each word such that:

If the length of the word is 1 or 2 letters, change all letters to lowercase.
Otherwise, change the first letter to uppercase and the remaining letters to lowercase.
Return the capitalized title.

 

Example 1:

Input: title = "capiTalIze tHe titLe"
Output: "Capitalize The Title"
Explanation:
Since all the words have a length of at least 3, the first letter of each word is uppercase, and the remaining letters are lowercase.
Example 2:

Input: title = "First leTTeR of EACH Word"
Output: "First Letter of Each Word"
Explanation:
The word "of" has length 2, so it is all lowercase.
The remaining words have a length of at least 3, so the first letter of each remaining word is uppercase, and the remaining letters are lowercase.
Example 3:

Input: title = "i lOve leetcode"
Output: "i Love Leetcode"
Explanation:
The word "i" has length 1, so it is lowercase.
The remaining words have a length of at least 3, so the first letter of each remaining word is uppercase, and the remaining letters are lowercase.
 

Constraints:

1 <= title.length <= 100
title consists of words separated by a single space without any leading or trailing spaces.
Each word consists of uppercase and lowercase English letters and is non-empty.
*/

class Solution {
    public String capitalizeTitle(String title) {
        StringBuilder st = new StringBuilder(title);

        for(int i = 0 ; i < st.length() ; i++){
            if(i == 0 || st.charAt(i-1) == ' '){
                if(lenG2(st , i)){
                    toUpperCase(st, i);
                }
                else{
                    toLowerCase(st, i);
                }
            }
            else{
                toLowerCase(st, i);
            }
        }
        return st.toString();
    }

    void toLowerCase(StringBuilder s, int in){
        int ch = (int)s.charAt(in);
        if(ch >= 65 && ch <= 90){
            ch += 32;
        }
        s.setCharAt(in, (char)ch);
    }

    void toUpperCase(StringBuilder s, int in){
        int ch = (int)s.charAt(in);
        if(ch >= 97 && ch <= 122){
            ch -= 32;
        }
        s.setCharAt(in, (char)ch);
    }

    boolean lenG2(StringBuilder s, int i){
        int len = s.length();
        if(i+1 <= len){
            if(i+1 == len || s.charAt(i+1) == ' '){
                return false;
            }
        }

        if(i+2 <= len){
            if(i+2 == len || s.charAt(i+2) == ' '){
                return false;
            }
        }
        return true;
    }
}

/*
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.

Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.
 

Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length
*/

class Solution {
    // TC: O(n)
    // SC: O(26) ~ O(1)
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];//to store frequency of all characters for a subtring
        int n = s.length();//len
        int maxFreq = 0;//maximum frequency
        int maxLen = 0;//answer
        int l = 0;//left pointer

        for(int r = 0; r < n; r++){//right pointer
            int currFreq = ++freq[s.charAt(r) - 'A'];//frequency of current character
            maxFreq = Math.max(maxFreq, currFreq);//highest frequency of any character
            while(((r-l+1) - maxFreq) > k){//move left pointer while other characters in substring are more than permitted
                freq[s.charAt(l)-'A']--;//reduce frequency
                l++;//more left pointer
            }
            maxLen = Math.max((r-l+1), maxLen);//maximum length updation 
        }
        return maxLen;//answer
    }
}

/*
Given a string s, find the length of the longest substring without duplicate characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 
Constraints:
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/

class Solution {
public:
    // TC: O(n)
    // SC: O(1)
    int lengthOfLongestSubstring(string s) {
        vector<int> freq(256,0);//faster than map
        int n = s.size();
        int ans = 0;

        int st = 0;//start of the substring
        for(int end = 0 ; end < n ; end++){//end of the substring
            freq[s[end]]++;//update substring[end] count

            while(freq[s[end]] > 1){
                //if the end element's count > 1
                //remove first index
                freq[s[st]]--;//reduce frequency of [st]
                st++;//remove [st]
            }
            ans = max(ans, end-st+1);//update answer
        }
        return ans;
    }
};

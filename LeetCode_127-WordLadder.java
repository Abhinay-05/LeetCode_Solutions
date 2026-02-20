/*
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

Example 1:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.

Example 2:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 
Constraints:
1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
*/

class Solution {
    // BFS
    // TC:O(N*L), L->length of word
    // SC:O(N)
    public int ladderLength(String bw, String ew, List<String> wl) {
//        if endWord does not exists then return 0
        boolean exists = false;
        HashMap<String, Integer> WL = new HashMap<>();
        for(String s : wl){
            if(s.equals(ew)){
                exists = true;
            }
            WL.put(s, 1);
        }
        if(!exists){
            return 0;
        }

        HashMap<String, Integer> visited = new HashMap<>();// to store visited strings in wordList
        Queue<String> q = new LinkedList<>();//Queue to store elements in order
//      add beginWord
        q.offer(bw);
        visited.put(bw, 1);
        int len = bw.length();//all words have same length

        int count = 1;//answer counter / step counter
        while(!q.isEmpty()){
            count++;
            int size = q.size();//size of current level
            for(int i = 0 ; i < size ; i++){
                String w = q.poll();//remove from Queue
                 
                for(int j = 0; j < len; j++){
                    for(char ch = 'a' ; ch <= 'z' ; ch++){
                        if(ch == w.charAt(j)){
                            continue;//same word 
                        }
                        StringBuilder temp = new StringBuilder(w);
                        temp.replace(j,j+1, String.valueOf(ch));//make changes
                        if(temp.toString().equals(ew)){//current string is the final answer
                            return count;//return asnwer
                        }
                        if(WL.containsKey(temp.toString()) && !visited.containsKey(temp.toString())){//word exists in wordList, but not in visited
                            q.offer(temp.toString());//add in Queue
                            visited.put(temp.toString(), 1);//mark in visited
                        }
                    }
                }
            }
        }
        return 0;
    }
}

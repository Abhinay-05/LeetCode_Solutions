/*
1773. Count Items Matching a Rule

You are given an array items, where each items[i] = [typei, colori, namei] describes the type, color, and name of the ith item. You are also given a rule represented by two strings, ruleKey and ruleValue.

The ith item is said to match the rule if one of the following is true:

ruleKey == "type" and ruleValue == typei.
ruleKey == "color" and ruleValue == colori.
ruleKey == "name" and ruleValue == namei.
Return the number of items that match the given rule.
*/

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans=0;
        if (ruleKey.equals("type")){
            for( int i=0 ; i<items.size() ; i++){
                if( items.get(i).get(0).equals(ruleValue)){
                    ans++;
                }
            }
        }
        else if (ruleKey.equals("color")){
            for( int i=0 ; i<items.size() ; i++){
                if( items.get(i).get(1).equals(ruleValue)){
                    ans++;
                }
            }
        }
        else {
            for( int i=0 ; i<items.size() ; i++){
                if( items.get(i).get(2).equals(ruleValue)){
                    ans++;
                }
            }
        }
        return ans;
    }
}

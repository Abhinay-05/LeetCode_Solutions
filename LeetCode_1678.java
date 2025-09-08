/*
1678. Goal Parser Interpretation

You own a Goal Parser that can interpret a string command. The command consists of an alphabet of "G", "()" and/or "(al)" in some order. The Goal Parser will interpret "G" as the string "G", "()" as the string "o", and "(al)" as the string "al". The interpreted strings are then concatenated in the original order.
Given the string command, return the Goal Parser's interpretation of command.
*/


class Solution {
    public String interpret(String command) {
        int l = command.length();
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while(i < l){
            if(command.charAt(i) == '('){
                if(command.charAt(i+1) == ')'){
                    ans.append('o');
                    i += 2;
                }
                else{
                    ans.append("al");
                    i += 4;
                }
            }
            else{
                ans.append(command.charAt(i));
                i++;
            }
        }
        return new String(ans);
    }
}

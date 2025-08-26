    public List<String> letterCombinations(String digits) {
        // edge case
        // if string is empty
        // return []
        if(digits.isEmpty()){
            List<String> list  = new ArrayList<>();
            return list;
        }
        // array of string to store alphabets
        String[] arr = {null,null ,"abc","def", "ghi","jkl","mno","pqrs" , "tuv", "wxyz" };
        return combination(digits,"",arr,"");
    }

    // s : input string
    // print : printable string
    // arr[] : stores alphabets of the particular number
    // curr : stores current alphabets
    List<String> combination(String s, String print, String[] arr, String curr){
        List<String> list  = new ArrayList<>();
        // add when inout string gets empty
        if(s.isEmpty()){
            list.add(print);
            return list;
        }

        // number at the index = 0 of the string
        // convert that string to int
        int number = Integer.parseInt(String.valueOf((s.charAt(0))));
        // stores current aplhabets
        curr = arr[number];

        for(int i = 0 ; i < curr.length() ; i++){
            // stores current character to be added to the string
            char ch = curr.charAt(i);
            // add all results of recusrion
            list.addAll(combination(s.substring(1),print+ch,arr,curr.substring(1)));
        }
        return list;
    }

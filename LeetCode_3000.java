int areaOfMaxDiagonal(int[][] dimensions) {
        int area = 0;
        double diagonal = 0;
        for(int[] arr : dimensions){
           double currD = Math.sqrt(Math.pow(arr[0],2) + Math.pow(arr[1],2));
           int currA = arr[0] * arr[1];
           if(currD > diagonal){
               area = currA;
               diagonal = currD;
           }
           if(currD == diagonal){
               area = (Math.max(area, currA));
           }
        }
        return area;
    }

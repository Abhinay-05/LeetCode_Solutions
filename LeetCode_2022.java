public int[][] construct2DArray(int[] original, int m, int n) {
            // check if the dimensions of both array and matrix
            // if array.length != matrix.length
            // return empty array
        if( (original.length) != (m*n))return new int[0][];

        // create a new 2Darray to store the matrix
        int[][] mat = new int[m][n];

        for( int k = 0 ; k < original.length ; k++ ){
            // i = k / column
            // j = k % column
            mat[k/n][k%n] = original[k];
        }
        return mat;
    }

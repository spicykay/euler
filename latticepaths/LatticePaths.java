package latticepaths;

import java.util.stream.IntStream;

public class LatticePaths {

    public static int findNumRoutes(int len, int width) {
        if((len < 0 || width < 0) || (len == 0 && width == 0)) return 0;
        // Initialize the memoization table
        int[][] memo = new int[len+1][width+1];
        memo[1][1] = 2;
        IntStream.range(2, len+1).forEach(row -> memo[row][1] = memo[row-1][1] +1);
        IntStream.range(2, width+1).forEach(col -> memo[1][col] = memo[1][col-1] + 1);

        for(int row = 2; row<memo.length; row++) {
            for(int col = 2; col<memo[row].length; col++) {
                memo[row][col] = memo[row-1][col] + memo[row][col-1];
            }
        }

        return memo[len][width];
    }
    public static void main(String[] args) {
        System.out.println(findNumRoutes(20, 20));
    }
}
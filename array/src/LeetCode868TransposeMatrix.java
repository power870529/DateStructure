
/**Given a matrix A, return the transpose of A.
 *
 * The transpose of a matrix is the matrix flipped over it's main diagonal,
 * switching the row and column indices of the matrix.
 *
 * Example 1:
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[1,4,7],[2,5,8],[3,6,9]]
 *
 * Example 2:
 * Input: [[1,2,3],[4,5,6]]
 * Output: [[1,4],[2,5],[3,6]]
 *
 * Note:
 * 1 <= A.length <= 1000
 * 1 <= A[0].length <= 1000
*/

public class LeetCode868TransposeMatrix {
    public static int[][] transpose(int[][] A) {

        int x = A[0].length;
        int y = A.length;
        int[][] ret = new int[x][y];

        for(int i = 0; i < x; i ++) {
            for(int j = 0; j < y; j ++) {
                ret[i][j] = A[j][i];
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2, 3}, {4, 5,6}};
        int[][] B = LeetCode868TransposeMatrix.transpose(A);
        for(int i = 0; i < B.length; i ++) {
            for(int j = 0; j < B[0].length; j ++) {
                System.out.print(B[i][j]);
            }
            System.out.println();
        }
    }
}

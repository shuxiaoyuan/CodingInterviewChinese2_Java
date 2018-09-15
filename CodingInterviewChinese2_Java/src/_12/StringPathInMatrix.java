package _12;


/**
 * 面试题12：矩阵中的路径 
 * P89
 */

public class StringPathInMatrix {

    public static void main(String[] args) {
        char[] matrix = {
            'a', 'b', 't', 'g',
            'c', 'f', 'c', 's',
            'j', 'd', 'e', 'h'
        };
        char[] str = {'b', 'f', 'c', 'e'};

        System.out.println(hasPath(matrix, 3, 4, str));
    }

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if(matrix == null || str == null ||
                rows <= 0 || cols <= 0 ||
                matrix.length == 0 || str.length == 0) {
            return false;
        }
        
        boolean[] visited = new boolean[rows * cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(hasPathCore(matrix, rows, cols, i, j,
                        0, str, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean hasPathCore(char[] matrix, int rows, int cols,
                int row, int col, int pathLength, char[] str, boolean[] visited) {
        if(pathLength == str.length) {
            return true;
        }
        boolean hasPath = false;
        if(row >= 0 && row < rows && col >= 0 && col < cols && 
                matrix[row * cols + col] == str[pathLength] && 
                        (!visited[row * cols + col])) {
            
            pathLength++;
            visited[row * cols + col] = true;
            hasPath = hasPathCore(matrix, rows, cols, row, col+1,
                                    pathLength, str, visited) ||
                      hasPathCore(matrix, rows, cols, row+1, col,
                                    pathLength, str, visited) ||
                      hasPathCore(matrix, rows, cols, row, col-1,
                              pathLength, str, visited) ||
                      hasPathCore(matrix, rows, cols, row-1, col,
                              pathLength, str, visited);
            
            if(!hasPath) {
                pathLength--;
                visited[row * cols + col] = false;
            }
            
        }
        return hasPath;
    }
    
}

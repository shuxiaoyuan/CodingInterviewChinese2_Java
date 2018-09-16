package _13;


/**
 * 面试题13：机器人的运动范围
 * P92
 */
public class RobotMove {

    public static void main(String[] args) {
        RobotMove robot = new RobotMove();
        System.out.println(robot.movingCount(18, 10, 10));
    }

    public int movingCount(int threshold, int rows, int cols) {
        if(threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        boolean[] visited = new boolean[rows * cols];
        int count = movingCountCore(threshold, rows, cols, 0, 0, visited);
        return count;
    }
    
    public int movingCountCore(int threshold, int rows, int cols,
                            int row, int col, boolean[] visited) {
        int count = 0;
        if(check(threshold, rows, cols, row, col, visited)) {
            visited[row * cols + col] = true;
            count = 1 + movingCountCore(threshold, rows, cols,
                                    row, col-1, visited)
                      + movingCountCore(threshold, rows, cols,
                              row-1, col, visited)
                      + movingCountCore(threshold, rows, cols,
                              row, col+1, visited)
                      + movingCountCore(threshold, rows, cols,
                              row+1, col, visited);
        }
        return count;
    }
    
    public boolean check(int threshold, int rows, int cols,
                    int row, int col, boolean[] visited) {
        if(row >= 0 && row < rows && col >= 0 && col < cols
                    && (getDigitSum(row) + getDigitSum(col)) <= threshold
                    && (!visited[row * cols + col])) {
            return true;
        }
        return false;
    }
    
    public int getDigitSum(int num) {
        int sum = 0;
        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    
}

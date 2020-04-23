package leetcode;

public class Solution_0999 {
    /**
     * https://leetcode-cn.com/problems/available-captures-for-rook/
     * @param board
     * @return
     */
    public int numRookCaptures(char[][] board) {
        XY rockXy = findRockXy(board);
        int result = 0;

        char[] temp = new char[8];
        for (int i = 0; i < board.length; i++) {
            temp[i] = board[rockXy.y][i];
        }

        result += findP(temp, rockXy.x);

        for (int i = 0; i < board.length; i++) {
            temp[i] = board[i][rockXy.x];
        }

        result += findP(temp, rockXy.y);
        return result;
    }

    private int findP(char[] temp, int index) {
        int result = 0;
        for (int i = index - 1; i >= 0; i--) {
            if (temp[i] == 'p') {
                result++;
                break;
            }
            if (temp[i] == 'B') {
                break;
            }
        }

        for (int i = index + 1; i < temp.length; i++) {
            if (temp[i] == 'p') {
                result++;
                break;
            }
            if (temp[i] == 'B') {
                break;
            }
        }

        return result;
    }

    private XY findRockXy(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R')
                    return new XY(j, i);
            }
        }
        return new XY(0,0);
    }

    static class XY {
        int x;
        int y;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[8][8];
//        board[0] = new char[]{'.','.','.','.','.','.','.','.'};
//        board[1] = new char[]{'.','.','.','p','.','.','.','.'};
//        board[2] = new char[]{'.','.','.','p','.','.','.','.'};
//        board[3] = new char[]{'p','p','.','R','.','p','B','.'};
//        board[4] = new char[]{'.','.','.','.','.','.','.','.'};
//        board[5] = new char[]{'.','.','.','B','.','.','.','.'};
//        board[6] = new char[]{'.','.','.','p','.','.','.','.'};
//        board[7] = new char[]{'.','.','.','.','.','.','.','.'};

        board[0] = new char[]{'.','.','.','.','.','.','.','.'};
        board[1] = new char[]{'.','.','.','p','.','.','.','.'};
        board[2] = new char[]{'.','.','.','R','.','.','.','p'};
        board[3] = new char[]{'.','.','.','.','.','.','.','.'};
        board[4] = new char[]{'.','.','.','.','.','.','.','.'};
        board[5] = new char[]{'.','.','.','p','.','.','.','.'};
        board[6] = new char[]{'.','.','.','.','.','.','.','.'};
        board[7] = new char[]{'.','.','.','.','.','.','.','.'};

        System.out.println(new Solution_0999().numRookCaptures(board));
    }
}

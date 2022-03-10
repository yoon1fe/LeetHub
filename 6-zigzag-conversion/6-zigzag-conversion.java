class Solution {
    public String convert(String s, int numRows) {
        StringBuilder answer = new StringBuilder();

        if (numRows == 1) {
            return s;
        }
        
        char[][] arry = new char[1000][numRows];
        for (int i = 0; i < 1000; i++) {
            Arrays.fill(arry[i], ' ');
        }

        int r = 0;
        int c = 0;
        boolean flag = true;

        for (int i = 0; i < s.length(); i++) {
            // 쭉
            if (flag) {
                arry[r][c++] = s.charAt(i);

                if (c == numRows) {
                    flag = false;
                    c--;
                }
            } else {
                arry[++r][--c] = s.charAt(i);
                if (c == 0) {
                    flag = true;
                    c++;
                }
            }
        }

        for (int j = 0; j < numRows; j++) {
            for (int i = 0; i < r + 1; i++) {
                if (arry[i][j] != ' ') {
                    answer.append(arry[i][j]);
                }
            }
        }
            
        return answer.toString();
    }
}
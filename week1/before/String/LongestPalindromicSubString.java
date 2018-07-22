public class Solution {
    public String longestPalindrome(String A) {
        int n = A.length();
        boolean[][] arr = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            arr[i][i] = true;
        }
        int beginIndex = 0;
        int lastIndex = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (A.charAt(i) != A.charAt(i+1)) {
                continue;
            }
            beginIndex = i;
            lastIndex = i + 1;
            arr[i][i+1] = true;
        }
        for (int size = 2; size < n; ++size) {
            boolean isGetTheIndexForThisSize = false;
            for (int i = 0; i < n - size; ++i) {
                if (A.charAt(i) != A.charAt(i+size)) {
                    continue;
                }
                int currentLastIndex = i + size;
                int oldLastIndex = currentLastIndex - 1;
                if (arr[i+1][oldLastIndex]) {
                    arr[i][currentLastIndex] = true;
                    if (!isGetTheIndexForThisSize) {
                        beginIndex = i;
                        lastIndex = i + size;
                        isGetTheIndexForThisSize = true;
                    }
                }
            }
        }
        return A.substring(beginIndex, lastIndex + 1);
    }
}

public class Solution {
    public int solve(String A) {
        int n = A.length() - 1;
        int result = A.length() % 2 == 0 ? -1 : 0;
        int paradromeLength = 0;
        for (int i = n; i >= 0; --i) {
            if (A.charAt(i) != A.charAt(0)) {
                continue;
            }
            int m = (i + 1) / 2;
            boolean isParadrome = true;
            for (int j = 0; j < m; ++j) {
                if (A.charAt(j) != A.charAt(i - j)) {
                    isParadrome = false;
                    break;
                }
            }
            if (isParadrome && i > paradromeLength) {
                paradromeLength = i;
            }
            if (paradromeLength >= i) {
                break;
            }
        }
        return n - paradromeLength;
    }
}

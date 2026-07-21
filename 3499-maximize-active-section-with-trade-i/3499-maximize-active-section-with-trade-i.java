class Solution {
    public int maxActiveSectionsAfterTrade(String s) {

        String t = "1" + s + "1";

        int ones = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }

        int ans = ones;
        int i = 0;

        while (i < t.length()) {

            char current = t.charAt(i);
            int count = 0;

            while (i < t.length() && t.charAt(i) == current) {
                count++;
                i++;
            }

            if (current == '1') {

                int left = i - count - 1;
                int right = i;

                int leftZero = 0;
                int rightZero = 0;
                while (left >= 0 && t.charAt(left) == '0') {
                    leftZero++;
                    left--;
                }
                while (right < t.length() && t.charAt(right) == '0') {
                    rightZero++;
                    right++;
                }

              
                if (leftZero > 0 && rightZero > 0) {
                    ans = Math.max(ans, ones + leftZero + rightZero);
                }
            }
        }

        return ans;
    }
}
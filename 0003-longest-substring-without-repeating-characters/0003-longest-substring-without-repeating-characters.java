class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0; 
        int[] lastPosition = new int[128];
        
        int left = 0;
        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            left = Math.max(left, lastPosition[currentChar]);
            maxLength = Math.max(maxLength, right - left + 1);
            lastPosition[currentChar] = right + 1;
        }
        return maxLength;
    }
}
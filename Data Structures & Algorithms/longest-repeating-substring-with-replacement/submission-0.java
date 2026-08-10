class Solution {
    private int findHighestFreq(int[] charFreq) {
        int max = 0;
        for (int i = 0; i < 26; i++) {
            if (charFreq[i] > max)
                max = charFreq[i];
        }

        return max;
    }
    public int characterReplacement(String s, int k) {
        int[] charFreq = new int[26];

        int left = 0, right = 0, length, highestFreq;

        int maxLength = 0;

        while (left <= right && right < s.length()) {
            length = right - left + 1;
            charFreq[s.charAt(right) - 'A']++;

            highestFreq = findHighestFreq(charFreq);

            while (length - highestFreq > k && left <= right) {
                charFreq[s.charAt(left) - 'A']--;
                left++;
                length--;
                highestFreq = findHighestFreq(charFreq);
            }

            if (length > maxLength)
                maxLength = length;
            right++;
        }
        return maxLength;
    }
}
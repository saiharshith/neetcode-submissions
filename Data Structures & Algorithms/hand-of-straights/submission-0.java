class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0) {
            return false;
        }

        int[] count = new int[1001];

        for (int card : hand) {
            count[card]++;
        }

        for (int i = 0; i < count.length; i++) {

            if (count[i] == 0) {
                continue;
            }

            int reference = count[i];

            for (int j = i; j < i + groupSize; j++) {

                if (j >= count.length || count[j] < reference) {
                    return false;
                }

                count[j] -= reference;
            }
        }

        return true;
    }
}
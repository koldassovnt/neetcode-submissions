class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        Set<Integer> numSet = new HashSet<>();

        for (int n : nums) {
            numSet.add(n);
        }

        int longest = 0;

        for (int n : numSet) {
            if (!numSet.contains(n - 1)) {
                int currCount = 1;
                int curr = n;

                while(numSet.contains(curr + 1)) {
                    curr++;
                    currCount++;
                }

                longest = Math.max(longest, currCount);
            }
        }

        return longest;
    }
}

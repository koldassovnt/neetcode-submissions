class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];

        int i = 0;
        int j = ans.length / 2;

        while (j < ans.length) {
            ans[i] = nums[i];
            ans[j] = nums[i];
            i++;
            j++;
        }

        return ans;
    }
}
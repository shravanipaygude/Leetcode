class Solution {
    public int missingInteger(int[] nums) {
        int i = 1;
        int sum = nums[0];
        while (i < nums.length && nums[i] == nums[i-1] + 1) {
            sum = sum + nums[i];
            i++;
        }
       Set<Integer> set = new HashSet<>();
       for (int num : nums) {
       set.add(num);
       }
       while (set.contains(sum)) {
       sum++;
       }
      return sum;
    }
}
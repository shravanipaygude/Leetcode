class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return ans;
    }

    private void backtrack(int[] nums, int start, List<Integer> current) {

        ans.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i + 1, current);
            current.remove(current.size() - 1);
        }
    }
}
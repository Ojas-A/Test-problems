class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> present = new HashMap();
        int first, second = 0;
        for (int i =0; i< nums.length; i++) {
            if (present.get(target - nums[i]) != null)
                return new int[]{present.get(target - nums[i]), i};
            present.put(nums[i], i);
        }
        return new int[]{0,0};
    }
}

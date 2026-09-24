class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i =0, j = 1;
        while (i < nums.length -1) {
            j = i +1;
            while(j < nums.length) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i,j};
                j++;    
            }
            i++;
        }
        return new int[]{i,j};
    }
}

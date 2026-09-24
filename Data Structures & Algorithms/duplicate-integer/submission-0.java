class Solution {
    public boolean hasDuplicate(int[] nums) {
       Map<Integer, Boolean> checkMap = new HashMap<>();
       int pointer = 0;
       while (pointer < nums.length) {
        if (checkMap.get(nums[pointer]) != null) {
            return true;
        }
        checkMap.put(nums[pointer], true);
        pointer++;
       }
       return false; 
    }
}
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int totalProduct = 1;
        int numOfZeros = 0;
        int zeroIndex = 0;
        for (int i =0; i<nums.length;i++) {
            if (nums[i] == 0) {
                numOfZeros++;
                if (numOfZeros > 1) {
                    return new int[nums.length];
                }
                zeroIndex = i;
            } else {
                totalProduct = totalProduct * nums[i];
            }   
        }
        int[] output = new int[nums.length];
        if (numOfZeros > 0) {
            output[zeroIndex] = totalProduct;
            return output;
        } else {
            for (int i =0; i<nums.length;i++) {
                output[i] = totalProduct / nums[i];
            }
        }
        return output;
    }
}  

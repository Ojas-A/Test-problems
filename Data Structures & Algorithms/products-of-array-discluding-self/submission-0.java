class Solution {
    public int[] productExceptSelf(int[] nums) {
        int totalProduct = 1, overflowProduct = 1;
        // overflow product is basically if any one number is too big and makes the prodict go over int limit - the question just says that the output array numbers are within 32bit, but not the total product 
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

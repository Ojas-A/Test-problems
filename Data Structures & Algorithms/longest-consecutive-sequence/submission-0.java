class Solution {
    public int longestConsecutive(int[] nums) {
        // Create a Map of all elements 
        // Pick entries and find the consecutive element -> count the lenght 

        Set<Integer> occurance = new HashSet<>();
        for (int i =0; i< nums.length; i++) {
            occurance.add(nums[i]);
        }

        // get entrySet, -> this is not ordered, so look for elemets in both directions.

        int[] elements = occurance.stream().mapToInt(Integer::intValue).toArray();
        int i = 0, maxLen = 0, currLen = 0, startNum = 0;
        while (i < elements.length) {
            if (!occurance.contains(elements[i])) {
                i++;
                continue;
            }
            // go in forward dirction
            int flen = 1;
            while(occurance.contains(elements[i] + flen)) {
                occurance.remove(elements[i] + flen);
                flen++;
            }

            // go in backward direction
            int blen = 1;
            while(occurance.contains(elements[i] - blen)) {
                occurance.remove(elements[i] - blen);
                blen++;
            }
            currLen = blen + flen -1;
            if (currLen > maxLen) {
                maxLen = currLen;
                startNum = elements[i] - blen +1;
            }
            i++;
        }

        // int[] ans = new int[maxLen];
        // for (int in = 0; in < maxLen; in++) {
        //     ans[in] = startNum + in;
        // }
        return maxLen;
    }
}

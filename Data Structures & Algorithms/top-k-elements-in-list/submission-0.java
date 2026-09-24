class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length)
            return nums;
        // - Create the occurance Map
        // - Pull first K values and create a MinHeap
        // - Pull subsequent items and only check the top element 
        Map<Integer, Integer> occurance = new HashMap<>();
        for (int i =0; i<nums.length; i++) {
            occurance.put(nums[i], occurance.getOrDefault(nums[i], 0) + 1);
        }

        Iterator<Map.Entry<Integer, Integer>> it = occurance.entrySet().iterator();
        int[][] topK = new int[k][2];
        for (int i=0;i<k;i++) {
            Map.Entry<Integer, Integer> record = it.next();
            topK[i][0] = record.getKey();
            topK[i][1] = record.getValue();
        }

        Arrays.sort(topK, (a, b) -> Integer.compare(a[1], b[1]));

        while(it.hasNext()) {
            Map.Entry<Integer, Integer> record = it.next();
            if (record.getValue() > topK[0][1]) {
                topK[0][1] = record.getValue();
                topK[0][0] = record.getKey();
                Arrays.sort(topK, (a, b) -> Integer.compare(a[1], b[1]));
            }
        }
        return Arrays.stream(topK)
                     .mapToInt(row -> row[0])
                     .toArray();
    }
}

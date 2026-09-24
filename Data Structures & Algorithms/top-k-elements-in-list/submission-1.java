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
        // Don't visualize a 2D array as a atrix, But rather a sequence of [ [1,2], [3,4], [5,6]   ]
        // This changes the perspective entirely, you can now use a 2D array as a tupe whenever you want more than 1 info in the comparision and in the data structure
        int[][] topK = new int[k][2];
        for (int i=0;i<k;i++) {
            Map.Entry<Integer, Integer> record = it.next();
            topK[i][0] = record.getKey();
            topK[i][1] = record.getValue();
        }
        // Sorting a 2D array with comparing only the 1st component.
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
